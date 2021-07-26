package wook.co.coc.view.main_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import wook.co.coc.R;
import wook.co.coc.view.bottom_nav.HomeFragment;
import wook.co.coc.view.bottom_nav.LikeFragment;
import wook.co.coc.view.bottom_nav.MyPageFragment;

public class MainPage extends AppCompatActivity {

    BottomNavigationView btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_mainpage_container);

        btnv = findViewById(R.id.bottonNav);

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame,new HomeFragment()).commit();

        btnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.home :
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new HomeFragment()).commit();
                        break;
                    case R.id.like :
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new LikeFragment()).commit();
                        break;
                    case R.id.mypage :
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new MyPageFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
}