package unifacear.edu.br.unilibrary_mobile.Model.Service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import unifacear.edu.br.unilibrary_mobile.ExibeLivroActivity;
import unifacear.edu.br.unilibrary_mobile.ListActivityLivro;
import unifacear.edu.br.unilibrary_mobile.Model.Entity.Livro;

public class LivroListService  extends AsyncTask<String,String,String> {

    private String urlString = "https://unilibrary.000webhostapp.com/livro/listar/23";
    private static List<Livro> lista;

    private ListActivityLivro activityLivro;
    private ExibeLivroActivity activityExibeLivro;
    private ProgressDialog dialog;
    private Context context;

    public LivroListService(Context context) {
        this.context = context;
    }
    public void setActivity(ListActivityLivro activity) {
        this.activityLivro = activity;
    }

    public void setActivity(ExibeLivroActivity activity) {
        this.activityExibeLivro = activity;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setTitle("Por favor aguarde");
        dialog.setMessage("Carregando...");
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {

        JSONObject json = new JSONObject();

        try{


            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");
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
        try{
            JSONArray jsonArray = new JSONArray(result);
            List<Livro> livros = new ArrayList<>();

            for(int i = 0 ; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                Livro livro = new Livro();
                livro.setId(object.getInt("id"));
                livro.setTitulo(object.getString("titulo"));
                livro.setDescricao(object.getString("descricao"));

                livros.add(livro);

                dialog.dismiss();
            }

            activityLivro.listar(livros);
            lista = livros;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Livro> getLista(){
        return this.lista;
    }
}
