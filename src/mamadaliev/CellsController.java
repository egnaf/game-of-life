package mamadaliev;

import java.awt.*;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

class CellsController {
    private int width;
    private int height;
    private int row, column;
    private boolean[][][] cells;
    private double radius;
    private double percent;

    /**
     * Constructor with class parameters CellsController
     *
     * @param width window width
     * @param height window height
     * @param row row length of cells
     * @param column column length of cells
     * @param radius cell radius
     */
    CellsController(int width, int height, int row, int column, double radius, double percent) {
        this.width = width;
        this.height = height;
        this.row = row;
        this.column = column;
        this.radius = radius;
        this.cells = new boolean[2][width][height]; // 2 x (row * column)
        this.percent = percent;
    }

    /**
     * Initialization of cells
     */
    public void fillValues() {
        Random rnd = new Random();
        int size = 0, x, y;
        int count = (int) (((row * column) / 100) * this.percent);

        while (size < count) {
            x = rnd.nextInt(row);
            y = rnd.nextInt(column);

            if (!cells[0][x][y]) {
                cells[0][x][y] = true;
                size++;
            }
        }
    }

    /**
     * Checking the neighbors and returning their quantity
     * @param x X
     * @param y Y
     */
    private int getNeighborsCount(int x, int y) {
        int neighbors = 0;

        // left bottom cell
        if (y == 0 && x == 0) {
            if (cells[0][x + 1][y])              neighbors++;
            if (cells[0][x][y + 1])              neighbors++;
            if (cells[0][x + 1][y + 1])          neighbors++;
            if (cells[0][width - 1][y])          neighbors++;
            if (cells[0][width - 1][y + 1])      neighbors++;
            if (cells[0][x][height - 1])         neighbors++;
            if (cells[0][x + 1][height - 1])     neighbors++;
            if (cells[0][width - 1][height - 1]) neighbors++;
        }

        // right bottom cell
        if (y == 0 && x == width - 1) {
            if (cells[0][0][y])              neighbors++; // [x+1, y]
            if (cells[0][0][y + 1])          neighbors++; // [x+1, y+1]
            if (cells[0][x][y + 1])          neighbors++; // [x,   y+1]
            if (cells[0][0][height - 1])     neighbors++; // [x+1, y-1]
            if (cells[0][x][height - 1])     neighbors++; // [x,   y-1]
            if (cells[0][x - 1][height - 1]) neighbors++; // [x-1, y-1]
            if (cells[0][x - 1][y])          neighbors++; // [x-1, y]
            if (cells[0][x - 1][y + 1])      neighbors++; // [x-1, y+1]
        }

        // bottom cells
        if (y == 0 && (x > 0 && x < width - 1)) {
            if (cells[0][x][y + 1])          neighbors++;
            if (cells[0][x + 1][y + 1])      neighbors++;
            if (cells[0][x + 1][y])          neighbors++;
            if (cells[0][x - 1][y + 1])      neighbors++;
            if (cells[0][x - 1][y])          neighbors++;
            if (cells[0][x - 1][height - 1]) neighbors++;
            if (cells[0][x][height - 1])     neighbors++;
            if (cells[0][x + 1][height - 1]) neighbors++;
        }

        // top cells
        if (y == height - 1 && (x > 0 && x < width - 1)) {
            if (cells[0][x][y - 1])     neighbors++;
            if (cells[0][x + 1][y - 1]) neighbors++;
            if (cells[0][x + 1][y])     neighbors++;
            if (cells[0][x - 1][y - 1]) neighbors++;
            if (cells[0][x - 1][y])     neighbors++;
            if (cells[0][x - 1][0])     neighbors++;
            if (cells[0][x][0])         neighbors++;
            if (cells[0][x + 1][0])     neighbors++;
        }

        // other cells
        if ((x > 0 && y > 0) && (x < width - 1 && y < height - 1)) {
            if (cells[0][x - 1][y - 1]) neighbors++;
            if (cells[0][x - 1][y])     neighbors++;
            if (cells[0][x][y - 1])     neighbors++;
            if (cells[0][x][y + 1])     neighbors++;
            if (cells[0][x + 1][y])     neighbors++;
            if (cells[0][x + 1][y + 1]) neighbors++;
            if (cells[0][x + 1][y - 1]) neighbors++;
            if (cells[0][x - 1][y + 1]) neighbors++;
        }
        return neighbors;
    }

    /**
     * Next epoch generation
     */
    public void getNextEpoch() {
        int neighbors;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                neighbors = getNeighborsCount(x, y);
                cells[1][x][y] = neighbors == 3 || (cells[0][x][y] && neighbors == 2);
            }
        }

        for (int i = 0; i < cells[0].length; i++) {
            System.arraycopy(cells[1][i], 0, cells[0][i], 0, cells[0][i].length);
        }
    }

    /**
     * Drawing cells
     */
    public void drawCells() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (cells[0][i][j]) {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledRectangle(i, j, 0.1 * radius, 0.1 * radius);
                }
            }
        }
    }
}