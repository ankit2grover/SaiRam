package com.kohls.mcommerce.opal.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kohls.mcommerce.opal.common.value.ConstantValues;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Created by tkmaea9 on 7/21/15.
 */
public class NetworkUtils {

    /**
     * @param Object
     * @return Json String
     */
    public static String createJsonFromModel(Object response) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String gsonString = gson.toJson(response);
        return gsonString;
    }

    public static void dumpIntoFile(String logText, String fileName, Context context) {
        // Get the file object - 1) Check if there is SD card present, if
        // present - use it, or move to the application Internal Memory cache

        File mFile = createFile(fileName, context);
        // IF file object does not exists, create it.
        if (null != mFile) {
            boolean append = true;
            // if ((System.currentTimeMillis() - mFile.lastModified()) > 24 * 60
            // *
            // 60 * 1000) {
            // append=false;
            // }

            BufferedWriter bW;

            try {
                bW = new BufferedWriter(new FileWriter(mFile, append));
                bW.write(logText);
                bW.newLine();
                bW.flush();
                bW.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // }
        }

    }

    public static File createFile(String mFileName, Context context) {
        // Get the file object - 1) Check if there is SD card present, if
        // present - use it, or move to the application Internal Memory cache

        File mFile = new File(getFileData(context,
                hasSDCard(context) ? ConstantValues.EXTERNAL_CACHE_DIR
                        : ConstantValues.CACHE_DIR),
                mFileName);
        // IF file object does not exists, create it.
        if (!mFile.exists()) {
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return mFile;
    }

    public static File getFileData(Context ctx, int type) {
        switch (type) {
            case ConstantValues.CACHE_DIR:
                return ctx.getFilesDir();

            case ConstantValues.EXTERNAL_CACHE_DIR:
                return ctx.getExternalCacheDir();
        }

        return null;
    }

    public static boolean hasSDCard(Context ctx) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }

    public static long getTimeinLong(String expires) {
        SimpleDateFormat parserSDF = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss zzz");
        Date dateStr = null;
        try {
            if (expires != null) {
                dateStr = parserSDF.parse(expires);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (dateStr != null) {
            return dateStr.getTime();
        }
        return 0;
    }

    /**
     * Compare date/time with current time
     *
     * @param getmExpiryTime
     * @return
     */
    public static boolean checkDataExpired(long getmExpiryTime) {
        Date mSavedTime = new Date(getmExpiryTime);
        Date currTime = new Date();
        if (mSavedTime.after(currTime)) {
            return false;
        }
        return true;
    }
    }
