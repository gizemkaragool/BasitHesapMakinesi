package com.nexis.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edittxtBirinci, edittxtİkinci;
    private TextView txtViewSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2;
    private int sonuc;
    private Hesapla hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //değişkenlere id leri ata
        edittxtBirinci = (EditText) findViewById(R.id.editTextBirinci);
        edittxtİkinci = (EditText) findViewById(R.id.editTextİkinci);
        txtViewSonuc = (TextView) findViewById(R.id.textViewSonuc);
    }

    public void btnHesapla(View v) {
        birinciSayi = edittxtBirinci.getText().toString();
        ikinciSayi = edittxtİkinci.getText().toString();

        //girilen değerleri değişkenlere atamak

        if (!TextUtils.isEmpty(birinciSayi) && (!TextUtils.isEmpty(ikinciSayi))) {
            s1 = Integer.valueOf(birinciSayi);
            s2 = Integer.valueOf(ikinciSayi);
            // değişkenlerin türünü integer yaptık
            hesapla = new Hesapla(s1, s2);

            switch (v.getId()) {
                case R.id.buttonToplama:
                    sonuc = hesapla.toplam();
                    break;
                case R.id.buttonEksi:
                    sonuc = hesapla.cikarma();
                    break;
                case R.id.buttonCarp:
                    sonuc = hesapla.carpma();
                    break;
                case R.id.buttonBolme:
                    sonuc = hesapla.bolme();
                    break;
            }
            txtViewSonuc.setText("Sonuç : " + sonuc);
        } else
            txtViewSonuc.setText("Girilen Değerler Boş Olamaz!");
    }
}