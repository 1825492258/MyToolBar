# MyToolBar
ToolBar的使用
### 1.对ToolBar的使用

### 2.图片毛玻璃的效果实现
    使用 Glide 和 transformations
    https://github.com/bumptech/glide
    https://github.com/wasabeef/glide-transformations
    public class FourActivity extends AppCompatActivity {
        @BindView(R.id.rl_four)
        RelativeLayout rlFour; // 一个相对布局
        @BindView(R.id.img_four)
        ImageView imgFour; // 展示图片 使图片为圆形图片

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_four);
            ButterKnife.bind(this);
            Glide.with(this)
                    .load(R.drawable.ic_home_weibo)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25)))
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                            rlFour.setBackground(resource);
                        }
                    });

            Glide.with(this).load(R.drawable.ic_home_weibo)
                    .apply(RequestOptions.bitmapTransform(new CropCircleTransformation()))
                    .into(imgFour);
        }
    }

### 3.CoordinatorLayout的体验 布局文件如下
     <?xml version="1.0" encoding="utf-8"?>
     <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
         xmlns:app="http://schemas.android.com/apk/res-auto"
         xmlns:tools="http://schemas.android.com/tools"
         android:id="@+id/refresh_layout"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         tools:context="com.item.bar.activity.FiveActivity">


         <android.support.design.widget.AppBarLayout
             android:id="@+id/appbar"
             android:layout_width="match_parent"
             android:layout_height="300dp">

             <android.support.design.widget.CollapsingToolbarLayout
                 android:id="@+id/collapsing_toolbar"
                 android:layout_width="match_parent"
                 android:layout_height="match_parent"
                 android:fitsSystemWindows="true"
                 android:includeFontPadding="false"
                 app:contentScrim="@color/colorPrimary"
                 app:expandedTitleMarginBottom="16dp"
                 app:expandedTitleMarginStart="8dp"
                 app:layout_scrollFlags="scroll|exitUntilCollapsed|snap">

                 <RelativeLayout
                     android:id="@+id/backdrop"
                     android:layout_width="match_parent"
                     android:layout_height="match_parent"
                     android:background="@drawable/ic_home_weibo"
                     android:contentDescription="@string/entity"
                     app:layout_collapseMode="parallax">

                     <TextView
                         android:id="@+id/publish_time_text_view"
                         android:layout_width="wrap_content"
                         android:layout_height="wrap_content"
                         android:layout_alignParentBottom="true"
                         android:layout_alignParentEnd="true"
                         android:layout_alignParentRight="true"
                         android:layout_marginBottom="8dp"
                         android:layout_marginEnd="8dp"
                         android:layout_marginRight="8dp"
                         android:text="发布时间 2017-08-02 19:00"
                         android:textColor="@android:color/white"
                         android:textSize="12sp"
                         tools:text="发布时间 2017-08-02 19:00" />

                     <TextView
                         android:id="@+id/temp_text_view"
                         android:layout_width="wrap_content"
                         android:layout_height="wrap_content"
                         android:layout_above="@id/publish_time_text_view"
                         android:layout_alignEnd="@id/publish_time_text_view"
                         android:layout_alignRight="@id/publish_time_text_view"
                         android:includeFontPadding="false"
                         android:text="12°"
                         android:textColor="@android:color/white"
                         android:textSize="88sp"
                         tools:text="12°" />

                     <TextView
                         android:id="@+id/weather_text_view"
                         android:layout_width="wrap_content"
                         android:layout_height="wrap_content"
                         android:layout_above="@+id/temp_text_view"
                         android:layout_alignEnd="@+id/publish_time_text_view"
                         android:layout_alignRight="@+id/publish_time_text_view"
                         android:text="小鱼"
                         android:textColor="@android:color/white"
                         android:textSize="14sp"
                         tools:text="小雨" />
                 </RelativeLayout>

                 <android.support.v7.widget.Toolbar
                     android:id="@+id/toolbar"
                     android:layout_width="match_parent"
                     android:layout_height="?attr/actionBarSize"
                     app:layout_collapseMode="pin"
                     app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />

             </android.support.design.widget.CollapsingToolbarLayout>
         </android.support.design.widget.AppBarLayout>

         <android.support.v4.widget.NestedScrollView
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             app:layout_behavior="@string/appbar_scrolling_view_behavior">


             <LinearLayout
                 android:layout_width="match_parent"
                 android:layout_height="match_parent"
                 android:orientation="vertical">

                 <View
                     android:layout_width="match_parent"
                     android:layout_height="500dp"
                     android:background="@color/colorPrimary" />

                 <View
                     android:layout_width="match_parent"
                     android:layout_height="500dp"
                     android:background="@color/colorAccent" />
             </LinearLayout>
         </android.support.v4.widget.NestedScrollView>
     </android.support.design.widget.CoordinatorLayout>

     public class FiveActivity extends AppCompatActivity {

         @BindView(R.id.toolbar)
         Toolbar toolbar;
         @BindView(R.id.collapsing_toolbar)
         CollapsingToolbarLayout collapsingToolbarLayout;
         @BindView(R.id.backdrop)
         RelativeLayout relativeLayout;
         @Override
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_five);
             ButterKnife.bind(this);
             setSupportActionBar(toolbar);
             toolbar.setNavigationIcon(R.drawable.ic_bar_back);
             toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     finish();
                 }
             });
             collapsingToolbarLayout.setTitle("你好呀啊啊");
             collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
             collapsingToolbarLayout.setCollapsedTitleTextColor(Color.YELLOW);

             Glide.with(this)
                     .load(R.drawable.ic_home_weibo)
                     .apply(RequestOptions.bitmapTransform(new BlurTransformation(25)))
                     .into(new SimpleTarget<Drawable>() {
                         @Override
                         public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                             relativeLayout.setBackground(resource);
                         }
                     });
         }
     }
