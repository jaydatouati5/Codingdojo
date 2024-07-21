import React from 'react';
import styles from './Box.module.css';

const Box = (props) => {
    const { color } = props
    const style = {
        backgroundColor: color.color,
        width: color.size,
        height: color.size,
    }
    return (
        <div className={styles.box} style={style}>
            
        </div>
    )
}

export default Box;