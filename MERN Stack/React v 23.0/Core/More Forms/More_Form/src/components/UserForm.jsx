import react , {useState} from 'react';

const UserForm = (props) => {
    const [firstName, setFirstName] = useState("");
    const [firstNameError, setFirstNameError] = useState("");
    const [lastName, setLastName] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");
    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [confirmPassword, setConfirmPassword ] = useState("");
    const [confirmPasswordError, setConfirmPasswordError] = useState("")

    /*
        ! Hadnleing Input Guide

        * States => 
        state => ""
        if we want to change the state we use the setter.
        if we want to get the state we use getter (state).
        
        * field state :
            const [field , setField] = useState(initial_value); 
            ? field => state : (variable) that contains the value.
            ? setField => setter : (function) that updates the state.
            
            * Example:
            const [username , setUsername] = useState("");
        * Error state :
            const [fieldError , setFieldError] => useState(intial_value);
            ? fieldError => state : (variable) that contains the value.
            ? setFieldError => setter : (function) that updates the state.

            * Example:
            const [usernameError , setUsernameError] = useState("");
        * Function structure =>
            ? e is the event
            ? e.target is the element on which the event happended
            ? e.target.value is the value inside the value attribute of the element (e.target)

            ? condition is checking if the value of the field is correct.

            ? error_message is the message we want to display if the condition is true (if the field is incorrect).

            const function_name = (e) => {   
                * update the state of the field with the value from the input(using state setter)
                setField(e.target.value); 

                * validate the field and set the error message (using state setter)
                condition ?
                setFieldError(error_message):
                setFieldError("");
            }
    */

    const handleFirstName = (e) => {
        setFirstName(e.target.value);
        
        e.target.value.length < 2 ?
        setFirstNameError("First Name must be at least 2 characters") : 
        setFirstNameError('');
    }

    const handleLastName = (e) => {
        setLastName(e.target.value);

        e.target.value.length <2 ?
        setLastNameError("Last Name must be at least 2 characters") :
        setLastNameError('');
    }

    const handleEmail = (e) => {
        setEmail(e.target.value);
        e.target.value.length < 5 ?
        setEmailError("Email must be at least 5 characters") :
        setEmailError("");
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
        e.target.value.length < 8 ?
        setPasswordError("Password must be at least 8 characters") :
        setPasswordError("")
    }

    const handleConfirmPassword =(e) => {
        setConfirmPassword(e.target.value)
        e.target.value != password ?
        setConfirmPasswordError("Confirm Password must match ") :
        setConfirmPasswordError("")
    }

    return( 
        <form >
            <div>

                <label htmlFor="FirstName">First Name :</label>
                <input type="text" id='FirstName' onChange={ handleFirstName } />
                <p>{ firstNameError }</p>

                <label htmlFor="LastName">Last Name :</label>
                <input type="text" id='LastName' onChange={handleLastName}/>
                <p>{ lastNameError}</p>


                <label htmlFor="Email">Email : </label>
                <input type="email" id='Email' onChange={ handleEmail }/>
                <p>{emailError}</p>

                <label htmlFor="Password">Password : </label>
                <input type="password" id='Password' onChange={handlePassword}/>
                <p>{ passwordError }</p>

                <label htmlFor="ConfirmPassword">Confirm Password : </label>
                <input type="password" id="ConfirmPassword" onChange={handleConfirmPassword}/>
                <p>{confirmPasswordError}</p>
            </div>
        </form>
    )
}




export default UserForm