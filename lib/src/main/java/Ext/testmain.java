package Ext;

/**
 * Created by andrew on 2016/9/22 0022.
 */
public class testmain {

    public static void main(String[] args) {
        /*Bee a=new Bee(1,"black",new AttackImpl("fly","move"));
        a.onattack();

        int x=2;
        x=x<2?++x:x--;
        System.out.println(x);*/

        String temp = "zh-cn";
        if (temp.contains("zh")) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
        String tem2="http://www.tutormeet.com/tutormeet/config/tutormeet_init.txt";
        tem2=tem2.replace("www","cn2");
        System.out.println(tem2);

        boolean isdemo=false;

        if(!isdemo){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }


    }



}
