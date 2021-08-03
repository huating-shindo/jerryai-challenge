package jerryai.model;

/**
 * @author Huating Wang
 */
public class Range {

    private int begin;
    private int end;

    public Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     *
     * @return begin of the range
     */
    public int getBegin() {
        return begin;
    }

    /**
     * set begin of the range
     * @param begin begin of the range
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     *
     * @return end of the range
     */
    public int getEnd() {
        return end;
    }

    /**
     * set end of the range
     * @param end end of the range
     */
    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + this.begin + ", " + this.end + ")";
    }
}
