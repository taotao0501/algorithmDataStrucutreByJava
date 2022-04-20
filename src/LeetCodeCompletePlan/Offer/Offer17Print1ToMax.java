package LeetCodeCompletePlan.Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer17Print1ToMax {

    private Character[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

    private List<String> res;

    public List<String> allCombination(int n) {
        res = new ArrayList<>();
        generateCombination(n, "", res);
        return res;
    }

    private void generateCombination(int n, String str, List<String> res) {
        if(str.length() == n) {
            res.add(str);
            return;
        }
        for(Character c : numbers) {
            generateCombination(n, str + c, res);
        }
    }

    public static void main(String[] args) {
        Offer17Print1ToMax offer17Print1ToMax = new Offer17Print1ToMax();
        System.out.println(offer17Print1ToMax.allCombination(3));
    }
}
