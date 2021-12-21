package file;

import java.io.File;
import java.io.IOException;

public class Create {
    
    public void creater(String book, String member){
        System.out.println("1. 책 2. 회원");

        int sideNo = sideNoCheck();

        if(sideNo == 1){

            System.out.println("책을 작성합니다.");

            createrBook(book);

        }else{

            System.out.println("회원을 작성합니다.");

            createrMember(member);

        }
    }

    private void createrBook(String book){
        File fileBook = new File(book);

        try{
            if (fileBook.createNewFile()) {

                System.out.println("책 생성");

            }else{

                System.out.println("이미 만들어져 있습니다.");

            }
        }catch(IOException e){

            System.out.println("다시 확인해주세요.");

        }

    }

    private void createrMember(String member){

        File fileMember = new File(member);

        try{
            if (fileMember.createNewFile()) {

                System.out.println("회원 생성");

            }else{

                System.out.println("이미 만들어져 있습니다.");

            }
        }catch(IOException e){

            System.out.println("다시 확인해주세요.");

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
