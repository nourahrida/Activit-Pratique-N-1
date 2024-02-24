package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    @Autowired
    @Qualifier("dao2")
    private IDao dao;

//    public MetierImpl(IDao dao) {
//        this.dao = dao;
//    }

    @Override
    public double calcul() {
        // doing sm logic
        return dao.getData();
    }
}
