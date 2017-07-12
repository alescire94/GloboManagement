import exception.MemoException;
import model.Memo;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.HibernatePersistenceTest;
import persistence.MemoRepository;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alessandro on 12/07/2017.
 */
public class MemoRepositoryTest {
    private static Session session;
    private static Memo memo;
    private static MemoRepository repository;
    private static double importo;
    @BeforeClass
    public static void setup(){
        session = HibernatePersistenceTest.getSessionFactory().openSession();
        memo = new Memo("descrizione");
        repository = new MemoRepository(session);
        importo = 300;
    }
    @AfterClass
    public static void shutdown(){
        HibernatePersistenceTest.shutdown();
    }
    @Test
    public void testSave() throws MemoException {
        Long id  = this.repository.save(memo);
        assertEquals(this.memo, this.repository.findById(id));
    }

    @Test(expected = MemoException.class)
    public void testDelete()throws MemoException{
        Long id = this.repository.save(memo);
        this.repository.delete(id);
        this.repository.findById(id);
    }
    @Test
    public void testUpdate() throws MemoException {
        Long id = this.repository.save(memo);
        memo.setImporto(this.importo);
        this.repository.update(memo);
        assertTrue(this.repository.findById(id).getImporto() == this.importo);
    }
}
