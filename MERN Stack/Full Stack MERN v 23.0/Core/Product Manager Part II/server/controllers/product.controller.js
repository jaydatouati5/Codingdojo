const Product = require('../models/product.model');


module.exports.create = (req , res) => {
    // ! Not so simple Method
    // const product = new Product(req.body);
    // product.save()
    // .then(data => res.json(data))
    // .catch(err => res.json(err));
    // ! Simple Method
    Product.create(req.body)
    .then(data => res.json(data))
    .catch(err => res.json(err));
}

module.exports.getAll = (req , res) => {
    Product.find()
    .then(data => res.json(data))
    .catch(err => res.json(err));
}

module.exports.getOne = (req , res) => {
    Product.findOne({_id: req.params.id})
    .then(data => res.json(data))
    .catch(err => res.json(err));
}
