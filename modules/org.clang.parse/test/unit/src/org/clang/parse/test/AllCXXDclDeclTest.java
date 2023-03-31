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
 * Collection of all test files from test/CXX/dcl.decl folder
 * @author Vladimir Voskresensky
 */
public class AllCXXDclDeclTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl";
  public AllCXXDclDeclTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXDclDeclTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_dcl_init_list_basic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/basic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/basic.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_ref_basic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/basic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/basic.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_def_default_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.default/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.default/p1.cpp -std=c++11
    RUN("%clang_cc1 -verify %s -std=c++11");
  }

  @Test
  public void test_dcl_init_aggr_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s");
  }

  @Test
  public void test_dcl_init_ref_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_init_string_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.string/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.string/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_array_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.array/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.array/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_dcl_meaning_fct_def_default_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/dcl.fct.def.default/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/dcl.fct.def.default/p1.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_meaning_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_name_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.name/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.name/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_meaning_p1_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/p1-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/p1-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_array_p1_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.array/p1-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.array/p1-cxx0x.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_dcl_fct_default_p10_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p10.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p10.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_p13_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p13.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fcxx-exceptions -fexceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p13.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -fcxx-exceptions -fexceptions -verify %s");
  }

  @Test
  public void test_dcl_fct_p14_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p14.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p14.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_p14_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p14-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p14-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_fct_def_default_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.default/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.default/p2.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -fcxx-exceptions %s");
  }

  @Test
  public void test_dcl_init_string_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.string/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.string/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_default_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_meaning_fct_def_default_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/dcl.fct.def.default/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/dcl.fct.def.default/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_fct_p2_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p2-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p2-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_init_list_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p3.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p3.cpp
    RUN("%clang_cc1 -std=c++14 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p3.cpp -triple i386-pc-solaris2.11
    RUN("%clang_cc1 -std=c++1z -fsyntax-only -verify %s -triple %itanium_abi_triple");
  }

  @Test
  public void test_dcl_init_ref_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_array_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.array/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1y -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.array/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1y -triple x86_64-linux-gnu %s");
  }

  @Test
  public void test_dcl_fct_default_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p3.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_mptr_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.mptr/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.mptr/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_def_delete_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.delete/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.delete/p4.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_aggr_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 -pedantic -Werror ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 -pedantic -Werror  %s");
  }

  @Test
  public void test_dcl_fct_default_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_decl_p4_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/p4-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/p4-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_ref_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_default_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_ref_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.ref/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.ref/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_ref_p5_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_dcl_init_ref_p5_cxx03_extra_copy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-cxx03-extra-copy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-option -Wbind-to-temporary-copy -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-cxx03-extra-copy.cpp
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-show-option -Wbind-to-temporary-copy -verify %s");
  }

  @Test
  public void test_dcl_init_ref_p5_cxx0x_no_extra_copy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-cxx0x-no-extra-copy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-cxx0x-no-extra-copy.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_init_ref_p5_examples_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-examples.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-examples.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-examples.cpp
    RUN("%clang_cc1 -ast-dump %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dcl_init_ref_p5_var_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-var.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-var.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-var.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.ref/p5-var.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_init_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p6.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_default_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p6.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p6.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_p6_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p6-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p6-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_ref_p6_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.ref/p6-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.ref/p6-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_aggr_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-uninitialized -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.aggr/p7.cpp -verify
    RUN("%clang_cc1 -Wno-uninitialized -std=c++1y %s -verify");
  }

  @Test
  public void test_dcl_init_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/p7.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dcl_fct_default_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p7.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_init_list_p7_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -triple x86_64-apple-macosx10.6.7 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -triple x86_64-apple-macosx10.6.7 -verify %s");
  }

  @Test
  public void test_dcl_init_list_p7_0x_fixits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-0x-fixits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wc++11-compat -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-0x-fixits.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-0x-fixits.cpp
    RUN("%clang_cc1 -fsyntax-only -Wc++11-compat -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dcl_init_list_p7_cxx11_nowarn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-cxx11-nowarn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wno-error=c++11-narrowing -triple x86_64-apple-macosx10.6.7 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-cxx11-nowarn.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wno-error=c++11-narrowing -triple x86_64-apple-macosx10.6.7 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wno-error=narrowing -triple x86_64-apple-macosx10.6.7 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.init/dcl.init.list/p7-cxx11-nowarn.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wno-error=narrowing -triple x86_64-apple-macosx10.6.7 -verify %s");
  }

  @Test
  public void test_dcl_fct_def_general_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.general/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.fct.def/dcl.fct.def.general/p8.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_dcl_fct_default_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct.default/p8.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p8.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dcl_fct_p8_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p8-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p8-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dcl_fct_p9_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p9-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/dcl.decl/dcl.meaning/dcl.fct/p9-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }
  
}
