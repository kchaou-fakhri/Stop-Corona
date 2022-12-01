package Interface;

import java.util.ArrayList;

public interface  IDAO <T> {
	
	public T findBy(Object id);
	public ArrayList<T> findAll();
	public boolean update(Object o);
	public boolean insert(Object o);
	public boolean delete(Object o);

}
