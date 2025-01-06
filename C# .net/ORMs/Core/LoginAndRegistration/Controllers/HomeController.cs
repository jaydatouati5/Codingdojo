using Microsoft.AspNetCore.Mvc;
using LoginAndRegistration.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Filters;
namespace LoginAndRegistration.Controllers;

public class HomeController : Controller
{
    private MyContext _context;

    public HomeController(MyContext context)
    {
        _context = context;
    }

    [HttpGet("")]
    public IActionResult Index()
    {
        return View();
    }

    [HttpPost("register")]
    public IActionResult Register(User newUser)
    {
        if (ModelState.IsValid)
        {
            // Check if email already exists
            if (_context.Users.Any(u => u.Email == newUser.Email))
            {
                ModelState.AddModelError("Email", "Email already in use!");
                return View("Index");
            }
            // Hash the password and save the user
            PasswordHasher<User> Hasher = new PasswordHasher<User>();
            newUser.Password = Hasher.HashPassword(newUser, newUser.Password);
            _context.Add(newUser);
            _context.SaveChanges();
            HttpContext.Session.SetInt32("UserId", newUser.UserId); // Set session
            return RedirectToAction("Success");
        }
        ViewBag.RegisterModel = newUser;
        ViewBag.LoginModel = new LoginUser();
        return View("Index");
    }

    [HttpPost("login")]
    public IActionResult Login(LoginUser loginUser)
    {
        if (ModelState.IsValid)
        {
            var userInDb = _context.Users.FirstOrDefault(u => u.Email == loginUser.LEmail);
            if (userInDb == null)
            {
                ModelState.AddModelError("Email", "Invalid Email/Password");
                return View("Index");
            }
            var hasher = new PasswordHasher<LoginUser>();
            var result = hasher.VerifyHashedPassword(loginUser, userInDb.Password, loginUser.LPassword);
            if (result == 0)
            {
                ModelState.AddModelError("Password", "Invalid Email/Password");
                return View("Index");
            }
            HttpContext.Session.SetInt32("UserId", userInDb.UserId); // Set session
            return RedirectToAction("Success");
        }
        ViewBag.RegisterModel = new User();
        ViewBag.LoginModel = loginUser;
        return View("Index");
    }

    [SessionCheck]
    [HttpGet("success")]
    public IActionResult Success()
    {
        return View();
    }

    [HttpGet("logout")]
    public IActionResult Logout()
    {
        HttpContext.Session.Clear(); // Clear session
        return RedirectToAction("Index");
    }
}


public class SessionCheckAttribute : ActionFilterAttribute
{
    public override void OnActionExecuting(ActionExecutingContext context)
    {
        int? userId = context.HttpContext.Session.GetInt32("UserId");
        
        if(userId == null)
        {

            context.Result = new RedirectToActionResult("Index", "Home", null);
        }
    }
}
