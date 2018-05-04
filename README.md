# BottomNavigationView
------
## 简介
  一个简单的底部导航栏，可以快速集成，简单易用
  
## 讨论
　　欢迎大家加入群组讨论。 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=e499491b3f42c95d62ed286d4e4b23185d9284c4b46e315fb925050bc1695c5f"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="Coder" title="Coder"></a>
 
 
![qq_img](https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/qq.png)
## 使用效果
![screen](https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/1.gif)

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
	        implementation 'com.github.wintonBy:BottomNavigationView:1.0'
	}
```

## 用法
### XML布局
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

### 添加module
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
### 添加监听
```java
mNV.setOnTabSelectedListener(new NavigationView.OnTabSelectedListener() {
            @Override
            public void selected(int i, NavigationView.Model model) {
                Toast.makeText(MainActivity.this,model.getTitle(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void unselected(int i, NavigationView.Model model) {

            }
 });
 ```
 ## 参数说明
 <li>app:iconSize               图标大小</li>
 <li>app:textSize               文字大小</li>
 <li>app:activeTextColor        选中时文字颜色</li>
 <li>app:unactiveTextColor      未选中时文字颜色</li>
 <li>app:icon_margin_top        距离顶部的距离</li>
 <li>app:text_margin_bottom     距离底部的距离</li>
 
 ## License
 Copyright 2018 Winton

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 



