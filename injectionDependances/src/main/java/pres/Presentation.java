package pres;

import dao.Idao;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /*
        Injection des dependances par instanciation statique=>new
        pour instanciation dynamique => creation de fichier config
        */
        Idao dao=new DaoImpl2();
        MetierImpl metier=new MetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
