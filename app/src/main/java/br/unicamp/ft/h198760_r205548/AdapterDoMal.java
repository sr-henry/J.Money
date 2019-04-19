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
    private MyOnLongClickListener myOnLongClickListener;
    private MyOnItemClickListener myOnItemClickListener;
    private int currentPos;

    public AdapterDoMal(ArrayList<Divida> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        final ViewHolderDoMal holderDoMal = new ViewHolderDoMal(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.MyOnItemClick(holderDoMal.getHolderPos());
            }
        });

        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(myOnLongClickListener != null){
                    currentPos = holderDoMal.getAdapterPosition();
                    removeItem(currentPos);
                    myOnLongClickListener.MyOnLongClick(currentPos);
                }
                return true;
            }
        });

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
        private TextView textViewType;

        private int      position;

        public ViewHolderDoMal(@NonNull View itemView) {
            super(itemView);

            textViewValue   = itemView.findViewById(R.id.tvValue);
            textViewTerm    = itemView.findViewById(R.id.tvTerm);
            textViewName    = itemView.findViewById(R.id.tvName);
            textViewType    = itemView.findViewById(R.id.tvType);
        }

        public void bind(Divida divida, int pos){
            textViewValue.setText(String.valueOf(divida.getValue()));
            textViewTerm.setText(String.valueOf(divida.getTerm()));
            textViewName.setText(divida.getName());

            if(divida.getType() == 0){
                textViewType.setText("Divida");
            }else{
                textViewType.setText("Emprestimo");
            }

            this.position = pos;
        }

        public int getHolderPos(){
            return position;
        }

    }

    public void addItem(double value, int term, String name, int type){
        list.add(new Divida(value, term, name, type));
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    public interface MyOnLongClickListener{
        void MyOnLongClick (int position);
    }

    public  void setMyOnLongClickListener(MyOnLongClickListener listener){
        this.myOnLongClickListener = listener;
    }

    public interface MyOnItemClickListener{
        void MyOnItemClick(int position);
    }

    public void setMyOnItemClickListener(MyOnItemClickListener listener){
        this.myOnItemClickListener = listener;
    }

}
