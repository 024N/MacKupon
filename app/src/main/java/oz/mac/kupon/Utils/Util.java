package oz.mac.kupon.Utils;

import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class Util {

    private String TAG = "MainActivity";
    private FirebaseFirestore database;

    public void createMacData() {
        Map<String, String> maclar = new HashMap<>();
        maclar.put("diger", "digerA");
        maclar.put("evSahibiTakim", "evsahibiA");
        maclar.put("konukTakim", "konuktakimA");
        maclar.put("macTahmini", "mactahminiA");
        maclar.put("oran", "oranA");
        maclar.put("saat", "saatA");
        maclar.put("tarih", "tarihA");

        database = FirebaseFirestore.getInstance();
        database.collection("maclar").document()
                .set(maclar)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }


    public void createKuponData() {
        Map<String, String> kupon = new HashMap<>();
        kupon.put("kuponTarih", "15.10.2019 20:00");
        kupon.put("mac1", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac2", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac3", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac4", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac5", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac6", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac7", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac8", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("mac9", "15.10.2019 20:00 Fenerbahçe - Galatasaray M.S: 2-1 --> Oran: 1.64");
        kupon.put("toplam", "512.23");

        database = FirebaseFirestore.getInstance();
        database.collection("kuponlar").document()
                .set(kupon)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

}