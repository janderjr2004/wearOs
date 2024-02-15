package com.example.acessibilidade_audio;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.Locale;

//Wallace Tavares

public class Texto implements TextToSpeech.OnInitListener {
    private static final String TAG = "TTSManager";
    private TextToSpeech mTTS;
    private boolean isInitialized = false;
    public Texto(Context context) {
        mTTS = new TextToSpeech(context, this);
    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = mTTS.setLanguage(Locale.getDefault());
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(TAG, "Esta linguagem não é suportada");
            } else {
                isInitialized = true;
            }
        } else {
            Log.e(TAG, "Falha ao inicializar o TextToSpeech");
        }
    }
    public void speak(String text) {
        if (isInitialized) {
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
    public void shutdown() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
    }
}