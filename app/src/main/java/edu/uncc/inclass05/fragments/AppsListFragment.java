package edu.uncc.inclass05.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.inclass05.MainActivity;
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
    AppAdapter adapter;
    ListView listView;


    private static final String ARG_PARAM_CATEGORY = "category";

    private String mCategory;

    public AppsListFragment() {
        // Required empty public constructor
    }

    public static AppsListFragment newInstance(String category) {
        AppsListFragment fragment = new AppsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getString(ARG_PARAM_CATEGORY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View appListView = inflater.inflate(R.layout.fragment_apps_list, container,false);
        return appListView;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appCategoryList = DataServices.getAppsByCategory(mCategory);
        listView = view.findViewById(R.id.appList);
        adapter = new AppAdapter(getActivity().getBaseContext(), R.layout.app, appCategoryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataServices.App app = adapter.getItem(position);
                mListener.sendSelectedApp(app);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(mCategory);
    }

    public interface AppListListener{
        void sendSelectedApp(DataServices.App app);
    }

    AppListListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (AppListListener) context;
    }


}