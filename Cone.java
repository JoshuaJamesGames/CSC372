public class Cone extends Shape{

    public double radius;
    public double height;

    Cone(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        //Cone Surface Area Formula
        return (Math.PI * radius * (radius + Math.sqrt((Math.pow(height, 2)+Math.pow(radius, 2)))));
    }

    @Override
    public double volume() {
        //Cone Volume Formula
        return (Math.PI * Math.pow(radius, 2) * (height / 3));
    }

    @Override
    public String toString(){
        //Override toString for convenient printing
        return String.format("Cone: %.2f area, %.2f volume", this.surface_area(), this.volume());
    }
    
}
