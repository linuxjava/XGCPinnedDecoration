package com.example.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.app.bean.LData;

import xiao.free.decoration.FlexibleDividerDecoration;
import xiao.free.superadapter.recycview.MultiItemTypeAdapter;
import xiao.free.superadapter.recycview.base.ItemViewDelegate;
import xiao.free.superadapter.recycview.base.ViewHolder;

public class SectionAdapter extends MultiItemTypeAdapter<LData> implements FlexibleDividerDecoration.VisibilityProvider {
    public SectionAdapter(Context context) {
        super(context);

        addItemViewDelegate(LData.ITEM_TYPE_SECTION, new SectionHolder());
        addItemViewDelegate(LData.ITEM_TYPE_DATA, new StationHolder());
    }

    @Override
    public boolean shouldHideDivider(int position, RecyclerView parent) {
        if (position >= 0 && position < getItemCount()) {

            //SECTION item前一个item不显示分割线
            if(position + 1 < getItemCount() && getDatas().get(position + 1).getItemType() == LData.ITEM_TYPE_SECTION){
                return true;
            }
            //SECTION item不显示分割线
            if (getDatas().get(position).getItemType() == LData.ITEM_TYPE_SECTION) {
                return true;
            }
        }
        return false;
    }

    public static class SectionHolder implements ItemViewDelegate<LData> {

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_text;
        }

        @Override
        public boolean isForViewType(LData item, int position) {
            return item.getItemType() == LData.ITEM_TYPE_SECTION;
        }

        @Override
        public void convert(ViewHolder holder, LData lData, int position) {
            holder.setBackgroundRes(R.id.text, R.color.colorPrimary);
            holder.setText(R.id.text, lData.getData());
            holder.setTextColorRes(R.id.text, R.color.white);
        }
    }

    public static class StationHolder implements ItemViewDelegate<LData> {

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_text;
        }

        @Override
        public boolean isForViewType(LData item, int position) {
            return item.getItemType() == LData.ITEM_TYPE_DATA;
        }

        @Override
        public void convert(ViewHolder holder, LData lData, int position) {
            holder.setText(R.id.text, lData.getData());
        }
    }
}
