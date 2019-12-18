package oz.mac.kupon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import oz.mac.kupon.Model.KuponModel;
import oz.mac.kupon.Model.MacModel;
import oz.mac.kupon.R;

import static android.view.View.VISIBLE;


public class KuponAdapter extends RecyclerView.Adapter<KuponAdapter.MyViewHolder> {

    private ArrayList<KuponModel> kuponModels;
    private LayoutInflater inflater;

    public KuponAdapter(Context context, ArrayList<KuponModel> kuponModels) {
        inflater = LayoutInflater.from(context);
        this.kuponModels = kuponModels;
    }


    @Override
    public KuponAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.kupon_row, parent, false);
        KuponAdapter.MyViewHolder holder = new KuponAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(KuponAdapter.MyViewHolder holder, int position) {
        KuponModel selectedKuponModel = kuponModels.get(position);
        holder.setData(selectedKuponModel, position);
    }

    @Override
    public int getItemCount() {
        return kuponModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView kuponTarih, mac1, mac2, mac3, mac4, mac5, mac6, mac7, mac8, mac9, toplam;

        MyViewHolder(View itemView) {
            super(itemView);
            kuponTarih = (TextView) itemView.findViewById(R.id.kupon_tarih);
            mac1 = (TextView) itemView.findViewById(R.id.kupon_mac_1);
            mac2 = (TextView) itemView.findViewById(R.id.kupon_mac_2);
            mac3 = (TextView) itemView.findViewById(R.id.kupon_mac_3);
            mac4 = (TextView) itemView.findViewById(R.id.kupon_mac_4);
            mac5 = (TextView) itemView.findViewById(R.id.kupon_mac_5);
            mac6 = (TextView) itemView.findViewById(R.id.kupon_mac_6);
            mac7 = (TextView) itemView.findViewById(R.id.kupon_mac_7);
            mac8 = (TextView) itemView.findViewById(R.id.kupon_mac_8);
            mac9 = (TextView) itemView.findViewById(R.id.kupon_mac_9);
            toplam = (TextView) itemView.findViewById(R.id.toplam);
        }

        void setData(KuponModel selectedKuponModel, int position) {
            this.kuponTarih.setText(selectedKuponModel.getKuponTarih());
            this.mac1.setText(selectedKuponModel.getMac1());
            if(!(selectedKuponModel.getMac2() == null || selectedKuponModel.getMac2().equals(""))) {
                this.mac2.setVisibility(VISIBLE);
                this.mac2.setText(selectedKuponModel.getMac2());
            }
            if(!(selectedKuponModel.getMac3() == null || selectedKuponModel.getMac3().equals(""))) {
                this.mac3.setVisibility(VISIBLE);
                this.mac3.setText(selectedKuponModel.getMac3());
            }
            if(!(selectedKuponModel.getMac4() == null || selectedKuponModel.getMac4().equals(""))) {
                this.mac4.setVisibility(VISIBLE);
                this.mac4.setText(selectedKuponModel.getMac4());
            }
            if(!(selectedKuponModel.getMac5() == null || selectedKuponModel.getMac5().equals(""))) {
                this.mac5.setVisibility(VISIBLE);
                this.mac5.setText(selectedKuponModel.getMac5());
            }
            if(!(selectedKuponModel.getMac6() == null || selectedKuponModel.getMac6().equals(""))) {
                this.mac6.setVisibility(VISIBLE);
                this.mac6.setText(selectedKuponModel.getMac6());
            }
            if(!(selectedKuponModel.getMac7() == null || selectedKuponModel.getMac7().equals(""))) {
                this.mac7.setVisibility(VISIBLE);
                this.mac7.setText(selectedKuponModel.getMac7());
            }
            if(!(selectedKuponModel.getMac8() == null || selectedKuponModel.getMac8().equals(""))) {
                this.mac8.setVisibility(VISIBLE);
                this.mac8.setText(selectedKuponModel.getMac8());
            }
            if(!(selectedKuponModel.getMac9() == null || selectedKuponModel.getMac9().equals(""))) {
                this.mac9.setVisibility(VISIBLE);
                this.mac9.setText(selectedKuponModel.getMac9());
            }
            this.toplam.setText(selectedKuponModel.getToplam());
        }
    }
}