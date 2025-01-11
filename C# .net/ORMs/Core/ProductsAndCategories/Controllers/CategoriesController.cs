using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ProductsAndCategories.Models;

namespace ProductsAndCategories.Controllers
{
    public class CategoriesController : Controller
    {
        private readonly MyContext _context;

        public CategoriesController(MyContext context)
        {
            _context = context;
        }

        [HttpGet("categories")]
        public IActionResult Index()
        {
            ViewBag.Categories = _context.Categories.ToList();
            return View();
        }

        [HttpPost("categories/create")]
        public IActionResult Create(Category newCategory)
        {
            if (ModelState.IsValid)
            {
                _context.Categories.Add(newCategory);
                _context.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Categories = _context.Categories.ToList();
            return View("Index" , newCategory);
        }

        [HttpGet("categories/{id}")]
        public IActionResult Details(int id)
        {
            var category = _context.Categories
                .Include(c => c.Associations)
                .ThenInclude(a => a.Product)
                .FirstOrDefault(c => c.CategoryId == id);

            if (category == null)
            {
                return NotFound();
            }

            ViewBag.Products = _context.Products
                .AsEnumerable()
                .Where(p => !category.Associations.Any(a => a.ProductId == p.ProductId))
                .ToList();

            var association = new Association
            {
                Category = category,
                CategoryId = category.CategoryId
            };

            return View(association);
        }

        [HttpPost("categories/{id}/addproduct")]
        public IActionResult AddProduct(int id, int productId)
        {
            var association = new Association
            {
                CategoryId = id,
                ProductId = productId
            };

            _context.Associations.Add(association);
            _context.SaveChanges();

            return RedirectToAction("Details", new { id });
        }

        [HttpPost("categories/{id}/deleteproduct")]
        public IActionResult DeleteProduct(int id, int productId)
        {
            var association = _context.Associations
                .FirstOrDefault(a => a.CategoryId == id && a.ProductId == productId);

            if (association != null)
            {
                _context.Associations.Remove(association);
                _context.SaveChanges();
            }

            return RedirectToAction("Details", new { id });
        }
    }
}
