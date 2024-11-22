class MagicCaster : Enemy
{
    public MagicCaster() : base("Magic Caster" , 80)
    {
        base.AddAttack(new Attack("Fireball" , 25));
        base.AddAttack(new Attack("Lightning Bolt" , 20));
        base.AddAttack(new Attack("Strike" , 10));
    }

    public void Heal(Enemy target)
    {
        target.Health += 40;
        Console.WriteLine($"Healed {target.Name} and new health is {target.Health}");
    }
}