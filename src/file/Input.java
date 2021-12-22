package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    
    SideNoCheck sideNoCheck = new SideNoCheck();
    Scn scn = new Scn();

    public void reader(String book, String member){
        System.out.println("1. 책 2. 회원");

        int sideNo = sideNoCheck.sideNoCheck();

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

        int sideNo = sideNoCheck.sideNoCheck();

        if(sideNo == 1){

            System.out.println("책을 찾습니다.");

            finderBook(book);

        }else{

            System.out.println("회원을 찾습니다.");

            finderMember(member);

        }
    }

    //1. 책 읽어오기
    private void readerBook(String book){

        try{

            //1. FileInputStream 사용
            /*FileInputStream fio = new FileInputStream(book);
            
            int r = -1;

            while((r = fio.read()) != -1){

                System.out.print((char)r); //한 자, 한 자 받아와서

                if(r == '\r'){

                    System.out.println();

                }
            }*/

            //2. BufferedReader 사용
            //new BufferedReader(new InputStreamReader(new FileInputStream(book))
            //BufferedReader: Reader를 매개변수로 받음
            //InputStreamReader: InputStream을 매개변수로 받음
            BufferedReader fio = new BufferedReader(new InputStreamReader(new FileInputStream(book)));
            String line = null;

            while((line = fio.readLine()) != null) {
                System.out.println(line); //한줄로 받아올 수 있는 건 String이기 때문에
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

            //1. FileInputStream 사용
            /*FileInputStream fio = new FileInputStream(member);
            
            int r = -1;

            while((r = fio.read()) != -1){

                System.out.print((char)r);

                if(r == '\r'){

                    System.out.println();

                }

            }*/

            //2. BufferedReader 사용
            BufferedReader fio = new BufferedReader(new InputStreamReader(new FileInputStream(member)));
            String line = null;

            while((line = fio.readLine()) != null) {
                System.out.println(line); //한줄로 받아올 수 있는 건 String이기 때문에
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
    
                String bookName = scn.scnString();
                String rString = "";

                boolean isNot = false; //유무 판단

                //1. FileInputStream 사용
                /*
                FileInputStream fio = new FileInputStream(book);
                
                int r = -1;
    
                while((r = fio.read()) != -1){

                    rString += String.valueOf((char)r);

                    if(r == '\r'){
                        rString = "";
                    }

                    if(bookName.equals(rString)){

                        System.out.print(rString + "을 찾았습니다.");
                        isNot = true;

                        break;
                    }

                }

                */

                //2. BufferedReader 사용
                BufferedReader fio = new BufferedReader(new InputStreamReader(new FileInputStream(book)));
                String line = null;

                while((line = fio.readLine()) != null) {
                    if(bookName.equals(line)){

                        System.out.print(line + "을 찾았습니다.");
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
    
                String memberName = scn.scnString();

                boolean isNot = false; //유무 판단

                //1. FileInputStream 사용
                /*FileInputStream fio = new FileInputStream(member);

                String rString = "";
                int r = -1;
    
                while((r = fio.read()) != -1){
    
                    rString = String.valueOf((char)r);
                    
                    if(r == '\r'){
                        rString = "";
                    }

                    if(memberName.equals(rString)){

                        System.out.print(rString + "을 찾았습니다.");
                        isNot = true;

                    }
                }

                */

                //2. BufferedReader 사용
                BufferedReader fio = new BufferedReader(new InputStreamReader(new FileInputStream(member)));
                String line = null;

                while((line = fio.readLine()) != null) {
                    if(memberName.equals(line)){

                        System.out.print(line + "을 찾았습니다.");
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

}