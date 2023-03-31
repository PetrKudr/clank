package org.clang.format;

import org.clang.tooling.core.Replacement;
import org.clang.tooling.core.Replacements;
import org.clank.java.std;
import org.llvm.support.llvm;


public class ReplacementTestGlobals {
  public static Replacements toReplacements(final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
    Replacements Result = new Replacements();
    for (Replacement R : Replaces) {
      org.llvm.support.Error Err = Result.add(R);
      assert !Err.$bool() : llvm.toString(Err);
    }
    return Result;
  }
}
