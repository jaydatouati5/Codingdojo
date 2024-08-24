import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Button } from '@mui/material';

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useNavigate } from 'react-router-dom';

const AuthorList = () => {
    const [authors , setAuthors] = useState([]);

    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors')
        .then(res => {console.log(res.data);setAuthors(res.data)})
        .catch(err => console.error(err))
    } , [])

    const deleteAuthor = (id) => {
        console.log(id)
        axios.delete(`http://localhost:8000/api/authors/${id}`)
        .then(res => {
            setAuthors(authors.filter(author => author._id != id))
        })
        .catch(err => console.error(err))
    }

    

    return (
        <div>
            <Table>
                <TableHead>
                    <TableCell>Author</TableCell>
                    <TableCell>Actions available</TableCell>
                </TableHead>
                <TableBody>
                    {authors.map((author , index) => {
                        return (
                            <TableRow key={index}>
                            <TableCell>{author.name}</TableCell>
                            <TableCell>
                                <Button variant='outlined' onClick={(e) => navigate(`/authors/${author._id}/edit`)}>Edit</Button>
                                <Button variant='outlined' color='error' onClick={e => deleteAuthor(author._id)}>Delete</Button>
                            </TableCell>
                        </TableRow>
                        )
                    })}
                </TableBody>
            </Table>
        </div>
    )
}

export default AuthorList