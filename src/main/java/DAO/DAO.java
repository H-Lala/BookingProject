package DAO;

import java.util.List;

public interface DAO<T> {

   void SaveData(String file);
   void LoadData(List<T> list);
   void ReadData(String file);

   void save(T item);//create
   T get(int ID);
   List<T> getAll();
   boolean delete(int ID);





}
