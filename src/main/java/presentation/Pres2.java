
package presentation;

import business.IBusiness;
import dao.IDao;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Pres2 {
    public static void main(String[] args) throws Exception{
       
       // DaoImpl dao= new DaoImpl();
       Scanner scanner = new Scanner(new File ("config.txt"));                     //lire le fichier config.txt dans le demarrage de notre
      String daoClassName = scanner.nextLine();                                       //lire la premiere du ficher (au moment de l'execution)
      Class cDao = Class.forName(daoClassName)  ;                              //creer un objet de cette class (dynamique)
     IDao dao= (IDao)cDao.getConstructor().newInstance();                              //new DaoImpl
     System.out.println(dao.getData());
     //  BusinessImpl business = new BusinessImpl();
     String businessClassName = scanner.nextLine();
     Class cBusiness = Class.forName(businessClassName);
     IBusiness business = (IBusiness)cBusiness.getConstructor().newInstance();
        //  business.setDao(dao);      //injection des dependances (dynamiquement)
   Method setDao = cBusiness.getDeclaredMethod("setDao",IDao.class);
   setDao.invoke(business, dao);                    //invocation dynamique du methode setDao
   System.out.print("Res ="+business.calcul());
   
         
    }
    
}
