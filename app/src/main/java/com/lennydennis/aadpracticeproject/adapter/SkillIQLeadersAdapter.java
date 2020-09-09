package com.lennydennis.aadpracticeproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lennydennis.aadpracticeproject.databinding.SkillIqItemBinding;
import com.lennydennis.aadpracticeproject.model.SkillIQScoresLeaders;

import java.util.ArrayList;

public class SkillIQLeadersAdapter extends RecyclerView.Adapter<SkillIQLeadersAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<SkillIQScoresLeaders> mSkillIQScoresLeaders;

    public SkillIQLeadersAdapter(Context context, ArrayList<SkillIQScoresLeaders> skillIQScoresLeaders) {
        mContext = context;
        mSkillIQScoresLeaders = skillIQScoresLeaders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SkillIqItemBinding skillIqItemBinding = SkillIqItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(skillIqItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillIQScoresLeaders skillIQScoresLeader = mSkillIQScoresLeaders.get(position);
        holder.skillIQBinding(skillIQScoresLeader);
    }

    @Override
    public int getItemCount() {
        return mSkillIQScoresLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public SkillIqItemBinding mSkillIqItemBinding;

        public ViewHolder(@NonNull SkillIqItemBinding skillIqItemBinding) {
            super(skillIqItemBinding.getRoot());
            mSkillIqItemBinding = skillIqItemBinding;
        }

        public void skillIQBinding(SkillIQScoresLeaders skillIQScoresLeaders){
            mSkillIqItemBinding.setSkillIQLeaders(skillIQScoresLeaders);
            mSkillIqItemBinding.executePendingBindings();
        }
    }
}
