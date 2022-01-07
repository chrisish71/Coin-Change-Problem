import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        ChangeHelper.findChanges(1000, Arrays.asList(100, 500, 100), new ChangeCallback() {
//            @Override
//            public void onChangeFound(List<Integer> coinList) {
//                System.out.println(coinList);
//            }
//        });

        Set<Integer> coinList = new HashSet<>(Arrays.asList(2, 5, 10));
        System.out.println(ChangeHelper.findChanges(25, coinList));
    }
}
