package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.polinema.intentexercise.model.UserModel;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullName;
    private TextView email;
    private TextView homepage;
    private TextView about;
    //ImageView imageProfile = new ImageView(this);
    private ImageView imageProfile;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullName = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        about = findViewById(R.id.label_about);
        imageProfile = findViewById(R.id.image_profile);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            UserModel userModel = extras.getParcelable(RegisterActivity.USER_KEY);
            fullName.setText(userModel.getFullName());
            email.setText(userModel.getEmail());
            homepage.setText(userModel.getHomepage());
            about.setText(userModel.getAbout());
            Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("profileImage"), 0, getIntent().getByteArrayExtra("profileImage").length);
            imageProfile.setImageBitmap(bmp);

        }
    }

    public void handleHomepage(View view) {
        String url = homepage.getText().toString();

        //cek http
        if (!url.startsWith("https://") && !url.startsWith("http://")){
            url = "http://" + url;
        }
        Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (openUrlIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openUrlIntent);
        }

    }
}
