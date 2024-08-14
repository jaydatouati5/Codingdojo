const productController = require('../controllers/product.controller');

module.exports = (app) => {
    app.post('/api/products' , productController.create);
    app.get('/api/products' , productController.getAll);
    app.get('/api/products/:id' , productController.getOne);
}