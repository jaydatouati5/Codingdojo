using Microsoft.EntityFrameworkCore;
using ChefsAndDishes.Models;

namespace ChefsAndDishes.Models
{
    public class MyContext : DbContext
    {
        public MyContext(DbContextOptions<MyContext> options)
            : base(options)
        {}

        public DbSet<Chef> Chefs { get; set; }
        public DbSet<Dish> Dishes { get; set; }

        // ...existing code...
    }
}
