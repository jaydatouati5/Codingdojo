using Microsoft.AspNetCore.Mvc;
namespace RazoFun;
public class HomeController : Controller
{
    [HttpGet("")]
    public ViewResult Home()
    {
        return View("Home");
    }
}