package wook.co.coc.view.main_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import wook.co.coc.R;
import wook.co.coc.view.bottom_nav.HomeFragment;
import wook.co.coc.view.bottom_nav.LikeFragment;
import wook.co.coc.view.bottom_nav.MyPageFragment;

public class MainPage extends AppCompatActivity {

    //바텀 네비게이션 객체 변수
    BottomNavigationView btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnav_container);

        //바텀 네비게이션 객체를 받아옴
        btnv = findViewById(R.id.bottonNav);

        //Fragment매니저를 불러와서 bottomnav_container.xml안에 Fragment들을 겹쳐서 보여줄 FrameLayout에 HomeFragment를 연결해서 화면에 띄움
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame,new HomeFragment()).commit();

        //바텀 네비게이션에서 아이템이 클릭됐을때의 리스너를 설정함
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