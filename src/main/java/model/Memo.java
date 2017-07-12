package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alessandro on 24/04/2017.
 */
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String notePagamento;
    @Column(nullable = false)
    private String descrizione;
    @Column
    private double importo;
    @Column
    private double saldo;
    @Column
    private String note;
    @OneToOne
    private Memo memoPassato;
    public Memo(){}
    public Memo(String descrizione) {

        this.descrizione = descrizione;

    }



    public String getNotePagamento() {
        return notePagamento;
    }

    public void setNotePagamento(String notePagamento) {
        this.notePagamento = notePagamento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Memo getMemoPassato() {
        return memoPassato;
    }

    public void setMemoPassato(Memo memoPassato) {
        this.memoPassato = memoPassato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Memo memo = (Memo) o;


        return descrizione.equals(memo.descrizione);
    }

    @Override
    public int hashCode() {

        int result = 31 + descrizione.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Memo{" +
                ", notePagamento='" + notePagamento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", importo=" + importo +
                ", saldo=" + saldo +
                ", note='" + note + '\'' +
                ", memoPassato=" + memoPassato +
                '}';
    }
}
