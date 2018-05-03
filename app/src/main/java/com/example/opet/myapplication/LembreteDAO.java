package com.example.opet.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by opet on 02/05/2018.
 */

@Dao
public interface LembreteDAO {
    @Insert
    public long inserir(Lembrete lembrete);

    @Query("SELECT * FROM Lembrete")
    public List<Lembrete> findAll();

    @Query("SELECT * FROM Lembrete WHERE ID = :id")
    public Lembrete findById(long id);

    @Update
    public int atualizar(Lembrete lembrete);

    @Delete
    public int remover(Lembrete lembrete);
}
