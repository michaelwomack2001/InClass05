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

import java.util.ArrayList;

import edu.uncc.inclass05.R;
import edu.uncc.inclass05.databinding.FragmentAppCategoriesBinding;
import edu.uncc.inclass05.databinding.FragmentAppsListBinding;
import edu.uncc.inclass05.models.DataServices;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppsListFragment extends Fragment {

    FragmentAppsListBinding binding;
    ArrayList<DataServices.App> appCategoryList = new ArrayList<DataServices.App>();
    ArrayAdapter<DataServices.App> adapter;
    ListView listView;
    String Tag;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AppsListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppsListFragment newInstance(String param1, String param2) {
        AppsListFragment fragment = new AppsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View appListView = inflater.inflate(R.layout.fragment_apps_list, container,false);
        if(Tag.equals("New Apps We Love")){
            appCategoryList = DataServices.getAppsByCategory(Tag);
        }
        else if(Tag.equals("New Games We Love")){
            appCategoryList = DataServices.getAppsByCategory(Tag);
        }
        else if(Tag.equals("Top Free Apps")){
            appCategoryList = DataServices.getAppsByCategory(Tag);
        }
        else if(Tag.equals(("Top Grossing Apps"))){
            appCategoryList = DataServices.getAppsByCategory(Tag);
        }
        else if(Tag.equals("Top Paid Apps")){
            appCategoryList = DataServices.getAppsByCategory(Tag);
        }

        listView = appListView.findViewById(R.id.appList);
        adapter = new ArrayAdapter<DataServices.App>(getContext(), android.R.layout.simple_expandable_list_item_1, appCategoryList);
        listView.setAdapter(adapter);
        return appListView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}