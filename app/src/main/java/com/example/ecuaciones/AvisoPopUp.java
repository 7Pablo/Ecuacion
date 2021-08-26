package com.example.ecuaciones;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AvisoPopUp extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.noRoot)
                    .setPositiveButton("ok", (dialog, which) -> {} )
                    .create();
            return builder.create();
        }
        public static String TAG = "NoRootDialog";
}
