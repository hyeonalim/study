import java.util.Scanner;

public class Customer {
    String name;
    Info info;

    Scanner scn = new Scanner(System.in);

    //인사
    String name() throws Exception{

        System.out.println("제 이름은 ");
        name = scn.nextLine();
        scn.nextLine();

        //이름에 숫자가 들어갈 경우, 예외처리
        if(name.matches(".*[0-9].*")){

            Exception e = new Exception("이름에 숫자가 들어가 있습니다.");
            throw e;

        }

        return name;

    }

    //카드 비밀번호 길이 예외
    int accountPwdCheck(int accountPwd) throws Exception{
        
        String accountStr = Integer.toString(accountPwd);

        if(accountStr.length() == 4){

            System.out.println(accountPwd + "로 계좌 비밀번호를 저장하겠습니다.");

        }else{

            Exception e = new Exception("계좌 비밀번호 길이는 네자리여야 합니다.");
            throw e;

        }

        return accountPwd;
    }

    
    //카드 비밀번호 길이 예외
    int cardPwdCheck(int cardPwd) throws Exception{
        
        String cardStr = Integer.toString(cardPwd);

        if(cardStr.length() == 4){

            System.out.println(cardPwd + "로 카드 비밀번호를 저장하겠습니다.");

        }else{

            Exception e = new Exception("카드 비밀번호 길이는 네자리여야 합니다.");
            throw e;

        }

        return cardPwd;
    }

    //입금 원하는 금액
    int dpSpend(int depositMoney, Info info){

        System.out.println(info.money + "를 가지고 있습니다.");
        info.money += depositMoney;                         
        System.out.println(depositMoney + "원이 입금되어 은행에 돈을 " + info.money + "원 맡기셨습니다.");                         

        return info.money;
    }

    //출금 원하는 금액
    int wdSpend(int withdrawMoney, Info info) throws Exception{

        //예외 만들기
        if(info.money >= withdrawMoney){
                
            System.out.println(info.money + "를 가지고 있습니다.");
            info.money -= withdrawMoney;
            System.out.println("남은 돈은 " + info.money + "입니다.");                            
                
        }else{

            Exception e = new Exception("가지고 있는 돈이 부족합니다.");
            throw e;

        }

        return withdrawMoney;
    }
    
}
