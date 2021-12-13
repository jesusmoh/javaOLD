package core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.validator.NameCheck;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;

    @NotBlank(message = "{empName.notblank}")
    @NameCheck
    @Column(name="first_name")
    private String firstName;

    @Size(min = 3, max = 5, message = "{empId.maxsize}")
    @Column(name="last_name")
    private String lastName;

    @NotBlank(message = "{empId.notblank}")
    @Column(name="email_id")
    private String emailId;


}
