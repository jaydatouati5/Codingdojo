Car car = new("RED" , 12);
Horse horse = new("BLACK" , 11);
Bicycle bicycle = new("BLUE" , 10);

// ! Cannot create an instance of the abstract type or interface 'Vehicle' [FuelUp]
// Vehicle vehicle = new();

List<Vehicle> VList = new() {car , horse , bicycle};
List<INeedFuel> FList = new();

foreach(Vehicle v in VList)
{
    if (v is INeedFuel){
        FList.Add((INeedFuel)v);
    }
}

foreach(INeedFuel f in FList)
{
    f.GiveFuel(10);
}

foreach(INeedFuel f in FList)
{
    Vehicle v = (Vehicle)f;
    Console.WriteLine($"NAME: {v.Name} | FUEL TOTAL: {f.FuelTotal}");
}