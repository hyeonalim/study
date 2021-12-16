import java.util.Scanner;

public class Customer {
    
    Scanner scn = new Scanner(System.in);

    int pay(int price) throws Exception{

        System.out.println("가지고 계신 금액: ");
        int money = scn.nextInt();
        
        if(money >= price){

            money -= price;
            System.out.println("거스름돈: " + money);

        }else{

            Exception e = new Exception();
            throw e;

        }

        return price;

    }

    void eat(Menu m){

        System.out.println(m.taste() + "이네요.");

    }
}