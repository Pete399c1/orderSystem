package app.daos;

import app.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ProductDao {
    private EntityManagerFactory emf;

    public Product createProduct(Product product){
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }
        return product;
    }

    public Product findProductById(Integer id){
        try(EntityManager em = emf.createEntityManager()){
            return em.find(Product.class, id);
        }
    }


}
