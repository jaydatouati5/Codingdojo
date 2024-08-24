const Author = require('../models/Authors.model');

module.exports.create = (req , res) => {
    Author.create(req.body)
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.getAll = (req , res) => {
    Author.find()
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.getOne = (req , res) => {
    Author.findOne({_id: req.params.id})
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.update = (req , res) => {
    Author.updateOne({_id: req.params.id} , req.body)
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.delete = (req , res) => {
    Author.deleteOne({_id: req.params.id})
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}