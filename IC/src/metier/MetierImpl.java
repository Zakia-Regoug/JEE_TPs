package metier;

import dao.Idao;

public class MetierImpl implements IMetier{
    private Idao dao; //couplage faible
    /*
    dao=new   signifie dependances d'une classe (il faut pas de new)
    */
    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }

    public void setDao(Idao dao) {
        this.dao = dao;
    }
}
