import java.util.ArrayList;

class CompileErrorException extends Exception{
    private ArrayList<Integer> errorLocations;

    public CompileErrorException(ArrayList<Integer> listInteger){
        this.errorLocations = listInteger;
    }
    
    public void showErrors(){
        for(int errorLocation : errorLocations){
            System.out.println("Error di baris : " + (errorLocation+1));
        }
    }
}