package com.example.zadanienrdwa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecondFragmentTest {

    SecondFragment fragment = new SecondFragment();

    @Test
    public void testCalculateBMI() {
        System.out.println("=============================================");
        double bmi = fragment.calculateBMI(80, 170);
        System.out.println("Calculated BMI for weight 80kg and height 170cm: " + bmi);
        assertEquals(27.68, bmi, 0.01);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_Starvation() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(15.5);
        System.out.println("Calculated category for BMI 15.5: " + category);
        assertEquals("Wygłodzenie", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_UnderweightSevere() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(16.5);
        System.out.println("Calculated category for BMI 16.5: " + category);
        assertEquals("Wychudzenie", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_Underweight() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(17.5);
        System.out.println("Calculated category for BMI 17.5: " + category);
        assertEquals("Niedowaga", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_NormalWeight() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(22.0);
        System.out.println("Calculated category for BMI 22.0: " + category);
        assertEquals("Waga prawidłowa", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_Overweight() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(27.0);
        System.out.println("Calculated category for BMI 27.0: " + category);
        assertEquals("Nadwaga", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_ObesityClass1() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(32.0);
        System.out.println("Calculated category for BMI 32.0: " + category);
        assertEquals("I stopień otyłości", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_ObesityClass2() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(37.0);
        System.out.println("Calculated category for BMI 37.0: " + category);
        assertEquals("II stopień otyłości", category);
        System.out.println("=============================================");
    }

    @Test
    public void testBMICategory_ExtremeObesity() {
        System.out.println("=============================================");
        String category = fragment.getBMICategory(45.0);
        System.out.println("Calculated category for BMI 45.0: " + category);
        assertEquals("Otyłość skrajna", category);
        System.out.println("=============================================");
    }
}
