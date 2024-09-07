package com.example.tabularview;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {
    private DatabaseReference postsDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout linearContainer = view.findViewById(R.id.post_container);

       /* postsDatabase = FirebaseDatabase.getInstance().getReference("posts");

        postsDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                linearContainer.removeAllViews();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String username = postSnapshot.child("userName").getValue(String.class);
                    String postTime = postSnapshot.child("postTime").getValue(String.class);
                    String postContent = postSnapshot.child("postContent").getValue(String.class);
                    String profilePicUrl = postSnapshot.child("profilePicture").getValue(String.class);


                    Post_Fragment_Item postFragment = new Post_Fragment_Item(username, postTime, postContent, R.drawable.profile);

                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.add(R.id.post_container, postFragment).commit();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: something goes ");
            }
        });
*/
        String[] usernames = {"Fahad Abbas", "Malik Muazzam", "Saim", "Ali Hamza", "Dilshad Dilawar", "Numman Ali"};
        String[] postTimes = {"2 hours ago", "1 day ago", "11 min ago", "1 week ago", "13 hours ago", "3 days ago"};
        String[] postContents = {"Love to Code", "Enjoying life", "Work hard beats talent", "Learning Android", "Sample post content", "Coding challenge"};
        int[] profilePics = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};

        for (int i = 0; i < usernames.length; i++) {
            Post_Fragment_Item postFragment = new Post_Fragment_Item(usernames[i], postTimes[i], postContents[i], profilePics[i]);

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.post_container, postFragment).commit();
        }

        return view;
    }
}
