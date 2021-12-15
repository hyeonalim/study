public class KimbapChef extends Chef {
    
    public Menu makeFood(Order o) throws Exception{
        if(!(o instanceof KimbapOrder)){

            throw new Exception("김밥만 만들 수 있어요.");

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
