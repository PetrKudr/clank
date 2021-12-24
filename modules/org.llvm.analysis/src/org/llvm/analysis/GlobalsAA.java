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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.ir.*;
import org.llvm.analysis.target.*;
import org.llvm.ir.java.IPassModule;


/// Analysis pass providing a never-invalidated alias analysis result.
//<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 121,
 FQN="llvm::GlobalsAA", NM="_ZN4llvm9GlobalsAAE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm9GlobalsAAE")
//</editor-fold>
public class GlobalsAA implements /*public*/ AnalysisInfoMixin<GlobalsAA>, IPassModule<GlobalsAAResult> {
  /*friend  AnalysisInfoMixin<GlobalsAA>*/
  // JAVA: moved to extra/*private*/ static /*char*/byte PassID;
/*public:*/
  // JAVA: typedef GlobalsAAResult Result
//  public final class Result extends GlobalsAAResult{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAA::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 942,
   FQN="llvm::GlobalsAA::run", NM="_ZN4llvm9GlobalsAA3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm9GlobalsAA3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public GlobalsAAResult run(final Module$IR /*&*/ M, final AnalysisManager<Module$IR> /*&*/ AM) {
    return GlobalsAAResult.analyzeModule(M, 
        AM.getResult(TargetLibraryAnalysis.class, M), 
        AM.getResult(CallGraphAnalysis.class, M));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAA::GlobalsAA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 121,
   FQN="llvm::GlobalsAA::GlobalsAA", NM="_ZN4llvm9GlobalsAAC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm9GlobalsAAC1EOS0_")
  //</editor-fold>
  public /*inline*/ GlobalsAA(JD$Move _dparam, final GlobalsAA /*&&*/$Prm0) {
    // : AnalysisInfoMixin<GlobalsAA>(static_cast<GlobalsAA &&>()) 
    //START JInit
    $AnalysisInfoMixin(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static Class<GlobalsAA> PassID = GlobalsAA.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
