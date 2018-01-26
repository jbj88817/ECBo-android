package us.bojie.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by bojiejiang on 1/25/18.
 */

public enum EcIcons implements Icon {
    qr_code('\ue6a9'),
    search('\uf6ac');

    private char mChar;

    EcIcons(char aChar) {
        mChar = aChar;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return mChar;
    }
}
