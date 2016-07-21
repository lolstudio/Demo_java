package com.example;

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
    }


    /**
     * 去除重复元素
     * @return
     */
    public static List<String> deleteRepeat(){
        String[] temp=new String[]{"a","b","c","d","b"};
        List<String> list=new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            if(!list.contains(temp[i])){
                list.add(temp[i]);
            }
        }
        return list;
    }

    public static void sort(){
        List<String> list=new ArrayList<>();
        list.add("Y");
        list.add("R");
        list.add("H");
        list.add("K");
        list.add("H");
        Collections.sort(list);
//        Comparator<Object> cmp = Collator.getInstance(Locale.ENGLISH);
//        Collections.sort(list,cmp);
        for(String i:list){
            System.out.println(i);
        }
    }

    /**
     * 数据在数组中的下标
     * String[] temp=new String[]{"a","b","c","d"};
        System.out.println(getIndex(temp,"b"));
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
     * @param videoName
     * @return
     */
    private static String getIndex(String videoName){
        String result = null;
        if(videoName.contains("_")){
            String[] name = videoName.split("_");
            for(String s: name){
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
