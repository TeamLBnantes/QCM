package fr.dawan.formation.DAO;

import fr.dawan.formation.classes.List;

import java.sql.Connection;

public abstract class DAO <T>{

    protected Connection connection = null;
    public DAO (Connection connection){
        this.connection= connection;
    }

    public abstract boolean create (T obj);

    public abstract boolean create (int id);
    public abstract T find (int id);
    public abstract boolean update (T obj);
    //public abstract List<T> findAll();
    public void closeConnection(){

    }

}
