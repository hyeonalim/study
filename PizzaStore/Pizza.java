import java.util.Scanner;

public class Pizza {
    
    int cheese; //치즈
    boolean olive; //올리브
    boolean beaf; //불고기
    boolean pepperoni; //페퍼로니
    
    Scanner scn = new Scanner(System.in); //스캐너 불러오기

    int addCheese(){

        System.out.println("치즈 양을 선택해주세요.(10/20/50)");
        cheese = scn.nextInt();
        scn.nextLine();
        
        return cheese;

    }

    Boolean addOlive(){

        System.out.println("올리브를 넣을까요?(Y/N)(500원 추가)");
        String addOlive = scn.nextLine();
        scn.nextLine();

        if(addOlive.equals("Y")){
            olive = true;
        }else if(addOlive.equals("N")){
            olive = false;
        }

        return olive;

    }

    Boolean addBeaf(){

        System.out.println("불고기를 넣을까요?(Y/N)(1000원 추가)");
        String addBeaf = scn.nextLine();
        scn.nextLine();

        if(addBeaf.equals("Y")){
            beaf = true;
        }else if(addBeaf.equals("N")){
            beaf = false;
        }
        
        return beaf;

    }

    Boolean addPepperoni(){

        System.out.println("페퍼로니를 넣을까요?(Y/N)(1500원 추가)");
        String addPepperoni = scn.nextLine();
        scn.nextLine();

        if(addPepperoni.equals("Y")){
            pepperoni = true;
        }else if(addPepperoni.equals("N")){
            pepperoni = false;
        }

        return pepperoni;

    }
}
