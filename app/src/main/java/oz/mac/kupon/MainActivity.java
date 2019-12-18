package oz.mac.kupon;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.onesignal.OneSignal;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import oz.mac.kupon.DB.DBHelper;
import oz.mac.kupon.Fragment.KuponFragment;
import oz.mac.kupon.Fragment.MacFragment;
import oz.mac.kupon.Model.KuponModel;
import oz.mac.kupon.Model.MacModel;
import oz.mac.kupon.Utils.Util;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends BaseActivity{

    private String TAG = "MainActivity";
    private FirebaseFirestore database;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        startProgressDialog();
        if(isNetworkAvailable()) {
            database = FirebaseFirestore.getInstance();            // Access a Cloud Firestore instance from your Activity
            readMacFromCloud();
        }
        else{
            Toast.makeText(this, "Güncellenemiyor, lütfen internet bağlantınızı kontrol edin!", Toast.LENGTH_LONG).show();
            stopProgressDialog();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.getBackground().setAlpha(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void readMacFromCloud(){
        database.collection("maclar")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            dbHelper.deleteMaclar();
                            dbHelper.deleteKuponlar();
                            dbHelper.createTables();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                dbHelper.insertMaclar(document.toObject(MacModel.class), document.getId());
                            }
                            readKuponFromCloud();
                            fragmentRouter("macFragment");
                            stopProgressDialog();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            Toast.makeText(getApplicationContext(),"Bir hata oluştu daha sonra tekrar deneyiniz.", Toast.LENGTH_LONG).show();
                            stopProgressDialog();
                        }
                    }
                });
    }

    private void readKuponFromCloud(){
        database.collection("kuponlar")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                dbHelper.insertKuponlar(document.toObject(KuponModel.class), document.getId());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            Toast.makeText(getApplicationContext(),"Bir hata oluştu daha sonra tekrar deneyiniz.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void fragmentRouter(String fragmentType){
        if(!isNetworkAvailable()) {
            Toast.makeText(this, "Güncellenemiyor, lütfen internet bağlantınızı kontrol edin!", Toast.LENGTH_LONG).show();
        }

        Fragment fragment = (fragmentType.equals("macFragment")) ? new MacFragment(): new KuponFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); //fragmentleri temizler
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.content, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentRouter("macFragment");
                    return true;
                case R.id.navigation_dashboard:
                    fragmentRouter("kuponFragment");
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        finish();
        startActivity(getIntent());
    }
}