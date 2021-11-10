import java.util.Scanner;

public class PizzaRestarant {
    
    Server sv;
    Chef ch;
    Casher cs;
    
    //레스토랑 직원들
    public PizzaRestarant() {

        this.sv = new Server();
        this.ch = new Chef();
        this.cs = new Casher();
        this.cs.sv = this.sv;
        this.cs.ch = this.ch;

      }

    //레스토랑 프로세스
    void run(){

        Customer cst = new Customer();

        cs.hi();
        cs.getOrder(cst);
        
    }

    boolean inputNext(){

        System.out.println("다음 손님을 받겠습니까?(Y/N)");

        Scanner scn = new Scanner(System.in); //스캐너 불러오기
        String next = scn.nextLine();
        scn.nextLine();

        if(next.equals("Y")){
            return true;
        }else if(next.equals("N")){
            return false;
        }else{
            System.out.println("Y와 N 중 입력하시지 않아 자동으로 취소됩니다.");
            return true;
        }
    }

}
