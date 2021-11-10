import java.util.Scanner;

public class Customer {

    String name;
    int money;
    int moreMoney;
    int addMoney;

    Pizza pz; //피자 불러오기
    String eatCheese;
    String eatOlive;
    String eatBeaf;
    String eatPepperoni;
    
    Scanner scn = new Scanner(System.in);

    //손님 이름
    String name(){

        System.out.println("손님의 이름은:");
        name = scn.nextLine();
        scn.nextLine();

        return name;

    }

    //계산, 손님 거스름돈
    int pay(int price){

        System.out.println("가지고 계신 금액을 입력해주세요.");
        money = scn.nextInt();
        scn.nextLine();

        if(money >= price){
            System.out.println(price + "를 내겠습니다.");
            money = money - price;
            System.out.println("남은 돈은 " + money + "입니다.");            
        }else{
            moreMoney = money - price;
            System.out.println("부족한 돈" + Math.abs(moreMoney) + " 보다 더 많은 금액을 입력해주세요.");
            addMoney = scn.nextInt();

            money = money + addMoney;
            money = money - price;
            System.out.println("남은 돈은 " + money + "입니다.");            
        }

        return price;

    }

    //맛 평가 (값이 안 들어옴... ㅜㅜPizza나 Casher에는 값이 들어옴)
    void eat(){

        Pizza pz = new Pizza();

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
