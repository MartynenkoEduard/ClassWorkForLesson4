package com.company;

import java.sql.Array;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //lessonTask_1();
        //lessonTask_2();
        //lessonTask_3();
        //lessonTask_4();
        //lessonTask_5();
        //lessonTask_6();
        //lessonTask_7();
        lessonTask_8();

    }

    private static void lessonTask_1() {
        final int N = 30;                           //quantity of Banks
        double[] course = new double[N];
        for (int i = 0; i < N; i++) {
            course[i] = (double) Math.round((Math.random() * 3 + 25) * 100) / 100;
        }
        System.out.print(Arrays.toString(course) + " ");
        Arrays.sort(course);
        System.out.println();
        System.out.println("Минимальный курс - " + course[0] + "\n" + "Максимальный курс - " + course[N - 1]);


        double[] course1 = course.clone();
        double maxCourse = 0;
        for (int i = 0; i < course.length - 1; i++)
            if (course[i] >= maxCourse)
                maxCourse = i;
        System.out.println("Максимальный курс - " + maxCourse);

        double minCourse = 0;
        for (int i = 0; i < course.length - 1; i++)
            if (course[i] <= minCourse)
                minCourse = i;
        System.out.println("Минимальный курс - " + maxCourse);
    }

    private static void lessonTask_2() {
        final int N = 50;
        int digitArray[] = new int[N];
        for (int i = 0; i < N; i++) {
            digitArray[i] = (int) (Math.random() * 100 + 1);
        }
        Arrays.sort(digitArray);
        for (int element : digitArray)
            System.out.printf("%5d", element);
        System.out.println();

        for (int i = 1; i < digitArray.length; i *= 2) {
            System.out.printf("%5d", digitArray[i]);
        }
    }

    //Найти сумму четных элементов массива целых чисел.
    private static void lessonTask_3() {
        final int N = 100;
        int sum = 0;
        int amount[] = new int[N];
        for (int i = 0; i < N; i++) {
            amount[i] = (int) (Math.random() * 100 + 1);
            if (amount[i] % 2 == 0) {
                sum += amount[i];
            }
        }
        System.out.println(Arrays.toString(amount));
        System.out.println("Сумма четных элементов массива: " + sum);
    }

    //Найти произведение элементов массива целых чисел, которые кратны 9.
    private static void lessonTask_4() {
        final int N = 100;
        int amount[] = new int[N];
        long product = 1;
        for (int i = 0; i < N; i++) {
            amount[i] = (int) (Math.random() * 10 + 1);
            if (amount[i] % 9 == 0) {
                product *= amount[i];
            }
        }
        System.out.println(Arrays.toString(amount));
        System.out.println("Произведение элементов массива целых чисел :  " + product);
    }


    /*  Каждый солнечный день улитка, сидящая на дереве, поднимается вверх на
      2 см, а каждый пасмурный день опускается вниз на 1 см. В начале
      наблюдения улитка находилась на расстоянии А см от земли на 5-метровом
      дереве. Имеется 30-элементный массив, содержащий сведения о том, был
      ли соответствующий день наблюдения пасмурным или солнечным.
      Написать программу, определяющую местоположение улитки к концу 30-
      го дня наблюдения.  */
    private static void lessonTask_5() {
        final int N = 30;
        int wheather[] = new int[N];
        int startDistance = 250;
        int currentDistance = startDistance;
        for (int i = 0; i < wheather.length; i++) {
            wheather[i] = (int) (Math.random() * 10);
            if (wheather[i] >= 3)
                currentDistance += 2;
            else
                currentDistance -= 1;
        }
        for (int i = 0; i < wheather.length; i++) {
            if (currentDistance >= 500)
                currentDistance = 500;
            else if (currentDistance == 0)
                currentDistance = 0;
        }
        System.out.println(Arrays.toString(wheather));
        System.out.println("Улитка стартовала с высоты : " + startDistance + "см");
        System.out.println("Закончила своё путешествие на высоте : " + currentDistance + "см");

    }

    /*Руководство фирмы ведет по месяцам учет расходов и поступлений
     средств. За n месяцев получены два массива: R(n) — расходов и P(n) —
     поступлений. Сформировать из массивов R(n) и P(n) массив прибыли Z(n).
     Определить общую прибыль (как за весь период, так и по месяцам она
     может быть отрицательная), месяц с максимальной и месяц с минимальной
     прибылью, количество месяцев с положительной прибылью.*/
    private static void lessonTask_6() {
        final int months = 12;
        int expence[] = new int[months];
        int profits[] = new int[months];
        int summaryMonthsProfits[] = new int[months];
        int positiveProfits[] = new int[months];
        int summuryYearProfit = 0;
        int maxProfit = 0, minProfit = 0, count = 0;
        for (int i = 0; i < months; i++) {
            expence[i] = (int) (Math.random() * 1000 + 1);
            profits[i] = (int) (Math.random() * 1000 + 1);

            summaryMonthsProfits[i] = profits[i] - expence[i];

            if (summaryMonthsProfits[i] > 0) {
                count++;
            }

            summuryYearProfit += summaryMonthsProfits[i];
            if (summaryMonthsProfits[i] > maxProfit) {
                maxProfit = summaryMonthsProfits[i];
            }
        }

        System.out.println("Общая прибыль за весь период : " + summuryYearProfit);
        System.out.println("Прибыль по месяцам: " + Arrays.toString(summaryMonthsProfits));
        System.out.println("Максимальная прибыль : " + maxProfit);
        System.out.println("Количество месяцев с положительной прибылью : " + count);
    }

    //На соревнованиях по прыжкам в высоту и в длину получены два массива
    //результатов H(n) и D(n). Определить три лучших и три худших результата
    //в каждом виде соревнований.
    private static void lessonTask_7() {
        final int Quantity = 20;
        double heightJumps[] = new double[Quantity];
        double lengthJumps[] = new double[Quantity];
        for (int i = 0; i < Quantity; i++) {
            heightJumps[i] = ((double) (Math.round((Math.random() * 4 + 1) * 100))) / 100;
            lengthJumps[i] = ((double) (Math.round((Math.random() * 6 + 4) * 100))) / 100;
        }
        System.out.println(Arrays.toString(heightJumps));
        Arrays.sort(heightJumps);
        Arrays.sort(lengthJumps);
        System.out.println("Три лучших результата прыжков в высоту : " + heightJumps[Quantity - 3]
                + " " + heightJumps[Quantity - 2] + " " + heightJumps[Quantity - 1]);
        System.out.println("Наименьшие результаты : " + heightJumps[0] + " " + heightJumps[1] + " " + heightJumps[2]);
        System.out.println("\nТри лучших результата прыжков в длину : " + lengthJumps[Quantity - 3] +
                " " + lengthJumps[Quantity - 2] + " " + lengthJumps[Quantity - 1]);
        System.out.println("Наименьшие результаты : " + lengthJumps[0] + " " + lengthJumps[1] + " " + lengthJumps[2]);
    }


    //Написать алгоритм переворота элементов массива (смены мест в
    // заданном массиве: 1-го элемента с последним, 2-го с предпоследним и
    // так далее).
    private static void lessonTask_8() {

        int quantity = 30;
        int turnRound[] = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            turnRound[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println(Arrays.toString(turnRound));
        for (int i = 0; i < quantity / 2; i++) {
            turnRound[i] = turnRound[i] + turnRound[turnRound.length - 1 - i];
            turnRound[turnRound.length - 1 - i] = turnRound[i] - turnRound[turnRound.length - 1 - i];
            turnRound[i] = turnRound[i] - turnRound[turnRound.length - 1 - i];
        }
        System.out.println(Arrays.toString(turnRound));
    }
}
