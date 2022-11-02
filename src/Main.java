/**
 * Программа эмулирует бой 2х роботов / имя робота, количество жизней(хп), минимальный и максимальный урон -
 * выставляется в параметрах классов...
 * <p>
 * код написан в ознакомительных целях во время закрепления материала автором...
 * <p>
 * код подойдет для понятия ЯП Java начального уровня
 * <p>
 * Все доработки приветствуются (можно добавить крит урон или особые навыки...)
 */
public class Main {
    public static void main(String[] args) {
        //создаем 1 робота(задаем имя, кол-во жизней, мин. урон , мах. урон)
        Robot r1 = new Robot("BigBan", 1000, 10, 100);

        //создаем 2рого
        Robot r2 = new Robot("Skala", 1100, 5, 100);

        //создаем обьект класса бой
        Fight vinF = new Fight();

        //вызываем метод бой и получаем победителя
        Robot vinner = vinF.fight(r1, r2);
        //выводим в консоль победителя
        System.out.println("Победителем становится  = " + vinner);
    }
}

class Robot { //класс робот (поля приватные и финальные , задаются при создании обьекта...)
    private final String name; //имя
    private final int hp; //количество здоровья (хп)
    private final int minHit; //минимальный урон
    private final int maxHit; //максималльный урон

    public Robot(String name, int hp, int minHit, int maxHit) { //конструктор
        this.name = name;
        this.hp = hp;
        this.minHit = minHit;
        this.maxHit = maxHit;
        System.err.println("Robot: " + getName() + " create!"); //логирование, можно убрать
    }

    //геттеры
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMinHit() {
        return minHit;
    }

    public int getMaxHit() {
        return maxHit;
    }

    //перереопределенный стринг выводит имя
    @Override
    public String toString() {
        return "Robot: " + name;
    }
}

class Fight { // класс бой
    /*
        принимаем 2 обьекта класса робот,
        возвращаем победителя класса робот
    */
    public Robot fight(Robot b1, Robot b2) {

        int hpB1 = b1.getHp(); //переменная хп 1робота
        int hpB2 = b2.getHp(); //переменная хп жизней 2робота

        while (hpB1 > 0 && hpB2 > 0) { //крутим цикл пока хп 1 из роботов не упадет до 0 и меньше

            int x = (hit(b2.getMinHit(), b2.getMaxHit())); //удар 2 робота
            hpB1 -= x; //хп 1робота после удара 2рого

            System.out.println(b2 + " нанес : " + x + " урона."); //выводим удар 2робота
            System.out.println(b1 + " имеет = " + hpB1 + " HP"); //выводим хп 1робота
            System.out.println(); //пстая строка
            if (hpB1 <= 0) break; //если хп 1робота 0 или ниже - выходим из цикла
            //все тоже только для 2рого робота ==>
            int y = (hit(b1.getMinHit(), b1.getMaxHit()));
            hpB2 -= y;
            System.out.println(b1 + " нанес : " + y + " урона.");
            System.out.println(b2 + " имеет = " + hpB2 + " HP");
            System.out.println();
            if (hpB2 <= 0) break;

        }
        return (hpB2 <= 0) ? b1 : b2; //тернарный оператор возвращает победителя
    }

    public int hit(int minHit, int maxHit) { //метод выдает случайное число в промежутке заданых чисел
        int hit = minHit + (int) (Math.random() * (maxHit + 1 - minHit)); //высчитываем число
        return hit; //возвращаем число
    }
}