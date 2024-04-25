package Principal;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//import

public class PrincipalConbusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        try {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Hola, elige el tipo de moneda al que deseas hacer la conversión:" +
                "\n(1) Peso Mexicano a Dolares" +
                "\n(2) Euros a Dolares" +
                "\n(3) Dolares Canadiense a Dolares" +
                "\n(4) Salir");

        var moneda = lectura.nextLine();

        String apiKey = "02f6f4f1407b2b2c2992c0d4";
        String urlMoneda = "https://v6.exchangerate-api.com/v6/02f6f4f1407b2b2c2992c0d4/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlMoneda))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        System.out.print(response.body());
        String strJson = response.body();

        Gson gson = new Gson();

        CatalogoMoneda obj = gson.fromJson(strJson, CatalogoMoneda.class);

        System.out.println(obj.getBase_code());
        System.out.println(obj.getAED());


        System.out.println(obj.getTime_last_update_utc());


        JsonObject jsonObject = gson.fromJson(strJson, JsonObject.class);
        String name = jsonObject.get("time_next_update_unix").getAsString();
        System.out.println(name);



            JsonObject jObj = new JsonObject(strJson);
            JsonObject dataResult = jObj.getJSONObject();
            JSONArray jArr = (JSONArray) dataResult.getJSONArray("conversion_rates");
            for(int i = 0; i < jArr.length();i++) {
                JSONObject innerObj = jArr.getJSONObject(i);
                for(Iterator it = innerObj.keys(); it.hasNext(); ) {
                    String key = (String)it.next();
                    System.out.println(key + ":" + innerObj.get(key));
                }
            }



            //System.out.println(jObj.get("ARS"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}