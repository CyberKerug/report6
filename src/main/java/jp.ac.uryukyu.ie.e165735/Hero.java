package jp.ac.uryukyu.ie.e165735;

public class Hero extends LivingThing {
    private boolean dead;
    private int hitPoint;
    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        hitPoint  = getHitPoint();
        dead = false;
    }

    public boolean isDead() {
        return dead;
    }


    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}
