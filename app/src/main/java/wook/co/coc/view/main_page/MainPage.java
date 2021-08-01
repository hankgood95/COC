package wook.co.coc.view.main_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

    private FragmentManager manager; //FragmentManger 객체
    private FragmentTransaction transaction; //FragmentTransaction 객체 변수

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
        transaction.add(R.id.main_frame,new HomeFragment(),"home");
        transaction.commit();

        //바텀 네비게이션에서 아이템이 클릭됐을때의 리스너를 설정함
        btnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                transaction = manager.beginTransaction();
                switch(menuItem.getItemId()){
                    case R.id.home :
                        manager.popBackStack("home",FragmentManager.POP_BACK_STACK_INCLUSIVE); //백스택에 해당 "home" 중복 태그 있을시 삭제
                        transaction.replace(R.id.main_frame,new HomeFragment(),"home");
                        transaction.addToBackStack("home");
                        break;
                    case R.id.like :
                        manager.popBackStack("like",FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        transaction.replace(R.id.main_frame,new LikeFragment(),"like");
                        transaction.addToBackStack("like");
                        break;
                    case R.id.mypage :
                        manager.popBackStack("mypage",FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        transaction.replace(R.id.main_frame,new MyPageFragment(),"mypage"); //끝에 String은 TAG를 붙여서 Fragment 검색할수 있게 하기위해 붙인것임
                        transaction.addToBackStack("mypage");
                        break;
                }
                transaction.commit();
                Log.i("BackStack Count ",Integer.toString(manager.getBackStackEntryCount()));
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //바텀네비게이션이 바뀌어야 한다.
        updateBottomNav(btnv);
    }

    //Fragment가 변경될때 여길 들어옴
    private void updateBottomNav(BottomNavigationView btnv){
        //지금 현재 Fragment에서 보여지고 있는 애의 id를 가져와서 해당 id를 가지고
        //바텀 네비게이션의 item을 select하게 한다.

        String TAG = "Bottom Navigation";
        Log.i(TAG,"Update");

        Fragment home = manager.findFragmentByTag("home");
        Fragment like = manager.findFragmentByTag("like");
        Fragment mypage = manager.findFragmentByTag("mypage");

        if(home!=null && home.isVisible()){
            btnv.getMenu().findItem(R.id.home).setChecked(true);
        }
        else if(like!=null && like.isVisible()){
            btnv.getMenu().findItem(R.id.like).setChecked(true);
        }
        else if(mypage!=null && mypage.isVisible()){
            btnv.getMenu().findItem(R.id.mypage).setChecked(true);
        }
    }
}