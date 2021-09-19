package com.docsconsole.tutorials.client;

import com.docsconsole.tutorials.entity.Player;
import com.docsconsole.tutorials.entity.Product;
import com.docsconsole.tutorials.entity.ProductDetails;
import com.docsconsole.tutorials.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("main method @MainClient");

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {


            transaction = entityManager.getTransaction();
            transaction.begin();

            System.out.println("Using createNativeQuery method");
            String sql = "SELECT player.* FROM PLAYER AS player WHERE player.ID = ?";

            Query query = entityManager.createNativeQuery(sql, Player.class);
            query.setParameter(1, "1000010");
            Player player = (Player) query.getSingleResult();

            System.out.println(player.getFirstName());
            System.out.println(player.getLastName());

            System.out.println("Using NamedNativeQuery annotation");
            Query query1 = entityManager.createNamedQuery("Player-query", Player.class);
            query1.setParameter(1, 1000011);
            Player player1 = (Player) query1.getSingleResult();
            System.out.println(player1.getFirstName());
            System.out.println(player1.getLastName());

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
