package unifacear.edu.br.unilibrary_mobile.Model.Entity;

public class Permissao {
    private Integer id;
    private String descricao;

    public Permissao() {}

    public Permissao(int id, String descricao) {
        super();
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
