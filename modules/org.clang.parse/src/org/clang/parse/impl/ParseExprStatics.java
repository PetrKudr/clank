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

import org.clang.ast.AvailabilitySpec;
import org.clang.basic.*;
import org.clang.parse.Parser;
import org.clank.support.Converted;
import org.clank.support.JavaCleaner;
import org.clank.support.Native;
import org.llvm.adt.SmallSet;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;


//<editor-fold defaultstate="collapsed" desc="static type ParseExprStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZL14isFoldOperatorN5clang3tok9TokenKindE;_ZL14isFoldOperatorN5clang4prec5LevelE;_ZL25CheckAvailabilitySpecListRN5clang6ParserEN4llvm8ArrayRefINS_16AvailabilitySpecEEE; -static-type=ParseExprStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseExprStatics {

//<editor-fold defaultstate="collapsed" desc="isFoldOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 239,
 FQN="isFoldOperator", NM="_ZL14isFoldOperatorN5clang4prec5LevelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZL14isFoldOperatorN5clang4prec5LevelE")
//</editor-fold>
public static boolean isFoldOperator_Level(prec.Level Level) {
  return Level.getValue() > prec.Level.Unknown.getValue() && Level != prec.Level.Conditional;
}

//<editor-fold defaultstate="collapsed" desc="isFoldOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 242,
 FQN="isFoldOperator", NM="_ZL14isFoldOperatorN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZL14isFoldOperatorN5clang3tok9TokenKindE")
//</editor-fold>
public static boolean isFoldOperator_TokenKind(/*tok.TokenKind*/char Kind) {
  return isFoldOperator_Level(BasicClangGlobals.getBinOpPrecedence(Kind, false, true));
}


/// Validate availability spec list, emitting diagnostics if necessary. Returns
/// true if invalid.
//<editor-fold defaultstate="collapsed" desc="CheckAvailabilitySpecList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2878,
 FQN="CheckAvailabilitySpecList", NM="_ZL25CheckAvailabilitySpecListRN5clang6ParserEN4llvm8ArrayRefINS_16AvailabilitySpecEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZL25CheckAvailabilitySpecListRN5clang6ParserEN4llvm8ArrayRefINS_16AvailabilitySpecEEE")
//</editor-fold>
public static boolean CheckAvailabilitySpecList(Parser /*&*/ P,
                                                ArrayRef<AvailabilitySpec> AvailSpecs) {
  SmallSet<StringRef> Platforms = null;
  try {
    Platforms/*J*/= new SmallSet<StringRef>(4, StringRef.R$EMPTY, StringRef.COMPARATOR);
    boolean HasOtherPlatformSpec = false;
    boolean Valid = true;
    for (/*const*/ AvailabilitySpec /*&*/ Spec : AvailSpecs) {
      if (Spec.isOtherPlatformSpec()) {
        if (HasOtherPlatformSpec) {
          JavaCleaner $c$ = Native.$createJavaCleaner();
          try {
            $c$.clean($c$.track(P.Diag(Spec.getBeginLoc(), diag.err_availability_query_repeated_star)));
            Valid = false;
          } finally {
            $c$.$destroy();
          }
        }
        
        HasOtherPlatformSpec = true;
        continue;
      }
      
      boolean Inserted = Platforms.insert(Spec.getPlatform());
      if (!Inserted) {
        JavaCleaner $c$ = Native.$createJavaCleaner();
        try {
          // Rule out multiple version specs referring to the same platform.
          // For example, we emit an error for:
          // @available(macos 10.10, macos 10.11, *)
          StringRef Platform = Spec.getPlatform();
          $c$.clean(BasicClangGlobals.$out_DiagnosticBuilder$C_StringRef(BasicClangGlobals.$out_DiagnosticBuilder$C_SourceRange($c$.track(P.Diag(Spec.getBeginLoc(), diag.err_availability_query_repeated_platform)),
                  new SourceRange(Spec.getEndLoc())), /*NO_COPY*/Platform));
          Valid = false;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!HasOtherPlatformSpec) {
      JavaCleaner $c$ = Native.$createJavaCleaner();
      try {
        SourceLocation InsertWildcardLoc = AvailSpecs.back().getEndLoc();
        $c$.clean(BasicClangGlobals.$out_DiagnosticBuilder$C_FixItHint$C($c$.track(P.Diag(new SourceLocation(InsertWildcardLoc), diag.err_availability_query_wildcard_required)),
            FixItHint.CreateInsertion(/*NO_COPY*/InsertWildcardLoc, new StringRef(/*KEEP_STR*/", *"))));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    return !Valid;
  } finally {
    if (Platforms != null) { Platforms.$destroy(); }
  }
}

} // END OF class ParseExprStatics
