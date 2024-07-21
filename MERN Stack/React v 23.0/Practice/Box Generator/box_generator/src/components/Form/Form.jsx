import react , { useState } from 'react';
import styles from './Form.module.css';

const Form = (props) => {
    const { setColors , colors } = props;
    const [ color , setColor ] = useState("");
    const [ size , setSize ] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();

        setColors([...colors , {color , size}]);
        setColor("");
    }

    return (
        <form className={styles.form} onSubmit={ handleSubmit }>
            <label htmlFor="color">Color</label>
            <input type="text" id='color' onChange={(e) => setColor(e.target.value)} value={color}/>
            <label htmlFor="Size">Size</label>
            <input type="number" id='Size' min={0} onChange={(e) => setSize(`${e.target.value}px`)}/>
            <button type="submit" className={styles.add}>Add</button>
            <button onClick={() => setColors([])} className={styles.reset}>Reset</button>
        </form>
    );
};

export default Form;