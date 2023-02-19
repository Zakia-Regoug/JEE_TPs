package pres;

import dao.Idao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres2 {
    public static void main(String[] args) throws Exception {
        //dynamique
        Scanner scanner=new Scanner(new File("D:\\ENSET\\S4\\J2EE\\IC\\src\\config.txt"));
        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        //InstantiationException si pas constru par defaut(sans parametre)
        //appel au constructeur par defaut: le constructeur ne doit pas etre privee
        Idao dao=(Idao) cDao.newInstance();

        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",Idao.class);
        //metier.setDao(dao)
        method.invoke(metier,dao);
        System.out.println(metier.calcul());

    }
}
