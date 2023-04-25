/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * <p>
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * <p>
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * <p>
 * Developed by:
 * <p>
 * LLVM Team
 * <p>
 * University of Illinois at Urbana-Champaign
 * <p>
 * http://llvm.org
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * <p>
 * * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimers.
 * <p>
 * * Redistributions in binary form must reproduce the above copyright notice
 * this list of conditions and the following disclaimers in the
 * documentation and/or other materials provided with the distribution.
 * <p>
 * * Neither the names of the LLVM Team, University of Illinois at
 * Urbana-Champaign, nor the names of its contributors may be used to
 * endorse or promote products derived from this Software without specific
 * prior written permission.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * <p>
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * <p>
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * <p>
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * <p>
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 * llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.format;

import org.clang.tooling.core.Range;
import org.clang.tooling.core.Replacements;
import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.JavaCleaner;
import org.clank.support.JavaDifferentiators.JD$T$C$P_T2$C$R;
import org.clank.support.aliases.uint$ptr;
import org.junit.Test;
import org.llvm.adt.ADTSupportTestBase;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.support.Expected;
import org.netbeans.api.annotations.common.NonNull;

import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.applyAllReplacements;
import static org.clang.tooling.ToolingGlobals.calculateRangesAfterReplacements;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.NativePointer.*;


//<editor-fold defaultstate="collapsed" desc="static type SortIncludesTest">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
        NM = "SortIncludesTest",
        cmd = "jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -test=SortIncludesTest")
//</editor-fold>
public final class SortIncludesTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {
//JAVA: namespace (anonymous) {

  private final FormatStyle Style/* = getLLVMStyle()*/;


  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest::SortIncludesTest">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 21,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest::SortIncludesTest", NM = "_ZN5clang6format12_GLOBAL__N_116SortIncludesTestC1Ev",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_116SortIncludesTestC1Ev")
  //</editor-fold>
  public /*inline*/ SortIncludesTest() {
    // : Test(), Style($c$.track(getLLVMStyle()))
    //START JInit
    super(TestState.Successful);
    /*InClass*/
    this.Style = getLLVMStyle();
    //END JInit
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 21,
// FQN="clang::format::(anonymous namespace)::SortIncludesTest", NM="_ZN5clang6format12_GLOBAL__N_116SortIncludesTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_116SortIncludesTestE")
////</editor-fold>
//public abstract static class SortIncludesTest extends /*public*/ Test implements Destructors.ClassWithDestructor {
  /*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest::GetCodeRange">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 23,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest::GetCodeRange", NM = "_ZN5clang6format12_GLOBAL__N_116SortIncludesTest12GetCodeRangeEN4llvm9StringRefE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_116SortIncludesTest12GetCodeRangeEN4llvm9StringRefE")
  //</editor-fold>
  private std.vector<Range> GetCodeRange(StringRef Code) {
    return new std.vector<Range>(1, new Range(0, Code.size()), new Range());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest::sort">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 27,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest::sort", NM = "_ZN5clang6format12_GLOBAL__N_116SortIncludesTest4sortEN4llvm9StringRefES4_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_116SortIncludesTest4sortEN4llvm9StringRefES4_")
  //</editor-fold>
  private std.string sort(StringRef Code) {
    return sort(Code, GetCodeRange(Code), new StringRef(/*KEEP_STR*/"input.cpp"));
  }

  private std.string sort(StringRef Code, StringRef FileName/*= "input.cpp"*/) {
    return sort(Code, GetCodeRange(Code), FileName);
  }

  private std.string sort(StringRef Code, std.vector<Range> Ranges) {
    return sort(Code, Ranges, new StringRef(/*KEEP_STR*/"input.cpp"));
  }

  private std.string sort(@NonNull StringRef Code,
                          @NonNull std.vector<Range> Ranges,
                          @NonNull StringRef FileName/*= "input.cpp"*/) {
    Expected<std.string> Sorted = null;
    Expected<std.string> Result = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Sorted = $c$.clean(
              applyAllReplacements(
                      new StringRef(Code),
                      $c$.track(
                              sortIncludes(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false), new StringRef(FileName))
                      )
              )
      );
      /*static_cast*/
      EXPECT_TRUE(Sorted.$bool());
      Result = $c$.clean(
              applyAllReplacements(
                      new StringRef(Sorted.$star()),
                      $c$.track(
                              reformat(Style, new StringRef(Sorted.$star()), new ArrayRef<Range>(Ranges, false), new StringRef(FileName))
                      )
              )
      );
      /*static_cast*/
      EXPECT_TRUE(Result.$bool());
      return new std.string(Result.$star());
    } finally {
      if (Result != null) {
        Result.$destroy();
      }
      if (Sorted != null) {
        Sorted.$destroy();
      }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest::newCursor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 38,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest::newCursor", NM = "_ZN5clang6format12_GLOBAL__N_116SortIncludesTest9newCursorEN4llvm9StringRefEj",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_116SortIncludesTest9newCursorEN4llvm9StringRefEj")
  //</editor-fold>
  private
  /*uint*/int newCursor(StringRef Code, /*uint*/int Cursor) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      uint$ptr Cursor$ptr = create_uint$ptr(Cursor);
      $c$.clean($c$.track(sortIncludes(Style, new StringRef(Code), new ArrayRef<Range>($c$.track(GetCodeRange(new StringRef(Code))), false), new StringRef(/*KEEP_STR*/"input.cpp"), /*AddrOf*/Cursor$ptr)));
      return Cursor$ptr.$star();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest::~SortIncludesTest">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 21,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest::~SortIncludesTest", NM = "_ZN5clang6format12_GLOBAL__N_116SortIncludesTestD0Ev",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_116SortIncludesTestD0Ev")
  //</editor-fold>
  @Override
  public /*inline*/ void $destroy() {
    //START JDestroy
    Style.$destroy();
    super.$destroy();
    //END JDestroy
  }

  @Override
  public String toString() {
    return "Style=" + Style // NOI18N
            + super.toString(); // NOI18N
  }
