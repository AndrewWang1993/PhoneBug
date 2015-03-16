package p.servertest;

import android.media.MediaRecorder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.UUID;

/**
 * Created by wangxm-wr on 2015/3/16 in Vanke.
 */
public class MyPhoneListener extends PhoneStateListener {
    static String TAG = "MyPhoneListener";
    private MediaRecorder mediaRecorder;

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        Log.v("STATE", "" + state);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                Log.v(TAG, "Idle");
                if (null != mediaRecorder) {
                    try {
                        mediaRecorder.stop();
                        mediaRecorder.reset();
                        Log.v(TAG, "Record Success");
                    } catch (Exception e) {

                    } finally {
                        mediaRecorder.release();
                    }
                }
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Log.v(TAG, "ringing");
                mediaRecorder = new MediaRecorder();
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                mediaRecorder.setOutputFile("mnt/sdcard/" + UUID.randomUUID().toString() + ".3gp");
                try {
                    mediaRecorder.prepare();
                } catch (Exception e) {

                }
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.v(TAG, "offHook");
                mediaRecorder.start();
                Log.v(TAG, "start recording");
                break;
            default:
                break;

        }
        super.onCallStateChanged(state, incomingNumber);

    }
}
