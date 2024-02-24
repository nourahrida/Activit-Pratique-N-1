package metier;

import dao.DaoImpl;
import ext.DaoImplSecondary;
import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl(){

    }

    public MetierImpl(DaoImpl dao) {
        this.dao = dao;
    }

    public MetierImpl(DaoImplSecondary dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double temp = dao.getData();
        // doing sm logic
        return temp;
    }
}
