package dao;

public class DaoImpl2 implements IDao{

    @Override
    public double getData() {
      System.out.println("version Web Service");
        double data=10;
        return data;
    }
    
     
}
