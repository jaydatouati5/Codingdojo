const mongoose = require('mongoose');

const JokeSchema = new mongoose.Schema
(
    {
        setup: 
        {
            type: String,
            required: [true, "The {PATH} field is required."]
        },
        punchline: 
        {
            type: String,
            required: [true, "The {PATH} field is required."]
        }
    },
    {timestamps: true}
);

const Joke = mongoose.model('Joke' , JokeSchema);

module.exports = Joke;

