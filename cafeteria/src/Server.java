import java.util.ArrayList;

import Menu.Menu;

public class Server {
    
    void run(ArrayList<Menu> menus, Customer cu){

        //list 크기에 맞게 각각의 맛 알려주기
        
        for(Menu m: menus){

            cu.eat(m);

        }
    }
    
}
