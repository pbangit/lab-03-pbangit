package com.example.listycitylab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditCityFragment extends DialogFragment {

    public interface EditCityDialogListener {
        void editCity(int position, City updatedCity);
    }

    private EditCityDialogListener listener;

    private City cityToEdit;
    private int position;

    public void setCityToEdit(City cityToEdit) {
        this.cityToEdit = cityToEdit;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof EditCityDialogListener) {
            listener = (EditCityDialogListener) context;
        } else {
            throw new RuntimeException(context + " must implement EditCityDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_add_city, null);

        EditText editCityName = view.findViewById(R.id.edit_text_city_text);
        EditText editProvinceName = view.findViewById(R.id.edit_text_province_text);

        if (cityToEdit != null) {
            editCityName.setText(cityToEdit.getName());
            editProvinceName.setText(cityToEdit.getProvince());
        }

        return new AlertDialog.Builder(getContext())
                .setTitle("Edit City")
                .setView(view)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Save", (dialog, which) -> {
                    String cityName = editCityName.getText().toString();
                    String province = editProvinceName.getText().toString();
                    listener.editCity(position, new City(cityName, province));
                })
                .create();
    }
}
