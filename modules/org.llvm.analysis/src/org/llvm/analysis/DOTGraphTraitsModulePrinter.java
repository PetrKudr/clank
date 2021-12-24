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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.support.sys.fs;

/*template <typename AnalysisT, bool IsSimple, typename GraphT = AnalysisT *, typename AnalysisGraphTraitsT = DefaultAnalysisGraphTraits<AnalysisT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraitsModulePrinter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DOTGraphTraitsPass.h", line = 151,
 FQN="llvm::DOTGraphTraitsModulePrinter", NM="_ZN4llvm27DOTGraphTraitsModulePrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm27DOTGraphTraitsModulePrinterE")
//</editor-fold>
public class DOTGraphTraitsModulePrinter</*typename*/ AnalysisT extends ModulePass, /*typename*/ GraphT/* = AnalysisT **/, /*typename*/ AnalysisGraphTraitsT extends DefaultAnalysisGraphTraits<AnalysisT,GraphT>>  extends /*public*/ ModulePass implements Destructors.ClassWithDestructor {
  /*template parameter*/ private final boolean IsSimple;

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraitsModulePrinter::DOTGraphTraitsModulePrinter<AnalysisT, IsSimple, GraphT, AnalysisGraphTraitsT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DOTGraphTraitsPass.h", line = 156,
   FQN="llvm::DOTGraphTraitsModulePrinter::DOTGraphTraitsModulePrinter<AnalysisT, IsSimple, GraphT, AnalysisGraphTraitsT>", NM="_ZN4llvm27DOTGraphTraitsModulePrinterC1ENS_9StringRefERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm27DOTGraphTraitsModulePrinterC1ENS_9StringRefERc")
  //</editor-fold>
  public DOTGraphTraitsModulePrinter(Class<AnalysisT> cls, AnalysisGraphTraitsT $Traits, boolean IsSimple, StringRef GraphName, final Class<? extends DOTGraphTraitsModulePrinter>/*char &*/ ID) {
    // : ModulePass(ID), Name(GraphName.operator basic_string()) 
    //START JInit
    /*ParenListExpr*/super(ID);
    /*template parameter*/ this.cls = cls;
    /*template parameter*/ this.$Traits = $Traits;
    /*template parameter*/ this.IsSimple = IsSimple;
    this.Name = GraphName.$string();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraitsModulePrinter::runOnModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DOTGraphTraitsPass.h", line = 159,
   FQN="llvm::DOTGraphTraitsModulePrinter::runOnModule", NM="_ZN4llvm27DOTGraphTraitsModulePrinter11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm27DOTGraphTraitsModulePrinter11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module$IR /*&*/ M)/* override*/ {
    raw_fd_ostream File = null;
    try {
      GraphT Graph = $Traits.getGraph($AddrOf(getAnalysis(cls)));
      std.string Filename = Name.append($(".dot"));
      std.error_code EC/*J*/= new std.error_code();
      
      errs().$out(/*KEEP_STR*/"Writing '").$out(Filename).$out(/*KEEP_STR*/"'...");
      
      File/*J*/= new raw_fd_ostream(new StringRef(Filename), EC, fs.OpenFlags.F_Text);
      std.string Title = DOTGraphTraits.<GraphT>getGraphName(Graph);
      if (!EC.$bool()) {
        AdtsupportLlvmGlobals.WriteGraph(File, Graph, IsSimple, new Twine(Title));
      } else {
        errs().$out(/*KEEP_STR*/"  error opening file for writing!");
      }
      errs().$out(/*KEEP_STR*/$LF);
      
      return false;
    } finally {
      if (File != null) { File.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraitsModulePrinter::getAnalysisUsage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DOTGraphTraitsPass.h", line = 178,
   FQN="llvm::DOTGraphTraitsModulePrinter::getAnalysisUsage", NM="_ZNK4llvm27DOTGraphTraitsModulePrinter16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm27DOTGraphTraitsModulePrinter16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    AU.<AnalysisT>addRequired(cls);
  }

/*private:*/
  private std.string Name;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final Class<AnalysisT> cls;
  private final AnalysisGraphTraitsT $Traits;
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + super.toString(); // NOI18N
  }
}
