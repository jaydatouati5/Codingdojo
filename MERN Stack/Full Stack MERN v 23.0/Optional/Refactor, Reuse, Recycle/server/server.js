const express = require('express');
const app = express();
require('dotenv').config();
port = process.env.PORT;
const cors = require('cors');
require('./config/mongoose.config');

app.use(cors())
app.use(express.json());
app.use(express.urlencoded({extended: true}));

const productRoutes = require('./routes/product.route');
productRoutes(app);

app.listen(port , () => console.log(`App running on port ${port} ♻`));