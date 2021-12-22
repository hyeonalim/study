package file;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

    SideNoCheck sideNoCheck = new SideNoCheck();
    Scn scn = new Scn();

    public void writer(String book, String member){
        System.out.println("1. 책 2. 회원");

        int sideNo = sideNoCheck.sideNoCheck();

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

            String bookName = scn.scnString();

            //1. FileOutputStream 사용
            /*FileOutputStream fio = new FileOutputStream(book, true);
            
            for(byte b: bookName.getBytes()){
                fio.write(b);
            }*/

            //2. BufferedWriter 사용
            //BufferedWriter: Writer를 매개변수로 받음
            BufferedWriter fio = new BufferedWriter(new FileWriter(book, true));
            fio.write(bookName);

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

            String memberName = scn.scnString();
            
            //1. FileOutputStream 사용
            /*FileOutputStream fio = new FileOutputStream(member, true);
            
            for(byte b: memberName.getBytes()){
                fio.write(b);
            }*/

            //2. BufferedWriter 사용
            BufferedWriter fio = new BufferedWriter(new FileWriter(member, true));
            fio.write(memberName);

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

}
