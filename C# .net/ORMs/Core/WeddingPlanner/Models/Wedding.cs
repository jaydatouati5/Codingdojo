#pragma warning disable CS8618
namespace WeddingPlanner.Models;

using System.ComponentModel.DataAnnotations;
using System.Security.Cryptography.X509Certificates;

public class Wedding 
{
    [Key]
    public int WeddingId { get; set; }
    [Required(ErrorMessage = "Wife is required")]
    public string Wife { get; set; }
    [Required(ErrorMessage = "Husband is required")]
    public string Husband { get; set; }
    [Required(ErrorMessage = "Date is required")]
    [FutureDate]
    public DateTime Date { get; set; }
    [Required(ErrorMessage = "Wedding Address is required")]
    public string Address { get; set; }
    [Required(ErrorMessage = "UserID is required")]
    public int UserID { get; set; }
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;
    public User? Creator { get; set; }

    public List<RSVP> Attendees { get; set; } = new List<RSVP>();
}

public class FutureDateAttribute : ValidationAttribute
{
    protected override ValidationResult IsValid(object? value, ValidationContext validationContext)
    {
        if (value is DateTime)
        {
            DateTime date = (DateTime)value;
            if (date < DateTime.Now)
            {
                return new ValidationResult("Date must be in the future.");
            }
            return ValidationResult.Success!;
        }
        return new ValidationResult("Invalid Date.");

    }
}

