package Ext;

/**
 * Created by andrew on 2016/9/22 0022.
 */
public class AttackImpl implements Attack{
    private String move;
    private String attack;

    public AttackImpl(String attack, String move) {
        this.attack = attack;
        this.move = move;
    }

    @Override
    public void move() {
        System.out.println(move);
    }

    @Override
    public void onattack() {
        move();
        System.out.println(attack);
    }
}
