package file;

public class SideNoCheck {
    protected int sideNoCheck(){
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
