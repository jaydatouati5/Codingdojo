class Horse : Vehicle , INeedFuel
{
    public Horse(string color , int number) : base("Horse" , number , color , false)
    {
        FuelType = "Hay";
        FuelTotal = 10;
    }
    public string FuelType { get; set; }
    public int FuelTotal { get; set; }


    public void GiveFuel(int Amount)
    {   
        this.FuelTotal += Amount;
    }
}