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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.llvm.adt.*;

/// A utility for appending two IdentifierIterators.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIdentifierIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7062,
 FQN="(anonymous namespace)::ChainedIdentifierIterator", NM="_ZN12_GLOBAL__N_125ChainedIdentifierIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_125ChainedIdentifierIteratorE")
//</editor-fold>
public class ChainedIdentifierIterator extends /*public*/ IdentifierIterator implements Destructors.ClassWithDestructor {
  private std.unique_ptr<IdentifierIterator> Current;
  private std.unique_ptr<IdentifierIterator> Queued;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIdentifierIterator::ChainedIdentifierIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7067,
   FQN="(anonymous namespace)::ChainedIdentifierIterator::ChainedIdentifierIterator", NM="_ZN12_GLOBAL__N_125ChainedIdentifierIteratorC1ESt10unique_ptrIN5clang18IdentifierIteratorESt14default_deleteIS3_EES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_125ChainedIdentifierIteratorC1ESt10unique_ptrIN5clang18IdentifierIteratorESt14default_deleteIS3_EES6_")
  //</editor-fold>
  public ChainedIdentifierIterator(std.unique_ptr<IdentifierIterator> First, 
      std.unique_ptr<IdentifierIterator> Second) {
    // : IdentifierIterator(), Current(std::move(First)), Queued(std::move(Second)) 
    //START JInit
    super();
    this.Current = new std.unique_ptr<IdentifierIterator>(JD$Move.INSTANCE, std.move(First));
    this.Queued = new std.unique_ptr<IdentifierIterator>(JD$Move.INSTANCE, std.move(Second));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIdentifierIterator::Next">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7071,
   FQN="(anonymous namespace)::ChainedIdentifierIterator::Next", NM="_ZN12_GLOBAL__N_125ChainedIdentifierIterator4NextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_125ChainedIdentifierIterator4NextEv")
  //</editor-fold>
  @Override public StringRef Next()/* override*/ {
    if (!Current.$bool()) {
      return new StringRef();
    }
    
    StringRef result = Current.$arrow().Next();
    if (!result.empty()) {
      return result;
    }
    
    // Try the queued iterator, which may itself be empty.
    Current.reset();
    std.swap(Current, Queued);
    return Next();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIdentifierIterator::~ChainedIdentifierIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7062,
   FQN="(anonymous namespace)::ChainedIdentifierIterator::~ChainedIdentifierIterator", NM="_ZN12_GLOBAL__N_125ChainedIdentifierIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_125ChainedIdentifierIteratorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Queued.$destroy();
    Current.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Current=" + Current // NOI18N
              + ", Queued=" + Queued // NOI18N
              + super.toString(); // NOI18N
  }
}
