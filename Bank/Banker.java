import java.util.Scanner;

public class Banker {

    String want;

    Scanner scn = new Scanner(System.in);

    Info info = new Info();
    Customer cu = new Customer();
    
    //인사
    void hi(){

        System.out.println("안녕하세요.");

    }

    //정보 입력 부탁
    //내 정보 받기
    Info getInfo() throws Exception{

        System.out.println("우선 현재 가지고 계신 정보를 입력해주세요.");

        System.out.println("통장이 있으신가요?(Y/N)");
        String account = scn.nextLine();
        scn.nextLine();

        if(account.equals("Y")){
        
            info.account = true;
            
            System.out.println("통장 비밀번호를 입력해주세요.");
            int accountPwd = scn.nextInt();
            scn.nextLine();

            String accountStr = Integer.toString(accountPwd);

            if(accountStr.length() == 4){

                info.accountPwd = accountPwd;
                System.out.println(accountPwd + "로 카드 비밀번호를 저장하겠습니다.");
    
            }else{
    
                Exception e = new Exception("카드 비밀번호 길이는 네자리여야 합니다.");
                throw e;
    
            }

        }else{

            info.account = false;
            
            System.out.println("통장이 없으시군요.");

        }

        System.out.println("카드가 있으신가요?(Y/N)");
        String card = scn.nextLine();
        scn.nextLine();

        if(card.equals("Y")){
        
            info.card = true;

            System.out.println("카드 비밀번호를 입력해주세요.");
            int cardPwd = scn.nextInt();
            scn.nextLine();
            

            String cardStr = Integer.toString(cardPwd);

            if(cardStr.length() == 4){

                info.cardPwd = cardPwd;
                System.out.println(cardPwd + "로 카드 비밀번호를 저장하겠습니다.");
    
            }else{
    
                Exception e = new Exception("카드 비밀번호 길이는 네자리여야 합니다.");
                throw e;
    
            }


        }else{

            info.card = false;

            System.out.println("카드가 없으시군요.");

        }

        if(account.equals("Y") || card.equals("Y")){

            System.out.println("은행 내 금액을 입력해주세요.");
            int money = scn.nextInt();
            scn.nextLine();
            info.money = money;

        } else{
            System.out.println("통장이나 카드를 개설할 필요가 있습니다.");
        }

        return info;
    }
    
    //업무 선택
    Info help(Customer cu) throws Exception{

        Calculator cc = new Calculator(); //계산기 만들기

        System.out.println(cu.name() + "님, 무엇을 도와드릴까요?");

        System.out.println("카드/통장 개설, 입출금, 예적금, 대출 중 입력해주세요.");
        
        String help = scn.nextLine();
        scn.nextLine();

        //해당하는 도움을 필요로 했을 때
        if(help.equals("카드/통장 개설") || help.equals("입출금") || help.equals("예적금") || help.equals("대출")){

            System.out.println(help + "업무를 도와드리겠습니다.");

            if(help.equals("카드/통장 개설")){
                
                make();
                
            }else if(help.equals("입출금")){
                
                dpAndWd();

            }else if(help.equals("예적금")){

                cc.savings();

            }else if(help.equals("대출")){
                
                cc.loan();

            }

            return info;

        }else{
            System.out.println("도와드릴 수 없는 업무입니다..");

            return null;
        }

    }
    
    //카드/통장 개설
    void make() throws Exception{
        
        System.out.println("통장/카드 중 무엇을 개설하길 원하시나요?(통장/카드)");
        want = scn.nextLine();
       
        if(want.equals("통장")){
            
            info.account = true;
            
            //통장 비번 설정
            System.out.println("통장 비밀번호를 설정해주세요.");
            int accountPwd = scn.nextInt();

            //통장 비번 길이 체크
            info.accountPwd = cu.accountPwdCheck(accountPwd);
            
        }else if(want.equals("카드")){

            info.card = true;
            
            //카드 비번 설정
            System.out.println("카드 비밀번호를 설정해주세요.");
            int cardPwd = scn.nextInt();

            //카드 비번 길이 체크
            info.cardPwd = cu.cardPwdCheck(cardPwd);

        }

    }

