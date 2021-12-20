import java.util.*;
import java.util.stream.Collectors;

public class ChangeHelper {

    public static Set<List<Integer>> findChanges(int amount, Set<Integer> coinList) {
        if (amount != 0) {
            return coinList
                    .stream()
                    .filter(coin -> coin <= amount)
                    .flatMap(coin -> findChanges(amount - coin, coinList).stream().peek(previousList -> previousList.add(coin))).map(resultList -> resultList.stream().sorted().collect(Collectors.toList()))
                    .collect(Collectors.toSet());
        } else {
            return Collections.singleton(new ArrayList<>());
        }
    }

    public static void findChanges(int amount, List<Integer> coinList, ChangeCallback callback) {
        find(amount, coinList, "", callback);
    }

    private static void find(int remaining, List<Integer> coinList, String found, ChangeCallback callback) {
        if (remaining == 0) {
            callback.onChangeFound(Arrays.stream(found.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            return;
        }
        if (remaining < 0) {
            return;
        }
        coinList.forEach(coin -> find(remaining - coin, coinList, found + coin + ",", callback));
    }
}
