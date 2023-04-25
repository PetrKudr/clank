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

import java.util.Iterator;
import java.util.function.Supplier;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.format.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.format.impl.EncodingStatics.*;
import org.clang.format.impl.EncodingStatics.Encoding;
import static org.clang.format.impl.FormatStatics.*;
import org.clang.format.java.FormatFunctionPointers.Change2Bool;
import org.clang.format.java.FormatFunctionPointers.FormatStyleStringRefvectorStringRef2Replacements;
import org.clang.format.java.FormatFunctionPointers.FormatToken2FormatToken;
import org.clang.lex.*;
import static org.clang.tooling.ToolingGlobals.applyAllReplacements;
import org.clang.tooling.core.*;
import org.clank.java.*;
import org.clank.java.std.Compare;
import static org.clank.java.std_defines.INT_MAX;
import static org.clank.java.std_defines.UINT_MAX;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$ConvertibleMove;
import org.clank.support.JavaDifferentiators.JD$Initializer_list$_Key_T1$C$R_T2$C$R;
import org.clank.support.JavaDifferentiators.JD$T$C$R_T$RR;
import org.clank.support.JavaDifferentiators.JD$T$RR_T1$RR;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.TypeType2Bool;
import org.clank.support.NativeCallback.Void2Void;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.Error;
import static org.llvm.support.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.FormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=Tpl__ZN5clang6formatL11AlignTokensERKNS0_11FormatStyleEOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE;Tpl__ZN5clang6formatL18AlignTokenSequenceEjjjOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE;Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE;_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE;_ZN5clang6format12_GLOBAL__N_118startsExternCBlockERKNS0_13AnnotatedLineE;_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE;_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_1L13markFinalizedEPNS0_11FormatTokenE;_ZN5clang6format12_GLOBAL__N_1L14printLineStateERKNS0_9LineStateE;_ZN5clang6format12_GLOBAL__N_1L19IncludeRegexPatternE;_ZN5clang6format12_GLOBAL__N_1L23PrecedenceUnaryOperatorE;_ZN5clang6format12_GLOBAL__N_1L24PrecedenceArrowAndPeriodE;_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj;_ZN5clang6format16getTokenTypeNameENS0_9TokenTypeE;_ZN5clang6format21sortJavaScriptImportsERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_;_ZN5clang6formatL11isGoogScopeERKNS0_13UnwrappedLineE;_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj;_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE;_ZN5clang6formatL13isAllmanBraceERKNS0_11FormatTokenE;_ZN5clang6formatL13mustBeJSIdentERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE;_ZN5clang6formatL14getStringSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE;_ZN5clang6formatL14isJSDeclOrStmtERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE;_ZN5clang6formatL14printDebugInfoERKNS0_13UnwrappedLineEN4llvm9StringRefE;_ZN5clang6formatL15getCommentSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE;_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj;_ZN5clang6formatL17CodePointsBetweenEPKNS0_11FormatTokenES3_;_ZN5clang6formatL19startsNextParameterERKNS0_11FormatTokenERKNS0_11FormatStyleE;_ZN5clang6formatL20mustBeJSIdentOrValueERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE;_ZN5clang6formatL20tokenCanStartNewLineERKNS_5TokenE;_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE;_ZN5clang6formatL22ShouldBreakBeforeBraceERKNS0_11FormatStyleERKNS0_11FormatTokenE;_ZN5clang6formatL23getLengthToNextOperatorERKNS0_11FormatTokenE;_ZN5clang6formatL24getLengthToMatchingParenERKNS0_11FormatTokenE;_ZN5clang6formatL25isFunctionDeclarationNameERKNS0_11FormatTokenERKNS0_13AnnotatedLineE;_ZN5clang6formatL26getLineCommentIndentPrefixEN4llvm9StringRefE;_ZN5clang6formatL30startsSegmentOfBuilderTypeCallERKNS0_11FormatTokenE;_ZN5clang6formatL6BlanksE;_ZN5clang6formatL7IsBlankEc;_ZN5clang6formatltERKNS0_17JsModuleReferenceES3_; -static-type=FormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class FormatStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::Blanks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 28,
 FQN="clang::format::Blanks", NM="_ZN5clang6formatL6BlanksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL6BlanksE")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ Blanks = $(" \t\013\014\015");
//<editor-fold defaultstate="collapsed" desc="clang::format::IsBlank">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 29,
 FQN="clang::format::IsBlank", NM="_ZN5clang6formatL7IsBlankEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL7IsBlankEc")
//</editor-fold>
public static boolean IsBlank(/*char*/byte C) {
  switch (C) {
   case ' ':
   case '\t':
   case '\013'/*\v*/:
   case '\f':
   case '\r':
    return true;
   default:
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getCommentSplit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 42,
 FQN="clang::format::getCommentSplit", NM="_ZN5clang6formatL15getCommentSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL15getCommentSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE")
//</editor-fold>
public static std.pairUIntUInt getCommentSplit(StringRef Text,
               /*uint*/int ContentStartColumn,
               /*uint*/int ColumnLimit,
               /*uint*/int TabWidth,
               /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding) {
  if ($lesseq_uint(ColumnLimit, ContentStartColumn + 1)) {
    return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }

  /*uint*/int MaxSplit = ColumnLimit - ContentStartColumn + 1;
  /*uint*/int MaxSplitBytes = 0;

  for (/*uint*/int NumChars = 0;
       $less_uint(NumChars, MaxSplit) && $less_uint(MaxSplitBytes, Text.size());) {
    /*uint*/int BytesInChar = getCodePointNumBytes(Text.$at(MaxSplitBytes), $Encoding);
    NumChars += columnWidthWithTabs(Text.substr(MaxSplitBytes, BytesInChar),
        ContentStartColumn, TabWidth, $Encoding);
    MaxSplitBytes += BytesInChar;
  }

  /*size_t*/int SpaceOffset = Text.find_last_of(/*STRINGREF_STR*/Blanks, MaxSplitBytes);
  if (SpaceOffset == StringRef.npos
    // Don't break at leading whitespace.
     || Text.find_last_not_of(/*STRINGREF_STR*/Blanks, SpaceOffset) == StringRef.npos) {
    // Make sure that we don't break at leading whitespace that
    // reaches past MaxSplit.
    /*size_t*/int FirstNonWhitespace = Text.find_first_not_of(/*STRINGREF_STR*/Blanks);
    if (FirstNonWhitespace == StringRef.npos) {
      // If the comment is only whitespace, we cannot split.
      return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
    }
    SpaceOffset = Text.find_first_of(/*STRINGREF_STR*/Blanks, std.max(MaxSplitBytes, FirstNonWhitespace));
  }
  if (SpaceOffset != StringRef.npos && SpaceOffset != 0) {
    StringRef BeforeCut = Text.substr(0, SpaceOffset).rtrim(/*STRINGREF_STR*/Blanks);
    StringRef AfterCut = Text.substr(SpaceOffset).ltrim(/*STRINGREF_STR*/Blanks);
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, BeforeCut.size(),
        AfterCut.begin().$sub(BeforeCut.end()));
  }
  return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getStringSplit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 85,
 FQN="clang::format::getStringSplit", NM="_ZN5clang6formatL14getStringSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL14getStringSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE")
//</editor-fold>
public static std.pairUIntUInt getStringSplit(StringRef Text, /*uint*/int UsedColumns, /*uint*/int ColumnLimit,
              /*uint*/int TabWidth, /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding) {
  // FIXME: Reduce unit test case.
  if (Text.empty()) {
    return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }
  if ($lesseq_uint(ColumnLimit, UsedColumns)) {
    return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }
  /*uint*/int MaxSplit = ColumnLimit - UsedColumns;
  /*size_t*/int SpaceOffset = 0;
  /*size_t*/int SlashOffset = 0;
  /*size_t*/int WordStartOffset = 0;
  /*size_t*/int SplitPoint = 0;
  for (/*uint*/int Chars = 0;;) {
    /*uint*/int Advance;
    if (Text.$at(0) == $$BACK_SLASH) {
      Advance = getEscapeSequenceLength(new StringRef(Text));
      Chars += Advance;
    } else {
      Advance = getCodePointNumBytes(Text.$at(0), $Encoding);
      Chars += columnWidthWithTabs(Text.substr(0, Advance), UsedColumns + Chars, TabWidth, $Encoding);
    }
    if ($greater_uint(Chars, MaxSplit) || $lesseq_uint(Text.size(), Advance)) {
      break;
    }
    if (IsBlank(Text.$at(0))) {
      SpaceOffset = SplitPoint;
    }
    if (Text.$at(0) == $$SLASH) {
      SlashOffset = SplitPoint;
    }
    if (Advance == 1 && !isAlphanumeric(Text.$at(0))) {
      WordStartOffset = SplitPoint;
    }

    SplitPoint += Advance;
    Text.$assignMove(Text.substr(Advance));
  }
  if (SpaceOffset != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, SpaceOffset + 1, 0);
  }
  if (SlashOffset != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, SlashOffset + 1, 0);
  }
  if (WordStartOffset != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, WordStartOffset + 1, 0);
  }
  if (SplitPoint != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, SplitPoint, 0);
  }
  return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }

