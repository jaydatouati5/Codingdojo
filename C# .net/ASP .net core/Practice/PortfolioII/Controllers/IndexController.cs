using Microsoft.AspNetCore.Mvc;
namespace PortfolioI.controllers;
public class IndexController :Controller
{
    [HttpGet("")]
    public ViewResult Index()
    {
        return View();
    }

    [HttpGet("projects")]
    public ViewResult Projects()
    {
        return View();
    }

    [HttpGet("contact")]
    public ViewResult Contact()
        {
            return View();
        }
}

