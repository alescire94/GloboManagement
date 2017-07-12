package persistence;

import exception.DiarioException;
import model.Diario;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Alessandro on 12/07/2017.
 */
public class DiarioRepository implements Repository<Diario> {
    private static final Logger LOGGER = Logger.getLogger( DiarioRepository.class.getName() );
    private Session session;
    public DiarioRepository(Session session){
        this.session = session;
    }
    public Long save(Diario save) {
        Diario diario = (Diario) save;
        session.beginTransaction();
        LOGGER.info("Save diario invoked");
        Long id = (Long)session.save(diario);
        session.getTransaction().commit();
        LOGGER.info("diario "+diario.toString()+" saved successfully");
        return id;
    }

    public void delete(long id) throws DiarioException {
        LOGGER.info("delete invoked");
        Diario delete = (Diario)this.findById(id);
        session.beginTransaction();
        session.delete(delete);
        session.getTransaction().commit();
        LOGGER.info(delete.toString() + " deleted succesfully");
    }

    public Diario findById(long id) throws DiarioException {
        LOGGER.info("findByID invoked");
        String query = "select d from Diario d where d.id = :id";
        Query q = this.session.createQuery(query).setParameter("id",id);
        Diario foundDiario;
        if(!q.list().isEmpty())
            foundDiario =(Diario) q.list().get(0);

        else{ LOGGER.info("Diario Not Found");
            throw new DiarioException("Diario Not Found");
        }
        return foundDiario;
    }

    public void update(Diario update) throws DiarioException {
        LOGGER.info("update invoked");
        Diario diario = (Diario) update;
        Diario old = this.findById(diario.getId());
        session.getTransaction().begin();
        old = diario;
        session.getTransaction().commit();
        LOGGER.info("now diario is "+this.findById(diario.getId()).toString());
    }

    public Diario findByDate(Date date) throws DiarioException {
        LOGGER.info("findByID invoked");
        String query = "select d from Diario d where d.data = :date";
        Query q = this.session.createQuery(query).setParameter("date",date);
        Diario foundDiario;
        if(!q.list().isEmpty())
            foundDiario =(Diario) q.list().get(0);

        else{ LOGGER.info("Diario Not Found");
            throw new DiarioException("Diario Not Found");
        }
        return foundDiario;
    }
}
