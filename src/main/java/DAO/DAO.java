package DAO;

import java.util.List;
import java.util.Scanner;

public interface DAO<T> {

   void SaveData(String file);
   void LoadData(List<T> list);
   void ReadData(String file);

   void save(T item);//create
   T get(int ID);
   List<T> getAll();
   boolean delete(int ID);




    void generate(Scanner sc);
}
