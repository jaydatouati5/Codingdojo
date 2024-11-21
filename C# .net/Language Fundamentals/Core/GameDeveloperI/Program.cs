Enemy Cooler = new("Boss");

Attack Throw = new("throw",10);
Attack Punch =new("punch", 15);
Attack Fireball = new Attack("fireball",20);

Cooler.AttackList.Add(Throw);
Cooler.AttackList.Add(Punch);
Cooler.AttackList.Add(Fireball);

Cooler.RandomAttack();
Cooler.AddAttack(Throw);

