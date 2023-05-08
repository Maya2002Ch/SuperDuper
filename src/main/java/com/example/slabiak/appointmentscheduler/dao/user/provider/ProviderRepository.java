package com.example.slabiak.appointmentscheduler.dao.user.provider;

import com.example.slabiak.appointmentscheduler.dao.user.CommonUserRepository;
import com.example.slabiak.appointmentscheduler.entity.user.provider.Teacher;
import com.example.slabiak.appointmentscheduler.entity.Work;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProviderRepository extends CommonUserRepository<Teacher> {

    List<Teacher> findByWorks(Work work);

    @Query("select distinct p from Teacher p inner join p.works w where w.targetCustomer = 'retail'")
    List<Teacher> findAllWithRetailWorks();

    @Query("select distinct p from Teacher p inner join p.works w where w.targetCustomer = 'corporate'")
    List<Teacher> findAllWithCorporateWorks();
}
