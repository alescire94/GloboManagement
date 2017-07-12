package persistence;

import exception.MemoException;
import model.Memo;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Alessandro on 12/07/2017.
 */
public class MemoRepository implements Repository {
    private static final Logger LOGGER = Logger.getLogger( MemoRepository.class.getName() );
    private Session session;
    public MemoRepository(Session session){
        this.session = session;
    }
    public Long save(Object save) {
        Memo memo = (Memo) save;
        session.beginTransaction();
        LOGGER.info("Save memo invoked");
        Long id = (Long)session.save(memo);
        session.getTransaction().commit();
        LOGGER.info("memo "+memo.toString()+" saved successfully");
        return id;
    }



    public void delete(long id) throws MemoException{
        LOGGER.info("delete invoked");
        Memo delete = (Memo)this.findById(id);
        session.beginTransaction();
        session.delete(delete);
        session.getTransaction().commit();
        LOGGER.info(delete.toString() + " deleted succesfully");
    }

    public Memo findById(long id) throws MemoException {
        LOGGER.info("findByID invoked");
        String query = "select m from Memo m where m.id = :id";
        Query q = this.session.createQuery(query).setParameter("id",id);
        Memo foundMemo;
        if(!q.list().isEmpty())
            foundMemo =(Memo) q.list().get(0);

        else{ LOGGER.info("Memo Not Found");
            throw new MemoException("Memo Not Found");
        }
        return foundMemo;
    }

    public void update(Object update) throws MemoException {
        LOGGER.info("update invoked");
        Memo memo = (Memo) update;
        Memo old = this.findById(memo.getId());
        session.getTransaction().begin();
        old = memo;
        session.getTransaction().commit();
        LOGGER.info("now memo is "+this.findById(memo.getId()).toString());
    }
}
