package Units;

public class Shooter extends Unit {
    public Shooter(String nam, String n, int health, int dam, int dist, int def, float move, int pr)
    {
        super(nam, n, health, dam, dist, def, move, pr);
        this.fineNumber = 1;
    }
}
