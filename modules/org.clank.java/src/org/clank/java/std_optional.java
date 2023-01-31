/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.clank.java;

import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.NativeMoveable;

/**
 *
 * @author petrkudriavtsev
 */
public interface std_optional {
  
  public static final class optional<T> implements NativeMoveable<T>, Destructors.ClassWithDestructor {
    public optional() {}
    public optional(JD$Move _dparam, T /*&&*/Param) {}

    @Override
    public T move() {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void $destroy() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public T $arrow() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean $bool() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }
}
