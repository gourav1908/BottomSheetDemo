package com.example.gourav.bottomsheetdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn_bottom_sheet;
    NestedScrollView layout_bottom_sheet;
    ImageView img_vector_menu;

    BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bottom_sheet = findViewById(R.id.btn_bottom_sheet);
        layout_bottom_sheet = findViewById(R.id.bottom_sheet);
        img_vector_menu= findViewById(R.id.img_vector_menu);

        img_vector_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();
            }
        });

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        sheetBehavior = BottomSheetBehavior.from(layout_bottom_sheet);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                        case BottomSheetBehavior.STATE_HIDDEN:
                            break;
                        case BottomSheetBehavior.STATE_EXPANDED:
                            btn_bottom_sheet.setText("Close Sheet");
                            break;
                        case BottomSheetBehavior.STATE_COLLAPSED:
                            btn_bottom_sheet.setText("Expand Sheet");
                            break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                        case BottomSheetBehavior.STATE_SETTLING:
                            break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        btn_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();
            }
        });

    }

    private void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            btn_bottom_sheet.setText("Close Sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            btn_bottom_sheet.setText("Expand Sheet");
        }
    }
}
