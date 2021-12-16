public class PorkChef extends Chef {
    
    public Menu makeFood(Order o) throws Exception{
        if(!(o instanceof PorkOrder)){

            throw new Exception("돈까스만 만들기 가능");

        }

        if(o instanceof CheesePorkOrder){

            return new CheesePork();

        }else if(o instanceof FishPorkOrder){

            return new FishPork();

        }else if(o instanceof SweetPotatoPorkOrder){

            return new SweetPotatoPork();

        }else{

            throw new Exception("레시피 x");

        }
    }
}
