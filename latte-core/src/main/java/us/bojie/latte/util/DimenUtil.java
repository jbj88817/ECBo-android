package us.bojie.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import us.bojie.latte.app.Latte;

/**
 * Created by bojiejiang on 1/28/18.
 */

public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
