import java.util.ArrayList;

public class Server {
 
    void serving(ArrayList<Menu> menus, Customer cu){

        System.out.println("서빙중입니다.");
     
        for(Menu m: menus){

            cu.eat(m);

        }
    }
}
