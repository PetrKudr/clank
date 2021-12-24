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

package org.llvm.transforms.utils;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SanitizerStats.h", line = 33,
 FQN="llvm::SanitizerStatReport", NM="_ZN4llvm19SanitizerStatReportE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN4llvm19SanitizerStatReportE")
//</editor-fold>
public class/*struct*/ SanitizerStatReport implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport::SanitizerStatReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp", line = 25,
   FQN="llvm::SanitizerStatReport::SanitizerStatReport", NM="_ZN4llvm19SanitizerStatReportC1EPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp -nm=_ZN4llvm19SanitizerStatReportC1EPNS_6ModuleE")
  //</editor-fold>
  public SanitizerStatReport(Module$IR /*P*/ M) {
    // : M(M), Inits() 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Generates code into B that increments a location-specific counter tagged
  /// with the given sanitizer kind SK.
  
  /// Generates code into B that increments a location-specific counter tagged
  /// with the given sanitizer kind SK.
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp", line = 43,
   FQN="llvm::SanitizerStatReport::create", NM="_ZN4llvm19SanitizerStatReport6createERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEENS_17SanitizerStatKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp -nm=_ZN4llvm19SanitizerStatReport6createERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEENS_17SanitizerStatKindE")
  //</editor-fold>
  public void create(final IRBuilder /*&*/ B, SanitizerStatKind SK) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Finalize module stats array and add global constructor to register it.
  
  /// Finalize module stats array and add global constructor to register it.
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport::finish">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp", line = 72,
   FQN="llvm::SanitizerStatReport::finish", NM="_ZN4llvm19SanitizerStatReport6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp -nm=_ZN4llvm19SanitizerStatReport6finishEv")
  //</editor-fold>
  public void finish() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  private Module$IR /*P*/ M;
  private GlobalVariable /*P*/ ModuleStatsGV;
  private ArrayType /*P*/ StatTy;
  private StructType /*P*/ EmptyModuleStatsTy;
  
  private std.vector<Constant /*P*/ > Inits;
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport::makeModuleStatsArrayTy">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp", line = 33,
   FQN="llvm::SanitizerStatReport::makeModuleStatsArrayTy", NM="_ZN4llvm19SanitizerStatReport22makeModuleStatsArrayTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp -nm=_ZN4llvm19SanitizerStatReport22makeModuleStatsArrayTyEv")
  //</editor-fold>
  private ArrayType /*P*/ makeModuleStatsArrayTy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport::makeModuleStatsTy">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp", line = 37,
   FQN="llvm::SanitizerStatReport::makeModuleStatsTy", NM="_ZN4llvm19SanitizerStatReport17makeModuleStatsTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp -nm=_ZN4llvm19SanitizerStatReport17makeModuleStatsTyEv")
  //</editor-fold>
  private StructType /*P*/ makeModuleStatsTy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerStatReport::~SanitizerStatReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SanitizerStats.h", line = 33,
   FQN="llvm::SanitizerStatReport::~SanitizerStatReport", NM="_ZN4llvm19SanitizerStatReportD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN4llvm19SanitizerStatReportD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", ModuleStatsGV=" + ModuleStatsGV // NOI18N
              + ", StatTy=" + StatTy // NOI18N
              + ", EmptyModuleStatsTy=" + EmptyModuleStatsTy // NOI18N
              + ", Inits=" + Inits; // NOI18N
  }
}
