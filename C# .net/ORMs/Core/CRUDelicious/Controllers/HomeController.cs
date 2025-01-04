using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using CRUDelicious.Models;
using Microsoft.EntityFrameworkCore.Metadata.Internal;

namespace CRUDelicious.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    private MyContext _context;

    public HomeController(ILogger<HomeController> logger , MyContext context)
    {
        _logger = logger;

        _context = context;
    }

    public IActionResult Index()
    {
        List<Dish> dishes = _context.Dishes.OrderBy(d => d.CreatedAt).ToList();
        return View(dishes);
    }

    [HttpGet("dishes/new")]
    public IActionResult CreateDish()
    {
        return View();
    }

    [HttpPost("dishes/create")]
    public IActionResult CDish(Dish dish)
    {
        if(ModelState.IsValid)
        {
            _context.Add(dish);
            _context.SaveChanges();
            return RedirectToAction("Index");
        }
        else
        {
            return View("CreateDish" , dish);
        }
    }

    [HttpGet("dishes/{DishId}")]
    public IActionResult ViewDish(int DishId)
    {
        Dish? dish = _context.Dishes.FirstOrDefault(d => d.DishId == DishId);
        if (dish != null)
        {
            return View(dish);
        }
        else
        {
            return RedirectToAction("Index");
        }
    }

    [HttpPost("/dishes/{DishId}/delete")]
    public IActionResult DeleteDish(int DishId)
    {
        Dish? dish = _context.Dishes.SingleOrDefault(d => d.DishId == DishId);
        if(dish != null)
        {
            _context.Dishes.Remove(dish);
            _context.SaveChanges();
        }
        return RedirectToAction("Index");
    }

    [HttpGet("/dishes/{DishId}/edit")]
    public IActionResult EditDish(int DishId)
    {
        Dish? dish = _context.Dishes.FirstOrDefault(d => d.DishId == DishId);
        if (dish != null)
        {
            return View(dish);
        }
        return RedirectToAction("Index");
    }

    [HttpPost("/dishes/{DishId}/update")]
    public IActionResult UDish(int DishId , Dish dish)
    {
        Dish? oldDish = _context.Dishes.FirstOrDefault(d => d.DishId == DishId);
        if (ModelState.IsValid)
        {
            oldDish.Name = dish.Name;
            oldDish.Chef = dish.Chef;
            oldDish.Testiness = dish.Testiness;
            oldDish.Calories = dish.Calories;
            oldDish.Description = dish.Description;
            oldDish.UpdatedAt = DateTime.Now;

            _context.SaveChanges();
            return RedirectToAction("ViewDish" , new {DishId = DishId});
        }
        return View("EditDish" , dish);
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
