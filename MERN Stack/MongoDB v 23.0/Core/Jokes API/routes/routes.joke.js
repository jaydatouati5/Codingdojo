const JokesController = require('../controllers/controller.joke');

module.exports = (app) => {
    app.get('/api/jokes' , JokesController.findAllJokes);
    app.get('/api/jokes/:id' , JokesController.findOneById);
    app.patch('/api/jokes/:id' , JokesController.updateJoke);
    app.post('/api/jokes' , JokesController.createJoke);
    app.delete('/api/jokes/:id' , JokesController.deleteJoke);
}