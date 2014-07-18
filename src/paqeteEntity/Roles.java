package paqeteEntity;

// Generated 18/07/2014 08:32:55 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name = "roles", catalog = "episunsa_gradesTracker")
public class Roles implements java.io.Serializable {

	private Integer id;
	private String nombreRol;
	private String descripcion;
	private Set<RolesUsuarios> rolesUsuarioses = new HashSet<RolesUsuarios>(0);

	public Roles() {
	}

	public Roles(String nombreRol, String descripcion,
			Set<RolesUsuarios> rolesUsuarioses) {
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
		this.rolesUsuarioses = rolesUsuarioses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre_rol", length = 45)
	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Column(name = "descripcion", length = 45)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<RolesUsuarios> getRolesUsuarioses() {
		return this.rolesUsuarioses;
	}

	public void setRolesUsuarioses(Set<RolesUsuarios> rolesUsuarioses) {
		this.rolesUsuarioses = rolesUsuarioses;
	}

}
