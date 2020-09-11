package com.lennydennis.aadpracticeproject.fragments;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lennydennis.aadpracticeproject.R;

import java.util.Objects;

public class ConfirmDialogFragment extends DialogFragment {

    private OnClickListener mOnClickListener;

    public static ConfirmDialogFragment newInstance() {
        return new ConfirmDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.confirm_dialog_fragment, container, false);
        ImageView closeButton = view.findViewById(R.id.close_button);
        Button submitButton = view.findViewById(R.id.ok_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickListener listener = (OnClickListener) getActivity();
                if (listener!= null)
                    listener.onDismiss(ConfirmDialogFragment.this);

                dismiss();

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickListener listener = (OnClickListener) getActivity();
                if (listener != null)
                    listener.onConfirm(ConfirmDialogFragment.this);
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOnClickListener = (OnClickListener) getActivity();

    }

    public static interface OnClickListener {
        void onConfirm(ConfirmDialogFragment confirmDialogFragment);

        void onDismiss(ConfirmDialogFragment confirmDialogFragment);
    }

}