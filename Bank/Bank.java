import java.util.Scanner;

public class Bank {
    
    Banker bker;
    Info info;

    //은행 직원들
    public Bank(){

        this.bker = new Banker();

    }

    void run(){

        Customer cu = new Customer();

        bker.hi();
        try{
            bker.help(cu);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("실패");
        }
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
            return false;
        }
    }

}
