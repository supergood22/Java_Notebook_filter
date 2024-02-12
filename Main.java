package Lesson6.ex;

import java.util.*;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
5 - поиск
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно
также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков
или добавить еще ноутбук, то программа начинает работать некорректно
*/
public class Main {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook();
        nb1.model = "dell";
        nb1.ram = 8;
        nb1.ssd = 256;
        nb1.os = "linux";
        nb1.color = "черный";

        Notebook nb2 = new Notebook();
        nb2.model = "sony";
        nb2.ram = 16;
        nb2.ssd = 512;
        nb2.os = "windows";
        nb2.color = "белый";

        Notebook nb3 = new Notebook();
        nb3.model = "apple";
        nb3.ram = 32;
        nb3.ssd = 1000;
        nb3.os = "ios";
        nb3.color = "серебристый";

        Notebook nb4 = new Notebook();
        nb4.model = "asus";
        nb4.ram = 16;
        nb4.ssd = 250;
        nb4.os = "linux";
        nb4.color = "черный";

        Set<Notebook> nbs = new HashSet<>();
        nbs.add(nb1);
        nbs.add(nb2);
        nbs.add(nb3);
        nbs.add(nb4);

        System.out.println("Перечень имеющихся ноутбуков:");
        printSet(nbs);
        filter(nbs);

    }

    static void filter(Set<Notebook> set){
        Map<Integer, String> userMapFilter = userFilter(set);
        System.out.println("Результаты фильтра:");
        for (Notebook notebook : set) {
            if ((userMapFilter.get(1).equals("") || notebook.ram >= Integer.parseInt(userMapFilter.get(1))) &&
                    (userMapFilter.get(2).equals("") || notebook.ssd >= Integer.parseInt(userMapFilter.get(2))) &&
                    (userMapFilter.get(3).equals("") || notebook.os.equals(userMapFilter.get(3))) &&
                    (userMapFilter.get(4).equals("") || notebook.color.equals(userMapFilter.get(4)))){
                System.out.println(notebook);
                //System.out.println(userMapFilter.get(2));
            }
        }
    }

    static void printSet(Set<Notebook> set){
        for (Notebook nb: set) {
            System.out.println(nb);
        }
    }

    static Map<Integer, String> userFilter(Set<Notebook> set) {
        int x = -1;
        Map<Integer, String> userResFilter = new HashMap<>();
        for (int i = 1; i < set.size()+1; i++) {
            userResFilter.put(i, "");
        }
        Scanner scanner = new Scanner(System.in);
        while (x != 0) {
            System.out.println("Введите параметры фильрации ноутбуков.\n" +
                    "Введите цифру, соответствующую необходимому критерию:\n" +
                    "1 - ОЗУ\n" +
                    "2 - Объем SSD\n" +
                    "3 - Операционная система\n" +
                    "4 - Цвет\n" +
                    "0 - поиск");
            String parametr = scanner.nextLine();
            switch (parametr) {
                case "1":
                    System.out.print("Введите минимальное значение ОЗУ: ");
                    String ramParam = scanner.nextLine();
                    //System.out.println(ramParam);
                    userResFilter.put(1, ramParam);
                    break;
                case "2":
                    System.out.print("Введите минимальное значение SSD: ");
                    String ssdParam = scanner.nextLine();
                    //System.out.println(ssdParam);
                    userResFilter.put(2, ssdParam);
                    break;

                case "3":
                    System.out.print("Введите операционную систему (linux, ios, windows): ");
                    String osParam = scanner.nextLine();
                    //System.out.println(osParam);
                    userResFilter.put(3, osParam);
                    break;

                case "4":
                    System.out.print("Введите цвет: ");
                    String colorParam = scanner.nextLine();
                    //System.out.println(colorParam);
                    userResFilter.put(4, colorParam);
                    break;

                case "0":
                    x = 0;
                    break;
            }
        }
        //System.out.println(userResFilter);
        return userResFilter;
    }


}

