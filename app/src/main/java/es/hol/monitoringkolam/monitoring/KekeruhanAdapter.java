package es.hol.monitoringkolam.monitoring;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.hol.monitoringkolam.monitoring.pojo.Kekeruhan;

public class KekeruhanAdapter extends RecyclerView.Adapter<KekeruhanAdapter.ViewHolder> {
    ArrayList<Kekeruhan> listkekeruhan;
    Context context;

    KekeruhanAdapter(Context context){this.context = context;}

    public ArrayList<Kekeruhan>getListkekeruhan(){return listkekeruhan;}
    public void setListkekeruhan(ArrayList<Kekeruhan>listkekeruhan){
        this.listkekeruhan = listkekeruhan;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kekeruhan_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.ntu.setText(getListkekeruhan().get(i).getNtu());
        viewHolder.status.setText(getListkekeruhan().get(i).getStatus());
    }

    @Override
    public int getItemCount() {return getListkekeruhan().size();}
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hasilNTU)
        TextView ntu;
        @BindView(R.id.status)
        TextView status;

        public ViewHolder (@NonNull View itemView){
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }

}
