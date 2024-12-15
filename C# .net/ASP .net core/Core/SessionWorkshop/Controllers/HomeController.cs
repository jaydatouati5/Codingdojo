using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using SessionWorkshop.Models;

namespace SessionWorkshop.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    public IActionResult Index()
    {
        HttpContext.Session.SetInt32("Score" , 0);
        return View();
    }

    [HttpPost("user")]
    public IActionResult RegisterUser(string Name)
    {
        HttpContext.Session.SetString("UserName" , Name);
        return RedirectToAction("Dashboard");
    }
    [HttpGet("dashboard")]
    public IActionResult Dashboard()
    {
        return View();
    }

    [HttpGet("logout")]
    public IActionResult logout()
    {
        HttpContext.Session.Clear();
        return RedirectToAction("Index");
    }

    [HttpGet("+1")]
    public IActionResult PlusOne()
    {
        int? score = HttpContext.Session.GetInt32("Score");
        HttpContext.Session.SetInt32("Score" , (int)score + 1);
        
        return RedirectToAction("Dashboard");
    }

    [HttpGet("-1")]
    public IActionResult MinusOne()
    {
        int? score = HttpContext.Session.GetInt32("Score");
        HttpContext.Session.SetInt32("Score" , (int)score - 1);
        
        return RedirectToAction("Dashboard");
    }

    [HttpGet("x2")]
    public IActionResult Double()
    {
        int? score = HttpContext.Session.GetInt32("Score");
        HttpContext.Session.SetInt32("Score" , (int)score * 2);
        
        return RedirectToAction("Dashboard");
    }

    [HttpGet("random")]
    public IActionResult Random()
    {
        Random rand = new Random();
        int? score = HttpContext.Session.GetInt32("Score");
        HttpContext.Session.SetInt32("Score" , (int)score + rand.Next(10) + 1);
        
        return RedirectToAction("Dashboard");
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
