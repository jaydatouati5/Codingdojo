const express = require("express");
const app = express();
const port = 8000;
const { faker } = require("@faker-js/faker");


const createUser = () => {
    const newUser = {
        _id: faker.database.mongodbObjectId(),
        firstName: faker.person.firstName(),
        lastName: faker.person.lastName(),
        email: faker.internet.email(),
        password: faker.internet.password(),
        phoneNumber: faker.phone.number()
    }

    return newUser;
}

const createCompany = () => {
    const newCompany = {
        _id: faker.database.mongodbObjectId(),
        name: faker.company.name(),
        address: {
            street: faker.location.street(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            country: faker.location.country()
        }
    }
    return newCompany;
}


app.get("/api/users/new" , (req,res)=> {
    res.json(createUser());
})


app.get("/api/companies/new",(req,res)=>{
    res.json(createCompany())
})

app.get("/api/user/company" , (req , res) => {
    res.json({
        user: createUser(),
        company: createCompany()
    })
})




app.listen(port , () => console.log(`Server is running on port ${port} ...`));