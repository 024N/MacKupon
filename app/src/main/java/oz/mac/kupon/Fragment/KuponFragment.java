package oz.mac.kupon.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import oz.mac.kupon.Adapter.KuponAdapter;
import oz.mac.kupon.DB.DBHelper;
import oz.mac.kupon.Model.KuponModel;
import oz.mac.kupon.R;

public class KuponFragment extends BaseFragment {
    private DBHelper dbHelper;
    private String TAG = "KuponFragment";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.kupon_fragment, container, false);
        RecyclerView kuponRecyclerView = view.findViewById(R.id.kupon_recylerview);

        dbHelper = new DBHelper(getActivity());

        ArrayList<KuponModel> sortedList = getSortedList();
        Collections.reverse(sortedList);

        KuponAdapter kuponAdapter = new KuponAdapter(getActivity(), sortedList);
        kuponRecyclerView.setAdapter(kuponAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        kuponRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    private ArrayList<KuponModel> getDataFromDB() {
        return  dbHelper.getAllKupon();
    }

    private ArrayList<KuponModel> getSortedList(){

        ArrayList<KuponModel> sortedList = getDataFromDB();

        Collections.sort( sortedList, new Comparator<KuponModel>() {
            @Override
            public int compare(KuponModel o1, KuponModel o2) {
                return o1.getDocumentID().compareTo(o2.getDocumentID());
            }
        });
        return sortedList;
    }
}