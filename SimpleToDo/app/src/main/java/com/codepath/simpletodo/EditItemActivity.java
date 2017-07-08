package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        EditText etItemPosition = (EditText) findViewById(R.id.etItemPosition);
        String itemTextToEdit = this.getIntent().getStringExtra("itemTextToEdit");
        int itemToEditPosition = this.getIntent().getIntExtra("itemPosition",0);
        etItemPosition.setText(String.valueOf(itemToEditPosition));
        etEditItem.setText(itemTextToEdit);
    }

    public void onSaveItem(View v){
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        EditText etItemPosition = (EditText) findViewById(R.id.etItemPosition);
        Intent data = new Intent();
        data.putExtra("editedItemValue", etEditItem.getText().toString());
        data.putExtra("editedItemPosition", etItemPosition.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
