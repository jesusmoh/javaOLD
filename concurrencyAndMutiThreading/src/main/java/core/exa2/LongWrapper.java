/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.exa2;

/**
 *
 * @author jesus
 */
public class LongWrapper {

    private Object key = new Object();
    private long l;

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public void incrementValue() {
        /* fixe RaceCondition
        synchronized(key)
        {
        l = l + 1;
        }
        */
        l = l + 1;
    }

    public LongWrapper(long l) {
        this.l = l;
    }

}
