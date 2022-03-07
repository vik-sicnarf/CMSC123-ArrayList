/// <summary>
/// My Arraylist implementation
/// </summary>
/// <typeparam name="T"></typeparam>
public class MyArrayListTest<T>
{
    /// <summary>
    /// Contains the elements of your list
    /// </summary>
    private T[] backingArray; 
    private T[] tempbackingArray; //This is for adding elements that exceed the original size of the array 

    /// <summary>
    /// size of my arraylist
    /// </summary>
    private int size;
    private int lastIndex;

    //Constructor for MyArrayListTest
    // Setup initial array with size 4
    public MyArrayListTest(){
        //this.backingArray = new T[4](); // To be deleted if the declaration below works
        this.size = 4;
        this.lastIndex = 0;
        this.backingArray = (T[]) new Object[4]; //Declaring initial size of array, Not sure if this is correct but for now it is working
    }

    // Method to get element from backing array at index i
    public T GetElementAtIndex(int index){
        if(index >= size){
            System.out.println("Index is greater than size");
            return null; //not sure if return null is correct. Does not return anything if the index is greater than list size
        } else{
            System.out.println("The element at index " + index + " is " + backingArray[index]);
            return backingArray[index];
        }
        //throw new NotImplementedException(); //From the template
    }

    public void Add(T newElement)
    {
        if(lastIndex==size) {
    
            // resize your arraylist, copy over elements to new backing array 
            this.tempbackingArray = (T[]) new Object[this.size]; //Declares a temporary backing array to put old values in 

            for(int i=0; i<this.size;i++){   ///Copies the elements from backing array to temporary backing array
                tempbackingArray[i] = backingArray[i]; 
            }

            this.size = 2*this.size; //Sets the new size of list 
            this.backingArray = (T[]) new Object[this.size]; ///Declares the new list 

            ///Adds the old elements to the new list 
            for(int i=0; i<this.size/2; i++){ ///divided by two because previously the old list is half of new list 
                backingArray[i] = tempbackingArray[i]; 
            }

            backingArray[lastIndex] = newElement;  // adds the element to be added 
            lastIndex++; 
            ///Declare new array of with the new size 
            ///Copy the elements of old array to the new array
        }else{
            //System.out.println("Adding Element");
            backingArray[lastIndex] = newElement; //adds the element to be added 
            lastIndex++;           
        }       
    }

    public boolean Find(T element2Find)
    { 
        //throw new NotImplementedException(); //From the template
        for (int i=0; i<this.size; i++){
            if (backingArray[i] == element2Find){
                System.out.println("It is found"); //For testing the argument only
                return true; //return true if element is found
            }
        }
        return false; //return false by default
    }

    public int GetSize(){
        System.out.println("The size of the list is: " + this.size); ///To check if the output is correct 
        return this.size;
    }

    public int GetCapacity(){
        //throw new NotImplementedException();
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
        MyArrayListTest<String> testlist = new MyArrayListTest<String>(); 
        testlist.Add("Element1"); 
        testlist.Add("Element2"); 
        testlist.Add("Element3"); 
        testlist.Add("Element4"); 
        testlist.Add("Element5"); 
        testlist.Add("Element6"); 
        testlist.Add("Element7"); 
        testlist.Add("Element8"); 
        testlist.Add("Element9"); 
        testlist.Add("Element10"); 
        
        
        testlist.GetElementAtIndex(0); 
        testlist.PrintMyArrayList();
        testlist.GetCapacity();
        testlist.Find("Element6");
        testlist.GetSize(); 
        
        
        
    }
}