    //입출금
    void dpAndWd() throws Exception{

        System.out.println("입출금을 진행하겠습니다.(입금/출금)");
        want = scn.nextLine();
        scn.nextLine();
        
        //입금/출금
        if(want.equals("입금")){

            System.out.println("입금을 진행합니다.");
            System.out.println("통장이나 카드를 선택해주세요.");
            String choose = scn.nextLine();
            scn.nextLine();
            
            if(choose.equals("카드")){
                System.out.println("카드 비밀번호를 입력해주세요.");
                int inputCardPwd = scn.nextInt();
                scn.nextLine();

                System.out.println(inputCardPwd + "를 카드 비밀번호로 입력하셨습니다.");

                if(inputCardPwd == info.cardPwd){
                    
                    //입금 메소드 진행
                    deposit();

                }else{
                    
                    Exception e = new Exception("카드 비밀번호를 잘못 입력하셨습니다.");
                    throw e;

                }
            }else if(choose.equals("통장")){
                
                System.out.println("통장 비밀번호를 입력해주세요.");
                int inputAccountPwd = scn.nextInt();
                scn.nextLine();

                System.out.println(inputAccountPwd + "를 통장 비밀번호로 입력하셨습니다.");

                if(inputAccountPwd == info.accountPwd){

                    //입금 메소드 진행
                    deposit();

                }else{
                    
                    Exception e = new Exception("통장 비밀번호를 잘못 입력하셨습니다.");
                    throw e;

                }
            }

        }else if(want.equals("출금")){

            System.out.println("출금을 진행합니다.");
            System.out.println("통장이나 카드를 선택해주세요.");
            String choose = scn.nextLine();
            scn.nextLine();

            if(choose.equals("카드")){
                System.out.println("카드 비밀번호를 입력해주세요.");
                int inputCardPwd = scn.nextInt();
                scn.nextLine();

                System.out.println(inputCardPwd + "를 카드 비밀번호로 입력하셨습니다.");

                if(inputCardPwd == info.cardPwd){
                    
                    //출금 메소드 진행
                    withdraw();

                }else{
                    
                    Exception e = new Exception("카드 비밀번호를 잘못 입력하셨습니다.");
                    throw e;

                }
            }else if(choose.equals("통장")){
                
                System.out.println("통장 비밀번호를 입력해주세요.");
                int inputAccountPwd = scn.nextInt();
                scn.nextLine();

                System.out.println(inputAccountPwd + "를 통장 비밀번호로 입력하셨습니다.");

                if(inputAccountPwd == info.accountPwd){

                    //출금 메소드 진행
                    withdraw();

                }else{
                    
                    Exception e = new Exception("통장 비밀번호를 잘못 입력하셨습니다.");
                    throw e;

                }
            }

        }

    }

    //입금 메소드
    int deposit(){

        System.out.println("현재 통장엔 " + info.money + "원이 있습니다. 얼마를 입금하시겠습니까?");
        int depositMoney = scn.nextInt();
        
        System.out.println(depositMoney + "원 입금을 진행하겠습니다.");

        info.money = cu.dpSpend(depositMoney, info);

        System.out.println("현재 통장에 " + info.money + "입니다."); 

        return info.money;

    }

    //출금 메소드
    int withdraw() throws Exception{

        System.out.println("현재 통장엔 " + info.money + "원이 있습니다. 얼마를 출금하시겠습니까?");
        int withdrawMoney = scn.nextInt();

        System.out.println("은행을 선택해주세요.");
        String bank = scn.nextLine();
        scn.nextLine();
        
        System.out.println("계좌를 입력해주세요.");
        long withdrawBank = scn.nextLong();
        scn.nextLine();

        System.out.println(withdrawMoney + "원 출금을 진행하겠습니다.");

        info.money = cu.wdSpend(withdrawMoney, info);
        
        System.out.println(bank + "의 " + withdrawBank + "계좌로 " + withdrawMoney + "원 출금을 진행하겠습니다.");

        System.out.println("현재 통장엔 " + info.money + "원 있습니다.");

        return info.money;

    }
    
}
