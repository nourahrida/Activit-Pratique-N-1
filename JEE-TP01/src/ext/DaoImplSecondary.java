package ext;

import dao.IDao;

public class DaoImplSecondary implements IDao {
    @Override
    public double getData() {
        return 2;
    }
}
