
package DAM_2.psp.UT5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Este programa de ejemplo interactua con dos archivos PHP enviando unos parametros y reciviendo respuesta del servidor HTML.
 * los archivos se encuentran en:
 * 	C:\wamp64\www\psp\actionPOST.php
 *	C:\wamp64\www\psp\actionGET.php
 * 
 * Tiene que estar ejecutandose un servidor Apache.
 * 
 * Una vez enviada las peticiones, si la repuesta del servidor es ok(200), se imprime por consola lo que envia el servidor.
 * 
 * @author alumno
 */
public class URLConnectionPOSTGET {

   private static final String USER_AGENT = "Mozilla/5.0";
        /*CAMBIA ESTA URL*/
	private static final String GET_URL = "http://localhost/psp/actionGET.php?userName=David";
        /*CAMBIA ESTA URL*/
	private static final String POST_URL = "http://localhost/psp/actionPOST.php";

	private static final String POST_PARAMS = "userName=David Jimenez&password=1234";

	public static void main(String[] args) {

            try {
                sendGET();
                System.out.println("Enviado GET");
                sendPOST();
                System.out.println("Enviado POST");
            } catch (IOException ex) {
                Logger.getLogger(URLConnectionPOSTGET.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine + "\n");
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

	private static void sendPOST() throws IOException {
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine + "\n");
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}
}
