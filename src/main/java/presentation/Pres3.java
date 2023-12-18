
package presentation;

import business.IBusiness;
import dao.IDao;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Pres3 {
    public static void main(String[] args) throws Exception{
       
       // DaoImpl dao= new DaoImpl();
       Scanner scanner = new Scanner(System.in);                     //lire le fichier config.txt dans le demarrage de notre
      System.out.println("Donner le classe de la couche DAO :");
       String daoClassName = scanner.nextLine();                                       //lire la premiere du ficher (au moment de l'execution)
      Class cDao = Class.forName(daoClassName)  ;                              //creer un objet de cette class (dynamique)
     IDao dao= (IDao)cDao.getConstructor().newInstance();                              //new DaoImpl
   
     
//  BusinessImpl business = new BusinessImpl();
     System.out.println("Donner le classe de la couche Business :");
     String businessClassName = scanner.nextLine();
     Class cBusiness = Class.forName(businessClassName);
     IBusiness business = (IBusiness)cBusiness.getConstructor().newInstance();
        //  business.setDao(dao);      //injection des dependances (dynamiquement)
   Method setDao = cBusiness.getDeclaredMethod("setDao",IDao.class);
   setDao.invoke(business, dao);                    //invocation dynamique du methode setDao
   System.out.print("Res ="+business.calcul());
   
         
    }
    
}
