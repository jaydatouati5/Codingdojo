import React, { useReducer } from 'react';

const Form = (props) => {
    const initialValue = 
    {
        first_name: {value: '',error: ''},
        last_name: {value: '',error: ''},
        email: {value: '', error: ''}
    };

    // action => {name: name_attribute_of_the_triggered_input , value: value_attribute_of_the_triggered_input}
    const reducer = (state , action) => {
        // first_name > 3
        // last_name > 4
        // email must be an email
        if (action.name == "first_name"){
            // Handle it
            if (action.value.length > 3){
                return {...state, first_name: {value: action.value ,error: ''}}
            }else{
                return {...state, first_name: {value: action.value ,error: 'First Name must be at least 3 characters.'}}
            }
        }
        else if(action.name == "last_name"){
            // handle it
            if (action.value.length > 4){
                return {...state, last_name: {value: action.value , error: ''}}
            }else{
                return {...state, last_name: {value: action.value ,error: 'Last Name must be at least 4 characters.'}}
            }
        }else {
            // handle it
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(action.value)){
                return {...state, email: {value: action.value ,error: ''}}
            }else{
                return {...state, email: {value: action.value ,error: 'Incorrect Email'}}
            }
        }
    }

    const [state , dispatch] = useReducer(reducer , initialValue);

    const handleChange = e => {
        const action = 
        {
            name: e.target.name,
            value: e.target.value
        }
        dispatch(action);
    }

    return (
        <fieldset>
            <legend>Form</legend>
            <form >
                <div>
                    <label htmlFor="first_name">First Name</label><br />
                    <input style={state.first_name.error ? {borderColor: 'red'} : {borderColor: 'green'}} type="text" name='first_name' id='first_name' onChange={handleChange}/>
                </div>

                <div>
                    <label htmlFor="last_name">Last Name</label><br />
                    <input style={state.last_name.error ? {borderColor: 'red'} : {borderColor: 'green'}} type="text" name='last_name' id='last_name' onChange={handleChange}/>
                </div>

                <div>
                    <label htmlFor="email">Email</label><br />
                    <input style={state.email.error ? {borderColor: 'red'} : {borderColor: 'green'}} type="email" name='email' id='email' onChange={handleChange}/>
                </div>

                <button type="submit">Submit</button>
                <br />
                {/* {JSON.stringify(state)} */}
            </form>
        </fieldset>
    )
}

export default Form;