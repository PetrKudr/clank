/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.clang.tooling.core;

import static org.clang.tooling.core.ReplacementStatics.getReplacementErrString;
import org.clank.java.std;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.Native;
import static org.llvm.support.AdtsupportLlvmGlobals.inconvertibleErrorCode;
import org.llvm.support.ErrorInfo;
import org.llvm.support.raw_ostream;

/**
 *
 * @author petrkudriavtsev
 */

public class ReplacementError extends ErrorInfo<ReplacementError> {
  /*public:*/
 
  public ReplacementError(replacement_error Err) {
    this.Err = Err;
    this.NewReplacement = new std.optional<>();
    this.ExistingReplacement = new std.optional<>();
  }

  /// Constructs an error related to an existing replacement.
  public ReplacementError(replacement_error Err, Replacement Existing) {
    this.Err = Err;
    this.NewReplacement = new std.optional<>();
    this.ExistingReplacement = new std.optional<>(JD$Move.INSTANCE, Existing);
  }

  /// Constructs an error related to a new replacement and an existing
  /// replacement in a set of replacements.
  public ReplacementError(replacement_error Err, Replacement New, Replacement Existing)
      /*: Err(Err), NewReplacement(std::move(New)),
        ExistingReplacement(std::move(Existing))*/ {
    this.Err = Err;
    this.NewReplacement = new std.optional<>(JD$Move.INSTANCE, New);
    this.ExistingReplacement = new std.optional<>(JD$Move.INSTANCE, Existing);
  }

  public std.string message() /*const override*/ {
    std.string Message = getReplacementErrString(Err);
    if (NewReplacement.$bool())
      Message.$addassign("\nNew replacement: " + NewReplacement.$arrow().toString());
    if (ExistingReplacement.$bool())
      Message.$addassign("\nExisting replacement: " + ExistingReplacement.$arrow().toString());
    return Message;
  }

  public void log(raw_ostream /*&*/OS) /*const override*/ { 
    OS.$out(message());
  }

  public replacement_error get() /*const*/ { return Err; }

  static char ID;

  public/*const*/ std.optional<Replacement> /*&*/getNewReplacement() /*const*/ {
    return NewReplacement;
  }

  public/*const*/ std.optional<Replacement> /*&*/getExistingReplacement() /*const*/ {
    return ExistingReplacement;
  }

/*private:*/
  // Users are not expected to use error_code.
  @Override 
  public std.error_code convertToErrorCode() /*const override*/ {
    return inconvertibleErrorCode();
  }

  replacement_error Err;

  // A new replacement, which is to expected be added into a set of
  // replacements, that is causing problem.
  std.optional<Replacement> NewReplacement;

  // An existing replacement in a replacements set that is causing problem.
  std.optional<Replacement> ExistingReplacement;
}