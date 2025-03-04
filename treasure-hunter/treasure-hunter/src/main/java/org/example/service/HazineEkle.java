package org.example.service;

import org.example.entity.grid.HazineSandigi;
import org.example.entity.grid.Izgara;
import org.example.entity.treasureEntity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;



public class HazineEkle {

    private static HazineEkle hazineEkle ;

    private int MaxHazineSandigi = 30;
    Random random = new Random();


    public ArrayList<HazineSandigi> hazineList = new ArrayList<>();
    private byte [][] izgaraMatriss ;
    private Izgara izgara ;



    private HazineEkle(){

        izgara = Izgara.izgaraGetir(800,800,(byte)5) ;
        izgaraMatriss = izgara.getIzgaraMatris() ;
    }


    public static HazineEkle hazineEkleGetir () {
        if (hazineEkle == null) {
            hazineEkle = new HazineEkle() ;
        }
        return hazineEkle ;
    }


    public void hazineEkle() {
        HazineSandigi hezine = null;

        for (int j = 0; j < 5 ; j++) {
            hazineList.add(RastgeleAltin());
            hazineList.add(RastgeleZümrüt());
            hazineList.add(RastgeleGümüs());
            hazineList.add(RastgeleBakir());
        }


        for (int i = 0; i < MaxHazineSandigi-20; i++) {
            int rastgeleEngelTur = random.nextInt(2);
            switch (rastgeleEngelTur){
                case 0:
                    hezine = RastgeleAltin();
                    break;
                case 1:
                    hezine = RastgeleZümrüt() ;
                    break;
                case 2:
                    hezine = RastgeleGümüs();
                    break;
                case 3:
                    hezine = RastgeleBakir() ;
                    break;

            }
            hazineList.add(hezine);
        }
    }

    private Altin RastgeleAltin() {
        Point point = izgara.rastgeleKonum(1,1) ;
         Altin altin = new Altin(point);
        izgaraMatrisGuncelle(altin);
        return altin ;
    }

    private Zümrüt RastgeleZümrüt() {
        Point point = izgara.rastgeleKonum(1,1) ;
        Zümrüt zümrüt = new Zümrüt(point);
        izgaraMatrisGuncelle(zümrüt);
        return zümrüt;

    }
    private Gümüs RastgeleGümüs(){

        Point point = izgara.rastgeleKonum(1,1) ;
        Gümüs gümüs = new Gümüs(point);
        izgaraMatrisGuncelle(gümüs);
        return gümüs;

    }

    private Bakir RastgeleBakir(){
        Point point = izgara.rastgeleKonum(1,1) ;
        Bakir bakir = new Bakir(point);
        izgaraMatrisGuncelle(bakir);
        return bakir;
    }


    private void izgaraMatrisGuncelle (HazineSandigi hazineSandigi) {
        for (int i = hazineSandigi.getKonum().x; i <= hazineSandigi.getKonum().x + hazineSandigi.getBoyutX() * izgara.getKareGenisligi()  + izgara.getKareGenisligi(); i+= izgara.getKareGenisligi()) {
            for (int j = hazineSandigi.getKonum().y; j <= hazineSandigi.getKonum().y + hazineSandigi.getBoyutY() * izgara.getKareGenisligi() + izgara.getKareGenisligi(); j+= izgara.getKareGenisligi()) {
                izgaraMatriss[j/ izgara.getKareGenisligi()][i/ izgara.getKareGenisligi()] = 2 ;
            }
        }
    }

    public byte [][] getIzgaraMatriss () {
        return izgaraMatriss ;
    }



    public void yazdirEngellerinIsimlerini () {
        for (HazineSandigi engel : hazineList) {
            System.out.println(engel.getClass().getSimpleName() + " : (" + engel.getBoyutX() + "," + engel.getBoyutY() + ")");
        }
    }

    public static void main(String[] args) {
        HazineEkle he = new HazineEkle();
        he.yazdirEngellerinIsimlerini();
    }
}
