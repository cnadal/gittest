/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerSet;

import java.util.ArrayList;

/**
 *
 * @author g.parra
 */
public class IntegerSet {

    private final int MAX = 100;
    private Boolean lesEntiers[];

    public IntegerSet() {
        lesEntiers = new Boolean[MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            lesEntiers[i] = false;
        }
    }

    public Boolean[] getLesEntiers() {
        return lesEntiers;
    }

    public void setLesEntiers(Boolean[] lesEntiers) {
        this.lesEntiers = lesEntiers;
    }

    public void put(int entier) {
        lesEntiers[entier] = true;
    }

    public Boolean remove(int entier) {
        if (lesEntiers[entier] == true) {
            lesEntiers[entier] = false;
            return true;
        } else {
            return false;
        }
    }

    public Boolean contains(int entier) {
        if (lesEntiers[entier] == true) {
            return true;
        } else {
            return false;
        }
    }

    public Integer cardinal() {
        Integer card = 0;
        for (int i = 0; i <= MAX; i++) {
            if (lesEntiers[i] == true) {
                card += 1;
            }
        }
        return card;
    }

    public String toString() {
        String ensemble = "{";
        for (int i = 0; i <= MAX; i++) {
            if (lesEntiers[i] == true) {
                ensemble = ensemble + i + ",";
            }
        }
        ensemble = ensemble + "}";
        return ensemble;
    }

    public Boolean equals(IntegerSet tab) {
        for (int i = 0; i < lesEntiers.length; i++) {
            if (lesEntiers[i] != tab.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public Boolean equals2(IntegerSet tab) {
        int i = 0;
        while (i < lesEntiers.length) {
            if (tab.getLesEntiers()[i] != lesEntiers[i]) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }

    public IntegerSet(int tab[]) {
        for (int i = 0; i <= MAX; i++) {
            lesEntiers[tab[i]] = true;
        }
    }

    public ArrayList toList() {
        ArrayList<Integer> ensemble = new ArrayList<>();
        for (int i = 0; i <= MAX; i++) {
            if (lesEntiers[i] == true) {
                ensemble.add(i);
            }
        }
        return ensemble;
    }

    public IntegerSet union(IntegerSet tippex) {
        IntegerSet inter = new IntegerSet();
        for (int i = 0; i <= MAX; i++) {
            if (tippex.getLesEntiers()[i] == true) {
                inter.put(i);
            }
        }
        for (int i = 0; i <= MAX; i++) {
            if (lesEntiers[i] == true) {
                inter.put(i);
            }
        }
        return inter;
    }

    public IntegerSet union2(IntegerSet obj) {
        IntegerSet res = new IntegerSet();
        for (int i = 0; i < lesEntiers.length; i++) {
            if (this.contains(i)) {
                res.put(i);
            }
        }
        for (int j = 0; j < obj.getLesEntiers().length; j++) {
            if (obj.contains(j)) {
                res.put(j);
            }
        }
        return res;
    }

    public IntegerSet inter(IntegerSet obj) {
        IntegerSet res = new IntegerSet();
        for (int i = 0; i < MAX; i++) {
            if (this.contains(i)) {
                res.put(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IntegerSet test = new IntegerSet();
        test.put(1);
        test.put(2);
        test.put(3);
        test.put(4);
        test.put(5);
        test.put(6);
        IntegerSet test2 = new IntegerSet();
        test2.put(7);
        test2.put(8);
        test2.put(9);
        test2.put(10);
        test2.put(11);
        test2.put(6);
        System.out.println(test.toString());
        System.out.println(test2.toString());
        System.out.println(test.equals(test2));
        System.out.println(test.union(test2).toString());

//        test.remove(4);
//        System.out.println(test.toString());
//        System.out.println(test.toList());
//        System.out.println(test.cardinal());
//        System.out.println(test.contains(0));
//        System.out.println(test.contains(74));
    }
}
