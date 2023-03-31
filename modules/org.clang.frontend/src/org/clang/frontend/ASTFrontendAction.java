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

package org.clang.frontend;

import org.clang.sema.CodeCompleteConsumer;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clang.parse.ParseClangGlobals;


/// \brief Abstract base class to use for AST consumer-based frontend actions.
//<editor-fold defaultstate="collapsed" desc="clang::ASTFrontendAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 224,
 FQN="clang::ASTFrontendAction", NM="_ZN5clang17ASTFrontendActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17ASTFrontendActionE")
//</editor-fold>
public abstract class ASTFrontendAction extends /*public*/ FrontendAction implements Destructors.ClassWithDestructor {
/*protected:*/
  /// \brief Implement the ExecuteAction interface by running Sema on
  /// the already-initialized AST consumer.
  ///
  /// This will also take care of instantiating a code completion consumer if
  /// the user requested it and the action supports it.
  
  //===----------------------------------------------------------------------===//
  // Utility Actions
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTFrontendAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 537,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 519,
   FQN="clang::ASTFrontendAction::ExecuteAction", NM="_ZN5clang17ASTFrontendAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17ASTFrontendAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    CompilerInstance /*&*/ CI = getCompilerInstance();
    if (!CI.hasPreprocessor()) {
      return;
    }
    
    // FIXME: Move the truncation aspect of this into Sema, we delayed this till
    // here so the source manager would be initialized.
    if (hasCodeCompletionSupport()
       && !CI.getFrontendOpts().CodeCompletionAt.FileName.empty()) {
      CI.createCodeCompletionConsumer();
    }
    
    // Use a code completion consumer?
    CodeCompleteConsumer /*P*/ CompletionConsumer = null;
    if (CI.hasCodeCompletionConsumer()) {
      CompletionConsumer = /*AddrOf*/CI.getCodeCompletionConsumer();
    }
    if (!CI.hasSema()) {
      CI.createSema(getTranslationUnitKind(), CompletionConsumer);
    }
    
    ParseClangGlobals.ParseAST(CI.getSema(), CI.getFrontendOpts().ShowStats,
        CI.getFrontendOpts().SkipFunctionBodies);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTFrontendAction::ASTFrontendAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 234,
   FQN="clang::ASTFrontendAction::ASTFrontendAction", NM="_ZN5clang17ASTFrontendActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17ASTFrontendActionC1Ev")
  //</editor-fold>
  public ASTFrontendAction() {
    // : FrontendAction() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTFrontendAction::usesPreprocessorOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 235,
   FQN="clang::ASTFrontendAction::usesPreprocessorOnly", NM="_ZNK5clang17ASTFrontendAction20usesPreprocessorOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17ASTFrontendAction20usesPreprocessorOnlyEv")
  //</editor-fold>
  @Override public boolean usesPreprocessorOnly() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTFrontendAction::~ASTFrontendAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 224,
   FQN="clang::ASTFrontendAction::~ASTFrontendAction", NM="_ZN5clang17ASTFrontendActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17ASTFrontendActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
