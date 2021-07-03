package week1;

import java.util.Random;

public class Craps {

    public static void main(String[] args) {
        int N = 5;
        int K = 4;

        Craps game = new Craps();
        Dice[] dices = new Dice[K];
        Player[] players = new Player[N];

        for(int i = 0; i < K; i++){
            dices[i] = game.new Dice();
        }
        for(int i = 0; i < N-1; i++){
            players[i] = game.new Player(String.valueOf(i+1));
        }
        players[N-1] = game.new Player("Computer");

        int first = 0;
        while(true){
            System.out.println("------------------------------------------------");
            System.out.println("Бросает предыдущий победитель");
            System.out.println("Игрок: " + players[first]);
            int sum = 0;
            for(int i = 0; i < K; i++){
                int dice = dices[i].throwDice();
                System.out.print(dice + "  ");
                sum += dice;
            }
            players[first].count = sum;
            System.out.println("\nСумма очков = " + sum);
            System.out.println();
            int Max = sum;
            int MaxIndex = first;
            for(int i = 0; i < N; i++){
                if(i != first){
                    System.out.println("Бросает игрок: " + players[i]);
                    sum = 0;
                    for(int j = 0; j < K; j++){
                        int dice = dices[j].throwDice();
                        System.out.print(dice + "  ");
                        sum += dice;
                    }
                    players[i].count = sum;
                    System.out.println("\nСумма очков = " + sum);
                    System.out.println();
                    if(sum > Max){
                        MaxIndex = i;
                        Max = sum;
                    }
                }
            }

            System.out.println("Победитель: " + players[MaxIndex] + " с суммой очков " + Max);
            first = MaxIndex;
            players[first].winCount += 1;
            System.out.println();
            int maxWinCounts = players[first].winCount;
            Player winner = players[first];
            System.out.println("Статистика очков по игрокам:");
            for(int i = 0; i < N; i++){
                System.out.println(players[i]);
                if(maxWinCounts < players[i].winCount){
                    maxWinCounts = players[i].winCount;
                    winner = players[i];
                }
            }
            if(maxWinCounts >= 7){
                System.out.println();
                System.out.println("У нас есть победитель!");
                System.out.println(winner);
                break;
            }
        }
    }

    public class Player{
        private String name;
        private int count = 0;
        private int winCount = 0;

        private Player(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    ", winCount=" + winCount +
                    '}';
        }
    }

    public class Dice{
        final Random random = new Random();

        int throwDice(){
            return random.nextInt(6) + 1;
        }
    }
}
