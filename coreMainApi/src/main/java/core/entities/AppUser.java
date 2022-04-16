package core.entities;

import core.commons.AppUserRoles;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

@Entity
@Data 
@Table(name = "app_user")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 4, max = 20)
    @Column(name = "username",unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, max = 224)
    @Column(nullable = false)
    private String password;
    
    @Column(name="roles")
    private String roles;

    @Size(min = 4, max = 100)
    @Column(name = "firstname")
    private String firstname;
     
    @Size(min = 4, max = 100)
    @Column(name = "lastname")
    private String lastname;
    
    @Size(min = 4, max = 100)
    @Column(name = "phone")
    private String phone;

    @Column(name = "createat")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createAt;

    @Column(name = "updateat")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateAt;

    @Column(name = "status")
    private int status;
    
    @Column(name = "pin")
    @Size(min = 6, max = 6)
    private String pin;
    
    @Column(name = "fingerprintdevice")
    @Size(min = 10, max = 100)
    private String fingerprintdevice;
    
    @Column(name = "profiledevice")
    @Size(min = 50, max = 500)
    private String profiledevice;
    
    

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.updateAt = new Date();
        status = 0;
        roles= AppUserRoles.ROLE_CLIENT;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = new Date();
    }

}
