package alex.proyectos.proyectoFinal.modelos;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")//Indicamos al ORM que tabla de la BBDD es
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Empresa {

    @Id
    private Integer idEmpresa;

    @Column
    private String nombre;

    @Column
    private String direccion1;

    @Column
    private String direccion2;

    @Column
    private Integer telefono1;

    @Column
    private Integer telefono2;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public Integer getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(Integer telefono1) {
        this.telefono1 = telefono1;
    }

    public Integer getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(Integer telefono2) {
        this.telefono2 = telefono2;
    }
}
