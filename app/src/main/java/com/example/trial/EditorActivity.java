package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity {

    Button button;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;
    EditText title_post, content_post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving.....");

        button = findViewById(R.id.btn_post);
        title_post = findViewById(R.id.title_post);
        content_post = findViewById(R.id.content_post);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = title_post.getText().toString();
                String post = content_post.getText().toString();

                savePost(title, post);

            }
        });

    }

    public void savePost(final String title, final String post){

        progressDialog.show();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Notes>call = apiInterface.saveNote(title, post);

        call.enqueue(new Callback<Notes>() {
            @Override
            public void onResponse(Call<Notes> call, Response<Notes> response) {



            }

            @Override
            public void onFailure(Call<Notes> call, Throwable t) {



            }
        });

    }

}
