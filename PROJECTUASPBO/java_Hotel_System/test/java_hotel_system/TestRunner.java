/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_hotel_system;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author hokyt
 */
public class TestRunner {
    public static void main(String[] args) {
        org.junit.runner.Result mResult = new JUnitCore().runClasses(ModelHotelTest.class);
        showMessageResult(mResult, ModelHotelTest.class.getSimpleName());
    }
    
    public static void showMessageResult(Result mResult, String className){
        if(mResult.wasSuccessful()){
            System.out.printf("The Result Test from %s : %s\n", className, mResult.wasSuccessful());
            
        }else{
            for(Failure failure : mResult.getFailures()){
                System.out.println(failure);
            }
        }
    }
}
