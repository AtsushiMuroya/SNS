package sorajirocom.android.sns;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostAdapter.OnLikeClickListener{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference("message");

    ListView listView;
    FloatingActionButton addButton;
    ArrayList<Post> items;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        addButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        items = new ArrayList<>();
        postAdapter = new PostAdapter(this,0,new ArrayList<Post>());
        postAdapter.setOnLikeClickListener(this);
        listView.setAdapter(postAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });
        refMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Post value = dataSnapshot.getValue(Post.class);

                items.add(value);
                postAdapter.clear();
                postAdapter.addAll(items);
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    @Override
    public void onLikeClick(int position){
        Toast.makeText(this,"いいねが押されたよ",Toast.LENGTH_SHORT).show();
    }
    public List<Post> getSampleData() {
        return Arrays.asList(
                new Post("title", "content", 3),
                new Post("title", "content", 3),
                new Post("title", "content", 3));
    }


}
