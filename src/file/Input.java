package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    
    public void reader(String book, String member){
        System.out.println("1. 책 2. 회원");

        int sideNo = sideNoCheck();

        if(sideNo == 1){

            System.out.println("책을 읽습니다.");

            readerBook(book);

        }else{

            System.out.println("회원을 읽습니다.");

            readerMember(member);

        }
    }

    public void finder(String book, String member){
        System.out.println("1. 책 2. 회원");

        int sideNo = sideNoCheck();

        if(sideNo == 1){

            System.out.println("책을 읽습니다.");

            readerBook(book);

        }else{

            System.out.println("회원을 읽습니다.");

            readerMember(member);

        }
    }

    //1. 책 읽어오기
    private void readerBook(String book){

        try{

            FileInputStream fio = new FileInputStream(book);
            
            int r = -1;

            while((r = fio.read()) != -1){

                System.out.print((char)r);

                if(r == '\r'){

                    System.out.println();

                }
            }

            System.out.println();
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

    //2. 회원 읽어오기
    private void readerMember(String member){

        try{

            FileInputStream fio = new FileInputStream(member);
            
            int r = -1;

            while((r = fio.read()) != -1){

                System.out.print((char)r);

                if(r == '\r'){

                    System.out.println();

                }

            }

            System.out.println();
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


        //3. 책 찾아오기
        private void finderBook(String book){

            try{
    
                FileInputStream fio = new FileInputStream(book);
                
                Scanner scn = new Scanner(System.in);
                String bookName = scn.nextLine();
                scn.nextLine();

                String rString = "";
                int r = -1;

                boolean isNot = false; //유무 판단
    
                while((r = fio.read()) != -1){
    
                    rString = String.valueOf((char)r);

                    if(bookName.equals(rString)){

                        System.out.print(rString + "을 찾았습니다.");
                        isNot = true;

                        break;
                    }

                }

                if(isNot == false){

                    System.out.println("찾지 못했습니다.");

                }

                System.out.println();
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
    
        //4. 회원 찾아오기
        private void finderMember(String member){
    
            try{
    
                FileInputStream fio = new FileInputStream(member);
                
                Scanner scn = new Scanner(System.in);
                String memberName = scn.nextLine();
                scn.nextLine();

                boolean isNot = false; //유무 판단

                String rString = "";
                int r = -1;
    
                while((r = fio.read()) != -1){
    
                    rString = String.valueOf((char)r);
                    
                    if(memberName.equals(rString)){

                        System.out.print(rString + "을 찾았습니다.");
                        isNot = true;

                    }
                }

                if(isNot == false){

                    System.out.println("찾지 못했습니다.");

                }

                System.out.println();
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