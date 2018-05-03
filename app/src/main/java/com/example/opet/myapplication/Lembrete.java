package com.example.opet.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by opet on 02/05/2018.
 */

@Entity
public class Lembrete {
    @PrimaryKey(autoGenerate = true)
    private long ID;
    private String texto;
    @ColumnInfo(name = "criado_em")
    private long dataLembrete;

    private int importancia;

    public Lembrete() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getDataLembrete() {
        return dataLembrete;
    }

    public void setDataLembrete(long dataLembrete) {
        this.dataLembrete = dataLembrete;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }
}
