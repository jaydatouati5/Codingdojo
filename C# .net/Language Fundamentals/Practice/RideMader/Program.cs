Vehicle car = new ("lamborghini", "red");
Vehicle horse = new ("Monica", "brown");
Vehicle unicycle = new ("catchy", "black");
Vehicle yacht = new ("Monica", "brown");

List<Vehicle> VehicleList = new() {car, horse, unicycle, yacht};

foreach(Vehicle vehicle in VehicleList)
{
    vehicle.ShowInfo();
}

unicycle.Travel(100);
unicycle.ShowInfo();

