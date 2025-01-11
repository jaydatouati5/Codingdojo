using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ProductsAndCategories.Models;

namespace ProductsAndCategories.Controllers
{
    public class ProductsController : Controller
    {
        private readonly MyContext _context;

        public ProductsController(MyContext context)
        {
            _context = context;
        }

        [HttpGet("")]
        public IActionResult Index()
        {
            ViewBag.Products = _context.Products.ToList();
            return View();
        }

        [HttpPost("products/create")]
        public IActionResult Create(Product newProduct)
        {
            if (ModelState.IsValid)
            {
                _context.Products.Add(newProduct);
                _context.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Products = _context.Products.ToList();

            return View("Index" , newProduct);
        }

        [HttpGet("products/{id}")]
        public IActionResult Details(int id)
        {
            var product = _context.Products
                .Include(p => p.Associations)
                .ThenInclude(a => a.Category)
                .FirstOrDefault(p => p.ProductId == id);

            if (product == null)
            {
                return NotFound();
            }

            ViewBag.Categories = _context.Categories
                .AsEnumerable()
                .Where(c => !product.Associations.Any(a => a.CategoryId == c.CategoryId))
                .ToList();

            var association = new Association
            {
                Product = product,
                ProductId = product.ProductId
            };

            return View(association);
        }

        [HttpPost("products/{id}/addcategory")]
        public IActionResult AddCategory(int id, int categoryId)
        {
            var association = new Association
            {
                ProductId = id,
                CategoryId = categoryId
            };

            _context.Associations.Add(association);
            _context.SaveChanges();

            return RedirectToAction("Details", new { id });
        }

        [HttpPost("products/{id}/deletecategory")]
        public IActionResult DeleteCategory(int id, int categoryId)
        {
            var association = _context.Associations
                .FirstOrDefault(a => a.ProductId == id && a.CategoryId == categoryId);

            if (association != null)
            {
                _context.Associations.Remove(association);
                _context.SaveChanges();
            }

            return RedirectToAction("Details", new { id });
        }
    }
}
