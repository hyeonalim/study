import file.Create;
import file.Input;
import file.Output;
import file.Scn;

public class LibraryFile {

    Input input = new Input();
    Output output = new Output();
    Create create = new Create();

    protected void run() throws Exception{

        String bookFileName = "src/file/book.txt";
        String memberFileName = "src/file/member.txt";

        while(true){

            System.out.println("1. 읽기 2. 찾기 3. 쓰기 4. 만들기");
            int no = noCheck();
            int sideNo = 0;

            if(no == 1){

                //1. 책, 사람 읽기
                System.out.println("읽기 방식을 선택하셨습니다.");
                input.reader(bookFileName, memberFileName);

            }else if(no == 2){
            
                //2. 책, 사람 찾기
                System.out.println("찾기 방식을 선택하셨습니다.");
                System.out.println("1. 책 2. 회원");

                input.finder(bookFileName, memberFileName);

            }else if(no == 3){

                //3. 책, 사람 쓰기
                System.out.println("쓰기 방식을 선택하셨습니다.");

                output.writer(bookFileName, memberFileName);
                
            }else{
                //4. 책, 사람 파일 만들기
                System.out.println("만들기 방식을 선택하셨습니다.");

                create.creater(bookFileName, memberFileName);

            }
        }
    }

    //숫자 잘못 입력한 경우
    private int noCheck(){

        Scn scn = new Scn();

        System.out.println("1 또는 4 를 입력해주세요.");

        int check = scn.scnInt();

        while(check < 1 || check > 4){

            System.out.println("1 또는 4 를 입력해주세요.");

            check = scn.scnInt();

        }

        return check;
    }

}