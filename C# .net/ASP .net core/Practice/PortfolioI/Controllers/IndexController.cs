using Microsoft.AspNetCore.Mvc;
namespace PortfolioI.controllers;
public class IndexController :Controller
{
    [HttpGet("")]
    public string index()
    {
        return "This is my Index !";
    }

    [HttpGet("projects")]
    public string projects()
    {
        return "This is my projects !";
    }

    [HttpGet("contact")]
    public string contact()
        {
            return "This is my contact!";
        }
}

