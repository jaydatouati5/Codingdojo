#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;

namespace WeddingPlanner.Models;

public class LoginUser
{
    [Required(ErrorMessage = "Please enter your email address.")]
    [EmailAddress(ErrorMessage = "Please enter a valid email address.")]
    [Display(Name = "Email")]
    public string LEmail { get; set; }
    [Required(ErrorMessage = "Please enter your password.")]
    [Display(Name = "Password")]
    [DataType(DataType.Password)]
    public string LPassword { get; set; }
}