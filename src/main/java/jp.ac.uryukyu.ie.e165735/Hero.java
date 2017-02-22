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

    /**
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(dead == false) {
            int crtHit;//ダメージ倍率
            int crt = (int) (Math.random() * 10);//クリティカルヒットの判定を行うための計算
            if(crt < 3){//Heroクラスの場合。 Enemyクラスの場合は(crt < 2)となる。
                crtHit = 2;//クリティカルヒット時(ダメージ2倍) 
            }else{
                crtHit = 1;//通常時(ダメージ等倍) 
            }
            int damage = (int) (Math.random() * getAttack() * crtHit);
            if(damage == 0) {
                System.out.println(getName() + "の攻撃！...だが、" + opponent.getName() + "は攻撃を回避した！");
            }else if(crtHit == 2) {
                System.out.printf("%sの攻撃！ 会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }opponent.wounded(damage);
        }
    }

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}
