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


    /**
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        int crtHit;//クリティカルヒット(ダメージ2倍)
        int crt = (int) (Math.random() * 10);//クリティカルヒットの判定を行うための計算
        if(crt < 2){
            crtHit = 2;//クリティカルヒット時(ダメージ2倍)
        }else{
            crtHit = 1;//通常時(ダメージ等倍) 
        }
        if(dead == false) {
            int damage = (int) (Math.random() * getAttack() * crtHit);
            if(damage == 0) {
                System.out.println(getName() + "の攻撃！...だが、" + opponent.getName() + "は攻撃を回避した！");
            }else if(crtHit == 2) {
                System.out.printf("%sの攻撃！ 痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}