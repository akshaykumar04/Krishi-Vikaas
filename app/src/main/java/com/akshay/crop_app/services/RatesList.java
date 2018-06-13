package com.akshay.crop_app.services;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akshay.crop_app.R;

import java.util.List;

/**
 * Created by Akshay on 17-04-2018.
 */

public class RatesList extends ArrayAdapter<Rates> {
    private Activity context;
    List<Rates> rates;

    public RatesList(Activity context, List<Rates> rates) {
        super(context, R.layout.layout_rates_list, rates);
        this.context = context;
        this.rates = rates;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_rates_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewRate = (TextView) listViewItem.findViewById(R.id.textViewEmail);
        TextView textViewPlace = (TextView) listViewItem.findViewById(R.id.textViewMob);


        Rates rate = rates.get(position);
        textViewName.setText(rate.getCrop_name());
        textViewRate.setText(rate.getRate());
        textViewPlace.setText(rate.getPlace());


        return listViewItem;
    }
}
