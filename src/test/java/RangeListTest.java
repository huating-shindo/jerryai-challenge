import jerryai.model.Range;
import jerryai.service.RangeList;
import jerryai.service.impl.MergeRangeListImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Huating Wang
 */
public class RangeListTest {

    private RangeList rangeList;

    @Before
    public void setup() {
        this.rangeList = new MergeRangeListImpl();
    }

    @Test
    public void addFirstRange() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        assertEquals("[1, 5)", this.rangeList.print());
    }


    @Test
    public void addRangesWithoutOverlap() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        assertEquals("[1, 5) [10, 20)", this.rangeList.print());
    }

    @Test
    public void addRangesWithoutOverlap2() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,20);
        this.rangeList.add(r);
        assertEquals("[1, 5) [10, 20)", this.rangeList.print());
    }

    @Test
    public void addRangesWithOverlap() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        assertEquals("[1, 5) [10, 21)", this.rangeList.print());
    }

    @Test
    public void addRangesWithOverlap2() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        assertEquals("[1, 5) [10, 21)", this.rangeList.print());
    }

    @Test
    public void addRangesWithOverlap3() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        r = new Range(3,8);
        this.rangeList.add(r);
        assertEquals("[1, 8) [10, 21)", this.rangeList.print());
    }

    @Test
    public void addRangesWithMultipleOverLaps() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(6,8);
        this.rangeList.add(r);
        r = new Range(21,24);
        this.rangeList.add(r);
        assertEquals("[1, 5) [6, 8) [10, 20) [21, 24)", this.rangeList.print());
        r = new Range(3,10);
        this.rangeList.add(r);
        assertEquals("[1, 20) [21, 24)", this.rangeList.print());
    }


    @Test
    public void removeRangesWithoutOverlap() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        r = new Range(3,8);
        this.rangeList.add(r);
        r = new Range(10,10);
        this.rangeList.remove(r);
        assertEquals("[1, 8) [10, 21)", this.rangeList.print());
    }

    @Test
    public void removeRangesWithOverlap() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        r = new Range(3,8);
        this.rangeList.add(r);
        r = new Range(10,11);
        this.rangeList.remove(r);
        assertEquals("[1, 8) [11, 21)", this.rangeList.print());
    }


    @Test
    public void removeRangesWithOverlap2() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        r = new Range(3,8);
        this.rangeList.add(r);
        r = new Range(10,11);
        this.rangeList.remove(r);
        r = new Range(15,17);
        this.rangeList.remove(r);
        assertEquals("[1, 8) [11, 15) [17, 21)", this.rangeList.print());
    }

    @Test
    public void removeRangesWithOverlap3() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        r = new Range(3,8);
        this.rangeList.add(r);
        r = new Range(10,11);
        this.rangeList.remove(r);
        r = new Range(15,17);
        this.rangeList.remove(r);
        r = new Range(3,19);
        this.rangeList.remove(r);
        assertEquals("[1, 3) [19, 21)", this.rangeList.print());
    }

    @Test
    public void removeFullRanges() {
        Range r = new Range(1,5);
        this.rangeList.add(r);
        r = new Range(10,20);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(20,21);
        this.rangeList.add(r);
        r = new Range(2,4);
        this.rangeList.add(r);
        r = new Range(3,8);
        this.rangeList.add(r);
        r = new Range(10,11);
        this.rangeList.remove(r);
        r = new Range(15,17);
        this.rangeList.remove(r);
        r = new Range(3,19);
        this.rangeList.remove(r);
        assertEquals("[1, 3) [19, 21)", this.rangeList.print());
        r = new Range(0,25);
        this.rangeList.remove(r);
        assertEquals("", this.rangeList.print());
    }
}
