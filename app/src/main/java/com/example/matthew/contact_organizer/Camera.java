package com.example.matthew.contact_organizer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Matthew on 1/11/2016.
 */
public class Camera extends Activity implements View.OnClickListener{

    ImageButton takePic_ib;
    Button setWallpaper_b;
    ImageView pic_iv;
    final static int cameraData = 0;
    Intent iCam;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
        //getResources lets you get a resource from
        //the resource folder
        InputStream is = getResources().openRawResource(R.drawable.splash_screen);
        bmp = BitmapFactory.decodeStream(is);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.bSetWallpaper:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.ibTakePic:
                iCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCam, cameraData);
                break;
        }
    }

    @Override
    /*
    * Method to get the result from the ACTION_IMAGE_CAMERA
    * */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            //when the camera activity closes it will "putExtras"
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data"); //data is a key reference
            pic_iv.setImageBitmap(bmp);
        }
    }

    private void initialize() {
        takePic_ib = (ImageButton) findViewById(R.id.ibTakePic);
        setWallpaper_b = (Button) findViewById(R.id.bSetWallpaper);
        pic_iv = (ImageView) findViewById(R.id.ivPic);
        setWallpaper_b.setOnClickListener(this);
        takePic_ib.setOnClickListener(this);
    }
}
