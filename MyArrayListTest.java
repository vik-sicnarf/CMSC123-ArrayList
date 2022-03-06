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
        this.backingArray = (T[]) new Object[4]; //Declaring initial size of array, Not sure if this is correct
    }

    // Method to get element from backing array at index i
    public T GetElementAtIndex(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        } else{
            return backingArray[index];
        }
        //throw new NotImplementedException(); //From the template
    }

    public void Add(T newElement)
    {
        if(lastIndex==size) {
            // resize your arraylist, copy over elements to new backing array 
            this.size = 2*this.size;
            ///Declare new array of with the new size 
            ///Copy the elements of old array to the new array
        }else{
            System.out.println("Adding Element");
            backingArray[lastIndex] = newElement; 
            lastIndex++;
        }
        // add elements to backing array
        
        
    }

    public boolean Find(T element2Find)
    {
        //throw new NotImplementedException(); //From the template 
        return true; //Change to True if the element is found and False if not (Not sure)
    }

    public int GetSize(){
        return this.size;
    }

    public int GetCapacity(){
        //throw new NotImplementedException();
        return 1; //Change to return actual capacity
    }
  
}