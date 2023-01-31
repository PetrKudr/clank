/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.clang.tooling.core;

import org.clank.java.std;
import org.llvm.support.llvm_unreachable;

/**
 *
 * @author petrkudriavtsev
 */
public final class ReplacementStatics {
  
  public static std.string getReplacementErrString(replacement_error Err) {
    switch (Err) {
      case fail_to_apply:
        return new std.string("Failed to apply a replacement.");
      case wrong_file_path:
        return new std.string("The new replacement's file path is different from the file path of "
            + "existing replacements");
      case overlap_conflict:
        return new std.string("The new replacement overlaps with an existing replacement.");
      case insert_conflict:
        return new std.string("The new insertion has the same insert location as an existing "
            + "replacement.");
    }
    throw new llvm_unreachable("A value of replacement_error has no message.");
  }
  
}
