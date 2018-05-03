package com.winton.bottomnavigationview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * @author: winton
 * @time: 2018/5/3 13:34
 * @package: com.sf.smartfactory.view.bottomnavigation
 * @project: SmartFactory
 * @mail:
 * @describe: 一句话描述
 */
public class NavigationItemView extends RelativeLayout {

    private TextView tvTitle;

    private ImageView ivIcon;

    private boolean isCheck;

    private String title = "title";

    private float textSize = 12;

    private int iconSize = 25;

    private int activeIcon = R.mipmap.ic_icon;

    private int unactiveIcon = R.mipmap.ic_icon;

    private int activeTextColor = Color.BLACK;

    private int unactiveTextColor = Color.GRAY;

    private int iconMarginTop = 5;

    private int textMarginBottom = 5;


    public NavigationItemView(Context context) {
        this(context,null);
    }

    public NavigationItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NavigationItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void build(){
        init();
    }


    private void init(){
        tvTitle = new TextView(getContext());
        initTitle();
        ivIcon = new ImageView(getContext());
        initIcon();
    }

    private void initTitle(){
        LayoutParams  layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.setMargins(0,0,0,dp2px(getContext(),textMarginBottom));
        this.addView(tvTitle,layoutParams);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP,textSize);
        tvTitle.setText(title);
        tvTitle.setTextColor( isCheck ? activeTextColor :unactiveTextColor);

    }

    private void initIcon(){
        LayoutParams  layoutParams = new LayoutParams(dp2px(getContext(),iconSize), dp2px(getContext(),iconSize));
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.setMargins(0,dp2px(getContext(),iconMarginTop),0,0);
        this.addView(ivIcon,layoutParams);
        ivIcon.setImageResource(isCheck ? activeIcon : unactiveIcon);
    }

    /**
     * dp转px
     *
     * @param context
     * @return
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    public void setCheck(boolean check){
        this.isCheck = check;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setIconSize(int iconSize) {
        this.iconSize = iconSize;
    }

    public void setActiveIcon(int activeIcon) {
        this.activeIcon = activeIcon;
    }

    public void setUnactiveIcon(int unactiveIcon) {
        this.unactiveIcon = unactiveIcon;
    }

    public void setActiveTextColor(int activeTextColor) {
        this.activeTextColor = activeTextColor;
    }

    public void setUnactiveTextColor(int unactiveTextColor) {
        this.unactiveTextColor = unactiveTextColor;
    }

    public void setIconMarginTop(int iconMarginTop) {
        this.iconMarginTop = iconMarginTop;
    }

    public void setTextMarginBottom(int textMarginBottom) {
        this.textMarginBottom = textMarginBottom;
    }

    public void rebuild(){
        tvTitle.setTextColor( isCheck ? activeTextColor :unactiveTextColor);
        ivIcon.setImageResource(isCheck ? activeIcon : unactiveIcon);
    }
}