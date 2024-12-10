using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using DojoSurveywithModel.Models;

namespace DojoSurveywithModel.Controllers;

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

        return View();
    }


    [HttpPost("results")]
    public IActionResult Results(Survey survey)
    {
        return View(survey);
    }


    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
