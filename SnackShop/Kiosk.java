import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    
    int income;
    Scanner scn = new Scanner(System.in);

    void hi(){
        System.out.println("어서오세요, 주문해주세요.");
    }

    ArrayList<Cook> order(Customer cu) throws Exception{

        boolean loop = true;
        int i = -1;

        ArrayList<Cook> cooks = new ArrayList<>();
        
        while(loop){

            System.out.println("1. 김밥류");
            System.out.println("2. 돈까스류");
            System.out.println("3. 라면류");
            System.out.println("ok, 주문완료");
            System.out.println("x, 방금전 주문 취소");
            System.out.println("Quit, 프로그램 종료");

            String no = scn.nextLine();
            scn.nextLine();

            Cook cook = new Cook();

            if(no.equals("1")){

                kimbap(cooks, cook);

            }else if(no.equals("2")){

                pork(cooks, cook);

            }else if(no.equals("3")){

                ramen(cooks, cook);

            }else if(no.equals("ok")){

                if(cooks.size() > 0){

                    calculate(cooks, cu);
                    System.out.println("쉐프에게 전달되어 요리중입니다.");

                    loop = false;
                    
                }else{

                    System.out.println("주문한 내역이 없습니다.");

                }

                
            }else if(no.equals("x")){

                if(i > 0){

                    cooks.remove(i-1);
                    i = i - 2;

                }else if(i == 0){

                    cooks.remove(0);
                    i = i - 2;

                }else{

                    System.out.println("주문한 내역이 없습니다.");

                }

            }else if(no.equals("Quit")){

                loop = false;

                SnackShop snackShop = new SnackShop();
                snackShop.loop();

            }else{

                Exception e = new Exception();
                throw e;

            }

            i++;

        }

        return cooks;
        
    }

    void kimbap(ArrayList<Cook> cooks, Cook cook){

        System.out.println("1. 참치김밥");
        System.out.println("2. 땡초김밥");
        System.out.println("3. 야채김밥");

        int no = scn.nextInt();
        scn.nextLine();

        cook.kind = "김밥";

        if(no == 1){
            
            cook.name = "참치";
            cook.price = 2000;

        }else if(no == 2){

            cook.name = "땡초";
            cook.price = 2000;

        }else if(no == 3){

            cook.name = "야채";
            cook.price = 1400;

        }

        cook.num = num();

        cooks.add(cook);

        System.out.println(cook);

    }

    void pork(ArrayList<Cook> cooks, Cook cook){
        
        System.out.println("1. 치즈돈까스");
        System.out.println("2. 고구마돈까스");
        System.out.println("3. 생선까스");

        int no = scn.nextInt();
        scn.nextLine();

        cook.kind = "돈까스";

        if(no == 1){
            
            cook.name = "치즈";
            cook.price = 3000;

        }else if(no == 2){
            
            cook.name = "고구마";
            cook.price = 3500;

        }else if(no == 3){

            cook.name = "생선";
            cook.price = 2300;

        }

        cook.num = num();

        cooks.add(cook);

        System.out.println(cook);
        
    }

    void ramen(ArrayList<Cook> cooks, Cook cook){

        System.out.println("1. 부대찌개라면");
        System.out.println("2. 기본라면");
        System.out.println("3. 치즈라면");

        int no = scn.nextInt();
        scn.nextLine();

        cook.kind = "라면";

        if(no == 1){
            
            cook.name = "부대찌개";
            cook.price = 3000;

        }else if(no == 2){

            cook.name = "기본";
            cook.price = 1000;

        }else if(no == 3){

            cook.name = "치즈";
            cook.price = 1500;

        }

        cook.num = num();

        cooks.add(cook);

        System.out.println(cook);
        
    }

    int num(){

        System.out.println("수량은?");
        int num = scn.nextInt();
        scn.nextLine();

        return num;

    }

    void calculate(ArrayList<Cook> cooks, Customer cu) throws Exception{

        int price = 0;
        int kimbapNum = 0;
        int porkNum = 0;
        int ramenNum = 0;

        for(int i = 0; i < cooks.size(); i++){
            
            Cook cook = cooks.get(i);

            price += cook.price * cook.num;

            if(cook.kind.equals("김밥")){

                kimbapNum += cook.num;

            }else if(cook.kind.equals("돈까스")){

                porkNum += cook.num;

            }else if(cook.kind.equals("라면")){

                ramenNum += cook.num;

            }

        }

        System.out.println("손님께서는 김밥 " + kimbapNum + "개, 돈까스 " + porkNum +" 개, 라면" + ramenNum + "개를 주문하셨습니다.");
        System.out.println("총 금액은 " + price + "원입니다.");
        income += cu.pay(price);

    }

}
