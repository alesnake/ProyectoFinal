package alex.proyectos.proyectoFinal.modelos;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "alumno")//Indicamos al ORM que tabla de la BBDD es
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Alumno {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String pass;

    @Column
    private Integer admin;

    @Column
    private Integer idEmpresaAux;

    @Column
    private Integer idCicloAux;

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getIdEmpresaAux() {
        return idEmpresaAux;
    }

    public void setIdEmpresaAux(Integer idEmpresaAux) {
        this.idEmpresaAux = idEmpresaAux;
    }

    public Integer getIdCicloAux() {
        return idCicloAux;
    }

    public void setIdCicloAux(Integer idCicloAux) {
        this.idCicloAux = idCicloAux;
    }
}
