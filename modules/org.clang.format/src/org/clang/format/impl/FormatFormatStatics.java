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
package org.clang.format.impl;

import org.clang.format.*;
import static org.clang.format.impl.FormatStatics.*;
import org.clang.tooling.core.*;
import org.clank.java.*;
import org.clank.java.std.Compare;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.$$LF;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.FormatFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE;_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE;_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE;_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE;_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj;_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj;_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE;_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj;_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE; -static-type=FormatFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class FormatFormatStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::expandPresets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 439,
 FQN="clang::format::expandPresets", NM="_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE")
//</editor-fold>
public static FormatStyle expandPresets(final /*const*/ FormatStyle /*&*/ Style) {
  if (Style.BreakBeforeBraces == FormatStyle.BraceBreakingStyle.BS_Custom) {
    return new FormatStyle(Style);
  }
  FormatStyle Expanded = new FormatStyle(Style);
  Expanded.BraceWrapping.$assignMove(new FormatStyle.BraceWrappingFlags(
        false, false, false, false, false, false,
        false, false, false, false, false));
  switch (Style.BreakBeforeBraces) {
   case BS_Linux:
    Expanded.BraceWrapping.AfterClass = true;
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.AfterNamespace = true;
    break;
   case BS_Mozilla:
    Expanded.BraceWrapping.AfterClass = true;
    Expanded.BraceWrapping.AfterEnum = true;
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.AfterStruct = true;
    Expanded.BraceWrapping.AfterUnion = true;
    break;
   case BS_Stroustrup:
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.BeforeCatch = true;
    Expanded.BraceWrapping.BeforeElse = true;
    break;
   case BS_Allman:
    Expanded.BraceWrapping.AfterClass = true;
    Expanded.BraceWrapping.AfterControlStatement = true;
    Expanded.BraceWrapping.AfterEnum = true;
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.AfterNamespace = true;
    Expanded.BraceWrapping.AfterObjCDeclaration = true;
    Expanded.BraceWrapping.AfterStruct = true;
    Expanded.BraceWrapping.BeforeCatch = true;
    Expanded.BraceWrapping.BeforeElse = true;
    break;
   case BS_GNU:
    Expanded.BraceWrapping.$assignMove(new FormatStyle.BraceWrappingFlags(
          true, true, true, true, true, true,
          true, true, true, true, true));
    break;
   case BS_WebKit:
    Expanded.BraceWrapping.AfterFunction = true;
    break;
   default:
    break;
  }
  return Expanded;
}

// end anonymous namespace

// Determines whether 'Ranges' intersects with ('Start', 'End').
//<editor-fold defaultstate="collapsed" desc="clang::format::affectsRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1203,
 FQN="clang::format::affectsRange", NM="_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj")
//</editor-fold>
public static boolean affectsRange(ArrayRef<Range> Ranges, /*uint*/int Start,
            /*uint*/int End) {
  for (Range $Range : Ranges) {
    if ($less_uint($Range.getOffset(), End)
       && $greater_uint($Range.getOffset() + $Range.getLength(), Start)) {
      return true;
    }
  }
  return false;
}


// Sorts a block of includes given by 'Includes' alphabetically adding the
// necessary replacement to 'Replaces'. 'Includes' must be in strict source
// order.
//<editor-fold defaultstate="collapsed" desc="clang::format::sortCppIncludes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1216,
 FQN="clang::format::sortCppIncludes", NM="_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj")
//</editor-fold>
public static void sortCppIncludes(final /*const*/ FormatStyle /*&*/ Style,
               final /*const*/ SmallVectorImpl<IncludeDirective> /*&*/ Includes,
               ArrayRef<Range> Ranges, StringRef FileName,
               final std.setType<Replacement> /*&*/ Replaces, uint$ptr/*uint P*/ Cursor) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!affectsRange(new ArrayRef<Range>(Ranges), Includes.front$Const().Offset,
        Includes.back$Const().Offset + Includes.back$Const().Text.size())) {
      return;
    }
    SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
    for (/*uint*/int i = 0, e = Includes.size(); i != e; ++i)  {
      Indices.push_back(i);
    }
    Compare<Integer> comparator = new Compare<Integer>(){
      @Override
      public boolean compare(/*uint*/ Integer LHSI, /*uint*/ Integer RHSI) {
        int res = Includes.$at$Const(LHSI).Category - Includes.$at$Const(RHSI).Category;
        if (res < 0) {
          return true;
        }
        if (res == 0) {
          res = Includes.$at$Const(LHSI).Filename.compare(Includes.$at$Const(RHSI).Filename);
          if (res < 0) {
            return true;
          }
          if (res == 0) {
            return Includes.$at$Const(LHSI).Offset < Includes.$at$Const(RHSI).Offset;
          }
        }
        return false;
      }
    };
    std.stable_sort(Indices.begin(), Indices.end(), comparator);

    // If the #includes are out of order, we generate a single replacement fixing
    // the entire block. Otherwise, no replacement is generated.
    if (std.is_sorted(Indices.begin(), Indices.end())) {
      return;
    }

    std.string result/*J*/= new std.string();
    boolean CursorMoved = false;
    for (/*uint*/int Index : Indices) {
      if (!result.empty()) {
        result.$addassign_T$C$P(/*KEEP_STR*/"\n");
      }
      $addassign_string_StringRef(result, /*NO_COPY*/Includes.$at$Const(Index).Text);
      if (Native.$bool(Cursor) && !CursorMoved) {
        /*uint*/int Start = Includes.$at$Const(Index).Offset;
        /*uint*/int End = Start + Includes.$at$Const(Index).Text.size();
        if ($greatereq_uint(Cursor.$star(), Start) && $less_uint(Cursor.$star(), End)) {
          Cursor.$set(Includes.front$Const().Offset + result.size() + Cursor.$star() - End);
          CursorMoved = true;
        }
      }
    }

    // Sorting #includes shouldn't change their total number of characters.
    // This would otherwise mess up 'Ranges'.
    assert (result.size() == Includes.back$Const().Offset + Includes.back$Const().Text.size() - Includes.front$Const().Offset);

    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(new StringRef(FileName), Includes.front$Const().Offset,
            result.size(), new StringRef(result)))));
  } finally {
    $c$.$destroy();
  }
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::format::sortCppIncludes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1323,
 FQN="clang::format::sortCppIncludes", NM="_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj")
