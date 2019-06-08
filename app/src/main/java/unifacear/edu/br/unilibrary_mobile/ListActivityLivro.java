package unifacear.edu.br.unilibrary_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Livro;
import unifacear.edu.br.unilibrary_mobile.Model.Service.LivroListService;

public class ListActivityLivro extends AppCompatActivity {

    private List<Livro> listLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_livro);

        ListView lv =findViewById(R.id.listaLivro);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ExibeLivroActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        LivroListService s = new LivroListService(lv.getContext());
        s.setActivity(this);
        s.execute();

    }

    public void listar(List<Livro> livros) {

        ArrayAdapter<Livro> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, livros);

        ListView lv = findViewById(R.id.listaLivro);

        lv.setAdapter(arrayAdapter);
    }

}
