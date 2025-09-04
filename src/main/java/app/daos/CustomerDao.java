package app.daos;

import app.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CustomerDao  {
    private EntityManagerFactory emf;

    public Customer createCustomer(Customer customer) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        }
        return customer;
    }

    public Customer findCustomerById(Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            return em.find(Customer.class, id);
        }
    }


    public List<Customer> getAll() {
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
            return query.getResultList();
        }
    }
}
