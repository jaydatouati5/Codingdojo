import react, {useState} from 'react';
import styles from './Tabs.module.css';

const Tabs = props => {
    const {arr} =props;
    const [content, setContent] = useState("");

    const handleClick = (e,item) => { 
        setContent(item.content);
    }

    return(
        <div className={styles.container}>
            <div className={styles.btn_container}>
                {arr.map(item => 
                <button className={styles.button} onClick={(e) => handleClick(e,item)}>{item.label}</button>
                )}
            </div>
            
            <p>{content}</p>
        </div>
    )
}
export default Tabs;