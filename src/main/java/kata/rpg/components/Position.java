package kata.rpg.components;


public class Position {
    private Long xCord;
    private Long yCord;
    private Long zCord;

    Position(long xCord, long yCord, long zCord ) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.zCord = zCord;
    }

    public double distance(Position otherPosition){
        if (otherPosition == null) {
            throw new IllegalArgumentException();
        }
        
        double partialResult = Math.pow((xCord - otherPosition.xCord), 2);
        partialResult =+  Math.pow((yCord - otherPosition.yCord), 2);
        partialResult =+  Math.pow((zCord - otherPosition.zCord), 2);

        return Math.sqrt(partialResult);
    }
}