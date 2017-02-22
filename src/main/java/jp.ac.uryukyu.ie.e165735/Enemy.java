package jp.ac.uryukyu.ie.e165735;

public class Enemy extends LivingThing {
    private boolean dead;
    private int hitPoint;
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        hitPoint = getHitPoint();
        dead = false;
    }

    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }



    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}