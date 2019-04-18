package br.unicamp.ft.h198760_r205548;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDoMal extends RecyclerView.Adapter {

    private ArrayList<Divida> list;

    public AdapterDoMal(ArrayList<Divida> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolderDoMal holderDoMal = new ViewHolderDoMal(v);
        return holderDoMal;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolderDoMal)viewHolder).bind(list.get(i), i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderDoMal extends RecyclerView.ViewHolder{

        private TextView textViewValue;
        private TextView textViewTerm;
        private TextView textViewName;

        private int      position;

        public ViewHolderDoMal(@NonNull View itemView) {
            super(itemView);

            textViewValue   = itemView.findViewById(R.id.tvValue);
            textViewTerm    = itemView.findViewById(R.id.tvTerm);
            textViewName    = itemView.findViewById(R.id.tvName);
        }

        public void bind(Divida divida, int pos){
            textViewValue.setText(String.valueOf(divida.getValue()));
            textViewTerm.setText(String.valueOf(divida.getTerm()));
            textViewName.setText(divida.getName());
            this.position = pos;
        }

        public int getHolderPos(){
            return position;
        }

    }

}
