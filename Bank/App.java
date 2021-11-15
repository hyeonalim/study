public class App {
    public static void main(String[] args) throws Exception {
        
        boolean works = true;

        while(works == true){
            
            //은행 진행
            Bank bk = new Bank();
            bk.run();
            works = bk.inputWork();
            
        }

    }
}
