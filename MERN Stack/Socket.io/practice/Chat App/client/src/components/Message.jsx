import React from 'react';
import styles from './Message.module.css';

const Message = ({message}) => {
    
    return (
        <div className={localStorage.getItem("name") == message.name ? styles.user : styles.other}>
            <div >
                <strong>{message.name}</strong>
                <p>{message.message}</p>
            </div>
        </div>
    )
}

export default Message