package com.example.trendy;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {
                }
                dialog.dismiss();
            }
        });
        Button btncontinue = (Button) dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

        Button btn_Back = (Button) findViewById(R.id.button_back);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }

        });
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6,

        };

        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        numLeft = random.nextInt(12);
        img_left.setImageResource(array.images1[numLeft]);


        numRight = random.nextInt(12);

        while (numLeft == numRight) {
            numRight = random.nextInt(12);
        }

        img_right.setImageResource(array.images1[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_right.setEnabled(false);
                    if (numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (numLeft > numRight) {
                        if (count < 6) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 6; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 1;
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 6) {
                    } else {
                        numLeft = random.nextInt(12);
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(a);


                        numRight = random.nextInt(12);

                        while (numLeft == numRight) {
                            numRight = random.nextInt(12);
                        }

                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(a);
                        img_right.setEnabled(true);
                    }
                }
                    return true;
                }
        });

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_left.setEnabled(false);
                    if (numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (numLeft < numRight) {
                        if (count < 6) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 6; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 1;
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 6) {
                    } else {
                        numLeft = random.nextInt(12);
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(a);


                        numRight = random.nextInt(12);

                        while (numLeft == numRight) {
                            numRight = random.nextInt(12);
                        }

                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(a);
                        img_left.setEnabled(true);
                    }
                }
                return true;
            }
        });

    }


    @Override
    public void onBackPressed() {
            try {
                Intent intent = new Intent(Level2.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
    }
}

