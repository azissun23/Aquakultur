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

public class KekeruhanAdapter extends RecyclerView.Adapter<KekeruhanAdapter.ViewHolder> {
    ArrayList<Kekeruhan> listKekeruhan;
    Context context;

    public KekeruhanAdapter(Context context){
        this.context = context;
    }

    public ArrayList<Kekeruhan> getListKekeruhan(){
        return listKekeruhan;
    }

    public void setListSensor(ArrayList<Kekeruhan> listKekeruhan){

        this.listKekeruhan = listKekeruhan;
    }
    @NonNull
    @Override
    public KekeruhanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kekeruhan_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KekeruhanAdapter.ViewHolder viewHolder, int i) {
        viewHolder.Ntu.setText(getListKekeruhan().get(i).getNtu());
        viewHolder.Status.setText(getListKekeruhan().get(i).getStatus());
    }

    @Override
    public int getItemCount() {return getListKekeruhan().size();}
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hasilNTU)
        TextView Ntu;
        @BindView(R.id.statusNtu)
        TextView Status;

        public ViewHolder (@NonNull View itemView){
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }

}
