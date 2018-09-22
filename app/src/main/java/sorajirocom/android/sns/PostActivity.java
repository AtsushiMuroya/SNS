package sorajirocom.android.sns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference("message");

    EditText mUsernameText;
    EditText mPostText;
    Button mPostBotton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mUsernameText = (EditText)findViewById(R.id.username);
        mPostText = (EditText)findViewById(R.id.message);
        mPostBotton = (Button)findViewById(R.id.post);
    }
    @Override
    public void onClick(View v){
        int id = v.getId();

        switch(id){
            case R.id.post:
                String message = mPostText.getText().toString();
                String userName = mUsernameText.getText().toString();
                Post post = new Post(userName,message);
                refMsg.push().setValue(post);

                finish();
                break;
        }
    }
}
