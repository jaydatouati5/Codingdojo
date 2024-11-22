using System.Security.Authentication;

class MeleeFighter : Enemy
{
    public MeleeFighter() : base("Melee Fighter" , 120)
    {
        base.AddAttack(new Attack("Punch" , 20));
        base.AddAttack(new Attack("Kick" , 15));
        base.AddAttack(new Attack("Tackle" , 25));
    }

    public void Rage(Enemy target)
    {
        Attack chosen = base.RandomAttack();
        chosen.DamageAmount += 10;
        base.PerformAttack(target , chosen);
        chosen.DamageAmount -= 10;
    }

    



}