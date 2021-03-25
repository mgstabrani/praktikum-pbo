class Main{
    public static void main(String[] args){
        Time time = new Time(23,0,0);
        Time time2 = new Time(1,0,0);
        time.printTime();
        time.add(time2);
        time.printTime();
        System.out.println(time.greaterThan(time2));
        System.out.println(time2.convertToSecond());
    }
}