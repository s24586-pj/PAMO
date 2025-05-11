package com.example.zadanienrdwa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.zadanienrdwa.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    public FragmentSecondBinding binding;
    public int weight = 80;
    public int height = 170;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.weightText.setText(String.valueOf(weight));
        binding.heightText.setText(String.valueOf(height));

        binding.buttonDecreaseWeight.setOnClickListener(v -> {
            if(weight > 1) {
                weight--;
                binding.weightText.setText(String.valueOf(weight));
            }
        });

        binding.buttonIncreaseWeight.setOnClickListener(v -> {
            weight++;
            binding.weightText.setText(String.valueOf(weight));
        });

        binding.buttonDecreaseHeight.setOnClickListener(v -> {
            if(height > 1) {
                height--;
                binding.heightText.setText(String.valueOf(height));
            }
        });

        binding.buttonIncreaseHeight.setOnClickListener(v -> {
            height++;
            binding.heightText.setText(String.valueOf(height));
        });

        binding.buttonCalculate.setOnClickListener(v -> {
            double bmi = calculateBMI(weight, height);
            String category = getBMICategory(bmi);
            binding.bmiResultText.setText(String.format("Twoje BMI: %.2f - %s", bmi, category));
        });

        binding.backToMainFromBmi.setOnClickListener(v -> {
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);
        });
    }

    public double calculateBMI(int weight, int height) {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    public String getBMICategory(double bmi) {
        if (bmi < 16) {
            return "Wygłodzenie";
        } else if (bmi < 17) {
            return "Wychudzenie";
        } else if (bmi < 18.5) {
            return "Niedowaga";
        } else if (bmi < 25) {
            return "Waga prawidłowa";
        } else if (bmi < 30) {
            return "Nadwaga";
        } else if (bmi < 35) {
            return "I stopień otyłości";
        } else if (bmi < 40) {
            return "II stopień otyłości";
        } else {
            return "Otyłość skrajna";
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
