import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import AddTask from './components/AddTask';
import TasksList from './components/TasksList';

function App() {
  /*
    task = {
      content: "...",
      finished: true
    }
  */
  const [tasks , setTasks] = useState([]);

  const addTask = (task) => {
    const task_object = {content: task , done: false};

    setTasks([...tasks , task_object]);
  }

  const triggerTask = (index) => {
    let new_task = [...tasks];
    new_task[index].done =  !new_task[index].done;
    setTasks(new_task);
  }

  const deleteTask = (index) => {
    setTasks(tasks.filter((item , i) => index != i));
  }


  return (
    <div className="App w-50 container mt-3" >
      <AddTask addTask={addTask}/>
      <TasksList deleteTask={deleteTask} triggerTask={triggerTask} tasks={tasks}/>
    </div>
  );
}

export default App;
