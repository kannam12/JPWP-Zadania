package com.example.studenci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RVAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.listaStudentow);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RVAdapter(this, getMyList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Student> getMyList() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        Student s1 = new Student("Rafał", "Kozioł", 444666, R.drawable.person);
        Student s2 = new Student("Cezary", "Wyszedł", 123455, R.drawable.ikonka);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        return studentArrayList;
    }
}
