package com.example.rellayapp.controller;
import com.example.rellayapp.model.Personne;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO implements DAO<Personne> {
    private List<Personne> personnesList = new ArrayList<>();
    @Override
    public List getAll() {
        return personnesList;
    }

    @Override
    public void insertPersonne(Personne p) {
        personnesList.add(p);
    }

    @Override
    public void update(Personne p, String[] params) {
        //
    }

    @Override
    public void delete(int id) {
        personnesList.remove(id);
    }

    @Override
    public Personne existePersonne(Personne p) {
       Personne p2 = null;
       for (Personne p1:personnesList) if (p1.equals(p)) p2=p1;
        return p2;
    }
}
