package com.winton.bottomnavigationview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
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
 * @describe:  单个ItemView
 */
public class NavigationItemView extends RelativeLayout {

    private TextView tvTitle;

    private ImageView ivIcon;

    private TextView reminderView;

    private boolean isCheck;

    private String title = "title";

    private String reminder = "";

    private float textSize = 12;

    private int iconSize = 25;

    private int activeIcon = R.mipmap.ic_icon;

    private int unactiveIcon = R.mipmap.ic_icon;

    private int activeTextColor = Color.BLACK;

    private int unactiveTextColor = Color.GRAY;
    /**
     * 是否显示提醒
     */
    private boolean enableReminder = false;

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
        ivIcon.setId(R.id.icon);
        initIcon();
        reminderView = new TextView(getContext());
        initRemindView();
        this.setFocusable(true);
        tvTitle.setFocusable(false);
        ivIcon.setFocusable(false);
        reminderView.setFocusable(false);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.item_bg));
    }

    /**
     * 初始化reminder view
     */
    private void initRemindView() {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_LEFT,R.id.icon);
        layoutParams.topMargin = iconMarginTop - 5;
        layoutParams.leftMargin = iconSize - 10;

        reminderView.setTextColor(Color.WHITE);
        reminderView.setGravity(Gravity.CENTER);
        reminderView.setPadding(5,5,5,5);
        reminderView.setMinHeight(dp2px(getContext(),10));
        reminderView.setMinWidth(dp2px(getContext(),10));
        this.addView(reminderView,layoutParams);
        updateReminder(reminder,enableReminder);
    }

    private void initTitle(){
        LayoutParams  layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.setMargins(0,0,0,textMarginBottom);
        this.addView(tvTitle,layoutParams);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        tvTitle.setText(title);
        tvTitle.setSingleLine(true);
        tvTitle.setTextColor( isCheck ? activeTextColor :unactiveTextColor);

    }

    private void initIcon(){
        LayoutParams  layoutParams = new LayoutParams(iconSize, iconSize);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.setMargins(0,iconMarginTop,0,0);
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

    /**
     * 设置reminder
     * @param enableReminder
     * @param reminder
     */
    public void setReminder(boolean enableReminder,String reminder){
        this.enableReminder = enableReminder;
        this.reminder = reminder;
    }

    /**
     * 显示提示
     * @param reminder
     * @param show
     */
    public void updateReminder(String reminder, boolean show){
        enableReminder = show;
        if(reminder == null){
            reminder ="";
        }
        this.reminder = reminder;
        if(!show){
            reminderView.setVisibility(GONE);
        }else {
            if(TextUtils.isEmpty(reminder)){
                reminderView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,5);
                reminderView.setBackgroundResource(R.drawable.reminder_bg);
                ViewGroup.LayoutParams layoutParams = reminderView.getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                reminderView.requestLayout();
            }else {

                reminderView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
                reminderView.setBackgroundResource(R.drawable.reminder_bg_big);
                ViewGroup.LayoutParams layoutParams = reminderView.getLayoutParams();
                layoutParams.width = dp2px(getContext(),20);
                layoutParams.height = dp2px(getContext(),20);
                reminderView.requestLayout();
            }
            reminderView.setVisibility(VISIBLE);
            if(reminder.length() >=3){
                reminder="···";
            }
            reminderView.setText(reminder);
        }
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