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
package org.clang.sema.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.clank.java.JavaTestBase;
import org.junit.*;

/**
 * Collection of all test files from test/SemaCUDA folder
 * @author Vladimir Voskresensky
 */
public class AllSemaCUDATest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/";
  public AllSemaCUDATest() {
    super(TEST_LOCATION, JavaTestBase.TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaCUDATest.txt");
  }  
  
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_addr_of_overloaded_fn_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/addr-of-overloaded-fn.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/addr-of-overloaded-fn.cu
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/addr-of-overloaded-fn.cu
    RUN("%clang_cc1 -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify %s");
  }

  @Test
  public void test_alias_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/alias.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fsyntax-only -fcuda-is-device -verify -DEXPECT_ERR ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/alias.cu
    RUN("%clang_cc1 -triple nvptx-unknown-cuda -fsyntax-only -fcuda-is-device -verify -DEXPECT_ERR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/alias.cu
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_amdgpu_num_gpr_attr_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/amdgpu-num-gpr-attr.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/amdgpu-num-gpr-attr.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_asm_constraints_device_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/asm-constraints-device.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/asm-constraints-device.cu
    RUN("%clang_cc1 -triple nvptx-unknown-cuda -fsyntax-only -fcuda-is-device -verify %s");
  }

  @Test
  public void test_asm_constraints_mixed_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/asm-constraints-mixed.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/asm-constraints-mixed.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -fsyntax-only -fcuda-is-device -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/asm-constraints-mixed.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_attributes_on_non_cuda_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/attributes-on-non-cuda.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/attributes-on-non-cuda.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/attributes-on-non-cuda.cu
    RUN("%clang_cc1 -fsyntax-only -fcuda-is-device -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DEXPECT_WARNINGS -fsyntax-only -verify -x c ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/attributes-on-non-cuda.cu
    RUN("%clang_cc1 -DEXPECT_WARNINGS -fsyntax-only -verify -x c %s");
  }

  @Test
  public void test_bad_attributes_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/bad-attributes.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wcuda-compat -verify -DEXPECT_INLINE_WARNING ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/bad-attributes.cu
    RUN("%clang_cc1 -fsyntax-only -Wcuda-compat -verify -DEXPECT_INLINE_WARNING %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -fsyntax-only -Wcuda-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/bad-attributes.cu
    RUN("%clang_cc1 -fcuda-is-device -fsyntax-only -Wcuda-compat -verify %s");
  }

  @Test
  public void test_builtins_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/builtins.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -aux-triple nvptx64-unknown-cuda -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/builtins.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -aux-triple nvptx64-unknown-cuda -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-cuda -fcuda-is-device -aux-triple x86_64-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/builtins.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple nvptx64-unknown-cuda -fcuda-is-device -aux-triple x86_64-unknown-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_call_overloaded_destructor_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/call-overloaded-destructor.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/call-overloaded-destructor.cu
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/call-overloaded-destructor.cu
    RUN("%clang_cc1 -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify %s");
  }

  @Test
  public void test_config_type_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/config-type.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/config-type.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cuda_builtin_vars_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/cuda-builtin-vars.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-nvidia-cuda -fcuda-is-device -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/cuda-builtin-vars.cu
    RUN("%clang_cc1 \"-triple\" \"nvptx-nvidia-cuda\" -fcuda-is-device -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx11_kernel_call_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/cxx11-kernel-call.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/cxx11-kernel-call.cu
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_device_var_init_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/device-var-init.cu");
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/device-var-init.cu -triple nvptx64-nvidia-cuda -fcuda-is-device -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/device-var-init.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -verify %s -triple nvptx64-nvidia-cuda -fcuda-is-device -std=c++11 %s");
  }

  @Test
  public void test_function_overload_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/function-overload.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/function-overload.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/function-overload.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify %s");
  }

  @Test
  public void test_function_target_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/function-target.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/function-target.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/function-target.cu
    RUN("%clang_cc1 -fsyntax-only -fcuda-is-device -verify %s");
  }

  @Test
  public void test_host_device_constexpr_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/host-device-constexpr.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/host-device-constexpr.cu
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -isystem %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/host-device-constexpr.cu -fcuda-is-device
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -isystem %S/Inputs %s -fcuda-is-device");
  }

  @Test
  public void test_implicit_copy_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-copy.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -triple nvptx64-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-copy.cu
    RUN("%clang_cc1 -std=gnu++11 -triple nvptx64-unknown-unknown -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -triple nvptx64-unknown-unknown -fcuda-is-device -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-copy.cu
    RUN("%clang_cc1 -std=gnu++11 -triple nvptx64-unknown-unknown -fcuda-is-device -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_intrinsic_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-intrinsic.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-unknown -fcuda-is-device -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-intrinsic.cu
    RUN("%clang_cc1 -triple nvptx64-unknown-unknown -fcuda-is-device -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_member_target_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-member-target.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-member-target.cu
    RUN("%clang_cc1 -std=gnu++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_member_target_collision_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-member-target-collision.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-member-target-collision.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_member_target_collision_cxx11_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-member-target-collision-cxx11.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/implicit-member-target-collision-cxx11.cu
    RUN("%clang_cc1 -std=gnu++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_kernel_call_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/kernel-call.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/kernel-call.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_launch_bounds_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/launch_bounds.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/launch_bounds.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_target_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/method-target.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/method-target.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_host_device_constexpr_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/no-host-device-constexpr.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fno-cuda-host-device-constexpr -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/no-host-device-constexpr.cu
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -fno-cuda-host-device-constexpr -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fno-cuda-host-device-constexpr -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/no-host-device-constexpr.cu
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -fno-cuda-host-device-constexpr -fcuda-is-device -verify %s");
  }

  @Test
  public void test_overloaded_delete_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/overloaded-delete.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/overloaded-delete.cu
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/overloaded-delete.cu
    RUN("%clang_cc1 -triple nvptx64-nvidia-cuda -fsyntax-only -fcuda-is-device -verify %s");
  }

  @Test
  public void test_pr27778_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/pr27778.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/pr27778.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_qualifiers_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fsyntax-only -verify -fcuda-is-device ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu
    RUN("%clang_cc1 -triple nvptx-unknown-cuda -fsyntax-only -verify -fcuda-is-device %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu --check-prefix=CHECK-ALL --check-prefix=CHECK-HOST
    RUN("not %clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -ast-dump %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ALL --check-prefix=CHECK-HOST");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fsyntax-only -ast-dump -fcuda-is-device ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/qualifiers.cu --check-prefix=CHECK-ALL --check-prefix=CHECK-DEVICE
    RUN("not %clang_cc1 -triple nvptx-unknown-cuda -fsyntax-only -ast-dump -fcuda-is-device %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ALL --check-prefix=CHECK-DEVICE");
  }

  @Test
  public void test_vararg_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/vararg.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -fsyntax-only -verify -DEXPECT_VA_ARG_ERR -DEXPECT_VARARG_ERR ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/vararg.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -fsyntax-only -verify -DEXPECT_VA_ARG_ERR -DEXPECT_VARARG_ERR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -fsyntax-only -fcuda-allow-variadic-functions -verify -DEXPECT_VA_ARG_ERR ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/vararg.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -fsyntax-only -fcuda-allow-variadic-functions -verify -DEXPECT_VA_ARG_ERR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify -DEXPECT_VARARG_ERR ${LLVM_SRC}/llvm/tools/clang/test/SemaCUDA/vararg.cu
    RUN(JavaTestBase.TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify -DEXPECT_VARARG_ERR %s");
  }
  
}
