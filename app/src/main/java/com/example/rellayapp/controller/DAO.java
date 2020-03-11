package com.example.rellayapp.controller;

import java.util.ArrayList;
import java.util.List;

public interface DAO<Personne> {

    List<Personne> getAll();
    void insertPersonne (Personne p);
    void update(Personne p, String[] params);
    void delete(int id);
    Personne existePersonne(Personne p);

}