// Returns the length of everything up to the first possible line break after
// the ), ], } or > matching \c Tok.
//<editor-fold defaultstate="collapsed" desc="clang::format::getLengthToMatchingParen">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 31,
 FQN="clang::format::getLengthToMatchingParen", NM="_ZN5clang6formatL24getLengthToMatchingParenERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL24getLengthToMatchingParenERKNS0_11FormatTokenE")
//</editor-fold>
public static /*uint*/int getLengthToMatchingParen(final /*const*/ FormatToken /*&*/ Tok) {
  if (!(Tok.MatchingParen != null)) {
    return 0;
  }
  FormatToken /*P*/ End = Tok.MatchingParen;
  while ((End.Next != null) && !End.Next.CanBreakBefore) {
    End = End.Next;
  }
  return End.TotalLength - Tok.TotalLength + 1;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getLengthToNextOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 41,
 FQN="clang::format::getLengthToNextOperator", NM="_ZN5clang6formatL23getLengthToNextOperatorERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL23getLengthToNextOperatorERKNS0_11FormatTokenE")
//</editor-fold>
public static /*uint*/int getLengthToNextOperator(final /*const*/ FormatToken /*&*/ Tok) {
  if (!(Tok.NextOperator != null)) {
    return 0;
  }
  return Tok.NextOperator.TotalLength - Tok.TotalLength;
}


// Returns \c true if \c Tok is the "." or "->" of a call and starts the next
// segment of a builder type call.
//<editor-fold defaultstate="collapsed" desc="clang::format::startsSegmentOfBuilderTypeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 49,
 FQN="clang::format::startsSegmentOfBuilderTypeCall", NM="_ZN5clang6formatL30startsSegmentOfBuilderTypeCallERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL30startsSegmentOfBuilderTypeCallERKNS0_11FormatTokenE")
//</editor-fold>
public static boolean startsSegmentOfBuilderTypeCall(final /*const*/ FormatToken /*&*/ Tok) {
  return Tok.isMemberAccess() && (Tok.Previous != null) && Tok.Previous.closesScope();
}


// Returns \c true if \c Current starts a new parameter.
//<editor-fold defaultstate="collapsed" desc="clang::format::startsNextParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 54,
 FQN="clang::format::startsNextParameter", NM="_ZN5clang6formatL19startsNextParameterERKNS0_11FormatTokenERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL19startsNextParameterERKNS0_11FormatTokenERKNS0_11FormatStyleE")
//</editor-fold>
public static boolean startsNextParameter(final /*const*/ FormatToken /*&*/ Current,
                   final /*const*/ FormatStyle /*&*/ Style) {
  final /*const*/ FormatToken /*&*/ Previous = /*Deref*/Current.Previous;
  if (Current.is_TokenType(TokenType.TT_CtorInitializerComma)
     && Style.BreakConstructorInitializersBeforeComma) {
    return true;
  }
  return Previous.is_TokenKind(tok.TokenKind.comma) && !Current.isTrailingComment()
     && (Previous.isNot(TokenType.TT_CtorInitializerComma)
     || !Style.BreakConstructorInitializersBeforeComma);
}

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

  // Returns a pair (Index, OffsetToEOL) describing the position of the cursor
  // before sorting/deduplicating. Index is the index of the include under the
  // cursor in the original set of includes. If this include has duplicates, it is
  // the index of the first of the duplicates as the others are going to be
  // removed. OffsetToEOL describes the cursor's position relative to the end of
  // its current line.
  // If `Cursor` is not on any #include, `Index` will be UINT_MAX.
  public static std.pair<Integer/*uint*/, Integer/*uint*/> FindCursorIndex(SmallVectorImpl<IncludeDirective> /*const&*/ Includes,
          SmallVectorUInt /*const&*/ Indices,
          int /*uint*/ Cursor) {
//  unsigned CursorIndex = UINT_MAX;
    int CursorIndex = std.UINT32_MAX;
    int OffsetToEOL = 0;
    for (int i = 0, e = Includes.size(); i != e; ++i) {
//    unsigned Start = Includes[Indices[i]].Offset;
      int Start = Includes.$at(Indices.$at(i)).Offset;
//    unsigned End = Start + Includes[Indices[i]].Text.size();
      int End = Start + Includes.$at(Indices.$at(i)).Text.size();
      if (!(Cursor >= Start && Cursor < End))
        continue;
//    CursorIndex = Indices[i];
      CursorIndex = Indices.$at(i);
      OffsetToEOL = End - Cursor;
      // Put the cursor on the only remaining #include among the duplicate
      // #includes.
//    while (--i >= 0 && Includes[CursorIndex].Text == Includes[Indices[i]].Text)
      while (--i >= 0 && Includes.$at(CursorIndex).Text.$eq(Includes.$at(Indices.$at(i)).Text)) {
        CursorIndex = i;
      }
      break;
    }
    // return std::make_pair(CursorIndex, OffsetToEOL);
    return std.make_pair(CursorIndex, OffsetToEOL);
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


// Sorts and deduplicate a block of includes given by 'Includes' alphabetically
// adding the necessary replacement to 'Replaces'. 'Includes' must be in strict
// source order.
// #include directives with the same text will be deduplicated, and only the
// first #include in the duplicate #includes remains. If the `Cursor` is
// provided and put on a deleted #include, it will be moved to the remaining
// #include in the duplicate #includes.
//<editor-fold defaultstate="collapsed" desc="clang::format::sortCppIncludes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1216,
 FQN="clang::format::sortCppIncludes", NM="_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj")
//</editor-fold>
public static void sortCppIncludes(
      final /*const*/ FormatStyle /*&*/ Style,
      final /*const*/ SmallVectorImpl<IncludeDirective> /*&*/ Includes,
      ArrayRef<Range> Ranges, StringRef FileName,
      final Replacements /*&*/ Replaces,
      uint$ptr/*uint P*/ Cursor) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    int /*uint*/ IncludesBeginOffset = Includes.front().Offset;
    //  unsigned IncludesEndOffset =
    //      Includes.back().Offset + Includes.back().Text.size();
    int /*uint*/ IncludesEndOffset
        = Includes.back().Offset + Includes.back().Text.size();
    int /*uint*/ IncludesBlockSize = IncludesEndOffset - IncludesBeginOffset;
    //  if (!affectsRange(Ranges, IncludesBeginOffset, IncludesEndOffset))
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

    // The index of the include on which the cursor will be put after
    // sorting/deduplicating.
    int /*uint*/ CursorIndex = 0;
    // The offset from cursor to the end of line.
    int /*uint*/ CursorToEOLOffset = 0;
    if (Cursor != null) {
      // std::tie(CursorIndex, CursorToEOLOffset) =
      //   FindCursorIndex(Includes, Indices, *Cursor);
      std.pair<Integer/*uint*/, Integer/*uint*/> p = FindCursorIndex(Includes, Indices, Cursor.$star());
      CursorIndex = p.first;
      CursorToEOLOffset = p.second;
    }
    // Deduplicate #includes.
    //  Indices.erase(std::unique(Indices.begin(), Indices.end(),
    //                            [&](unsigned LHSI, unsigned RHSI) {
    //                              return Includes[LHSI].Text == Includes[RHSI].Text;
    //                            }),
    //                Indices.end());

    Indices.erase(std.unique(Indices.begin(), Indices.end(),
        (TypeType2Bool<Integer>) (Integer LHSI, Integer RHSI) -> Includes.$at(LHSI).Text.$eq(Includes.$at(RHSI).Text)),
        Indices.end()
    );

    // If the #includes are out of order, we generate a single replacement fixing
    // the entire block. Otherwise, no replacement is generated.
    if (Indices.size() == Includes.size()
        && std.is_sorted(Indices.begin(), Indices.end())) {
      return;
    }

    std.string result/*J*/= new std.string();
    for (/*uint*/int Index : Indices) {
      if (!result.empty()) {
        result.$addassign_T$C$P(/*KEEP_STR*/"\n");
      }
      $addassign_string_StringRef(result, /*NO_COPY*/Includes.$at$Const(Index).Text);
      // if (Cursor && CursorIndex == Index)
      //   *Cursor = IncludesBeginOffset + result.size() - CursorToEOLOffset;
      if (Cursor != null && CursorIndex == Index) {
        Cursor.star$ref().$assign(IncludesBeginOffset + result.size() - CursorToEOLOffset);
      }
    }

    org.llvm.support.Error Err = Replaces.add(new Replacement(new StringRef(FileName), Includes.front$Const().Offset, IncludesBlockSize, new StringRef(result)));
    // FIXME: better error handling. For now, just skip the replacement for the
    // release version.
    if (Err.$bool()) {
      String ErrMsg = "sortCppIncludes error:" + llvm.toString(Err);
      llvm.dbgs().$out(ErrMsg);
      // assert (false)
      throw new RuntimeException(ErrMsg);
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::IncludeRegexPattern">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1318,
 FQN="clang::format::(anonymous namespace)::IncludeRegexPattern", NM="_ZN5clang6format12_GLOBAL__N_1L19IncludeRegexPatternE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L19IncludeRegexPatternE")
