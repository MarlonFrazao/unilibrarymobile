package unifacear.edu.br.unilibrary_mobile.Model.Service;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Permissao;

public class PermissaoService extends AsyncTask<Permissao,String,String> {
    private URLBackEnd urlBackEnd;

    public PermissaoService() {
        urlBackEnd = new URLBackEnd();
    }

    @Override
    protected String doInBackground(Permissao... permissoes) {
        return null;
    }

    public void inserir(Permissao... permissoes) {
        //cria o json
        JSONObject json = new JSONObject();
        try {
            //insere os atributos
            json.put("permissao", permissoes[0].getDescricao());

            Log.i("Teste", "entrou inserir");

            URL url = new URL(urlBackEnd.getUlr() + "/permissao/inserir");
            //estabelece a conexao
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //cria o http
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true);

            //abre o stream da conexao
            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json.toString());

            //conecta
            connection.connect();

            //pega o retorno
            connection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
