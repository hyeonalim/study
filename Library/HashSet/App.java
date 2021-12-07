import java.util.ArrayList;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        HashSet<String> members = new HashSet<>();
        HashSet<String> books = new HashSet<>();
        HashSet<Rental> rentals = new HashSet<>();
        
        while(true){
            
            Library library = new Library();
            try{
                library.run(members, books, rentals);
            } catch(Exception e){
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
