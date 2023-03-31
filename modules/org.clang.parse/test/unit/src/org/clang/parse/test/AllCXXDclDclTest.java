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
package unit.src.org.clang.parse.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/CXX/dcl.dcl folder
 * @author Vladimir Voskresensky
 */
public class AllCXXDclDclTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl";
  public AllCXXDclDclTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXDclDclTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_namespace_unnamed_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/namespace.unnamed/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/namespace.unnamed/p1.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_namespace_def_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 -pedantic ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 -pedantic %s");
  }

  @Test
  public void test_namespace_udecl_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_namespace_udir_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udir/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udir/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_attr_depend_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.depend/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.depend/p1.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_attr_deprecated_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.deprecated/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.deprecated/p1.cpp
    RUN("%clang_cc1 -std=c++1y -verify %s");
  }

  @Test
  public void test_dcl_attr_fallthrough_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.fallthrough/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.fallthrough/p1.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_attr_nodiscard_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_attr_noreturn_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.noreturn/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.noreturn/p1.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fcxx-exceptions %s");
  }

  @Test
  public void test_dcl_attr_unused_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_constexpr_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s");
  }

  @Test
  public void test_dcl_inline_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.inline/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.inline/p1.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_stc_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_type_elab_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p1.cpp -std=c++11
    RUN("%clang_cc1 -verify %s -std=c++11");
  }

  @Test
  public void test_namespace_udecl_p10_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p10.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p10.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_stc_p10_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p10.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p10.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_namespace_udecl_p11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p11.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_namespace_udecl_p12_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p12.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p12.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p12.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p12.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_spec_auto_p12_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p12-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p12-1y.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p12-1y.cpp
    RUN("%clang_cc1 -std=c++1y -verify %s");
  }

  @Test
  public void test_namespace_udecl_p13_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p13.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p13.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_namespace_udecl_p15_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p15.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p15.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_namespace_udecl_p18_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p18.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p18.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_namespace_def_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_attr_depend_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.depend/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.depend/p2.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_attr_nodiscard_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1z -verify -Wc++1z-extensions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++1z -verify -Wc++1z-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify -DEXT -Wc++1z-extensions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify -DEXT -Wc++1z-extensions %s");
  }

  @Test
  public void test_dcl_attr_unused_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_enum_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.enum/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.enum/p2.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_link_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p2.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_constexpr_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p2.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p2.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dcl_stc_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_spec_auto_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p2.cpp -std=c++11
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_dcl_type_elab_p2_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p2-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p2-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_typedef_p2_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.typedef/p2-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.typedef/p2-0x.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_attr_grammar_p2_1z_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.grammar/p2-1z.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.grammar/p2-1z.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_spec_auto_p2_1z_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p2-1z.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p2-1z.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_namespace_memdef_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/namespace.memdef/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/namespace.memdef/p3.cpp -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_namespace_udecl_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p3.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p3.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_attr_nodiscard_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.nodiscard/p3.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_attr_unused_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -Wused-but-marked-unused -std=c++1z -Wc++1z-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -Wused-but-marked-unused -std=c++1z -Wc++1z-extensions -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -Wused-but-marked-unused -std=c++11 -Wc++1z-extensions -verify -DEXT ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -Wused-but-marked-unused -std=c++11 -Wc++1z-extensions -verify -DEXT %s");
  }

  @Test
  public void test_dcl_constexpr_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fcxx-exceptions -triple=x86_64-linux-gnu -std=c++11 -Werror=c++1y-extensions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p3.cpp
    RUN("%clang_cc1 -verify -fcxx-exceptions -triple=x86_64-linux-gnu -std=c++11 -Werror=c++1y-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fcxx-exceptions -triple=x86_64-linux-gnu -std=c++1y -DCXX1Y ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p3.cpp
    RUN("%clang_cc1 -verify -fcxx-exceptions -triple=x86_64-linux-gnu -std=c++1y -DCXX1Y %s");
  }

  @Test
  public void test_dcl_fct_spec_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p3.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_dcl_spec_auto_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3.cpp -std=c++98 -Wno-c++11-extensions -Wc++11-compat
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98 -Wno-c++11-extensions -Wc++11-compat");
  }

  @Test
  public void test_dcl_type_elab_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.elab/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_typedef_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.typedef/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.typedef/p3.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_dcl_type_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/p3-0x.cpp -fcxx-exceptions
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s -fcxx-exceptions");
  }

  @Test
  public void test_dcl_spec_auto_p3_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3-1y.cpp -std=c++1y -DCXX1Y
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1y -DCXX1Y");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3-1y.cpp -std=c++11 -Wno-c++1y-extensions
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11 -Wno-c++1y-extensions");
  }

  @Test
  public void test_dcl_spec_auto_p3_generic_lambda_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3-generic-lambda-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p3-generic-lambda-1y.cpp -std=c++1y -DCXX1Y
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1y -DCXX1Y");
  }

  @Test
  public void test_namespace_udecl_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_attr_unused_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.unused/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_constexpr_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 -fcxx-exceptions -Werror=c++1y-extensions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p4.cpp
    RUN("%clang_cc1 -verify -std=c++11 -fcxx-exceptions -Werror=c++1y-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++1y -fcxx-exceptions -DCXX1Y ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p4.cpp
    RUN("%clang_cc1 -verify -std=c++1y -fcxx-exceptions -DCXX1Y %s");
  }

  @Test
  public void test_dcl_fct_spec_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_spec_auto_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p4.cpp -std=c++1y
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1y");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p4.cpp -std=c++11 -Wno-c++1y-extensions
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11 -Wno-c++1y-extensions");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p4.cpp -std=c++98 -Wno-c++11-extensions
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98 -Wno-c++11-extensions");
  }

  @Test
  public void test_dcl_typedef_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.typedef/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.typedef/p4.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_dcl_dcl_p4_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/p4-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/p4-0x.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -verify -fsyntax-only %s");
  }

  @Test
  public void test_dcl_type_simple_p4_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.simple/p4-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.simple/p4-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_align_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-linux-gnu -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p5.cpp
    RUN("%clang_cc1 -std=c++11 -triple x86_64-linux-gnu -verify %s");
  }

  @Test
  public void test_dcl_enum_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.enum/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.enum/p5.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_constexpr_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-unknown-unknown -verify -std=c++11 -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-unknown-unknown -verify -std=c++11 -fcxx-exceptions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-unknown-unknown -verify -std=c++14 -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-unknown-unknown -verify -std=c++14 -fcxx-exceptions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-unknown-unknown -std=c++11 -fcxx-exceptions -Wno-invalid-constexpr ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p5.cpp -DNO_INVALID_CONSTEXPR
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-unknown-unknown -std=c++11 -fcxx-exceptions -Wno-invalid-constexpr %s -DNO_INVALID_CONSTEXPR");
  }

  @Test
  public void test_dcl_inline_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.inline/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.inline/p5.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_dcl_spec_auto_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p5.cpp -std=c++11
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_namespace_udecl_p5_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p5-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p5-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_type_simple_p5_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.simple/p5-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.type.simple/p5-cxx0x.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_namespace_udir_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udir/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udir/p6.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_align_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p6.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_attr_grammar_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.grammar/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.attr.grammar/p6.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_constexpr_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p6.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_fct_spec_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p6.cpp
    RUN("%clang_cc1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p6.cpp
    RUN("%clang_cc1 -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.fct.spec/p6.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_spec_auto_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p6.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p6.cpp -std=c++98 -Wno-c++11-extensions
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98 -Wno-c++11-extensions");
  }

  @Test
  public void test_namespace_udecl_p6_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p6-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p6-cxx11.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_namespace_def_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p7.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_namespace_udecl_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p7.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_align_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p7.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_link_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p7.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p7.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dcl_spec_auto_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p7.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p7.cpp -std=c++98 -Wno-c++11-extensions
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98 -Wno-c++11-extensions");
  }

  @Test
  public void test_dcl_spec_auto_p7_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p7-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.type/dcl.spec.auto/p7-1y.cpp
    RUN("%clang_cc1 -verify -std=c++1y %s");
  }

  @Test
  public void test_dcl_link_p7_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p7-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -o - ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p7-2.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.link/p7-2.cpp
    RUN("%clang_cc1 -ast-print -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_namespace_def_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.def/p8.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_namespace_udecl_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_align_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.attr/dcl.align/p8.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_constexpr_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p8.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_namespace_udecl_p8_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CXX98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++98 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CXX98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CXX11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/basic.namespace/namespace.udecl/p8-cxx0x.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CXX11 %s");
  }

  @Test
  public void test_dcl_constexpr_p9_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p9.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.constexpr/p9.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_stc_p9_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p9.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.dcl/dcl.spec/dcl.stc/p9.cpp
    RUN("%clang_cc1 -verify %s");
  }
  
}
