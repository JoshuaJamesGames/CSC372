import java.util.ArrayList;

public class ShapeArray {
    public static void storeAndPrint(){
        //Create 3 sub-classes of Shape
        Sphere mySphere;
        Cylinder myCylinder;
        Cone myCone;

        //An ArrayList for the Shape(s)
        ArrayList<Shape> threeShapes = new ArrayList<Shape>();
    
        mySphere = new Sphere(5);
        myCylinder = new Cylinder(6, 6);
        myCone = new Cone(7, 7);

        threeShapes.add(mySphere);
        threeShapes.add(myCylinder);
        threeShapes.add(myCone);

        threeShapes.forEach((stats) -> System.out.println(stats));
    }
}
