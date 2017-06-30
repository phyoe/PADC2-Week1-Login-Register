package xyz.phyoekhant.padc2_week1_login_register.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import xyz.phyoekhant.padc2_week1_login_register.CarPweSarApp;
import xyz.phyoekhant.padc2_week1_login_register.R;
import xyz.phyoekhant.padc2_week1_login_register.views.items.ViewItemSellertype;


/**
 * Created by Phyoe Khant on 6/8/2017.
 */
public class SellertypeListAdapter extends BaseAdapter {
    private List<String> mSellertypeList;
    private LayoutInflater mInflater;

    public SellertypeListAdapter(List<String> sellertypeList) {
        if (sellertypeList != null) {
            this.mSellertypeList = sellertypeList;
        } else {
            this.mSellertypeList = new ArrayList<>();
        }
        mInflater = LayoutInflater.from(CarPweSarApp.getContext());
    }

    @Override
    public int getCount() {
        return mSellertypeList.size();
    }

    @Override
    public String getItem(int position) {
        return mSellertypeList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.view_item_sellertype, parent, false);
        }

        if (convertView instanceof ViewItemSellertype) {
            ViewItemSellertype viewItemSellertype = (ViewItemSellertype) convertView;
            viewItemSellertype.setData(getItem(position));
        }

        return convertView;
    }
}
