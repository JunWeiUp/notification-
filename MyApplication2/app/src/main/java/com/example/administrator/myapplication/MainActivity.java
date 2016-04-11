package com.example.administrator.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //用RemoteViews来创建自定义Notification视图
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                Notification.Builder builder = new Notification.Builder(MainActivity.this);
//                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/"));
//                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, mIntent, 0);
//                builder.setContentIntent(pendingIntent);
//                builder.setSmallIcon(R.mipmap.ic_launcher);
//                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
//                builder.setAutoCancel(true);
//                builder.setContentTitle("折叠式通知");
//                //用RemoteViews来创建自定义Notification视图
//                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_fold);
//                Notification notification = builder.build();
//                //指定展开时的视图
//                notification.bigContentView = remoteViews;
//                notificationManager.notify(0, notification);


                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, mIntent, 0);
                builder.setContentIntent(pendingIntent);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                builder.setAutoCancel(true);
                builder.setContentTitle("悬挂式通知");
                //设置点击跳转
                Intent hangIntent = new Intent();
                hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                hangIntent.setClass(MainActivity.this, MainActivity.class);
                //如果描述的PendingIntent已经存在，则在产生新的Intent之前会先取消掉当前的
                PendingIntent hangPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setFullScreenIntent(hangPendingIntent, true);
                notificationManager.notify(2, builder.build());
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
