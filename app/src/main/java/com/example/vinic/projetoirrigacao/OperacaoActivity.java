package com.example.vinic.projetoirrigacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vinic on 18/08/2017.
 */

public class OperacaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacao);

        Valvula v1= new Valvula();
        Valvula v2= new Valvula();

        v1.setVal("valvula 1");
        v1.setPulsos(3);
        v1.setTempo(2.5);

        v2.setVal("valvula 2");
        v2.setPulsos(5);
        v2.setTempo(5);

        ArrayList<Valvula> arrayList = new ArrayList<Valvula>();

        arrayList.add(v1);
        arrayList.add(v2);
        arrayList.add(v1);
        arrayList.add(v2);
        arrayList.add(v1);
        arrayList.add(v2);
        arrayList.add(v1);
        arrayList.add(v2);

        final ValvulaAdapter valvulaAdapter= new ValvulaAdapter(this,arrayList);

        final ListView listView = (ListView) findViewById(R.id.list_adapter);
        listView.setAdapter(valvulaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Valvula val= (Valvula) parent.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(),val.getVal(),Toast.LENGTH_SHORT).show();
                val.setVal("Novo Val");


            }
        });

    }


    public void onButtonClick(View v){



    }

}
