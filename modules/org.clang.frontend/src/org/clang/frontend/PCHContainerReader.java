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

import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.llvm.adt.StringRef;
import org.llvm.bitcode.BitstreamReader;
import org.llvm.support.MemoryBufferRef;
import org.clang.serialization.spi.PCHContainerReaderImplementation;


/// This abstract interface provides operations for unwrapping
/// containers for serialized ASTs (precompiled headers and clang
/// modules).
//<editor-fold defaultstate="collapsed" desc="clang::PCHContainerReader">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*command for this file is absent*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 60,
 FQN="clang::PCHContainerReader", NM="_ZN5clang18PCHContainerReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN5clang18PCHContainerReaderE")
//</editor-fold>
public abstract class PCHContainerReader implements PCHContainerReaderImplementation, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerReader::~PCHContainerReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", line = 24,
   FQN="clang::PCHContainerReader::~PCHContainerReader", NM="_ZN5clang18PCHContainerReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN5clang18PCHContainerReaderD0Ev")
  //</editor-fold>
  public abstract void $destroy()/* = 0*/;
  /// Equivalent to the format passed to -fmodule-format=
  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerReader::getFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 64,
   FQN="clang::PCHContainerReader::getFormat", NM="_ZNK5clang18PCHContainerReader9getFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZNK5clang18PCHContainerReader9getFormatEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getFormat() /*const*//* = 0*/;

  
  /// Initialize an llvm::BitstreamReader with the serialized AST inside
  /// the PCH container Buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerReader::ExtractPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 68,
   FQN="clang::PCHContainerReader::ExtractPCH", NM="_ZNK5clang18PCHContainerReader10ExtractPCHEN4llvm15MemoryBufferRefERNS1_15BitstreamReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZNK5clang18PCHContainerReader10ExtractPCHEN4llvm15MemoryBufferRefERNS1_15BitstreamReaderE")
  //</editor-fold>
  public abstract /*virtual*/ void ExtractPCH(MemoryBufferRef Buffer, 
            BitstreamReader /*&*/ StreamFile) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerReader::PCHContainerReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 60,
   FQN="clang::PCHContainerReader::PCHContainerReader", NM="_ZN5clang18PCHContainerReaderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN5clang18PCHContainerReaderC1Ev")
  //</editor-fold>
  public /*inline*/ PCHContainerReader() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
