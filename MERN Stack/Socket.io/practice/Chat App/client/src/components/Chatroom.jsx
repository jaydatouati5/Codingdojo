import React, { createRef, useEffect, useRef, useState } from 'react'
import { useParams } from 'react-router-dom';
import io from 'socket.io-client';
import Message from './Message';

const Chatroom = ( ) => {
    const endRoomRef = useRef(null);
    // alert("Component !");
    const [socket] = useState(() => io(":8000"));
    const [messages , setMessages] = useState([]);
    const [message , setMessage] = useState("");
    const {id} = useParams();

    useEffect(() => {
        endRoomRef.current?.lastElementChild?.scrollIntoView()
        // socket.on("test" , data => {
        //     alert(data)
        // })
        socket.on(`messages_${id}` , data => {
            console.log(data)
            setMessages(prev => {return data});
        })
        return () => {
            socket.off(`messages_${id}`);
        };
    } , [socket , messages])

    const inputContainerStyles = {
        position: "fixed",
        bottom: "10px",
        left: "0",
        right: "0",
        margin: "auto"
    }

    

    const handleClick = e => {
        socket.emit("send_message" , {chatroom_id: id,name: localStorage.getItem('name') , message: message})
        setMessage("");
    }

    return (
        <div className='m-auto w-75 d-flex align-items-center'>
            {/* <p>Name: {name}</p> */}
            {/* <p>RoomID: {id}</p> */}
            {/* <p>Messages:{JSON.stringify(messages)}</p> */}
            <div ref={endRoomRef} className='w-100 mb-5'>
                {messages.map((message , i) => <Message key={i} message={message} />)}
            </div>
            <div className='d-flex w-50 gap-4' style={inputContainerStyles}>
                <input type="text" className='form-control' onChange={e => setMessage(e.target.value)} value={message}/>
                <button className='btn btn-primary' onClick={handleClick}>Send</button>
            </div>
            <div ></div>
        </div>
    )
}

export default Chatroom