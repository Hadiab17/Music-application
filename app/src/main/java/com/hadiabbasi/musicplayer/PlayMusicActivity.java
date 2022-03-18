package com.hadiabbasi.musicplayer;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayMusicActivity extends AppCompatActivity {

    private Bundle bundle;
    private CircleImageView img;
    private ImageView get_app_img, forward_img;
    private TextView name,singer_name;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        //initViews
        initViews();
        //set data in activity
        setData();
        //set on back pressed
        forward_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        get_app_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(PlayMusicActivity.this);
                dialog.setContentView(R.layout.download_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
    }

    private void setData(){
        bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));
        singer_name.setText(bundle.getString("singer"));
        Picasso.get()
                .load(bundle.getString("image"))
                .into(img);
    }

    private void initViews() {
        forward_img = findViewById(R.id.forward_img);
        get_app_img = findViewById(R.id.get_app_img);
        img = findViewById(R.id.img);
        name = findViewById(R.id.name);
        singer_name = findViewById(R.id.singer_name);
    }
}