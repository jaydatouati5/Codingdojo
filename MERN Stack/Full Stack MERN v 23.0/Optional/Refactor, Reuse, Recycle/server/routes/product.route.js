const productController = require('../controllers/product.controller');

module.exports = (app) => {
    app.get('/api/products' , productController.getAll);
    app.post('/api/products' , productController.create);
    app.get('/api/products/:id' , productController.getOne);
    app.patch('/api/products/:id' , productController.updateOne);
    app.delete('/api/products/:id' , productController.deleteOne);
}