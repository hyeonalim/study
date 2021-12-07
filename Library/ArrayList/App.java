import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> members = new ArrayList<>();
        ArrayList<String> books = new ArrayList<>();
        ArrayList<Rental> rentals = new ArrayList<>();

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
