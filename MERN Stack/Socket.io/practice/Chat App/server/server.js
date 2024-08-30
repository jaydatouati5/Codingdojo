const express = require('express');
const app = express();

const server = app.listen(8000 , () => console.log("Server running!"));

const io = require('socket.io')(server , {cors: true});

const chatrooms = 
{
    // key: id of chat room
    // value: a list of messages[]
    id_1: [],
    id_2: []
}

io.on("connection", socket => {
    socket.on("test" , data => {
        socket.broadcast.emit("test" , data);
    })

    socket.on('send_message' , data => {
        // data =>
            // chatroom id
            // name of the sender
            // message
        /*
            data = {chatroom_id: 'id_1' , name: "jayda" , message:"Hello everyone"}
        */
        console.log(data)
        chatrooms[data.chatroom_id].push({name: data.name , message: data.message})
        socket.broadcast.emit(`messages_${data.chatroom_id}` , chatrooms[data.chatroom_id])
        socket.emit(`messages_${data.chatroom_id}` , chatrooms[data.chatroom_id])
    })
    
    console.log("User Connected!" , socket.id)
})