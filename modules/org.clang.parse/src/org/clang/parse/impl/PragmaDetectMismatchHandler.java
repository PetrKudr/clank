/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.parse.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDetectMismatchHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 111,
 FQN="(anonymous namespace)::PragmaDetectMismatchHandler", NM="_ZN12_GLOBAL__N_127PragmaDetectMismatchHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_127PragmaDetectMismatchHandlerE")
//</editor-fold>
public class/*struct*/ PragmaDetectMismatchHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDetectMismatchHandler::PragmaDetectMismatchHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 112,
   FQN="(anonymous namespace)::PragmaDetectMismatchHandler::PragmaDetectMismatchHandler", NM="_ZN12_GLOBAL__N_127PragmaDetectMismatchHandlerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_127PragmaDetectMismatchHandlerC1ERN5clang4SemaE")
  //</editor-fold>
  public PragmaDetectMismatchHandler(Sema /*&*/ Actions) {
    // : PragmaHandler("detect_mismatch"), Actions(Actions) 
    //START JInit
    super(/*STRINGREF_STR*/"detect_mismatch");
    this./*&*/Actions=/*&*/Actions;
    //END JInit
  }

  
  /// \brief Handle the Microsoft \#pragma detect_mismatch extension.
  ///
  /// The syntax is:
  /// \code
  ///   #pragma detect_mismatch("name", "value")
  /// \endcode
  /// Where 'name' and 'value' are quoted strings.  The values are embedded in
  /// the object file and passed along to the linker.  If the linker detects a
  /// mismatch in the object file's values for the given name, a LNK2038 error
  /// is emitted.  See MSDN for more details.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDetectMismatchHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1737,
   FQN="(anonymous namespace)::PragmaDetectMismatchHandler::HandlePragma", NM="_ZN12_GLOBAL__N_127PragmaDetectMismatchHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_127PragmaDetectMismatchHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    SourceLocation DetectMismatchLoc = Tok.getLocation();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = Native.$createJavaCleaner();
      try {
        $c$.clean(BasicClangGlobals.$out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(/*NO_COPY*/DetectMismatchLoc, diag.err_expected)), tok.TokenKind.l_paren));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Read the name to embed, which must be a string literal.
    std.string NameString/*J*/= new std.string();
    if (!PP.LexStringLiteral(Tok, NameString, 
        /*KEEP_STR*/"pragma detect_mismatch", 
        /*MacroExpansion=*/ true)) {
      return;
    }
    
    // Read the comma followed by a second string literal.
    std.string ValueString/*J*/= new std.string();
    if (Tok.isNot(tok.TokenKind.comma)) {
      JavaCleaner $c$ = Native.$createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_detect_mismatch_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (!PP.LexStringLiteral(Tok, ValueString, /*KEEP_STR*/"pragma detect_mismatch", 
        /*MacroExpansion=*/ true)) {
      return;
    }
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = Native.$createJavaCleaner();
      try {
        $c$.clean(BasicClangGlobals.$out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(Tok.getLocation(), diag.err_expected)), tok.TokenKind.r_paren));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok); // Eat the r_paren.
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = Native.$createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_detect_mismatch_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If the pragma is lexically sound, notify any interested PPCallbacks.
    if ((PP.getPPCallbacks() != null)) {
      PP.getPPCallbacks().PragmaDetectMismatch(/*NO_COPY*/DetectMismatchLoc, new StringRef(NameString), 
          new StringRef(ValueString));
    }
    
    Actions.ActOnPragmaDetectMismatch(new SourceLocation(DetectMismatchLoc), new StringRef(NameString), new StringRef(ValueString));
  }

/*private:*/
  private Sema /*&*/ Actions;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDetectMismatchHandler::~PragmaDetectMismatchHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 111,
   FQN="(anonymous namespace)::PragmaDetectMismatchHandler::~PragmaDetectMismatchHandler", NM="_ZN12_GLOBAL__N_127PragmaDetectMismatchHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_127PragmaDetectMismatchHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Actions=" + Actions // NOI18N
              + super.toString(); // NOI18N
  }
}
