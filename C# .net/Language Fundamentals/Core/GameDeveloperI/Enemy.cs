class Enemy
{
    string Name;
    int _Health ;
    public int Health
    {
    get {return _Health;}
    }
    public List<Attack> AttackList{get;}

    public Enemy(string name)
    {
        this.Name = name;
        this._Health = 100;
        this.AttackList = new();
    }

    public void RandomAttack()
    {
        Random rand = new();
        int attackIndex = rand.Next(this.AttackList.Count);
        Console.WriteLine(AttackList[attackIndex].Name);
    }

    public void AddAttack(Attack attack)
    {
        AttackList.Add(attack);
    }
}