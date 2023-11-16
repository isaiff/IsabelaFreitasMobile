package br.com.germinare.isabelafreitasmobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.FirebaseApp;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.germinare.isabelafreitasmobile.presenter.fragments.bichos.BichosFragment;
import br.com.germinare.isabelafreitasmobile.presenter.fragments.placar.PlacarFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpActivity();
    }

    private void setUpActivity() {
        initFirebase();
        ViewPager viewPager = findViewById(R.id.viewPager);
        SmartTabLayout tabLayout = findViewById(R.id.tabLayout);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Bichos", BichosFragment.class)
                .add("Placar de estudo", PlacarFragment.class)
                .create());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
    }

}