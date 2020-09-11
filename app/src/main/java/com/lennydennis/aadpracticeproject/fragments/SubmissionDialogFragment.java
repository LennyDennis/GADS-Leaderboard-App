package com.lennydennis.aadpracticeproject.fragments;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.databinding.SubmissionDialogFragmentBinding;
import com.lennydennis.aadpracticeproject.databinding.SubmissionFragmentBinding;
import com.lennydennis.aadpracticeproject.model.Submission;

import java.util.Objects;

public class SubmissionDialogFragment extends DialogFragment {

    private boolean success;
    private TextView mSubmissionText;
    private ImageView mSubmissionImage;

    public SubmissionDialogFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.submission_dialog_fragment, container, false);
        mSubmissionText = view.findViewById(R.id.submission_text);
        mSubmissionImage = view.findViewById(R.id.submission_image);
        if (success) {
            mSubmissionText.setText(R.string.submission_successful);
            mSubmissionImage.setImageResource(R.drawable.ic_baseline_check_circle_24);
        } else {
            mSubmissionText.setText(R.string.submission_not_successful);
            mSubmissionImage.setImageResource(R.drawable.ic_baseline_report_problem_24);
        }
        return view;
    }


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
        TextView textView = (TextView) getView();
        ImageView imageView = (ImageView) getView();
        if (textView != null && imageView != null) {
            if (success) {
                textView.setText(R.string.submission_successful);
                imageView.setImageResource(R.drawable.ic_baseline_check_circle_24);
            } else {
                textView.setText(R.string.submission_not_successful);
                imageView.setImageResource(R.drawable.ic_baseline_report_problem_24);
            }
        }
    }

}