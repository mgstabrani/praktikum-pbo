public class GPoint<T> {
    private T x, y;

    public GPoint(T newx, T newy) {
        this.x = newx;
        this.y = newy;
    }

    public GPoint(GPoint<T> other) {
        this.x = other.x;
        this.y = other.y;
    }

    public T GetAbsis() {
        return this.x;
    }

    public T GetOrdinat() {
        return this.y;
    }

    public void SetAbsis(T newx) {
        this.x = newx;
    }

    public void SetOrdinat(T newy) {
        this.y = newy;
    }

    public int IsEqual(GPoint<T> other) {
        return (other.GetAbsis().equals(this.GetAbsis()) && other.GetOrdinat().equals(this.GetOrdinat())) ? 1 : 0;
    }
}