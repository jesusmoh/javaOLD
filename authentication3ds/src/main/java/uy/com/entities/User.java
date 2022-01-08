package uy.com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "user_3ds")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="createat")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createAt;
    
    @Column(name="updateat")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateAt;
    
    @PrePersist
    public void prePersist(){
      this.createAt = new Date();
      this.updateAt = new Date();
    }
    
    @PreUpdate
    public void preUpdate(){
      this.updateAt = new Date();
    }

}
