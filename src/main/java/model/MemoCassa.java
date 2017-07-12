package model;

import java.util.Date;

/**
 * Created by Alessandro on 12/07/2017.
 */
public class MemoCassa extends Memo {
    public MemoCassa(Date data, Date dataAnnoPrecedente, String descrizione, double importo) {
        super(descrizione);
        super.setImporto(importo);
    }
}
