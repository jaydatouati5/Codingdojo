//Example 1
console.log(hello);
var hello = 'world';
// var hello 
// console.log(hello);logs undefined
// var hello = 'world';
// -------------------------------------------------------------------------------

//Example 2
var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}
// var needle = 'haystack';
// test();
// var needle = 'magnet';
// console.log(needle);logs 'magnet'

// -------------------------------------------------------------------------------

//Example 3
var brendan ='super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
} 
console.log(brendan);

// var brendan ='super cool';
// console.log(brendan); logs 'super cool'

// -------------------------------------------------------------------------------

//Example 4
var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
// var food = 'chicken';
// console.log(food); logs 'chicken'
// eat();
// food = 'half-chicken';
// console.log(food);logs 'half-chicken'
// var food = 'gone'

// -------------------------------------------------------------------------------

//Example 4 version 2
var food = 'chicken';
eat();
console.log(food);
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
// var food = 'chicken';
// eat()
// food = 'half-chicken'
// console.log(food);logs 'half-chicken'
// var food = 'gone'
// console.log(food);logs 'half-chicken' 

// -------------------------------------------------------------------------------

//Example 5 confused about it 
mean();
console.log(food);
var mean = function() {
food = "chicken";
console.log(food);
var food = "fish";
console.log(food);
}
console.log(food);

// Error

// -------------------------------------------------------------------------------

// example 6
console.log(genre);
var genre = "disco";
rewind();
function rewind() {
    genre = "rock";
    console.log(genre);
    var genre = "r&b";
    console.log(genre);
}
console.log(genre);

// var genre 
// console.log(genre); logs 'undefined'
// genre = "disco"
// rewind()
// var genre = "r&b"
// genre = "rock"
// console.log(genre); logs "rock"
// console.log(genre); logs "r&b"
// console.log(genre); logs"disco"

// -------------------------------------------------------------------------------

//Example 7
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
dojo = "seattle";
console.log(dojo);
var dojo = "burbank";
console.log(dojo);
}
// dojo = "san jose";
// console.log(dojo); logs "san jose"
// learn();
// var dojo ;
// dojo = "seattle";
// console.log(dojo); logs "seattle"
// dojo = "burbank";
// console.log(dojo); logs "burbank"

// -------------------------------------------------------------------------------

// example 8 - Bonus ES6: const

console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students){
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if(dojo.students > 50){
        dojo.hiring = true;
    }
    else if(dojo.students <= 0){
        dojo = "closed for now";
    }
    return dojo;
}

// function makeDojo(name, students){
//     const dojo = {};
//     dojo.name = name;
//     dojo.students = students;
//     if(dojo.students > 50){
//         dojo.hiring = true;
//     }
//     else if(dojo.students <= 0){
//         dojo = "closed for now";
//     }
//     return dojo;
// }
// console.log(makeDojo("Chicago", 65));
// logs {name: "chicago" , students: 65 , hiring: true};
// console.log(makeDojo("Berkeley", 0));
// logs "closed for now"









