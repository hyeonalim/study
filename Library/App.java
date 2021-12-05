import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> members = new ArrayList<>();
        ArrayList<String> books = new ArrayList<>();
        ArrayList<Rental> rentals = new ArrayList<>();

        while(true){
            //레스토랑 진행
            Library library = new Library();
            library.run(members, books, rentals);
        
        }   

    }
}
