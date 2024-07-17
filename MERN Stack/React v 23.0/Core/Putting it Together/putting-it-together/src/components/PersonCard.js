import react,{useState} from "react";


const PersonCard = (props) => {
    const {firstName,lastName,age,hairColor} = props;
    const [birth, setBirth] = useState(age);
    const clickhandler = () =>{
        setBirth(birth +1)
    }
    
    return (
        <div>
            <h1>{firstName},{lastName}</h1>
            <p>Age : {birth}</p>
            <p>Hair Color : {hairColor}</p>
            <button onClick={clickhandler}>Birthday button for {firstName} {lastName}</button>
        </div>
    )
}



export default PersonCard;