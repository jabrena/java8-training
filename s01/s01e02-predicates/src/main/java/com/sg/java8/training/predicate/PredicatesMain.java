package com.sg.java8.training.predicate;

import com.sg.java8.training.model.Product;
import com.sg.java8.training.predicate.service.ProductService;

import java.util.List;
import java.util.function.Predicate;

/**
 * A few {@link java.util.function.Predicate} usage samples
 */
public class PredicatesMain {

    public static void main(String[] args) {
        simplePredicates();

        productPredicates();

        removeCollectionItems();

        sectionPredicates();

        managerPredicates();
    }

    private static void simplePredicates() {
        final Predicate<Integer> isEven = number -> number %2 == 0;
        final Predicate<Integer> isBiggerThan100 = number -> number > 100;

        System.out.println(isEven.test(7));
        //System.out.println(isEven.test(8));

        System.out.println(isEven.and(isBiggerThan100).test(450));

        final Predicate<String> isNullOrEmpty = value -> value == null || value.isEmpty();
        System.out.println(isNullOrEmpty.test("something"));
        System.out.println(isNullOrEmpty.test(null));

        final Predicate<String> aFancyPredicate = it -> {
            if (it.length() > 10) {
                return true;
            } else {
                System.out.println(it);
                return it.length() > 50;
            }
        };

        final Predicate<Double> singleStatementMethodPredicate = predicateAsSingleStatementMethod();
        singleStatementMethodPredicate.test(515d);

        final Predicate<Double> multipleStatementsMethodPredicate = predicateAsMultipleStatementMethod();
        multipleStatementsMethodPredicate.test(441d);

        // TODO try other simple predicates - Integer, String, ...
    }

    private static void removeCollectionItems() {
        // TODO remove the elements of a collection - imperative and functional
    }

    private static void productPredicates() {
        final Product product = new Product(10, "iSomething", 500);
        final Predicate<Product> hasAppleBranding = it -> it.getName().startsWith("i");
        System.out.println(hasAppleBranding.test(product));

        final ProductService productService = new ProductService();
        final List<Product> products = productService.getNexusTablets();
        System.out.println("There are " + products.size() + " Nexus tablets");

        // TODO try other Product predicates
    }

    private static Predicate<Double> predicateAsSingleStatementMethod() {
        return value -> value > 20d;
    }

    private static Predicate<Double> predicateAsMultipleStatementMethod() {
        return value -> {
            if (value > 20) {
                System.out.println("Perform several instructions");
                return true;
            } else {
                System.out.println("Perform other instructions");
                return false;
            }
        };
    }

    private static void sectionPredicates() {
        // TODO build a Predicate which filters the Monitors section

        // TODO build a Predicate which filters the sections with more than 3 products
    }

    private static void managerPredicates() {
        // TODO build a Predicate which returns true if a store is managed by Jane
    }
}