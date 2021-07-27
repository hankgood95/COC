package wook.co.coc.view.main_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnav_container);

        //바텀 네비게이션 객체를 받아옴
        btnv = findViewById(R.id.bottonNav);

        //Fragment매니저 불러옴
        manager = getSupportFragmentManager();
        //Fragment와의 연결시작
        transaction = manager.beginTransaction();

        //Fragment매니저를 불러와서 bottomnav_container.xml안에 Fragment들을 겹쳐서 보여줄 FrameLayout에 HomeFragment를 연결해서 화면에 띄움
        transaction.replace(R.id.main_frame,new HomeFragment()).commit();

        //바텀 네비게이션에서 아이템이 클릭됐을때의 리스너를 설정함
        btnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                transaction = manager.beginTransaction();
                switch(menuItem.getItemId()){
                    case R.id.home :
                        transaction.replace(R.id.main_frame,new HomeFragment());
                        transaction.commit();
                        break;
                    case R.id.like :
                        transaction.replace(R.id.main_frame,new LikeFragment());
                        transaction.commit();
                        break;
                    case R.id.mypage :
                        transaction.replace(R.id.main_frame,new MyPageFragment());
                        transaction.commit();
                        break;
                }
                return true;
            }
        });
    }
}