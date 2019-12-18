package oz.mac.kupon.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.fragment.app.Fragment;
import oz.mac.kupon.R;

public abstract class BaseFragment extends Fragment
{
    final String TAG = this.getClass().getSimpleName();
    private ProgressDialog progressDialog;

    public void startProgressDialog(){
        progressDialog = new ProgressDialog(getActivity(), R.style.dialogTheme);
        progressDialog.setMessage(getString(R.string.loading) + "");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(R.style.Widget_AppCompat_ProgressBar);
        progressDialog.show();
    }

    public void stopProgressDialog(){
        progressDialog.dismiss();
    }

    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}