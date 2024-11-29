using System.Globalization;
using Microsoft.AspNetCore.Mvc;
namespace Countdown.Controllers;

public class Countdown : Controller 
{
    [HttpGet("")]
    public IActionResult index()
    {

        DateTime d_start = DateTime.Now;
        DateTime d_end = new DateTime(2025, 10 , 29);

        TimeSpan d_difference = d_end - d_start;

        string start = d_start.ToString("MMM dd, yyyy hh:mm tt",CultureInfo.InvariantCulture);
        string end = d_end.ToString("MMM dd, yyyy hh:mm tt" , CultureInfo.InvariantCulture);
        string difference = $"{d_difference.Days} Day(s), {d_difference.Hours} Hour(s), {d_difference.Minutes} Minute(s) Remaining";

        ViewBag.start = start;
        ViewBag.end = end;
        ViewBag.difference = difference;
        return View();
    }
}