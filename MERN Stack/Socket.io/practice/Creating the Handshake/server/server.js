const express = require('express');
const app = express();

const server = app.listen(8000 , () => console.log("Server running!"));

const io = require('socket.io')(server , {cors: true});

io.on("connection", socket => {
    console.log("Nice to meet you. (shake hand)" , socket.id);
    socket.emit("Welcome" , "Welcome There!");
})