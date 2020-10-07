package com.example.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String FILENAME="namafile";
    Button BuatFile, UbahFile, BacaFile, deleteFile;
    TextView textbaca

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BuatFile=findViewById(R.id.buttonBuatFile);
        UbahFile=findViewById(R.id.buttonUbahFile);
        BacaFile=findViewById(R.id.buttonBacaFile);
        deleteFile=findViewById(R.id.buttonHapusFile);
        textbaca=findViewById(R.id.textBaca);

        BuatFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuatFile();
            }
        });
        UbahFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UbahFile();
            }
        });
        BacaFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        deleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HapusFile();
            }
        });
    }

    void BuatFile(){
            String isiFile="Coba isi data file text";
            File file=new File(getFilesDir(),FILENAME);
            FileOutputStream outputStream=null;
            try {
                file.createNewFile();
                outputStream=new FileOutputStream(file, true);
                outputStream.write(isiFile.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    void UbahFile(){
        String isiFile="Update isi data file text";
        File file=new File(getFilesDir(),FILENAME);
        FileOutputStream outputStream=null;
        try {
            file.createNewFile();
            outputStream=new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void BacaFile(){
            File dir=getFilesDir();
            File file=new File(dir,FILENAME);
            if (file.exists()){
                StringBuilder text=new StringBuilder();

                BufferedReader br=new BufferedReader(new FileReader(File);
                String line=br.readLine();
                while (line:null){
                    text.append(line);
                    line=br.readLine();
                }
                br.close();
            }
            textbaca.setText(textbaca.toString());
    }

    void HapusFile(){
        File file=new File(getFilesDir(),FILENAME);
        if(file.exists()){
            file.delete();
        }
    }

}