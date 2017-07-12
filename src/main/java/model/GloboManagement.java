package model;

import exception.MemoException;
import org.hibernate.Session;
import persistence.HibernatePersistence;
import persistence.MemoRepository;

import java.util.Date;

/**
 * Created by Alessandro on 12/07/2017.
 */
public class GloboManagement {
    private MemoRepository repository;
    private Session session;
    private static GloboManagement instance = null;
    protected GloboManagement(){
        this.session = HibernatePersistence.getSessionFactory().openSession();
        this.repository = new MemoRepository(session);
    }
    public static GloboManagement getInstance() {
        if (instance == null)
            instance = new GloboManagement();
        return instance;
    }

    public void inserisciMemo(String notePagamento, String descrizione,
                              double importo, double saldo, String note){
        Memo memo = new Memo(descrizione );
        memo.setNotePagamento(notePagamento);
        memo.setImporto(importo);
        memo.setSaldo(saldo);
        memo.setNote(note);
        this.repository.save(memo);
    }
    public void updateMemo(long id,  String notePagamento, String descrizione,
                           double importo, double saldo, String note) throws MemoException {
        Memo memo = new Memo(descrizione );
        memo.setNotePagamento(notePagamento);
        memo.setImporto(importo);
        memo.setSaldo(saldo);
        memo.setNote(note);
        memo.setId(id);
        this.repository.update(memo);
    }
}
