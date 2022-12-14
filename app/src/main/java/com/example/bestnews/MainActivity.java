package com.example.bestnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList< HashMap<String,String> > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);

        createTable();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
    }




    //============================================================
    //============================================================
    //============================================================

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.item, viewGroup, false);

            ImageView itemCover = myView.findViewById(R.id.itemCover);
            TextView itemCat = myView.findViewById(R.id.itemCat);
            TextView itemTitle = myView.findViewById(R.id.itemTitle);
            TextView itemDes = myView.findViewById(R.id.itemDes);
            LinearLayout layItem = myView.findViewById(R.id.layItem);

            HashMap<String, String> hashMap = arrayList.get(position);
            String cat = hashMap.get("cat");
            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String des = hashMap.get("des");

            Picasso.get().load(image_url)
                    .placeholder(R.drawable.juba)
                    .into(itemCover);

            itemCat.setText(cat);
            itemTitle.setText(title);
            itemDes.setText(des);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCat.setBackgroundColor(color);

            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NewsDetails.TITLE = title;
                    NewsDetails.DESCRIPTION = des;
                    Bitmap bitmap = ( (BitmapDrawable) itemCover.getDrawable() ).getBitmap();
                    NewsDetails.MY_BITMAP = bitmap;

                    startActivity( new Intent(MainActivity.this, NewsDetails.class));
                }
            });





            return myView;
        }
    }





