package com.aididi.app;

/**
 * @author xuzexiang
 * @Date: 2018-10-13 0013
 * @Description:
 */
public class ToolItem {

    private String name;
    private boolean hasDone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDone() {
        return hasDone;
    }

    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }

    @Override
    public String toString() {
        return "ToolItem{" +
                "name='" + name + '\'' +
                ", hasDone=" + hasDone +
                '}';
    }
}
