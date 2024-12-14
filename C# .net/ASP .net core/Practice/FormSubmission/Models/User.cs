#pragma warning disable CS8618

namespace FormSubmission.Models;

using System.ComponentModel.DataAnnotations;


public class User
{
    [Required]
    [MinLength(2,ErrorMessage ="Name must be at least 2 characters long")]
    public string Name {get;set;}

    [Required]
    [EmailAddress(ErrorMessage ="Email Address must be a valid format.")]
    public string EmailAddress {get;set;}

    [Required]
    [BirthdayValidation]
    public DateTime Date {get;set;}

    [Required]
    [DataType(DataType.Password)]
    [MinLength(2,ErrorMessage ="Password must be at least 8 characters long.")]
    public string Password {get;set;}

    [Required]
    [OddNumbers]
    public int FavoriteOddNumber {get;set;}
}


public class BirthdayValidationAttribute : ValidationAttribute
{
protected override ValidationResult IsValid(object value, ValidationContext validationContext)
    {
        DateTime date = (DateTime)value;
        DateTime now = DateTime.Now;
        if (date > now)
        {
            return new ValidationResult("Error, birthday's can't be in the future.");
        } else {
            return ValidationResult.Success;
        }
    }
}

public class OddNumbersAttribute : ValidationAttribute
{
protected override ValidationResult IsValid(object value, ValidationContext validationContext)
    {
        if ((int)value % 2 == 0)
        {
            return new ValidationResult("Favorite Odd Number must be a whole odd number.");
        } else {
            return ValidationResult.Success;
        }
    }
}



