package com.example.tabularview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        LinearLayout linearcontainer = view.findViewById(R.id.post_container);

        String[] Posts = getResources().getStringArray(R.array.posts);
        String[] Usernames = {"Fahad Abbas","Malik Muazzam","Saim","Ali Hamza","Dilshad Dilawar","Numman ali"};
        String[] Posttimes = {"2 hours ago","1 day ago","11 min ago","1 weak ago","13 hours ago","3 days ago"};
        String[] PostContent = {"love to Code","","Workhard beats tilent where tilent fails to hardwork","sample post content","sample post"};

        for(int i = 0;i<6;i++){
            View postView = inflater.inflate(R.layout.item_post,container,false);
            ImageView profilePic = postView.findViewById(R.id.profile_picture);
            TextView userName = postView.findViewById(R.id.post_user_name);
            TextView postTime = postView.findViewById(R.id.post_time);
            TextView postContent = postView.findViewById(R.id.post_content_text);
            ImageView postContentImage = postView.findViewById(R.id.post_content_image);
           // ImageView image1 = postView.findViewById(R.id.image1);

            TabLayout tabLayout = postView.findViewById(R.id.tablayout);
           TabLayout.Tab tab1 = tabLayout.newTab();
            TabLayout.Tab tab2 = tabLayout.newTab();
            TabLayout.Tab tab3 = tabLayout.newTab();
            TabLayout.Tab tab4 = tabLayout.newTab();

            tab4.setIcon(R.drawable.send);
            tab2.setIcon(R.drawable.comment);
            tab3.setIcon(R.drawable.refresh);
            tab1.setIcon(R.drawable.like);



           tabLayout.addTab(tab1);
            tabLayout.addTab(tab2);
            tabLayout.addTab(tab3);
            tabLayout.addTab(tab4);

            userName.setText(Usernames[i]);
           // postContent.setText(PostContent[i]);
            postContent.setText(Posts[i]);
            postTime.setText(Posttimes[i]);

            if(i%2 ==0){
                postContentImage.setVisibility(View.VISIBLE);

            }
            linearcontainer.addView(postView);

        }
        return view;
    }
}