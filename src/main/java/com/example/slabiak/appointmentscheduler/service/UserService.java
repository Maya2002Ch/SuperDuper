package com.example.slabiak.appointmentscheduler.service;


import com.example.slabiak.appointmentscheduler.entity.Work;
import com.example.slabiak.appointmentscheduler.entity.user.Role;
import com.example.slabiak.appointmentscheduler.entity.user.User;
import com.example.slabiak.appointmentscheduler.entity.user.customer.CorporateCustomer;
import com.example.slabiak.appointmentscheduler.entity.user.customer.Customer;
import com.example.slabiak.appointmentscheduler.entity.user.customer.Student;
import com.example.slabiak.appointmentscheduler.entity.user.provider.Teacher;
import com.example.slabiak.appointmentscheduler.model.ChangePasswordForm;
import com.example.slabiak.appointmentscheduler.model.UserForm;

import java.util.Collection;
import java.util.List;

public interface UserService {
    /*
     * User
     * */
    boolean userExists(String userName);

    User getUserById(int userId);

    User getUserByUsername(String userName);

    List<User> getUsersByRoleName(String roleName);

    List<User> getAllUsers();

    void deleteUserById(int userId);

    void updateUserPassword(ChangePasswordForm passwordChangeForm);

    /*
     * Provider
     * */
    Teacher getProviderById(int providerId);

    List<Teacher> getProvidersWithRetailWorks();

    List<Teacher> getProvidersWithCorporateWorks();

    List<Teacher> getProvidersByWork(Work work);

    List<Teacher> getAllProviders();

    void saveNewProvider(UserForm userForm);

    void updateProviderProfile(UserForm updateData);

    Collection<Role> getRolesForProvider();

    /*
     * Customer
     * */
    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    /*
     * RetailCustomer
     * */
    Student getRetailCustomerById(int retailCustomerId);

    void saveNewRetailCustomer(UserForm userForm);

    void updateRetailCustomerProfile(UserForm updateData);

    Collection<Role> getRolesForRetailCustomer();

    /*
     * CorporateCustomer
     * */
    CorporateCustomer getCorporateCustomerById(int corporateCustomerId);

    List<Student> getAllRetailCustomers();

    void saveNewCorporateCustomer(UserForm userForm);

    void updateCorporateCustomerProfile(UserForm updateData);

    Collection<Role> getRoleForCorporateCustomers();


}

