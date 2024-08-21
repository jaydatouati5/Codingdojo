const Product = require('../models/product.model');

module.exports.getAll = (req , res) => {
    Product.find()
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.getOne = (req , res) => {
    Product.findOne({_id: req.params.id})
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.create = (req , res) => {
    Product.create(req.body)
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}

module.exports.updateOne = (req , res) => {
    Product.findOneAndUpdate({_id: req.params.id},req.body , {new: true})
    .then(data => res.json(data))
    .catch(err => res.status(400).json(data));
}

module.exports.deleteOne = (req , res) => {
    Product.deleteOne({_id: req.params.id })
    .then(data => res.json(data))
    .catch(err => res.status(400).json(err));
}
