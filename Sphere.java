public class Sphere extends Shape{
    public double radius;

    Sphere(double radius){
        this.radius = radius;
    }

    @Override
    public double surface_area() {
        //Sphere Surface area formula
        return (4 * Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double volume() {
        //Sphere Volume formula
        return (4 * Math.PI * Math.pow(radius, 3) / 3);
    }

    @Override
    public String toString(){
        //Override toString for convenient printing
        return String.format("Sphere: %.2f area, %.2f volume", this.surface_area(), this.volume());
    }
    
}
