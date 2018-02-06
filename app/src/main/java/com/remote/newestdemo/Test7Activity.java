package com.remote.newestdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test7Activity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout outer;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);
        outer = (RelativeLayout) findViewById(R.id.outer);
        web = (WebView) findViewById(R.id.wweb);
        findViewById(R.id.save).setOnClickListener(this);

        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            web.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        web.setVerticalScrollBarEnabled(false); //垂直不显示
        web.addJavascriptInterface(this, "nativeJs");
        web.setWebViewClient(new MyWebViewClient());
//        web.setWebChromeClient(new MyWebChromeClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBlockNetworkImage(false);//解决图片不显示
        web.loadUrl("https://api2.wifiyaoshi.com/nb-2401.html");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
//                saveTo();
                break;
        }
    }

    // 分享年报
    @JavascriptInterface
    public void shareNb(final String url, final String pic, final String title, final String desc) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                new UmShare(Test7Activity.this, url, pic, title, desc).postShare();
            }
        });
    }

    // 保存->相册
    @JavascriptInterface
    public void saveNb() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                saveToGallery();
            }
        });
    }

    private void saveToGallery() {
        new AnnualThread().start();
    }

    class AnnualThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int width = web.getWidth();
            int height = web.getHeight();
            Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            web.draw(c);
            Log.e("aaaaaaaaaaaa1", "111");

            // 首先保存图片
            File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = "annual" + ".jpg";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                b.compress(Bitmap.CompressFormat.JPEG, 60, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("aaaaaaaaaaaa1", "222");

            String absolutePath = file.getAbsolutePath();
            // 其次把文件插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(Test7Activity.this.getContentResolver(),
                        absolutePath, fileName, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Log.e("aaaaaaaaaaaa1", "333");
//             最后通知图库更新
            Test7Activity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
            Log.e("aaaaaaaaaaaa1", "444");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.e("aaaaaaaaaaaa1", "done!!!!!!!!!!");
                    Toast.makeText(Test7Activity.this, "done!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

//    private void saveTo() {
//        int width = web.getWidth();
//        int height = web.getHeight();
//        Log.e("hhhhhhhhhhhhhh-", "width - " + width + ", height - " + height);
//        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        Canvas c = new Canvas(bitmap);
//        web.draw(c);
//        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", "description");
//        saveImageToGallery(this, bitmap);
//    }
//
//    public static void saveImageToGallery(Context context, Bitmap bmp) {
//        // 首先保存图片
//        File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
//        if (!appDir.exists()) {
//            appDir.mkdir();
//        }
//        String fileName = "annual" + ".png";
//        File file = new File(appDir, fileName);
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
//            fos.flush();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String absolutePath = file.getAbsolutePath();
//        // 其次把文件插入到系统图库
//        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(),
//                    absolutePath, fileName, null);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 最后通知图库更新
//        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + absolutePath)));
//    }

    class MyWebViewClient extends WebViewClient {

    }


}
