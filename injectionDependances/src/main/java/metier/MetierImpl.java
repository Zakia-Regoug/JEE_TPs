package metier;

import dao.Idao;
import org.springframework.stereotype.Component;

public class MetierImpl implements IMetier{
    private Idao dao;
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
