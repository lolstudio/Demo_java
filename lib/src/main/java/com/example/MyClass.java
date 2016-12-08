package com.example;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {

//        System.out.println(String.format("old %1$s yeas %2$s", 12, 19));
//        System.out.println(sanmu());
//        testCollectionAddAll();
//        testCollectionCopy();
//        testNumberFormat();
//        System.out.println(getRandom(5,10));
//        System.out.println(tryFinally());
//        System.out.println(getIndex("_recording_session648_VndCy9A4VM_2016072012648"));
//        System.out.println(deleteRepeat().toString());

        /*String temp="stumble upon";
        try {
            System.out.println(URLEncoder.encode(temp, "UTF-8"));
            String replace = URLEncoder.encode(temp, "UTF-8").replace("+", " ");
            System.out.println(replace);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        /*one sub=new one();
        System.out.println(sub.calc());

        String lang="zh";
        String temp="abc";
        System.out.println(temp.substring(2));
        System.out.println(temp.substring(0,1));
        int size=0;
        boolean sw=false;
        System.out.println(sw ? 1:0);

        List<Integer> te=new ArrayList<>();
        Iterator iterator = te.iterator();
        while (iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            System.out.println(next.toString());
        }
        System.out.println("begin");
        for(Integer s:te){
            System.out.println("for");
            System.out.println(s.toString());
        }
        System.out.println("end");*/

        //输出英文
        System.out.println(Character.toString((char) (65 + 1)));


//        Calendar calendar = Calendar.getInstance();// 获取实例
//        String id = calendar.getTimeZone().getID();
//        System.out.println(id);
        int[] sessionTypes = {1, 2, 3, 4, 6, 80};
        int sessionType = 1;

        System.out.println(showEar(sessionTypes, sessionType));

        //三目运算的数据类型是相同的，也就是说后面返回的结果和第一个数的类型是一致的！！！第一个数是double，所以返回的结果也会是double，即1.0。
        Double d = 1.01;
        System.out.println(d > 1 ? d.intValue() : d); // 1.0


        System.out.println(DateUtils.getCurrentTimeInString());

        String temp = "bed & breakfast";
        /*try {
            temp= URLEncoder.encode(temp, "UTF-8");
            System.out.println(temp);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        String temp2;
        try {
            temp2 = URLEncoder.encode(temp, "UTF-8");
            System.out.println(temp2);
            temp2 = URLDecoder.decode(temp2, "UTF-8");
            System.out.println(temp2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String time="2016-12-05 19:15:00";
        long time2=0;
        try {
            time2 = DateUtils.transferStringDateToLong(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(time2);

        System.out.println(System.currentTimeMillis()<time2);

    }

    public static boolean showEar(int[] list, int temp) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == (temp)) {
                return true;
            }
        }
        return false;
    }

    private static class Mythread extends Thread {
        private int i;

        public Mythread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            super.run();
            System.out.println(i);
        }
    }


    /**
     * 去除重复元素
     *
     * @return
     */
    public static List<String> deleteRepeat() {
        String[] temp = new String[]{"a", "b", "c", "d", "b"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (!list.contains(temp[i])) {
                list.add(temp[i]);
            }
        }
        return list;
    }

    public static void sort() {
        List<String> list = new ArrayList<>();
        list.add("Y");
        list.add("R");
        list.add("H");
        list.add("K");
        list.add("H");
        Collections.sort(list);
//        Comparator<Object> cmp = Collator.getInstance(Locale.ENGLISH);
//        Collections.sort(list,cmp);
        for (String i : list) {
            System.out.println(i);
        }
    }

    /**
     * 数据在数组中的下标
     * String[] temp=new String[]{"a","b","c","d"};
     * System.out.println(getIndex(temp,"b"));
     *
     * @param list
     * @param temp
     * @return
     */
    public static int getIndex(String[] list, String temp) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(temp)) {
                return i;
            }
        }
        return 0;
    }


    /**
     * 分隔符取下标
     *
     * @param videoName
     * @return
     */
    private static String getIndex(String videoName) {
        String result = null;
        if (videoName.contains("_")) {
            String[] name = videoName.split("_");
            for (String s : name) {
                System.out.println(s);
            }
            result = name[2];
        }
        return result;
    }


    public static int tryFinally() {
        try {
            return 0;
        } finally {
            System.out.println("finally trumps return.");
        }
    }

    /**
     * 返回指定的随机数
     *
     * @param min 最小范围
     * @param max 最大返回
     * @return 返回值
     */
    private static int getRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    private static void testNumberFormat() {
        String temp = "12abc";
        int i = 0;
        try {
            i = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
        }
        System.out.println(i);
    }

    private static void testCollectionAddAll() {
        Integer[] array = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        System.out.println(list.size());
    }

    private static void testCollectionCopy() {
        List<String> srclst = new ArrayList<String>(5);
        List<String> destlst = new ArrayList<String>(10);

        // populate two lists
        srclst.add("Java");
        srclst.add("is");
        srclst.add("best");

        destlst.add("C++");
        destlst.add("is");
        destlst.add("older");


        // copy into dest list
        Collections.copy(destlst, srclst);

        System.out.println("Value of source list: " + srclst);
        System.out.println("Value of destination list: " + destlst);
    }

    public static int sanmu() {
        return 1 > 2 ? 10 : 11;
    }
}
