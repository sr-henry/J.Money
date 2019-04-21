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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    View v;

    private Financiamento financiamento;
    private int position;

    private Button button;
    private EditText etNome;
    private EditText etValue;
    private RadioGroup rgType;
    private RadioButton rbDivida;
    private RadioButton rbEmprestimo;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_edit, container, false);

        button          = v.findViewById(R.id.btUpdate);
        etNome          = v.findViewById(R.id.etNomeEdit);
        etValue         = v.findViewById(R.id.etValueEdit);
        rgType          = v.findViewById(R.id.rgTypeEdit);
        rbDivida        = v.findViewById(R.id.rbDividaEdit);
        rbEmprestimo    = v.findViewById(R.id.rbEmprestimoEdit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    financiamento.setName(etNome.getText().toString());
                    financiamento.setValue(Double.parseDouble(etValue.getText().toString()));

                    if (rgType.getCheckedRadioButtonId() == R.id.rbDividaEdit){
                        financiamento.setType("divida");
                    }else{
                        financiamento.setType("emprestimo");
                    }

                    Toast.makeText(getContext(), "ATUALIZADO", Toast.LENGTH_SHORT).show();

                }catch (Exception err){
                    err.printStackTrace();
                    Toast.makeText(getContext(), "UPDATE ERRO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void onStart() {
        super.onStart();

        financiamento = Financiamentos.financiamentos.get(position);

        etNome.setText(financiamento.getName());
        etValue.setText(String.valueOf(financiamento.getValue()));

        if(financiamento.getType().equals("divida")){
            rbDivida.toggle();
        }else{
            rbEmprestimo.toggle();
        }

    }

}
