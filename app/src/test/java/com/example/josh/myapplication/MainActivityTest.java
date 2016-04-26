package com.example.josh.myapplication;

import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView currentHoleView = (TextView) activity.findViewById(R.id.currentHoleView);
        assertTrue("Hole 1".equals(currentHoleView.getText().toString()));
    }
    @Test
    public void validateButtonTextContent() {
        Button homeBtn = (Button) activity.findViewById(R.id.homeBtn);
        assertTrue("Home".equals(homeBtn.getText().toString()));
    }


}
