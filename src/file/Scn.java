package file;
import java.util.Scanner;

public class Scn {
    
    Scanner scn = new Scanner(System.in);

    public int scnInt(){
        int n = scn.nextInt();
        scn.nextLine();

        return n;
    }

    public String scnString(){
        String name = scn.nextLine();
        scn.nextLine();

        return name;
    }
}
