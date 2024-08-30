import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const StartChatting = () => {
    const [name , setName] = useState("")
    const [roomId , setRoomId] = useState('');
    const navigate = useNavigate();
    const handleClick = (e) => {
        localStorage.setItem('name' , name);
        navigate(`/chatroom/${roomId}`);
    }
    return (
        <div className='d-flex justify-content-center'>
            <div className='card p-3 w-50'>
                <h4>Get Started Right Now!</h4>
                <div className='d-flex flex-column align-items-center'>
                    <label htmlFor="name">I want to start chatting with the name ..</label>
                    <div className='d-flex w-50 justify-content-center gap-3 align-items-center'>
                        <input type="text" placeholder='My name..' id='name' className='form-control w-50' onChange={(e) => setName(e.target.value)}/>
                        
                        <button disabled={((name == "") || (roomId == ""))} className='btn btn-success' onClick={handleClick} >Start Chatting</button>
                    </div>
                    <label htmlFor="roomId">Choose Room ID</label>
                    <div className='d-flex w-50 justify-content-center gap-3 align-items-center'>
                        <select id="roomId" onChange={(e) => setRoomId(e.target.value)} className='form-control w-50'>
                            <option disabled selected>Choose Room</option>
                            <option value="id_1">id_1</option>
                            <option value="id_2">id_2</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default StartChatting