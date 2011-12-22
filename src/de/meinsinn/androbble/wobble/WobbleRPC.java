package de.meinsinn.androbble.wobble;

import org.alexd.jsonrpc.JSONRPCClient;

public class WobbleRPC {

	public static final String USER_LOGIN = "user_login";
	
	private static JSONRPCClient instance;

	public static JSONRPCClient getInstance() {
		if(instance == null){
			//instance = JSONRPCClient.create("http://localhost:8888/api/endpoint.php");
			instance = JSONRPCClient.create("http://ec2-46-51-143-163.eu-west-1.compute.amazonaws.com/wobble/api/endpoint.php");
		}
		return instance;
	}

}
