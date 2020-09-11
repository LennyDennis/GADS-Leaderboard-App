package com.lennydennis.aadpracticeproject.views;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Window;
import android.view.WindowManager;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.databinding.ActivityMainBinding;
import com.lennydennis.aadpracticeproject.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));

        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        if (savedInstanceState == null) {
//            HomeFragment homeFragment = new HomeFragment();
            SubmissionFragment submissionFragment = new SubmissionFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.host_fragment, submissionFragment);
            fragmentTransaction.commit();

        }

        mMainActivityViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainActivityViewModel.class);
    }
}