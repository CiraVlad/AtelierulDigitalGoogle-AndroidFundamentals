package com.androidfundamentals.dietconsultant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DietListFragment extends Fragment implements ClickListenerCallback {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retrieveDiets(view);
    }

    private void retrieveDiets(View view) {
        Diet diet1 = new Diet("Diet1", "description", "22.03.2020", "19.06.2020");
        Diet diet2 = new Diet("Diet2", "description", "22.03.2020", "19.06.2020");
        Diet diet3 = new Diet("Diet3", "description", "22.03.2020", "19.06.2020");
        Diet diet4 = new Diet("Diet4", "description", "22.03.2020", "19.06.2020");

        List<Diet> diets = new ArrayList<>();
        diets.add(diet1);
        diets.add(diet2);
        diets.add(diet3);
        diets.add(diet4);

        DietAdapter adapter = new DietAdapter(diets, this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDietClick(Diet diet) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_details, new DietDetailsFragment(diet))
                .addToBackStack("DietDetailsFragment")
                .commit();

    }
}
