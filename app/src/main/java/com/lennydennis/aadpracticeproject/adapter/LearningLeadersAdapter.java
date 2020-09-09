package com.lennydennis.aadpracticeproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.databinding.LearningItemBinding;
import com.lennydennis.aadpracticeproject.model.LearningHoursLeaders;

import java.util.ArrayList;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<LearningHoursLeaders> mLearningHoursLeaders;

    public LearningLeadersAdapter(Context context, ArrayList<LearningHoursLeaders> learningHoursLeaders) {
        mContext = context;
        mLearningHoursLeaders = learningHoursLeaders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LearningItemBinding learningItemBinding = LearningItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(learningItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningHoursLeaders learningHoursLeader = mLearningHoursLeaders.get(position);
        holder.bindView(learningHoursLeader);

    }

    @Override
    public int getItemCount() {
        return mLearningHoursLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LearningItemBinding mLearningItemBinding;

        public ViewHolder(@NonNull LearningItemBinding learningItemBinding) {
            super(learningItemBinding.getRoot());
            this.mLearningItemBinding = learningItemBinding;
        }

        public void bindView(LearningHoursLeaders learningHoursLeader){
            mLearningItemBinding.setLearningLeaders(learningHoursLeader);
            mLearningItemBinding.executePendingBindings();
        }

    }
}
