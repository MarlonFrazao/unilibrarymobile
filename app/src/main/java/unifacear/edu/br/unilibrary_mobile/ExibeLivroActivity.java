package unifacear.edu.br.unilibrary_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Livro;
import unifacear.edu.br.unilibrary_mobile.Model.Service.ExibeLivroService;
import unifacear.edu.br.unilibrary_mobile.Model.Service.LivroListService;

public class ExibeLivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exibe_livro);

        LinearLayout ll = findViewById(R.id.exibeLivro);

        long idSelected = getIntent().getLongExtra("ID", 0);

        // Então aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        ExibeLivroService s = new ExibeLivroService(getApplicationContext());
        s.setId((int)idSelected);
        s.setActivity(this);
        s.execute();

    }



    public void exibir(List<Livro> livros) {
        TextView id = findViewById(R.id.id);
        TextView titulo = findViewById(R.id.titulo);
        TextView descricao = findViewById(R.id.descricao);

        id.setText(livros.get(0).getId());
        titulo.setText(livros.get(0).getTitulo());
        descricao.setText(livros.get(0).getDescricao());
    }
}
