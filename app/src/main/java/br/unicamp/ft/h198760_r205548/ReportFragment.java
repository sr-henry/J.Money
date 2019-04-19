package br.unicamp.ft.h198760_r205548;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {

    private Button     buttonReport;
    private TextView tvReport;

    private double divida = 0;
    private double emprestimo = 0;
    private double report;

    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        tvReport = v.findViewById(R.id.tvReport);
        buttonReport = v.findViewById(R.id.btReport);


        buttonReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < Dividas.list.size(); i++){
                    if(Dividas.list.get(i).getType() == 0){
                        divida -= Dividas.list.get(i).getValue();
                    }else {
                        emprestimo += Dividas.list.get(i).getValue();
                    }
                }

                report = emprestimo+divida;

                tvReport.setText(String.valueOf(report));

                emprestimo = 0;
                divida = 0;
                report = 0;

            }
        });


        return v;
    }

}
