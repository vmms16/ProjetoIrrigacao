package com.example.vinic.projetoirrigacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import static android.app.Activity.RESULT_OK;


/**
 * Created by vinic on 20/08/2017.
 */

public class EditarValvulaDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(R.layout.activity_edit_val);

        EditText tempo= (EditText)getDialog().findViewById(R.id.id_tempo_d);
        EditText pulsos= (EditText)getDialog().findViewById(R.id.id_pulsos_d);

        final String tempoString = tempo.getText().toString();
        final String pulsosString= pulsos.getText().toString();

        builder.setMessage("Edição de Valvula")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditarValvulaDialog.this.getDialog().cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}

