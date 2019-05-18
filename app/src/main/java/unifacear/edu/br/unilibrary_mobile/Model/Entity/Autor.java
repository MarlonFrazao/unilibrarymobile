package unifacear.edu.br.unilibrary_mobile.Model.Entity;

public class Autor {
    private Integer id;
    private String nome;
    private Integer quantEditais;

    public Autor() {}

    public Autor(Integer id, String nome, Integer quantEditais) {
        this.id = id;
        this.nome = nome;
        this.quantEditais = quantEditais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantEditais() {
        return quantEditais;
    }

    public void setQuantEditais(Integer quantEditais) {
        this.quantEditais = quantEditais;
    }
}
