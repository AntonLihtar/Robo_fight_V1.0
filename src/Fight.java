/**
 * принимаем 2 обьекта класса робот,
 * возвращаем победителя класса робот
 */
public class Fight {
    public Robot fight(Robot b1, Robot b2) {

        int hpB1 = b1.getHp(); //переменная хп 1робота
        int hpB2 = b2.getHp(); //переменная хп жизней 2робота

        while (hpB1 > 0 && hpB2 > 0) { //вычисляем победителя
            hpB1 = getHp1(hpB1, b2);
            hpB2 = getHp1(hpB2, b1);
        }
        return (hpB1 <= 0) ? b2 : b1;
    }

    private int getHp1(int hpR1, Robot r2) { //Возвращает хП 1го робота принимая его здоровье и врага
        int hitR2 = hit(r2);
        System.out.println("Hit " + r2 + " = " + hitR2);
        hpR1 -= hitR2;
        System.out.println("HP enemy = " + hpR1);
        return hpR1;
    }

    private int hit(Robot r) { //метод выдает случайное число в промежутке заданых чисел
        return r.getMinHit() + (int) (Math.random() * (r.getMaxHit() + 1 - r.getMinHit())); //возвращаем число
    }
}
