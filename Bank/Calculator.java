import java.util.Scanner;

public class Calculator {

    Scanner scn = new Scanner(System.in);

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
