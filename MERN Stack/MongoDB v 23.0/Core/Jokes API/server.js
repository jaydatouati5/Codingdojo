const express = require('express');
const app = express();
require('dotenv').config();
require('./config/mongoose.config');
app.use( express.json() );
app.use( express.urlencoded({ extended: true }) );
const port = process.env.PORT;

const JokesRoutes = require('./routes/routes.joke');
JokesRoutes(app);








app.listen(port , () => console.log(`Server is running on port ${port}`));