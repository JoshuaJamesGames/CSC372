public class Cylinder extends Shape{

    public double radius;
    public double height;

    Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        //Cylinder Surface area formula
        return ((2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2)));
    }

    @Override
    public double volume() {
        //Cylinder Volume formula
        return (Math.PI * Math.pow(radius, 2) * height);
    }

    @Override
    public String toString(){
        //Override toString for convenient printing
        return String.format("%.2f area, %.2f volume", this.surface_area(), this.volume());
    }
    
}
