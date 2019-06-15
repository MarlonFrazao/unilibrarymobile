package unifacear.edu.br.unilibrary_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Permissao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void listarLivro(View v) {
        Intent intent = new Intent(this, ListActivityLivro.class);

        startActivity(intent);

    }
}
