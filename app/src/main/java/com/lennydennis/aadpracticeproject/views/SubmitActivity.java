package com.lennydennis.aadpracticeproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.databinding.ActivityMainBinding;
import com.lennydennis.aadpracticeproject.databinding.ActivitySubmitBinding;
import com.lennydennis.aadpracticeproject.fragments.ConfirmDialogFragment;
import com.lennydennis.aadpracticeproject.fragments.SubmissionDialogFragment;
import com.lennydennis.aadpracticeproject.model.Submission;
import com.lennydennis.aadpracticeproject.viewmodels.MainActivityViewModel;
import com.lennydennis.aadpracticeproject.viewmodels.SubmitActivityViewModel;

public class SubmitActivity extends AppCompatActivity implements ConfirmDialogFragment.OnClickListener {

    SubmitActivityViewModel mSubmitActivityViewModel;
    ActivitySubmitBinding mActivitySubmitBinding;
    private Submission mSubmission;
    private ConfirmDialogFragment mConfirmDialogFragment;
    SubmissionDialogFragment mSubmissionDialogFragment = new SubmissionDialogFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));

        mActivitySubmitBinding = ActivitySubmitBinding.inflate(getLayoutInflater());
        setContentView(mActivitySubmitBinding.getRoot());
        mSubmitActivityViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SubmitActivityViewModel.class);
        mSubmitActivityViewModel.getStatus().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer status) {
                if (status != SubmitActivityViewModel.STATUS_NEUTRAL) {
                    mSubmissionDialogFragment.setSuccess(status == SubmitActivityViewModel.STATUS_OK);
                    mSubmissionDialogFragment.show(getSupportFragmentManager(), "SubmitActivity_SubmitResultDialog");
                }
            }
        });
        mConfirmDialogFragment = new ConfirmDialogFragment();

        Button submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mActivitySubmitBinding.firstName.getText().toString();
                String lastName = mActivitySubmitBinding.lastName.getText().toString();
                String emailAddress = mActivitySubmitBinding.emailAddress.getText().toString();
                String githubLink = mActivitySubmitBinding.githubLink.getText().toString();
                mSubmission = new Submission(firstName, lastName, emailAddress, githubLink);
                boolean allFieldFilled = firstName.length() > 0 && lastName.length() > 0 && emailAddress.length() > 0 && githubLink.length() > 0;
                if (allFieldFilled) {
                    mConfirmDialogFragment.show(getSupportFragmentManager(), "Confirm Dialog");

                } else {
                    Toast.makeText(SubmitActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onConfirm(ConfirmDialogFragment confirmDialogFragment) {
        mSubmitActivityViewModel.submitProject(mSubmission);
    }

    @Override
    public void onDismiss(ConfirmDialogFragment confirmDialogFragment) {

    }
}