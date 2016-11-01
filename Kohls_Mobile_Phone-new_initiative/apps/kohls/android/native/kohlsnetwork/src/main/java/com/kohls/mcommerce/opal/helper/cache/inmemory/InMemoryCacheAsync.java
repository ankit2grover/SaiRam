
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import com.kohls.mcommerce.opal.common.util.UtilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;

/**
 * This is a async task to save the LinkedHashMap into the file
 */
public class InMemoryCacheAsync {

    private static final String TAG = "InMemoryCacheAsync";

    private int mScreenId = 0;

    public InMemoryCacheAsync(int screenId) {
        mScreenId = screenId;
    }

    public interface IResultMap {
        public void resultHashMap(LinkedHashMap<String, InMemoryCacheVO> map);
    }

    @SuppressWarnings("unchecked")
    public synchronized LinkedHashMap<String, InMemoryCacheVO> getHashmapfromFile() {
        LinkedHashMap<String, InMemoryCacheVO> hashMap = null;
        ObjectInputStream objectStream = null;
        File file = null;
        try {
            file = UtilityMethods.createFile(InMemoryCacheHelper.getFileName(mScreenId));
            if (file != null && file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                if (fileInputStream != null && fileInputStream.available() > 0) {
                    objectStream = new ObjectInputStream(fileInputStream);
                    if (objectStream != null) {
                        hashMap = (LinkedHashMap<String, InMemoryCacheVO>) objectStream.readObject();
                    }
                }
            }

        } catch (Exception ex) {
        } finally {
            try {
                if (objectStream != null) {
                    objectStream.close();
                }
            } catch (IOException e) {
            }
        }
        return hashMap;
    }
}
