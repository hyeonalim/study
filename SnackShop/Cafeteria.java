import java.util.ArrayList;

public class Cafeteria {

    Kiosk kiosk = new Kiosk();    

    KimbapChef kimbapChef = new KimbapChef();
    PorkChef porkChef = new PorkChef();
    RamenChef ramenChef = new RamenChef();

    Server sv = new Server();

    void run() throws Exception{
    
        while(true){
            Customer cu = new Customer();

            System.out.println("어서오세요, 주문해주세요.");

            ArrayList<Order> orders = kiosk.run(cu);
            ArrayList<Menu> menus = new ArrayList<>();

            for(Order o: orders){

                if(o instanceof KimbapOrder){

                    menus.add(kimbapChef.makeFood(o));

                }else if(o instanceof PorkOrder){

                    menus.add(porkChef.makeFood(o));

                }else if(o instanceof RamenOrder){

                    menus.add(porkChef.makeFood(o));
                    
                }else{

                    System.out.println("주문이 없습니다.");

                }
                
               }

            if(orders.size() > 0){

                sv.serving(menus, cu);
    
            }else{

                System.out.println("주문하신 메뉴가 없습니다.");
            }

        }

    }

}
