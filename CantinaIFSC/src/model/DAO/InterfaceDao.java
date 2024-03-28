
package model.DAO;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface InterfaceDao <T> {
     
    public abstract void create (T objeto);
    public abstract List<T> retrieve();
    public abstract T retrieve(int parPK);
    public abstract List<T> retrieve(String parString);
    public abstract void uptade (T object);
    public abstract void delete(T object);
    
}
