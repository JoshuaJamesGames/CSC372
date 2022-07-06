import java.util.ArrayList;

public class ShapeArray {
    private Sphere mySphere;
    private Cylinder myCylinder;
    private Cone myCone;

    private ArrayList<Shape> threeShapes = new ArrayList<Shape>();

    ShapeArray(){
        mySphere = new Sphere(5);
        myCylinder = new Cylinder(6, 6);
        myCone = new Cone(7, 7);

        threeShapes.add(mySphere);
        threeShapes.add(myCylinder);
        threeShapes.add(myCone);

        threeShapes.forEach((stats) -> System.out.println(stats));
    }
}
