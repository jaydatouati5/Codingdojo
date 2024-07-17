import react from 'react';
import styles from './Main.module.css'
import SubContent from '../SubContent/SubContent';
import Advertisement from '../Advertisements/Advertisement';

const Main = (props) => {
    return (
        <div className={styles.main}>
            <div className={styles.sub}>
                {props.children}
            </div>
            <Advertisement />
        </div>
    )
};


export default Main;