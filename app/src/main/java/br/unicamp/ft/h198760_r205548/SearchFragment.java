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

    private EditText editTextSearch;
    private Button   buttonSearch;
    private TextView textViewSearchResult;

    private String   nameToSearch;

    private String  result = "";

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        editTextSearch = v.findViewById(R.id.etSearch);
        buttonSearch = v.findViewById(R.id.btSearch);
        textViewSearchResult = v.findViewById(R.id.tvResult);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameToSearch = editTextSearch.getText().toString();

                for (int i = 0;i < Dividas.list.size();i++){
                    if(nameToSearch.equals(Dividas.list.get(i).getName())){
                        result += String.valueOf(Dividas.list.get(i).getValue()) + "\n";
                        result += String.valueOf(Dividas.list.get(i).getTerm()) + "\n";
                        result += Dividas.list.get(i).getName();

                        textViewSearchResult.setText(result);

                        break;
                    }
                }

                if(result.equals("")){
                    textViewSearchResult.setText("404 Not Found");
                }

                result = "";

            }
        });

        return v;
    }

}
