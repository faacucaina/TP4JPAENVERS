package org.example;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{


            entityManager.getTransaction().begin();


         /*  Cliente cliente = Cliente.builder()
                    .nombre("Pepe")
                    .apellido("Sancho")
                    .dni(41222313)
                    .build();

            Factura factura1 = Factura.builder()
                    .numero(12)
                    .fecha("10/08/2024")
                    .build();

            Domicilio dom = Domicilio.builder()
                    .nombreCalle("Talcahuano")
                    .numero(1222)
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacion("lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            Articulo art1 = Articulo.builder()
                    .cantidad(200)
                    .denominacion("Leche en Polvo")
                    .precio(20)
                    .build();

            Articulo art2 = Articulo.builder()
                    .cantidad(300)
                    .denominacion("Brilla Pisos")
                    .precio(15)
                    .build();

            cliente.setDomicilio(dom);
            factura1.setCliente(cliente);


            art1.getCategorias().add(lacteos);
            art2.getCategorias().add(limpieza);



            DetalleFactura det1 = DetalleFactura.builder().build();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);
            det1.setFactura(factura1);

            DetalleFactura det2 = DetalleFactura.builder().build();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);
            det2.setFactura(factura1);

            factura1.setTotal(120);

            factura1.getDetalles().add(det1);
            factura1.getDetalles().add(det2);

            entityManager.persist(cliente);
            entityManager.persist(dom); */

            Factura factura1 = entityManager.find(Factura.class, 1L);

            //factura1.setNumero(60);

            entityManager.remove(factura1);

            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Algo ha fallado");
            System.out.println("Error : " + e.getMessage());
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}