import java.util.Scanner;

public class ForLoop {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        Boolean reTry = true;

        //for문으로 루프
        for(;reTry==true;){
            String name = inputName();
            int score = inputScore(name);
            String grade = getGradeCount(score);
            System.out.println(name + "의 등급은 " + grade + "입니다.");
            String reTake = shouldReTake(grade);
            System.out.println(name + "은 재수강이 " + reTake + "입니다.");
            reTry = inputReTry();
        }
        
    }

    //1. 학생 이름과 성적 터미널에서 받기
    static String inputName(){
        
        System.out.println("학생의 이름을 입력하세요:");
        String name = scn.nextLine();
        scn.nextLine();

        return name;

    }

    static int inputScore(String name){

        System.out.println(name+"의 성적을 입력하세요:");
        int score = scn.nextInt();
        scn.nextLine();

        return score;

    }

    //2. 성적 나누기
    static String getGradeCount(int score){

        String grade;

        if(score == 100){
            grade = "S";    
        }else if(score >= 95 && score <= 99){
            grade="A+";
        }else if(score >= 90 && score <= 94){
            grade="A0";
        }else if(score >= 85 && score <= 89){
            grade="B+";
        }else if(score >= 80 && score <= 84){
            grade="B0";
        }else if(score >= 75 && score <= 79){
            grade="C+";
        }else if(score >= 70 && score <= 74){
            grade="C0";
        }else if(score >= 65 && score <= 69){
            grade="D+";
        }else if(score >= 60 && score <= 64){
            grade="D0";
        }else{
            grade="F";
        }

        return grade;

    }

    //3. 재수강 유무
    static String shouldReTake(String grade){

        String reTake;

        if(grade == "S" || grade == "A+" || grade == "A0" || grade == "B+" || grade == "B0"){
            reTake = "필요없음";
        }else if(grade == "C+" || grade == "C0" || grade == "D+" || grade == "D0"){            
            reTake = "재수강 권장";
        }else{
            reTake = "재수강 필요";
        }

        return reTake;

    }

    //4. 재수강 권장, 필요 시 다시 진행
    static Boolean inputReTry(){

        System.out.println("다시 확인하시겠습니까?(Y/N)");
            
        String reTry = scn.nextLine();
        scn.nextLine();

        if(reTry.equals("Y")){
            return true;
        }else if(reTry.equals("N")){
            return false;
        }else{
            System.out.println("Y와 N 중 입력하시지 않아 자동으로 취소됩니다.");
            return true;
        }

    }

}