
class Soda : Drink
{
    public string Diet;
    public Soda(string diet , string color, double temperature, int calories) : base("soda", color, temperature, true, calories)
    {
        this.Diet = diet;  
    }

    public override void ShowDrink()
    {
        base.ShowDrink();
        Console.WriteLine($"Diet : {Diet}");
    }
}