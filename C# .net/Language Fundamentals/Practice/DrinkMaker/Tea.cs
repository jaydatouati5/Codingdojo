class Tea : Drink
{
    public string Region;
    public int Year; 
    public Tea(string region, int year,string color, double temp, int calories) : base("tea", color, temp, false, calories)
    {
        this.Region = region;
        this.Year = year;
    }

    public override void ShowDrink()
    {
        base.ShowDrink();
        Console.WriteLine($"Region : {Region}");
        Console.WriteLine($"Year : {Year}");
    }
}