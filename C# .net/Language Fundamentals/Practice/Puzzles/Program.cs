// ! Coin Flip
static string CoinFlip()
{
    Random rand = new();
    if (rand.Next(2) == 0)
        return "Tails";
    else
        return "Heads";
}

// Console.WriteLine(CoinFlip());
// Console.WriteLine(CoinFlip());
// Console.WriteLine(CoinFlip());
// Console.WriteLine(CoinFlip());
// Console.WriteLine(CoinFlip());

// ! Dice Roll
static int RollDice(int sides)
{
    Random rand = new();
    return rand.Next(sides)+1;
}

// Console.WriteLine(RollDice(6));
// Console.WriteLine(RollDice(6));
// Console.WriteLine(RollDice(6));
// Console.WriteLine(RollDice(6));
// Console.WriteLine(RollDice(6));
// Console.WriteLine(RollDice(6));
// Console.WriteLine(RollDice(6));

// ! Stat Roll

static List<int> StatRoll(int rolls)
{
    int largest = 0;
    List<int> list = new();
    for(int i = 0; i < rolls; i++)
    {
        int CurrentRoll = RollDice(6);
        list.Add(CurrentRoll);
        if (CurrentRoll > largest)
            largest = CurrentRoll;
    }

    Console.WriteLine($"The largest roll was: {largest}");
    return list;
}

// List<int> plays = StatRoll(4);
// Console.WriteLine("Rolls: ");
// foreach(int roll in plays)
//     Console.WriteLine(roll);

// ! Roll Until...
static void RollUntil(int number){
    int count = 1;
    int roll = RollDice(6);
    while(roll != number){
        count++;
        roll = RollDice(6);
    }
    Console.WriteLine($"Rolled a {number} after {count} tries");
}

// Console.WriteLine("Jouda:");
// RollUntil(4);
// Console.WriteLine("Aloulou:");
// RollUntil(5);

// ! Optional Bonus
static void Play()
{
    string player_1;
    string player_2;

    int dice_size;

    int dice_count;
    // Get Player Names:
    Console.WriteLine("Player 1, Please put your name: ");
    player_1 = Console.ReadLine();
    Console.Clear();
    Console.WriteLine("Player 2, Please put your name: ");
    player_2 = Console.ReadLine();
    Console.Clear();

    // Choose Dice Size 
    Console.WriteLine("Insert the Dice size: ");
    dice_size = Int32.Parse(Console.ReadLine());
    Console.Clear();

    // How many dice in game
    Console.WriteLine("Insert the number of Dice: ");
    dice_count = Int32.Parse(Console.ReadLine());
    Console.Clear();

    // Print game details 
    Console.WriteLine("----------------- Game Details -----------------");
    Console.WriteLine($"Player 1: {player_1}");
    Console.WriteLine($"Player 2: {player_2}");
    Console.WriteLine($"Dice Size: {dice_size}");
    Console.WriteLine($"Dice Count: {dice_count}");
    

    int player_1_score = 0;
    int player_2_score = 0;

    // Play Game
    Console.WriteLine($"{player_1}'s turn: ");
    player_1_score = playTurn(dice_size , dice_count);
    Console.WriteLine($"Their score is: {player_1_score}");

    Console.WriteLine($"{player_2}'s turn: ");
    player_2_score = playTurn(dice_size , dice_count);
    Console.WriteLine($"Their score is: {player_2_score}");

    // Display Results:
    if (player_1_score > player_2_score){
        Console.WriteLine($"Congrats {player_1}, you won the game with the score: {player_1_score}");
    }else if(player_2_score > player_1_score){
        Console.WriteLine($"Congrats {player_2}, you won the game with the score: {player_2_score}");
    }else{
        Console.WriteLine($"Tie, no one won!");
    }
}

static int playTurn(int diceSize, int diceCount){
    int total = 0;
    Console.WriteLine("Rolled a:");
    for (int i = 0; i < diceCount; i++){
        int played = RollDice(diceSize);
        Console.Write($" {played}");
        total+=played;
    }
    return total;
}

Play();