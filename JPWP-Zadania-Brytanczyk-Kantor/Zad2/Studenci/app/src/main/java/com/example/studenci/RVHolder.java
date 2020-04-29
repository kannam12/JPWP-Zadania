package com.example.studenci;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {

    private TextView imie;
    private TextView nazwisko;
    private TextView indeks;
    private ImageView ikona;

    public RVHolder(@NonNull View itemView) {
        super(itemView);
        this.imie = (TextView) itemView.findViewById(R.id.imieTxt);
        this.nazwisko = (TextView) itemView.findViewById(R.id.nazwiskoTxt);
        this.indeks = (TextView) itemView.findViewById(R.id.indeksTxt);
        this.ikona = (ImageView) itemView.findViewById(R.id.imageView);
    }

    public TextView getImie() {
        return imie;
    }

    public void setImie(TextView imie) {
        this.imie = imie;
    }

    public TextView getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(TextView nazwisko) {
        this.nazwisko = nazwisko;
    }

    public TextView getIndeks() {
        return indeks;
    }

    public void setIndeks(TextView indeks) {
        this.indeks = indeks;
    }

    public ImageView getIkona() {
        return ikona;
    }

    public void setIkona(ImageView ikona) {
        this.ikona = ikona;
    }
}
