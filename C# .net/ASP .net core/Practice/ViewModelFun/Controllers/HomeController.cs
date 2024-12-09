using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ViewModelFun.Models;

namespace ViewModelFun.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }


    [HttpGet("")]
    public IActionResult Index()
    {
        string message = "This is my first assignement in MVC II";
        return View("Index",message);
    }

    [HttpGet("numbers")]
    public IActionResult Numbers()
    {
        int[] arrayInt= {1,2,10,21,8,7,3,5};
        return View(arrayInt);
    }

    [HttpGet("user")]
    public IActionResult User()
    {
        User newuser = new User()
        {
            firstName = "Neil",
            lastName = "Gaiman"
        };
        return View(newuser);
    }

    [HttpGet("users")]
    public IActionResult Users()
    {
        List<User> users = new();
        users.Add(new User(){firstName="Neil" , lastName="Gaiman"});
        users.Add(new User(){firstName="Terry" , lastName="Tom"});
        users.Add(new User(){firstName="John" , lastName="Deep"});
        users.Add(new User(){firstName="Micheal" , lastName="Jackson"});
        users.Add(new User(){firstName="Jemmy" , lastName="Wellson"});
        return View(users);
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
