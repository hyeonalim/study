import java.util.ArrayList;

public class SnackShop {
    
    void run(){
    
        Kiosk kiosk = new Kiosk();    
        Customer cu = new Customer();
        Chef ch = new Chef();
        Server sv = new Server();

        kiosk.hi();

        try{

            ArrayList<Cook> cooks = kiosk.order(cu);
            ArrayList<Maker> makers = new ArrayList<Maker>();

            for(Cook cook: cooks){

                makers.add(ch.makers(cook)); //음식 만들기

            }

            if(cooks.size() > 0){

                ch.makerOff();
                sv.serving(makers, cu);
    
            }

        }catch(Exception e){

            System.out.println("주문을 받는데서 실패했습니다.");

        }

    }

    void loop(){

        App app = new App();
        app.loop = false;

    }
}
