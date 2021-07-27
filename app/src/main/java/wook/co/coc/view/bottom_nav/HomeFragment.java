package wook.co.coc.view.bottom_nav;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import wook.co.coc.R;
import wook.co.coc.view.cafeinfo.CafeInfoFrag;

public class HomeFragment extends Fragment {

    private View view;
    private String TAG = "HomeFragment";
    private Button hotCafe;
    private Button searchCafe;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    //만든 layout inflate해서 View 객체를 얻어옴
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreatView");

        //layoyt 불러와서 해당 layout inflate 시켜서 view create 한다.
        view = inflater.inflate(R.layout.mainpage_mainpage,container,false);

        manager = getParentFragmentManager();
        transaction = manager.beginTransaction();

        //핫한 카페로 이동하는 버튼 가져옴
        hotCafe = view.findViewById(R.id.hot_cafe);
        searchCafe = view.findViewById(R.id.search_cafe);

        hotCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.main_frame,new CafeInfoFrag());
                transaction.commit();
            }
        });

        return view;
    }
}
