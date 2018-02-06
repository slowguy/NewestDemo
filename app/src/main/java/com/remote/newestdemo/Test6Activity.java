package com.remote.newestdemo;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Test6Activity extends AppCompatActivity {

    @Bind(R.id.action)
    TextView action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test6);
        ButterKnife.bind(this);
        ImageView i = new ImageView(this);

        i.setBackground(null);

    }

    public void showDialog() {
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        View dialogView = LayoutInflater.from(this)
                .inflate(R.layout.dialog_test, null);
        TextView tvTakePhoto = (TextView) dialogView.findViewById(R.id.tva);
        TextView tvPhotoAlbum = (TextView) dialogView.findViewById(R.id.tvb);
        TextView tvCancel = (TextView) dialogView.findViewById(R.id.tvc);

        tvTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Test6Activity.this, "拍照", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        tvPhotoAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Test6Activity.this, "拍照", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setContentView(dialogView);
        dialog.show();
    }

    @OnClick(R.id.action)
    public void onViewClicked() {
        showDialog();
    }
}
