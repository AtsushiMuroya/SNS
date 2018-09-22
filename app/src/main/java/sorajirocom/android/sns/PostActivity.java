package sorajirocom.android.sns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference("message");

    EditText titleText;
    EditText contentText;
    Button postBotton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        titleText = (EditText)findViewById(R.id.username);
        contentText = (EditText)findViewById(R.id.message);
        postBotton = (Button)findViewById(R.id.post);

        postBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleText.getText().toString();
                String content = contentText.getText().toString();
                String key = refMsg.push().getKey();

                Post item = new Post(key,title, content, 0);

                refMsg.child(key).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();
                    }
                });
            }
        });
    }
//    @Override
//    public void onClick(View v){
//        int id = v.getId();
//
//        switch(id){
//            case R.id.post:
//                String message = mPostText.getText().toString();
//                String userName = mUsernameText.getText().toString();
//                Post post = new Post(title,content);
//                refMsg.push().setValue(post);
//
//                finish();
//                break;
//        }
//    }
}
