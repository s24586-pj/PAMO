package com.example.zadanienrdwa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.zadanienrdwa.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    private String activityLevel = "";
    private String gender = "";

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.activityLow.setOnClickListener(v -> activityLevel = "low");
        binding.activityMedium.setOnClickListener(v -> activityLevel = "medium");
        binding.activityHigh.setOnClickListener(v -> activityLevel = "high");

        binding.genderMale.setOnClickListener(v -> gender = "male");
        binding.genderFemale.setOnClickListener(v -> gender = "female");

        binding.calculateButton.setOnClickListener(v -> {
            String ageInput = binding.ageInput.getText().toString();
            String weightInput = binding.weightInput.getText().toString();
            String heightInput = binding.heightInput.getText().toString();

            if (ageInput.isEmpty() || weightInput.isEmpty() || heightInput.isEmpty()) {
                Toast.makeText(getActivity(), "Proszę wprowadzić wszystkie dane do inputów!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (activityLevel.isEmpty() || gender.isEmpty()) {
                Toast.makeText(getActivity(), "Proszę wybrać poziom aktywności i płeć!", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageInput);
            int weight = Integer.parseInt(weightInput);
            int height = Integer.parseInt(heightInput);

            if (age <= 0 || weight <= 0 || height <= 0) {
                Toast.makeText(getActivity(), "Dane muszą być większe od zera!", Toast.LENGTH_SHORT).show();
                return;
            }

            double kcal = calculateDailyCalories(weight, height, age, activityLevel, gender);
            binding.calorieResultText.setText(String.format("Twoje dzienne zapotrzebowanie kaloryczne: %.2f kcal", kcal));

            showMealSuggestions(kcal);
        });

        binding.backToMainFromKcal.setOnClickListener(v ->
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment)
        );
    }

    private double calculateDailyCalories(int weight, int height, int age, String activityLevel, String gender) {
        double bmr;

        if (gender.equals("male")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        double activityFactor = 1.2;
        switch (activityLevel) {
            case "low":
                break;
            case "medium":
                activityFactor = 1.55;
                break;
            case "high":
                activityFactor = 1.9;
                break;
        }

        return bmr * activityFactor;
    }

    private void showMealSuggestions(double kcal) {
        String mealSuggestion;
        if (kcal < 2000) {
            mealSuggestion = "Lekkie posiłki: Sałatka z kurczakiem, Jajka na twardo z warzywami.";
        } else if (kcal <= 2500) {
            mealSuggestion = "Średnie posiłki: Kurczak z ryżem, Sałatka z tuńczykiem.";
        } else {
            mealSuggestion = "Cięższe posiłki: Stek z ziemniakami, Makaron z mięsem mielonym.";
        }

        binding.mealSuggestions.setText(mealSuggestion);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
