# These are the steps I took
- use my_first_db
- db.createCollection("students")
- 
``` javascript
    {
        name: STRING, 
        home_state: STRING, 
        lucky_number: NUMBER, 
        birthday: 
            {
                month: NUMBER, 
                day: NUMBER, 
                year: NUMBER
            }
    }
```
- db.students.insertOne(
    {
        name:"jack" ,
        home_state:"California", 
        lucky_number: 5 ,
        birthday:
            {
                month: 05,
                day: 11,
                year: 1995
            }})
- db.students.insertOne(
    {
        name:"Maria" ,
        home_state:"Washington", 
        lucky_number: 27 ,
        birthday:
            {
                month: 08,
                day: 17,
                year: 2000
            }})
- db.students.insertOne(
    {
        name:"Diana" ,
        home_state:"New York", 
        lucky_number: 16 ,
        birthday:
            {
                month: 10,
                day: 29,
                year: 2002
            }})


- db.students.insertMany([{
    name:"John" ,
        home_state:"Toronto", 
        lucky_number: 66 ,
        birthday:
            {
                month: 02,
                day: 11,
                year: 2000
            }
} , {
    name:"Lucy" ,
        home_state:"Texas", 
        lucky_number: 76 ,
        birthday:
            {
                month: 04,
                day: 13,
                year: 1999
            }
}])
- db.students.find()
- db.students.find({$or: [{home_state: "California"} , {home_state: "Washington"} ]})
- db.students.find({lucky_number:{$gt:3}})
- db.students.updateMany({} , {$set: {interests: ["Coding" , "Brunch" , "MongoDB"]}})
- db.students.updateOne({_id: ObjectId("66b5e79de3208656551f491f")} , {$addToSet: {interests: "Chess"}})
- db.students.updateOne({_id:  ObjectId("66b5e65ee3208656551f491d")} , {$addToSet: {interests: "Dancing"}})
- db.students.updateOne({_id:  ObjectId("66b5e6ede3208656551f491e")} , {$addToSet: {interests: "Swimming"}})
- db.students.updateOne({_id:  ObjectId("66b5e89fe3208656551f4920")} , {$addToSet: {interests: "Reading"}})
- db.students.updateOne({_id: ObjectId("66b5e89fe3208656551f4921")} , {$addToSet: {interests: "Politics"}})
- db.students.updateOne({_id: ObjectId("66b5e89fe3208656551f4921")} , {$addToSet: {interests: "Taxes"}})
- db.students.updateOne({_id: ObjectId("66b5e89fe3208656551f4921")} , {$pull: {interests: "Taxes"}})
- db.students.deleteMany({home_state:"California"})
- db.students.deleteOne({name:"Lucy"})
- db.students.deleteOne({lucky_number:{$gt:5}})
- db.students.updateMany({} , {$set: {number_of_belts: 0}})
- db.students.updateMany({home_state: "Washington"} , {$inc:{number_of_belts:1}})
- db.students.updateMany({},{$currentDate:{updated_on:true}})





