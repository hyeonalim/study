public class RamenChef extends Chef {
    
    public Menu makeFood(Order o) throws Exception{
        if(!(o instanceof RamenOrder)){

            throw new Exception("라면만 만들기 가능");

        }

        if(o instanceof BagStewRamenOrder){

            return new BagStewRamen();

        }else if(o instanceof CheeseRamenOrder){

            return new CheeseRamen();

        }else if(o instanceof OriginRamenOrder){

            return new OriginRamen();

        }else{

            throw new Exception("레시피 x");

        }
    }
}
