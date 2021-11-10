import java.util.Scanner;

public class Casher {

    int income; //가게 돈
    int price = 1000; //피자 가격
    Pizza pz; //피자 불러오기
    Chef ch; //셰프 불러오기
    Server sv; //서버 불러오기
    Scanner scn = new Scanner(System.in); //스캐너 불러오기

    //인사하기
    void hi(){

        System.out.println("어서오세요.");

    }

    //주문받기
    void getOrder(Customer cu){

        System.out.println(cu.name() + "님, 주문하시겠습니까?(Y/N)");

        String order = scn.nextLine();
        scn.nextLine();

        if(order.equals("Y")){
            getSomething();
            askPay(cu, price);
            ch.makePizza();
            sv.serving(cu);   
        }else if(order.equals("N")){
            System.out.println("나가시는 문은 왼쪽입니다.");
        }
                
    }

    int getSomething(){

        Pizza pz = new Pizza();

        pz.addCheese();

        pz.addOlive();

        if(pz.olive == true){
            price += 500;
        }else{
            System.out.println("올리브는 안 넣겠습니다.");
        }

        pz.addBeaf();

        if(pz.beaf == true){
            price += 1000;
        }else{
            System.out.println("불고기는 안 넣겠습니다.");
        }

        pz.addPepperoni();
        
        if(pz.pepperoni == true){
            price += 1500;
        }else{
            System.out.println("페퍼로니는 안 넣겠습니다.");
        }

        return price;

        }
    

    //수입 증가 확인
    void askPay(Customer cu, int price){

        System.out.println("피자의 가격은 "+price+"입니다.");
        income += cu.pay(price);
        System.out.println("수입이 "+price+"증가해서 현재"+income+"가지고 있습니다.");

    }
}
