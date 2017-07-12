import exception.DiarioException;
import model.Diario;
import model.Memo;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import persistence.DiarioRepository;
import persistence.HibernatePersistenceTest;
import persistence.MemoRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alessandro on 12/07/2017.
 */
public class DiarioRepositoryTest {
    private static Session session;
    private static List<Memo> memos;
    private static Memo memo;
    private static Diario diario;
    private static DiarioRepository repository;

    @BeforeClass
    public static void setup(){
        session = HibernatePersistenceTest.getSessionFactory().openSession();
        memos = new LinkedList<Memo>();
        memo = new Memo("ritirare ordine");
        memos.add(memo);
        diario = new Diario(new Date(), new Date(),memos);
        repository = new DiarioRepository(session);

    }
    @AfterClass
    public static void shutdown(){
        HibernatePersistenceTest.shutdown();
    }
    @Test
    public void testSave() throws DiarioException {
        Long id  = this.repository.save(diario);
        assertEquals(this.diario, this.repository.findById(id));
    }

    @Test(expected = DiarioException.class)
    public void testDelete()throws DiarioException{
        Long id = this.repository.save(diario);
        this.repository.delete(id);
        this.repository.findById(id);
    }
    @Test
    public void testUpdate() throws DiarioException, ParseException {
        Long id = this.repository.save(diario);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        diario.setData(date);
        this.repository.update(diario);
        assertTrue(this.repository.findById(id).getData().equals(date));
    }
}
