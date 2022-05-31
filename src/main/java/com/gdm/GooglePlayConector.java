package com.gdm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class GooglePlayConector {

	
	 /* public static void main(String[] args) throws FileNotFoundException { 
		  FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json"); //Aca va el JSON QUE SE BAJA 
*/	  
		/*
		 * FirebaseOptions options = new
		 * FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(
		 * serviceAccount))
		 * .setDatabaseUrl("https://monitoreomascontrolvial.firebaseio.com") .build();
		 * 
		 * FirebaseApp.initializeApp(options);
		 * 
		 * } private static Credential authorize() throws Exception { // load client
		 * GoogleClientSecrets clientSecrets =GoogleClientSecrets.load(JSON_FACTORY, new
		 * InputStreamReader(CalendarSample.class.getResourceAsStream(
		 * "/client_secrets.json"))); // set up authorization code flow
		 * GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
		 * httpTransport, JSON_FACTORY,
		 * clientSecrets,Collections.singleton(CalendarScopes.CALENDAR)).
		 * setDataStoreFactory( dataStoreFactory) .build(); // authorize return new
		 * AuthorizationCodeInstalledApp(flow, new
		 * LocalServerReceiver()).authorize("user");
		 */
//	  }
	 
}
