using Microsoft.AspNetCore.Mvc;
using WeddingPlanner.Models;
using Microsoft.EntityFrameworkCore;

namespace WeddingPlanner.Controllers;


public class WeddingController : Controller
{
    private readonly ILogger<WeddingController> _logger;

    private MyContext _context;

    public WeddingController(ILogger<WeddingController> logger , MyContext context)
    {
        _logger = logger;
        _context = context;
    }

    [SessionCheck]
    [HttpGet("weddings")]
    public IActionResult Weddings()
    {
        User? user = _context.Users.FirstOrDefault(u => u.UserId == HttpContext.Session.GetInt32("UserId"));
        ViewBag.LoggedUser = user;
        List<Wedding> AllWeddings = _context.Weddings.Include(w => w.Attendees).ToList();
        return View(AllWeddings);
    }

    [SessionCheck]
    [HttpGet("weddings/new")]
    public IActionResult AddWedding()
    {
        User? user = _context.Users.FirstOrDefault(u => u.UserId == HttpContext.Session.GetInt32("UserId"));
        ViewBag.LoggedUser = user;
        return View();
    }

    [SessionCheck]
    [HttpPost("weddings/new")]
    public IActionResult CreateWedding(Wedding newWedding)
    {
        User? user = _context.Users.FirstOrDefault(u => u.UserId == HttpContext.Session.GetInt32("UserId"));
        if(ModelState.IsValid)
        {
            newWedding.UserID = user.UserId;
            _context.Weddings.Add(newWedding);
            _context.SaveChanges();
            return RedirectToAction("Weddings");
        }
        ViewBag.LoggedUser = user;
        return View("AddWedding");
    }

    [SessionCheck]
    [HttpPost("weddings/{WeddingId}/delete")]
    public IActionResult DeleteWedding(int weddingId)
    {
        Wedding? wedding = _context.Weddings.SingleOrDefault(w => w.WeddingId == weddingId);
        _context.Weddings.Remove(wedding);
        _context.SaveChanges();
        return RedirectToAction("Weddings");
    }

    // handle RSVP
    [SessionCheck]
    [HttpGet("weddings/{WeddingId}/rsvp")]
    public IActionResult RSVP(int weddingId)
    {
        User? user = _context.Users.FirstOrDefault(u => u.UserId == HttpContext.Session.GetInt32("UserId"));
        RSVP newRSVP = new RSVP
        {
            WeddingId = weddingId,
            UserId = user.UserId
        };
        _context.RSVPs.Add(newRSVP);
        _context.SaveChanges();
        return RedirectToAction("Weddings");
    }

    // handle Un-RSVP
    [SessionCheck]
    [HttpGet("weddings/{WeddingId}/un-rsvp")]
    public IActionResult UnRSVP(int weddingId)
    {
        User? user = _context.Users.SingleOrDefault(u => u.UserId == HttpContext.Session.GetInt32("UserId"));
        RSVP? rsvp = _context.RSVPs.SingleOrDefault(r => r.WeddingId == weddingId && r.UserId == user.UserId);
        _context.RSVPs.Remove(rsvp);
        _context.SaveChanges();
        return RedirectToAction("Weddings");
    }

    [SessionCheck]
    [HttpGet("weddings/{WeddingId}")]
    public IActionResult Wedding(int WeddingId)
    {
        User? user = _context.Users.FirstOrDefault(u => u.UserId == HttpContext.Session.GetInt32("UserId"));
        ViewBag.LoggedUser = user;
        Wedding? wedding = _context.Weddings
            .Include(w => w.Attendees)
            .ThenInclude(r => r.User)
            .FirstOrDefault(w => w.WeddingId == WeddingId);
        return View(wedding);
    }
}

