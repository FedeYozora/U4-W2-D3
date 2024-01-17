import Shop.Category;
import Shop.Customer;
import Shop.Order;
import Shop.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Category checkFor = (str, x) -> x.getCategory().equals(str);

        Product p1 = new Product("Harry Potter", "Books", 110);
        Product p2 = new Product("The Hobbit", "Books", 40);
        Product p3 = new Product("The Da Vinci Code", "Books", 127.5);
        Product p4 = new Product("The Godfather", "Books", 71.5);
        Product p5 = new Product("Adventures of Huckleberry Finn", "Books", 41.5);
        Product p6 = new Product("Culla", "Baby", 52.5);
        Product p7 = new Product("Pannolini", "Baby", 47.5);
        Product p8 = new Product("Scarpe", "Boy", 60);
        Product p9 = new Product("Pantaloni", "Boy", 23);
        Product p10 = new Product("Maglietta", "Boy", 28);

        List<Product> listaProdotti = new ArrayList<>();
        listaProdotti.add(p1);
        listaProdotti.add(p2);
        listaProdotti.add(p3);
        listaProdotti.add(p4);
        listaProdotti.add(p5);
        listaProdotti.add(p6);
        listaProdotti.add(p7);
        listaProdotti.add(p8);
        listaProdotti.add(p9);
        listaProdotti.add(p10);

        List<Product> listaProdottiDiMario = new ArrayList<>();
        listaProdottiDiMario.add(p6);
        listaProdottiDiMario.add(p7);
        List<Product> listaProdottiDiLuigi = new ArrayList<>();
        listaProdottiDiLuigi.add(p9);
        listaProdottiDiLuigi.add(p10);
        List<Product> listaProdottiDiGiuseppe = new ArrayList<>();
        listaProdottiDiGiuseppe.add(p1);
        listaProdottiDiGiuseppe.add(p2);
        listaProdottiDiGiuseppe.add(p3);


        List<Order> listaOrder = getOrders(listaProdottiDiMario, listaProdottiDiLuigi, listaProdottiDiGiuseppe);

        //ESERCIZIO 1

        Predicate<Product> priceMore100 = p -> p.getPrice() > 100;

        List<Product> lista1 = listaProdotti.stream().filter(p -> checkFor.isCategory("Books", p)).filter(priceMore100).toList();
        System.out.println();
        System.out.println("Elementi in categoria Book con prezzo superiori a 100");
        lista1.forEach(System.out::println);

        //ESERCIZIO 2

        List<Order> lista2 = listaOrder.stream().filter(order -> order.getProduct().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
        System.out.println();
        System.out.println("Ordini con almeno un prodotto in categoria Baby");
        lista2.forEach(System.out::println);

        //ESERCIZIO 3

        List<Product> lista3 = listaProdotti.stream().filter(p -> checkFor.isCategory("Boy", p)).toList();

        System.out.println();
        System.out.println("Elementi categoria Boy scontati del 10%");
        lista3.forEach(p -> {
            p.setSconto();
            System.out.println(p);
        });

        // ESERCIZIO 4

        LocalDate initialDate = LocalDate.of(2021, 2, 1);
        LocalDate finalDate = LocalDate.of(2021, 4, 1);
        Predicate<Order> orderIter2 = p -> p.getCustomer().getTier() == 2;
        Predicate<Order> orderDate = p -> p.getOrderDate().isAfter(initialDate) && p.getOrderDate().isBefore(finalDate);
        List<Order> lista4 = listaOrder.stream().filter(orderIter2.and(orderDate)).toList();

        System.out.println();
        System.out.println("Ordini effettuati da clienti tier 2 tra il 1 feb e il 1 apr 2021");
        lista4.forEach(System.out::println);
    }

    private static List<Order> getOrders(List<Product> listaProdottiDiMario, List<Product> listaProdottiDiLuigi, List<Product> listaProdottiDiGiuseppe) {
        Customer c1 = new Customer("Mario", 1);
        Customer c2 = new Customer("Luigi", 2);
        Customer c3 = new Customer("Giuseppe", 3);

        List<Customer> listaCustomer = new ArrayList<>();

        listaCustomer.add(c1);
        listaCustomer.add(c2);
        listaCustomer.add(c3);

        LocalDate d1 = LocalDate.of(2021, 10, 10);
        LocalDate d2 = LocalDate.of(2021, 2, 10);
        LocalDate d3 = LocalDate.of(2021, 3, 15);

        Order o1 = new Order("Completed", d1, listaProdottiDiMario, c1);
        Order o2 = new Order("Pending", d2, listaProdottiDiLuigi, c2);
        Order o3 = new Order("Shipped", d3, listaProdottiDiGiuseppe, c3);

        List<Order> listaOrder = new ArrayList<>();
        listaOrder.add(o1);
        listaOrder.add(o2);
        listaOrder.add(o3);
        return listaOrder;
    }
}