import java.util.Scanner;

public class Customer {
    
    Scanner scn = new Scanner(System.in);

    int pay(int price) throws Exception{

        System.out.println("가지고 계신 금액: ");
        int money = scn.nextInt();
        
        if(money >= price){

            System.out.println(price);
            money -= price;
            System.out.println("거스름돈: " + money);

        }else{

            Exception e = new Exception();
            throw e;

        }

        return price;

    }

    void eat(String kind){

        if(kind.equals("김밥")){

            System.out.println(kind + "이 밥이 맛있네요.");

        }else if(kind.equals("돈까스")){

            System.out.println(kind + "이 바삭하네요.");

        }else if(kind.equals("라면")){

            System.out.println(kind + "꼬들거리네요.");

        }

    }
}
