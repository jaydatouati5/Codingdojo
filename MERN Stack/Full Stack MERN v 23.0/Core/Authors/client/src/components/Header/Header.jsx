import { Button } from '@mui/material';
import React, { useEffect, useState } from 'react'
import { Link, useLocation } from 'react-router-dom'

const Header = () => {

    const location = useLocation();
    const [linkData , setLinkData] = useState({});
    

    useEffect(() => {
        if (location.pathname == "/authors")
            setLinkData({to: '/authors/new' , content: "Add an author"});
        else
            setLinkData({to: '/authors' , content: "Home"});
    } , [location])

    const styles = {
        padding: '20px', 
        backgroundColor: '#BDA981', 
        display: 'flex', 
        justifyContent: 'center',
        flexDirection: 'column',
        alignItems: "center"
    }

    return (
        <div style={styles}>
            <h1>Favorite authors</h1>
            <Button variant='contained'><Link style={{color: "white"}} to={linkData.to}>{linkData.content}</Link></Button>
        </div>
    )
}

export default Header