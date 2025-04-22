package com.example.zadanienrdwa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThirdFragmentTest {

    ThirdFragment fragment = new ThirdFragment();

    @Test
    public void testCalculateDailyCalories_Male_LowActivity() {
        System.out.println("=============================================");
        System.out.println("Test testCalculateDailyCalories_Male_LowActivity started.");
        double kcal = fragment.calculateDailyCalories(80, 180, 25, "low", "male");
        double expectedBMR = 88.362 + (13.397 * 80) + (4.799 * 180) - (5.677 * 25);
        System.out.println("Calculated kcal (male, low activity): " + kcal);
        assertEquals(expectedBMR * 1.2, kcal, 0.01);
        System.out.println("Test testCalculateDailyCalories_Male_LowActivity passed.");
        System.out.println("=============================================");
    }

    @Test
    public void testCalculateDailyCalories_Female_MediumActivity() {
        System.out.println("=============================================");
        System.out.println("Test testCalculateDailyCalories_Female_MediumActivity started.");
        double kcal = fragment.calculateDailyCalories(65, 165, 30, "medium", "female");
        double expectedBMR = 447.593 + (9.247 * 65) + (3.098 * 165) - (4.330 * 30);
        System.out.println("Calculated kcal (female, medium activity): " + kcal);
        assertEquals(expectedBMR * 1.55, kcal, 0.01);
        System.out.println("Test testCalculateDailyCalories_Female_MediumActivity passed.");
        System.out.println("=============================================");
    }

    @Test
    public void testCalculateDailyCalories_Male_HighActivity() {
        System.out.println("=============================================");
        System.out.println("Test testCalculateDailyCalories_Male_HighActivity started.");
        double kcal = fragment.calculateDailyCalories(90, 185, 28, "high", "male");
        double expectedBMR = 88.362 + (13.397 * 90) + (4.799 * 185) - (5.677 * 28);
        System.out.println("Calculated kcal (male, high activity): " + kcal);
        assertEquals(expectedBMR * 1.9, kcal, 0.01);
        System.out.println("Test testCalculateDailyCalories_Male_HighActivity passed.");
        System.out.println("=============================================");
    }

}
