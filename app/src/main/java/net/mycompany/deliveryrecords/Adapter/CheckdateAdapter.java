package net.mycompany.deliveryrecords.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.local_db.Entity.Records;

import java.util.List;

public class CheckdateAdapter extends RecyclerView.Adapter<CheckdateAdapter.Cholder> {
    Context ctxt;
    List<Records> records;

    public CheckdateAdapter(Context ctxt, List<Records> records) {
        this.ctxt = ctxt;
        this.records = records;
    }

    @Override
    public Cholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(ctxt).inflate(R.layout.sv_cda,parent,false);
        return new Cholder(v);
    }
    public void setNewList(List<Records> records){
        this.records=records;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull Cholder holder, int position) {
        Records r=records.get(position);
        holder.tv_date.setText(r.getDelivery_date());
        holder.tv_itemname.setText(r.getItemname());
        holder.tv_name.setText(r.getReceiver_name());
        holder.tv_location.setText(r.getLocation());
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class Cholder extends RecyclerView.ViewHolder{
        TextView tv_date,tv_itemname,tv_name,tv_location;
        public Cholder(View itemView) {
            super(itemView);
            tv_date=itemView.findViewById(R.id.tv_date_cda);
            tv_itemname=itemView.findViewById(R.id.tv_iname_cda);
            tv_name=itemView.findViewById(R.id.tv_name_cda);
            tv_location=itemView.findViewById(R.id.tv_loctaion_cda);

        }
    }
}
