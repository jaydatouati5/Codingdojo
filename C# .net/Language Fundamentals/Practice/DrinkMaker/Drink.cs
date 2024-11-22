class Drink 
{
    public string Name;
    public string Color;
    public double Temperature;
    public bool IsCarbonated;
    public int Calories ;

    public Drink(string name, string color, double temperature, bool isCarbonated, int calories){
        this.Name = name;
        this.Color = color;
        this.Temperature = temperature;
        this.IsCarbonated = isCarbonated;
        this.Calories = calories;
    }

    public virtual void ShowDrink()
    {
        Console.WriteLine($"Name {Name}");
        Console.WriteLine($"Color {Color}");
        Console.WriteLine($"Temperature {Temperature}");
        Console.WriteLine($"IsCarbonated {IsCarbonated}");
        Console.WriteLine($"Calories {Calories}");
    }
}