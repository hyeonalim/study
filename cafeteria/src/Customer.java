import java.util.Scanner;

import Menu.Menu;

public class Customer {
    
    Scanner scn = new Scanner(System.in);

    //계산하기
    int pay(int price) throws Exception{

        System.out.println("가지고 계신 금액을 입력해주세요.");
        int money = scn.nextInt();
        scn.nextLine();

        money -= price;

        //돈이 전체 금액보다 큰 경우
        if(money >= 0){

            System.out.println("거스름돈 : " + money);
            
        }else{
            //돈이 전체 금액보다 작은 경우
            
            //돈을 더 입력할지 여부
            String answer = answer();

            if(answer.equals("Y")){

                System.out.println("여분의 금액을 입력해주세요.");
                int extra = scn.nextInt();
                scn.nextLine();

                extra += money;

                if(extra >= 0){

                    System.out.println("거스름돈: " + extra);

                }else{
    
                    Exception e = new Exception();
                    throw e;
    
                }

            }else{

                Exception e = new Exception();
                throw e;

            }

        }

        return price;
    }

    String answer(){
        
        System.out.println("돈을 더 입력하시겠습니까? (Y/N)");
        String answer = scn.nextLine();
        scn.nextLine();

        while(!(answer.equals("Y") || answer.equals("N"))){

            System.out.println("잘못 입력하셨습니다.");
            System.out.println("돈을 더 입력하시겠습니까? (Y/N)");
            answer = scn.nextLine();
            scn.nextLine();

        }
            
        return answer;

    }

    void eat(Menu m){

        System.out.println(m.taste() + "네요."); //주문한 것의 각각의 맛 노출

    }
}