//</editor-fold>
public static /*const*//*char*/char$ptr IncludeRegexPattern/*[55]*/ = $("^[\\t\\ ]*#[\\t\\ ]*(import|include)[^\"<]*([\"<][^\">]*[\">])");
// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::format::sortCppIncludes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1323,
 FQN="clang::format::sortCppIncludes", NM="_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj")
//</editor-fold>
public static Replacements sortCppIncludes(
      final /*const*/ FormatStyle /*&*/ Style,
      StringRef Code, ArrayRef<Range> Ranges,
      StringRef FileName,
      final Replacements /*&*/ Replaces,
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
    return new Replacements(Replaces);
  } finally {
    if (Categories != null) { Categories.$destroy(); }
    if (IncludeRegex != null) { IncludeRegex.$destroy(); }
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::format::processReplacements">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1396,
 FQN="clang::format::processReplacements", NM="Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE")
//</editor-fold>
public static </*typename*/ T extends FormatStyleStringRefvectorStringRef2Replacements> Expected<Replacements> processReplacements(T ProcessFunc, StringRef Code,
      final /*const*/ Replacements /*&*/ Replaces,
      final /*const*/ FormatStyle /*&*/ Style) {
  Expected<std.string> NewCode = null;
  std.vector<Range> ChangedRanges = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Replaces.empty()) {
      return new Expected<>(JD$ConvertibleMove.INSTANCE, new Replacements());
    }

    NewCode = applyAllReplacements(new StringRef(Code), Replaces);
    if (!NewCode.$bool()) {
      return $c$.clean(new Expected<>($c$.track(NewCode.takeError())));
    }
    ChangedRanges = Replaces.getAffectedRanges();
    StringRef FileName = Replaces.begin().$arrow().getFilePath();

    Replacements FormatReplaces = ProcessFunc.$call(Style, new StringRef(NewCode.$star()), ChangedRanges, FileName);

    return new Expected<>(JD$ConvertibleMove.INSTANCE, Replaces.merge(FormatReplaces));
  } finally {
    if (ChangedRanges != null) { ChangedRanges.$destroy(); }
    if (NewCode != null) { NewCode.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::isHeaderInsertion">
  @Converted(kind = Converted.Kind.AUTO,
      source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1443,
      FQN = "clang::format::(anonymous namespace)::isHeaderInsertion", NM = "_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE",
      cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE")
//</editor-fold>
  public static /*inline*/ boolean isHeaderInsertion(final /*const*/ Replacement /*&*/ Replace) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Replace.getOffset() == UINT_MAX && Replace.getLength() == 0
          && $c$.track(new Regex(new StringRef(IncludeRegexPattern))).find(/*match(*/Replace.getReplacementText()));
    } finally {
      $c$.$destroy();
    }
  }

  public static /*inline*/ boolean isHeaderDeletion(final /*const*/ Replacement /*&*/ Replace) {
    return Replace.getOffset() == UINT_MAX && Replace.getLength() == 0;
  }

// Returns the offset after skipping a sequence of tokens, matched by \p
// GetOffsetAfterSequence, from the start of the code.
// \p GetOffsetAfterSequence should be a function that matches a sequence of
// tokens and returns an offset after the sequence.
  public static int /*uint*/ getOffsetAfterTokenSequence(StringRef FileName,
          StringRef Code, final /*const*/ FormatStyle /*&*/ Style,
          // std::function<unsigned(const SourceManager &, Lexer &, Token &)>
          SrcMgrLexerToken2Uint GetOffsetAfterSequense) {
    std.unique_ptr<Environment> Env = null;
    Lexer Lex = null;
    Token Tok = null;
    try {
      Env = Environment.CreateVirtualEnvironment(new StringRef(Code), new StringRef(FileName), new ArrayRef<Range>());
      final SourceManager /*&*/ SourceMgr = Env.$arrow().getSourceManager();
      Lex = new Lexer(Env.$arrow().getFileID(), SourceMgr.getBuffer(Env.$arrow().getFileID()), SourceMgr, getFormattingLangOpts(Style));
      Tok = new Token();
      // Get the first token.
      Lex.LexFromRawLexer(Tok);
      return GetOffsetAfterSequense.apply(SourceMgr, Lex, new Token(Tok));
    } finally {
      if (Env != null) {
        Env.$destroy();
      }
      if (Lex != null) {
        Lex.$destroy();
      }
    }
  }


//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::skipComments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1448,
 FQN="clang::format::(anonymous namespace)::skipComments", NM="_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE")
//</editor-fold>
public static void skipComments(final Lexer /*&*/ Lex, final Token /*&*/ Tok) {
  while (Tok.is(tok.TokenKind.comment)) {
    if (Lex.LexFromRawLexer(Tok)) {
      return;
    }
  }
}


// Check if a sequence of tokens is like "#<Name> <raw_identifier>". If it is,
// \p Tok will be the token after this directive; otherwise, it can be any token
// after the given \p Tok (including \p Tok).
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::checkAndConsumeDirectiveWithName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1457,
 FQN="clang::format::(anonymous namespace)::checkAndConsumeDirectiveWithName", NM="_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE")
//</editor-fold>
public static boolean checkAndConsumeDirectiveWithName(final Lexer /*&*/ Lex, StringRef Name, final Token /*&*/ Tok) {
  boolean Matched = Tok.is(tok.TokenKind.hash) && !Lex.LexFromRawLexer(Tok)
     && Tok.is(tok.TokenKind.raw_identifier)
     && $eq_StringRef(Tok.getRawIdentifier(), /*NO_COPY*/Name) && !Lex.LexFromRawLexer(Tok)
     && Tok.is(tok.TokenKind.raw_identifier);
  if (Matched) {
    Lex.LexFromRawLexer(Tok);
  }
  return Matched;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::getOffsetAfterHeaderGuardsAndComments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1467,
 FQN="clang::format::(anonymous namespace)::getOffsetAfterHeaderGuardsAndComments", NM="_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE")
//</editor-fold>
public static /*uint*/int getOffsetAfterHeaderGuardsAndComments(StringRef FileName,
                                     StringRef Code,
                                     final /*const*/ FormatStyle /*&*/ Style) {
  return getOffsetAfterTokenSequence(new StringRef(FileName), new StringRef(Code), Style, (SM, Lex, Tok) -> {
    skipComments(Lex, Tok);
    int InitialOffset = SM.getFileOffset(Tok.getLocation());
    if (checkAndConsumeDirectiveWithName(Lex, new StringRef("ifndef"), Tok)) {
      skipComments(Lex, Tok);
      if (checkAndConsumeDirectiveWithName(Lex, new StringRef("define"), Tok))
        return SM.getFileOffset(Tok.getLocation());
    }
    return InitialOffset;
  });
}

// Check if a sequence of tokens is like
//    "#include ("header.h" | <header.h>)".
// If it is, \p Tok will be the token after this directive; otherwise, it can be
// any token after the given \p Tok (including \p Tok).
  public static boolean checkAndConsumeInclusiveDirective(Lexer /*&*/ Lex, Token /*&*/ Tok) {
    Supplier<Boolean> Matched = () -> {
      Lex.LexFromRawLexer(Tok);
      return true;
    };

//    if (Tok.is(tok::hash) && !Lex.LexFromRawLexer(Tok) &&
//        Tok.is(tok::raw_identifier) && Tok.getRawIdentifier() == "include") {
    if (Tok.is(tok.TokenKind.hash) && !Lex.LexFromRawLexer(Tok)
        && Tok.is(tok.TokenKind.raw_identifier) && $eq_StringRef(Tok.getRawIdentifier(), "include")) {
      if (Lex.LexFromRawLexer(Tok))
        return false;
      if (Tok.is(tok.TokenKind.string_literal)) {
        return Matched.get();
      }

      if (Tok.is(tok.TokenKind.less)) {
        while (!Lex.LexFromRawLexer(Tok) && Tok.isNot(tok.TokenKind.greater)) {
        }
        if (Tok.is(tok.TokenKind.greater)) {
          return Matched.get();
        }
      }
    }
    return false;
  }

