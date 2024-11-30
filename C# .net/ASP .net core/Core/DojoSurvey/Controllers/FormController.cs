using Microsoft.AspNetCore.Mvc;

namespace DojoSurvey.Controllers;
public class FormController : Controller
{
    [HttpGet("")]
    public ViewResult index()
    {
        return View("Form");
    }

    [HttpPost("results")]
    public IActionResult Form(string name, string location, string favoritelanguage, string comment)
    {
        Console.WriteLine($"Name : {name}");
        Console.WriteLine($"Location : {location}");
        Console.WriteLine($"Favoritelanguage : {favoritelanguage}");
        Console.WriteLine($"Comment : {comment}");

        
        
        return RedirectToAction("Results" , new {name = name , location = location , favoritelanguage = favoritelanguage , comment = comment});
    }

    [HttpGet("results/{name}/{location}/{favoritelanguage}/{comment}")]
    public ViewResult Results(string name, string location, string favoritelanguage, string comment)
    {
        ViewBag.name = name;
        ViewBag.location = location;
        ViewBag.favoritelanguage = favoritelanguage;
        ViewBag.comment = comment;
        return View();
    }
}