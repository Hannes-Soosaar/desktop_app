package desk.app;

public class KeyboardController {

    // takes in current pos and returns modified coordinates
    public double  moveUp( double X){
        System.out.println("Moving Up");
    return X+10;
    }
    public double  moveDown(double X)
    {
        System.out.println("Moving Down");
        return X-10;
    }
    public double  moveLeft( double Y)
    {
        System.out.println("Moving Left");
        return Y-10;
    }
    public double  moveRight(double Y){

        System.out.println("Moving Right");
        return Y+10;
    }

}
