const productController = require('../controllers/product.controller');

module.exports = (app) => {
    app.post('/api/products' , productController.create);
}