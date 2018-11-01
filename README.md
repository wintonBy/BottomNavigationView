# BottomNavigationView
------
## 简介
  一个简单的底部导航栏，可以快速集成，简单易用
  
## 讨论
　　欢迎大家加入群组讨论。 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=e499491b3f42c95d62ed286d4e4b23185d9284c4b46e315fb925050bc1695c5f"><img border="0" src="https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/group.png" alt="Coder" title="Coder"></a>
 
 
![qq_img](https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/qq.png)
## 使用效果
<div>
    <img src="https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/demo.png" width="320"/>
</div>
<div align="left">
默认<br><img src="https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/default.png" width="400"/><br>

无分割线<br><img src="https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/noline.png" width="400"/><br>

自定义线<br><img src="https://github.com/wintonBy/BottomNavigationView/blob/master/app/screen/cutomline.png" width="400"/>
</div>

## 集成方式

### gradle

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
	        implementation 'com.github.wintonBy:BottomNavigationView:2.4'
	}
```

## 用法
### XML布局
```
    <com.winton.bottomnavigationview.NavigationView
        app:layout_constraintBottom_toBottomOf="parent"
        android:id="@+id/nv"
        android:background="@android:color/white"
        app:activeTextColor="@android:color/black"
        app:unactiveTextColor="#666666"
        android:layout_width="match_parent"
        android:layout_height="60dp">
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
        /*在此处监听，可获取到第一次选中到结果*/
        mNV.build();
        //mNV.check(0); //2.2 版本之后默认选中0
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
### 显示新消息
```
 /**
 * 第一个参数代表Item的位置
 * 第二个参数代表是否显示红点
 * 第三个参数代表红点第内容
 **/
 mNV.reminder(0,true,"99");
 mNV.reminder(1,true,"···");
 mNV.reminder(2,true,"");
```

 ## 参数说明
 <li>app:iconSize               图标大小</li>
 <li>app:textSize               文字大小</li>
 <li>app:activeTextColor        选中时文字颜色</li>
 <li>app:unactiveTextColor      未选中时文字颜色</li>
 <li>app:icon_margin_top        距离顶部的距离</li>
 <li>app:text_margin_bottom     距离底部的距离</li>
 <li>app:lineColor              分割线到颜色</li>
 <li>app:showLine               是否显示风割线</li>
 
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
 



