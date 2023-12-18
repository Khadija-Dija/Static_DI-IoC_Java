
package business;

import dao.IDao;


public class BusinessImpl implements IBusiness {
    private IDao dao;                       //couplage faible  +  bon pratique : ne pas initialiser dao=null

    @Override
    public double calcul() {
        double data=dao.getData();      //on ne sais pas quel version qu'on va utiliser au moment de l'execution on va appele la méthode getData()
        double res=data*11;
       return res;
    }
    /***Injecter  dans la variable dao 
     * un objet d'une classe qui implemente l'interface IDao
     * @param dao
     ***/
    
    public void setDao(IDao dao){
        this.dao=dao;
    }
}
