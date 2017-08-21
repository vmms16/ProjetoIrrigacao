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
    private Sessao sessao= Sessao.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacao);


        final ValvulaAdapter valvulaAdapter= new ValvulaAdapter(this,sessao.getArrayValvulas());

        final ListView listView = (ListView) findViewById(R.id.list_adapter);
        listView.setAdapter(valvulaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Valvula val= (Valvula) parent.getAdapter().getItem(position);
                //Toast.makeText(getApplicationContext(),val.getVal(),Toast.LENGTH_SHORT).show();
                sessao.setValvula(val);
                val.setPulsos(sessao.getValvula().getPulsos());
                val.setTempo(sessao.getValvula().getTempo());
                Intent intent= new Intent(getApplication(),EditarValvula.class);
                startActivity(intent);

                //Toast.makeText(getApplicationContext(),Integer.toString(arrayList.get(0).getPulsos()),Toast.LENGTH_SHORT).show();
                listView.invalidateViews();
            }
        });



    }


    public void onButtonClick(View v){



    }

}
