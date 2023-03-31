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

package serialization.impl;

import org.clang.basic.FileEntry;
import org.clang.lex.HeaderFileInfo;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.llvm.adt.Optional;
import org.llvm.support.OnDiskChainedHashTable;
import serialization.ModuleFile;
import serialization.java.SerializationFunctionPointers.ModuleFile$Ref2Bool;

/// \brief Visitor used to search for information about a header file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5100,
 FQN="(anonymous namespace)::HeaderFileInfoVisitor", NM="_ZN12_GLOBAL__N_121HeaderFileInfoVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_121HeaderFileInfoVisitorE")
//</editor-fold>
public class HeaderFileInfoVisitor implements ModuleFile$Ref2Bool, Destructors.ClassWithDestructor {
  private /*const*/ FileEntry /*P*/ FE;
  
  private Optional<HeaderFileInfo> HFI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoVisitor::HeaderFileInfoVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5106,
   FQN="(anonymous namespace)::HeaderFileInfoVisitor::HeaderFileInfoVisitor", NM="_ZN12_GLOBAL__N_121HeaderFileInfoVisitorC1EPKN5clang9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_121HeaderFileInfoVisitorC1EPKN5clang9FileEntryE")
  //</editor-fold>
  public /*explicit*/ HeaderFileInfoVisitor(/*const*/ FileEntry /*P*/ FE) {
    // : FE(FE), HFI() 
    //START JInit
    this.FE = FE;
    this.HFI = new Optional<HeaderFileInfo>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoVisitor::operator()">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5109,
   FQN="(anonymous namespace)::HeaderFileInfoVisitor::operator()", NM="_ZN12_GLOBAL__N_121HeaderFileInfoVisitorclERN5clang13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_121HeaderFileInfoVisitorclERN5clang13serialization10ModuleFileE")
  //</editor-fold>
  public boolean $call(final ModuleFile /*&*/ M) {
    OnDiskChainedHashTable<FileEntry, HeaderFileInfoTrait.key_type, HeaderFileInfo> /*P*/ Table = ((/*static_cast*/OnDiskChainedHashTable<FileEntry, HeaderFileInfoTrait.key_type, HeaderFileInfo> /*P*/ )(M.HeaderFileInfoTable));
    if (!(Table != null)) {
      return false;
    }
    
    // Look in the on-disk hash table for an entry for this file name.
//    OnDiskChainedHashTable.iterator<FileEntry, HeaderFileInfoTrait.key_type, HeaderFileInfo> Pos = Table.find(FE);
//    if (Pos.$eq(Table.end())) {
//      return false;
//    }
    HeaderFileInfo Pos = Table.$get(FE);
    if (Pos == null) {
      return false;
    }
    
    HFI.$assign_T$RR(Pos/*.$star()*/);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoVisitor::getHeaderFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5124,
   FQN="(anonymous namespace)::HeaderFileInfoVisitor::getHeaderFileInfo", NM="_ZNK12_GLOBAL__N_121HeaderFileInfoVisitor17getHeaderFileInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_121HeaderFileInfoVisitor17getHeaderFileInfoEv")
  //</editor-fold>
  public Optional<HeaderFileInfo> getHeaderFileInfo() /*const*/ {
    return new Optional<HeaderFileInfo>(HFI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoVisitor::~HeaderFileInfoVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5100,
   FQN="(anonymous namespace)::HeaderFileInfoVisitor::~HeaderFileInfoVisitor", NM="_ZN12_GLOBAL__N_121HeaderFileInfoVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_121HeaderFileInfoVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    HFI.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "FE=" + FE // NOI18N
              + ", HFI=" + HFI; // NOI18N
  }
}
