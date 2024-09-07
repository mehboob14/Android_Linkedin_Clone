package com.example.tabularview;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;

public class Post_Fragment_Item extends Fragment {

    private String username;
    private String postTime;
    private String postContent;
    private int profilePicResId;


    public Post_Fragment_Item(String username, String postTime, String postContent, int profilePicResId) {
        this.username = username;
        this.postTime = postTime;
        this.postContent = postContent;
        this.profilePicResId = profilePicResId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post___item, container, false);


        ImageView profilePic = view.findViewById(R.id.profile_picture);
        TextView userName = view.findViewById(R.id.post_user_name);
        TextView postTimeText = view.findViewById(R.id.post_time);
        TextView postContentText = view.findViewById(R.id.post_content_text);
        ImageView postContentImage = view.findViewById(R.id.post_content_image);

        profilePic.setImageResource(profilePicResId);
        userName.setText(username);
        postTimeText.setText(postTime);
        postContentText.setText(postContent);


        if (!postContent.isEmpty()) {
            postContentImage.setVisibility(View.VISIBLE);
        } else {
            postContentImage.setVisibility(View.GONE);
        }

        TabLayout tabLayout = view.findViewById(R.id.tablayout);
        TabLayout.Tab tab1 = tabLayout.newTab().setIcon(R.drawable.like);
        TabLayout.Tab tab2 = tabLayout.newTab().setIcon(R.drawable.comment);
        TabLayout.Tab tab3 = tabLayout.newTab().setIcon(R.drawable.refresh);
        TabLayout.Tab tab4 = tabLayout.newTab().setIcon(R.drawable.send);
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);

        return view;
    }
}
