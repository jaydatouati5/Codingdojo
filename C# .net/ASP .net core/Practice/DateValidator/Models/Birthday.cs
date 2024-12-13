#pragma warning disable CS8618

namespace DateValidator.Models;

using System.ComponentModel.DataAnnotations;

public class Birthday 
{
    [FutureDate]
    public DateTime Date {get; set;}

}

public class FutureDateAttribute : ValidationAttribute
{    
    protected override ValidationResult IsValid(object value, ValidationContext validationContext)    
    {        
        // You first may want to unbox "value" here and cast to to a DateTime variable!  
        DateTime date = (DateTime)value;
        DateTime now = DateTime.Now;

        if (date > now)
        {
            return new ValidationResult("Error, birthday's can't be in the future.");
        }
        else
        {
            return ValidationResult.Success;
        }
    }
}

