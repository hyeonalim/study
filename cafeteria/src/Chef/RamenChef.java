package Chef;

import Menu.BagStewRamen;
import Menu.CheeseRamen;
import Menu.Menu;
import Menu.OriginRamen;
import Order.BagStewRamenOrder;
import Order.CheeseRamenOrder;
import Order.Order;
import Order.OriginRamenOrder;
import Order.RamenOrder;

public class RamenChef extends Chef {
    public Menu makeFood(Order o) throws Exception{
        
        if(!(o instanceof RamenOrder)){

            System.out.println("라면만 입력 가능");
        }
        
        if(o instanceof OriginRamenOrder){

            return new OriginRamen();

        }else if(o instanceof CheeseRamenOrder){

            return new CheeseRamen();

        }else if(o instanceof BagStewRamenOrder){

            return new BagStewRamen();

        }else{

            throw new Exception("레시피 x");
        }
    }
}
