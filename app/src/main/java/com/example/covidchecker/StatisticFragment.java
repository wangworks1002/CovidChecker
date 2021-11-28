package com.example.covidchecker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class StatisticFragment extends Fragment {

    View view;
    TextView stat_case;
    TextView stat_case_today;
    TextView stat_death;
    TextView stat_death_today;
    TextView stat_recovered;
    TextView stat_recovered_today;

    public StatisticFragment() {
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
        view = inflater.inflate(R.layout.fragment_statistic, container, false);
        stat_case = view.findViewById(R.id.stat_case);
//        stat_case.setVisibility(View.GONE);
        stat_case_today = view.findViewById(R.id.stat_case_today);
//        stat_case_today.setVisibility(View.GONE);
        stat_death = view.findViewById(R.id.stat_death);
//        stat_death.setVisibility(View.GONE);
        stat_death_today = view.findViewById(R.id.stat_death_today);
//        stat_death_today.setVisibility(View.GONE);
        stat_recovered = view.findViewById(R.id.stat_recovered);
//        stat_recovered.setVisibility(View.GONE);
        stat_recovered_today = view.findViewById(R.id.stat_recovered_today);
//        stat_recovered_today.setVisibility(View.GONE);
        TextView sta1 = view.findViewById(R.id.sta1);
//        sta1.setVisibility(View.GONE);
        TextView sta2 = view.findViewById(R.id.sta2);
//        sta2.setVisibility(View.GONE);
        TextView sta3 = view.findViewById(R.id.sta3);
//        sta3.setVisibility(View.GONE);
        TextView sta4 = view.findViewById(R.id.sta4);
//        sta4.setVisibility(View.GONE);
        TextView sta5 = view.findViewById(R.id.sta5);
//        sta5.setVisibility(View.GONE);
        TextView sta6 = view.findViewById(R.id.sta6);
//        sta6.setVisibility(View.GONE);
        TextView sta7 = view.findViewById(R.id.sta7);
//        sta7.setVisibility(View.GONE);
        TextView sta8 = view.findViewById(R.id.sta8);
//        sta8.setVisibility(View.GONE);
        TextView sta9 = view.findViewById(R.id.sta9);
//        sta9.setVisibility(View.GONE);
        TextView sta10 = view.findViewById(R.id.sta10);
//        sta10.setVisibility(View.GONE);
        TextView sta11 = view.findViewById(R.id.sta11);
//        sta11.setVisibility(View.GONE);
        TextView sta12 = view.findViewById(R.id.sta12);
//        sta12.setVisibility(View.GONE);

        try {
            Integer cases = getArguments().getInt("cases", 0);
            Log.e("kasus", String.valueOf(cases));
            Integer today_cases = getArguments().getInt("today_cases", 0);
            Integer deaths = getArguments().getInt("deaths", 0);
            Integer today_deaths = getArguments().getInt("today_deaths", 0);
            Integer recovered = getArguments().getInt("recovered", 0);
            Integer today_recovered = getArguments().getInt("today_recovered", 0);
            if (cases != null){
//                sta1.setVisibility(View.VISIBLE);
//                sta2.setVisibility(View.VISIBLE);
//                sta3.setVisibility(View.VISIBLE);
//                sta4.setVisibility(View.VISIBLE);
//                sta5.setVisibility(View.VISIBLE);
//                sta6.setVisibility(View.VISIBLE);
//                sta7.setVisibility(View.VISIBLE);
//                sta8.setVisibility(View.VISIBLE);
//                sta9.setVisibility(View.VISIBLE);
//                sta10.setVisibility(View.VISIBLE);
//                sta11.setVisibility(View.VISIBLE);
//                sta12.setVisibility(View.VISIBLE);
                stat_case.setText(String.valueOf(cases));
//                stat_case.setVisibility(View.VISIBLE);
                stat_case_today.setText(String.valueOf(today_cases));
//                stat_case_today.setVisibility(View.VISIBLE);
                stat_death.setText(String.valueOf(deaths));
//                stat_death.setVisibility(View.VISIBLE);
                stat_death_today.setText(String.valueOf(today_deaths));
//                stat_death_today.setVisibility(View.VISIBLE);
                stat_recovered.setText(String.valueOf(recovered));
//                stat_recovered.setVisibility(View.VISIBLE);
                stat_recovered_today.setText(String.valueOf(today_recovered));
//                stat_recovered_today.setVisibility(View.VISIBLE);
            } else {
                Snackbar.make(view, "negara tidak ditemukan", Snackbar.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static StatisticFragment newInstance(){
        return new StatisticFragment();
    }
}