package com.vuforia.samples.VuforiaSamples.ui.Common;

import android.net.Uri;
import android.os.AsyncTask;

/**
 * Created by aquat on 2017/12/18.
 */

interface HttpInterFace {

    //region 定義
    public enum ProgressType{
        DIALOG,
        NOPROGRESS,
    }
    //endregion

    //region 定数
    //ユーザー情報登録
    public static final String INSERT_USERINFO =  "https://t1-dot-gcloud-t1.appspot.com/insert/user";

    //リロード
    public static final String SELECT_COMMENT = "https://t1-dot-gcloud-t1.appspot.com/select/comment";

    //コメント登録・編集
    public static final String EDIT_COMMENT = "https://t1-dot-gcloud-t1.appspot.com/edit/comment";

    //コンテンツ情報取得
    public static final String SELECT_CONTENTS = "https://t1-dot-gcloud-t1.appspot.com/select/contents";
    //endregion

}
