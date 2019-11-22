package com.kharismarizqii.holiyeay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DestinationAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Destination> destinations = new ArrayList<>();

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public DestinationAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return destinations.size();
    }

    @Override
    public Object getItem(int position) {
        return destinations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_destination, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        Destination destination =  (Destination) getItem(position);
        viewHolder.bind(destination);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDesc;
        private TextView txtRating;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.tv_dest);
            txtDesc = view.findViewById(R.id.tv_desc);
            txtRating = view.findViewById(R.id.tv_rating);
        }

        void bind(Destination destination){
            txtName.setText(destination.getName());
            txtRating.setText(destination.getRating());
            txtDesc.setText(destination.getDescription());
        }
    }
}
