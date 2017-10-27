package qichenzhao.floatingactionbuttondemo;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_phone,fab_twitter,fab_fb;
    Animation FabOpen,FabClose,FabClockwise,FabAnticlockwise;
    boolean isOpen = false;
    String phone = "111-111-1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_phone = (FloatingActionButton)findViewById(R.id.floatingActionPhone);
        fab_twitter = (FloatingActionButton)findViewById(R.id.floatingActionTwitter);
        fab_fb = (FloatingActionButton)findViewById(R.id.floatingActionFb);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabAnticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        final FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.floatingActionStar);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isOpen)
                {
                    fab_fb.startAnimation(FabClose);
                    fab_twitter.startAnimation(FabClose);
                    fab_phone.startAnimation(FabClose);
                    mFab.startAnimation(FabAnticlockwise);
                    fab_phone.setClickable(false);
                    fab_twitter.setClickable(false);
                    fab_fb.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    fab_fb.startAnimation(FabOpen);
                    fab_twitter.startAnimation(FabOpen);
                    fab_phone.startAnimation(FabOpen);
                    mFab.startAnimation(FabClockwise);
                    fab_phone.setClickable(true);
                    fab_twitter.setClickable(true);
                    fab_fb.setClickable(true);
                    isOpen = true;
                }
            }
        });
        fab_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel://" + phone)));
            }
        });
        fab_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.facebook.com/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        fab_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.twitter.com/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
