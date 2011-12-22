package de.meinsinn.androbble;

import org.alexd.jsonrpc.JSONRPCClient;
import org.alexd.jsonrpc.JSONRPCException;
import org.json.JSONException;
import org.json.JSONObject;

import de.meinsinn.androbble.wobble.WobbleRPC;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		Button registerButton = (Button) findViewById(R.id.registerButton);
		Button loginButton = (Button) findViewById(R.id.loginButton);

		registerButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String email = getEmail();
				String password = getPassword();

			}
		});

		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String email = getEmail();
				String password = getPassword();

				JSONRPCClient rpc = WobbleRPC.getInstance();
				try {
					JSONObject request = new JSONObject();
					try {
						request.put("email", email);
						request.put("password", password);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Object result = rpc.call(WobbleRPC.USER_LOGIN,
							request );
					Log.d("Androbble", "login result using [" + email + ","
							+ password + "] => " + result);

				} catch (JSONRPCException e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected String getPassword() {
		return ((EditText) findViewById(R.id.email)).getText().toString();
	}

	protected String getEmail() {
		return ((EditText) findViewById(R.id.password)).getText().toString();
	}
}
