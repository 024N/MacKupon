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
import oz.mac.kupon.DB.DBHelper;
import oz.mac.kupon.Adapter.MacAdapter;
import oz.mac.kupon.Model.MacModel;
import oz.mac.kupon.R;

public class MacFragment extends BaseFragment {
    private DBHelper dbHelper;
    private String TAG = "MacFragment";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.mac_fragment, container, false);
        RecyclerView macRecyclerView = view.findViewById(R.id.mac_recylerview);

        dbHelper = new DBHelper(getActivity());

        ArrayList<MacModel> sortedList = getSortedList();
        Collections.reverse(sortedList);

        MacAdapter macAdapter = new MacAdapter(getActivity(), sortedList);
        macRecyclerView.setAdapter(macAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        macRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    private ArrayList<MacModel> getDataFromDB() {
        return  dbHelper.getAllMac();
    }

    private ArrayList<MacModel> getSortedList(){

        ArrayList<MacModel> sortedList = getDataFromDB();

        Collections.sort(sortedList, new Comparator<MacModel>() {
            @Override
            public int compare(MacModel o1, MacModel o2) {
                return o1.getDocumentID().compareTo(o2.getDocumentID());
            }
        });
        return sortedList;
    }
}