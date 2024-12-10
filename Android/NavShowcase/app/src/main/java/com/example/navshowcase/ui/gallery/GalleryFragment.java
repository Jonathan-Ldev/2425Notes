package com.example.navshowcase.ui.gallery;

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
import com.example.navshowcase.databinding.FragmentGalleryBinding;

import org.w3c.dom.Text;

import java.util.Random;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    private EditText guessTXT;
    private TextView answerTXT;
    private Button enterBTN;
    private TextView scoreTXT;

    int strike = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        guessTXT = (EditText) view.findViewById(R.id.guessTXT);
        answerTXT = (TextView) view.findViewById(R.id.answerTXT);
        enterBTN = view.findViewById(R.id.enterBTN);


        int randy = new Random().nextInt(100);




        enterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerTXT.setVisibility(View.VISIBLE);
                while (strike < 10){
                    if(Integer.parseInt(String.valueOf(guessTXT.getText())) == randy){
                        answerTXT.setText("You Got it Right");
                        break;
                    }
                    if (Integer.parseInt(String.valueOf(guessTXT.getText())) < randy){
                        answerTXT.setText("Too Low");
                        strike +=1;
                    }
                    if (Integer.parseInt(String.valueOf(guessTXT.getText())) > randy){
                        answerTXT.setText("Too High");
                        strike +=1;
                    }
                }

                if (strike < 10){
                    
                }


            }
        });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}