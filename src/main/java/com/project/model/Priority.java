package com.project.model;

public enum Priority {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private  final  int level;

    private Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
