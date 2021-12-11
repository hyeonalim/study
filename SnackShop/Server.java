import java.util.ArrayList;
import java.util.HashSet;

public class Server {
 
    void serving(ArrayList<Maker> makers, Customer cu){

        System.out.println("서빙중입니다.");
        HashSet<String> kinds = new HashSet<>();

        for(int i = 0; i < makers.size(); i++){

            Maker maker = makers.get(i);
            String kind = maker.kind;
            kinds.add(kind);

        }

        for(String kind: kinds){
            
            cu.eat(kind);

        }
    }
}
