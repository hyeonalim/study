public class Rental {
    
    String mname;
    String bname;

    //this maker
    public Rental(String mname, String bname){
        
        this.mname = mname;
        this.bname = bname;

    }

    public Rental(String bname2) {
    }

    //mnameequlas
    public boolean mequals(Object o){
        
        if(o == this.mname){

            return true;

        }

        if(!(o instanceof Rental)){
        
            return false;
        
        }

        Rental r = (Rental) o;
        return this.mname.equals(r.mname);

    }

    //bnameequlas
    public boolean bequals(Object o){
        
        if(o == this.bname){

            return true;

        }

        if(!(o instanceof Rental)){
        
            return false;
        
        }

        Rental r = (Rental) o;
        return this.bname.equals(r.bname);

    }

}
