package de.meinsinn.androbble;

import org.alexd.jsonrpc.JSONRPCClient;
import org.alexd.jsonrpc.JSONRPCException;

import android.app.Activity;
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
        
        Button listMethodsButton = (Button) findViewById(R.id.list_methods_button);

        listMethodsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String result = "no result";
		        
		        try {
		        	JSONRPCClient client = JSONRPCClient.create("http://192.168.1.146:8888/api/endpoint.php");
		        	result = client.callString("system.listMethods");
				} catch (JSONRPCException e) {
					e.printStackTrace();
				}
		        TextView textView = (TextView) findViewById(R.id.console);
		        textView.setText(result);
			}
		});
        
    }
}