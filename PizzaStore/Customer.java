import java.util.Scanner;

public class Customer {

    String name;
    
    Pizza pz; //피자 불러오기

    int cheese;
    boolean olive;
    boolean beaf;
    boolean pepperoni;
    
    Scanner scn = new Scanner(System.in);

    //손님 이름
    String name(){

        System.out.println("손님의 이름은:");
        name = scn.nextLine();
        scn.nextLine();

        return name;

    }

    //계산, 손님 거스름돈
    int pay(int price) throws Exception{

        System.out.println("가지고 계신 금액을 입력해주세요.");
        int money = scn.nextInt();

        //예외 만들기
        if(money >= price){
            
            System.out.println(price + "를 내겠습니다.");
            money = money - price;
            System.out.println("남은 돈은 " + money + "입니다.");   
            
        }else{
            
            Exception e = new Exception("가지고 있는 돈이 부족합니다.");
            throw e;
            
        }

        return price;

    }

    //맛 평가
    void eat(Pizza pz){

        //맛 표기 하는 문자열
        String eatCheese;
        String eatOlive;
        String eatBeaf;
        String eatPepperoni;

        if(pz.cheese <= 10){
            eatCheese = "치즈가 있네,";
        }else if(pz.cheese <= 20){
            eatCheese = "치즈가 적당하네,";
        }else{
            eatCheese = "치즈 축제네,";
        }

        if(pz.olive == true){
            eatOlive = "올리브가 신선하군,";
        }else{
            eatOlive = "흠...";
        }

        if(pz.beaf == true){
            eatBeaf = "불고기가 잘 구워졌군,";
        }else{
            eatBeaf = "음...";
        }

        if(pz.pepperoni == true){
            eatPepperoni = "페퍼로니가 매콤하군";
        }else{
            eatPepperoni = "맵지 않군";
        }

        System.out.println("피자에 " + eatCheese + eatOlive + eatBeaf + eatPepperoni);

    }
}
