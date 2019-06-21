package unifacear.edu.br.unilibrary_mobile.Model.Service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import unifacear.edu.br.unilibrary_mobile.MainActivity;
import unifacear.edu.br.unilibrary_mobile.Model.Entity.Login;
import unifacear.edu.br.unilibrary_mobile.Model.Entity.Usuario;

public class LoginService extends AsyncTask<Login,String,String> {
    private String urlString = "https://unilibrary.000webhostapp.com/usuario/login";


    private MainActivity activity;
    private ProgressDialog dialog;
    private Context context;

    public LoginService(Context context) {
        this.context = context;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }



   /* @Override
    protected void onPreExecute() {
        //7 Executa o loading
        dialog = new ProgressDialog(context);
        dialog.setTitle("Por favor aguarde");
        dialog.setMessage("Carregando...");
        dialog.show();
    }*/

    // para de executar aqui
    @Override
    protected String doInBackground(Login... logins) {

        Log.d("teste", "entrou no doInBack");
        if(android.os.Debug.isDebuggerConnected())
            android.os.Debug.waitForDebugger();
        JSONObject json = new JSONObject();

        try{
            //8 seta os parametros no json
            json.put("usuario", logins[0].getUsuario());
            json.put("senha", logins[0].getSenha());

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);


            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json.toString());

            connection.connect();

            connection.getOutputStream();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();

            String result;

            while((result = br.readLine()) != null){
                sb.append(result + "\n");
            }

            br.close();
            return sb.toString();

        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        //9 verifica o resultado
        if(result == null) {
            result = "false";
        }
        if(!result.equalsIgnoreCase("false")) {
            // 10 se verdadeiro monta o usuario
            try {
                JSONArray jsonArray = new JSONArray(result);
                List<Usuario> usuarios = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);

                    Usuario usuario = new Usuario();
                    usuario.setId(object.getInt("id"));
                    usuario.setUsuario(object.getInt("usuario"));
                    usuario.setPermissao(object.getInt("permissao"));
                    usuario.setStatus(object.getBoolean("status"));

                    usuarios.add(usuario);


                    //dialog.dismiss();
                }
                // 11 passa true para o metodo login
                activity.login(true);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("teste", e.getMessage());
            }

        } else {
            // 12 se falso passa false no metodo login
            activity.login(false);
           // dialog.dismiss();
        }
    }
}
