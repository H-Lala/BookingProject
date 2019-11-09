package DAO;

import java.util.HashSet;

public interface DAO<T> {

    void store(T data);
    T get(int ID);
     void cancel(int ID);

      void search();   //look at this


}
