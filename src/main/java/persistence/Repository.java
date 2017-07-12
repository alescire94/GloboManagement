package persistence;

import exception.MemoException;

import java.util.Date;
import java.util.List;

/**
 * Created by Alessandro on 12/07/2017.
 */
public interface Repository <T>{
    public Long save(T save);
    public void delete(long id) throws Exception;
    public T findById(long id) throws Exception;
    public void update(T update) throws Exception;
}
