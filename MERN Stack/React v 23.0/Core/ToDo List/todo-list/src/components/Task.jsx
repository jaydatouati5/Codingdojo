import React from 'react'
import styles from './Task.module.css'

const Task = ({content , done , index , triggerTask , deleteTask}) => {
    return (
        <div  className={styles.task}>
            <span>
                <input type="checkbox" name="" id="fstring" onChange={() => triggerTask(index)}/>
                <label htmlFor="fstring">
                    <span style={{textDecoration: done ? 'line-through' : 'none'}}>{content}</span>
                </label>
            </span>
            <button className='btn btn-danger' onClick={()=> deleteTask(index)} style={{float: "right"}}>Delete</button>
        </div>
    )
}

export default Task