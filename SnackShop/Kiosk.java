import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    
    int income = 0;
    Scanner scn = new Scanner(System.in);

    ArrayList<Order> run(Customer cu) throws Exception{

        ArrayList<Order> orders = new ArrayList<>();
        
        while(true){

            System.out.println("1. 김밥류");
            System.out.println("2. 돈까스류");
            System.out.println("3. 라면류");
            System.out.println("ok, 주문완료");
            System.out.println("x, 방금전 주문 취소");
            System.out.println("Quit, 프로그램 종료");

            String no = scn.nextLine();
            scn.nextLine();

            try{
                if(no.equals("1")){

                    kimbap();

                }else if(no.equals("2")){

                    pork();

                }else if(no.equals("3")){

                    ramen();

                }else if(no.equals("ok")){

                    if(cooks.size() > 0){

                        calculate(cooks, cu);
                        System.out.println("쉐프에게 전달되어 요리중입니다.");
                
                    }else{
    
                        System.out.println("주문한 내역이 없습니다.");

                    }

                }else if(no.equals("x")){

                    if(orders.size() > 0){
        
                        cooks.remove(orders.size()-1);
                            
                    }else if(orders.size() == 0){

                        cooks.remove(0);
    
                    }else{

                        System.out.println("주문한 내역이 없습니다.");

                    }

                }else if(no.equals("Quit")){
                    
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);

                }else{

                    System.out.println("잘못 입력하셨습니다.");

                }
            }catch(InputMismatchException e){
                
                System.out.println("숫자를 입력해주세요.");

            }catch(Exception e){
            
                System.out.println("금액 부족");

            }
        }
     
        return orders;
        
    }

    KimbapOrder kimbap() throws Exception{

        System.out.println("1. 참치김밥");
        System.out.println("2. 땡초김밥");
        System.out.println("3. 야채김밥");

        int no = scn.nextInt();
        scn.nextLine();

         while(no < 1 || no > 3){
            System.out.println("다시 눌러주세요.");

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

    PorkOrder pork() throws Exception{
        
        System.out.println("1. 치즈돈까스");
        System.out.println("2. 고구마돈까스");
        System.out.println("3. 생선까스");

        int no = scn.nextInt();
        scn.nextLine();

        while(no < 1 || no > 3){
            System.out.println("다시 눌러주세요.");

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

    RamenOrder ramen() throws Exception{

        System.out.println("1. 부대찌개라면");
        System.out.println("2. 기본라면");
        System.out.println("3. 치즈라면");

        int no = scn.nextInt();
        scn.nextLine();

        while(no < 1 || no > 3){
            System.out.println("다시 눌러주세요.");

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

    int num() throws Exception{

        System.out.println("수량은?");
        int num = scn.nextInt();
        scn.nextLine();

        while(num <= 0){
            System.out.println("다시 눌러주세요.");

            System.out.println("수량은?");
            num = scn.nextInt();
            scn.nextLine();
    
        }

        return num;

    }
    
    void calculate(ArrayList<Order> orders, Customer cu) throws Exception{

        int totalPrice = 0;

        for(Order o: orders){
            
            totalPrice += o.price * o.num;

        }

        System.out.println("총 금액은 " + totalPrice + "원입니다.");

        income += cu.pay(price);

    }

}
