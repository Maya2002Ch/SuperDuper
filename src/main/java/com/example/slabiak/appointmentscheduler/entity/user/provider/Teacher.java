package com.example.slabiak.appointmentscheduler.entity.user.provider;

import com.example.slabiak.appointmentscheduler.entity.user.Role;
import com.example.slabiak.appointmentscheduler.entity.user.User;
import com.example.slabiak.appointmentscheduler.entity.Appointment;
import com.example.slabiak.appointmentscheduler.entity.Work;
import com.example.slabiak.appointmentscheduler.entity.WorkingPlan;
import com.example.slabiak.appointmentscheduler.model.UserForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "id_provider")
public class Teacher extends User {

    @OneToMany(mappedBy = "teacher")
    private List<Appointment> appointments;

    @ManyToMany
    @JoinTable(name = "works_providers", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_work"))
    private List<Work> works;

    @OneToOne(mappedBy = "teacher", cascade = {CascadeType.ALL})
    private WorkingPlan workingPlan;

    public Teacher() {
    }

    public Teacher(UserForm userFormDTO, String encryptedPassword, Collection<Role> roles, WorkingPlan workingPlan) {
        super(userFormDTO, encryptedPassword, roles);
        this.workingPlan = workingPlan;
        workingPlan.setTeacher(this);
        this.works = userFormDTO.getWorks();
    }

    @Override
    public void update(UserForm updateData) {
        super.update(updateData);
        this.works = updateData.getWorks();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public WorkingPlan getWorkingPlan() {
        return workingPlan;
    }

    public void setWorkingPlan(WorkingPlan workingPlan) {
        this.workingPlan = workingPlan;
    }

    public List<Work> getCorporateWorks() {
        List<Work> corporateWorks = new ArrayList<>();
        for (Work w : works) {
            if (w.getTargetCustomer().equals("corporate")) {
                corporateWorks.add(w);
            }
        }
        return corporateWorks;
    }

    public List<Work> getRetailWorks() {
        List<Work> retailWorks = new ArrayList<>();
        for (Work w : works) {
            if (w.getTargetCustomer().equals("retail")) {
                retailWorks.add(w);
            }
        }
        return retailWorks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return teacher.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointments, works, workingPlan);
    }

}
