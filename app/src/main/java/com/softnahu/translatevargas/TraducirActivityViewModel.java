package com.softnahu.translatevargas;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class TraducirActivityViewModel extends AndroidViewModel {
    private ArrayList<Palabra>listado;
    private MutableLiveData<String> mutablePalabra;
    private MutableLiveData<Integer> mutableRuta;
    public TraducirActivityViewModel(@NonNull Application application) {
        super(application);
        listado = new ArrayList<>();
        listado.add(new Palabra("casa","house",R.drawable.hermosacasa));
        listado.add(new Palabra("oso","bear",R.drawable.oso));
    }
    public LiveData<String>getMutablePalabra(){
        if(mutablePalabra==null){
            mutablePalabra = new MutableLiveData<>();
        }
        return mutablePalabra;
}
    public LiveData<Integer>getMutableRuta(){
        if(mutableRuta==null){
            mutableRuta=new MutableLiveData<>();
        }
        return mutableRuta;
    }
    public void traducir(Intent intent){
        String palabra = intent.getStringExtra("palabra");
        Intent intent = new Intent(getApplication().getApplicationContext(),TraducidoActivity.class);
        intent.putExtra("palabra", palabra);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }
}