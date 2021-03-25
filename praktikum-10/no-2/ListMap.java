//ListMap.java
public class ListMap implements Map {

    private ListMapEntry first;

    @Override
    public void set(String key, String value) {
        if (this.first == null){
            this.first = new ListMapEntry(key, value);
        } else {
            ListMapEntry x = this.first;
            while (x.getNext() != null){
                if (x.getKey().equals(key)){
                    x.setValue(value);
                    return;
                }
                x = x.getNext();
            }
            x.setNext(new ListMapEntry(key, value));
        }
    }

    @Override
    public String get(String key) {
        ListMapEntry x = this.first;
        while (x != null){
            if (x.getKey().equals(key)){
                return x.getValue();
            }
            x = x.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        ListMapEntry x = this.first;
        int hitung = 0;
        while (x != null){
            hitung++;
            x = x.getNext();
        }
        return hitung;
    }
    
}