#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;

namespace ChefsAndDishes.Models
{
    public class Chef
    {
        [Key]
        public int ChefId { get; set; }
        
        [Required(ErrorMessage = "First name is required.")]
        public string FirstName { get; set; }

        [Required(ErrorMessage = "Last name is required.")]
        public string LastName { get; set; }

        [Required(ErrorMessage = "Date of birth is required.")]
        [DataType(DataType.Date)]
        [PastDate(ErrorMessage = "Date of birth must be in the past.")]
        [MinimumAge(18, ErrorMessage = "Chef must be at least 18 years old.")]
        public DateTime DateOfBirth { get; set; }

        public List<Dish> Dishes { get; set; } = new List<Dish>();
    }

    public class PastDateAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            if (value is DateTime dateTime)
            {
                if (dateTime < DateTime.Now)
                {
                    return ValidationResult.Success;
                }
                return new ValidationResult(ErrorMessage);
            }
            return new ValidationResult("Invalid date format.");
        }
    }

    public class MinimumAgeAttribute : ValidationAttribute
    {
        private readonly int _minimumAge;

        public MinimumAgeAttribute(int minimumAge)
        {
            _minimumAge = minimumAge;
        }

        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            if (value is DateTime dateTime)
            {
                var age = DateTime.Now.Year - dateTime.Year;
                if (dateTime > DateTime.Now.AddYears(-age)) 
                    age--;
                if (age >= _minimumAge)
                {
                    return ValidationResult.Success;
                }
                return new ValidationResult(ErrorMessage);
            }
            return new ValidationResult("Invalid date format.");
        }
    }
}

