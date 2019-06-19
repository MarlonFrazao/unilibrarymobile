package unifacear.edu.br.unilibrary_mobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Login;
import unifacear.edu.br.unilibrary_mobile.Model.Entity.Permissao;
import unifacear.edu.br.unilibrary_mobile.Model.Service.LoginService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void login(Boolean aceite) {
        //13 se login com sucesso, abre a proxima tela, senão exibe msg de erro
        if(aceite) {
            Intent intent = new Intent(this, ListActivityLivro.class);

            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuario ou senha incorretos", Toast.LENGTH_LONG).show();
        }
    }

    public void click(View v) {
        //2 metodo click
        Button btnEntrar = (Button) v;

        EditText usuario = findViewById(R.id.edtUsuario);
        EditText senha = findViewById(R.id.edtSenha);
        Login l = new Login();
        //3 pega o usuario e a senha da tela
        l.setUsuario(usuario.getText().toString());
        l.setSenha(senha.getText().toString());

        // 4 instancia a classe LoginService
        LoginService s = new LoginService(getApplicationContext());
        //5 seta a atividade
        s.setActivity(this);
        //6 executa a classe LoginService passando o login por parametro
        s.execute(l);
    }

    @Deprecated
    public void listarLivro(View v) {
        Intent intent = new Intent(this, ListActivityLivro.class);

        startActivity(intent);

    }
}