// Returns the offset of the last #include directive after which a new
// #include can be inserted. This ignores #include's after the #include block(s)
// in the beginning of a file to avoid inserting headers into code sections
// where new #include's should not be added by default.
// These code sections include:
//      - raw string literals (containing #include).
//      - #if blocks.
//      - Special #include's among declarations (e.g. functions).
//
// If no #include after which a new #include can be inserted, this returns the
// offset after skipping all comments from the start of the code.
// Inserting after an #include is not allowed if it comes after code that is not
// #include (e.g. pre-processing directive that is not #include, declarations).
  public static /*uint*/ int getMaxHeaderInsertionOffset(StringRef FileName, StringRef Code,
          /*const*/ FormatStyle /*&*/ Style) {
    return getOffsetAfterTokenSequence(new StringRef(FileName), new StringRef(Code), Style, (SM, Lex, Tok) -> {
      skipComments(Lex, Tok);
      int /*uint*/ MaxOffset = SM.getFileOffset(Tok.getLocation());
      while (checkAndConsumeInclusiveDirective(Lex, Tok)) {
        MaxOffset = SM.getFileOffset(Tok.getLocation());
      }
      return MaxOffset;
    });
  }

  public static boolean isDeletedHeader(StringRef HeaderName, std.setType<StringRef> /*const&*/ HeadersToDelete) {
    return HeadersToDelete.count(HeaderName) || HeadersToDelete.count(HeaderName.trim(new StringRef("\"<>")));
  }

// FIXME: we also need to insert a '\n' at the end of the code if we have an
// insertion with offset Code.size(), and there is no '\n' at the end of the
// code.
// FIXME: do not insert headers into conditional #include blocks, e.g. #includes
// surrounded by compile condition "#if...".
// FIXME: insert empty lines between newly created blocks.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::fixCppIncludeInsertions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1494,
 FQN="clang::format::(anonymous namespace)::fixCppIncludeInsertions", NM="_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE")
//</editor-fold>
public static Replacements fixCppIncludeInsertions(StringRef Code, final /*const*/ Replacements /*&*/ Replaces,
      final /*const*/ FormatStyle /*&*/ Style) {
  Replacements HeaderInsertions = null;
  std.setType<StringRef> HeadersToDelete = null;
  Replacements Result = null;
  Regex IncludeRegex = null;
  Regex DefineRegex = null;
  IncludeCategoryManager Categories = null;
  std.mapIntInt CategoryEndOffsets = null;
  std.setInt Priorities = null;
  std.setType<StringRef> ExistingIncludes = null;
  try {
    if (Style.Language != FormatStyle.LanguageKind.LK_Cpp) {
      return new Replacements(Replaces);
    }

    HeaderInsertions/*J*/ = new Replacements();
    HeadersToDelete = new std.setType<>(StringRef.COMPARATOR);
    Result = new Replacements();
    for (Replacement R : Replaces.Replaces) {
      if (isHeaderInsertion(R)) {
        // Replacements from \p Replaces must be conflict-free already, so we can
        // simply consume the error.
        llvm.consumeError(HeaderInsertions.add(R));
      } else if (isHeaderDeletion(R)) {
        HeadersToDelete.insert(R.getReplacementText());
      } else if (R.getOffset() == UINT_MAX) {
        llvm.errs().$out(/*KEEP_STR*/"Insertions other than header #include insertion are not supported! ").$out(
            R.getReplacementText()
        ).$out(/*KEEP_STR*/$LF);
      } else {
        llvm.consumeError(Result.add(R));
      }
    }

    if (HeaderInsertions.empty() && HeadersToDelete.empty()) {
      return new Replacements(Replaces);
    }

    IncludeRegex/*J*/= new Regex(new StringRef(IncludeRegexPattern));
    DefineRegex/*J*/= new Regex(new StringRef(/*KEEP_STR*/"^[\\t\\ ]*#[\\t\\ ]*define[\\t\\ ]*[^\\\\]*$"));
    SmallVector<StringRef> Matches/*J*/ = new SmallVector<>(4, new StringRef());

    StringRef FileName = Replaces.begin().$arrow().getFilePath();
    Categories/*J*/= new IncludeCategoryManager(Style, new StringRef(FileName));

    // Record the offset of the end of the last include in each category.
    CategoryEndOffsets/*J*/= new std.mapIntInt();
    // All possible priorities.
    // Add 0 for main header and INT_MAX for headers that are not in any category.
    /*FIXME: Initializer produces not destroyed temporary!*/Priorities = /*{ */new std.setInt(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, new$int(2, 0, INT_MAX))/* }*/;
    for (final /*const*/ FormatStyle.IncludeCategory /*&*/ Category : Style.IncludeCategories)  {
      Priorities.insert_T$C$R(Category.Priority);
    }
    int FirstIncludeOffset = -1;
    // All new headers should be inserted after this offset.
    /*uint*/int MinInsertOffset = getOffsetAfterHeaderGuardsAndComments(new StringRef(FileName), new StringRef(Code), Style);
    StringRef TrimmedCode = Code.drop_front(MinInsertOffset);
    int /*uint*/ MaxInsertOffset
        = MinInsertOffset
        + getMaxHeaderInsertionOffset(FileName, TrimmedCode, Style);

    SmallVector<StringRef> Lines/*J*/ = new SmallVector<>(32, new StringRef());
    TrimmedCode.split(Lines, $$LF);
    /*uint*/int Offset = MinInsertOffset;
    /*uint*/int NextLineOffset;
    ExistingIncludes/*J*/ = new std.setType<>(StringRef.COMPARATOR);
    for (StringRef Line : Lines) {
      NextLineOffset = std.min_uint(Code.size(), Offset + Line.size() + 1);
      if (IncludeRegex.match(/*NO_COPY*/Line, /*AddrOf*/Matches)) {
        StringRef IncludeName = new StringRef(Matches.$at(2));
        ExistingIncludes.insert_T$C$R(IncludeName);
        // Only record the offset of current #include if we can insert after it.
        if (Offset <= MaxInsertOffset) {
          int Category = Categories.getIncludePriority(new StringRef(IncludeName), /*CheckMainHeader=*/ FirstIncludeOffset < 0);
          CategoryEndOffsets.$set(Category, NextLineOffset);
          if (FirstIncludeOffset < 0) {
            FirstIncludeOffset = Offset;
          }
        }
        if (isDeletedHeader(new StringRef(IncludeName), HeadersToDelete)) {
          // If this is the last line without trailing newline, we need to make
          // sure we don't delete across the file boundary.
          int /*ui*/ Length = std.min(Line.size() + 1, Code.size() - Offset);
          Error Err
              = Result.add(new Replacement(new StringRef(FileName), Offset, Length, new StringRef("")));
          if (Err.$bool()) {
            // Ignore the deletion on conflict.
            llvm.errs().$out("Failed to add header deletion replacement for ")
                .$out(IncludeName)
                .$out(": ")
                .$out(llvm.toString(Err))
                .$out($LF);
          }
        }
      }
      Offset = NextLineOffset;
    }

    // Populate CategoryEndOfssets:
    // - Ensure that CategoryEndOffset[Highest] is always populated.
    // - If CategoryEndOffset[Priority] isn't set, use the next higher value that
    //   is set, up to CategoryEndOffset[Highest].
    std.setInt.iterator Highest = Priorities.begin();
    if (CategoryEndOffsets.find(Highest.$star()).$eq(CategoryEndOffsets.end())) {
      if (FirstIncludeOffset >= 0) {
        CategoryEndOffsets.$set(Highest.$star(), FirstIncludeOffset);
      } else {
        CategoryEndOffsets.$set(Highest.$star(), MinInsertOffset);
      }
    }
    // By this point, CategoryEndOffset[Highest] is always set appropriately:
    //  - to an appropriate location before/after existing #includes, or
    //  - to right after the header guard, or
    //  - to the beginning of the file.
    for (std.setInt.iterator I = new std.setInt.iterator(Priorities.begin().$preInc()), E = Priorities.end(); I.$noteq(E); I.$preInc())  {
      if (CategoryEndOffsets.find(I.$star()).$eq(CategoryEndOffsets.end())) {
        CategoryEndOffsets.$set(I.$star(), CategoryEndOffsets.$at_T$C$R(std.prev(new std.setInt.iterator(I)).$star()));
      }
    }

    boolean NeedNewLineAtEnd = !Code.empty() && Code.back() != '\n';
    for (Iterator<Replacement> it = HeaderInsertions.iterator(); it.hasNext();) {
      Replacement R = it.next();
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef IncludeDirective = R.getReplacementText();
        boolean Matched = IncludeRegex.match(/*NO_COPY*/IncludeDirective, /*AddrOf*/Matches);
        assert (Matched) : "Header insertion replacement must have replacement text '#include ...'";
        ///*J:(void)*/Matched;
        StringRef IncludeName = new StringRef(Matches.$at(2));
        if (ExistingIncludes.find(IncludeName).$noteq(ExistingIncludes.end())) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
              llvm.dbgs().$out(/*KEEP_STR*/"Skip adding existing include : ").$out(/*NO_COPY*/IncludeName).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          continue;
        }
        int Category = Categories.getIncludePriority(new StringRef(IncludeName), /*CheckMainHeader=*/ true);
        Offset = CategoryEndOffsets.$at_T$C$R(Category);
        std.string NewInclude = !IncludeDirective.endswith(/*STRINGREF_STR*/"\n") ? ($add_StringRef$C_char$ptr$C(IncludeDirective, /*KEEP_STR*/ $LF)).str() : IncludeDirective.str();
        // When inserting headers at end of the code, also append '\n' to the code
        // if it does not end with '\n'.
        if (NeedNewLineAtEnd && Offset == Code.size()) {
          NewInclude = new std.string("\n").$addassign(NewInclude);
          NeedNewLineAtEnd = false;
        }
        Replacement NewReplace = new Replacement(new StringRef(FileName), Offset, 0, new StringRef(NewInclude));
        Error Err = Result.add(NewReplace);
        if (Err.$bool()) {
          llvm.consumeError(Err);
          int /*uint*/ NewOffset = Result.getShiftedCodePosition(Offset);
          NewReplace = new Replacement(new StringRef(FileName), NewOffset, 0, new StringRef(NewInclude));
          Result = Result.merge(new Replacements(NewReplace));
        }
      } finally {
        $c$.$destroy();
      }
    }
    return Result;
  } finally {
    if (ExistingIncludes != null) { ExistingIncludes.$destroy(); }
    if (Priorities != null) { Priorities.$destroy(); }
    if (CategoryEndOffsets != null) { CategoryEndOffsets.$destroy(); }
    if (Categories != null) { Categories.$destroy(); }
    if (DefineRegex != null) { DefineRegex.$destroy(); }
    if (IncludeRegex != null) { IncludeRegex.$destroy(); }
    if (HeaderInsertions != null) { HeaderInsertions.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getLanguageByFileName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1682,
 FQN="clang::format::getLanguageByFileName", NM="_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE")
//</editor-fold>
public static FormatStyle.LanguageKind getLanguageByFileName(StringRef FileName) {
  if (FileName.endswith(/*STRINGREF_STR*/".java")) {
    return FormatStyle.LanguageKind.LK_Java;
  }
  if (FileName.endswith_lower(/*STRINGREF_STR*/".js") || FileName.endswith_lower(/*STRINGREF_STR*/".ts")) {
    return FormatStyle.LanguageKind.LK_JavaScript; // JavaScript or TypeScript.
  }
  if (FileName.endswith(".m") || FileName.endswith(".mm")) {
    return FormatStyle.LanguageKind.LK_ObjC;
  }
  if (FileName.endswith_lower(/*STRINGREF_STR*/".proto")
     || FileName.endswith_lower(/*STRINGREF_STR*/".protodevel")) {
    return FormatStyle.LanguageKind.LK_Proto;
  }
  if (FileName.endswith_lower(/*STRINGREF_STR*/".td")) {
    return FormatStyle.LanguageKind.LK_TableGen;
  }
  return FormatStyle.LanguageKind.LK_Cpp;
}


/// \brief Determines the name of a token type.
//<editor-fold defaultstate="collapsed" desc="clang::format::getTokenTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 26,
 FQN="clang::format::getTokenTypeName", NM="_ZN5clang6format16getTokenTypeNameENS0_9TokenTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format16getTokenTypeNameENS0_9TokenTypeE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTokenTypeName(TokenType Type) {
  final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[61]*/> TokNames = getTokenTypeName$$.TokNames;
  if (Type.getValue() < TokenType.NUM_TOKEN_TYPES.getValue()) {
    return TokNames.$at(Type.getValue());
  }
  throw new llvm_unreachable("unknown TokenType");
//  return null;
}
private static final class getTokenTypeName$$ {
  static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[61]*/> TokNames = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*61*/] {
    $("ArrayInitializerLSquare"), $("ArraySubscriptLSquare"), $("AttributeParen"), $("BinaryOperator"), $("BitFieldColon"), $("BlockComment"), $("CastRParen"), $("ConditionalExpr"), $("ConflictAlternative"), $("ConflictEnd"), $("ConflictStart"), $("CtorInitializerColon"), $("CtorInitializerComma"), $("DesignatedInitializerPeriod"), $("DictLiteral"), $("ForEachMacro"), $("FunctionAnnotationRParen"), $("FunctionDeclarationName"), $("FunctionLBrace"), $("FunctionTypeLParen"), $("ImplicitStringLiteral"), $("InheritanceColon"), $("InlineASMBrace"), $("InlineASMColon"), $("JavaAnnotation"), $("JsComputedPropertyName"), $("JsFatArrow"), $("JsTypeColon"), $("JsTypeOperator"), $("JsTypeOptionalQuestion"), $("LambdaArrow"), $("LambdaLSquare"), $("LeadingJavaAnnotation"), $("LineComment"), $("MacroBlockBegin"), $("MacroBlockEnd"), $("ObjCBlockLBrace"), $("ObjCBlockLParen"), $("ObjCDecl"), $("ObjCForIn"), $("ObjCMethodExpr"), $("ObjCMethodSpecifier"), $("ObjCProperty"), $("ObjCStringLiteral"), $("OverloadedOperator"), $("OverloadedOperatorLParen"), $("PointerOrReference"), $("PureVirtualSpecifier"), $("RangeBasedForLoopColon"), $("RegexLiteral"), $("SelectorName"), $("StartOfName"), $("TemplateCloser"), $("TemplateOpener"), $("TemplateString"), $("TrailingAnnotation"), $("TrailingReturnArrow"), $("TrailingUnaryOperator"), $("UnaryOperator"), $("Unknown"),
    null
  });
}


