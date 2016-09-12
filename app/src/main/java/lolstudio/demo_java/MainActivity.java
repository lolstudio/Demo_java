package lolstudio.demo_java;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.vipabc.common.FeatureActivity;
import com.vipabc.data.Account;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_capture;
    private Button btn_capture;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getLocaleCalendar();
//        Toast.makeText(this, getLangLocale(), Toast.LENGTH_LONG).show();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                mHandler=new Handler(Looper.myLooper());
                Looper.loop();
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            }
        }.start();

    }

    public String getLang() {
        String temp = "ja";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lang", temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity) + getStatusHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }


    /**
     * 获得屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }


    /**
     * 分享给小伙伴
     */
    public static void ShareWithOther(Context con, String content, String title) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "分享");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
        con.startActivity(Intent.createChooser(shareIntent, title));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == FeatureActivity.REQUEST_CODE_ACCOUNT) {
                Account account = (Account) data.getSerializableExtra(FeatureActivity.INTENT_EXTRA_ACCOUNT);
                if (account != null) {
                    System.out.println("name:" + account.getName() + "pass:" + account.getPass());
                }
            }
        }
    }

    public static String getLangLocale() {
        String lang = Locale.JAPAN.getLanguage();
        if (!lang.equalsIgnoreCase("en")) {
            lang += Locale.JAPAN.getCountry();
        }
        return lang;
    }


    /**
     * 获取对应语言的时间
     * http://stackoverflow.com/questions/16313372/calendar-failed-to-get-the-days-names-in-different-languages-than-english
     */
    private void getLocaleCalendar() {
        Calendar calendarTime = Calendar.getInstance();
        SimpleDateFormat simple = new SimpleDateFormat("M d EEEE", Locale.CHINA);
        String tmp = simple.format(calendarTime.getTime());
        String[] tmpList = tmp.split(" ");
        for (String s : tmpList) {
            System.out.println(s);
        }


        Calendar instance = Calendar.getInstance();
        Map<String, Integer> displayNames = instance.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.JAPAN);
        for (String key : displayNames.keySet()) {
            System.out.println(key + "___" + displayNames.get(key));
        }


        String[] weekdays = new DateFormatSymbols(Locale.JAPAN).getWeekdays();
        for (int i = 0; i < weekdays.length; i++) {
            System.out.println("weekday = " + weekdays[i]);
        }
    }
}
