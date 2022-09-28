import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void listCheck(String headline, List<String> shoppingList) {
        System.out.println(headline);
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println(i + 1 + ". " + shoppingList.get(i));
        }
    }

    public static void main(String[] args) {
        int operation = 0;
        List<String> shoppingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию и введите её номер, для завершения введите end:" +
                    " \n1. Добавить товар в список покупок" +
                    " \n2. Показать список покупок" +
                    " \n3. Удалить товар из списка покупок" +
                    " \n4. Поиск в списке покупок");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            try {
                operation = Integer.parseInt(input);
            } catch (Exception h) {
                System.out.println("Нужно вводить цифры а вы ввели: " + input);
            }
            switch (operation) {
                case 1:
                    System.out.println("\n" + "Какую покупку хотите добавить?");

                    input = scanner.nextLine();
                    shoppingList.add(input);
                    System.out.println("Итого в списке покупок: " + shoppingList.size());
                    break;
                case 2:
                    listCheck("\nСписок покупок:", shoppingList);
                    break;
                case 3:
                    listCheck("\nСписок покупок:", shoppingList);
                    System.out.println("Какой товар хотите удалить? Введите номер или название");
                    String removeInput = scanner.nextLine();
                    try {
                        int removeNumber = Integer.parseInt(removeInput) - 1;
                        System.out.println("Покупка \"" + shoppingList.get(removeNumber) + "\" удалена, список покупок:");
                        shoppingList.remove(removeNumber);
                        for (int i = 0; i < shoppingList.size(); i++) {
                            System.out.println((i + 1) + " " + shoppingList.get(i));
                        }
                    } catch (Exception e) {
                        if (shoppingList.contains(removeInput)) {
                            System.out.println("Покупка \"" + removeInput + "\" удалена, список покупок:");
                            shoppingList.remove(removeInput);
                            for (int i = 0; i < shoppingList.size(); i++) {
                                System.out.println((i + 1) + " " + shoppingList.get(i));
                            }
                        } else {
                            System.out.println("Такого товара нет в списке покупок!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String search = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено:");
                    boolean yes = false;
                    for (int i = 0; i < shoppingList.size(); i++) {
                        if (shoppingList.get(i).toLowerCase().contains(search.toLowerCase())) {
                            System.out.println(i + 1 + ". " + shoppingList.get(i));
                            yes = true;
                        }
                    }
                    if (!yes) System.out.println("0 совпадений");
                    break;
            }
        }
    }
}