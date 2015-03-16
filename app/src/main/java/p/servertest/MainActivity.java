package p.servertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends Activity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout rl = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rl.setLayoutParams(layoutParams);

        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button button, button1;
        button = new Button(this);
        button.setId(0);
        button.setText("Start Server");
        layoutParams.topMargin = 50;
        button.setLayoutParams(layoutParams);
        rl.addView(button);

        button1 = new Button(this);
        button1.setId(1);
        button1.setText("Stop Server");
        layoutParams1.topMargin = 200;
        button1.setLayoutParams(layoutParams1);
        rl.addView(button1);


        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        setContentView(rl);
        intent = new Intent(this, MyService.class);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 0:

                startService(intent);
                break;
            case 1:
                stopService(intent);
                break;
            default:
                Log.v("id", "null");

        }
    }
}
