
package presentation;

import business.BusinessImpl;
import dao.DaoImpl;


public class Pres1 {
    public static void main(String[] args){
        //pres1 est ouverte a la modification pcq elle depend des classe (new  DaoImpl, BusinessImpl) on est oblige de modifier le code src
        DaoImpl dao= new DaoImpl();
        BusinessImpl business = new BusinessImpl();
        business.setDao(dao); //injection des dependances
        System.out.println("Ress = "+business.calcul());
         
    }
    
}
