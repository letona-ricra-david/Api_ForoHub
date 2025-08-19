package com.david.api.forohub.domain.respuesta;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import com.david.api.forohub.domain.topico.Topico;
import com.david.api.forohub.domain.usuario.Usuario;
import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String mensaje;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "topico_id")
private Topico topico;
@Column(name = "fechaCreacion")
private LocalDateTime fechaCreacion;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "usuario_id")
private Usuario autor;
private  String solucion;
private Boolean state;

    public Respuesta(@NotBlank String mensaje, String solucion, Usuario usuario, Topico topico) {
        this.id = null;
        this.mensaje = mensaje;
        this.topico = topico;
        this.fechaCreacion = LocalDateTime.now();
        this.autor = usuario;
        this.solucion = solucion;
        this.state = true;
    }

    public void actualizarInformaciones( DatosActualizarRespuesta datos) {
        if(datos.mensaje() !=null){
            this.mensaje =datos.mensaje();
        }
        if(datos.solucion() != null){
            this.solucion= datos.solucion();
        }
    }

    public void eliminar(){
        this.state = false;
    }
}
