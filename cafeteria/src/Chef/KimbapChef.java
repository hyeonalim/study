package Chef;

import Menu.Menu;
import Menu.TengchoKimbap;
import Menu.TunaKimbap;
import Menu.VegetableKimbap;
import Order.KimbapOrder;
import Order.Order;
import Order.TengchoKimbapOrder;
import Order.TunaKimbapOrder;
import Order.VegetableKimbapOrder;

public class KimbapChef extends Chef {
    public Menu makeFood(Order o) throws Exception{
        
        if(!(o instanceof KimbapOrder)){

            System.out.println("김밥만 입력 가능");
        }
        
        if(o instanceof TengchoKimbapOrder){

            return new TengchoKimbap();

        }else if(o instanceof TunaKimbapOrder){

            return new TunaKimbap();

        }else if(o instanceof VegetableKimbapOrder){

            return new VegetableKimbap();

        }else{

            throw new Exception("레시피 x");
        }
    }
    
}
