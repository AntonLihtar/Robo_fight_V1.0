/**
 * класс робот (поля приватные и финальные , задаются при создании обьекта...)
 */
public class Robot {
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
