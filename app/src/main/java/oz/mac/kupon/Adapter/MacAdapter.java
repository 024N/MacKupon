package oz.mac.kupon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import oz.mac.kupon.Model.MacModel;
import oz.mac.kupon.R;


public class MacAdapter extends RecyclerView.Adapter<MacAdapter.MyViewHolder> {

    private ArrayList<MacModel> macModels;
    private LayoutInflater inflater;

    public MacAdapter(Context context, ArrayList<MacModel> macModels) {
        inflater = LayoutInflater.from(context);
        this.macModels = macModels;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.mac_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MacModel selectedMacModel = macModels.get(position);
        holder.setData(selectedMacModel, position);
    }

    @Override
    public int getItemCount() {
        return macModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView saat, tarih, evSahibiTakim, konukTakim, macTahmini, oran, diger;

        MyViewHolder(View itemView) {
            super(itemView);
            saat = (TextView) itemView.findViewById(R.id.saat);
            tarih = (TextView) itemView.findViewById(R.id.tarih);
            evSahibiTakim = (TextView) itemView.findViewById(R.id.ev_sahibi_takim);
            konukTakim = (TextView) itemView.findViewById(R.id.konuk_takim);
            macTahmini = (TextView) itemView.findViewById(R.id.mac_tahmini);
            oran = (TextView) itemView.findViewById(R.id.oran);
            diger = (TextView) itemView.findViewById(R.id.diger);

//            deleteproduct.setOnClickListener(this);
        }

        void setData(MacModel selectedMacModel, int position) {

            this.saat.setText(selectedMacModel.getSaat());
            this.tarih.setText(selectedMacModel.getTarih());
            this.evSahibiTakim.setText(selectedMacModel.getEvSahibiTakim());
            this.konukTakim.setText(selectedMacModel.getKonukTakim());
            this.macTahmini.setText(selectedMacModel.getMacTahmini());
            this.oran.setText(selectedMacModel.getOran());
            this.diger.setText(selectedMacModel.getDiger());
        }
    }
}