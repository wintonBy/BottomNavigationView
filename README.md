# BottomNavigationView
------
## 简介
  一个简单的底部导航栏，可以快速集成，简单易用
  
## 使用效果
![screen]()

## 集成方式

###gradle
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.wintonBy:BottomNavigationView:0.1'
	}
```

## 用法
###XML布局
```
<com.winton.bottomnavigationview.NavigationView
        app:iconSize="25dp"
        app:activeTextColor="@color/colorPrimary"
        app:icon_margin_top="5dp"
        app:text_margin_bottom="5dp"
        app:textSize="14dp"
        app:unactiveTextColor="@color/colorAccent"
        android:layout_width="match_parent"
        android:layout_height="50dp">

    </com.winton.bottomnavigationview.NavigationView>
```

###添加module
```java
 NavigationView mNV = findViewById(R.id.nv);
        List<NavigationView.Model> tabs = new ArrayList<>();
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).title("主页").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).title("tab1").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).title("tab2").build());
        mNV.setItems(tabs);
        mNV.build();
        mNV.check(0);
```

