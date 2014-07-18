package paqeteEntity;

// Generated 18/07/2014 08:32:55 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RolesUsuarios generated by hbm2java
 */
@Entity
@Table(name = "roles_usuarios", catalog = "episunsa_gradesTracker")
public class RolesUsuarios implements java.io.Serializable {

	private RolesUsuariosId id;
	private Usuarios usuarios;
	private Roles roles;

	public RolesUsuarios() {
	}

	public RolesUsuarios(RolesUsuariosId id, Usuarios usuarios, Roles roles) {
		this.id = id;
		this.usuarios = usuarios;
		this.roles = roles;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "usuarioId", column = @Column(name = "usuario_id", nullable = false)),
			@AttributeOverride(name = "rolId", column = @Column(name = "rol_id", nullable = false)) })
	public RolesUsuariosId getId() {
		return this.id;
	}

	public void setId(RolesUsuariosId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", nullable = false, insertable = false, updatable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}
