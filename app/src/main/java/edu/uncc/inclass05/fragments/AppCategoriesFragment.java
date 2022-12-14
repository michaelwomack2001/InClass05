package edu.uncc.inclass05.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.uncc.inclass05.R;
import edu.uncc.inclass05.databinding.FragmentAppCategoriesBinding;
import edu.uncc.inclass05.models.DataServices;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppCategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppCategoriesFragment extends Fragment {

    FragmentAppCategoriesBinding binding;
    ArrayList<String> appCategoryList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView appCategoryLv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AppCategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppCategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppCategoriesFragment newInstance(String param1, String param2) {
        AppCategoriesFragment fragment = new AppCategoriesFragment();
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
        View appCategoryFragment = inflater.inflate(R.layout.fragment_app_categories, container, false);

        appCategoryList = DataServices.getAppCategories();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1, appCategoryList);
        appCategoryLv = appCategoryFragment.findViewById(R.id.appCategories);
        appCategoryLv.setAdapter(adapter);

        appCategoryLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String services = appCategoryList.get(position);
                Log.d("demo", String.valueOf(position)+services);
                categoryInt.gotoListFrag1(services);



            }
        });

        return appCategoryFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    CategoryInt categoryInt;
    public interface CategoryInt{
        void gotoListFrag1(String dataParse);
        }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof CategoryInt) {
            categoryInt = (CategoryInt) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement CategoryInt");
        }

    }
}