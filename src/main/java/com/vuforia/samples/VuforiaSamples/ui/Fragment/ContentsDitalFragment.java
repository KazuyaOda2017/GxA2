package com.vuforia.samples.VuforiaSamples.ui.Fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.Common.ProductInfo;
import com.vuforia.samples.VuforiaSamples.ui.Common.UserInfo;
import com.vuforia.samples.VuforiaSamples.ui.CustomView.DitailView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aquat on 2017/12/28.
 */

public class ContentsDitalFragment extends Fragment {

    View layout;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        try{

            layout = inflater.inflate(R.layout.contents_dital_fragment, null);

        }catch (Exception e){

            e.printStackTrace();
        }


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //画像をセット
                ImageView imageView = (ImageView)layout.findViewById(R.id.photo);
                imageView.setImageResource(BackGround.valueOf(UserInfo.getInstance().getProductInfoMap().get("image")).id);
                TextView header = (TextView)layout.findViewById(R.id.product_name);
                header.setText(UserInfo.getInstance().getProductInfoMap().get(ProductInfo.cardIndexNames[0]));
                //imageView.setImageResource(R.drawable.puroduct_smple1);
                /*URL url;

                InputStream istream;
                try {
//画像のURLを直うち
                    url = new URL(UserInfo.getInstance().getProductInfoMap().get("写真"));
//インプットストリームで画像を読み込む
                    istream = url.openStream();
//読み込んだファイルをビットマップに変換
                    Bitmap oBmp = BitmapFactory.decodeStream(istream);
//ビットマップをImageViewに設定
                    imageView.setImageBitmap(oBmp);//oImg.setImageBitmap(oBmp);
//インプットストリームを閉じる
                    istream.close();
                } catch (Exception e) {
// TODO 自動生成された catch ブロック
                    e.printStackTrace();
                }*/


            }
        });
        thread.start();

        LinearLayout ditaileLine = (LinearLayout)layout.findViewById(R.id.contents_detail);

        //詳細情報分Viewを追加
     /*   for(Map.Entry<String,String> e : UserInfo.getInstance().getProductInfoMap().entrySet()){


            if(e.getKey().equals("写真"))continue;

            DitailView ditailView = new DitailView(this.getActivity().getApplicationContext(),null);
            ditailView.setText(e.getKey(),e.getValue());

            ditaileLine.addView(ditailView);

        }*/

     for(String key : getString(R.string.detail_title).split(",")){

         String value = UserInfo.getInstance().getProductInfoMap().get(key);

         DitailView ditailView = new DitailView(this.getActivity().getApplicationContext(),null);
         ditailView.setText(key,value);

         ditaileLine.addView(ditailView);
     }

        return layout;
    }

    private enum BackGround {
        blendsone(R.drawable.img_blendsone),
        blendsweet(R.drawable.img_blendsweet),
        brazil(R.drawable.img_brazil),
        cashe_scholrship(R.drawable.img_cashe_scholrship),
        ethiopia_conga(R.drawable.img_ethiopia_conga),
        mandelin(R.drawable.img_mandelin),
        ethiopia_hawa(R.drawable.img_ethiopia_hawa);

        private int id;

        private BackGround(int id) {
            this.id = id;
        }
    }
}
