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
package org.clang.codegen.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.Module$IR;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;


//<editor-fold defaultstate="collapsed" desc="static type CGCUDABuiltinStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDABuiltin.cpp -nm=_ZL21GetVprintfDeclarationRN4llvm6ModuleE; -static-type=CGCUDABuiltinStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGCUDABuiltinStatics {

//<editor-fold defaultstate="collapsed" desc="GetVprintfDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDABuiltin.cpp", line = 24,
 FQN="GetVprintfDeclaration", NM="_ZL21GetVprintfDeclarationRN4llvm6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDABuiltin.cpp -nm=_ZL21GetVprintfDeclarationRN4llvm6ModuleE")
//</editor-fold>
public static Function /*P*/ GetVprintfDeclaration(final Module$IR /*&*/ M) {
  Type /*P*/ ArgTypes[/*2*/] = new Type /*P*/  [/*2*/] {
    Type.getInt8PtrTy(M.getContext()), 
    Type.getInt8PtrTy(M.getContext())};
  FunctionType /*P*/ VprintfFuncType = FunctionType.get(Type.getInt32Ty(M.getContext()), new ArrayRef<Type /*P*/ >(ArgTypes, true), false);
  {
    
    Function /*P*/ F = M.getFunction(new StringRef(/*KEEP_STR*/"vprintf"));
    if ((F != null)) {
      // Our CUDA system header declares vprintf with the right signature, so
      // nobody else should have been able to declare vprintf with a bogus
      // signature.
      assert (F.getFunctionType() == VprintfFuncType);
      return F;
    }
  }
  
  // vprintf doesn't already exist; create a declaration and insert it into the
  // module.
  return Function.Create(VprintfFuncType, GlobalVariable.LinkageTypes.ExternalLinkage, new Twine(/*KEEP_STR*/"vprintf"), /*AddrOf*/M);
}

} // END OF class CGCUDABuiltinStatics
