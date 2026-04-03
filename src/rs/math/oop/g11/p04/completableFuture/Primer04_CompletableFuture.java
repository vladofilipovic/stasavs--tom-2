package rs.math.oop.g11.p04.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Primer04_CompletableFuture {
    public static void main(String[] args)
        throws Exception {
        CompletableFuture<String> buducnost =
        CompletableFuture
            // Асинхрона операција
            .supplyAsync(() -> {
                System.out.println(
                    "Корак 1: учитавање ("
                    + Thread.currentThread()
                        .getName() + ")");
                return "подаци";
            })
            // Трансформација резултата
            .thenApply(s -> {
                System.out.println(
                    "Корак 2: обрада");
                return s.toUpperCase();
            })
            // Још једна трансформација
            .thenApply(s -> {
                System.out.println(
                    "Корак 3: форматирање");
                return "Резултат: [" + s + "]";
            });
 
        // Преузимање резултата
        System.out.println(buducnost.get());
 
        // Комбиновање два резултата
        CompletableFuture<Integer> a =
        CompletableFuture.supplyAsync(
            () -> 10);
        CompletableFuture<Integer> b =
        CompletableFuture.supplyAsync(
            () -> 20);
        CompletableFuture<Integer> zbir =
        a.thenCombine(b, Integer::sum);
 
        System.out.println(
        "Збир: " + zbir.get());
    }
}
