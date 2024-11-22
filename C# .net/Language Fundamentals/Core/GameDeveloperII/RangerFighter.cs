class RangedFighter : Enemy
{
    public double Distance {get; set;}

    public RangedFighter() : base("Ranged Fighter")
    {
        this.Distance = 5;
        base.AddAttack(new Attack("Arrow" , 20));
        base.AddAttack(new Attack("Knife" , 15));
    }

    public override void PerformAttack(Enemy Target, Attack ChosenAttack)
    {
        if (this.Distance >= 10)
            base.PerformAttack(Target, ChosenAttack);
        else
            Console.WriteLine("Too close to attack!");
    }

    public void Dash()
    {
        this.Distance = 20;
    }
}