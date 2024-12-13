#pragma warning disable CS8618
namespace DojoSurveywithValidations;
using System.ComponentModel.DataAnnotations;

public class Survey{
    [Required]
    [MinLength(2,ErrorMessage ="Name should be no less than 2 characters.")]
    public string Name {get;set;}
    [Required]
    public string DojoLocation {get;set;}
    [Required]
    public string FavoriteLanguage {get;set;}
    [MinLength(20,ErrorMessage ="Comment should be more than 20 characters.")]
    public string Comment {get;set;}
}