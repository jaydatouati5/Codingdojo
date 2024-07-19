import react, {useState} from 'react';
import styles from './Form.module.css';


const Form =(props)=>{
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    return(
        <div>
            <form className={styles.form}>
                <div className={styles.box}></div>

                <div  className={styles.input_container}>
                    <label htmlFor="firstName">First Name : </label>
                    <input type="text" name="firstName" value={firstName} onChange={(e)=>setFirstName(e.target.value)}/>
                </div>

                <div className={styles.input_container}>
                    <label htmlFor="lastName">Last Name : </label>
                    <input type="text" name="lastName" value={lastName} onChange={(e)=>setLastName(e.target.value)}/>
                </div>

                <div className={styles.input_container}>
                    <label htmlFor="email">Email : </label>
                    <input type="email" name="email" value={email} onChange={(e)=>setEmail(e.target.value)}/>
                </div>

                <div className={styles.input_container}>
                    <label htmlFor="password">Password : </label>
                    <input type="password" name="password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                </div>

                <div className={styles.input_container}>
                    <label htmlFor="confirmPassword">Confirm Password : </label>
                    <input type="password" name="confirmPassword" value={confirmPassword} onChange={(e)=>setConfirmPassword(e.target.value)}/>
                </div>

            </form>
            <div>
                <p>Your form data </p>
                <p>First Name :{firstName}</p>
                <p>Last Name : {lastName} </p>
                <p>Email : {email}</p>
                <p>Password : {password}</p>
                <p>Confirm password :{confirmPassword}</p>
            </div>
            
        </div>
        
    )
}


export default Form;
