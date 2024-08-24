const authorController = require('../controllers/Author.controller');


module.exports = (app) => {
    app.get('/api/authors/:id' , authorController.getOne);
    app.get('/api/authors' , authorController.getAll);
    app.post('/api/authors' , authorController.create);
    app.patch('/api/authors/:id' , authorController.update);
    app.delete('/api/authors/:id' , authorController.delete);
}