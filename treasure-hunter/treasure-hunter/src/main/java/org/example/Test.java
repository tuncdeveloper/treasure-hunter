package org.example;

import com.formdev.flatlaf.FlatDarculaLaf;

import org.example.entity.grid.HazineSandigi;
import org.example.entity.grid.Izgara;
import org.example.service.EnKısaYol;
import org.example.service.EngelEkle;
import org.example.service.HazineEkle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(new FlatDarculaLaf()); // FlatLaf temasını aktif et
                } catch (Exception ex) {
                    System.err.println("FlatLaf yüklenirken hata oluştu!");
                }
            JFrame frame ;
            Izgara izgara ;
            frame = new JFrame("Izgara Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            izgara = Izgara.izgaraGetir(800, 800, (byte) 5);
            frame.getContentPane().add(izgara, BorderLayout.CENTER);

            JButton yeniHaritaButton = new JButton("Yeni Harita Oluştur");
            yeniHaritaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EngelEkle engelEkle;
                    HazineEkle hazineEkle;
                    izgara.temizle();
                    engelEkle = EngelEkle.engelEkleGetir();
                    engelEkle.engelEkle();

                    hazineEkle = HazineEkle.hazineEkleGetir();
                    hazineEkle.hazineEkle();
                    izgara.repaint();
                }
            });

            JButton oyunBaslatButton = new JButton("Oyun Başlat");
            oyunBaslatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List <Point> hazineLokasyon = new ArrayList<>() ;

                    for (HazineSandigi hazine : HazineEkle.hazineEkleGetir().hazineList) {
                        hazineLokasyon.add(hazine.getKonum()) ;
                    }

                    EnKısaYol spf = new EnKısaYol() ;

                    List<Point> shortestPath = spf.search(HazineEkle.hazineEkleGetir().hazineList);
                    izgara.setPatika(shortestPath);
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(yeniHaritaButton);
            buttonPanel.add(oyunBaslatButton);

            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);



            frame.pack();
            frame.setVisible(true);

        });
    }
}
