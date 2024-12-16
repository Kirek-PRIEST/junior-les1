package market.example;

import market.example.food.Food;
import market.example.food.HealthFood;
import market.example.food.SemiFinishedFood;
import market.example.food.Snack;

import java.util.Scanner;

public class Program {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UMarket market = new UMarket();
        System.out.println("Hello, World!");

        while (true) {
            System.out.println("=============================================================");
            System.out.println("0 - выйти из приложения");
            System.out.println("1 - отобразить полный список товаров");
            System.out.println("2 - сфомировать онлайн корзину снеков");
            System.out.println("3 - сформировать корзину полуфабрикатов");
            System.out.println("4 - сформировать корзину из продуктов для проиготовления");
            System.out.println("5 - сформировать корзину из любых продовольственных товаров");
            System.out.println("Выберите путь");

            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                switch ((no)) {
                    case 0 -> {
                        System.out.println("Работа с приложением завершена");
                        return;
                    }
                    case 1 -> {
                        System.out.println("Список товаров:");
                        market.printThings(Food.class);
                    }

                    case 2 -> CreateCart(Snack.class, market);
                    case 3 -> CreateCart(SemiFinishedFood.class, market);
                    case 4 -> CreateCart(HealthFood.class, market);
                    case 5 -> CreateCart(Food.class, market);
                    default -> System.out.println("Пункт меню не существует.\nПожалуйста, выберите другой пункт");


                }

            } else {
                System.out.println("Некорректный пунк меню.\nПопробуйте ещё раз!");
                scanner.nextLine();
            }
        }


    }

    static <T extends Food> void CreateCart(Class<T> clazz, UMarket market) {
        Cart<T> cart = new Cart<>(clazz, market);
        while (true) {
            System.out.println("Список доступных товаров");
            System.out.println("[0] Завершение фомирования корзины + балансировка");
            market.printThings(clazz);
            System.out.println("Укажите номер товара для добавления");
            if (scanner.hasNextInt()){
                int no = scanner.nextInt();
                scanner.nextLine();
                if (no == 0){
                    cart.cartBalancing();
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuff();
                    return;
                }else {
                    T thing = market.getThingByIndex(clazz, no);
                    if ((thing == null)){
                        System.out.println("Некорректный номер товара \n Пожалуйста повторите ввод");
                        continue;
                    }
                    cart.getFoodstuff().add(thing);
                    System.out.println("Товар успешно добавлен в корзину");
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuff();
                }
            }
        }
    }
}