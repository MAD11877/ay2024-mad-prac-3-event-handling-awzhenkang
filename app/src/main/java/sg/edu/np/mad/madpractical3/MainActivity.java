package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnGroup1, btnGroup2;


    // Declare 'followed' as a member variable of the class
    private boolean followed = false;
    private boolean toast = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGroup1 = findViewById(R.id.btnMessage);
        btnGroup2 = findViewById(R.id.btnMessage);

        int randomNum = new Random().nextInt(999999);

        // Initialize a new User object
        User user = new User("MAD " + randomNum, "MAD Developer", 1, false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        Button btnMessage = findViewById(R.id.btnMessage);


        // Set the TextViews with the User's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        // Set the initial text for the button based on the initial value of 'followed'
        if (followed) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the value of 'followed'
                followed = !followed;

                String message = followed ? "Followed" : "Unfollowed";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                btnFollow.setText(followed ? "Unfollow" : "Follow");
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }
}
