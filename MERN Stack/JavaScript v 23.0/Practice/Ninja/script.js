class Ninja{
    constructor(name){
        this.name = name;
        this.health = 90;
        this.speed =3;
        this.strength =3;
    }
    sayName(){
        console.log(`Hello ${this.name}`);
    }
    showStats(){
        console.log(`${this.name} ${this.health} ${this.speed} ${this.strength}`);
    }
    drinkSake(){
        this.health += 10;
    }
}


