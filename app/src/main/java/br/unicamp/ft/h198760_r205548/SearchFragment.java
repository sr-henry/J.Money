package br.unicamp.ft.h198760_r205548;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private EditText etSearch;
    private Button button;
    private TextView tvResult;

    private String nameToSearch;
    private String result = "";

    Financiamento current;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search, container, false);

        etSearch    = v.findViewById(R.id.etSearch);
        button      = v.findViewById(R.id.btSearch);
        tvResult    = v.findViewById(R.id.tvResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameToSearch = etSearch.getText().toString().toLowerCase();

                for (int i = 0; i < Financiamentos.financiamentos.size(); i++){

                    current = Financiamentos.financiamentos.get(i);

                    if(nameToSearch.equals(current.getName())){
                        result += String.valueOf(current.getValue()) + "\n";
                        result += String.valueOf(current.getTerm()) + "\n";
                        result += current.getName() + "\n";
                        result += current.getTerm();

                        tvResult.setText(result);

                        break;
                    }
                }

                if(result.equals("")){
                    tvResult.setText("404 Not Found");
                }

                result = "";
            }
        });

        return v;
    }

}
