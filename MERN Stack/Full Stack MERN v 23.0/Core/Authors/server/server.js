// ! Initialize the dotenv process.
require('dotenv').config();

// ! All the imports.
// Import Express
const express = require('express');

// Import Cors
const cors = require('cors');

// Import Mongoose Config File
require('./config/mongoose.config');

// ! Initialize the express app
const app = express();

// ! App Config
app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.use(cors());

// ! Import and run all the routes
// Author Routes
require('./routes/Author.route')(app);

// ! Get port from .env
const port = process.env.PORT;

// ! Run the Server
app.listen(port, () => console.log(`Server Running On Port ${port} ♻`));

