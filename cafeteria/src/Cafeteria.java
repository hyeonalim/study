import java.util.ArrayList;

import Chef.KimbapChef;
import Chef.PorkChef;
import Chef.RamenChef;
import Menu.Menu;
import Order.KimbapOrder;
import Order.Order;
import Order.PorkOrder;
import Order.RamenOrder;

public class Cafeteria {

    Kiosk kiosk = new Kiosk(); //키오스크
    
    KimbapChef kimbapChef = new KimbapChef();
    PorkChef porkChef = new PorkChef();
    RamenChef ramenChef = new RamenChef();

    Server server = new Server(); //서버

    //어서오세요, 주문해주세요.
    void run() throws Exception{

        while(true){

            Customer customer = new Customer(); //고객

            //인사
            System.out.println("어서오세요, 주문해주세요.");

            //정보 모으기
            ArrayList<Order> orders = kiosk.run(customer);//키오스크 주문 받은 내역 저장
            ArrayList<Menu> menus = new ArrayList<>(); //주문받은 내역 만들기

            //셰프에게 전달
            for(Order o: orders){
            
                if(o instanceof KimbapOrder){

                    menus.add(kimbapChef.makeFood(o));
                    
                }else if(o instanceof PorkOrder){

                    menus.add(porkChef.makeFood(o));
                    
                }else if(o instanceof RamenOrder){

                    menus.add(ramenChef.makeFood(o));
                    
                }else{

                    System.out.println("주문이 없습니다.");

                }

            }

            //서빙
            if(menus.size() > 0){

                server.run(menus, customer);

            }else{

                System.out.println("주문이 없습니다.");

            }
        }
    }

}