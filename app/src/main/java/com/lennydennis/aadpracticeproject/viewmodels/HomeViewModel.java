package com.lennydennis.aadpracticeproject.viewmodels;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.views.SubmissionFragment;

public class HomeViewModel extends ViewModel {

    private Context context;

    public HomeViewModel(Context context) {
        this.context = context;
    }

    public void onClickSubmitButton(View v) {
        SubmissionFragment submissionFragment = new SubmissionFragment();
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.host_fragment, submissionFragment);
        fragmentTransaction.commit();
    }


}

