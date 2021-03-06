public class Mst {
    // В этой статической(!) переменной будет хранится единственный объект класса Mst
    private static Mst instance;

    // у нашего единственного объекта должно быть поле e
    private String value;

    // Метод getter для поля value
    public String getValue() {
        return value;
    }

    // ВАЖНО: Конструктор должен быть приватным
    // Мы не хотим, чтобы пользователь мог создавать новые объекты класса Mst
    private Mst(String value) {
        this.value = value;
    }

    // Вот этот статический метод будет вызывать пользователь, чтобы получить объект класса Mst
    public static Mst getInstance(String value) {
        // если ранее не был создан единственный объект
        if (instance == null) {
            // код здесь выполняется только в момент первого вызова метода getInstance()

            // создаем объект один раз
            instance = new Mst(value);
        }

        // все остальные вызовы метода getInstance() пользователю возвращается тот же самый объект
        return instance;
    }
}

// Тестируем
class SingletonTest {
    public static void main(String[] args) {
        Mst first = Mst.getInstance("Hello!");
        Mst second = Mst.getInstance("Goodbye!");

        // true
        System.out.println(first == second);

        // Hello!
        System.out.println(first.getValue());

        // Hello!
        System.out.println(second.getValue());
    }
}