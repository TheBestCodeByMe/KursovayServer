package database;

import entity.Description;

import java.util.LinkedList;

public interface IDescription {
    boolean isFind(Description object);
    LinkedList<Description> selectAllDescription();
    void update(Description object, int id);
    void insert(Description object);
    void delete(int id);
}
