package wook.co.coc.view.cafeinfo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import wook.co.coc.R;

public class CafeInfoFrag extends Fragment {

    private String TAG = "CafeInfoFrag";
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");
        view = inflater.inflate(R.layout.cafeinfo_cafeinfo,container,false);
        return view;
    }
}