// Returns the lengths in code points between Begin and End (both included),
// assuming that the entire sequence is put on a single line.
//<editor-fold defaultstate="collapsed" desc="clang::format::CodePointsBetween">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 140,
 FQN="clang::format::CodePointsBetween", NM="_ZN5clang6formatL17CodePointsBetweenEPKNS0_11FormatTokenES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6formatL17CodePointsBetweenEPKNS0_11FormatTokenES3_")
//</editor-fold>
public static /*uint*/int CodePointsBetween(/*const*/ FormatToken /*P*/ Begin,
                 /*const*/ FormatToken /*P*/ End) {
  assert ($greatereq_uint(End.TotalLength, Begin.TotalLength));
  return End.TotalLength - Begin.TotalLength + Begin.ColumnWidth;
}


// Sort JavaScript ES6 imports/exports in ``Code``. The generated replacements
// only monotonically increase the length of the given code.
//<editor-fold defaultstate="collapsed" desc="clang::format::sortJavaScriptImports">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 430,
 FQN="clang::format::sortJavaScriptImports", NM="_ZN5clang6format21sortJavaScriptImportsERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format21sortJavaScriptImportsERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_")
//</editor-fold>
public static Replacements sortJavaScriptImports(
      final /*const*/ FormatStyle /*&*/ Style,
      StringRef Code,
      ArrayRef<Range> Ranges,
      StringRef FileName) {
  std.unique_ptr<Environment> Env = null;
  JavaScriptImportSorter Sorter = null;
  try {
    // FIXME: Cursor support.
    Env = Environment.CreateVirtualEnvironment(new StringRef(Code), new StringRef(FileName), new ArrayRef<Range>(Ranges));
    Sorter/*J*/= new JavaScriptImportSorter(Env.$star(), Style);
    return Sorter.process();
  } finally {
    if (Sorter != null) { Sorter.$destroy(); }
    if (Env != null) { Env.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::operator<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 95,
 FQN="clang::format::operator<", NM="_ZN5clang6formatltERKNS0_17JsModuleReferenceES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6formatltERKNS0_17JsModuleReferenceES3_")
//</editor-fold>
public static boolean $less_JsModuleReference$C(final /*const*/ JsModuleReference /*&*/ LHS, final /*const*/ JsModuleReference /*&*/ RHS) {
  if (LHS.IsExport != RHS.IsExport) {
    return (LHS.IsExport ? 1 : 0) < (RHS.IsExport ? 1 : 0);
  }
  if (LHS.Category != RHS.Category) {
    return LHS.Category.getValue() < RHS.Category.getValue();
  }
  if (LHS.Category == JsModuleReference.ReferenceCategory.SIDE_EFFECT) {
    // Side effect imports might be ordering sensitive. Consider them equal so
    // that they maintain their relative order in the stable sort below.
    // This retains transitivity because LHS.Category == RHS.Category here.
    return false;
  }
  // Empty URLs sort *last* (for export {...};).
  if (LHS.URL.empty() != RHS.URL.empty()) {
    return (LHS.URL.empty() ? 1 : 0) < (RHS.URL.empty() ? 1 : 0);
  }
  {
    int Res = LHS.URL.compare_lower(/*NO_COPY*/RHS.URL);
    if ((Res != 0)) {
      return Res < 0;
    }
  }
  // '*' imports (with prefix) sort before {a, b, ...} imports.
  if (LHS.Prefix.empty() != RHS.Prefix.empty()) {
    return (LHS.Prefix.empty() ? 1 : 0) < (RHS.Prefix.empty() ? 1 : 0);
  }
  if ($noteq_StringRef(/*NO_COPY*/LHS.Prefix, /*NO_COPY*/RHS.Prefix)) {
    return $greater_StringRef(/*NO_COPY*/LHS.Prefix, /*NO_COPY*/RHS.Prefix);
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::PrecedenceUnaryOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1349,
 FQN="clang::format::(anonymous namespace)::PrecedenceUnaryOperator", NM="_ZN5clang6format12_GLOBAL__N_1L23PrecedenceUnaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L23PrecedenceUnaryOperatorE")
//</editor-fold>
public static /*const*/int PrecedenceUnaryOperator = prec.Level.PointerToMember.getValue() + 1;
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::PrecedenceArrowAndPeriod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1350,
 FQN="clang::format::(anonymous namespace)::PrecedenceArrowAndPeriod", NM="_ZN5clang6format12_GLOBAL__N_1L24PrecedenceArrowAndPeriodE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L24PrecedenceArrowAndPeriodE")
//</editor-fold>
public static /*const*/int PrecedenceArrowAndPeriod = prec.Level.PointerToMember.getValue() + 2;

// This function heuristically determines whether 'Current' starts the name of a
// function declaration.
//<editor-fold defaultstate="collapsed" desc="clang::format::isFunctionDeclarationName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1590,
 FQN="clang::format::isFunctionDeclarationName", NM="_ZN5clang6formatL25isFunctionDeclarationNameERKNS0_11FormatTokenERKNS0_13AnnotatedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6formatL25isFunctionDeclarationNameERKNS0_11FormatTokenERKNS0_13AnnotatedLineE")
//</editor-fold>
public static boolean isFunctionDeclarationName(final /*const*/ FormatToken /*&*/ Current,
                         final /*const*/ AnnotatedLine /*&*/ Line) {
  FormatToken2FormatToken skipOperatorName = /*[]*/ (/*const*/ FormatToken /*P*/ Next) -> {
        for (; (Next != null); Next = Next.Next) {
          if (Next.is_TokenType(TokenType.TT_OverloadedOperatorLParen)) {
            return Next;
          }
          if (Next.is_TokenType(TokenType.TT_OverloadedOperator)) {
            continue;
          }
          if (Next.isOneOf(tok.TokenKind.kw_new, tok.TokenKind.kw_delete)) {
            // For 'new[]' and 'delete[]'.
            if ((Next.Next != null) && Next.Next.is_TokenKind(tok.TokenKind.l_square)
               && (Next.Next.Next != null) && Next.Next.Next.is_TokenKind(tok.TokenKind.r_square)) {
              Next = Next.Next.Next;
            }
            continue;
          }

          break;
        }
        return null;
      };

  // Find parentheses of parameter list.
  /*const*/ FormatToken /*P*/ Next = Current.Next;
  if (Current.is_TokenKind(tok.TokenKind.kw_operator)) {
    if ((Current.Previous != null) && Current.Previous.is_TokenKind(tok.TokenKind.coloncolon)) {
      return false;
    }
    Next = skipOperatorName.$call(Next);
  } else {
    if (!Current.is_TokenType(TokenType.TT_StartOfName) || Current.NestingLevel != 0) {
      return false;
    }
    for (; (Next != null); Next = Next.Next) {
      if (Next.is_TokenType(TokenType.TT_TemplateOpener)) {
        Next = Next.MatchingParen;
      } else if (Next.is_TokenKind(tok.TokenKind.coloncolon)) {
        Next = Next.Next;
        if (!(Next != null)) {
          return false;
        }
        if (Next.is_TokenKind(tok.TokenKind.kw_operator)) {
          Next = skipOperatorName.$call(Next.Next);
          break;
        }
        if (!Next.is_TokenKind(tok.TokenKind.identifier)) {
          return false;
        }
      } else if (Next.is_TokenKind(tok.TokenKind.l_paren)) {
        break;
      } else {
        return false;
      }
    }
  }

  // Check whether parameter list can be long to a function declaration.
  if (!(Next != null) || !Next.is_TokenKind(tok.TokenKind.l_paren) || !(Next.MatchingParen != null)) {
    return false;
  }
  // If the lines ends with "{", this is likely an function definition.
  if (Line.Last.is_TokenKind(tok.TokenKind.l_brace)) {
    return true;
  }
  if (Next.Next == Next.MatchingParen) {
    return true; // Empty parentheses.
  }
  // If there is an &/&& after the r_paren, this is likely a function.
  if ((Next.MatchingParen.Next != null)
     && Next.MatchingParen.Next.is_TokenType(TokenType.TT_PointerOrReference)) {
    return true;
  }
  for (/*const*/ FormatToken /*P*/ Tok = Next.Next; (Tok != null) && Tok != Next.MatchingParen;
       Tok = Tok.Next) {
    if (Tok.is_TokenKind(tok.TokenKind.kw_const) || Tok.isSimpleTypeSpecifier()
       || Tok.isOneOf(TokenType.TT_PointerOrReference, TokenType.TT_StartOfName, tok.TokenKind.ellipsis)) {
      return true;
    }
    if (Tok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.string_literal, TokenType.TT_ObjCMethodExpr)
       || Tok.Tok.isLiteral()) {
      return false;
    }
  }
  return false;
}


