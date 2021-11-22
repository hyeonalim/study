import java.util.ArrayList;

public class Server {
    //서빙 중
    void serving(ArrayList<Pizza> pz, Customer cu){

        System.out.println("서빙중입니다.");
        
        for(int i = 0; i < pz.size(); i++){

            cu.eat(pz.get(i));

        }
    }
}
