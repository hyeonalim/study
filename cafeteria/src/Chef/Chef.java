package Chef;

import Menu.Menu;
import Order.Order;

public abstract class Chef {
    
    public abstract Menu makeFood(Order o) throws Exception;
    
}
