package com.androidfundamentals.dietconsultant;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class DietDetailsFragment extends Fragment {

    private Diet diet;

    public DietDetailsFragment(Diet diet) {
        this.diet = diet;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity instanceof MainActivity) {
            activity.getSupportActionBar().setTitle("Diet Detail");
        }

        TextView name = view.findViewById(R.id.text_view_diet_name);
        TextView description = view.findViewById(R.id.text_View_diet_description);
        TextView startDate = view.findViewById(R.id.text_View_diet_start_date);
        TextView endDate = view.findViewById(R.id.text_View_diet_end_date);

        name.setText(diet.getName());
        description.setText(diet.getDescription());
        startDate.setText(diet.getStartTime());
        endDate.setText(diet.getEndTime());
    }
}
