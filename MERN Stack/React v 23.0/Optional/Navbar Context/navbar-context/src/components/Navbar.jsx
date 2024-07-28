import React , {useContext} from 'react'
import MyContext from './conText'
import styles from './Navbar.module.css'

const Navbar = (props) => {
    const context = useContext(MyContext);

    return (
    <div className={styles.container}>
        <h3 className= {styles.text }>Hi {context.name}!</h3>
    </div>
    )
}

export default Navbar