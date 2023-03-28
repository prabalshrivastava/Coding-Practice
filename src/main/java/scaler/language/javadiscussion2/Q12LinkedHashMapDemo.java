package scaler.language.javadiscussion2;

import java.util.LinkedHashMap;

import java.util.HashMap;


public class Q12LinkedHashMapDemo {


  public static void main(String args[]) {

    HashMap<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);

    stocks.put("Apple", 123);

    stocks.put("BMW", 54);

    stocks.put("Google", 87);

    stocks.put("Microsoft", 232);

    stocks.put("Oracle", 76);

    stocks.get("Google");

    stocks.get("BMW");

    System.out.println(stocks);

  }


}


//  The output of this program will be the following:
//    {Apple=123, Microsoft=232, Oracle=76, Google=87, BMW=54}
//    Here's what's happening in the code:
//    An instance of LinkedHashMap is created with an initial capacity of 16, a load factor of 0.75f, and with access-order set to true. The access-order parameter specifies whether or not the elements will be ordered according to their access order, with the most recently accessed element at the end of the iteration order. Setting it to true means that the iteration order will reflect the order in which the elements were last accessed.
//    Several key-value pairs are added to the map using the put() method.
//    The get() method is called twice to retrieve the values associated with the keys "Google" and "BMW". This has the effect of updating the access order of these elements.
//    The map is printed using the println() method. Since the map is ordered by access order, the elements are printed in the order in which they were last accessed, which is: Apple, Microsoft, Oracle, Google, BMW.
//    So, the final output is a LinkedHashMap with five elements in it, sorted by the access order of their keys.