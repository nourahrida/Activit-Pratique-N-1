package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImplSecondary implements IDao {
    @Override
    public double getData() {
        return 2;
    }
}
