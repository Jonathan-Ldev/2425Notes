package com.example.navshowcase.ui.scifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navshowcase.R;
import com.example.navshowcase.databinding.FragmentHomeBinding;
import com.example.navshowcase.databinding.FragmentScifiBinding;
import com.example.navshowcase.ui.home.HomeViewModel;

import java.util.Random;

public class SciFiFragment extends Fragment {

    private EditText fNameEDT;
    private EditText lNameEDT;
    private EditText questEDT;
    private EditText colorEDT;
    private EditText swalEDT;
    private EditText petEDT;
    private TextView outputTXT;
    private Button genBTN;

    private FragmentScifiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SciFiViewModel scifiViewModel =
                new ViewModelProvider(this).get(SciFiViewModel.class);

        binding = FragmentScifiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSciFi;
        scifiViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        fNameEDT = view.findViewById(R.id.fNameEDT);
        lNameEDT = view.findViewById(R.id.lNameEDT);
        questEDT = view.findViewById(R.id.questEDT);
        colorEDT = view.findViewById(R.id.colorEDT);
        swalEDT = view.findViewById(R.id.swalEDT);
        petEDT = view.findViewById(R.id.petEDT);
        outputTXT = view.findViewById(R.id.outputTXT);
        genBTN = view.findViewById(R.id.genBTN);

        genBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randy = new Random();

                int Lof = fNameEDT.getText().toString().length();
                int num = randy.nextInt(Lof);
                String SciFiFirst = fNameEDT.getText().toString().substring(num,Lof);
                int Loc = lNameEDT.getText().toString().length();
                num = randy.nextInt(Loc);
                String SciFiLast = lNameEDT.getText().toString().substring(num,Loc);
                String SciFiFirstName = SciFiFirst+SciFiLast;
                int Lof2 = questEDT.getText().toString().length();
                num = randy.nextInt(Lof2);
                String SciLastFirst = questEDT.getText().toString().substring(num,Lof2);
                int Loc2 = colorEDT.getText().toString().length();
                num = randy.nextInt(Loc2);
                String SciLastLast = colorEDT.getText().toString().substring(num,Loc2);
                String SciFiLastName = SciLastFirst+SciLastLast;
                int Lof3 = swalEDT.getText().toString().length();
                num = randy.nextInt(Lof3);
                String SciOriginFirst = swalEDT.getText().toString().substring(num,Lof3);
                int Loc3 = petEDT.getText().toString().length();
                num = randy.nextInt(Loc3);
                String SciOriginLast = petEDT.getText().toString().substring(num,Loc3);
                String SciFiOrigin = SciOriginFirst+SciOriginLast;
                outputTXT.setText("Howdy: "+SciFiFirstName+" "+SciFiLastName+" From "+SciFiOrigin+"");
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}