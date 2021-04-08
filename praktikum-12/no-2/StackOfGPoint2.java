import java.util.ArrayList;

public class StackOfGPoint2 {
    private final int defaultStackSize = 10;
    private int size;
    private int topStack;
    private ArrayList<GPoint<Float>> data;
    private static int nStack = 0;

    public StackOfGPoint2() {
        this.size = defaultStackSize;
        this.topStack = -1;
        this.data = new ArrayList<GPoint<Float>>();
        nStack++;
    }

    public StackOfGPoint2(int size) {
        this.size = size;
        this.topStack = -1;
        this.data = new ArrayList<GPoint<Float>>(size);
        nStack++;
    }

    public void Push(GPoint<Float> p) {
        if (this.data.size() < this.size) {
            this.data.add(0, p);
        }
    }

    public GPoint<Float> Pop() {
        if (this.topStack + 1 >= this.size) {
            return null;
        }
        if (this.topStack + 1 >= this.data.size()) {
            return null;
        }
        this.topStack++;
        return this.data.get(this.topStack);
    }

    public int IsEmpty() {
        int used = 0;
        if (topStack >= 0) {
            used += topStack + 1;
        }
        return (this.data.size() - used == 0) ? 1 : 0;
    }

    public int IsFull() {
        return (this.data.size() == this.size) ? 1 : 0;
    }

    public static int NumStackObj() {
        return nStack;
    }
}