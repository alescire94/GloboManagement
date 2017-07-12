package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alessandro on 24/04/2017.
 */
@Entity
public class Memo  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataAnnoPrecedente;
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

    public Memo(Date data, Date dataAnnoPrecedente, String descrizione, Memo memoPassato) {
        this.data = data;
        this.dataAnnoPrecedente = dataAnnoPrecedente;
        this.descrizione = descrizione;
        this.memoPassato = memoPassato;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataAnnoPrecedente() {
        return dataAnnoPrecedente;
    }

    public void setDataAnnoPrecedente(Date dataAnnoPrecedente) {
        this.dataAnnoPrecedente = dataAnnoPrecedente;
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
}
