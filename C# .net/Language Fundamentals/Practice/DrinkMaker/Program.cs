Soda soda1 = new("Has sugar" , "Black", 2.1, 150);
Soda soda2 = new("No Sugar" , "Orange",1.9, 200);

Coffee coffee1 = new("Dark", "Brazelian","Black", 90.1, 0);
Coffee coffee2 = new("Light","American", "Caramel",96.2, 5);

Tea tea1 = new("UK",2000,"white tea",80.0, 1);
Tea tea2 = new("India",1977, "Green tea", 98.1, 4);

List<Drink> AllBeverages = new List<Drink>();

AllBeverages.Add(soda1);
AllBeverages.Add(soda2);

AllBeverages.Add(coffee1);
AllBeverages.Add(coffee2);

AllBeverages.Add(tea1);
AllBeverages.Add(tea2);

foreach(Drink dr in AllBeverages)
{
    dr.ShowDrink();
}

//! Variable type doesn²t match the invoked class's constructor 
// Coffee MyDrink = new Soda();