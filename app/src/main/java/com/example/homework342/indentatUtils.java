package com.example.homework342;

import android.app.Activity;
import android.content.Intent;

public class indentatUtils {

    private static int sTheme;

    public final static int THEME_LARGE = 0;
    public final static int THEME_AVERAGE = 1;
    public final static int THEME_SMALL = 2;


    public static void changeToTheme(Activity activity,int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static int changeThemeSpinner(int theme)
    {
        sTheme = theme;
        return sTheme;

    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_LARGE:
                activity.setTheme(R.style.Margin10);
                break;
            case THEME_AVERAGE:
                activity.setTheme(R.style.Margin3);
                break;
            case THEME_SMALL:
                activity.setTheme(R.style.Margin1);
                break;
        }
    }
}
