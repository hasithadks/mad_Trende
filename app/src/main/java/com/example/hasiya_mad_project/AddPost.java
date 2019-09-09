package com.example.hasiya_mad_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class AddPost extends AppCompatActivity {

    TextView mobile, title, price, des;
    Spinner plant, area;
    ImageView mainimage,img1,img2,img3,img4,img5;
    Button add;
  //  FirebaseDatabase database;
    DatabaseReference dbref;
    Post post;


    FirebaseStorage storage;
    StorageReference storageReference;

  //  FirebaseDatabase database2 = FirebaseDatabase.getInstance();
 //   DatabaseReference myRef = database2.getReference("Uploads");

//    public Uri imgurimain;
//    public Uri imguri01;
//    public Uri imguri02;
//    public Uri imguri03;
//    public Uri imguri04;
//    public Uri imguri05;


    private Uri filepath;
    private Uri filepath01;
    private Uri filepath02;
    private Uri filepath03;
    private Uri filepath04;
    private Uri filepath05;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_add_post);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        mobile = findViewById(R.id.mobiletxt);
        title = findViewById(R.id.titletxt);
        price = findViewById(R.id.price);
        des = findViewById(R.id.descripTxt);
        plant = findViewById(R.id.categorySpin);
        area = findViewById(R.id.locationSpin);
        mainimage = findViewById(R.id.mainImg);
        img1 = findViewById(R.id.otherpic02);
        img2 = findViewById(R.id.otherpic03);
        img3 = findViewById(R.id.otherpic04);
        img4 = findViewById(R.id.otherpic05);
        img5 = findViewById(R.id.otherpic06);
        add = findViewById(R.id.postbtn);

        post = new Post();

        mainimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileupload();
            }
        });


    }

    private String getExtention(Uri uri){

        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap =  MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));

    }

    public void fileupload(){

          //  database = FirebaseStorage.getInstance()
            dbref =FirebaseDatabase.getInstance().getReference().child("Post");
            try{
                if(TextUtils.isEmpty(mobile.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter a Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(title.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter a Title for Post", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(price.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter a Price for one product", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(des.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter a Description for Post", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(plant.getSelectedItem().toString())){
                    Toast.makeText(getApplicationContext(), "Please Select Category from list", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(area.getSelectedItem().toString())){
                    Toast.makeText(getApplicationContext(), "Please Select Location from list", Toast.LENGTH_SHORT).show();
                }
                else{
                    post.setPhoneno(Integer.parseInt(mobile.getText().toString().trim()));
                    post.setTitle(title.getText().toString().trim());
                    post.setPrrice(Double.parseDouble(price.getText().toString().trim()));
                    post.setDescription(des.getText().toString().trim());
                    post.setCategory(plant.getSelectedItem().toString().trim());
                    post.setLocation(area.getSelectedItem().toString().trim());
                   // post.setMainImageAdd(imgurimain);

                 //   post.setImage01Add(imguri01);
                  //  post.setImage02Add(imguri02);
                 //   post.setImage03Add(imguri03);
                  //  post.setImage04Add(imguri04);
                  //  post.setImage05Add(imguri05);

                    if(filepath != null)
                    {
                        final ProgressDialog progressDialog = new ProgressDialog(this);
                        progressDialog.setTitle("Uploading...");
                        progressDialog.show();

                        StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
                        ref.putFile(filepath)
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        progressDialog.dismiss();
                                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(getApplicationContext(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                        double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                                .getTotalByteCount());
                                        progressDialog.setMessage("Uploaded "+(int)progress+"%");
                                    }
                                });


                        StorageReference ref2 = storageReference.child("images/"+ UUID.randomUUID().toString());
                        ref.putFile(filepath01)
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        progressDialog.dismiss();
                                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(getApplicationContext(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                        double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                                .getTotalByteCount());
                                        progressDialog.setMessage("Uploaded "+(int)progress+"%");
                                    }
                                });

                    }


                    dbref.push().setValue(post);

                    Toast.makeText(getApplicationContext(), "Data Save Successfully", Toast.LENGTH_SHORT).show();

                }

            } catch (Exception e){
                Toast.makeText(getApplicationContext(),"Invaild Data",Toast.LENGTH_SHORT).show();
            }


    }


    public void imagechooser(){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data != null && data.getData() != null){


  //          imgurimain = data.getData()
//            mainimage.setImageURI(imgurimain);
//            imguri01 = data.getData();
//            img1.setImageURI(imguri01);
//            imguri02 = data.getData();
//            img2.setImageURI(imguri02);
//            imguri03 = data.getData();
//            img3.setImageURI(imguri03);
//            imguri04 = data.getData();
//            img4.setImageURI(imguri04);
//            imguri05 = data.getData();
//            img5.setImageURI(imguri05);


            filepath = data.getData();
            filepath01 = data.getData();
            filepath02 = data.getData();
            filepath03 = data.getData();
            filepath04 = data.getData();
            filepath05 = data.getData();

            Toast.makeText(getApplicationContext(),filepath.toString() + filepath01.toString() + filepath02.toString(),Toast.LENGTH_LONG).show();



            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                mainimage.setImageBitmap(bitmap);
                Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath01);
                img1.setImageBitmap(bitmap1);
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath02);
                img2.setImageBitmap(bitmap2);
                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath03);
                img3.setImageBitmap(bitmap3);
                Bitmap bitmap4 = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath04);
                img4.setImageBitmap(bitmap4);
                Bitmap bitmap5 = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath05);
                img5.setImageBitmap(bitmap5);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}