//}

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_BasicSorting_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 47,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_BasicSorting_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_134SortIncludesTest_BasicSorting_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134SortIncludesTest_BasicSorting_Test8TestBodyEv")
//</editor-fold>
  public void test_BasicSorting() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ(
            "#include \"a.h\"\n"
                    + "#include \"b.h\"\n"
                    + "#include \"c.h\"\n",
            sort(new StringRef(/*KEEP_STR*/
                    "#include \"a.h\"\n"
                            + "#include \"c.h\"\n"
                            + "#include \"b.h\"\n")));
    EXPECT_EQ("// comment\n"
                    + "#include <a>\n"
                    + "#include <b>\n",
            sort(new StringRef(
                    "// comment\n"
                            + "#include <b>\n"
                            + "#include <a>\n"
            ), new std.vector<Range>(new Range[]{new Range(25, 1)}, 1, Range::new)));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_NoReplacementsForValidIncludes_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 56,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_NoReplacementsForValidIncludes_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_152SortIncludesTest_NoReplacementsForValidIncludes_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_152SortIncludesTest_NoReplacementsForValidIncludes_Test8TestBodyEv")
//</editor-fold>
  public void test_NoReplacementsForValidIncludes() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Identical #includes have led to a failure with an unstable sort.
      std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE,
              "#include <a>\n" +
                      "#include <b>\n" +
                      "#include <c>\n" +
                      "#include <d>\n" +
                      "#include <e>\n" +
                      "#include <f>\n");
      EXPECT_TRUE($c$.track(sortIncludes(Style, new StringRef(Code), new ArrayRef<Range>($c$.track(GetCodeRange(new StringRef(Code))), false), new StringRef(/*KEEP_STR*/"a.cc"))).empty());
      $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_SupportClangFormatOff_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 67,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_SupportClangFormatOff_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_143SortIncludesTest_SupportClangFormatOff_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143SortIncludesTest_SupportClangFormatOff_Test8TestBodyEv")
