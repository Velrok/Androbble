package de.meinsinn.androbble;

import org.alexd.jsonrpc.JSONRPCClient;
import org.alexd.jsonrpc.JSONRPCException;

import de.meinsinn.androbble.wobble.WobbleRPC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AndrobbleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        
        Button listMethodsButton = (Button) findViewById(R.id.list_methods_button);

        listMethodsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String result = "no result";
		        
		        try {
		        	JSONRPCClient rpc = WobbleRPC.getInstance();
		        	result = rpc.callString("system.listMethods");
				} catch (JSONRPCException e) {
					e.printStackTrace();
				}
		        TextView textView = (TextView) findViewById(R.id.console);
		        textView.setText(result);
			}
		});
        
    }
}