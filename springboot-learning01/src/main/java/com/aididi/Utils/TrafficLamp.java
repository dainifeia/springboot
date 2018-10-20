package com.aididi.Utils;

/**
 * @author Administrator
 * @Date: 2018/4/22 0022 21:11
 * @Description:
 */
public enum  TrafficLamp {
    RED(30) {
        @Override
        public TrafficLamp getNextLamp() {
            return GREEN;
        }
    }, GREEN(45) {
        @Override
        public TrafficLamp getNextLamp() {
            return YELLOW;
        }
    }, YELLOW(5) {
        @Override
        public TrafficLamp getNextLamp() {
            return RED;
        }
    };

    private int time;

    TrafficLamp(int time) {
        this.time = time;
    }

    /**
     * 一个抽象方法
     */

    public abstract TrafficLamp getNextLamp();

}
