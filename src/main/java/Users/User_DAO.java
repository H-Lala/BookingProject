package Users;

import java.util.List;

public interface User_DAO<T extends Users> {
    List<T> getAll();

    void save(T person);
    boolean delete(int ID);
    T get(int ID);
    void SaveData(String filePath);
    void ReadData(String filePath);
    void LoadData(List<T> persons);


}
