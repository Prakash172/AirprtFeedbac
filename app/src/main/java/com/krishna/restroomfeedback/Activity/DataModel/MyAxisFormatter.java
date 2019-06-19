package com.krishna.restroomfeedback.Activity.DataModel;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class MyAxisFormatter implements IAxisValueFormatter {
    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        switch ((int)value) {
            case 1:
                return "Bad";
            case 2:
                return "Poor";
            case 3:
                return "Average";
            case 4:
                return "Good";
            case 5:
                return "Excellent";
                default: return null;

        }

    }
}
