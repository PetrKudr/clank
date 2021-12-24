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
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.DependenceAnalysisStatics.dumpExampleDependence;

// class DependenceAnalysis

/// \brief Legacy pass manager pass to access dependence information
//<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 939,
 FQN="llvm::DependenceAnalysisWrapperPass", NM="_ZN4llvm29DependenceAnalysisWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm29DependenceAnalysisWrapperPassE")
//</editor-fold>
public class DependenceAnalysisWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0); // Class identification, replacement for typeinfo
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::DependenceAnalysisWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 942,
   FQN="llvm::DependenceAnalysisWrapperPass::DependenceAnalysisWrapperPass", NM="_ZN4llvm29DependenceAnalysisWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm29DependenceAnalysisWrapperPassC1Ev")
  //</editor-fold>
  public DependenceAnalysisWrapperPass() {
    // : FunctionPass(ID), info() 
    //START JInit
    super(ID);
    this.info = new std.unique_ptr<DependenceInfo>();
    //END JInit
    DependenceAnalysisLlvmStatics.initializeDependenceAnalysisWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 141,
   FQN="llvm::DependenceAnalysisWrapperPass::runOnFunction", NM="_ZN4llvm29DependenceAnalysisWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm29DependenceAnalysisWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    final AAResults /*&*/ AA = this.<AAResultsWrapperPass>getAnalysis(AAResultsWrapperPass.class).getAAResults();
    final ScalarEvolution /*&*/ SE = this.<ScalarEvolutionWrapperPass>getAnalysis(ScalarEvolutionWrapperPass.class).getSE();
    final LoopInfo /*&*/ LI = this.<LoopInfoWrapperPass>getAnalysis(LoopInfoWrapperPass.class).getLoopInfo();
    info.reset(new DependenceInfo($AddrOf(F), $AddrOf(AA), $AddrOf(SE), $AddrOf(LI)));
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 151,
   FQN="llvm::DependenceAnalysisWrapperPass::releaseMemory", NM="_ZN4llvm29DependenceAnalysisWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm29DependenceAnalysisWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    info.reset();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 153,
   FQN="llvm::DependenceAnalysisWrapperPass::getAnalysisUsage", NM="_ZNK4llvm29DependenceAnalysisWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm29DependenceAnalysisWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    AU.<AAResultsWrapperPass>addRequiredTransitive(AAResultsWrapperPass.class);
    AU.<ScalarEvolutionWrapperPass>addRequiredTransitive(ScalarEvolutionWrapperPass.class);
    AU.<LoopInfoWrapperPass>addRequiredTransitive(LoopInfoWrapperPass.class);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 192,
   FQN="llvm::DependenceAnalysisWrapperPass::print", NM="_ZNK4llvm29DependenceAnalysisWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm29DependenceAnalysisWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    print(OS, 
       (/*const*/ Module$IR /*P*/ )null);
  }
  @Override public void print(final raw_ostream /*&*/ OS, 
       /*const*/ Module$IR /*P*/ $Prm1/*= null*/) /*const*//* override*/ {
    dumpExampleDependence(OS, info.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::getDI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 149,
   FQN="llvm::DependenceAnalysisWrapperPass::getDI", NM="_ZNK4llvm29DependenceAnalysisWrapperPass5getDIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm29DependenceAnalysisWrapperPass5getDIEv")
  //</editor-fold>
  public DependenceInfo /*&*/ getDI() /*const*/ {
    return info.$star();
  }

/*private:*/
  private std.unique_ptr<DependenceInfo> info;
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceAnalysisWrapperPass::~DependenceAnalysisWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 939,
   FQN="llvm::DependenceAnalysisWrapperPass::~DependenceAnalysisWrapperPass", NM="_ZN4llvm29DependenceAnalysisWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm29DependenceAnalysisWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    info.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<DependenceAnalysisWrapperPass> ID = DependenceAnalysisWrapperPass.class; // Class identification, replacement for typeinfo

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "info=" + info // NOI18N
              + super.toString(); // NOI18N
  }
}
