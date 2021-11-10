public class App {
    public static void main(String[] args) throws Exception {
        
        boolean next = true;

        while(next == true){
            //레스토랑 진행
            PizzaRestarant pr = new PizzaRestarant();
            pr.run();
            pr.inputNext();
         
        }       
    }
}
