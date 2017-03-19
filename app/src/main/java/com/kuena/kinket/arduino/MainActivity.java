package com.kuena.kinket.arduino;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kuena.kinket.arduino.adapter.AdapterBasic;
import com.kuena.kinket.arduino.bean.Basic;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    private ListView listView;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String judul;
    private String image;
    private String code;
    private String langkah;
    private String alat;
    private String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {

        }
        else {

        }


        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                } else {
                    // User is signed out

                }
                // ...
            }
        };

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("basic");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                ArrayList<Basic> list = new ArrayList<Basic>();
                for(DataSnapshot chil:dataSnapshot.getChildren()) {
                    Basic basic= chil.getValue(Basic.class);

                    HashMap<String,String> employees = new HashMap<>();

                    employees.put(judul,basic.getJudul());
                    employees.put(image,basic.getImage());
                    employees.put(code,basic.getCode());
                    employees.put(langkah,basic.getLangkah());
                    employees.put(alat,basic.getAlat_bahan());
                    employees.put(hasil,basic.getHasil());

                    list.add(basic);
                }
//                ListAdapter adapter = new SimpleAdapter(
//                        getActivity(), list, R.layout.filter,
//                        new String[]{config.TAG_JUDUL_BERITA,config.TAG_TANGGAL_BERITA},
//                        new int[]{R.id.judul, R.id.tanggal});
                AdapterBasic adapter = new AdapterBasic(MainActivity.this, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
