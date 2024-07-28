import react,{useState , useContext} from 'react';
import MyContext from './conText';
import styles from './Navbar.module.css'

const Form =(props) => {
    const context = useContext(MyContext);

    return(
        <form>
            <fieldset>
                <legend className={styles.form}>Form </legend>
            <label htmlFor="Name" className={styles.name}>Your Name :</label>
            <input type="text" id="Name" onChange={(e) => context.setName(e.target.value)}/>
            </fieldset>
        </form>
    )
}


export default Form;

