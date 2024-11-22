MeleeFighter melee = new();
RangedFighter ranged = new();
MagicCaster magic = new();

melee.PerformAttack(ranged , melee.AttackList[1]);

melee.Rage(magic);

ranged.PerformAttack(melee , ranged.AttackList[0]);

ranged.Dash();

ranged.PerformAttack(melee , ranged.AttackList[0]);

magic.PerformAttack(melee , magic.AttackList[0]);

magic.Heal(ranged);

magic.Heal(magic);

