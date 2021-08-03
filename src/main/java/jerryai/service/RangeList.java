package jerryai.service;

import jerryai.model.Range;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author Huating Wang
 *
 *  Task: Implement a class named 'jerryai.service.RangeList'
 *  A pair of integers define a range, for example: [1, 5). This range
 *  includes integers: 1, 2, 3, and 4.
 *  A range list is an aggregate of these ranges: [1, 5), [10, 11), [100, 201)
 */
public interface RangeList {

    /**
     * Adds a range to the list
     * @param range - new range(begin,end) to be added.
     */
    void add(Range range);

    /**
     * Removes a range from the list
     * @param range - range(begin,end) to be deleted
     */
    void remove(Range range);

    /**
     * Prints out the list of ranges in the range list
     */
    String print();
}
