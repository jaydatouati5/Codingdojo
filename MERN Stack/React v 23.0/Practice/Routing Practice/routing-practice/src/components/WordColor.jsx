import React from 'react'
import { useParams } from 'react-router-dom'

const WordColor = (props) => {
    const {hello,color,backgroundColor} = useParams();

    const st = 
    {
        color: color,
        backgroundColor: backgroundColor,
        height: "30px"
    }

  return (
    <div>
        <h3 style={st}>the word is : {hello}</h3>
    </div>
  )
}

export default WordColor