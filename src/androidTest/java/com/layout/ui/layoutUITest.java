package com.layout.ui;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.layout.ui.layoutUITest \
 * com.layout.ui.tests/android.test.InstrumentationTestRunner
 */
public class layoutUITest extends ActivityInstrumentationTestCase2<layoutUI> {

    public layoutUITest() {
        super("com.layout.ui", layoutUI.class);
    }

}
