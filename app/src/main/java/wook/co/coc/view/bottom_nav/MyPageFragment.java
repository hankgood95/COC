package wook.co.coc.view.bottom_nav;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import wook.co.coc.R;

public class MyPageFragment extends Fragment {

    private View view;
    private String TAG = "MyPageFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i(TAG,"onCreateView");

        view = inflater.inflate(R.layout.mypage_main,container,false);
        return view;
    }
}
