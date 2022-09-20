package edu.uncc.inclass05.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.uncc.inclass05.MainActivity;
import edu.uncc.inclass05.R;
import edu.uncc.inclass05.databinding.FragmentAppDetailsBinding;
import edu.uncc.inclass05.models.DataServices;


public class AppDetailsFragment extends Fragment {
    FragmentAppDetailsBinding binding;

    ArrayList<String> genresList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;

    private static final String ARG_PARAM_APP = "param-app";
    private DataServices.App mApp;

    public AppDetailsFragment() {
        // Required empty public constructor
    }
    public static AppDetailsFragment newInstance(DataServices.App app) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_APP, app);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mApp = (DataServices.App) getArguments().getSerializable(ARG_PARAM_APP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppDetailsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView appName = view.findViewById(R.id.appNameLbl);
        TextView artistName = view.findViewById(R.id.artistName);
        TextView releaseDate = view.findViewById(R.id.releaseDateLbl);


        genresList = mApp.getGenres();
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, genresList);
        listView = view.findViewById(R.id.genreList);
        listView.setAdapter(adapter);



        appName.setText(mApp.getName());
        artistName.setText(mApp.getArtistName());
        releaseDate.setText(mApp.getReleaseDate());

    }
    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("App Details");
    }
}