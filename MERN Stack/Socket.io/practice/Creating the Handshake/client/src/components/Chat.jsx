import React, { useEffect, useState } from 'react'
import io from 'socket.io-client';


const Chat = () => {
    const [socket] = useState(() => io(":8000"));

    useEffect(() => {
        console.log("Is this running?")
        socket.on('Welcome' , data => console.log(data));
        return () => socket.removeAllListeners;
    },[socket])

    return (
        <div>Chat</div>
    )
}

export default Chat