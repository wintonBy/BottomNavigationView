package com.winton.bottomnavigationview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import java.util.List;

/**
 * @author: winton
 * @time: 2018/5/3 14:31
 * @package: com.sf.smartfactory.view.bottomnavigation
 * @project: SmartFactory
 * @mail:
 * @describe: 导航的View
 */
public class NavigationView extends FrameLayout {

    private List<Model> items;

    private OnTabSelectedListener listener;

    private LinearLayout itemContainer;

    private View line;

    /**
     * 选中时文字颜色
     */
    private int activeTextColor = Color.BLACK;
    /**
     * 未选中时文字颜色
     */
    private int unactiveTextColor = Color.GRAY;

    /**
     * icon到顶部的距离
     */
    private float iconMarginTop = NavigationItemView.dp2px(getContext(),5);

    /**
     * text到底部的距离
     */
    private float textMarginBottom = NavigationItemView.dp2px(getContext(),5);
    /**
     * 文字大小
     */
    private float textSize = NavigationItemView.dp2px(getContext(),14);
    /**
     * icon大小
     */
    private float iconSize = NavigationItemView.dp2px(getContext(),25);

    /**
     * 线的颜色
     */
    private int lineColor = Color.GRAY;

    private boolean showline = true;


    private int checkIndex = -1;

    public NavigationView(Context context) {
        this(context,null);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationView);
        if(typedArray != null){
            activeTextColor = typedArray.getColor(R.styleable.NavigationView_activeTextColor,activeTextColor);
            unactiveTextColor = typedArray.getColor(R.styleable.NavigationView_unactiveTextColor,unactiveTextColor);
            textSize = typedArray.getDimensionPixelSize(R.styleable.NavigationView_textSize,(int)textSize);
            textMarginBottom = typedArray.getDimensionPixelSize(R.styleable.NavigationView_text_margin_bottom,(int)textMarginBottom);
            iconMarginTop = typedArray.getDimensionPixelSize(R.styleable.NavigationView_icon_margin_top,(int)iconMarginTop);
            iconSize = typedArray.getDimensionPixelSize(R.styleable.NavigationView_iconSize,(int)iconSize);
            lineColor = typedArray.getColor(R.styleable.NavigationView_lineColor,lineColor);
            showline = typedArray.getBoolean(R.styleable.NavigationView_showLine,showline);
            typedArray.recycle();
        }
        init();
    }

    private void init(){
        itemContainer = new LinearLayout(this.getContext());
        itemContainer.setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        params.topMargin = 1;
        this.addView(itemContainer,params);
        line = new View(this.getContext());
        LayoutParams lineParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);
        line.setBackgroundColor(lineColor);
        this.addView(line,lineParams);
    }

    public void setItems(List<Model> items) {
        this.items = items;
    }

    private void addChild(){
        if(items == null){
            return;
        }
        for(int i =0;i<items.size();i++){
            addChildView(items.get(i),i);
        }
    }

    public void build(){
        itemContainer.removeAllViews();
        itemContainer.setWeightSum(items.size());
        addChild();
        if(!showline){
            line.setVisibility(INVISIBLE);
        }
        check(0);
    }

    private void addChildView(Model item, final int index){
        NavigationItemView itemView = new NavigationItemView(getContext());
        itemView.setActiveIcon(item.getActiveIcon());
        itemView.setUnactiveIcon(item.getUnactiveIcon());
        itemView.setTitle(item.getTitle());
        itemView.setCheck(false);
        itemView.setReminder(item.enableReminder,item.reminder);
        itemView.setActiveTextColor(activeTextColor);
        itemView.setUnactiveTextColor(unactiveTextColor);
        itemView.setIconMarginTop((int)iconMarginTop);
        itemView.setTextMarginBottom((int)textMarginBottom);
        itemView.setTextSize(textSize);
        itemView.setIconSize((int)iconSize);
        itemView.build();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
        itemContainer.addView(itemView,layoutParams);
        itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                check(index);
            }
        });
    }


    public static class Model{
        private String title;

        private boolean enableReminder;

        private String reminder;

        private int activeIcon = R.mipmap.ic_icon;

        private int unactiveIcon = R.mipmap.ic_icon;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getActiveIcon() {
            return activeIcon;
        }

        public void setActiveIcon(int activeIcon) {
            this.activeIcon = activeIcon;
        }

        public int getUnactiveIcon() {
            return unactiveIcon;
        }

        public void setUnactiveIcon(int unactiveIcon) {

            this.unactiveIcon = unactiveIcon;
        }

        public boolean isEnableReminder() {
            return enableReminder;
        }

        public void setEnableReminder(boolean enableReminder) {
            this.enableReminder = enableReminder;
        }

        public static class Builder{
            private String title;

            private boolean enableReminder;

            private final int activeIcon ;

            private final int unactiveIcon;

            public Builder(int activeIcon, int unactiveIcon) {
                this.activeIcon = activeIcon;
                this.unactiveIcon = unactiveIcon;
            }

            public Builder title(String title){
                this.title = title;
                return this;
            }

            public Builder enableReminder(boolean enableReminder){
                this.enableReminder = enableReminder;
                return this;
            }

            public Model build(){
                Model model = new Model();
                model.setActiveIcon(activeIcon);
                model.setUnactiveIcon(unactiveIcon);
                model.setTitle(title);
                model.setEnableReminder(enableReminder);
                return model;
            }
        }

    }

    public void check(int index){
        if(index < 0 || index >= items.size()){
            throw new IllegalArgumentException("index should >=0 && <items.size");
        }
        if(checkIndex == index){
            return;
        }
        if(listener != null){
            listener.selected(index,items.get(index));
            if(checkIndex != -1){
                //第一次 不需要unselect
                listener.unselected(checkIndex,items.get(checkIndex));
            }
        }
        checkIndex = index;
        for(int i = 0;i< itemContainer.getChildCount();i++){
           NavigationItemView itemView =  (NavigationItemView) itemContainer.getChildAt(i);
           if(i == checkIndex){
               itemView.setCheck(true);
           }else {
               itemView.setCheck(false);
           }
           itemView.rebuild();
        }

    }

    /**
     * 显示reminder
     * @param index
     * @param show
     * @param reminder
     */
    public void reminder(int index,boolean show,String reminder){
        if(index < 0 || index >= items.size()){
            throw new IllegalArgumentException("index should >=0 && <items.size");
        }
        NavigationItemView itemView = (NavigationItemView) itemContainer.getChildAt(index);
        itemView.updateReminder(reminder,show);

    }


    public void setOnTabSelectedListener(OnTabSelectedListener listener) {
        this.listener = listener;
    }

    public interface OnTabSelectedListener{
        /**
         * 选中的tab
         * @param index
         * @param model
         */
        void selected(int index, Model model);

        /**
         * 取消选中的tab
         * @param index
         * @param model
         */
        void unselected(int index, Model model);
    }
}