//</editor-fold>
  public void test_SupportClangFormatOff() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include <a>\n"
            + "#include <b>\n"
            + "#include <c>\n"
            + "// clang-format off\n"
            + "#include <b>\n"
            + "#include <a>\n"
            + "#include <c>\n"
            + "// clang-format on\n", sort(new StringRef(/*KEEP_STR*/
            "#include <b>\n"
                    + "#include <a>\n"
                    + "#include <c>\n"
                    + "// clang-format off\n"
                    + "#include <b>\n"
                    + "#include <a>\n"
                    + "#include <c>\n"
                    + "// clang-format on\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_IncludeSortingCanBeDisabled_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 86,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_IncludeSortingCanBeDisabled_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_149SortIncludesTest_IncludeSortingCanBeDisabled_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149SortIncludesTest_IncludeSortingCanBeDisabled_Test8TestBodyEv")
//</editor-fold>
  public void test_IncludeSortingCanBeDisabled() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    Style.SortIncludes = false;
    EXPECT_EQ("#include \"a.h\"\n#include \"c.h\"\n#include \"b.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"a.h\"\n#include \"c.h\"\n#include \"b.h\"\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_MixIncludeAndImport_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 96,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_MixIncludeAndImport_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_141SortIncludesTest_MixIncludeAndImport_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141SortIncludesTest_MixIncludeAndImport_Test8TestBodyEv")
//</editor-fold>
  public void test_MixIncludeAndImport() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include \"a.h\"\n#import \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"a.h\"\n#include \"c.h\"\n#import \"b.h\"\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_FixTrailingComments_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 105,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_FixTrailingComments_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_141SortIncludesTest_FixTrailingComments_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141SortIncludesTest_FixTrailingComments_Test8TestBodyEv")
//</editor-fold>
  public void test_FixTrailingComments() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include \"a.h\"  // comment\n"
            + "#include \"bb.h\" // comment\n"
            + "#include \"ccc.h\"\n", sort(new StringRef(/*KEEP_STR*/
            "#include \"a.h\" // comment\n"
                    + "#include \"ccc.h\"\n"
                    + "#include \"bb.h\" // comment\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_LeadingWhitespace_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 114,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_LeadingWhitespace_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_139SortIncludesTest_LeadingWhitespace_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139SortIncludesTest_LeadingWhitespace_Test8TestBodyEv")
//</editor-fold>
  public void test_LeadingWhitespace() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/" #include \"a.h\"\n  #include \"c.h\"\n   #include \"b.h\"\n")));
    EXPECT_EQ("#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"# include \"a.h\"\n#  include \"c.h\"\n#   include \"b.h\"\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_GreaterInComment_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 129,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_GreaterInComment_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_138SortIncludesTest_GreaterInComment_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138SortIncludesTest_GreaterInComment_Test8TestBodyEv")
//</editor-fold>
  public void test_GreaterInComment() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include \"a.h\"\n"
            + "#include \"b.h\" // >\n"
            + "#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/
            "#include \"a.h\"\n"
                    + "#include \"c.h\"\n"
                    + "#include \"b.h\" // >\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_SortsLocallyInEachBlock_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 138,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_SortsLocallyInEachBlock_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_145SortIncludesTest_SortsLocallyInEachBlock_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145SortIncludesTest_SortsLocallyInEachBlock_Test8TestBodyEv")
//</editor-fold>
  public void test_SortsLocallyInEachBlock() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include \"a.h\"\n#include \"c.h\"\n\n#include \"b.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"a.h\"\n#include \"c.h\"\n\n#include \"b.h\"\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_HandlesAngledIncludesAsSeparateBlocks_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 149,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_HandlesAngledIncludesAsSeparateBlocks_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_159SortIncludesTest_HandlesAngledIncludesAsSeparateBlocks_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_159SortIncludesTest_HandlesAngledIncludesAsSeparateBlocks_Test8TestBodyEv")
//</editor-fold>
  public void test_HandlesAngledIncludesAsSeparateBlocks() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EXPECT_EQ("#include \"a.h\"\n#include \"c.h\"\n#include <b.h>\n#include <d.h>\n", sort(new StringRef(/*KEEP_STR*/"#include <d.h>\n#include <b.h>\n#include \"c.h\"\n#include \"a.h\"\n")));

      $c$.clean(Style.$assignMove($c$.track(getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp))));
      EXPECT_EQ("#include <b.h>\n#include <d.h>\n#include \"a.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include <d.h>\n#include <b.h>\n#include \"c.h\"\n#include \"a.h\"\n")));
    } finally {
      $c$.$destroy();
    }
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_HandlesMultilineIncludes_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 170,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_HandlesMultilineIncludes_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_146SortIncludesTest_HandlesMultilineIncludes_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146SortIncludesTest_HandlesMultilineIncludes_Test8TestBodyEv")
//</editor-fold>
  public void test_HandlesMultilineIncludes() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ("#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"a.h\"\n#include \\\n\"c.h\"\n#include \"b.h\"\n")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_LeavesMainHeaderFirst_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 180,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_LeavesMainHeaderFirst_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_143SortIncludesTest_LeavesMainHeaderFirst_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143SortIncludesTest_LeavesMainHeaderFirst_Test8TestBodyEv")
