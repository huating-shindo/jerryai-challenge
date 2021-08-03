# Range List

## Coding Question

Task: Implement a class named 'RangeList'
 A pair of integers define a range, for example: [1, 5). This range includes integers: 1, 2, 3, and 4.
A range list is an aggregate of these ranges: [1, 5), [10, 11), [100, 201)


## API

* **Adds a range to the list**

    void add(Range range);   
   
* **Removes a range from the list**

    void remove(Range range);
    
* **Prints out the list of ranges in the range list**

    String print();
    

## Solution - Merge
   
   ### Premise
   Anytime, the range list will keep in order, if 0<i<j<length, then range(i).end<range(j).begin 
   
   #### 1. Add
   Iterate the whole existing range list
   * if the existing range's begin is less than the merged range's begin, simply append existing one to the merged list
   * if the existing range's end is larger than the merge range's end
        * append merged range to the merged list if it hasn't been added
     append existing one to the merged list
   * otherwise, merge the new range with existing one, assuming the existing range is (begin, end), and the added range is (addStart, addEnd), then the merged range will become (Math.min(begin, addStart), Math.max(end,addEnd))
   Finally, set the member variable rangeList to merged list
   
  #### Complexity
   
   * Time Complexity: O(N) , where N is the size of the range list.
   * Space Complexity: O(N), where N is the size of the range list.
   
   ### 2. Remove
   
   Iterate the whole existing range list
   * if there is no overlap, simply add it into merged list
   * otherwise
        * if the deleting range's begin (deleteStart) is large than existing range's begin(begin), append (begin, deleteStart)
        * if the deleting range's end (deleteEnd) is less than existing range's end(end), append (deleteEnd, end)
    Finally, set the member variable rangeList to merged list
   
   #### Complexity
  
  * Time Complexity: O(N) , where N is the size of the range list.
  * Space Complexity: O(N), where N is the size of the range list.
