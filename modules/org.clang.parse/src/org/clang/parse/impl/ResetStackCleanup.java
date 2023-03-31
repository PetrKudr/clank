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

import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clank.support.NativeTrace;
import org.llvm.support.CrashRecoveryContext;
import org.llvm.support.CrashRecoveryContextCleanupBase;
import org.llvm.support.llvm;


/// Resets LLVM's pretty stack state so that stack traces are printed correctly
/// when there are nested CrashRecoveryContexts and the inner one recovers from
/// a crash.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResetStackCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 35,
 FQN="(anonymous namespace)::ResetStackCleanup", NM="_ZN12_GLOBAL__N_117ResetStackCleanupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_117ResetStackCleanupE")
//</editor-fold>
public class ResetStackCleanup extends /*public*/ CrashRecoveryContextCleanupBase<ResetStackCleanup, /*const*/Object> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResetStackCleanup::ResetStackCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 39,
   FQN="(anonymous namespace)::ResetStackCleanup::ResetStackCleanup", NM="_ZN12_GLOBAL__N_117ResetStackCleanupC1EPN4llvm20CrashRecoveryContextEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_117ResetStackCleanupC1EPN4llvm20CrashRecoveryContextEPKv")
  //</editor-fold>
  public ResetStackCleanup(CrashRecoveryContext /*P*/ Context, /*const*/Object/*void P*/ Top) {
    // : CrashRecoveryContextCleanupBase<ResetStackCleanup, const void>(Context, Top) 
    //START JInit
    super(Context, Top);
    //END JInit
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ResetStackCleanup() {
    super(null, null);
    NativeTrace.traceNotImplemented("ResetStackCleanup.ResetStackCleanup");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResetStackCleanup::recoverResources">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 42,
   FQN="(anonymous namespace)::ResetStackCleanup::recoverResources", NM="_ZN12_GLOBAL__N_117ResetStackCleanup16recoverResourcesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_117ResetStackCleanup16recoverResourcesEv")
  //</editor-fold>
  @Override public void recoverResources()/* override*/ {
    llvm.RestorePrettyStackState(resource);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResetStackCleanup::~ResetStackCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 35,
   FQN="(anonymous namespace)::ResetStackCleanup::~ResetStackCleanup", NM="_ZN12_GLOBAL__N_117ResetStackCleanupD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_117ResetStackCleanupD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
