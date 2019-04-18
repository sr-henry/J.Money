package br.unicamp.ft.h198760_r205548;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private EditText editTextValue;
    private EditText editTextTerm;
    private EditText editTextName;
    private Button button;


    private double value;
    private int term;
    private String name;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        editTextValue   = v.findViewById(R.id.etValue);
        editTextTerm    = v.findViewById(R.id.etTerm);
        editTextName    = v.findViewById(R.id.etName);
        button          = v.findViewById(R.id.btInput);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value = Double.parseDouble(editTextValue.getText().toString());
                term  = Integer.parseInt(editTextTerm.getText().toString());
                name  = editTextName.getText().toString();

                Dividas.list.add(new Divida(value, term, name));

                Toast.makeText(getContext(), "ADD", Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }

}
