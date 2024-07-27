import react, { useState } from 'react'

const AddTask = ({addTask}) => {
    const [task , setTask] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();


        addTask(task)
        setTask("")
    }

    return (
        <form className='d-flex align-items-start flex-column gap-2' onSubmit={handleSubmit}>
            <input type="text" placeholder='Add Task' className='form-control' value={task}onChange={(e) => setTask(e.target.value)}/>
            <button type="submit" className='btn btn-primary w-50'>Add</button>
        </form>
    )
}

export default AddTask