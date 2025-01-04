#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace CRUDelicious.Models;

public class Dish
{
    [Key]
    public int DishId {get; set;}
    [Required(ErrorMessage = "Name is Required!")]
    public string Name {get; set;}
    [Required(ErrorMessage = "Chef is Required!")]
    public string Chef {get; set;}
    [Required(ErrorMessage = "Tastiness is Required!")]
    [Range(1 , 5 , ErrorMessage = "Testiness must be between than 1 and 5.")]
    public int Testiness {get; set;}
    [Required(ErrorMessage = "Calories is Required!")]
    [Range(1 , Int32.MaxValue , ErrorMessage = "Calories must be greater than 0.")]
    public int Calories {get; set;}
    [Required(ErrorMessage = "Description is Required!")]
    public string Description {get; set;}

    public DateTime CreatedAt {get; set;} = DateTime.Now;
    public DateTime UpdatedAt {get; set;} = DateTime.Now;
}