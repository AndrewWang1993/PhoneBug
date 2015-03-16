package p.servertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootingCompleteRecever extends BroadcastReceiver {
    public BootingCompleteRecever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }


    }
}
