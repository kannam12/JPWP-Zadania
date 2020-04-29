package com.example.studenci;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVHolder>{

    private Context context;
    ArrayList<Student> studentArrayList;

    public RVAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rekord, null);
        return new RVHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        holder.getImie().setText("Imię: " + studentArrayList.get(position).getImie());
        holder.getNazwisko().setText("Nazwisko: " + studentArrayList.get(position).getNazwisko());
        holder.getIndeks().setText("Indeks: " + String.valueOf(studentArrayList.get(position).getNrIndeksu()));
        holder.getIkona().setImageResource(studentArrayList.get(position).getIkonka());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }
}
