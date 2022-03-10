import java.util.Arrays;

///My Arraylist implementation
public class MyArrayList<T>
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
    public MyArrayList(){
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
            System.out.println("The element at index " + index + " is " + backingArray[index]); //For testing
            return backingArray[index];
        }
    }

    //Method to add elements to the arraylist
    public void Add(T newElement)
    {
        if(lastIndex==size) {
            ///Resizes arraylist

            //Copies elements from backingarray to tempbackingarray
            this.tempbackingArray = Arrays.copyOf(backingArray, this.size);

            this.size = 2*this.size; //Sets the new size of list as twice the current one 
            
            ///Declares the resized array and copies elements from old array to new array 
            this.backingArray = Arrays.copyOf(tempbackingArray, this.size); //copies elements from old array to new array 

            backingArray[lastIndex] = newElement;  // adds the element to be added 
            lastIndex++; 

        }else{
            backingArray[lastIndex] = newElement; //adds the element to be added 
            lastIndex++;           
        }    
        
    }

    //Method to Find an element inside the arraylist
    public boolean Find(T element2Find)
    {
        for (int i=0; i<this.size; i++){
            if (backingArray[i] == element2Find){
                //System.out.println("It is found"); //For testing the argument only
                return true; //return true if element is found
            }
        }
        //System.out.println("Element is not found"); //For testing the argument only
        return false; //return false by default
    }

    //Method to return the current size of the array list
    public int GetSize(){
        System.out.println("The size of the list is: " + this.size); ///To display the size for testing
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

    ///Method for printing out the contents of the list to see if it works
    
    public void PrintMyArrayList(){
        System.out.println("These are the contents of the list: ");
        for (int i=0; i<this.size; i++){
            System.out.println(backingArray[i]);
        }
    }
    


    
    
    // public static void main(String[] args){  //THIS IS MAINLY FOR TESTING IF THE CODE WORKS 
    //     MyArrayList<Integer> testlist = new MyArrayList<Integer>(); 
    //     testlist.Add(20); 
    //     testlist.Add(21); 
    //     testlist.Add(22);
    //     testlist.Add(23);
    //     testlist.Add(24);
    //     testlist.Add(25);
 
        
    //     //testlist.GetElementAtIndex(20); for testing out of bounds exception 
    //     testlist.GetElementAtIndex(2); 
    //     testlist.PrintMyArrayList();
    //     testlist.GetCapacity();
    //     testlist.Find(25);
    //     testlist.GetSize(); 
        
        
        
    // }
}