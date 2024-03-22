package com.firebird.main;

public class starEx {
    public static void main(String[] args) {
        drawPanda();
    }

    public static void drawPanda() {
        System.out.println("     __   __");
        System.out.println("   /   \\/   \\");
        System.out.println("  /           \\");
        System.out.println(" |  (\\     /)  |");
        System.out.println(" |_____________|");
        System.out.println("    |  ___  |");
        System.out.println("   /\\ (o o) /\\");
        System.out.println("  /  \\  ~  /  \\");
        System.out.println(" /    |___|    \\");
        System.out.println(" \\_____________/");

        drawPanda(1);
    }

    public static void drawPanda(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("* ");
            }
            System.out.println();
        }
    }
}
