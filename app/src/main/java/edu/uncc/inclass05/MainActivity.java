package edu.uncc.inclass05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.uncc.inclass05.databinding.ActivityMainBinding;
import edu.uncc.inclass05.fragments.AppCategoriesFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoriesFragment())
                .commit();
    }
}