// Returns 'true' if 'Tok' is a brace we'd want to break before in Allman style.
//<editor-fold defaultstate="collapsed" desc="clang::format::isAllmanBrace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 2246,
 FQN="clang::format::isAllmanBrace", NM="_ZN5clang6formatL13isAllmanBraceERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6formatL13isAllmanBraceERKNS0_11FormatTokenE")
//</editor-fold>
public static boolean isAllmanBrace(final /*const*/ FormatToken /*&*/ Tok) {
  return Tok.is_TokenKind(tok.TokenKind.l_brace) && Tok.BlockKind == BraceBlockKind.BK_Block
     && !Tok.isOneOf(TokenType.TT_ObjCBlockLBrace, TokenType.TT_DictLiteral);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::startsExternCBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 21,
 FQN="clang::format::(anonymous namespace)::startsExternCBlock", NM="_ZN5clang6format12_GLOBAL__N_118startsExternCBlockERKNS0_13AnnotatedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118startsExternCBlockERKNS0_13AnnotatedLineE")
//</editor-fold>
public static boolean startsExternCBlock(final /*const*/ AnnotatedLine /*&*/ Line) {
  /*const*/ FormatToken /*P*/ Next = Line.First.getNextNonComment();
  /*const*/ FormatToken /*P*/ NextNext = (Next != null) ? Next.getNextNonComment() : null;
  return Line.startsWith(tok.TokenKind.kw_extern) && (Next != null) && Next.isStringLiteral()
     && (NextNext != null) && NextNext.is_TokenKind(tok.TokenKind.l_brace);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::markFinalized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 453,
 FQN="clang::format::(anonymous namespace)::markFinalized", NM="_ZN5clang6format12_GLOBAL__N_1L13markFinalizedEPNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L13markFinalizedEPNS0_11FormatTokenE")
