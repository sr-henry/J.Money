package br.unicamp.ft.h198760_r205548;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {

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

        for(int i = 0; i < Financiamentos.financiamentos.size(); i++){
            if(Financiamentos.financiamentos.get(i).getType().equals("divida")){
                divida -= Financiamentos.financiamentos.get(i).getValue();
            }else {
                emprestimo += Financiamentos.financiamentos.get(i).getValue();
            }
        }

        report = emprestimo+divida;

        tvReport.setText(String.valueOf(report));

        emprestimo = 0;
        divida = 0;
        report = 0;

        return v;
    }

}
