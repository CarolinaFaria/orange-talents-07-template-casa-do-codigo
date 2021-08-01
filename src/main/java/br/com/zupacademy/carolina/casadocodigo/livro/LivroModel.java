package br.com.zupacademy.carolina.casadocodigo.livro;

import br.com.zupacademy.carolina.casadocodigo.autor.AutorModel;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaModel;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Livro")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @Lob
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;
    @Future
    @NotNull
    private LocalDate dataPublicacao;
    @ManyToOne
    private AutorModel autorModel;
    @ManyToOne
    private CategoriaModel categoriaModel;

    public LivroModel() {
    }

    public LivroModel(String titulo, String resumo, String sumario, BigDecimal preco,
                      Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                      @Valid AutorModel autor, @Valid CategoriaModel categoria) {


    }
}
