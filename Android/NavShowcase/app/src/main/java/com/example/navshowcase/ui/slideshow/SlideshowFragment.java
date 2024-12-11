package com.example.navshowcase.ui.slideshow;

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
import com.example.navshowcase.databinding.FragmentSlideshowBinding;

import org.w3c.dom.Text;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private Button madlib1BTN;
    private Button madlib2BTN;
    private Button madlib3BTN;
    private EditText adjective1;
    private EditText adjective2;
    private EditText adjective3;
    private EditText noun1;
    private EditText noun2;
    private EditText verb1;
    private EditText verb2;
    private EditText verb3;
    private TextView storyTXT;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        madlib1BTN = view.findViewById(R.id.madlib1BTN);
        madlib2BTN = view.findViewById(R.id.madlib2BTN);
        madlib3BTN = view.findViewById(R.id.madlib3BTN);

        adjective1 = view.findViewById(R.id.adjective1);
        adjective2 = view.findViewById(R.id.adjective2);
        adjective3 = view.findViewById(R.id.adjective3);
        noun1 = view.findViewById(R.id.noun1);
        noun2 = view.findViewById(R.id.noun2);
        verb1 = view.findViewById(R.id.verb1);
        verb2 = view.findViewById(R.id.verb2);
        verb3 = view.findViewById(R.id.verb3);

        storyTXT = view.findViewById(R.id.storyTXT);

        madlib1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjective1.setVisibility(View.INVISIBLE);
                adjective2.setVisibility(View.INVISIBLE);
                adjective3.setVisibility(View.INVISIBLE);
                noun1.setVisibility(View.INVISIBLE);
                noun2.setVisibility(View.INVISIBLE);
                verb1.setVisibility(View.INVISIBLE);
                verb2.setVisibility(View.INVISIBLE);
                verb3.setVisibility(View.INVISIBLE);
                storyTXT.setVisibility(View.VISIBLE);
                storyTXT.setText("In a "+adjective1.getText()+", "+adjective2.getText()+", and "+adjective3.getText()+ " world, a "+noun1.getText()+ " discovered a hidden "+noun2.getText()+". Curious, it decided to "+verb1.getText()+ " inside. Once there, it had to "+verb2.getText()+ " and "+verb3.getText()+ " to find its way back home!");
            }
        });

        madlib2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjective1.setVisibility(View.INVISIBLE);
                adjective2.setVisibility(View.INVISIBLE);
                adjective3.setVisibility(View.INVISIBLE);
                noun1.setVisibility(View.INVISIBLE);
                noun2.setVisibility(View.INVISIBLE);
                verb1.setVisibility(View.INVISIBLE);
                verb2.setVisibility(View.INVISIBLE);
                verb3.setVisibility(View.INVISIBLE);
                storyTXT.setVisibility(View.VISIBLE);
                storyTXT.setText("On a "+adjective1.getText()+", "+adjective2.getText()+", and "+adjective3.getText()+ " day, a "+noun1.getText()+ " wandered into a mysterious "+noun2.getText()+". It decided to "+verb1.getText()+ " around and soon began to "+verb2.getText()+". As it explored, it discovered how to "+verb3.getText()+ " its way through the adventure!");
            }
        });

        madlib3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjective1.setVisibility(View.INVISIBLE);
                adjective2.setVisibility(View.INVISIBLE);
                adjective3.setVisibility(View.INVISIBLE);
                noun1.setVisibility(View.INVISIBLE);
                noun2.setVisibility(View.INVISIBLE);
                verb1.setVisibility(View.INVISIBLE);
                verb2.setVisibility(View.INVISIBLE);
                verb3.setVisibility(View.INVISIBLE);
                storyTXT.setVisibility(View.VISIBLE);
                storyTXT.setText("In a "+adjective1.getText()+", "+adjective2.getText()+", and "+adjective3.getText()+ " forest, a  "+noun1.getText()+ " stumbled upon an ancient "+noun2.getText()+". Excited, it decided to "+verb1.getText()+ " to uncover its secrets. Along the way, it had to "+verb2.getText()+ " and "+verb3.getText()+ " to escape the lurking dangers!");
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}