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

import org.clang.basic.OpenMPDirectiveKind;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.Unsigned;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPDirectiveKindEx">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 30,
 FQN="(anonymous namespace)::OpenMPDirectiveKindEx", NM="_ZN12_GLOBAL__N_121OpenMPDirectiveKindExE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_121OpenMPDirectiveKindExE")
//</editor-fold>
public enum OpenMPDirectiveKindEx implements Native.ComparableLower {
  OMPD_cancellation(OpenMPDirectiveKind.OMPD_unknown.getValue() + 1),
  OMPD_data(OMPD_cancellation.getValue() + 1),
  OMPD_declare(OMPD_data.getValue() + 1),
  OMPD_end(OMPD_declare.getValue() + 1),
  OMPD_end_declare(OMPD_end.getValue() + 1),
  OMPD_enter(OMPD_end_declare.getValue() + 1),
  OMPD_exit(OMPD_enter.getValue() + 1),
  OMPD_point(OMPD_exit.getValue() + 1),
  OMPD_reduction(OMPD_point.getValue() + 1),
  OMPD_target_enter(OMPD_reduction.getValue() + 1),
  OMPD_target_exit(OMPD_target_enter.getValue() + 1),
  OMPD_update(OMPD_target_exit.getValue() + 1),
  OMPD_distribute_parallel(OMPD_update.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OpenMPDirectiveKindEx valueOf(int val) {
    OpenMPDirectiveKindEx out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OpenMPDirectiveKindEx[] VALUES;
    private static final OpenMPDirectiveKindEx[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OpenMPDirectiveKindEx kind : OpenMPDirectiveKindEx.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OpenMPDirectiveKindEx[min < 0 ? (1-min) : 0];
      VALUES = new OpenMPDirectiveKindEx[max >= 0 ? (1+max) : 0];
      for (OpenMPDirectiveKindEx kind : OpenMPDirectiveKindEx.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private OpenMPDirectiveKindEx(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OpenMPDirectiveKindEx)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OpenMPDirectiveKindEx)obj).value);}
  //</editor-fold>
}
