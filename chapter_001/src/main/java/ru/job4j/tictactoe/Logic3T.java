package ru.job4j.tictactoe;

/**
 * @author Valeriy Gyrievskikh
 * @since 15.06.2018.
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяется, выиграл ли игрок Х.
     *
     * @return Результат проверки.
     */
    public boolean isWinnerX() {
        boolean winX = false;
        boolean column = true;
        boolean line = true;
        boolean diagonal = true;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][0].hasMarkX() && !table[i][j].hasMarkX()) {
                    line = false;
                    break;
                }
            }
            for (int j = 0; j < table.length; j++) {
                if (table[0][i].hasMarkX() && !table[j][i].hasMarkX()) {
                    column = false;
                    break;
                }
            }
            for (int j = 0; j < table.length; j++) {
                if ((table[0][0].hasMarkX() && !table[j][j].hasMarkX())
                        || (table[0][table.length - 1].hasMarkX() && !table[j][table.length - 1 - j].hasMarkX())) {
                    diagonal = false;
                    break;
                }
            }
        }
        if (line || column || diagonal) {
            winX = true;
        }
        return winX;
    }

    /**
     * Проверяется, выиграл ли игрок O
     *
     * @return Результат проверки.
     */
    public boolean isWinnerO() {
        boolean winO = false;
        boolean column = true;
        boolean line = true;
        boolean diagonal = true;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][0].hasMarkO() && !table[i][j].hasMarkO()) {
                    line = false;
                    break;
                }
            }
            for (int j = 0; j < table.length; j++) {
                if (table[0][i].hasMarkO() && !table[j][i].hasMarkO()) {
                    column = false;
                    break;
                }
            }
            for (int j = 0; j < table.length; j++) {
                if ((table[0][0].hasMarkO() && !table[j][j].hasMarkO())
                        || (table[0][table.length - 1].hasMarkO() && !table[j][table.length - 1 - j].hasMarkO())) {
                    diagonal = false;
                    break;
                }
            }
        }
        if (line || column || diagonal) {
            winO = true;
        }
        return winO;
    }

    /**
     * Проверяется, есть ли свободные поля.
     *
     * @return Результат проверки.
     */
    public boolean hasGap() {
        boolean hasFree = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkO() && !table[i][j].hasMarkX()) {
                    hasFree = true;
                    break;
                }
            }
        }
        return hasFree;
    }
}
