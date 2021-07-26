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

public class LikeFragment extends Fragment {
    private View view;
    private String TAG = "LikeFragment";

    //만든 layout inflate해서 View 객체를 얻어옴
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");
        view = inflater.inflate(R.layout.like_likemain,container,false);
        return view;
    }
}
