package edu.uncc.inclass05.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.uncc.inclass05.R;
import edu.uncc.inclass05.models.DataServices;

public class AppAdapter extends ArrayAdapter<DataServices.App> {
    public AppAdapter(@NonNull Context context, int resource, @NonNull List<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.app,parent,false);
        }
        DataServices.App app = getItem(position);
        TextView appName = convertView.findViewById(R.id.appName);
        TextView artistName = convertView.findViewById(R.id.artistNameTxt);
        TextView releaseDate = convertView.findViewById(R.id.releaseDate);

        appName.setText(app.getName());
        artistName.setText(app.getArtistName());
        releaseDate.setText(app.getReleaseDate());

        return convertView;
    }
}
