
///My Arraylist implementation
public class MyArrayListTest<T>
{
    /// <summary>
    /// Contains the elements of your list
    /// </summary>
    private T[] backingArray; 
    private T[] tempbackingArray; //Array to store old elements of the list when resizing

    /// <summary>
    /// size of my arraylist
    /// </summary>
    private int size;
    private int lastIndex;

    //Constructor for MyArrayListTest
    public MyArrayListTest(){
        this.size = 4;
        this.lastIndex = 0;
        this.backingArray = (T[]) new Object[4]; //Setup initial array with size 4
    }

    // Method to get element from backing array at index i
    public T GetElementAtIndex(int index){
        if(index >= size){
            System.out.println("Index is greater than size");
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds"); ///Throws exception if out of bounds
            
        } else{
            System.out.println("The element at index " + index + " is " + backingArray[index]);
            return backingArray[index];
        }
    }

    //Method to add elements to the arraylist
    public void Add(T newElement)
    {
        if(lastIndex==size) {
            ///Resizes arraylist
            this.tempbackingArray = (T[]) new Object[this.size]; //Declares a temporary backing array to put old values in 

            for(int i=0; i<this.size;i++){   ///Copies the elements from backing array to temporary backing array
                tempbackingArray[i] = backingArray[i]; 
            }

            this.size = 2*this.size; //Sets the new size of list as twice the current one 
            this.backingArray = (T[]) new Object[this.size]; ///Declares the resized array

            ///Adds the old elements to the new list 
            for(int i=0; i<this.size/2; i++){ ///Divide by two because previously the old list is half of new list 
                backingArray[i] = tempbackingArray[i]; 
            }

            backingArray[lastIndex] = newElement;  // adds the element to be added 
            lastIndex++; 

        }else{
            backingArray[lastIndex] = newElement; //adds the element to be added 
            lastIndex++;           
        }       
    }

    //Method to Find an elmenent inside the arraylist
    public boolean Find(T element2Find)
    {
        for (int i=0; i<this.size; i++){
            if (backingArray[i] == element2Find){
                System.out.println("It is found"); //For testing the argument only
                return true; //return true if element is found
            }
        }
        return false; //return false by default
    }

    //Method to return the current size of the array list
    public int GetSize(){
        System.out.println("The size of the list is: " + this.size); ///To display the size 
        return this.size;
    }

    //Method to return the number of elements in the array list
    public int GetCapacity(){
        int count = 0;
        for (int i=0; i<this.size; i++){
            if (backingArray[i] != null){
                ++count; //count every non-empty element of the list
            }
        } 
        System.out.println("There are currently " + count + " elements in the list "); //For testing the argument only
        return count;  
    }

    ///METHOD FOR PRINTING OUT THE CONTENTS OF THE LIST for checking if stuff works. can be removed when finalizing. 
    public void PrintMyArrayList(){
        System.out.println("These are the contents of the list: ");
        for (int i=0; i<this.size; i++){
            System.out.println(backingArray[i]);
        }
    }


    public static void main(String[] args){  //THIS IS MAINLY FOR TESTING IF THE CODE WORKS 
        MyArrayListTest<Integer> testlist = new MyArrayListTest<Integer>(); 
        testlist.Add(20); 
        testlist.Add(21); 
        testlist.Add(22); 
        testlist.Add(23); 
        testlist.Add(24); 
        testlist.Add(25); 
        testlist.Add(26); 
        testlist.Add(27); 
        testlist.Add(28); 
        testlist.Add(29); 
        
        //testlist.GetElementAtIndex(20); for testing out of bounds exception 
        testlist.GetElementAtIndex(11); 
        testlist.PrintMyArrayList();
        testlist.GetCapacity();
        testlist.Find(21);
        testlist.GetSize(); 
        
        
        
    }
}