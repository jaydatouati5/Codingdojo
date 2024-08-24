const mongoose = require('mongoose');
const dbName = process.env.DB;
const username = process.env.ATLAS_USERNAME;
const password = process.env.ATLAS_PASSWORD;
const uri = `mongodb+srv://${username}:${password}@cluster0.q3uawxl.mongodb.net/${dbName}?retryWrites=true&w=majority&appName=Cluster0`

mongoose.connect(uri)
.then(() => console.log(`Established connection to the ${dbName} database! ✅`))
.catch(() => console.log(`Connection to the ${dbName} database failed! ❌`));