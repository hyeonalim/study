package Chef;

import Menu.CheesePork;
import Menu.FishPork;
import Menu.Menu;
import Menu.SweetPotatoPork;
import Order.CheesePorkOrder;
import Order.FishPorkOrder;
import Order.Order;
import Order.PorkOrder;
import Order.SweetPotatoPorkOrder;

public class PorkChef {
    public Menu makeFood(Order o) throws Exception{
        
        if(!(o instanceof PorkOrder)){

            System.out.println("돈까스만 입력 가능");
        }
        
        if(o instanceof FishPorkOrder){

            return new FishPork();

        }else if(o instanceof SweetPotatoPorkOrder){

            return new SweetPotatoPork();

        }else if(o instanceof CheesePorkOrder){

            return new CheesePork();

        }else{

            throw new Exception("레시피 x");
        }
    }
}
