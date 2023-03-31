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

import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.aliases.type$ptr;
import org.clank.support.literal_constants;
import org.llvm.adt.StringRef;
import org.llvm.support.llvm;
import serialization.aliases.ContinuousRangeMapUIntInt;

import static org.clank.support.Native.$eq_ptr;
import static org.clank.support.Native.$tryClone;


//<editor-fold defaultstate="collapsed" desc="static type ModuleStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.serialization.impl.ModuleStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=Tpl__ZL14dumpLocalRemapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_T0_XT1_EEE; -static-type=ModuleStatics -package=org.clang.serialization.impl")
//</editor-fold>
public final class ModuleStatics {

  //template <typename Key = unsigned int, typename Offset = int, unsigned int InitialCapacity = 2> 
  //<editor-fold defaultstate="collapsed" desc="dumpLocalRemap">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp", line = 52,
   FQN="dumpLocalRemap", NM="_ZL14dumpLocalRemapIjiLj2EEvN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_T0_XT1_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZL14dumpLocalRemapIjiLj2EEvN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_T0_XT1_EEE")
  //</editor-fold>
  public static void dumpLocalRemap(StringRef Name, 
                final /*const*/ ContinuousRangeMapUIntInt /*&*/ Map) {
    if ($eq_ptr(Map.begin$Const(), Map.end$Const())) {
      return;
    }

    // JAVA: typedef ContinuousRangeMap<unsigned int, int, InitialCapacityU> MapType
  //  final class MapType extends ContinuousRangeMap/*<InitialCapacity</*uint*/int, int>/*U*/>*/{ };
    llvm.errs().$out(/*KEEP_STR*/"  ").$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/literal_constants.$COLON_LF);
    for (type$ptr</*const*/std.pairUIntInt /*P*/> I = $tryClone(Map.begin$Const()), /*P*/ IEnd = $tryClone(Map.end$Const());
         Native.$noteq_ptr(I, IEnd); I.$preInc()) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(I./*->*/$star().first).$out(/*KEEP_STR*/" -> ").$out_int(I./*->*/$star().second).$out(/*KEEP_STR*/literal_constants.$LF);
    }
  }
//  /*template <typename Key, typename Offset, unsigned int InitialCapacity> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="dumpLocalRemap">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp", line = 52,
//   FQN="dumpLocalRemap", NM="Tpl__ZL14dumpLocalRemapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_T0_XT1_EEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=Tpl__ZL14dumpLocalRemapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_T0_XT1_EEE")
//  //</editor-fold>
//  public static </*typename*/ Key, /*typename*/ Offset> void dumpLocalRemap(/*uint*/int InitialCapacity, StringRef Name, 
//                final /*const*/ ContinuousRangeMap<Key, Offset>/*<InitialCapacity>*/ /*&*/ Map) {
//    if (Native.$eq(Map.begin(), Map.end())) {
//      return;
//    }
//
//    // JAVA: typedef ContinuousRangeMap<Key, Offset, InitialCapacity> MapType
//  //  final class MapType extends ContinuousRangeMap<Key, Offset>/*<InitialCapacity>*/{ };
//    llvm.errs().$out(/*KEEP_STR*/"  ").$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/$COLON_LF);
//    for ( ContinuousRangeMap*/.const_iterator<Key, Offset>/*<InitialCapacity> I = Map.begin(), IEnd = Map.end();
//         Native.$noteq(I, IEnd); I.$preInc()) {
//      Native.$out(Native.$out(Native.$out(Native.$out(llvm.errs().$out(/*KEEP_STR*/"    "), I.first), $(" -> ")), I.second), $LF);
//    }
//  }

} // END OF class ModuleStatics
