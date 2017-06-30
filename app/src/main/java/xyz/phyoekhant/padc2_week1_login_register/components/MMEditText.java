package xyz.phyoekhant.padc2_week1_login_register.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import xyz.phyoekhant.padc2_week1_login_register.utils.MMFontUtils;


/**
 * Created by aung on 7/7/16.
 */
public class MMEditText extends EditText {

    public MMEditText(Context context) {
        super(context);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }
}
