package unifacear.edu.br.unilibrary_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Permissao;
import unifacear.edu.br.unilibrary_mobile.Model.Service.PermissaoService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText campo = findViewById(R.id.editText);
        Button botao = findViewById(R.id.button);
    }

    public void click(View v) {
        Button botao = (Button) v;
        new PermissaoService().inserir(new Permissao(0, findViewById(R.id.editText).toString()));

    }

    public void listarLivro(View v) {
        Intent intent = new Intent(this, ListActivityLivro.class);

        startActivity(intent);

    }
}
