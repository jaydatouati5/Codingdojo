const Joke = require('../models/model.joke');


// get all
module.exports.findAllJokes = (req , res) => 
    {
        Joke.find()
        .then(data => res.json(data))
        .catch(err => res.json(err));
    };

// get by id
module.exports.findOneById = (req , res) => 
    {
        Joke.findOne({_id: req.params.id})
        .then(data => res.json(data))
        .catch(err => res.json(err));
    };

// create
module.exports.createJoke = (req , res) => 
    {
        // ! Method 1
        const joke = new Joke(req.body);
        joke.save()
        .then(data => res.json(data))
        .catch(err => res.json(err));
        // ! Method 2
        // Joke.create(req.body)
        // .then(data => res.json(data))
        // .catch(err => res.json(err));
    };

// update
module.exports.updateJoke = (req , res) => 
    {
        Joke.updateOne({_id: req.params.id}, req.body)
        .then(data => res.json(data))
        .catch(err => res.json(err));
    };

// delete
module.exports.deleteJoke = (req, res) => 
    {
        Joke.deleteOne({_id: req.params.id})
        .then(data => res.json(data))
        .catch(err => res.json(err));
    };