//</editor-fold>
public static std.setType<Replacement> sortCppIncludes(final /*const*/ FormatStyle /*&*/ Style, StringRef Code,
               ArrayRef<Range> Ranges,
               StringRef FileName,
               final std.setType<Replacement> /*&*/ Replaces,
               uint$ptr/*uint P*/ Cursor) {
  Regex IncludeRegex = null;
  IncludeCategoryManager Categories = null;
  try {
    /*uint*/int Prev = 0;
    /*uint*/int SearchFrom = 0;
    IncludeRegex/*J*/= new Regex(new StringRef(IncludeRegexPattern));
    SmallVector<StringRef> Matches/*J*/= new SmallVector<StringRef>(4, new StringRef());
    SmallVector<IncludeDirective> IncludesInBlock/*J*/= new SmallVector<IncludeDirective>(16, new IncludeDirective());

    // In compiled files, consider the first #include to be the main #include of
    // the file if it is not a system #include. This ensures that the header
    // doesn't have hidden dependencies
    // (http://llvm.org/docs/CodingStandards.html#include-style).
    //
    // FIXME: Do some sanity checking, e.g. edit distance of the base name, to fix
    // cases where the first #include is unlikely to be the main header.
    Categories/*J*/= new IncludeCategoryManager(Style, new StringRef(FileName));
    boolean FirstIncludeBlock = true;
    boolean MainIncludeFound = false;
    boolean FormattingOff = false;

    for (;;) {
      /*size_t*/int Pos = Code.find($$LF, SearchFrom);
      StringRef Line = Code.substr(Prev, (Pos != StringRef.npos ? Pos : Code.size()) - Prev);

      StringRef Trimmed = Line.trim();
      if ($eq_StringRef(/*NO_COPY*/Trimmed, /*STRINGREF_STR*/"// clang-format off")) {
        FormattingOff = true;
      } else if ($eq_StringRef(/*NO_COPY*/Trimmed, /*STRINGREF_STR*/"// clang-format on")) {
        FormattingOff = false;
      }
      if (!FormattingOff && !Line.endswith(/*STRINGREF_STR*/"\\")) {
        if (IncludeRegex.match(/*NO_COPY*/Line, /*AddrOf*/Matches)) {
          StringRef IncludeName = new StringRef(Matches.$at(2));
          int Category = Categories.getIncludePriority(new StringRef(IncludeName),
              /*CheckMainHeader=*/ !MainIncludeFound && FirstIncludeBlock);
          if (Category == 0) {
            MainIncludeFound = true;
          }
          IncludesInBlock.push_back(new IncludeDirective(IncludeName, Line, Prev, Category));
        } else if (!IncludesInBlock.empty()) {
          sortCppIncludes(Style, IncludesInBlock, new ArrayRef<Range>(Ranges), new StringRef(FileName), Replaces,
              Cursor);
          IncludesInBlock.clear();
          FirstIncludeBlock = false;
        }
        Prev = Pos + 1;
      }
      if (Pos == StringRef.npos || Pos + 1 == Code.size()) {
        break;
      }
      SearchFrom = Pos + 1;
    }
    if (!IncludesInBlock.empty()) {
      sortCppIncludes(Style, IncludesInBlock, new ArrayRef<Range>(Ranges), new StringRef(FileName), Replaces, Cursor);
    }
    return new std.setType<Replacement>(Replaces);
  } finally {
    if (Categories != null) { Categories.$destroy(); }
    if (IncludeRegex != null) { IncludeRegex.$destroy(); }
  }
  }

} // END OF class FormatFormatStatics
