public class Server {
    //서빙 중
    void serving(Pizza pz, Customer cu){

        System.out.println("서빙중입니다.");
        cu.eat(pz);

    }
}
