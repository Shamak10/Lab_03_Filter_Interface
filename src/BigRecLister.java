import java.util.ArrayList;

// Define a BigRectangleFilter interface
interface BigRectangleFilter {
    boolean accept(Object object);
}

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle(" + width + "x" + height + ")";
    }
}

class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(9, 3));
        rectangles.add(new Rectangle(8, 2));
        rectangles.add(new Rectangle(3, 6));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(9, 4));
        rectangles.add(new Rectangle(7, 2));
        rectangles.add(new Rectangle(4, 10));
        rectangles.add(new Rectangle(1, 9));
        rectangles.add(new Rectangle(5, 8));
        rectangles.add(new Rectangle(6, 7));

        // Filter rectangles with perimeter > 10
        ArrayList<Rectangle> bigRectangles = (ArrayList<Rectangle>) collectAll(rectangles, new BigRectangleFilter() {
            @Override
            public boolean accept(Object object) {
                return ((Rectangle) object).getPerimeter() > 10;
            }
        });

        // Display big rectangles
        for (Rectangle rectangle : bigRectangles) {
            System.out.println(rectangle);
        }
    }

    public static ArrayList<?> collectAll(ArrayList<?> objects, BigRectangleFilter filter) {
        ArrayList<Object> filteredObjects = new ArrayList<>();

        for (Object object : objects) {
            if (filter.accept(object)) {
                filteredObjects.add(object);
            }
        }

        return filteredObjects;
    }
}