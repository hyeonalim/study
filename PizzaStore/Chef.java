public class Chef {
    
    //피자 만드는 메소드
    //피자 안 돌려주고 있는 중.. 피자 돌려줄 것!
    Pizza makePizza(Order od){

        Pizza pz = new Pizza(); //피자 만들기
        
        System.out.println("피자를 만드는 중입니다.");
        
        pz.cheese = od.amountCheese;
        pz.olive = od.putOlive;
        pz.beaf = od.putBeaf;
        pz.pepperoni = od.putPepperoni;

        System.out.println("피자가 완성되었습니다.");

        return pz;
        
    }
}