//</editor-fold>
  public void test_LeavesMainHeaderFirst() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    Style.IncludeIsMainRegex.$assign_T$C$P(/*KEEP_STR*/"([-_](test|unittest))?$");
    EXPECT_EQ("#include \"llvm/a.h\"\n#include \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"llvm/a.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"a.cc")));
    EXPECT_EQ("#include \"llvm/a.h\"\n#include \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"llvm/a.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"a_test.cc")));
    EXPECT_EQ("#include \"llvm/input.h\"\n#include \"b.h\"\n#include \"c.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"llvm/input.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"input.mm")));

    // Don't allow prefixes.
    EXPECT_EQ("#include \"b.h\"\n#include \"c.h\"\n#include \"llvm/not_a.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"llvm/not_a.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"a.cc")));

    // Don't do this for _main and other suffixes.
    EXPECT_EQ("#include \"b.h\"\n#include \"c.h\"\n#include \"llvm/a.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"llvm/a.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"a_main.cc")));

    // Don't do this in headers.
    EXPECT_EQ("#include \"b.h\"\n#include \"c.h\"\n#include \"llvm/a.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"llvm/a.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"a.h")));

    // Only do this in the first #include block.
    EXPECT_EQ("#include <a>\n\n#include \"b.h\"\n#include \"c.h\"\n#include \"llvm/a.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include <a>\n\n#include \"llvm/a.h\"\n#include \"c.h\"\n#include \"b.h\"\n"), new StringRef(/*KEEP_STR*/"a.cc")));

    // Only recognize the first #include with a matching basename as main include.
    EXPECT_EQ("#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\n#include \"llvm/a.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"b.h\"\n#include \"a.h\"\n#include \"c.h\"\n#include \"llvm/a.h\"\n"), new StringRef(/*KEEP_STR*/"a.cc")));
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_NegativePriorities_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 256,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_NegativePriorities_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_140SortIncludesTest_NegativePriorities_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140SortIncludesTest_NegativePriorities_Test8TestBodyEv")
//</editor-fold>
  public void test_NegativePriorities() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Style.IncludeCategories.$assign($c$.track(new /*const*/ FormatStyle.IncludeCategory[/*2*/]{new FormatStyle.IncludeCategory($(".*important_os_header.*"), -1), new FormatStyle.IncludeCategory($DOT_STAR, 1)})));
      EXPECT_EQ("#include \"important_os_header.h\"\n#include \"c_main.h\"\n#include \"a_other.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"c_main.h\"\n#include \"a_other.h\"\n#include \"important_os_header.h\"\n"), new StringRef(/*KEEP_STR*/"c_main.cc")));

      // check stable when re-run
      EXPECT_EQ("#include \"important_os_header.h\"\n#include \"c_main.h\"\n#include \"a_other.h\"\n", sort(new StringRef(/*KEEP_STR*/"#include \"important_os_header.h\"\n#include \"c_main.h\"\n#include \"a_other.h\"\n"), new StringRef(/*KEEP_STR*/"c_main.cc")));
    } finally {
      $c$.$destroy();
    }
  }

  @Test
  public void test_DeduplicateIncludes() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ(new StringRef("""
                    #include <a>
                    #include <b>
                    #include <c>
                    """),
            sort(new StringRef("""
                    #include <a>
                    #include <b>
                    #include <b>
                    #include <b>
                    #include <b>
                    #include <c>
                    """)));
  }

  @Test
  public void test_SortAndDeduplicateIncludes() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    EXPECT_EQ(new StringRef("""
                    #include <a>
                    #include <b>
                    #include <c>
                    """),
            sort(new StringRef("""
                    #include <b>
                    #include <a>
                    #include <b>
                    #include <b>
                    #include <c>
                    #include <b>
                    """)));
  }

  @Test
  public void test_CalculatesCorrectCursorPositionAfterDeduplicate() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    std.string Code = new std.string("#include <b>\n" +     // Start of line: 0
            "#include <a>\n" +     // Start of line: 13
            "#include <b>\n" +     // Start of line: 26
            "#include <b>\n" +     // Start of line: 39
            "#include <c>\n" +     // Start of line: 52
            "#include <b>\n");     // Start of line: 65
    std.string Expected = new std.string("#include <a>\n" +  // Start of line: 0
            "#include <b>\n" +  // Start of line: 13
            "#include <c>\n"); // Start of line: 26
    EXPECT_EQ(Expected, sort(new StringRef(Code)));
    // Cursor on 'i' in "#include <a>".
    EXPECT_EQ(1, newCursor(new StringRef(Code), 14));
    // Cursor on 'b' in "#include <b>".
    EXPECT_EQ(23, newCursor(new StringRef(Code), 10));
    EXPECT_EQ(23, newCursor(new StringRef(Code), 36));
    EXPECT_EQ(23, newCursor(new StringRef(Code), 49));
    EXPECT_EQ(23, newCursor(new StringRef(Code), 36));
    EXPECT_EQ(23, newCursor(new StringRef(Code), 75));
    // Cursor on '#' in "#include <c>".
    EXPECT_EQ(26, newCursor(new StringRef(Code), 52));
  }

  @Test
  public void test_DeduplicateLocallyInEachBlock() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }

    EXPECT_EQ(new StringRef("""
                    #include <a>
                    #include <b>

                    #include <b>
                    #include <c>
                    """),
            sort(new StringRef("""
                    #include <a>
                    #include <b>

                    #include <c>
                    #include <b>
                    #include <b>
                    """)));
  }

  @Test
  public void test_ValidAffactedRangesAfterDeduplicatingIncludes() {
    std.string Code = new std.string("""
            #include <a>
            #include <b>
            #include <a>
            #include <a>

               int     x ;""");
//    std::vector<tooling::Range> Ranges = {tooling::Range(0, 52)};
    std.vector<Range> Ranges = new std.vector<>(new Range[]{new Range(0, 52)}, 1, Range::new);
    Replacements Replaces = sortIncludes(Style, new StringRef(Code), new ArrayRef<>(Ranges), new StringRef("input.cpp"));
    Ranges = calculateRangesAfterReplacements(Replaces, Ranges);
    EXPECT_EQ(1, Ranges.size());
    EXPECT_EQ(0, Ranges.$at(0).getOffset());
    EXPECT_EQ(26, Ranges.$at(0).getLength());
  }

  @Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortIncludesTest_CalculatesCorrectCursorPosition_Test::TestBody">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
          source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp", line = 276,
          FQN = "clang::format::(anonymous namespace)::SortIncludesTest_CalculatesCorrectCursorPosition_Test::TestBody", NM = "_ZN5clang6format12_GLOBAL__N_153SortIncludesTest_CalculatesCorrectCursorPosition_Test8TestBodyEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortIncludesTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153SortIncludesTest_CalculatesCorrectCursorPosition_Test8TestBodyEv")
//</editor-fold>
  public void test_CalculatesCorrectCursorPosition() {
    if (markAsSkippedIfNeed(TestState.Successful)) {
      return;
    }
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <ccc>\n#include <bbbbbb>\n#include <a>\n"); // Start of line: 33
    EXPECT_EQ(31/*U*/, newCursor(new StringRef(Code), 0));
    EXPECT_EQ(13/*U*/, newCursor(new StringRef(Code), 15));
    EXPECT_EQ(0/*U*/, newCursor(new StringRef(Code), 33));
    EXPECT_EQ(41/*U*/, newCursor(new StringRef(Code), 10));
    EXPECT_EQ(23/*U*/, newCursor(new StringRef(Code), 25));
    EXPECT_EQ(10/*U*/, newCursor(new StringRef(Code), 43));
  }

//} JAVA: end of namespace (anonymous) // end namespace
//} JAVA: end of namespace format // end namespace format
//} JAVA: end of namespace clang
} // END OF class SortIncludesTest
