template <class T>
class GPoint {
public:
    GPoint(T newx, T newy);
    GPoint(const GPoint&);
    GPoint& operator= (const GPoint&);
    ~GPoint();
    T GetAbsis();
    T GetOrdinat();
    void SetAbsis(T newx);
    void SetOrdinat(T newy);
    int IsEqual(GPoint P);
private:
    T x; //absis
    T y; //ordinat
};