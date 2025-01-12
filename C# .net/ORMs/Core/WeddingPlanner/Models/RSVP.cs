#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace WeddingPlanner.Models;

public class RSVP
{
    [Key]
    public int RSVPId { get; set; }
    [Required(ErrorMessage = "WeddingId is required")]
    public int WeddingId { get; set; }
    [Required(ErrorMessage = "UserId is required")]
    public int UserId { get; set; }
    public Wedding? Wedding { get; set; }
    public User? User { get; set; }
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;
}