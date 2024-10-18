package ao.co.isptec.aplm.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
/*
public class MyPhoneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == TelephonyManager.ACTION_PHONE_STATE_CHANGED){
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.i("BroadcastReceiver", "State: " + state + ", Number: " + number);
        }

    }
}*/

// com a 4.

public class MyPhoneReceiver extends BroadcastReceiver {

    private static final String TAG = "TAG_MyPhoneReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Verifica se a intenção é relacionada ao estado do telefone
        if (TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(intent.getAction())) {
            // Obtém o estado da chamada (por exemplo, IDLE, RINGING, OFFHOOK)
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            // Obtém o número de telefone da chamada recebida (caso seja uma chamada de entrada)
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            // Registra o estado e o número da chamada (se disponível) no Logcat
            if (state != null) {
                Log.i("PhoneReceiver", "Estado da chamada: " + state);

                if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                    Log.i("ifPhoneReceiver", "Número da chamada recebida: " + incomingNumber);
                }
            }
        }
    }
}