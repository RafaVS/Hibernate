/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

/**
 *
 * @author Raf
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor {

    private int updates;
    private int creates;
    private int loads;

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) { 
    // do nothing 
    }

    // This method is called when Employee object gets updated. 
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof Employee) {
            System.out.println("Update Operation");
            return true;
        }
        return false;
    }
    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        // do nothing 
        return true;
    }
    // This method is called when Employee object gets created. 
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Employee) {
            System.out.println("Create Operation");
            return true;
        }
        return false;
    }
    //called before commit into database 
    @Override
    public void preFlush(Iterator iterator) {
        System.out.println("preFlush");
    }
    //called after committed into database
    @Override
    public void postFlush(Iterator iterator) {
        System.out.println("postFlush");
    }
}
