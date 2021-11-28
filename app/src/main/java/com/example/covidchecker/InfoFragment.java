package com.example.covidchecker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;


public class InfoFragment extends Fragment {

    View view;
    TextView info_code;
    TextView info_lat;
    TextView info_long;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_info, container, false);
        info_code = view.findViewById(R.id.info_code);
//        info_code.setVisibility(View.GONE);
        info_lat = view.findViewById(R.id.info_lat);
//        info_lat.setVisibility(View.GONE);
        info_long = view.findViewById(R.id.info_long);
//        info_long.setVisibility(View.GONE);
        TextView lbl1 = view.findViewById(R.id.lbl1);
//        lbl1.setVisibility(View.GONE);
        TextView lbl2 = view.findViewById(R.id.lbl2);
//        lbl2.setVisibility(View.GONE);
        TextView lbl3 = view.findViewById(R.id.lbl3);
//        lbl3.setVisibility(View.GONE);
        TextView lbl4 = view.findViewById(R.id.lbl4);
//        lbl4.setVisibility(View.GONE);
        TextView lbl5 = view.findViewById(R.id.lbl5);
//        lbl5.setVisibility(View.GONE);
        TextView lbl6 = view.findViewById(R.id.lbl6);
//        lbl6.setVisibility(View.GONE);
        try {
            String country = getArguments().getString("country_name", "");
            String latitude = getArguments().getString("latitude", "");
            String longitude = getArguments().getString("longitude", "");
            String countryCode = getArguments().getString("country_code", "");
            if (country != null){
//                lbl1.setVisibility(View.VISIBLE);
//                lbl2.setVisibility(View.VISIBLE);
//                lbl3.setVisibility(View.VISIBLE);
//                lbl4.setVisibility(View.VISIBLE);
//                lbl5.setVisibility(View.VISIBLE);
//                lbl6.setVisibility(View.VISIBLE);
                info_code.setText(countryCode);
//                info_code.setVisibility(View.VISIBLE);
                info_lat.setText(latitude);
//                info_lat.setVisibility(View.VISIBLE);
                info_long.setText(longitude);
//                info_long.setVisibility(View.VISIBLE);
            } else {
                Snackbar.make(view, "negara tidak ditemukan", Snackbar.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }
}