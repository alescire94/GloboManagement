package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Alessandro on 12/07/2017.
 */
@Entity
public class Diario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataAnnoPrecedente;
    @OneToMany
    List<Memo> memos;

    public Diario(Date data, Date dataAnnoPrecedente, List<Memo> memos) {
        this.data = data;
        this.dataAnnoPrecedente = dataAnnoPrecedente;
        this.memos = memos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Memo> getMemos() {
        return memos;
    }

    public void setMemos(List<Memo> memos) {
        this.memos = memos;
    }

    @Override
    public String toString() {
        return "Diario{" +
                "data=" + data +
                ", dataAnnoPrecedente=" + dataAnnoPrecedente +
                ", memos=" + memos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diario diario = (Diario) o;

        return data.equals(diario.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
