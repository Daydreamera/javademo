package proxy;

import java.util.SplittableRandom;

// 歌手
interface Skill {
    public void sing(String song);

    public void plan(String song);
}

// 经纪人
class Broker implements Skill {
    private Singer singer;

    public Broker(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing(String song) {
    }

    @Override
    public void plan(String song) {
        System.out.println("策划演唱会");
        singer.sing(song);
        System.out.println("演唱会收尾");
    }
}

// 创建被代理类
class Singer implements Skill {
    private String name;

    public Singer(String name) {
        this.name = name;
    }

    @Override
    public void sing(String song) {
        System.out.println("大家好 ,我是" + name + "，一首" + song + "送给你们");
    }

    @Override
    public void plan(String song) {

    }
}

public class StaticProxtTest {
    public static void main(String[] args) {
        Singer juXing = new Singer("牛逼");
        Broker broker = new Broker(juXing);
        broker.plan("小红花");
    }
}
