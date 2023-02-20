package pres;
import dao.Idao;
import metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres2 {
    public static void main(String[] args) throws Exception {
        /*
        Injection des dependances par instanciation dynamique => creation de fichier config
        */
        Scanner scanner=new Scanner(new File("config.txt"));

        /* *** instancier un objet implemente l'interface Idao *** */
        String daoClassName=scanner.nextLine();
        //le fichier config precise l'objet de quel classe (daoClassName)
        Class cDao=Class.forName(daoClassName);
        Idao dao=(Idao) cDao.newInstance();

        /* *** instancier un objet implemente l'interface IMetier *** */
        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",Idao.class);
        //cet ecriture equivalent a metier.setDao(dao)
        method.invoke(metier,dao);
        System.out.println(metier.calcul());
    }
}
//InstantiationException si pas constru par defaut(sans parametre)
//appel au constructeur par defaut: le constructeur ne doit pas etre privee
