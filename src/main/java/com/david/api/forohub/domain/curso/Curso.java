package com.david.api.forohub.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Curso {
    @Column(name = "nombreCurso")
    private  String nombreCurso;
    @Column(name = "categoriaCurso")
    private  String categoriaCurso;

    public Curso(DatosCurso datos) {
        this.nombreCurso = datos.nombreCurso();
        this.categoriaCurso = datos.categoriaCurso();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }
}
