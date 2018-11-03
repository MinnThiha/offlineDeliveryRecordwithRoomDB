package net.mycompany.deliveryrecords.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.mycompany.deliveryrecords.CallBack.RecordsCallBack;
import net.mycompany.deliveryrecords.local_db.Entity.Records;


import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.Rholder> {
    Context ctxt;
    List<Records> record;
    RecordsCallBack rcb;


    public RecordAdapter(Context ctxt, List<Records> record) {
        this.ctxt = ctxt;
        this.record = record;
    }
    public void setnewRecord(List<Records> n){
        this.record=n;
        notifyDataSetChanged();
    }
    public void recordCallbackListener(RecordsCallBack rcb){
        this.rcb=rcb;
    }

    @Override
    public Rholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(ctxt).inflate(net.mycompany.deliveryrecords.R.layout.sv_ca,parent,false);
        return new Rholder(v);
    }

    @Override
    public void onBindViewHolder(Rholder holder, int position) {
        Records r=record.get(position);
        holder.tv_item.setText(r.getItemname());
        holder.tv_name.setText(r.getReceiver_name());
        holder.tv_location.setText(r.getLocation());
        holder.tv_ph.setText(r.getReceiver_ph());
        holder.tv_date.setText(r.getDelivery_date());
    }

    @Override
    public int getItemCount() {
        return record.size();
    }

    public class Rholder extends RecyclerView.ViewHolder{
        TextView tv_item,tv_name,tv_location,tv_ph,tv_date;
        public Rholder(View itemView) {
            super(itemView);
            tv_item=itemView.findViewById(net.mycompany.deliveryrecords.R.id.tv_name_svca);
            tv_name=itemView.findViewById(net.mycompany.deliveryrecords.R.id.tv_rn_svca);
            tv_location=itemView.findViewById(net.mycompany.deliveryrecords.R.id.tv_loctaion_svca);
            tv_ph=itemView.findViewById(net.mycompany.deliveryrecords.R.id.tv_ph_svca);
            tv_date=itemView.findViewById(net.mycompany.deliveryrecords.R.id.tv_date_svca);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    rcb.recordOnclickListener(record.get(getAdapterPosition()));
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    rcb.recordOnlongClickListener(record.get(getAdapterPosition()));
                    return true;
                }
            });
        }
    }
}
