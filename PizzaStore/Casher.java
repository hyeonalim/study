import java.util.Scanner;

public class Casher {

    int income; //가게 돈
    Scanner scn = new Scanner(System.in); //스캐너 불러오기

    //인사하기
    void hi(){

        System.out.println("어서오세요.");

    }

    //주문받기
    void getOrder(Customer cu) throws Exception{

        System.out.println(cu.name() + "님, 주문하시겠습니까?(Y/N)");

        String order = scn.nextLine();
        scn.nextLine();

        if(order.equals("Y")){
            
            Order od = new Order(); //주문서 만들기

            //기본 피자 가격 +1000
            int price = makeOrder(od) + 1000;
            
            askPay(cu, price); //price는 위의 1000원을 가져옴

            return od;   
        }else{
            System.out.println("나가시는 문은 왼쪽입니다.");

            return null;
        }
                
    }

    //주문 받기
    int makeOrder(Order od){
        
        int price = 0;

        //치즈받기
        System.out.println("치즈 양을 선택해주세요.(10/20/50)");
        od.amountCheese = scn.nextInt();
        scn.nextLine();

        //올리브받기
        System.out.println("올리브를 넣을까요?(Y/N)(500원 추가)");
        String addOlive = scn.nextLine();
        scn.nextLine();

        if(addOlive.equals("Y")){
            od.putOlive = true;
            price += 500;            
        }else if(addOlive.equals("N")){
            od.putOlive = false;
            System.out.println("올리브는 안 넣겠습니다.");
        }

        //불고기받기
        System.out.println("불고기를 넣을까요?(Y/N)(1000원 추가)");
        String addBeaf = scn.nextLine();
        scn.nextLine();

        if(addBeaf.equals("Y")){
            od.putBeaf = true;
            price += 1000;
        }else if(addBeaf.equals("N")){
            od.putBeaf = false;
            System.out.println("불고기는 안 넣겠습니다.");
        }

        //페퍼로니 받기
        System.out.println("페퍼로니를 넣을까요?(Y/N)(1500원 추가)");
        String addPepperoni = scn.nextLine();
        scn.nextLine();

        if(addPepperoni.equals("Y")){
            od.putPepperoni = true;
            price += 1500;
        }else if(addPepperoni.equals("N")){
            od.putPepperoni = false;
            System.out.println("페퍼로니는 안 넣겠습니다.");
        }

        return price;

        }
    

    //수입 증가 확인
    void askPay(Customer cu, int price) throws Exception{

        System.out.println("피자의 가격은 "+price+"입니다.");
        income += cu.pay(price);
        System.out.println("수입이 "+price+"증가해서 현재"+income+"가지고 있습니다.");

    }
}
