package edu.uncc.inclass05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import edu.uncc.inclass05.databinding.ActivityMainBinding;
import edu.uncc.inclass05.fragments.AppCategoriesFragment;
import edu.uncc.inclass05.fragments.AppDetailsFragment;
import edu.uncc.inclass05.fragments.AppsListFragment;
import edu.uncc.inclass05.models.DataServices;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.CategoryInt, AppsListFragment.AppListListener {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onResume() {
        super.onResume();
        setTitle("App Categories");
    }

    @Override
    public void gotoListFrag1(String category) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, AppsListFragment.newInstance(category))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void sendSelectedApp(DataServices.App app) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, AppDetailsFragment.newInstance(app))
                .addToBackStack(null)
                .commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }



}