//============================================================
    //============================================================

    //============================================================


    private void createTable(){

        hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/05/nothing-lead-20220507134631.jpg");
        hashMap.put("title", "????????????????????? ??????????????? ?????????????????? ???????????? ??????????????? ????????? ???, ????????? ????????? ??????");
        hashMap.put("des", "??????????????????-????????????????????? ??????????????? ??????????????? ?????????????????? ??????????????? ?????????????????? ??????????????? ????????????????????? ??????????????????????????? ???????????????????????? ??????????????? ???????????????????????? ??????????????????????????? ???????????? ????????? ?????????????????? ????????? ????????? ?????? ?????????????????? ????????????????????? ????????? ???????????? ?????????????????? ??????????????? ?????? ????????? ???????????? ???????????????????????? ?????????????????? ??????????????? ?????????????????????????????????\n" +
                "???????????????????????? ????????????????????? ??????????????? ???????????????????????? ??????????????? ????????? ?????????????????? ?????????????????? ?????? ?????????????????? ?????????????????? ??????????????? ????????? ????????? ????????? ??????????????????????????? ????????????????????? ?????????????????? ?????? ???????????????????????? ??????????????? ????????????????????????????????? ???????????? ??????????????? ????????? ?????? ?????????????????? ????????????????????? ??????????????? ?????????????????? ???????????? ?????????????????? ?????????????????? ???????????????????????? ???????????????????????????????????? ???????????????\n" +
                "??? ??????????????? ???????????????????????? ???????????? ??????????????? ????????? ??? ???????????? ??????????????? ?????????????????? ????????????????????? ??????????????? ??????????????? ?????? ????????????????????????????????? ??????????????? ????????? ???????????????????????????????????? ????????????????????? ?????????????????? ?????????????????? ??????????????? ?????????????????? ???????????? ???????????? ??????????????? ???????????????????????? ?????????????????? ????????? ???????????? ??????????????? ???????????????????????? ???????????? ??????????????????????????? ??????????????????\n" +
                "\n" +
                "???????????????????????? ???????????? ?????? ???????????????????????????????????? ???????????? ?????????????????? ?????? ???????????? ??????????????? ????????? ??????????????? ?????????????????? ????????? ????????????????????? ????????? ????????? ??????????????? ????????? ?????? ????????????????????? ?????????????????????????????????????????? ??????????????? ?????????????????? ???????????????, ????????? ?????????????????? ????????? ???????????? ????????? ???????????? ????????? ?????????????????? ?????????????????? ????????? ??????????????????\n" +
                "\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "GAME");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2021/05/%E0%A6%AB%E0%A7%8D%E0%A6%B0%E0%A6%BF-%E0%A6%AB%E0%A6%BE%E0%A7%9F%E0%A6%BE%E0%A6%B0-%E0%A6%93-%E0%A6%AA%E0%A6%BE%E0%A6%AC%E0%A6%9C%E0%A6%BF.jpg");
        hashMap.put("title", "?????????????????? ???????????? ?????? ?????? ???????????????");
        hashMap.put("des", "?????????????????? ????????????????????? ???????????? ????????? ????????????????????? ????????? ??????????????????????????? ??????????????? ???????????????????????????????????? ????????? ????????????????????? ????????? ??????????????? ???????????? ?????????????????? ????????????????????? ???????????? ??????????????????????????? ?????????????????????????????? ???????????? ???????????? ????????? ?????????????????? ???????????? ??????????????? ???????????? ?????????????????? ????????? ??????????????? ????????? ????????? ????????????????????? ????????????????????? ????????????????????????????????? ??????????????????????????? ???????????????????????? ???????????? ?????????????????? ??????????????????????????? ?????????????????? ?????????????????? ????????????????????? ???????????? ???????????? ???????????????????????? ??????????????? ??????????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ??????????????? ???????????????, ????????? ???????????? ???????????? ????????? ????????? ?????????????????? ???????????? ???????????? ??????????????? ????????? ???????????? ???????????? ???????????? ????????????????????? ????????????????????? ??????????????? ??????, ?????????????????? ???????????? ????????? ???????????? ???????????? ??????? ??? ?????????, ??????????????????, ???????????? ??????????????? ???????????????, ????????? ??????????????? ?????????????????????\n" +
                "????????? ???????????????????????? ???????????? ????????? ?????????????????? ?????????????????? ????????????????????? ?????? ??????????????? ??????????????? ???????????????????????? ????????? ??????????????? ??????????????? ???????????????????????? ?????????????????????????????? ???????????? ?????????????????? ???????????????????????? ?????????????????? ?????????????????? ????????? ???????????????????????? ???????????? ????????????????????? ?????????????????? ????????? ????????? ???????????? ????????? ????????????????????? ?????????????????? ?????????????????? ????????????????????? ??????????????? ???????????? ?????????????????????????????? ????????????????????? ??????????????? ????????? ????????? ???????????????????????? ????????? ??????????????? ??????????????? ?????????????????????????????? ????????????????????? ?????????????????? ???????????? ????????? ???????????????????????? ??????????????? ??????????????? ?????? ???????????? ????????? ?????? ????????? ???????????? ????????? ????????? ?????????????????? ????????? ????????? ???????????? ???????????? ????????? ?????????????????????????????? ???????????? ????????????????????? ????????? ?????? ?????? ??????????????????????????????????????? ??????????????? ???????????? ????????? ????????? ?????????????????? ????????? ?????????????????????????????? ????????? ???????????????????????? ????????? ?????????????????? ??????????????????, ???????????? ???????????? ??????????????? ????????????????????? ????????????????????? ???????????? ??????????????? ?????????????????? ???????????????\n" +
                "\n");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("cat", "SPACE");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/04/%E0%A6%AE%E0%A6%B9%E0%A6%BE%E0%A6%95%E0%A6%BE%E0%A6%B6%E0%A7%87-%E0%A6%95%E0%A6%BE%E0%A6%AC%E0%A6%BE%E0%A6%AC-%E0%A6%AA%E0%A6%BE%E0%A6%A0%E0%A6%BE%E0%A6%A8%E0%A7%8B%E0%A6%B0-%E0%A6%9A%E0%A7%87%E0%A6%B7%E0%A7%8D%E0%A6%9F%E0%A6%BE.jpg");
        hashMap.put("title", "????????????????????? ???????????? ???????????? ?????? ?????????????????????-???????????????????????????????????? ?????????????????????");
        hashMap.put("des", "?????????????????? ?????? ?????????????????????????????? ???????????? ?????????????????????????????? ???????????? ????????????????????? ???????????? ??????????????? ?????????????????????????????? ??????????????????????????? ????????????????????? ?????? ?????????????????? ???????????? ?????????????????????????????? ??????????????? ??????????????? ?????????????????? ???????????????????????? ???????????? ?????????????????? ???????????? ?????????????????? ?????????????????? ????????????????????? ??????????????? ????????????????????? ?????????????????? ????????????????????? ??????????????? ???????????????????????? ????????? ???????????????\n" +
                "\n???????????????????????? ???????????????, ???????????? ?????????????????? ?????? ?????? ?????????????????? ????????????????????? ????????? ??????????????? ???????????? ????????? ????????????????????? ?????????????????? ?????????????????? ?????????????????? ????????? ???????????????, ?????????????????? ??? ??????????????? ????????????????????? ?????????????????? ?????? ??????????????? ??? ??????????????? ????????????????????? ???????????????????????? ?????????????????? ??????????????? ???????????? ??????????????????????????? ??????????????? ?????? ?????? ?????????????????????\n" +
                "????????? ????????? ??????, ?????????????????? ?????????????????? ????????????????????? ?????????????????? ??????????????? ???????????? ???????????? ?????? ???????????? ??????????????? ???????????? ??????????????? ??????????????? ??????????????????????????? ????????????????????? ??????????????? ???????????? ???????????? ??????????????? ????????? ???????????? ??????????????? ??? ????????????????????? ?????????????????? ????????? ????????? ?????? ???????????? ???????????? ???????????? ????????????????????????????????? ?????????????????? ????????? ?????????????????? ????????????????????????????????? ???????????????\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "TRENDING");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/04/%E0%A6%85%E0%A6%9A%E0%A6%BF%E0%A6%B0%E0%A7%87%E0%A6%87-%E0%A6%95%E0%A6%BF-%E0%A6%AA%E0%A7%83%E0%A6%A5%E0%A6%BF%E0%A6%AC%E0%A7%80-%E0%A6%86%E0%A6%95%E0%A7%8D%E0%A6%B0%E0%A6%AE%E0%A6%A3-%E0%A6%95%E0%A6%B0%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%B2%E0%A6%BF%E0%A7%9F%E0%A7%87%E0%A6%A8%E0%A6%B0%E0%A6%BE.jpg");
        hashMap.put("title", "?????????????????? ?????? ?????????????????? ?????????????????? ???????????? ?????????????????????????");
        hashMap.put("des", "?????????????????? ???????????? ?????? ???????????? ???????????? ??? ?????????????????? ??????????????? ?????????????????? ???????????????????????? ????????????????????? ?????????????????? ?????????????????? ?????????????????? ???????????????\n" +
                "???????????? ?????? ????????????????????? ?????????????????? ????????????????????? ???????????????????????? ????????????????????? ??????????????????????????? ?????? ?????????????????? ?????????????????? ??????????????? ????????????????????? ?????????????????? ??????????????? ????????????????????? ???????????? ???????????? ??????????????? ???????????? ??????????????? ????????????????????? ???????????? ???????????? ????????? ??????????????? ????????????????????????????????? ??????????????????\n" +
                "???????????????????????? ??????????????? ?????? ???????????? ?????????????????? ????????? ????????????, ?????? ???????????? ????????????????????????????????? ??????????????? ???????????????????????? ???????????? ???????????? ?????? ???????????? ????????????????????? ????????? ????????? ??????????????????????????? ???????????? ???????????? ???????????????????????????\n" +
                "\n" +
                "?????? ????????????????????????????????? ?????????????????? ???????????????????????? ??????, ?????????????????? ???????????? ?????????????????? ?????? ???????????? ??????????\n" +
                "????????????????????????????????? ??????????????????, ???????????????????????? ??????????????? ????????? ?????????????????? ???????????? ?????????????????? ???????????? ????????????, ???????????????????????? ??????????????? ?????????????????? ????????????????????? ????????? ???????????? ?????????????????? ???????????? ?????????????????? ????????????????????? ??????????????? ????????? ???????????? ???????????? ???????????? ???????????? ?????????????????? ???????????? ????????????????????????\n" +
                "?????? ????????????????????? ???????????????????????? ???????????? ???????????? ???????????? ????????????????????? ???????????? ??????????????? ???????????? ????????? ????????? ???????????????, ????????? ???????????????????????? ?????????????????? ?????????????????? ?????????, ????????? ???????????? ???????????? ??????????????? ????????????????????? ????????????\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "GAME");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2021/05/%E0%A6%AB%E0%A7%8D%E0%A6%B0%E0%A6%BF-%E0%A6%AB%E0%A6%BE%E0%A7%9F%E0%A6%BE%E0%A6%B0-%E0%A6%93-%E0%A6%AA%E0%A6%BE%E0%A6%AC%E0%A6%9C%E0%A6%BF.jpg");
        hashMap.put("title", "?????????????????? ???????????? ?????? ?????? ???????????????");
        hashMap.put("des", "?????????????????? ????????????????????? ???????????? ????????? ????????????????????? ????????? ??????????????????????????? ??????????????? ???????????????????????????????????? ????????? ????????????????????? ????????? ??????????????? ???????????? ?????????????????? ????????????????????? ???????????? ??????????????????????????? ?????????????????????????????? ???????????? ???????????? ????????? ?????????????????? ???????????? ??????????????? ???????????? ?????????????????? ????????? ??????????????? ????????? ????????? ????????????????????? ????????????????????? ????????????????????????????????? ??????????????????????????? ???????????????????????? ???????????? ?????????????????? ??????????????????????????? ?????????????????? ?????????????????? ????????????????????? ???????????? ???????????? ???????????????????????? ??????????????? ??????????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ??????????????? ???????????????, ????????? ???????????? ???????????? ????????? ????????? ?????????????????? ???????????? ???????????? ??????????????? ????????? ???????????? ???????????? ???????????? ????????????????????? ????????????????????? ??????????????? ??????, ?????????????????? ???????????? ????????? ???????????? ???????????? ??????? ??? ?????????, ??????????????????, ???????????? ??????????????? ???????????????, ????????? ??????????????? ?????????????????????\n" +
                "????????? ???????????????????????? ???????????? ????????? ?????????????????? ?????????????????? ????????????????????? ?????? ??????????????? ??????????????? ???????????????????????? ????????? ??????????????? ??????????????? ???????????????????????? ?????????????????????????????? ???????????? ?????????????????? ???????????????????????? ?????????????????? ?????????????????? ????????? ???????????????????????? ???????????? ????????????????????? ?????????????????? ????????? ????????? ???????????? ????????? ????????????????????? ?????????????????? ?????????????????? ????????????????????? ??????????????? ???????????? ?????????????????????????????? ????????????????????? ??????????????? ????????? ????????? ???????????????????????? ????????? ??????????????? ??????????????? ?????????????????????????????? ????????????????????? ?????????????????? ???????????? ????????? ???????????????????????? ??????????????? ??????????????? ?????? ???????????? ????????? ?????? ????????? ???????????? ????????? ????????? ?????????????????? ????????? ????????? ???????????? ???????????? ????????? ?????????????????????????????? ???????????? ????????????????????? ????????? ?????? ?????? ??????????????????????????????????????? ??????????????? ???????????? ????????? ????????? ?????????????????? ????????? ?????????????????????????????? ????????? ???????????????????????? ????????? ?????????????????? ??????????????????, ???????????? ???????????? ??????????????? ????????????????????? ????????????????????? ???????????? ??????????????? ?????????????????? ???????????????\n" +
                "\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "TIPS");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2021/04/%E0%A6%AC%E0%A6%BE%E0%A7%9C%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A8%E0%A6%BF%E0%A6%A8-%E0%A6%B8%E0%A7%8D%E0%A6%AE%E0%A6%BE%E0%A6%B0%E0%A7%8D%E0%A6%9F%E0%A6%AB%E0%A7%8B%E0%A6%A8%E0%A7%87%E0%A6%B0-%E0%A6%AC%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%9F%E0%A6%BE%E0%A6%B0%E0%A6%BF%E0%A6%B0-%E0%A6%86%E0%A7%9F%E0%A7%81.jpg");
        hashMap.put("title", "????????????????????? ??????????????????????????? ?????????????????? ?????? ??????????????? ????????????????????????, ??????????????? ?????? ????????????");
        hashMap.put("des", "????????????????????? ?????????????????? ???????????????????????????????????? ????????? ??????????????? ?????????????????? ?????? ???????????? ??????????????? ??????????????? ??????????????? ?????? ???????????????????????????????????? ???????????? ????????????????????? ????????? ???????????????????????? ????????????????????? ????????? ??????????????????????????? ??????????????? ?????? ???????????????????????????????????? ????????????????????? ???????????? ??????????????? ?????????????????????????????? ????????? ??????????????? ??????????????????????????? ???????????????????????? ????????? ????????????????????? ???????????? ??????????????? ??????????????? ???????????????????????? ??????????????? ?????? ???????????? ???????????? ???????????? ???????????? ????????????????????????????????? ??????????????? ????????? ??????????????? ???????????? ???????????? ???????????? ??????????????????????????? ????????? ??? ?????????????????? ???????????? ??????????????? ????????? ???????????????????????? ????????? ???????????? ??????????????? ???????????????????????? ??????????????? ?????? ??????????????? ??????????????????? ??????????????? ?????? ?????????????????????????????????\n" +
                "???% ???????????? ?????????% ??????????????? ??????????????? ??????\n" +
                "?????????????????? ??????????????? ????????? ????????? ??????????????? ????????????????????? ??????????????? ??????????????? ?????????????????? ????????? ??????????????? ??????????????????????????? ?????????????????? ???????????? ???????????? ???????????? ????????? ??????????????? ???????????????????????? ???????????? ???????????????????????? ??????????????? ??????????????? ????????? ?????????????????? ???????????? ??????-?????? ????????????????????? ??????????????? ????????????????????? ???????????? ????????? ??????????????? ???????????? ????????? ?????? ??????????????? ?????????????????????????????? ????????? ????????????????????? ???????????? ???????????? ??????????????? ????????? ??????????????? ??????????????? ???????????????????????? ???????????? ????????? ??????????????? ??????????????? ?????? ??????????????? ?????????????????? ??????????????? ???????????????????????? ???????????? ??? ??????????????? ????????????????????? ???????????????????????? ??????????????? ????????? ?????????????????? ???????????? ?????? ??????????????? ????????????????????? ???????????? ???????????? ????????? ??????????????? ???????????? ????????? ???????????????\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/04/%E0%A7%AA%E0%A7%AA-%E0%A6%AC%E0%A6%BF%E0%A6%B2%E0%A6%BF%E0%A7%9F%E0%A6%A8-%E0%A6%A1%E0%A6%B2%E0%A6%BE%E0%A6%B0%E0%A7%87-%E0%A6%9F%E0%A7%81%E0%A6%87%E0%A6%9F%E0%A6%BE%E0%A6%B0%E0%A7%87%E0%A6%B0-%E0%A6%AE%E0%A6%BE%E0%A6%B2%E0%A6%BF%E0%A6%95-%E0%A6%B9%E0%A6%9A%E0%A7%8D%E0%A6%9B%E0%A7%87%E0%A6%A8-%E0%A6%87%E0%A6%B2%E0%A7%8B%E0%A6%A8-%E0%A6%AE%E0%A6%BE%E0%A6%B8%E0%A7%8D%E0%A6%95.jpg\n");
        hashMap.put("title", "?????? ?????????????????? ??????????????? ???????????????????????? ??????????????? ?????????????????? ???????????? ???????????????");
        hashMap.put("des", "???????????? ??? ??????????????? ????????? ???????????? ????????????????????? ???????????? ?????????????????? ????????? ????????????????????? ?????????????????? ???????????? ?????????????????? ???????????? ????????????????????? ??????????????? ??? ??????????????? ?????????????????? ????????????????????????????????? ???????????????????????? (????????????) ???????????? ?????????????????? ???????????????????????? ???????????????????????? ?????????????????? ????????? ??? ???????????????????????? ???????????????????????? ??????????????? ?????????????????? ????????????????????? ????????? ?????????????????? ??? ??????????????? ???????????? ????????? ????????? ????????????????????????\n" +
                "?????????????????????????????? ????????? ??????, ???????????? ??????????????? ????????? ?????? ???????????????????????? ??? ?????????????????????????????? ???????????? ??? ????????????????????? ????????? ????????????????????? ????????????????????? ????????????????????? ???????????? ???????????????????????? ???????????????????????? ???????????????????????? ??????????????? ????????????????????? ??????????????? ?????????????????? ????????????????????? ????????? ???????????????\n" +
                "???????????? ????????? ????????? ??????, ?????????????????? ????????? ???????????????????????? ????????????????????? ????????????????????? ???????????????????????? ????????? ????????? ???????????? ?????? ??????????????? ?????? ??????????????? ????????????????????? ????????? ?????????????????? ???????????? ?????????????????? ?????????????????? ??????????????????????????? ?????????????????????????????? ??????????????? ???????????? ??????????????? ????????? ???????????? ???????????????????????? ???????????? ?????????????????????????????? ??????????????? ?????????????????? ???????????????????????? ????????????????????? ?????? ???????????? ??? ??????????????? ???????????? ?????? ??????????????? ?????? ??????????????? ????????????????????????\n" +
                "???????????????????????? ??????????????? ????????????????????? ?????? ????????? ???????????? ????????????????????? ????????????????????? ????????????????????? ?????????????????? ????????? ?????????????????? ??????????????? ??????????????? ????????? ??????????????? ??????????????? ??????????????????????????? ?????????????????? ???????????? ??????????????? ???????????? ?????????????????? ????????? ?????????????????? ???????????? ???????????????????????? ??????????????? ????????? ??????????????? ??????????????? ?????? ?????????????????? ???????????? ??? ???????????????????????? ???????????? ???????????? ????????????????????? ??????????????????\n" +
                "\n" +
                "\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/05/nothing-lead-20220507134631.jpg");
        hashMap.put("title", "????????????????????? ??????????????? ?????????????????? ???????????? ??????????????? ????????? ???, ????????? ????????? ??????");
        hashMap.put("des", "??????????????????-????????????????????? ??????????????? ??????????????? ?????????????????? ??????????????? ?????????????????? ??????????????? ????????????????????? ??????????????????????????? ???????????????????????? ??????????????? ???????????????????????? ??????????????????????????? ???????????? ????????? ?????????????????? ????????? ????????? ?????? ?????????????????? ????????????????????? ????????? ???????????? ?????????????????? ??????????????? ?????? ????????? ???????????? ???????????????????????? ?????????????????? ??????????????? ?????????????????????????????????\n" +
                "???????????????????????? ????????????????????? ??????????????? ???????????????????????? ??????????????? ????????? ?????????????????? ?????????????????? ?????? ?????????????????? ?????????????????? ??????????????? ????????? ????????? ????????? ??????????????????????????? ????????????????????? ?????????????????? ?????? ???????????????????????? ??????????????? ????????????????????????????????? ???????????? ??????????????? ????????? ?????? ?????????????????? ????????????????????? ??????????????? ?????????????????? ???????????? ?????????????????? ?????????????????? ???????????????????????? ???????????????????????????????????? ???????????????\n" +
                "??? ??????????????? ???????????????????????? ???????????? ??????????????? ????????? ??? ???????????? ??????????????? ?????????????????? ????????????????????? ??????????????? ??????????????? ?????? ????????????????????????????????? ??????????????? ????????? ???????????????????????????????????? ????????????????????? ?????????????????? ?????????????????? ??????????????? ?????????????????? ???????????? ???????????? ??????????????? ???????????????????????? ?????????????????? ????????? ???????????? ??????????????? ???????????????????????? ???????????? ??????????????????????????? ??????????????????\n" +
                "\n" +
                "???????????????????????? ???????????? ?????? ???????????????????????????????????? ???????????? ?????????????????? ?????? ???????????? ??????????????? ????????? ??????????????? ?????????????????? ????????? ????????????????????? ????????? ????????? ??????????????? ????????? ?????? ????????????????????? ?????????????????????????????????????????? ??????????????? ?????????????????? ???????????????, ????????? ?????????????????? ????????? ???????????? ????????? ???????????? ????????? ?????????????????? ?????????????????? ????????? ??????????????????\n" +
                "\n");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("cat", "GAME");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2021/05/%E0%A6%AB%E0%A7%8D%E0%A6%B0%E0%A6%BF-%E0%A6%AB%E0%A6%BE%E0%A7%9F%E0%A6%BE%E0%A6%B0-%E0%A6%93-%E0%A6%AA%E0%A6%BE%E0%A6%AC%E0%A6%9C%E0%A6%BF.jpg");
        hashMap.put("title", "?????????????????? ???????????? ?????? ?????? ???????????????");
        hashMap.put("des", "?????????????????? ????????????????????? ???????????? ????????? ????????????????????? ????????? ??????????????????????????? ??????????????? ???????????????????????????????????? ????????? ????????????????????? ????????? ??????????????? ???????????? ?????????????????? ????????????????????? ???????????? ??????????????????????????? ?????????????????????????????? ???????????? ???????????? ????????? ?????????????????? ???????????? ??????????????? ???????????? ?????????????????? ????????? ??????????????? ????????? ????????? ????????????????????? ????????????????????? ????????????????????????????????? ??????????????????????????? ???????????????????????? ???????????? ?????????????????? ??????????????????????????? ?????????????????? ?????????????????? ????????????????????? ???????????? ???????????? ???????????????????????? ??????????????? ??????????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ???????????? ??????????????? ???????????????, ????????? ???????????? ???????????? ????????? ????????? ?????????????????? ???????????? ???????????? ??????????????? ????????? ???????????? ???????????? ???????????? ????????????????????? ????????????????????? ??????????????? ??????, ?????????????????? ???????????? ????????? ???????????? ???????????? ??????? ??? ?????????, ??????????????????, ???????????? ??????????????? ???????????????, ????????? ??????????????? ?????????????????????\n" +
                "????????? ???????????????????????? ???????????? ????????? ?????????????????? ?????????????????? ????????????????????? ?????? ??????????????? ??????????????? ???????????????????????? ????????? ??????????????? ??????????????? ???????????????????????? ?????????????????????????????? ???????????? ?????????????????? ???????????????????????? ?????????????????? ?????????????????? ????????? ???????????????????????? ???????????? ????????????????????? ?????????????????? ????????? ????????? ???????????? ????????? ????????????????????? ?????????????????? ?????????????????? ????????????????????? ??????????????? ???????????? ?????????????????????????????? ????????????????????? ??????????????? ????????? ????????? ???????????????????????? ????????? ??????????????? ??????????????? ?????????????????????????????? ????????????????????? ?????????????????? ???????????? ????????? ???????????????????????? ??????????????? ??????????????? ?????? ???????????? ????????? ?????? ????????? ???????????? ????????? ????????? ?????????????????? ????????? ????????? ???????????? ???????????? ????????? ?????????????????????????????? ???????????? ????????????????????? ????????? ?????? ?????? ??????????????????????????????????????? ??????????????? ???????????? ????????? ????????? ?????????????????? ????????? ?????????????????????????????? ????????? ???????????????????????? ????????? ?????????????????? ??????????????????, ???????????? ???????????? ??????????????? ????????????????????? ????????????????????? ???????????? ??????????????? ?????????????????? ???????????????\n" +
                "\n");
        arrayList.add(hashMap);



    }



//============================================================

    //============================================================


}