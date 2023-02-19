package metier;

import dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MetierImpl implements IMetier{
    //au moment de chargement de la classe si il trouve un objet de type idao il va l'injecter dans la variable dao
    @Autowired
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
