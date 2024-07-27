import React from 'react'
import Task from './Task'

const TasksList = ({tasks , triggerTask , deleteTask}) => {
    return (
        <div className='d-flex flex-column align-items-start'>
            {tasks.map((item , index) => <Task index={index} deleteTask={deleteTask} triggerTask={triggerTask} content={item.content} done={item.done} />)}
        </div>
    )
}

export default TasksList