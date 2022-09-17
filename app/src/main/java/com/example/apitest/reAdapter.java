package com.example.apitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class reAdapter extends RecyclerView.Adapter<reAdapter.MyViewHolder> implements Filterable {

 Context context;
 ArrayList<FirstAidModel> titleArray;
 ArrayList<FirstAidModel> getTitleArrayfull;

    public reAdapter(Context context, ArrayList<FirstAidModel> titleArray) {
        this.context = context;
        this.titleArray = titleArray;
        getTitleArrayfull = new ArrayList<>(titleArray);
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.task_layout,parent,false);
    MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FirstAidModel getData = titleArray.get(position);

         holder.id.setText(  String.valueOf(getData.getIdmodel()));
         holder.hospitalcode.setText(getData.getHospitalCodemodel());
         holder.hospitalname.setText(getData.getHospitalNamemodel());

    }

    @Override
    public int getItemCount() {
        return titleArray.size();
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FirstAidModel> filterList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0)
            {
                filterList.addAll(getTitleArrayfull);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (FirstAidModel item:getTitleArrayfull)
                {
                    if (item.getHospitalNamemodel().toLowerCase().contains(filterPattern))
                    {
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            titleArray.clear();
            titleArray.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView hospitalcode;
        TextView hospitalname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.id);
            hospitalname= itemView.findViewById(R.id.HospitalName);
            hospitalcode= itemView.findViewById(R.id.HospitalCode);


        }

    }
}
