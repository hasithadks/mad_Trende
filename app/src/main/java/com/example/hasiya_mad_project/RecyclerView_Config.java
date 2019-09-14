package com.example.hasiya_mad_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {




        private Context mContext;
        private PostAdapter mPostAdapter;
        public void setConfig(RecyclerView recyclerView, Context context, List<Post> posts, List<String> keys){
            mContext = context;
            mPostAdapter = new PostAdapter(posts,keys);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mPostAdapter);
            
        }


        class PostItemView extends RecyclerView.ViewHolder {

            private TextView mCompany;
            private TextView mTitle;
            private TextView mPrice;

            private String key;

            public PostItemView(ViewGroup parent){
                super(LayoutInflater.from(mContext).
                inflate(R.layout.post_list_item, parent, false));

                mCompany = (TextView) itemView.findViewById(R.id.companytxt);
                mTitle = (TextView) itemView.findViewById(R.id.titletxt);
                mPrice = (TextView) itemView.findViewById(R.id.pricetxt);
            }

            public void bind(Post post, String key){
                mCompany.setText(post.getCompany());
                mTitle.setText(post.getCategory());
                mPrice.setText(post.getPrrice().toString());
                this.key = key;
            }

        }

        class PostAdapter extends RecyclerView.Adapter<PostItemView>{

            private List<Post> mPostList;
            private List<String> mKeys;

            public PostAdapter(List<Post> mPostList, List<String> mKeys) {
                this.mPostList = mPostList;
                this.mKeys = mKeys;
            }

            @NonNull
            @Override
            public PostItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new PostItemView(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull PostItemView holder, int position) {
                    holder.bind(mPostList.get(position),mKeys.get(position));
            }

            @Override
            public int getItemCount() {
                return mPostList.size();
            }
        }






}
