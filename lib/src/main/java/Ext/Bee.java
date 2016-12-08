package Ext;

/**
 * Created by andrew on 2016/9/22 0022.
 */
public class Bee extends Insect implements Attack{
    private Attack mAttack;

    public Bee(int size, String color,Attack mAttack) {
        super(size, color);
        this.mAttack=mAttack;
    }


    @Override
    public void move() {
        mAttack.move();
    }

    @Override
    public void onattack() {
        mAttack.onattack();
    }
}