//</editor-fold>
public static void markFinalized(FormatToken /*P*/ Tok) {
  for (; (Tok != null); Tok = Tok.Next) {
    Tok.Finalized = true;
    for (AnnotatedLine /*P*/ Child : Tok.Children)  {
      markFinalized(Child.First);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::printLineState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 462,
 FQN="clang::format::(anonymous namespace)::printLineState", NM="_ZN5clang6format12_GLOBAL__N_1L14printLineStateERKNS0_9LineStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L14printLineStateERKNS0_9LineStateE")
//</editor-fold>
public static void printLineState(final /*const*/ LineState /*&*/ State) {
  llvm.dbgs().$out(/*KEEP_STR*/"State: ");
  for (final /*const*/ ParenState /*&*/ P : State.Stack) {
    llvm.dbgs().$out_uint(P.Indent).$out(/*KEEP_STR*/$PIPE).$out_uint(P.LastSpace).$out(/*KEEP_STR*/$PIPE).$out_uint(P.NestedBlockIndent).$out(
        /*KEEP_STR*/$SPACE
    );
  }
  llvm.dbgs().$out(/*NO_COPY*/State.NextToken.TokenText).$out(/*KEEP_STR*/$LF);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::isGoogScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 453,
 FQN="clang::format::isGoogScope", NM="_ZN5clang6formatL11isGoogScopeERKNS0_13UnwrappedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL11isGoogScopeERKNS0_13UnwrappedLineE")
//</editor-fold>
public static boolean isGoogScope(final /*const*/ UnwrappedLine /*&*/ Line) {
  // FIXME: Closure-library specific stuff should not be hard-coded but be
  // configurable.
  if ($less_uint(Line.Tokens.size(), 4)) {
    return false;
  }
  std.list.iterator<UnwrappedLineNode> I = Line.Tokens.begin$Const();
  if ($noteq_StringRef(/*NO_COPY*/I.$arrow().Tok.TokenText, /*STRINGREF_STR*/"goog")) {
    return false;
  }
  I.$preInc();
  if (I.$arrow().Tok.isNot(tok.TokenKind.period)) {
    return false;
  }
  I.$preInc();
  if ($noteq_StringRef(/*NO_COPY*/I.$arrow().Tok.TokenText, /*STRINGREF_STR*/"scope")) {
    return false;
  }
  I.$preInc();
  return I.$arrow().Tok.is_TokenKind(tok.TokenKind.l_paren);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::ShouldBreakBeforeBrace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 471,
 FQN="clang::format::ShouldBreakBeforeBrace", NM="_ZN5clang6formatL22ShouldBreakBeforeBraceERKNS0_11FormatStyleERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL22ShouldBreakBeforeBraceERKNS0_11FormatStyleERKNS0_11FormatTokenE")
//</editor-fold>
public static boolean ShouldBreakBeforeBrace(final /*const*/ FormatStyle /*&*/ Style,
                      final /*const*/ FormatToken /*&*/ InitialToken) {
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_namespace)) {
    return Style.BraceWrapping.AfterNamespace;
  }
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_class)) {
    return Style.BraceWrapping.AfterClass;
  }
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_union)) {
    return Style.BraceWrapping.AfterUnion;
  }
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_struct)) {
    return Style.BraceWrapping.AfterStruct;
  }
  return false;
}


// Here we blacklist certain tokens that are not usually the first token in an
// unwrapped line. This is used in attempt to distinguish macro calls without
// trailing semicolons from other constructs split to several lines.
//<editor-fold defaultstate="collapsed" desc="clang::format::tokenCanStartNewLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 640,
 FQN="clang::format::tokenCanStartNewLine", NM="_ZN5clang6formatL20tokenCanStartNewLineERKNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL20tokenCanStartNewLineERKNS_5TokenE")
//</editor-fold>
public static boolean tokenCanStartNewLine(final /*const*/ Token /*&*/ Tok) {
  // Semicolon can be a null-statement, l_square can be a start of a macro or
  // a C++11 attribute, but this doesn't seem to be common.
  return Tok.isNot(tok.TokenKind.semi) && Tok.isNot(tok.TokenKind.l_brace)
     && Tok.isNot(tok.TokenKind.l_square)
    // Tokens that can only be used as binary operators and a part of
    // overloaded operator names.
     && Tok.isNot(tok.TokenKind.period) && Tok.isNot(tok.TokenKind.periodstar)
     && Tok.isNot(tok.TokenKind.arrow) && Tok.isNot(tok.TokenKind.arrowstar)
     && Tok.isNot(tok.TokenKind.less) && Tok.isNot(tok.TokenKind.greater)
     && Tok.isNot(tok.TokenKind.slash) && Tok.isNot(tok.TokenKind.percent)
     && Tok.isNot(tok.TokenKind.lessless) && Tok.isNot(tok.TokenKind.greatergreater)
     && Tok.isNot(tok.TokenKind.equal) && Tok.isNot(tok.TokenKind.plusequal)
     && Tok.isNot(tok.TokenKind.minusequal) && Tok.isNot(tok.TokenKind.starequal)
     && Tok.isNot(tok.TokenKind.slashequal) && Tok.isNot(tok.TokenKind.percentequal)
     && Tok.isNot(tok.TokenKind.ampequal) && Tok.isNot(tok.TokenKind.pipeequal)
     && Tok.isNot(tok.TokenKind.caretequal) && Tok.isNot(tok.TokenKind.greatergreaterequal)
     && Tok.isNot(tok.TokenKind.lesslessequal)
    // Colon is used in labels, base class lists, initializer lists,
    // range-based for loops, ternary operator, but should never be the
    // first token in an unwrapped line.
     && Tok.isNot(tok.TokenKind.colon)
    // 'noexcept' is a trailing annotation.
     && Tok.isNot(tok.TokenKind.kw_noexcept);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::mustBeJSIdent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 666,
 FQN="clang::format::mustBeJSIdent", NM="_ZN5clang6formatL13mustBeJSIdentERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL13mustBeJSIdentERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE")
//</editor-fold>
public static boolean mustBeJSIdent(final /*const*/ AdditionalKeywords /*&*/ Keywords,
             /*const*/ FormatToken /*P*/ FormatTok) {
  // FIXME: This returns true for C/C++ keywords like 'struct'.
  return FormatTok.is_TokenKind(tok.TokenKind.identifier)
     && (FormatTok.Tok.getIdentifierInfo() == null
     || !FormatTok.isOneOf(Keywords.kw_in, Keywords.kw_of, Keywords.kw_as,
      Keywords.kw_async, Keywords.kw_await,
      Keywords.kw_yield, Keywords.kw_finally,
      Keywords.kw_function, Keywords.kw_import,
      Keywords.kw_is, Keywords.kw_let, Keywords.kw_var,
      Keywords.kw_abstract, Keywords.kw_extends,
      Keywords.kw_implements, Keywords.kw_instanceof,
      Keywords.kw_interface, Keywords.kw_throws));
}

//<editor-fold defaultstate="collapsed" desc="clang::format::mustBeJSIdentOrValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 681,
 FQN="clang::format::mustBeJSIdentOrValue", NM="_ZN5clang6formatL20mustBeJSIdentOrValueERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL20mustBeJSIdentOrValueERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE")
//</editor-fold>
public static boolean mustBeJSIdentOrValue(final /*const*/ AdditionalKeywords /*&*/ Keywords,
                    /*const*/ FormatToken /*P*/ FormatTok) {
  return FormatTok.Tok.isLiteral() || mustBeJSIdent(Keywords, FormatTok);
}


// isJSDeclOrStmt returns true if |FormatTok| starts a declaration or statement
// when encountered after a value (see mustBeJSIdentOrValue).
//<editor-fold defaultstate="collapsed" desc="clang::format::isJSDeclOrStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 688,
 FQN="clang::format::isJSDeclOrStmt", NM="_ZN5clang6formatL14isJSDeclOrStmtERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL14isJSDeclOrStmtERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE")
//</editor-fold>
public static boolean isJSDeclOrStmt(final /*const*/ AdditionalKeywords /*&*/ Keywords,
              /*const*/ FormatToken /*P*/ FormatTok) {
  return FormatTok.isOneOf(tok.TokenKind.kw_return,
      // conditionals
      tok.TokenKind.kw_if, tok.TokenKind.kw_else,
      // loops
      tok.TokenKind.kw_for, tok.TokenKind.kw_while, tok.TokenKind.kw_do, tok.TokenKind.kw_continue, tok.TokenKind.kw_break,
      // switch/case
      tok.TokenKind.kw_switch, tok.TokenKind.kw_case,
      // exceptions
      tok.TokenKind.kw_throw, tok.TokenKind.kw_try, tok.TokenKind.kw_catch,
      // declaration
      tok.TokenKind.kw_const, tok.TokenKind.kw_class, tok.TokenKind.kw_export)||FormatTok.isOneOf(Keywords.kw_finally, Keywords.kw_yield, Keywords.kw_var, Keywords.kw_let,
      Keywords.kw_async, Keywords.kw_function,
      // import/export
      Keywords.kw_import);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::printDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1974,
 FQN="clang::format::printDebugInfo", NM="_ZN5clang6formatL14printDebugInfoERKNS0_13UnwrappedLineEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL14printDebugInfoERKNS0_13UnwrappedLineEN4llvm9StringRefE")
