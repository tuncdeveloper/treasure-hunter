package org.example.entity.obstacleEntity.movingObstacleEntity;

import org.example.entity.obstacleEntity.Engel;

import java.awt.*;

public abstract class HareketliEngel extends Engel {
    private int sagHareketMiktari;
    private int solHareketMiktari;
    private int yukariHareketMiktari;
    private int asagiHareketMiktari;
    private Point konum;

    private boolean merkez ;


    public HareketliEngel(int boyutX, int boyutY, String engelAdi, int sagHareketMiktari, int solHareketMiktari, int yukariHareketMiktari, int asagiHareketMiktari , Point point) {
        super(boyutX, boyutY, engelAdi , point);
        this.sagHareketMiktari = sagHareketMiktari;
        this.solHareketMiktari = solHareketMiktari;
        this.yukariHareketMiktari = yukariHareketMiktari;
        this.asagiHareketMiktari = asagiHareketMiktari;
        this.konum = point;
        merkez = true ;
    }
    public abstract void hareketEt() ;

    public Point getKonum() {
        return this.konum;
    }

    public void setKonum(Point konum) {
        this.konum = konum;
    }

    public int getSagHareketMiktari() {
        return sagHareketMiktari;
    }

    public void setSagHareketMiktari(int sagHareketMiktari) {
        this.sagHareketMiktari = sagHareketMiktari;
    }

    public int getSolHareketMiktari() {
        return solHareketMiktari;
    }

    public void setSolHareketMiktari(int solHareketMiktari) {
        this.solHareketMiktari = solHareketMiktari;
    }

    public int getYukariHareketMiktari() {
        return yukariHareketMiktari;
    }

    public void setYukariHareketMiktari(int yukariHareketMiktari) {
        this.yukariHareketMiktari = yukariHareketMiktari;
    }

    public int getAsagiHareketMiktari() {
        return asagiHareketMiktari;
    }

    public void setAsagiHareketMiktari(int asagiHareketMiktari) {
        this.asagiHareketMiktari = asagiHareketMiktari;
    }


    public boolean isMerkez() {
        return merkez;
    }

    public void setMerkez(boolean merkez) {
        this.merkez = merkez;
    }



}

