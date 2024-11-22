class Enemy
{
    public string Name {get; set;}
    int _Health ;
    public int Health
    {
    get {return _Health;}
    set {_Health = value;}
    }
    public List<Attack> AttackList{get;}

    public Enemy(string name , int health = 100)
    {
        this.Name = name;
        this._Health = health;
        this.AttackList = new();
    }

    public Attack RandomAttack()
    {
        Random rand = new();
        int attackIndex = rand.Next(this.AttackList.Count);
        return AttackList[attackIndex];
    }

    public void AddAttack(Attack attack)
    {
        AttackList.Add(attack);
    }

    // Inside of the Enemy class
    public virtual void PerformAttack(Enemy Target, Attack ChosenAttack)
    {
        // Write some logic here to reduce the Targets health by your Attack's DamageAmount
        Target.Health -= ChosenAttack.DamageAmount;
        Console.WriteLine($"{Name} attacks {Target.Name}, dealing {ChosenAttack.DamageAmount} damage and reducing {Target.Name}'s health to {Target.Health}!!");
    }


}