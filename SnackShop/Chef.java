public class Chef {
    
    Maker makers(Cook cook){
        
        Maker maker = new Maker();

        if(cook.kind.equals("김밥")){

            maker = new Kimbap();

        }else if(cook.kind.equals("돈까스")){

            maker = new Pork();

        }else if(cook.kind.equals("라면")){

            maker = new Ramen();

        }
        
        maker.kind = cook.kind;
        maker.name = cook.name;
        maker.num = cook.num;
        maker.price = cook.price;

        return maker;

    }

    void makerOff(){

        System.out.println("요리가 완료되었습니다.");

    }
}
