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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;


/// Legacy wrapper pass to provide the GlobalsAAResult object.
//<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 132,
 FQN="llvm::GlobalsAAWrapperPass", NM="_ZN4llvm20GlobalsAAWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm20GlobalsAAWrapperPassE")
//</editor-fold>
public class GlobalsAAWrapperPass extends /*public*/ ModulePass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<GlobalsAAResult> Result;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::GlobalsAAWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 960,
   FQN="llvm::GlobalsAAWrapperPass::GlobalsAAWrapperPass", NM="_ZN4llvm20GlobalsAAWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm20GlobalsAAWrapperPassC1Ev")
  //</editor-fold>
  public GlobalsAAWrapperPass() {
    // : ModulePass(ID), Result() 
    //START JInit
    super(ID);
    this.Result = new std.unique_ptr<GlobalsAAResult>();
    //END JInit
    GlobalsModRefLlvmStatics.initializeGlobalsAAWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::getResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 140,
   FQN="llvm::GlobalsAAWrapperPass::getResult", NM="_ZN4llvm20GlobalsAAWrapperPass9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm20GlobalsAAWrapperPass9getResultEv")
  //</editor-fold>
  public GlobalsAAResult /*&*/ getResult() {
    return Result.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::getResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 141,
   FQN="llvm::GlobalsAAWrapperPass::getResult", NM="_ZNK4llvm20GlobalsAAWrapperPass9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZNK4llvm20GlobalsAAWrapperPass9getResultEv")
  //</editor-fold>
  public /*const*/ GlobalsAAResult /*&*/ getResult$Const() /*const*/ {
    return Result.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 964,
   FQN="llvm::GlobalsAAWrapperPass::runOnModule", NM="_ZN4llvm20GlobalsAAWrapperPass11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm20GlobalsAAWrapperPass11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module$IR /*&*/ M)/* override*/ {
    Result.reset(GlobalsAAResult.analyzeModule(M, this.<TargetLibraryInfoWrapperPass>getAnalysis(TargetLibraryInfoWrapperPass.class).getTLI(), 
            this.<CallGraphWrapperPass>getAnalysis(CallGraphWrapperPass.class).getCallGraph()));
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 971,
   FQN="llvm::GlobalsAAWrapperPass::doFinalization", NM="_ZN4llvm20GlobalsAAWrapperPass14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm20GlobalsAAWrapperPass14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module$IR /*&*/ M)/* override*/ {
    Result.reset();
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 976,
   FQN="llvm::GlobalsAAWrapperPass::getAnalysisUsage", NM="_ZNK4llvm20GlobalsAAWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZNK4llvm20GlobalsAAWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    AU.<CallGraphWrapperPass>addRequired(CallGraphWrapperPass.class);
    AU.<TargetLibraryInfoWrapperPass>addRequired(TargetLibraryInfoWrapperPass.class);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAWrapperPass::~GlobalsAAWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 132,
   FQN="llvm::GlobalsAAWrapperPass::~GlobalsAAWrapperPass", NM="_ZN4llvm20GlobalsAAWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm20GlobalsAAWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Result.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<GlobalsAAWrapperPass> ID = GlobalsAAWrapperPass.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
