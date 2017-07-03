package co.smartreceipts.android.graphs;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.Calendar;
import java.util.Locale;

public class DayAxisValueFormatter implements IAxisValueFormatter {
    private final String defaultSeparator;

    public DayAxisValueFormatter(String dafaultSeparator) {
        this.defaultSeparator = dafaultSeparator;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        try { // Hack for sometimes appearing IndexOutOfBoundsException from MPAndroidCharts lib
            int days = (int) value;

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, days);

            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;

            if (Locale.getDefault() == Locale.US) {
                return String.format("%02d", month) + defaultSeparator + String.format("%02d", day);
            } else {
                return String.format("%02d", day) + defaultSeparator + String.format("%02d", month);
            }
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

}
