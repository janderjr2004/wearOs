package com.example.acessibilidade_audio;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

//Wallace Tavares

public class Notificacao extends NotificationListenerService {
    private static final String TAG = "Notificacao";
    private Texto ttsManager;
    @Override
    public void onCreate() {
        super.onCreate();
        ttsManager = new Texto(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutdown();
    }
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        String notificationText = sbn.getNotification().tickerText.toString();
        ttsManager.speak("Nova mensagem " + notificationText);
        Log.d(TAG, "Nova notificação: " + sbn.getPackageName());
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        Log.d(TAG, "Notificação removida: " + sbn.getPackageName());
    }
}