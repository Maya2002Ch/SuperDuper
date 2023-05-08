package com.example.slabiak.appointmentscheduler.entity.user.customer;

import com.example.slabiak.appointmentscheduler.entity.user.Role;
import com.example.slabiak.appointmentscheduler.model.UserForm;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "id_customer")
public class Student extends Customer {

    public Student() {
    }

    public Student(UserForm userFormDTO, String encryptedPassword, Collection<Role> roles) {
        super(userFormDTO, encryptedPassword, roles);
    }


}
