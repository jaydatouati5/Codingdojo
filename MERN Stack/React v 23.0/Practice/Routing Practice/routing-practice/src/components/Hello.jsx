import React from 'react'
import { useParams } from 'react-router-dom'

const Hello = () => {
  const {word} = useParams();

  return (
    <div>
      {
        isNaN(word) ? 
        <h2>This word is : {word}</h2>:
        <h2>This number is : {word}</h2>
      }
    </div>
  )
}

export default Hello