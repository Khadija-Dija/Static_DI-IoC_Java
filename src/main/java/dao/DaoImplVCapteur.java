
package dao;

public class DaoImplVCapteur implements IDao {

    @Override
    public double getData() {
       System.out.print("Version capteur");
       double data=77;
       return data;
    }
    
}
