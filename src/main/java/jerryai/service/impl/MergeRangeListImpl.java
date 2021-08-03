package jerryai.service.impl;

import jerryai.model.Range;
import jerryai.service.RangeList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author Huating Wang
 *
 *  implementation of RangeList with Merge algorithm
 */
public class MergeRangeListImpl implements RangeList {

    private List<Range> rangeList;

    public MergeRangeListImpl() {
        this.rangeList = new ArrayList<Range>();
    }

    /**
     * Use merge algorithm to add new range to the existing range list
     * @param range - new range(begin,end) to be added.
     */
    public void add(Range range) {
        List<Range> mergeList = new ArrayList<Range>();
        // the flag to indicate if the new range has been merged into existing list
        boolean merged = false;
        for(Range r: rangeList) {
            if(r.getEnd() < range.getBegin()) {
                mergeList.add(r);
            } else if (r.getBegin() > range.getEnd()) {
                if(!merged) {
                    mergeList.add(range);
                    merged = true;
                }
                mergeList.add(r);
            // overlap process
            } else {
                range.setBegin(Math.min(r.getBegin(), range.getBegin()));
                range.setEnd(Math.max(r.getEnd(), range.getEnd()));
            }
        }
        if(!merged)
            mergeList.add(range);
        this.rangeList = mergeList;
    }

    /**
     * Use merge algorithm to delete the given range from the existing range list
     * @param range - range(begin,end) to be deleted.
     */
    public void remove(Range range) {
        List<Range> mergeList = new ArrayList<Range>();
        for(Range r: rangeList) {
            if(r.getEnd() < range.getBegin() || r.getBegin() > range.getEnd()) {
                mergeList.add(r);
            // overlap process
            } else {
                // e.g. existing range (1,5) delete range (3,6), then remain range(1,3)
                if(r.getBegin() < range.getBegin())
                    mergeList.add(new Range(r.getBegin(), range.getBegin()));
                // e.g. existing range (4,8) delete range (3,6), then remain range(6,8)
                if(r.getEnd() > range.getEnd())
                    mergeList.add(new Range(range.getEnd(), r.getEnd()));
            }
        }
        this.rangeList = mergeList;
    }

    /**
     * Prints out the list of ranges in the range list
     */
    public String print() {
        StringBuilder sb = new StringBuilder();
        for(Range r: this.rangeList)
            sb.append(r.toString()).append(" ");
        System.out.println(sb);
        return sb.toString().trim();
    }
}
