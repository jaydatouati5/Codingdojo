#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;

namespace ChefsAndDishes.Models
{
    public class Dish
    {
        [Key]
        public int DishId { get; set; }
        
        [Required(ErrorMessage = "Name is required.")]
        public string Name { get; set; }

        [Required(ErrorMessage = "Calories are required.")]
        [Range(0, int.MaxValue, ErrorMessage = "Calories must be a non-negative number.")]
        public int Calories { get; set; }

        [Required(ErrorMessage = "Tastiness is required.")]
        [Range(1, 5, ErrorMessage = "Tastiness must be between 1 and 5.")]
        public int Tastiness { get; set; }

        [Required(ErrorMessage = "Chef is required.")]
        public int ChefId { get; set; }
        public Chef? Chef { get; set; }
    }
}
