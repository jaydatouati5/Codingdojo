using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ChefsAndDishes.Models;
using Microsoft.EntityFrameworkCore;

namespace ChefsAndDishes.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;
    private readonly MyContext _context;

    public HomeController(ILogger<HomeController> logger, MyContext context)
    {
        _logger = logger;
        _context = context;
    }

    public IActionResult Index()
    {
        List<Chef> chefs = _context.Chefs.Include(c => c.Dishes).ToList();
        return View(chefs);
    }

    [HttpGet("/chefs/new")]
    public IActionResult Add()
    {
        return View();
    }

    [HttpPost("/chefs/new")]
    public IActionResult Add(Chef chef)
    {
        if (ModelState.IsValid)
        {
            _context.Chefs.Add(chef);
            _context.SaveChanges();
            return RedirectToAction("Index");
        }
        return View(chef);
    }

    [HttpGet("/dishes")]
    public IActionResult Dishes()
    {
        List<Dish> dishes = _context.Dishes.Include(d => d.Chef).ToList();
        return View(dishes);
    }

    [HttpGet("/dishes/add")]
    public IActionResult AddDish()
    {
        ViewBag.Chefs = _context.Chefs.ToList();
        return View();
    }

    [HttpPost("/dishes/add")]
    public IActionResult AddDish(Dish dish)
    {
        if (ModelState.IsValid)
        {
            _context.Dishes.Add(dish);
            _context.SaveChanges();
            return RedirectToAction("Dishes");
        }
        ViewBag.Chefs = _context.Chefs.ToList();
        return View(dish);
    }

    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
