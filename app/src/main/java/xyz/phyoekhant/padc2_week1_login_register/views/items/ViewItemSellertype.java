package xyz.phyoekhant.padc2_week1_login_register.views.items;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.phyoekhant.padc2_week1_login_register.R;

/**
 * Created by Phyoe Khant on 6/8/2017.
 */
public class ViewItemSellertype extends FrameLayout {

    @BindView(R.id.tv_sellertype)
    TextView tvSellertype;

    public ViewItemSellertype(Context context) {
        super(context);
    }

    public ViewItemSellertype(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemSellertype(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setData(String country) {
        tvSellertype.setText(country);
    }
}
