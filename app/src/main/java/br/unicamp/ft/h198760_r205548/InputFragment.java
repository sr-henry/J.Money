package br.unicamp.ft.h198760_r205548;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import Interfaces.OnEditRequest;

import static android.view.View.VISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private RecyclerView    recyclerView;
    private AdapterDoMal    adapterDoMal;
    private EditText        editTextValue;
    private EditText        editTextTerm;
    private EditText        editTextName;
    private RadioGroup      radioGroup;
    private CheckBox        checkBox;
    private Button          button;

    private OnEditRequest onEditRequest;

    String strValue, strTerm;

    private double  value;
    private int     term;
    private String  name;
    private int     type = 0;

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
        radioGroup      = v.findViewById(R.id.radioGroupType);
        recyclerView    = v.findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterDoMal = new AdapterDoMal(Dividas.list);
        recyclerView.setAdapter(adapterDoMal);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radioGroup.getCheckedRadioButtonId();

                strValue    = editTextValue.getText().toString();
                strTerm     = editTextTerm.getText().toString();
                name = editTextName.getText().toString();

                if(!strValue.equals("") && !strTerm.equals("") && !name.equals("")){

                    value = Double.parseDouble(strValue);

                    term = Integer.parseInt(strTerm);


                    if (id == R.id.rbEmprestimo) {
                        type = 1;
                    }

                    adapterDoMal.addItem(value, term, name, type);

                    Toast.makeText(getContext(), "ADD", Toast.LENGTH_SHORT).show();

                    clearEditText();

                } else {
                    Toast.makeText(getContext(), "VALORES INVALIDOS", Toast.LENGTH_SHORT).show();
                }

            }
        });

        adapterDoMal.setMyOnLongClickListener(new AdapterDoMal.MyOnLongClickListener() {
            @Override
            public void MyOnLongClick(int position) {
                Toast.makeText(getContext(), "Remove\t" + position, Toast.LENGTH_SHORT).show();
            }
        });

        adapterDoMal.setMyOnItemClickListener(new AdapterDoMal.MyOnItemClickListener() {
            @Override
            public void MyOnItemClick(int position) {
                if(onEditRequest != null){
                    onEditRequest.OnEditRequest(position);
                }
                Toast.makeText(getContext(), "Clicked\t" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    public void setOnEditRequest(OnEditRequest onEditRequest){
        this.onEditRequest = onEditRequest;
    }

    public void clearEditText(){
        editTextValue.getText().clear();
        editTextTerm.getText().clear();
        editTextName.getText().clear();
    }

}
