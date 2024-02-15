package com.example.acessibilidade_audio;
import android.R;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Wallace Felipe

public class MainActivity extends AppCompatActivity {


    private Audio audioHelper;
    private Texto ttsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list_item);
        TextView textView = findViewById(R.id.text2);
        Button btnBluetoothSettings = findViewById(R.id.button1);
        Intent serviceIntent = new Intent(this, Notificacao.class);
        startService(serviceIntent);

        audioHelper = new Audio(this);
        ttsManager = new Texto(this);
        if (audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP)) {
            textView.setText("Conectado, monitorando as notificações");
            btnBluetoothSettings.setVisibility(View.GONE);
            ttsManager.speak("Conectado, estamos monitorando as notificações");

        } else {
            textView.setText("Nenhum Bluetooth conectado");
            btnBluetoothSettings.setVisibility(View.VISIBLE);
            btnBluetoothSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioHelper.showBluetoothSettings();
                }
            });
        }
        ttsManager.speak("Não há dispositivos de áudio Bluetooth conectados. Para conectar, pressione o botão no centro da tela.");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutdown();
    }
}