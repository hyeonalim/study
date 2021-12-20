import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Order.BagStewRamenOrder;
import Order.CheesePorkOrder;
import Order.CheeseRamenOrder;
import Order.FishPorkOrder;
import Order.KimbapOrder;
import Order.Order;
import Order.OriginRamenOrder;
import Order.PorkOrder;
import Order.RamenOrder;
import Order.SweetPotatoPorkOrder;
import Order.TengchoKimbapOrder;
import Order.TunaKimbapOrder;
import Order.VegetableKimbapOrder;

public class Kiosk {

    int income = 0;
    Scanner scn = new Scanner(System.in);

    //주문 받기
    ArrayList<Order> run(Customer customer) throws Exception{

        ArrayList<Order> orders = new ArrayList<>();

        while(true){
            String no = procedure(); //주문 순번 받기

            try{
                if(no.equals("1")){

                    orders.add(kimbap());   //김밥
            
                }else if(no.equals("2")){

                    orders.add(pork()); //돈까스

                }else if(no.equals("3")){

                    orders.add(ramen());    //라면

                }else if(no.equals("ok")){

                    //주문 그만 받기
                    if(orders.size() > 0){
                        //1개 이상인 경우
                        calculator(orders, customer);
                        
                        System.out.println("쉐프에게 전달되어 요리중입니다.");

                        break;

                    }else{
                        //0개 이하인 경우
        
                        System.out.println("최소 1개 이상인 주문이 필요합니다.");
        
                    }   

                }else if(no.equals("x")){

                    //바로 이전에 등록한 내역 삭제
                    x(orders);

                }else if(no.equals("Quit")){

                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);

                }
            }catch(InputMismatchException e){

                System.out.println("숫자로 입력해주세요.");

            }catch(Exception e){

                System.out.println("금액이 부족합니다.");

            }
        }

        return orders;

    }

    //주문 순번 받기
    String procedure(){
        System.out.println("1. 김밥류");
        System.out.println("2. 돈까스류");
        System.out.println("3. 라면류");
        System.out.println("ok, 주문완료");
        System.out.println("x, 방금전 주문 취소");
        System.out.println("Quit, 프로그램 종료");

        String no = scn.nextLine();
        scn.nextLine();

        //만약 다른 것을 눌렀을 때 다시 실행
        while(!(no.equals("1") || no.equals("2") || no.equals("3") || no.equals("ok") || no.equals("x") || no.equals("Quit"))){

            System.out.println("1. 김밥류");
            System.out.println("2. 돈까스류");
            System.out.println("3. 라면류");
            System.out.println("ok, 주문완료");
            System.out.println("x, 방금전 주문 취소");
            System.out.println("Quit, 프로그램 종료");

            no = scn.nextLine();
            scn.nextLine();

        }

        return no;

    }

    //김밥 주문 받기
    KimbapOrder kimbap(){
        
        System.out.println("1. 참치김밥");
        System.out.println("2. 땡초김밥");
        System.out.println("3. 야채김밥");

        int no = scn.nextInt();
        scn.nextLine();

        //다른 순번 눌렀을 때 다시 받기
        while(no < 1 || no > 3){

            System.out.println("1. 참치김밥");
            System.out.println("2. 땡초김밥");
            System.out.println("3. 야채김밥");
    
            no = scn.nextInt();
            scn.nextLine();
    
        }

        if(no == 1){

            return new TunaKimbapOrder(num());

        }else if(no == 2){

            return new TengchoKimbapOrder(num());

        }else{

            return new VegetableKimbapOrder(num());

        }

    }

    //돈까스 주문 받기
    PorkOrder pork(){

        System.out.println("1. 치즈돈까스");
        System.out.println("2. 고구마돈까스");
        System.out.println("3. 생선까스");

        int no = scn.nextInt();
        scn.nextLine();

        //주문 다른 것을 눌렀을 때 확인
        while(no < 1 || no > 3){

            System.out.println("1. 치즈돈까스");
            System.out.println("2. 고구마돈까스");
            System.out.println("3. 생선까스");
    
            no = scn.nextInt();
            scn.nextLine();
    
        }

        if(no == 1){
            
            return new CheesePorkOrder(num());

        }else if(no == 2){

            return new SweetPotatoPorkOrder(num());

        }else{

            return new FishPorkOrder(num());

        }
    }

    //라면 주문 받기
    RamenOrder ramen(){

        System.out.println("1. 부대찌개라면");
        System.out.println("2. 기본라면");
        System.out.println("3. 치즈라면");

        int no = scn.nextInt();
        scn.nextLine();

        //주문 다른 것을 눌렀을 때
        while(no < 1 || no > 3){

            System.out.println("1. 부대찌개라면");
            System.out.println("2. 기본라면");
            System.out.println("3. 치즈라면");
    
            no = scn.nextInt();
            scn.nextLine();
    
        }

        if(no == 1){
            
            return new BagStewRamenOrder(num());

        }else if(no == 2){

            return new OriginRamenOrder(num());

        }else{

            return new CheeseRamenOrder(num());

        }
    }

    //수량 받기
    int num(){

        System.out.println("수량은?");

        int num = scn.nextInt();
        scn.nextLine();

        while(num <= 0){

            System.out.println("0 이상의 숫자를 입력해주세요. 수량은?");

            num = scn.nextInt();
            scn.nextLine();
    
        }
    
        return num;

    }

    //계산하기
    void calculator(ArrayList<Order> orders, Customer cu) throws Exception{

        int allPrice = 0;
        int kimbapNum = 0;
        int porkNum = 0;
        int ramenNum = 0;

        for(Order o: orders){

            allPrice += o.price * o.num;

            if(o instanceof KimbapOrder){

                kimbapNum += o.num; //주문 내의 김밥 개수
                
            }else if(o instanceof PorkOrder){

                porkNum += o.num; //주문 내의 돈까스 개수

            }else if(o instanceof RamenOrder){

                ramenNum += o.num; //주문 내의 라면 개수
                
            }

        }

        System.out.println("김밥은 " + kimbapNum + "개, 돈까스는 " + porkNum + "개, 라면은 " + ramenNum + "개 주문하셨습니다.");
        System.out.println("총 금액은 " + allPrice +"원 입니다.");

        income += cu.pay(allPrice); //계산

    }

    //이전 주문 취소
    void x(ArrayList<Order> orders){

        if(orders.size() > 0){
            //1개 이상인 경우
        
            orders.remove(orders.size() - 1);

        }else{
            //0개 이하인 경우

            System.out.println("최소 1개 이상인 주문이 필요합니다.");

        }

    }

}