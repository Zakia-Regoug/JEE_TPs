package ext;

import dao.Idao;

public class DaoImpl2 implements Idao {
    @Override
    public double getData() {
        System.out.println("Version WS");
        double tmp=2000;
        return tmp;
    }
}
