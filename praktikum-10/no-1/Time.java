public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        // Set seluruh atribut dengan nilai 0
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(Time t) {
        // Set atribut dengan atribut milik t
        this.hour = t.hour;
        this.minute = t.minute;
        this.second = t.second;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int convertToSecond() {
        return this.getHour() * 3600 + this.getMinute() * 60 + this.getSecond();
    }

    public Time add(Time t) {
        int perubahan = (this.convertToSecond() + t.convertToSecond())%86400;
        
        int hour = perubahan / 3600;
        int minute = (perubahan / 60) % 60;
        int second = perubahan % 60;
        return new Time(hour, minute, second);
    }

    public Time minus(Time t) {
        if (lessThan(t)){
            return this;
        }
        int perubahan = (this.convertToSecond() - t.convertToSecond())%86400;
        
        int hour = perubahan / 3600;
        int minute = (perubahan / 60) % 60;
        int second = perubahan % 60;
        return new Time(hour, minute, second);
    }

    public boolean lessThan(Time t) {
        // Returns true jika *this* < t menurut definisi waktu
        return (this.convertToSecond() < t.convertToSecond());
    }

    public boolean greaterThan(Time t) {
        // Returns true jika *this* > t menurut definisi waktu
        return (this.convertToSecond() > t.convertToSecond());
    }

    public void printTime() {
        // Menuliskan jam dalam format hh:mm:ss diakhiri dengan newline. Perhatikan bahwa setiap parameter harus dituliskan 2 digit.
        if(this.getHour() > 9) System.out.print(this.getHour() + ":");
        else System.out.print("0" + this.getHour() + ":");

        if(this.getMinute() > 9) System.out.print(this.getMinute() + ":");
        else System.out.print("0" + this.getMinute() + ":");

        if(this.getSecond() > 9) System.out.println(this.getSecond());
        else System.out.println("0" + this.getSecond());

    }
}