package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class HomePage extends AppCompatActivity {

    private RecyclerView mRecycleView;
    // ListView mListView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
      //  mListView = findViewById(R.id.listview);
        mRecycleView = findViewById(R.id.listview);
        new FirebaseDatabaseHelper().readPost(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Post> posts, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecycleView, HomePage.this, posts,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });


      //  sellerAdptor sellerAdptorx = new sellerAdptor();
     //   mListView.setAdapter(sellerAdptorx);
    }



//
//        int[] images = {R.drawable.bonsaiimag02,
//                R.drawable.orchidvendar,
//                R.drawable.tg12,
//                R.drawable.tg13,
//                R.drawable.bonsaiimg01,
//                R.drawable.tg14};
//
//
//        String[] names = {"Bonsai Trees" , "Orchid Platns-Vendar", "Cactus Plants", "Cactus Plants", "Bonsai Trees", "Cactus Plants"};
//
//        String[] price = {"Rs. 7500.00" , "Rs. 2500.00", "Rs. 850.00", "Rs. 700", "Rs. 6750.00", "Rs. 1000.00"};
//
//    class sellerAdptor extends BaseAdapter {
//
//
//        @Override
//        public int getCount() {
//            return (images.length);
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//
//            View view1 = getLayoutInflater().inflate(R.layout.mainmenulayout, null);
//
//            ImageView mimageView = view1.findViewById(R.id.imageView);
//            TextView mTextView = view1.findViewById(R.id.textview);
//            TextView pTextView = view1.findViewById(R.id.textviewprice);
//
//            mimageView.setImageResource(images[i]);
//            mTextView.setText(names[i]);
//            pTextView.setText(price[i]);
//
//
//            return view1;
//        }
//    }
}
