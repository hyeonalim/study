package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Output {

    public void writer(String book, String member){
        System.out.println("1. 책 2. 회원");

        int sideNo = sideNoCheck();

        if(sideNo == 1){

            System.out.println("책을 작성합니다.");

            writerBook(book);

        }else{

            System.out.println("회원을 작성합니다.");

            writerMember(member);

        }
    }

    //2. 책 쓰기
    private void writerBook(String book){
        try{

            Scanner scn = new Scanner(System.in);
            String bookName = scn.nextLine();
            scn.nextLine();
            
            FileOutputStream fio = new FileOutputStream(book, true);
            
            for(byte b: bookName.getBytes()){
                fio.write(b);
            }

            fio.write('\r');
            fio.close();

        }catch(IOException e){

            //read(), close() 구문이 예외로 IOException를 던져줘서 e로 지정
            //FileNotFoundException(child)는 IOException(parnet)를 상속하고 있기 때문에 e를 포함하고 있다
            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }
    }
    
    //2. 회원 쓰기
    private void writerMember(String member){
        try{

            Scanner scn = new Scanner(System.in);
            String memberName = scn.nextLine();
            scn.nextLine();
            
            FileOutputStream fio = new FileOutputStream(member, true);
            
            for(byte b: memberName.getBytes()){
                fio.write(b);
            }

            fio.write('\r');
            fio.close();

        }catch(IOException e){

            //read(), close() 구문이 예외로 IOException를 던져줘서 e로 지정
            //FileNotFoundException(child)는 IOException(parnet)를 상속하고 있기 때문에 e를 포함하고 있다
            if(e instanceof FileNotFoundException){
                
                System.out.println("파일이 없습니다.");

            }else{

                System.out.println("다시 확인해주세요.");

            }
        }
    }

    //숫자 잘못 입력한 경우
    private int sideNoCheck(){

        Scn scn = new Scn();

        System.out.println("1 또는 2 를 입력해주세요.");

        int check = scn.scnInt();

        while(check < 1 || check > 2){

            System.out.println("1 또는 2 를 입력해주세요.");

            check = scn.scnInt();

        }

        return check;
    }
}
