

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;  

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.net.InetAddress;
import java.util.List; 
import java.util.Arrays;
import java.util.ArrayList;

public class Main{
   
    static String[] ips = { "10.6.40.145", "10.6.40.146", "10.6.40.147", "10.6.40.148"};
    static String json1 = "doctor.json";
    




    public static void main(String[] args) throws Exception{
        //listas con los trabajadores locales
        List<Doctor> doctoreslocales = new ArrayList<Doctor>();
        List<Enfermero> enfermeroslocales = new ArrayList<Enfermero>();
        List<Paramedico> paramedicoslocales = new ArrayList<Paramedico>();

        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());

        String direccion=InetAddress.getLocalHost().getHostAddress().toString();
        System.out.println(direccion);


        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(json1));
        JSONObject jsonObject =  (JSONObject) obj;
        JSONArray doctor= (JSONArray) jsonObject.get("Doctor");
        JSONArray enfermero= (JSONArray) jsonObject.get("enfermero");
        JSONArray paramedico= (JSONArray) jsonObject.get("Paramedico");

        for(int i=0; i<doctor.size(); i++){
            JSONObject rec =(JSONObject) doctor.get(i);
            String nombre=rec.get("nombre").toString();
            String apellido=rec.get("apellido").toString();
            int id=(int) (long) rec.get("id");
            int estudios=(int) (long) rec.get("estudios");
            int experiencia=(int) (long) rec.get("experiencia");
            Doctor doctorsito = new Doctor(nombre,apellido,id,estudios,experiencia);
            doctoreslocales.add(doctorsito);
            System.out.println(doctoreslocales.get(i).getNombre());
        }

        for(int i=0; i<enfermero.size(); i++){
            JSONObject rec =(JSONObject) enfermero.get(i);
            String nombre=rec.get("nombre").toString();
            String apellido=rec.get("apellido").toString();
            int id=(int) (long) rec.get("id");
            int estudios=(int) (long) rec.get("estudios");
            int experiencia=(int) (long) rec.get("experiencia");
            Enfermero enfermesito = new Enfermero(nombre,apellido,id,estudios,experiencia);
            enfermeroslocales.add(enfermesito);
            System.out.println(enfermeroslocales.get(i).getNombre());
        }


        for(int i=0; i<paramedico.size(); i++){
            JSONObject rec =(JSONObject) paramedico.get(i);
            String nombre=rec.get("nombre").toString();
            String apellido=rec.get("apellido").toString();
            int id=(int) (long) rec.get("id");
            int estudios=(int) (long) rec.get("estudios");
            int experiencia=(int) (long) rec.get("experiencia");
            Paramedico paramedisito = new Paramedico(nombre,apellido,id,estudios,experiencia);
            paramedicoslocales.add(paramedisito);
            System.out.println(paramedicoslocales.get(i).getNombre());
        }










        try {
            MyServerSocket server = new MyServerSocket(direccion,20000);
            server.start();
            System.out.println("Entro a server");
            MyClientSocket cliente = new MyClientSocket("10.6.40.146",20000);
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



