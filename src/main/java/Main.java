import java.util.Scanner;

public class Main {
    private static Order order;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Cart cart = new Cart();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Переглянути список моїх замовлень");
            System.out.println("7 - Переглянути товари за категорією");
            System.out.println("8 - Переглянути товари за назвою");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        order = new Order(cart);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товар для можливості його видалення.");
                    } else {
                        System.out.println("Ваш кошик містить: ");
                        System.out.println(cart);
                        System.out.println("Введіть ID для видалення товару з кошика");
                        int deleteID = scanner.nextInt();
                        if (deleteID == 1) cart.removeProduct(product1);
                        else if (deleteID == 2) cart.removeProduct(product2);
                        else if (deleteID == 3) cart.removeProduct(product3);
                        else System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 6:
                    if(order.getProducts().isEmpty()) {
                        System.out.println("Список замовлень пустий, зробіть замовлення щоб побачити список Ваших замовлень.");
                    } else {
                        System.out.println(order);
                    }
                    break;
                case 7:
                    System.out.println("Введіть назву категорії: ");
                    System.out.println("1 - Електроніка");
                    System.out.println("2 - Смартфони");
                    System.out.println("3 - Аксесуари");
                    int categoryID = scanner.nextInt();
                    if (categoryID == 1) {
                        System.out.println(product1);
                    }
                    else if (categoryID == 2) {
                        System.out.println(product2);
                    }
                    else if (categoryID == 3) {
                        System.out.println(product3);
                    }
                    break;
                case 8:
                    System.out.println("Введіть назву товару: ");
                    System.out.println("1 - Ноутбук");
                    System.out.println("2 - Смартфон");
                    System.out.println("3 - Навушники");
                    int goodID = scanner.nextInt();
                    if (goodID == 1) {
                        System.out.println(product1);
                    }
                    else if (goodID == 2) {
                        System.out.println(product2);
                    }
                    else if (goodID == 3) {
                        System.out.println(product3);
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}