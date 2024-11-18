// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");

// //! 1. Iterate and print values
// //TODO Given a List of strings, iterate through the List and print out all the values. Bonus: How many different ways can you find to print out the contents of a List? (There are at least 3! Check Google!)
using System.Diagnostics.Metrics;

static void PrintList(List<string> MyList)
{
    // Your code here
    for(int i=0; i<MyList.Count; i++)
    {
        Console.WriteLine(MyList[i]);
    }
}
List<string> TestStringList = new List<string>() {"Harry", "Steve", "Carla", "Jeanne"};
PrintList(TestStringList);

//! 2. Print Sum
//TODO Given a List of integers, calculate and print the sum of the values.
static void SumOfNumbers(List<int> IntList)
{
    // Your code here
    int sum = 0;
    // for(int i=0; i<IntList.Count; i++)
    // {
    //     sum+=IntList[i];
    // }
    foreach(int number in IntList)
    {
        sum+=number;
    }
    Console.WriteLine($"the total is sum {sum}");

}
List<int> TestIntList = new List<int>() {2,7,12,9,3};
// You should get back 33 in this example
SumOfNumbers(TestIntList);

//! 3. Find Max
// TODO Given a List of integers, find and return the largest value in the List.
static int FindMax(List<int> IntList)
{
    // Your code here
    int biggestNumber = IntList[0];
    foreach(int num in IntList)
    {
        if(num > biggestNumber){
            biggestNumber = num;
        }
    }
    return biggestNumber;
}
List<int> TestIntList2 = new List<int>() {-9,12,10,3,17,5};
// You should get back 17 in this example
FindMax(TestIntList2);

//! 4. Square the Values
//TODO Given a List of integers, return the List with all the values squared.
static List<int> SquareValues(List<int> IntList)
{
    // Your code here
    for(int i = 0; i < IntList.Count; i++){
        IntList[i] *= IntList[i];
    }
    return IntList;
}
List<int> TestIntList3 = new List<int>() {1,2,3,4,5};
// You should get back [1,4,9,16,25], think about how you will show that this worked
SquareValues(TestIntList3);

//! 5. Replace Negative Numbers with 0
//TODO Given an array of integers, return the array with all values below 0 replaced with 0.
static int[] NonNegatives(int[] IntArray)
{
    // Your code here
    for(int i=0; i<IntArray.Length; i++)
    {
        if(IntArray[i]<0)
        {
            IntArray[i]=0;
        }
    }
    return IntArray;
}
int[] TestIntArray = new int[] {-1,2,3,-4,5};
// You should get back [0,2,3,0,5], think about how you will show that this worked
NonNegatives(TestIntArray);

//! 6. Print Dictionary
//TODO Given a dictionary, print the contents of the said dictionary.
static void PrintDictionary(Dictionary<string,string> MyDictionary)
{
    // Your code here
    foreach(KeyValuePair<string,string> entry in MyDictionary)
    {
        Console.WriteLine($"{entry.Key} - {entry.Value}");
    }
}
Dictionary<string,string> TestDict = new Dictionary<string,string>();
TestDict.Add("HeroName", "Iron Man");
TestDict.Add("RealName", "Tony Stark");
TestDict.Add("Powers", "Money and intelligence");
PrintDictionary(TestDict);

//! 7. Find Key
//TODO Given a search term, return true or false whether the given term is a key in a dictionary. (Hint: figuring this one out may require some research!)
static bool FindKey(Dictionary<string,string> MyDictionary, string SearchTerm)
{
    // Your code here
foreach(KeyValuePair<string,string> entry in MyDictionary)
{
    if(SearchTerm==entry.Key)
    {
        return true;
    }
}
return false;
}
// Use the TestDict from the earlier example or make your own
// This should print true
Console.WriteLine(FindKey(TestDict, "RealName"));
// This should print false
Console.WriteLine(FindKey(TestDict, "Name"));

//! 8. Generate a Dictionary
//TODO Given a List of names and a List of integers, create a dictionary where the key is a name from the List of names and the value is a number from the List of numbers. Assume that the two Lists will be of the same length. Don't forget to print your results to make sure it worked.
// Ex: Given ["Julie", "Harold", "James", "Monica"] and [6,12,7,10], return a dictionary
// {
//	"Julie": 6,
//	"Harold": 12,
//	"James": 7,
//	"Monica": 10
// } 
static Dictionary<string,int> GenerateDictionary(List<string> Names, List<int> Numbers)
{
    // Your code here
    Dictionary<string,int> MyDictionary2 = new Dictionary<string, int>();
    for(int i =0; i<Names.Count; i++)
    {
        MyDictionary2.Add(Names[i], Numbers[i]);
    }
    return MyDictionary2;
}
// We've shown several examples of how to set your tests up properly, it's your turn to set it up!
// Your test code here
List<string> Names = new List<string>(){"Julie","Harold","James","Monica"};
List<int> Numbers = new List<int>() {6,12,7,10};
Console.WriteLine(GenerateDictionary(Names,Numbers));

















