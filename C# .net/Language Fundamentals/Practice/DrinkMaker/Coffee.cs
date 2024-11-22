class Coffee : Drink 
{
    public string Roast;
    public string Type;
    public Coffee(string roast, string type, string color,double tem, int calories) : base ("coffee", color, tem, false, calories)
    {
        this.Roast = roast ;
        this.Type= type ;
    }

    public override void ShowDrink()
    {
        base.ShowDrink();
        Console.WriteLine($"Roast {Roast}");
        Console.WriteLine($"Type : {Type}");
    }
}