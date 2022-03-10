
public class MyArrayListTester {
    public static void main(String[] args){  //THIS IS MAINLY FOR TESTING IF THE CODE WORKS 
        MyArrayList<Integer> testlist = new MyArrayList<Integer>(); 
        testlist.Add(20); 
        testlist.Add(21); 
        testlist.Add(22);
        testlist.Add(23);
        testlist.Add(24);
        testlist.Add(25);
 
        
        //testlist.GetElementAtIndex(20); //for testing out of bounds exception 
        testlist.GetElementAtIndex(3); 
        testlist.PrintMyArrayList();
        testlist.GetCapacity();
        testlist.Find(26);
        testlist.GetSize(); 
        
        
        
    }
}