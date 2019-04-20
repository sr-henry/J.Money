package br.unicamp.ft.h198760_r205548;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    private EditText editTextValueEdit;
    private EditText editTextTermEdit;
    private EditText editTextNameEdit;
    private RadioButton radioButtonDivida, radioButtonEmprestimo;

    private String strValueEdit, strTermEdit, strNameEdit;

    private Button updateButton;

    private Divida obj;

    private int position;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_edit, container, false);

        editTextValueEdit   = v.findViewById(R.id.etValueEdit);
        editTextTermEdit    = v.findViewById(R.id.etTermEdit);
        editTextNameEdit    = v.findViewById(R.id.etNameEdit);
        updateButton        = v.findViewById(R.id.btUpdate);
        radioButtonDivida   = v.findViewById(R.id.rbDividaEdit);
        radioButtonEmprestimo = v.findViewById(R.id.rbEmprestimoEdit);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strValueEdit    = editTextValueEdit.getText().toString();
                strTermEdit     = editTextTermEdit.getText().toString();
                strNameEdit     = editTextNameEdit.getText().toString();

                if(!strValueEdit.equals("") && !strTermEdit.equals("") && !strNameEdit.equals("")){

                    obj.setValue(Double.parseDouble(strValueEdit));
                    obj.setTerm(Integer.parseInt(strTermEdit));
                    obj.setName(strNameEdit);

                    if(radioButtonDivida.isChecked()){
                        obj.setType(radioButtonDivida.getText().toString());
                    }
                    if(radioButtonEmprestimo.isChecked()){
                        obj.setType(radioButtonEmprestimo.getText().toString());
                    }

                    Toast.makeText(getContext(), "ATUALIZADO", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "VALORES INVALIDOS", Toast.LENGTH_SHORT).show();
                }



            }
        });

        return v;
    }

    public void setArguments(int position){
        this.position = position;
    }

    public void onStart() {
        super.onStart();

        obj = Dividas.list.get(position);

        editTextValueEdit.setText(String.valueOf(obj.getValue()));
        editTextTermEdit.setText(String.valueOf(obj.getTerm()));
        editTextNameEdit.setText(obj.getName());

        if(obj.getType().equals("Divida")){
            radioButtonDivida.toggle();
        }else{
            radioButtonEmprestimo.toggle();
        }

    }

}
