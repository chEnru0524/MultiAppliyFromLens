package com.example.user.multiappliyfromlens.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.R;

import java.io.File;
import java.io.FileNotFoundException;

public class CameraFragment extends BaseFragment
{

    private static final int Image_Capture_Code = 1;
    private View viewFragmentView = null;
    private Button btnTakePhoto = null;
    private Button btnTakePhotoConfirm = null;
    private ImageView imgPhoto = null;
    private String strSavePath = "";
    private File fileSaved = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewFragmentView = inflater.inflate(R.layout.camera_fragment, container, false);
        btnTakePhoto = viewFragmentView.findViewById(R.id.btnTakePhoto);
        btnTakePhotoConfirm = viewFragmentView.findViewById(R.id.btnTakePhotoConfirm);
        imgPhoto = viewFragmentView.findViewById(R.id.imgCamera);
        btnTakePhotoConfirm.setOnClickListener(CameraClickListener);
        btnTakePhoto.setOnClickListener(CameraClickListener);

        return viewFragmentView;
    }
    private void saveSetting()
    {
        strSavePath =Environment.getExternalStorageDirectory() + "/Photos";
        String fileName = System.currentTimeMillis() + ".jpg"; // 使用系統時間來對照片進行命名，保證唯一性
        fileSaved = new File(strSavePath, fileName); // 建立文件的保存路徑
        if(!fileSaved.exists())
        {
            fileSaved.mkdirs();
        }


    }
    private View.OnClickListener CameraClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnTakePhoto)
            {
                saveSetting();
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code);//start activity
            }
            else if(v.getId() == R.id.btnTakePhotoConfirm)
            {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rlMainContainer,new Poker_RecommandFragment());
                fragmentTransaction.commitNowAllowingStateLoss();
            }
        }
    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Capture_Code)
        {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imgPhoto.setImageBitmap(bp);
                //imgPhoto.setImageURI(Uri.fromFile(fileSaved));
            } else if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}