//</editor-fold>
public static void printDebugInfo(final /*const*/ UnwrappedLine /*&*/ Line)/* __attribute__((unused))*/ {
  printDebugInfo(Line,
              new StringRef(/*KEEP_STR*/$EMPTY));
}
public static void printDebugInfo(final /*const*/ UnwrappedLine /*&*/ Line,
              StringRef Prefix/*= ""*/)/* __attribute__((unused))*/ {
  llvm.dbgs().$out(/*NO_COPY*/Prefix).$out(/*KEEP_STR*/"Line(").$out_uint(Line.Level).$out(/*KEEP_STR*/$RPAREN).$out(
      (Line.InPPDirective ? $(" MACRO") : $EMPTY)
  ).$out(/*KEEP_STR*/": ");
  for (std.list.iterator<UnwrappedLineNode> I = Line.Tokens.begin$Const(),
      E = Line.Tokens.end$Const();
       I.$noteq(E); I.$preInc()) {
    llvm.dbgs().$out(I.$arrow().Tok.Tok.getName()).$out(/*KEEP_STR*/$LSQUARE).$out_int(I.$arrow().Tok.Type.getValue()).$out(/*KEEP_STR*/"] ");
  }
  for (std.list.iterator<UnwrappedLineNode> I = Line.Tokens.begin$Const(),
      E = Line.Tokens.end$Const();
       I.$noteq(E); I.$preInc()) {
    final /*const*/ UnwrappedLineNode /*&*/ Node = I.$star();
    for (type$ptr<UnwrappedLine> I$1 = $tryClone(Node.Children.begin$Const()),
        /*P*/ E$1 = $tryClone(Node.Children.end$Const());
         $noteq_ptr(I$1, E$1); I$1.$preInc()) {
      printDebugInfo(I$1.$star(), new StringRef(/*KEEP_STR*/"\nChild: "));
    }
  }
  llvm.dbgs().$out(/*KEEP_STR*/$LF);
}


// Align a single sequence of tokens, see AlignTokens below.
/*template <typename F> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::format::AlignTokenSequence">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 165,
 FQN="clang::format::AlignTokenSequence", NM="Tpl__ZN5clang6formatL18AlignTokenSequenceEjjjOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=Tpl__ZN5clang6formatL18AlignTokenSequenceEjjjOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE")
//</editor-fold>
public static </*typename*/ F extends Change2Bool> void AlignTokenSequence(/*uint*/int Start, /*uint*/int End, /*uint*/int Column, final F /*&&*/Matches,
                  final SmallVector<WhitespaceManager.Change> /*&*/ Changes) {
  boolean FoundMatchOnLine = false;
  int Shift = 0;
  for (/*uint*/int i = Start; i != End; ++i) {
    if ($greater_uint(Changes.$at(i).NewlinesBefore, 0)) {
      FoundMatchOnLine = false;
      Shift = 0;
    }

    // If this is the first matching token to be aligned, remember by how many
    // spaces it has to be shifted, so the rest of the changes on the line are
    // shifted by the same amount
    if (!FoundMatchOnLine && Matches.$call(Changes.$at(i))) {
      FoundMatchOnLine = true;
      Shift = Column - Changes.$at(i).StartOfTokenColumn;
      Changes.$at(i).Spaces += Shift;
    }
    assert (Shift >= 0);
    Changes.$at(i).StartOfTokenColumn += Shift;
    if (i + 1 != Changes.size()) {
      Changes.$at(i + 1).PreviousEndOfTokenColumn += Shift;
    }
  }
}


// Walk through all of the changes and find sequences of matching tokens to
// align. To do so, keep track of the lines and whether or not a matching token
// was found on a line. If a matching token is found, extend the current
// sequence. If the current line cannot be part of a sequence, e.g. because
// there is an empty line before it or it contains only non-matching tokens,
// finalize the previous sequence.
/*template <typename F> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::format::AlignTokens">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 199,
 FQN="clang::format::AlignTokens", NM="Tpl__ZN5clang6formatL11AlignTokensERKNS0_11FormatStyleEOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=Tpl__ZN5clang6formatL11AlignTokensERKNS0_11FormatStyleEOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE")
//</editor-fold>
public static </*typename*/ F extends Change2Bool> void AlignTokens(final /*const*/ FormatStyle /*&*/ Style, final F /*&&*/Matches,
           final SmallVector<WhitespaceManager.Change> /*&*/ Changes) {
  final /*uint*/uint$ref MinColumn = create_uint$ref(0);
  final /*uint*/uint$ref  MaxColumn = create_uint$ref(UINT_MAX);

  // Line number of the start and the end of the current token sequence.
  final /*uint*/uint$ref StartOfSequence = create_uint$ref(0);
  final /*uint*/uint$ref EndOfSequence = create_uint$ref(0);

  // Keep track of the nesting level of matching tokens, i.e. the number of
  // surrounding (), [], or {}. We will only align a sequence of matching
  // token that share the same scope depth.
  //
  // FIXME: This could use FormatToken::NestingLevel information, but there is
  // an outstanding issue wrt the brace scopes.
  /*uint*/int NestingLevelOfLastMatch = 0;
  /*uint*/int NestingLevel = 0;

  // Keep track of the number of commas before the matching tokens, we will only
  // align a sequence of matching tokens if they are preceded by the same number
  // of commas.
  /*uint*/int CommasBeforeLastMatch = 0;
  /*uint*/int CommasBeforeMatch = 0;

  // Whether a matching token has been found on the current line.
  boolean FoundMatchOnLine = false;

  // Aligns a sequence of matching tokens, on the MinColumn column.
  //
  // Sequences start from the first matching token to align, and end at the
  // first token of the first line that doesn't need to be aligned.
  //
  // We need to adjust the StartOfTokenColumn of each Change that is on a line
  // containing any matching token to be aligned and located after such token.
  Void2Void AlignCurrentSequence = /*[&]*/() -> {
        if ($greater_uint(StartOfSequence.$deref(), 0) && $less_uint(StartOfSequence.$deref(), EndOfSequence)) {
          AlignTokenSequence(StartOfSequence.$deref(), EndOfSequence.$deref(), MinColumn.$deref(), Matches,
              Changes);
        }
        MinColumn.$set(0);
        MaxColumn.$set(UINT_MAX);
        StartOfSequence.$set(0);
        EndOfSequence.$set(0);
      };

  for (/*uint*/int i = 0, e = Changes.size(); i != e; ++i) {
    if (Changes.$at(i).NewlinesBefore != 0) {
      CommasBeforeMatch = 0;
      EndOfSequence.$set(i);
      // If there is a blank line, or if the last line didn't contain any
      // matching token, the sequence ends here.
      if ($greater_uint(Changes.$at(i).NewlinesBefore, 1) || !FoundMatchOnLine) {
        AlignCurrentSequence.$call();
      }

      FoundMatchOnLine = false;
    }
    if (Changes.$at(i).Kind == tok.TokenKind.comma) {
      ++CommasBeforeMatch;
    } else if (Changes.$at(i).Kind == tok.TokenKind.r_brace
       || Changes.$at(i).Kind == tok.TokenKind.r_paren
       || Changes.$at(i).Kind == tok.TokenKind.r_square) {
      --NestingLevel;
    } else if (Changes.$at(i).Kind == tok.TokenKind.l_brace
       || Changes.$at(i).Kind == tok.TokenKind.l_paren
       || Changes.$at(i).Kind == tok.TokenKind.l_square) {
      // We want sequences to skip over child scopes if possible, but not the
      // other way around.
      NestingLevelOfLastMatch = std.min_uint(NestingLevelOfLastMatch, NestingLevel);
      ++NestingLevel;
    }
    if (Native.$not(Matches.$call(Changes.$at(i)))) {
      continue;
    }

    // If there is more than one matching token per line, or if the number of
    // preceding commas, or the scope depth, do not match anymore, end the
    // sequence.
    if (FoundMatchOnLine || CommasBeforeMatch != CommasBeforeLastMatch
       || NestingLevel != NestingLevelOfLastMatch) {
      AlignCurrentSequence.$call();
    }

    CommasBeforeLastMatch = CommasBeforeMatch;
    NestingLevelOfLastMatch = NestingLevel;
    FoundMatchOnLine = true;
    if (StartOfSequence.$deref() == 0) {
      StartOfSequence.$set(i);
    }

    /*uint*/int ChangeMinColumn = Changes.$at(i).StartOfTokenColumn;
    int LineLengthAfter = -Changes.$at(i).Spaces;
    for (/*uint*/int j = i; j != e && Changes.$at(j).NewlinesBefore == 0; ++j)  {
      LineLengthAfter += Changes.$at(j).Spaces + Changes.$at(j).TokenLength;
    }
    /*uint*/int ChangeMaxColumn = Style.ColumnLimit - LineLengthAfter;

    // If we are restricted by the maximum column width, end the sequence.
    if ($greater_uint(ChangeMinColumn, MaxColumn.$deref()) || $less_uint(ChangeMaxColumn, MinColumn)
       || CommasBeforeLastMatch != CommasBeforeMatch) {
      AlignCurrentSequence.$call();
      StartOfSequence.$set(i);
    }

    MinColumn.$set(std.max(MinColumn.$deref(), ChangeMinColumn));
    MaxColumn.$set(std.min_uint(MaxColumn.$deref(), ChangeMaxColumn));
  }

  EndOfSequence.$set(Changes.size());
  AlignCurrentSequence.$call();
}

} // END OF class FormatStatics
