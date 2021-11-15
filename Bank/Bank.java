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
            
            bker.getInfo();
            bker.help(cu);
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        
        }
    }

    //다른 업무 찾기
    boolean inputWork(){

        System.out.println("다른 업무를 확인해드릴까요? (Y/N)");

        Scanner scn = new Scanner(System.in); //스캐너 불러오기
        String work = scn.nextLine();
        scn.nextLine();

        if(work.equals("Y")){
            return true;
        }else if(work.equals("N")){
            return false;
        }else{
            System.out.println("Y와 N 중 입력하시지 않아 자동으로 취소됩니다.");
            return false;
        }
    }

}
