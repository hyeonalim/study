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

    //업무 선택
    Info help(Customer cu) throws Exception{

        Info info = new Info(); //새로운 회원정보 만들기

        System.out.println(cu.name() + "님, 무엇을 도와드릴까요?");
        System.out.println("우선 현재 가지고 계신 정보를 입력해주세요.");

        getInfo();

        System.out.println("카드/통장 개설, 입출금, 예적금, 대출 중 입력해주세요.");
        
        String help = scn.nextLine();
        scn.nextLine();

        //해당하는 도움을 필요로 했을 때
        if(help.equals("카드/통장 개설") || help.equals("입출금") || help.equals("예적금") || help.equals("대출")){

            System.out.println(help + "업무를 도와드리겠습니다.");

            if(help.equals("카드/통장 개설")){
                
                make();
                
            }else if(help.equals("입출금")){
                
                deposit();

            }else if(help.equals("예적금")){

                savings();

            }else if(help.equals("대출")){
                
                loan();

            }

            return info;

        }else{
            System.out.println("도와드릴 수 없는 업무입니다..");

            return null;
        }

    }
    
    //내 정보 받기
    Info getInfo(){

        System.out.println("통장이 있으신가요?(Y/N)");
        String account = scn.nextLine();
        scn.nextLine();

        if(account.equals("Y")){
        
            info.account = true;
            
            System.out.println("통장 비밀번호를 입력해주세요.");
            int accountPwd = scn.nextInt();
            scn.nextLine();
            info.accountPwd = accountPwd;

            System.out.println("은행 내 금액을 입력해주세요.");
            int money = scn.nextInt();
            scn.nextLine();
            info.money = money;

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
            info.cardPwd = cardPwd;

            System.out.println("은행 내 금액을 입력해주세요.");
            int money = scn.nextInt();
            scn.nextLine();
            info.money = money;

        }else{

            info.card = false;

            System.out.println("통장이 없으시군요.");

        }

        return info;
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
    int deposit() throws Exception{

        System.out.println("입출금을 진행하겠습니다.(입금/출금)");
        want = scn.nextLine();
        
        //입금/출금
        if(want.equals("입금")){

            System.out.println("입금을 진행합니다.");
            System.out.println("얼마를 입금하시겠습니까?");
            int depositMoney = scn.nextInt();
            
            System.out.println(depositMoney + "원 입금을 진행하겠습니다.");

            info.money += cu.dpSpend(depositMoney);

            System.out.println("현재 통장에 " + info.money + "입니다.");   

        }else if(want.equals("출금")){

            System.out.println("출금을 진행합니다.");

            System.out.println("얼마를 출금하시겠습니까?");
            int withdrawMoney = scn.nextInt();

            System.out.println("은행을 선택해주세요.");
            String bank = scn.nextLine();
            scn.nextLine();
            
            System.out.println("계좌를 입력해주세요.");
            long withdrawBank = scn.nextLong();
            scn.nextLine();

            System.out.println(withdrawMoney + "원 출금을 진행하겠습니다.");

            info.money += cu.wdSpend(withdrawMoney);
            
            System.out.println(bank + "의 " + withdrawBank + "계좌로 " + withdrawMoney + "원 입금을 진행하겠습니다.");

            info.money -= withdrawMoney;

            System.out.println("현재 통장엔 " + info.money + "원 있습니다.");

        }

        return info.money;

    }

    //예적금
    void savings(){

        System.out.println("예적금을 소개하겠습니다.");
        System.out.println("기본 2.0% 이자가 지급됩니다.");

        //이자 추가
        int interestRate = 2;

        System.out.println("1년부터 최소 3년까지 계약 가능하며, 계약 기간에 따라 이자가 지급됩니다. 몇 년 진행하시겠습니까?(1/2/3)");
        System.out.println("1년: 1%, 2년: 2%, 3년: 3%");
        
        int year = scn.nextInt();
        scn.nextLine();

        int month = 0; //이자 계산할 때 쓰일 개월 수

        if(year == 1){
            
            interestRate += 1;
            month = 12;
        
        }else if(year == 2){

            interestRate += 2;
            month = 24;

        }else if(year == 3){

            interestRate += 3;
            month = 36;
            
        }

        System.out.println("직장인으로 매달 월급이 입금되면 2% 이자가 더 추가됩니다.(Y/N)");

        String checkOne = scn.nextLine();
        scn.nextLine();

        if(checkOne.equals("Y")){
        
            interestRate += 2;
        
        }else if(checkOne.equals("N")){
        
            System.out.println("월급 입금으로는 이자가 추가되지 않았습니다.");
        
        }

        System.out.println("마케팅 동의를 해주시면 1% 이자가 더 추가됩니다. (Y/N)");
        
        String checkTwo = scn.nextLine();
        scn.nextLine();
        
        if(checkTwo.equals("Y")){

            interestRate += 1;

        }else if(checkTwo.equals("N")){

            System.out.println("마케팅 동의로는 이자가 추가되지 않았습니다.");

        }

        System.out.println("총 " + interestRate + "%의 이자가 지급될 예정입니다.");

        //매달 입금 금액, 계산기

        System.out.println("매달 얼마를 입금하시겠습니까?");
        
        int addMoney = scn.nextInt();
        scn.nextLine();

        int interest = 0;

        for(int i = 1; i<=month; i++){
        
            interest += addMoney*(interestRate/100)*month/12; //이자
        
        }

        int matured = addMoney*12 + interest;

        System.out.println("매달 " + addMoney + "원을 입금하시면, " + interestRate + "% 이자로 만기 시, " + matured + "받으실 수 있습니다.");

    }

    //대출받기
    void loan(){

        System.out.println("대출을 소개드리겠습니다.");
        System.out.println("기본 4% 이자가 붙게 됩니다.");

        int loanRate = 4;

        System.out.println("얼마를 빌리겠습니까?");

        long loanMoney = scn.nextLong();
        scn.nextLine();

        System.out.println("몇 일 동안 빌리시겠습니까?");
        int day = scn.nextInt();
        scn.nextLine();

        //대출 계산기
        long interest = (loanMoney*loanRate/100)*day/365;
        
        System.out.println(loanMoney + "원을 빌리면, 매달 " + interest + "이자를 갚아야 합니다.");

    }
}
