package com.example.myrecyclerviewtest;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

public class MyRecAdapter  extends RecyclerView.Adapter<MyRecAdapter.ModelViewHolder> {


    private List<Model> list  = new ArrayList();
    private ItemModelClickListener listener;

    public void add(Model model){
        model.setState(false);
        list.add(model);
        notifyDataSetChanged();
    }
    public  void update(Model model, int position){
        list.set(position, model);
        notifyDataSetChanged();

    }
    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ModelViewHolder(view);
    }

    public MyRecAdapter(ItemModelClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {

        holder.bind(list.get(position));


    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        private TextView name,surname;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            name = itemView.findViewById(R.id.name_tv);
            surname = itemView.findViewById(R.id.sur_name_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Model model = list.get(getLayoutPosition());
                    listener.clickItemModels(model,getLayoutPosition());
                }
            });

        }


        public void bind(Model model) {
            name.setText(model.getName());
            surname.setText(model.getSurName());
        }
    }
    interface ItemModelClickListener{
       void clickItemModels(Model model,int position);
    }
    public void  setListener(ItemModelClickListener listener){
        this.listener = listener;
    }
    }

