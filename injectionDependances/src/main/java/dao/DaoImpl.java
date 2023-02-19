package dao;

public class DaoImpl implements Idao{
    @Override
    public double getData() {
        /*
        se connecter a bdd
         */
        double temp=Math.random()*40;
        return temp;
    }
}
