package delivery.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipoculinaria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoculinaria() {
        return tipoculinaria;
    }

    public void setTipoculinaria(String tipoculinaria) {
        this.tipoculinaria = tipoculinaria;
    }
}