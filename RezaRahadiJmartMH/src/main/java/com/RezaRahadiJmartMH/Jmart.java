package com.RezaRahadiJmartMH;

import com.RezaRahadiJmartMH.dbjson.JsonDBEngine;
import com.google.gson.Gson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

@SpringBootApplication
public class Jmart
{
    public static long DELIVERED_LIMIT_MS = 11;
    public static long ON_DELIVERY_LIMIT_MS = 11;
    public static long ON_PROGRESS_LIMIT_MS = 11;
    public static long WAITING_CONF_LIMIT_MS = 11;

    /*
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> predicate = a -> (a.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByCategory(List<Product> list, Product.ProductCategory category){
        List <Product> categor = new ArrayList<>();
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).category.equals(category)){
                categor.add(list.get(i));
            }
            return categor;
        }
        return null;
    }
    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize){
        Predicate<Product> predicate = a -> (a.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List <Product> products = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if(minPrice <= 0.0){
                if(list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            } else if (maxPrice <= 0.0){
                if(list.get(i).price >= minPrice){
                    products.add(list.get(i));
                }
            } else {
                if (list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }
        }
        return products;
    }
*/
    public static void main(String[] args){
        /*
        for (int i = 0; i < 3; i++) {
            System.out.println("account id:" + new Account(null, null, null, -1).id);
        }
         */
        SpringApplication.run(Jmart.class, args);

        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

        /*
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);

        try{
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:\\Users\\Asus\\Desktop\\Projek OOP\\jmart\\src\\randomPaymentList.Json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();

            table.forEach(payment -> paymentPool.add(payment));
            while(paymentPool.size() !=0);
            paymentPool.exit();

            while (paymentPool.isAlive());
            System.out.println("Thread exited successfully");
            Gson gson = new Gson();
            table.forEach(payment-> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
            });

        }catch (Throwable t)
        {
            t.printStackTrace();
        }
        /*
        try
        {

            List<Product> list = read("C:/Users/Asus/Desktop/Projek OOP/jmart/src/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
            filtered.forEach(product -> System.out.println(product.price));

            List<Product> filteredName = filterByName(list, "gtx", 1, 5);
            filteredName.forEach(product -> System.out.println(product.name));

            List<Product> filteredAccount = filterByAccountId(list, 1, 0, 5);
            filteredAccount.forEach(product -> System.out.println(product.name));

            String filepath = "C:/Users/Asus/Desktop/Projek OOP/jmart/src/Account.json";

            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password", -1));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));

        }
        catch (Throwable t){
            t.printStackTrace();
        }
         */
    }

    public static boolean paymentTimekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = Math.abs(record.date.getTime() - (new Date()).getTime());

        if(record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "WAITING"));
            return true;
        } else if(record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "PROGRESS"));
            return true;
        } else if(record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "DELIVERY"));
            return false;
        } else if(record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "FINISH"));
            return true;
        }
        return false;
    }

    /*
    private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){
        if(page<0){
            page = 0;
        }
        if(pageSize<0){
            pageSize = 0;
        }
        return list.stream().filter(a -> pred.predicate(a)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }


    public static List<Product> read (String filepath) {
        try {
            Gson gson = new Gson();
            JsonReader js = new JsonReader(new FileReader(filepath));

            List<Product> list = new ArrayList<>();
            Product[] prod = gson.fromJson(js, Product[].class);
            Collections.addAll(list, prod);
            return list;
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }

        return null;
    }


/**
    public static Product create(){
        Product product = new Product("Nampan", 1, false, new PriceTag(30000, 10), Product.ProductCategory.KITCHEN);
        return product;
    }
    
    public static Coupon createcoup(){
        Coupon coup = new Coupon("Diskon Payung", 1, Coupon.Type.REBATE, 5000, 50000);
        return coup;
    }
    
    public static ShipmentDuration createshipment(){
        ShipmentDuration ship = new ShipmentDuration(ShipmentDuration.REGULER);
        return ship;
    }
*/
    
}
