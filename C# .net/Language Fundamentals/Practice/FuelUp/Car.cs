class Car : Vehicle , INeedFuel
{
    public Car(string color , int number) : base("Car" , number , color , true)
    {
        FuelType = "Gas";
        FuelTotal = 10;
    }
    public string FuelType { get; set; }
    public int FuelTotal { get; set; }


    public void GiveFuel(int Amount)
    {   
        this.FuelTotal += Amount;
    }
}