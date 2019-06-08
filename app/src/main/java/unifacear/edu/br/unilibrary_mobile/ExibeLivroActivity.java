package unifacear.edu.br.unilibrary_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import unifacear.edu.br.unilibrary_mobile.Model.Entity.Livro;
import unifacear.edu.br.unilibrary_mobile.Model.Service.LivroListService;

public class ExibeLivroActivity extends AppCompatActivity {
    long idSelected;
    long positionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exibe_livro);

        LinearLayout ll = findViewById(R.id.exibeLivro);

        idSelected = getIntent().getLongExtra("ID", 0);
        positionSelected = getIntent().getIntExtra("POSITION", 0);

        // Então aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        LivroListService s = new LivroListService(ll.getContext());
        s.setActivity(this);
        s.execute();
    }



    public void exibir(List<Livro> livros) {
        for(Livro l : livros) {
            if(l.getId() == (int) idSelected){
                TextView titulo = findViewById(R.id.titulo);
                TextView autor = findViewById(R.id.autor);

                titulo.setText(l.getTitulo());
                autor.setText(l.getAutor().getNome());
                break;
            }
        }


       /* TextView titulo = findViewById(R.id.titulo);
        TextView autor = findViewById(R.id.autor);

        titulo.setText(livros.get((int) positionSelected).getTitulo());
        autor.setText(livros.get((int) positionSelected).getAutor().getNome());*/
    }
}
