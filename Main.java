

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.net.InetAddress;

public class Main{

    static String json = "pacientes.json";
    public static void main(String[] args) throws Exception{


        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());

        String direccion=InetAddress.getLocalHost().getHostAddress().toString();
        try {
            MyServerSocket server = new MyServerSocket(direccion,20000);
            server.start();
            System.out.println("Entro a server");
            MyClientSocket cliente = new MyClientSocket("10.6.40.145",20000);
            cliente.start();
            System.out.println("Entro a cliente");



        }

        catch(Exception e){
             System.out.println("Entro a Exception");


        }
        /*JSONParser parser = new JSONParser();
        try {



            JSONObject obj = new JSONObject (json);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        JSONObject obj = new JSONObject("pacientes.json");
		//String pageName = obj.getJSONObject("pageInfo").getString("pageName");
		JSONArray arr = obj.getJSONArray("paciente_id");
		System.out.println("Holi");
		
		for (int i = 0; i < arr.length(); i++)
		{
		    String post_id = arr.getJSONObject(i).getString("post_id");
		}
		*/
    }
}



