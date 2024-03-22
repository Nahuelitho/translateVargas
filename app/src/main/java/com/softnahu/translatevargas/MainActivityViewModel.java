package com.softnahu.translatevargas;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public void traducir(String palabra){
        Context context = getApplication().getApplicationContext();
        Intent intent = new Intent(context, SegundaActivity2.class);
        intent.putExtra("pablabra",palabra);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
