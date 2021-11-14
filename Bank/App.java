public class App {
    public static void main(String[] args) throws Exception {
        
        boolean next = true;

        while(next == true){
            
            //은행 진행
            Bank bk = new Bank();
            bk.run();
            bk.inputNext();
            
        }

    }
}
