package wook.co.coc.view.main_page;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import wook.co.coc.R;
import wook.co.coc.view.bottom_nav.HomeFragment;
import wook.co.coc.view.bottom_nav.LikeFragment;
import wook.co.coc.view.bottom_nav.MyPageFragment;

public class MainPage extends AppCompatActivity {

    //바텀 네비게이션 객체 변수
    BottomNavigationView btnv;

    //네비게이션 컨트롤러
    NavController navc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FragmentActivity","onCreated");
        setContentView(R.layout.bottomnav_container);

        btnv = findViewById(R.id.bottomNav);

        navc = Navigation.findNavController(this,R.id.botnav_host_fragment);
        NavigationUI.setupWithNavController(btnv,navc);

        //Fragment Stack에 현재 Fragment를 쌓기 위해서
        btnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.homeFragment :
                        navc.navigate(R.id.homeFragment);
                        break;
                    case R.id.likeFragment :
                        navc.navigate(R.id.likeFragment);
                        break;
                    case R.id.myPageFragment :
                        navc.navigate(R.id.myPageFragment);
                        break;
                }
                    return true;
            }
        });
    }
}