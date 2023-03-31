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

import org.clang.ast.*;
import org.clang.ast.java.AstDeclarationsRTTI;
import org.clang.ast.java.AstJavaFixedRTTI;
import org.clang.ast.java.AstRTTI;
import org.clang.ast.java.AstStatementsRTTI;
import org.clang.basic.*;
import org.clang.sema.IdentifierResolver;
import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.JavaDifferentiators.JD$Pair$_U1$_U2;
import org.clank.support.aliases.type$ptr;
import org.clank.support.aliases.type$ref;
import org.clank.support.aliases.uint$ref;
import org.llvm.adt.FoldingSetNodeID;
import org.llvm.adt.aliases.*;
import org.llvm.support.llvm;
import org.llvm.support.llvm_unreachable;
import serialization.ASTReader;
import serialization.ModuleFile;
import serialization.ModuleKind;

import static org.clank.support.Native.$tryClone;
import static serialization.impl.ASTReaderDeclStatics.*;
import static serialization.impl.SerializationStatics.needsAnonymousDeclarationNumber;
import static serialization.impl.SerializationStatics.numberAnonymousDeclsWithin;

//<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 37,
 FQN="clang::ASTDeclReader", NM="_ZN5clang13ASTDeclReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReaderE")
//</editor-fold>
public class ASTDeclReader implements /*public*/ DeclVisitorVoid<ASTDeclReader> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ F;
  private long/*uint64_t*/ Offset;
  private /*const*//*uint32_t*/int ThisDeclID;
  private /*const*/ SourceLocation ThisDeclLoc;
  // JAVA: typedef ASTReader::RecordData RecordData
//  public final class RecordData extends SmallVectorULong{ };
  private final /*const*/SmallVectorULong /*&*/ Record;
  private final uint$ref/*uint &*/ Idx;
  private /*uint32_t*/int TypeIDForTypeDecl;
  private /*uint*/int AnonymousDeclNumber;
  private /*uint32_t*/int NamedDeclForTagDecl;
  private IdentifierInfo /*P*/ TypedefNameForLinkage;
  
  private boolean HasPendingBody;
  
  ///\brief A flag to carry the information for a decl from the entity is
  /// used. We use it to delay the marking of the canonical decl as used until
  /// the entire declaration is deserialized and merged.
  private boolean IsDeclMarkedUsed;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::GetCurrentCursorOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 446,
   FQN="clang::ASTDeclReader::GetCurrentCursorOffset", NM="_ZN5clang13ASTDeclReader22GetCurrentCursorOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22GetCurrentCursorOffsetEv")
  //</editor-fold>
  private long/*uint64_t*/ GetCurrentCursorOffset() {
    return F.DeclsCursor.GetCurrentBitNo() + F.GlobalBitOffset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadLocalOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 60,
   FQN="clang::ASTDeclReader::ReadLocalOffset", NM="_ZN5clang13ASTDeclReader15ReadLocalOffsetERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader15ReadLocalOffsetERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private long/*uint64_t*/ ReadLocalOffset(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    long/*uint64_t*/ LocalOffset = R.$at$Const(I.$set$postInc());
    assert (Unsigned.$less_ulong(LocalOffset, Offset)) : "offset point after current record";
    return (LocalOffset != 0) ? Offset - LocalOffset : Unsigned.$int2ullong(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadGlobalOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 66,
   FQN="clang::ASTDeclReader::ReadGlobalOffset", NM="_ZN5clang13ASTDeclReader16ReadGlobalOffsetERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader16ReadGlobalOffsetERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private long/*uint64_t*/ ReadGlobalOffset(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    long/*uint64_t*/ Local = ReadLocalOffset(R, I);
    return (Local != 0) ? Reader.getGlobalBitOffset(F, Unsigned.$ulong2uint(Local)) : Unsigned.$int2ullong(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 71,
   FQN="clang::ASTDeclReader::ReadSourceLocation", NM="_ZN5clang13ASTDeclReader18ReadSourceLocationERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18ReadSourceLocationERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private SourceLocation ReadSourceLocation(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadSourceLocation(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 75,
   FQN="clang::ASTDeclReader::ReadSourceRange", NM="_ZN5clang13ASTDeclReader15ReadSourceRangeERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader15ReadSourceRangeERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private SourceRange ReadSourceRange(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadSourceRange(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::GetTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 79,
   FQN="clang::ASTDeclReader::GetTypeSourceInfo", NM="_ZN5clang13ASTDeclReader17GetTypeSourceInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17GetTypeSourceInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private TypeSourceInfo /*P*/ GetTypeSourceInfo(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.GetTypeSourceInfo(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadDeclID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 83,
   FQN="clang::ASTDeclReader::ReadDeclID", NM="_ZN5clang13ASTDeclReader10ReadDeclIDERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader10ReadDeclIDERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private /*uint32_t*/int ReadDeclID(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadDeclID(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 87,
   FQN="clang::ASTDeclReader::ReadString", NM="_ZN5clang13ASTDeclReader10ReadStringERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader10ReadStringERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private std.string ReadString(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadString(R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadDeclIDList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 91,
   FQN="clang::ASTDeclReader::ReadDeclIDList", NM="_ZN5clang13ASTDeclReader14ReadDeclIDListERN4llvm15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14ReadDeclIDListERN4llvm15SmallVectorImplIjEE")
  //</editor-fold>
  private void ReadDeclIDList(final SmallVectorImplUInt /*&*/ IDs) {
    for (/*uint*/int I = 0, Size = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())); I != Size; ++I)  {
      IDs.push_back(ReadDeclID(Record, Idx));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 96,
   FQN="clang::ASTDeclReader::ReadDecl", NM="_ZN5clang13ASTDeclReader8ReadDeclERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader8ReadDeclERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private Decl /*P*/ ReadDecl(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadDecl(F, R, I);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadDeclAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 101,
   FQN="clang::ASTDeclReader::ReadDeclAs", NM="Tpl__ZN5clang13ASTDeclReader10ReadDeclAsERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader10ReadDeclAsERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private </*typename*/ T> T /*P*/ ReadDeclAs(Class<T> cls, final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.<T>ReadDeclAs(cls, F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadQualifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 105,
   FQN="clang::ASTDeclReader::ReadQualifierInfo", NM="_ZN5clang13ASTDeclReader17ReadQualifierInfoERNS_13QualifierInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17ReadQualifierInfoERNS_13QualifierInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private void ReadQualifierInfo(final QualifierInfo /*&*/ Info, 
                   final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    Reader.ReadQualifierInfo(F, Info, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadDeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 110,
   FQN="clang::ASTDeclReader::ReadDeclarationNameLoc", NM="_ZN5clang13ASTDeclReader22ReadDeclarationNameLocERNS_18DeclarationNameLocENS_15DeclarationNameERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22ReadDeclarationNameLocERNS_18DeclarationNameLocENS_15DeclarationNameERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private void ReadDeclarationNameLoc(final DeclarationNameLoc /*&*/ DNLoc, DeclarationName Name, 
                        final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    Reader.ReadDeclarationNameLoc(F, DNLoc, new DeclarationName(Name), R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadDeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 115,
   FQN="clang::ASTDeclReader::ReadDeclarationNameInfo", NM="_ZN5clang13ASTDeclReader23ReadDeclarationNameInfoERNS_19DeclarationNameInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader23ReadDeclarationNameInfoERNS_19DeclarationNameInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private void ReadDeclarationNameInfo(final DeclarationNameInfo /*&*/ NameInfo, 
                         final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    Reader.ReadDeclarationNameInfo(F, NameInfo, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::readSubmoduleID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 120,
   FQN="clang::ASTDeclReader::readSubmoduleID", NM="_ZN5clang13ASTDeclReader15readSubmoduleIDERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader15readSubmoduleIDERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private /*uint32_t*/int readSubmoduleID(final /*const*/SmallVectorULong /*&*/ R, 
                 final uint$ref/*uint &*/ I) {
    if (Unsigned.$greatereq_uint(I.$deref(), R.size())) {
      return 0;
    }
    
    return Reader.getGlobalSubmoduleID(F, Unsigned.$ullong2uint(R.$at$Const(I.$set$postInc())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::readModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 128,
   FQN="clang::ASTDeclReader::readModule", NM="_ZN5clang13ASTDeclReader10readModuleERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader10readModuleERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private Module$B /*P*/ readModule(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.getSubmodule(readSubmoduleID(R, I));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadCXXRecordDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1662,
   FQN="clang::ASTDeclReader::ReadCXXRecordDefinition", NM="_ZN5clang13ASTDeclReader23ReadCXXRecordDefinitionEPNS_13CXXRecordDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader23ReadCXXRecordDefinitionEPNS_13CXXRecordDeclEb")
  //</editor-fold>
  private void ReadCXXRecordDefinition(CXXRecordDecl /*P*/ D, boolean Update) {
     CXXRecordDecl.DefinitionData /*P*/ DD;
    final ASTContext /*&*/ C = Reader.getContext();
    
    // Determine whether this is a lambda closure type, so that we can
    // allocate the appropriate DefinitionData structure.
    boolean IsLambda = (Record.$at$Const(Idx.$set$postInc()) != 0);
    if (IsLambda) {
      DD = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
          return new CXXRecordDecl.LambdaDefinitionData(D, (TypeSourceInfo /*P*/ )null, false, false, 
                  LambdaCaptureDefault.LCD_None);
       });
    } else {
      DD = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
          return new  CXXRecordDecl.DefinitionData(D);
       });
    }
    
    ReadCXXDefinitionData(Native.$Deref(DD), Record, Idx);
    
    // We might already have a definition for this record. This can happen either
    // because we're reading an update record, or because we've already done some
    // merging. Either way, just merge into it.
    CXXRecordDecl /*P*/ Canon = D.getCanonicalDecl();
    if ((Canon.DefinitionData != null)) {
      MergeDefinitionData(Canon, std.move(Native.$Deref(DD)));
      D.DefinitionData = Canon.DefinitionData;
      return;
    }
    
    // Mark this declaration as being a definition.
    D.IsCompleteDefinition = true;
    D.DefinitionData = DD;
    
    // If this is not the first declaration or is an update record, we can have
    // other redeclarations already. Make a note that we need to propagate the
    // DefinitionData pointer onto them.
    if (Update || Canon != D) {
      Canon.DefinitionData = D.DefinitionData;
      Reader.PendingDefinitions.insert(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadCXXDefinitionData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1460,
   FQN="clang::ASTDeclReader::ReadCXXDefinitionData", NM="_ZN5clang13ASTDeclReader21ReadCXXDefinitionDataERNS_13CXXRecordDecl14DefinitionDataERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21ReadCXXDefinitionDataERNS_13CXXRecordDecl14DefinitionDataERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private void ReadCXXDefinitionData(final  CXXRecordDecl.DefinitionData /*&*/ Data, 
                       final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    // Note: the caller has deserialized the IsLambda bit already.
    Data.UserDeclaredConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.UserDeclaredSpecialMembers = Unsigned.$uint2uint_6bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.Aggregate = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.PlainOldData = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.Empty = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.Polymorphic = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.Abstract = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.IsStandardLayout = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasNoNonEmptyBases = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasPrivateFields = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasProtectedFields = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasPublicFields = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasMutableFields = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasVariantMembers = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasOnlyCMembers = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasInClassInitializer = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasUninitializedReferenceMember = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasUninitializedFields = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasInheritedConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasInheritedAssignment = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.NeedOverloadResolutionForMoveConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.NeedOverloadResolutionForMoveAssignment = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.NeedOverloadResolutionForDestructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.DefaultedMoveConstructorIsDeleted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.DefaultedMoveAssignmentIsDeleted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.DefaultedDestructorIsDeleted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasTrivialSpecialMembers = Unsigned.$uint2uint_6bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.DeclaredNonTrivialSpecialMembers = Unsigned.$uint2uint_6bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasIrrelevantDestructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasConstexprNonCopyMoveConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasDefaultedDefaultConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.DefaultedDefaultConstructorIsConstexpr = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasConstexprDefaultConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasNonLiteralTypeFieldsOrBases = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.ComputedVisibleConversions = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.UserProvidedDefaultConstructor = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.DeclaredSpecialMembers = Unsigned.$uint2uint_6bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.ImplicitCopyConstructorHasConstParam = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.ImplicitCopyAssignmentHasConstParam = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasDeclaredCopyConstructorWithConstParam = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    Data.HasDeclaredCopyAssignmentWithConstParam = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    Data.NumBases = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if ((Data.NumBases != 0)) {
      Data.Bases.$assign(ReadGlobalOffset(F, Record, Idx));
    }
    Data.NumVBases = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if ((Data.NumVBases != 0)) {
      Data.VBases.$assign(ReadGlobalOffset(F, Record, Idx));
    }
    
    Reader.ReadUnresolvedSet(F, Data.Conversions, Record, Idx);
    Reader.ReadUnresolvedSet(F, Data.VisibleConversions, Record, Idx);
    assert ((Data.Definition != null)) : "Data.Definition should be already set!";
    Data.FirstFriend.$assign(Unsigned.$uint2ulong(ReadDeclID(Record, Idx)));
    if (Data.IsLambda) {
      // JAVA: typedef LambdaCapture Capture
//      final class Capture extends LambdaCapture{ };
      final CXXRecordDecl.LambdaDefinitionData /*&*/ Lambda = ((/*static_cast*/CXXRecordDecl.LambdaDefinitionData /*&*/ )(Data));
      Lambda.Dependent = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      Lambda.IsGenericLambda = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      Lambda.CaptureDefault = Unsigned.$uint2uint_2bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      Lambda.NumCaptures = Unsigned.$uint2uint_15bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      Lambda.NumExplicitCaptures = Unsigned.$uint2uint_13bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      Lambda.ManglingNumber = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      Lambda.ContextDecl = ReadDecl(Record, Idx);
      Lambda.Captures = NativePointer.create_const_type$ptr(NativePointer.new$T(new LambdaCapture[Unsigned.$15bits_uint2uint(Lambda.NumCaptures)], ()->new LambdaCapture()));
         //= (LambdaCapture /*P*/ )Reader.Context.Allocate($sizeof_LambdaCapture() * $15bits_uint2uint(Lambda.NumCaptures));
      type$ptr<LambdaCapture /*P*/> ToCapture = Native.$Clone(Lambda.Captures);
      Lambda.MethodTyInfo = GetTypeSourceInfo(Record, Idx);
      for (/*uint*/int I = 0, N = Unsigned.$15bits_uint2uint(Lambda.NumCaptures); I != N; ++I) {
        SourceLocation Loc = ReadSourceLocation(Record, Idx);
        boolean IsImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
        LambdaCaptureKind Kind = /*static_cast*/LambdaCaptureKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        switch (Kind) {
         case LCK_StarThis:
         case LCK_This:
         case LCK_VLAType:
          Native.$Deref(ToCapture.$postInc()).$assignMove(new LambdaCapture(new SourceLocation(Loc), IsImplicit, Kind, (VarDecl /*P*/ )null, new SourceLocation()));
          break;
         case LCK_ByCopy:
         case LCK_ByRef:
           VarDecl /*P*/ Var = this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx);
          SourceLocation EllipsisLoc = ReadSourceLocation(Record, Idx);
          Native.$Deref(ToCapture.$postInc()).$assignMove(new LambdaCapture(new SourceLocation(Loc), IsImplicit, Kind, Var, new SourceLocation(EllipsisLoc)));
          break;
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::MergeDefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1554,
   FQN="clang::ASTDeclReader::MergeDefinitionData", NM="_ZN5clang13ASTDeclReader19MergeDefinitionDataEPNS_13CXXRecordDeclEONS1_14DefinitionDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19MergeDefinitionDataEPNS_13CXXRecordDeclEONS1_14DefinitionDataE")
  //</editor-fold>
  private void MergeDefinitionData(CXXRecordDecl /*P*/ D, final  CXXRecordDecl.DefinitionData /*&&*/MergeDD) {
    assert ((D.DefinitionData != null)) : "merging class definition into non-definition";
    final CXXRecordDecl.DefinitionData /*&*/ DD = Native.$Deref(D.DefinitionData);
    if (DD.Definition != MergeDD.Definition) {
      // Track that we merged the definitions.
      Reader.MergedDeclContexts.insert_pair$KeyT$ValueT(new std.pairPtrPtr<DeclContext /*P*/ , DeclContext /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/MergeDD.Definition, /*Fwd2*//*Fwd*/DD.Definition));
      Reader.PendingDefinitions.erase(MergeDD.Definition);
      MergeDD.Definition.IsCompleteDefinition = false;
      mergeDefinitionVisibility(DD.Definition, MergeDD.Definition);
      assert (Reader.Lookups.find(MergeDD.Definition).$eq(/*NO_ITER_COPY*/Reader.Lookups.end())) : "already loaded pending lookups for merged definition";
    }
    
    DenseMapIterator<Object/*void P*/ , ASTReader.PendingFakeDefinitionKind> PFDI = Reader.PendingFakeDefinitionData.find(Native.$AddrOf(DD));
    if (PFDI.$noteq(/*NO_ITER_COPY*/Reader.PendingFakeDefinitionData.end())
       && PFDI.$arrow().second == ASTReader.PendingFakeDefinitionKind.Fake) {
      // We faked up this definition data because we found a class for which we'd
      // not yet loaded the definition. Replace it with the real thing now.
      assert (!DD.IsLambda && !MergeDD.IsLambda) : "faked up lambda definition?";
      PFDI.$arrow().second = ASTReader.PendingFakeDefinitionKind.FakeLoaded;
      
      // Don't change which declaration is the definition; that is required
      // to be invariant once we select it.
      CXXRecordDecl /*P*/ Def = DD.Definition;
      DD.$assignMove(std.move(MergeDD));
      DD.Definition = Def;
      return;
    }
    
    // FIXME: Move this out into a .def file?
    boolean DetectedOdrViolation = false;
    DetectedOdrViolation |= DD.UserDeclaredConstructor != MergeDD.UserDeclaredConstructor;
    DD.UserDeclaredConstructor |= MergeDD.UserDeclaredConstructor;
    DetectedOdrViolation |= Unsigned.$6bits_uint2uint(DD.UserDeclaredSpecialMembers) != Unsigned.$6bits_uint2uint(MergeDD.UserDeclaredSpecialMembers);
    DD.UserDeclaredSpecialMembers |= Unsigned.$int2uint_6bits(Unsigned.$6bits_uint2uint(MergeDD.UserDeclaredSpecialMembers));
    DetectedOdrViolation |= DD.Aggregate != MergeDD.Aggregate;
    DD.Aggregate |= MergeDD.Aggregate;
    DetectedOdrViolation |= DD.PlainOldData != MergeDD.PlainOldData;
    DD.PlainOldData |= MergeDD.PlainOldData;
    DetectedOdrViolation |= DD.Empty != MergeDD.Empty;
    DD.Empty |= MergeDD.Empty;
    DetectedOdrViolation |= DD.Polymorphic != MergeDD.Polymorphic;
    DD.Polymorphic |= MergeDD.Polymorphic;
    DetectedOdrViolation |= DD.Abstract != MergeDD.Abstract;
    DD.Abstract |= MergeDD.Abstract;
    DetectedOdrViolation |= DD.IsStandardLayout != MergeDD.IsStandardLayout;
    DD.IsStandardLayout |= MergeDD.IsStandardLayout;
    DetectedOdrViolation |= DD.HasNoNonEmptyBases != MergeDD.HasNoNonEmptyBases;
    DD.HasNoNonEmptyBases |= MergeDD.HasNoNonEmptyBases;
    DetectedOdrViolation |= DD.HasPrivateFields != MergeDD.HasPrivateFields;
    DD.HasPrivateFields |= MergeDD.HasPrivateFields;
    DetectedOdrViolation |= DD.HasProtectedFields != MergeDD.HasProtectedFields;
    DD.HasProtectedFields |= MergeDD.HasProtectedFields;
    DetectedOdrViolation |= DD.HasPublicFields != MergeDD.HasPublicFields;
    DD.HasPublicFields |= MergeDD.HasPublicFields;
    DetectedOdrViolation |= DD.HasMutableFields != MergeDD.HasMutableFields;
    DD.HasMutableFields |= MergeDD.HasMutableFields;
    DetectedOdrViolation |= DD.HasVariantMembers != MergeDD.HasVariantMembers;
    DD.HasVariantMembers |= MergeDD.HasVariantMembers;
    DetectedOdrViolation |= DD.HasOnlyCMembers != MergeDD.HasOnlyCMembers;
    DD.HasOnlyCMembers |= MergeDD.HasOnlyCMembers;
    DetectedOdrViolation |= DD.HasInClassInitializer != MergeDD.HasInClassInitializer;
    DD.HasInClassInitializer |= MergeDD.HasInClassInitializer;
    DetectedOdrViolation |= DD.HasUninitializedReferenceMember != MergeDD.HasUninitializedReferenceMember;
    DD.HasUninitializedReferenceMember |= MergeDD.HasUninitializedReferenceMember;
    DetectedOdrViolation |= DD.HasUninitializedFields != MergeDD.HasUninitializedFields;
    DD.HasUninitializedFields |= MergeDD.HasUninitializedFields;
    DetectedOdrViolation |= DD.HasInheritedConstructor != MergeDD.HasInheritedConstructor;
    DD.HasInheritedConstructor |= MergeDD.HasInheritedConstructor;
    DetectedOdrViolation |= DD.HasInheritedAssignment != MergeDD.HasInheritedAssignment;
    DD.HasInheritedAssignment |= MergeDD.HasInheritedAssignment;
    DetectedOdrViolation |= DD.NeedOverloadResolutionForMoveConstructor != MergeDD.NeedOverloadResolutionForMoveConstructor;
    DD.NeedOverloadResolutionForMoveConstructor |= MergeDD.NeedOverloadResolutionForMoveConstructor;
    DetectedOdrViolation |= DD.NeedOverloadResolutionForMoveAssignment != MergeDD.NeedOverloadResolutionForMoveAssignment;
    DD.NeedOverloadResolutionForMoveAssignment |= MergeDD.NeedOverloadResolutionForMoveAssignment;
    DetectedOdrViolation |= DD.NeedOverloadResolutionForDestructor != MergeDD.NeedOverloadResolutionForDestructor;
    DD.NeedOverloadResolutionForDestructor |= MergeDD.NeedOverloadResolutionForDestructor;
    DetectedOdrViolation |= DD.DefaultedMoveConstructorIsDeleted != MergeDD.DefaultedMoveConstructorIsDeleted;
    DD.DefaultedMoveConstructorIsDeleted |= MergeDD.DefaultedMoveConstructorIsDeleted;
    DetectedOdrViolation |= DD.DefaultedMoveAssignmentIsDeleted != MergeDD.DefaultedMoveAssignmentIsDeleted;
    DD.DefaultedMoveAssignmentIsDeleted |= MergeDD.DefaultedMoveAssignmentIsDeleted;
    DetectedOdrViolation |= DD.DefaultedDestructorIsDeleted != MergeDD.DefaultedDestructorIsDeleted;
    DD.DefaultedDestructorIsDeleted |= MergeDD.DefaultedDestructorIsDeleted;
    DD.HasTrivialSpecialMembers |= Unsigned.$int2uint_6bits(Unsigned.$6bits_uint2uint(MergeDD.HasTrivialSpecialMembers));
    DD.DeclaredNonTrivialSpecialMembers |= Unsigned.$int2uint_6bits(Unsigned.$6bits_uint2uint(MergeDD.DeclaredNonTrivialSpecialMembers));
    DetectedOdrViolation |= DD.HasIrrelevantDestructor != MergeDD.HasIrrelevantDestructor;
    DD.HasIrrelevantDestructor |= MergeDD.HasIrrelevantDestructor;
    DD.HasConstexprNonCopyMoveConstructor |= MergeDD.HasConstexprNonCopyMoveConstructor;
    DD.HasDefaultedDefaultConstructor |= MergeDD.HasDefaultedDefaultConstructor;
    DetectedOdrViolation |= DD.DefaultedDefaultConstructorIsConstexpr != MergeDD.DefaultedDefaultConstructorIsConstexpr;
    DD.DefaultedDefaultConstructorIsConstexpr |= MergeDD.DefaultedDefaultConstructorIsConstexpr;
    DD.HasConstexprDefaultConstructor |= MergeDD.HasConstexprDefaultConstructor;
    DetectedOdrViolation |= DD.HasNonLiteralTypeFieldsOrBases != MergeDD.HasNonLiteralTypeFieldsOrBases;
    DD.HasNonLiteralTypeFieldsOrBases |= MergeDD.HasNonLiteralTypeFieldsOrBases;
    // ComputedVisibleConversions is handled below.
    DetectedOdrViolation |= DD.UserProvidedDefaultConstructor != MergeDD.UserProvidedDefaultConstructor;
    DD.UserProvidedDefaultConstructor |= MergeDD.UserProvidedDefaultConstructor;
    DD.DeclaredSpecialMembers |= Unsigned.$int2uint_6bits(Unsigned.$6bits_uint2uint(MergeDD.DeclaredSpecialMembers));
    DetectedOdrViolation |= DD.ImplicitCopyConstructorHasConstParam != MergeDD.ImplicitCopyConstructorHasConstParam;
    DD.ImplicitCopyConstructorHasConstParam |= MergeDD.ImplicitCopyConstructorHasConstParam;
    DetectedOdrViolation |= DD.ImplicitCopyAssignmentHasConstParam != MergeDD.ImplicitCopyAssignmentHasConstParam;
    DD.ImplicitCopyAssignmentHasConstParam |= MergeDD.ImplicitCopyAssignmentHasConstParam;
    DD.HasDeclaredCopyConstructorWithConstParam |= MergeDD.HasDeclaredCopyConstructorWithConstParam;
    DD.HasDeclaredCopyAssignmentWithConstParam |= MergeDD.HasDeclaredCopyAssignmentWithConstParam;
    DetectedOdrViolation |= DD.IsLambda != MergeDD.IsLambda;
    DD.IsLambda |= MergeDD.IsLambda;
    if (DD.NumBases != MergeDD.NumBases || DD.NumVBases != MergeDD.NumVBases) {
      DetectedOdrViolation = true;
    }
    // FIXME: Issue a diagnostic if the base classes don't match when we come
    // to lazily load them.
    
    // FIXME: Issue a diagnostic if the list of conversion functions doesn't
    // match when we come to lazily load them.
    if (MergeDD.ComputedVisibleConversions && !DD.ComputedVisibleConversions) {
      DD.VisibleConversions.$assignMove(std.move(MergeDD.VisibleConversions));
      DD.ComputedVisibleConversions = true;
    }
    
    // FIXME: Issue a diagnostic if FirstFriend doesn't match when we come to
    // lazily load it.
    if (DD.IsLambda) {
      // FIXME: ODR-checking for merging lambdas (this happens, for instance,
      // when they occur within the body of a function template specialization).
    }
    if (DetectedOdrViolation) {
      Reader.PendingOdrMergeFailures.$at_T1$C$R(DD.Definition).push_back(MergeDD.Definition);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::getAnonymousDeclForMerging">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2875,
   FQN="clang::ASTDeclReader::getAnonymousDeclForMerging", NM="_ZN5clang13ASTDeclReader26getAnonymousDeclForMergingERNS_9ASTReaderEPNS_11DeclContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader26getAnonymousDeclForMergingERNS_9ASTReaderEPNS_11DeclContextEj")
  //</editor-fold>
  private static NamedDecl /*P*/ getAnonymousDeclForMerging(final ASTReader /*&*/ Reader, 
                            DeclContext /*P*/ DC, 
                            /*uint*/int Index) {
    {
      // If the lexical context has been merged, look into the now-canonical
      // definition.
      DeclContext /*P*/ Merged = Reader.MergedDeclContexts.lookup(DC);
      if ((Merged != null)) {
        DC = Merged;
      }
    }
    
    // If we've seen this before, return the canonical declaration.
    final SmallVector<NamedDecl /*P*/ > /*&*/ Previous = Reader.AnonymousDeclarationsForMerging.$at_T1$C$R(DC);
    if (Unsigned.$less_uint(Index, Previous.size()) && (Previous.$at(Index) != null)) {
      return Previous.$at(Index);
    }
    
    // If this is the first time, but we have parsed a declaration of the context,
    // build the anonymous declaration list from the parsed declaration.
    if (!AstDeclarationsRTTI.cast_Decl(DC).isFromASTFile()) {
      numberAnonymousDeclsWithin(DC, /*[&, &Previous]*/ (NamedDecl /*P*/ ND, /*uint*/int Number) -> {
                if (Previous.size() == Number) {
                  Previous.push_back(AstDeclarationsRTTI.cast_NamedDecl(ND.getCanonicalDecl()));
                } else {
                  Previous.$set(Number, AstDeclarationsRTTI.cast_NamedDecl(ND.getCanonicalDecl()));
                }
              });
    }
    
    return Unsigned.$less_uint(Index, Previous.size()) ? Previous.$at(Index) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::setAnonymousDeclForMerging">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2902,
   FQN="clang::ASTDeclReader::setAnonymousDeclForMerging", NM="_ZN5clang13ASTDeclReader26setAnonymousDeclForMergingERNS_9ASTReaderEPNS_11DeclContextEjPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader26setAnonymousDeclForMergingERNS_9ASTReaderEPNS_11DeclContextEjPNS_9NamedDeclE")
  //</editor-fold>
  private static void setAnonymousDeclForMerging(final ASTReader /*&*/ Reader, 
                            DeclContext /*P*/ DC, /*uint*/int Index, 
                            NamedDecl /*P*/ D) {
    {
      DeclContext /*P*/ Merged = Reader.MergedDeclContexts.lookup(DC);
      if ((Merged != null)) {
        DC = Merged;
      }
    }
    
    final SmallVector<NamedDecl /*P*/ > /*&*/ Previous = Reader.AnonymousDeclarationsForMerging.$at_T1$C$R(DC);
    if (Unsigned.$greatereq_uint(Index, Previous.size())) {
      Previous.resize(Index + 1);
    }
    if (!(Previous.$at(Index) != null)) {
      Previous.$set(Index, D);
    }
  }

  
  /// Results from loading a RedeclarableDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::RedeclarableResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 145,
   FQN="clang::ASTDeclReader::RedeclarableResult", NM="_ZN5clang13ASTDeclReader18RedeclarableResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18RedeclarableResultE")
  //</editor-fold>
  /*friend*/public/*private*/ static class RedeclarableResult {
    private /*uint32_t*/int FirstID;
    private Decl /*P*/ MergeWith;
    private boolean IsKeyDecl;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::RedeclarableResult::RedeclarableResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 151,
     FQN="clang::ASTDeclReader::RedeclarableResult::RedeclarableResult", NM="_ZN5clang13ASTDeclReader18RedeclarableResultC1EjPNS_4DeclEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18RedeclarableResultC1EjPNS_4DeclEb")
    //</editor-fold>
    public RedeclarableResult(/*uint32_t*/int FirstID, Decl /*P*/ MergeWith, boolean IsKeyDecl) {
      // : FirstID(FirstID), MergeWith(MergeWith), IsKeyDecl(IsKeyDecl) 
      //START JInit
      this.FirstID = FirstID;
      this.MergeWith = MergeWith;
      this.IsKeyDecl = IsKeyDecl;
      //END JInit
    }

    
    /// \brief Retrieve the first ID.
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::RedeclarableResult::getFirstID">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 155,
     FQN="clang::ASTDeclReader::RedeclarableResult::getFirstID", NM="_ZNK5clang13ASTDeclReader18RedeclarableResult10getFirstIDEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13ASTDeclReader18RedeclarableResult10getFirstIDEv")
    //</editor-fold>
    public /*uint32_t*/int getFirstID() /*const*/ {
      return FirstID;
    }

    
    /// \brief Is this declaration a key declaration?
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::RedeclarableResult::isKeyDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 158,
     FQN="clang::ASTDeclReader::RedeclarableResult::isKeyDecl", NM="_ZNK5clang13ASTDeclReader18RedeclarableResult9isKeyDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13ASTDeclReader18RedeclarableResult9isKeyDeclEv")
    //</editor-fold>
    public boolean isKeyDecl() /*const*/ {
      return IsKeyDecl;
    }

    
    /// \brief Get a known declaration that this should be merged with, if
    /// any.
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::RedeclarableResult::getKnownMergeTarget">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 162,
     FQN="clang::ASTDeclReader::RedeclarableResult::getKnownMergeTarget", NM="_ZNK5clang13ASTDeclReader18RedeclarableResult19getKnownMergeTargetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13ASTDeclReader18RedeclarableResult19getKnownMergeTargetEv")
    //</editor-fold>
    public Decl /*P*/ getKnownMergeTarget() /*const*/ {
      return MergeWith;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::RedeclarableResult::RedeclarableResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 145,
     FQN="clang::ASTDeclReader::RedeclarableResult::RedeclarableResult", NM="_ZN5clang13ASTDeclReader18RedeclarableResultC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18RedeclarableResultC1EOS1_")
    //</editor-fold>
    public /*inline*/ RedeclarableResult(JD$Move _dparam, final RedeclarableResult /*&&*/$Prm0) {
      // : FirstID(static_cast<RedeclarableResult &&>().FirstID), MergeWith(static_cast<RedeclarableResult &&>().MergeWith), IsKeyDecl(static_cast<RedeclarableResult &&>().IsKeyDecl) 
      //START JInit
      this.FirstID = $Prm0.FirstID;
      this.MergeWith = $Prm0.MergeWith;
      this.IsKeyDecl = $Prm0.IsKeyDecl;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "FirstID=" + FirstID // NOI18N
                + ", MergeWith=" + "[Decl]" // NOI18N
                + ", IsKeyDecl=" + IsKeyDecl; // NOI18N
    }
  };
  
  /// \brief Class used to capture the result of searching for an existing
  /// declaration of a specific kind and name, along with the ability
  /// to update the place where this result was found (the declaration
  /// chain hanging off an identifier or the DeclContext we searched in)
  /// if requested.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 170,
   FQN="clang::ASTDeclReader::FindExistingResult", NM="_ZN5clang13ASTDeclReader18FindExistingResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResultE")
  //</editor-fold>
  private static class FindExistingResult implements Destructors.ClassWithDestructor {
    private final ASTReader /*&*/ Reader;
    private NamedDecl /*P*/ New;
    private NamedDecl /*P*/ Existing;
    private /*mutable */boolean AddResult;
    
    private /*uint*/int AnonymousDeclNumber;
    private IdentifierInfo /*P*/ TypedefNameForLinkage;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 179,
     FQN="clang::ASTDeclReader::FindExistingResult::operator=", NM="_ZN5clang13ASTDeclReader18FindExistingResultaSERS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResultaSERS1_")
    //</editor-fold>
    protected/*private*/ void $assign(final FindExistingResult /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::FindExistingResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 182,
     FQN="clang::ASTDeclReader::FindExistingResult::FindExistingResult", NM="_ZN5clang13ASTDeclReader18FindExistingResultC1ERNS_9ASTReaderE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResultC1ERNS_9ASTReaderE")
    //</editor-fold>
    public FindExistingResult(final ASTReader /*&*/ Reader) {
      // : Reader(Reader), New(null), Existing(null), AddResult(false), AnonymousDeclNumber(0), TypedefNameForLinkage(null) 
      //START JInit
      this./*&*/Reader=/*&*/Reader;
      this.New = null;
      this.Existing = null;
      this.AddResult = false;
      this.AnonymousDeclNumber = 0;
      this.TypedefNameForLinkage = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::FindExistingResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 186,
     FQN="clang::ASTDeclReader::FindExistingResult::FindExistingResult", NM="_ZN5clang13ASTDeclReader18FindExistingResultC1ERNS_9ASTReaderEPNS_9NamedDeclES5_jPNS_14IdentifierInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResultC1ERNS_9ASTReaderEPNS_9NamedDeclES5_jPNS_14IdentifierInfoE")
    //</editor-fold>
    public FindExistingResult(final ASTReader /*&*/ Reader, NamedDecl /*P*/ New, NamedDecl /*P*/ Existing, 
        /*uint*/int AnonymousDeclNumber, 
        IdentifierInfo /*P*/ TypedefNameForLinkage) {
      // : Reader(Reader), New(New), Existing(Existing), AddResult(true), AnonymousDeclNumber(AnonymousDeclNumber), TypedefNameForLinkage(TypedefNameForLinkage) 
      //START JInit
      this./*&*/Reader=/*&*/Reader;
      this.New = New;
      this.Existing = Existing;
      this.AddResult = true;
      this.AnonymousDeclNumber = AnonymousDeclNumber;
      this.TypedefNameForLinkage = TypedefNameForLinkage;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::FindExistingResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 193,
     FQN="clang::ASTDeclReader::FindExistingResult::FindExistingResult", NM="_ZN5clang13ASTDeclReader18FindExistingResultC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResultC1ERKS1_")
    //</editor-fold>
    public FindExistingResult(final /*const*/ FindExistingResult /*&*/ Other) {
      // : Reader(Other.Reader), New(Other.New), Existing(Other.Existing), AddResult(Other.AddResult), AnonymousDeclNumber(Other.AnonymousDeclNumber), TypedefNameForLinkage(Other.TypedefNameForLinkage) 
      //START JInit
      this./*&*/Reader=/*&*/Other.Reader;
      this.New = Other.New;
      this.Existing = Other.Existing;
      this.AddResult = Other.AddResult;
      this.AnonymousDeclNumber = Other.AnonymousDeclNumber;
      this.TypedefNameForLinkage = Other.TypedefNameForLinkage;
      //END JInit
      Other.AddResult = false;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::~FindExistingResult">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2825,
     FQN="clang::ASTDeclReader::FindExistingResult::~FindExistingResult", NM="_ZN5clang13ASTDeclReader18FindExistingResultD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResultD0Ev")
    //</editor-fold>
    public void $destroy() {
      // Record that we had a typedef name for linkage whether or not we merge
      // with that declaration.
      if ((TypedefNameForLinkage != null)) {
        DeclContext /*P*/ DC = New.getDeclContext().getRedeclContext();
        Reader.ImportedTypedefNamesForLinkage.insert_pair$KeyT$ValueT(std.make_pair_T_Ptr(Native.$Move(std.make_pair_Ptr_Ptr(DC, TypedefNameForLinkage)), New));
        return;
      }
      if (!AddResult || (Existing != null)) {
        return;
      }
      
      DeclarationName Name = New.getDeclName();
      DeclContext /*P*/ DC = New.getDeclContext().getRedeclContext();
      if (needsAnonymousDeclarationNumber(New)) {
        ASTDeclReader.setAnonymousDeclForMerging(Reader, New.getLexicalDeclContext(), 
            AnonymousDeclNumber, New);
      } else if (DC.isTranslationUnit()
         && !Reader.getContext().getLangOpts().CPlusPlus) {
        if (Reader.getIdResolver().tryAddTopLevelDecl(New, new DeclarationName(Name))) {
          Reader.PendingFakeLookupResults.$at(Name.getAsIdentifierInfo()).
              push_back(New);
        }
      } else {
        DeclContext /*P*/ MergeDC = getPrimaryContextForMerging(Reader, DC);
        if ((MergeDC != null)) {
          // Add the declaration to its redeclaration context so later merging
          // lookups will find it.
          MergeDC.makeDeclVisibleInContextImpl(New, /*Internal*/ true);
        }
      }
    }

    
    /// \brief Suppress the addition of this result into the known set of
    /// names.
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::suppress">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 205,
     FQN="clang::ASTDeclReader::FindExistingResult::suppress", NM="_ZN5clang13ASTDeclReader18FindExistingResult8suppressEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18FindExistingResult8suppressEv")
    //</editor-fold>
    public void suppress() {
      AddResult = false;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::operator NamedDecl * ">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 207,
     FQN="clang::ASTDeclReader::FindExistingResult::operator NamedDecl * ", NM="_ZNK5clang13ASTDeclReader18FindExistingResultcvPNS_9NamedDeclEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13ASTDeclReader18FindExistingResultcvPNS_9NamedDeclEEv")
    //</editor-fold>
    public NamedDecl /*P*/ $NamedDecl$P() /*const*/ {
      return Existing;
    }

    
    /*template <typename T> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::FindExistingResult::operator type-parameter-0-0 * ">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 210,
     FQN="clang::ASTDeclReader::FindExistingResult::operator type-parameter-0-0 * ", NM="Tpl__ZNK5clang13ASTDeclReader18FindExistingResultcvPT_Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZNK5clang13ASTDeclReader18FindExistingResultcvPT_Ev")
    //</editor-fold>
    public </*typename*/ T> T /*P*/ $T$P(Class<T> cls) /*const*/ {
      return llvm.dyn_cast_or_null(cls, Existing);
    }

    
    @Override public String toString() {
      return "" + "Reader=" + Reader // NOI18N
                + ", New=" + "[NamedDecl]" // NOI18N
                + ", Existing=" + "[NamedDecl]" // NOI18N
                + ", AddResult=" + AddResult // NOI18N
                + ", AnonymousDeclNumber=" + AnonymousDeclNumber // NOI18N
                + ", TypedefNameForLinkage=" + TypedefNameForLinkage; // NOI18N
    }
  };
  
  
  /// Find the context in which we should search for previous declarations when
  /// looking for declarations to merge.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::getPrimaryContextForMerging">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2784,
   FQN="clang::ASTDeclReader::getPrimaryContextForMerging", NM="_ZN5clang13ASTDeclReader27getPrimaryContextForMergingERNS_9ASTReaderEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader27getPrimaryContextForMergingERNS_9ASTReaderEPNS_11DeclContextE")
  //</editor-fold>
  private static DeclContext /*P*/ getPrimaryContextForMerging(final ASTReader /*&*/ Reader, 
                             DeclContext /*P*/ DC) {
    {
      NamespaceDecl /*P*/ ND = AstDeclarationsRTTI.dyn_cast_NamespaceDecl(DC);
      if ((ND != null)) {
        return ND.getOriginalNamespace();
      }
    }
    {
      
      CXXRecordDecl /*P*/ RD = AstDeclarationsRTTI.dyn_cast_CXXRecordDecl(DC);
      if ((RD != null)) {
        // Try to dig out the definition.
        CXXRecordDecl.DefinitionData /*P*/ DD = RD.DefinitionData;
        if (!(DD != null)) {
          DD = RD.getCanonicalDecl().DefinitionData;
        }
        
        // If there's no definition yet, then DC's definition is added by an update
        // record, but we've not yet loaded that update record. In this case, we
        // commit to DC being the canonical definition now, and will fix this when
        // we load the update record.
        if (!(DD != null)) {
          DD = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Reader.Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(Reader.Context, (type$ptr<?> New$Mem)->{
              return new  CXXRecordDecl.DefinitionData(RD);
           });
          RD.IsCompleteDefinition = true;
          RD.DefinitionData = DD;
          RD.getCanonicalDecl().DefinitionData = DD;
          
          // Track that we did this horrible thing so that we can fix it later.
          Reader.PendingFakeDefinitionData.insert_pair$KeyT$ValueT(new std.pairPtrType<Object/*void P*/ , ASTReader.PendingFakeDefinitionKind>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/DD, /*Fwd2*//*Fwd*/ASTReader.PendingFakeDefinitionKind.Fake));
        }
        
        return DD.Definition;
      }
    }
    {
      
      EnumDecl /*P*/ ED = AstDeclarationsRTTI.dyn_cast_EnumDecl(DC);
      if ((ED != null)) {
        return ED.getASTContext().getLangOpts().CPlusPlus ? ED.getDefinition() : null;
      }
    }
    {
      
      // We can see the TU here only if we have no Sema object. In that case,
      // there's no TU scope to look in, so using the DC alone is sufficient.
      TranslationUnitDecl /*P*/ TU = AstDeclarationsRTTI.dyn_cast_TranslationUnitDecl(DC);
      if ((TU != null)) {
        return TU;
      }
    }
    
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::findExisting">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2915,
   FQN="clang::ASTDeclReader::findExisting", NM="_ZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclE")
  //</editor-fold>
  private ASTDeclReader.FindExistingResult findExisting(NamedDecl /*P*/ D) {
    DeclarationName Name = (TypedefNameForLinkage != null) ? new DeclarationName(TypedefNameForLinkage) : D.getDeclName();
    if (!Name.$bool() && !needsAnonymousDeclarationNumber(D)) {
      FindExistingResult Result = null;
      try {
        // Don't bother trying to find unnamed declarations that are in
        // unmergeable contexts.
        Result/*J*/= new FindExistingResult(Reader, D, /*Existing=*/ (NamedDecl /*P*/ )null, 
            AnonymousDeclNumber, TypedefNameForLinkage);
        Result.suppress();
        return new ASTDeclReader.FindExistingResult(Result);
      } finally {
        if (Result != null) { Result.$destroy(); }
      }
    }
    
    DeclContext /*P*/ DC = D.getDeclContext().getRedeclContext();
    if ((TypedefNameForLinkage != null)) {
      DenseMapIterator<std.pairPtrPtr<DeclContext /*P*/ , IdentifierInfo /*P*/ >, NamedDecl /*P*/ > It = Reader.ImportedTypedefNamesForLinkage.find(std.make_pair_Ptr_Ptr(DC, TypedefNameForLinkage));
      if (It.$noteq(/*NO_ITER_COPY*/Reader.ImportedTypedefNamesForLinkage.end())) {
        if (isSameEntity(It.$arrow().second, D)) {
          return new FindExistingResult(Reader, D, It.$arrow().second, AnonymousDeclNumber, 
              TypedefNameForLinkage);
        }
      }
      // Go on to check in other places in case an existing typedef name
      // was not imported.
    }
    if (needsAnonymousDeclarationNumber(D)) {
      {
        // This is an anonymous declaration that we may need to merge. Look it up
        // in its context by number.
        NamedDecl /*P*/ Existing = getAnonymousDeclForMerging(Reader, D.getLexicalDeclContext(), AnonymousDeclNumber);
        if ((Existing != null)) {
          if (isSameEntity(Existing, D)) {
            return new FindExistingResult(Reader, D, Existing, AnonymousDeclNumber, 
                TypedefNameForLinkage);
          }
        }
      }
    } else if (DC.isTranslationUnit()
       && !Reader.getContext().getLangOpts().CPlusPlus) {
       findExisting$$.UpToDateIdentifierRAII UpToDate = null;
      try {
        final IdentifierResolver /*&*/ IdResolver = Reader.getIdResolver();
        
        // Temporarily consider the identifier to be up-to-date. We don't want to
        // cause additional lookups here.
        UpToDate/*J*/= new  findExisting$$.UpToDateIdentifierRAII(Name.getAsIdentifierInfo());
        
        for (IdentifierResolver.iterator I = IdResolver.begin(/*NO_COPY*/Name), 
            IEnd = IdResolver.end();
             I.$noteq(IEnd); I.$preInc()) {
          {
            NamedDecl /*P*/ Existing = getDeclForMerging(I.$star(), (TypedefNameForLinkage != null));
            if ((Existing != null)) {
              if (isSameEntity(Existing, D)) {
                return new FindExistingResult(Reader, D, Existing, AnonymousDeclNumber, 
                    TypedefNameForLinkage);
              }
            }
          }
        }
      } finally {
        if (UpToDate != null) { UpToDate.$destroy(); }
      }
    } else {
      DeclContext /*P*/ MergeDC = getPrimaryContextForMerging(Reader, DC);
      if ((MergeDC != null)) {
        DeclContextLookupResult R = MergeDC.noload_lookup(new DeclarationName(Name));
        for (DeclContextLookupResult.iterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
          {
            NamedDecl /*P*/ Existing = getDeclForMerging(I.$star(), (TypedefNameForLinkage != null));
            if ((Existing != null)) {
              if (isSameEntity(Existing, D)) {
                return new FindExistingResult(Reader, D, Existing, AnonymousDeclNumber, 
                    TypedefNameForLinkage);
              }
            }
          }
        }
      } else {
        // Not in a mergeable context.
        return new FindExistingResult(Reader);
      }
    }
    
    // If this declaration is from a merged context, make a note that we need to
    // check that the canonical definition of that context contains the decl.
    //
    // FIXME: We should do something similar if we merge two definitions of the
    // same template specialization into the same CXXRecordDecl.
    DenseMapIterator<DeclContext /*P*/ , DeclContext /*P*/ > MergedDCIt = Reader.MergedDeclContexts.find(D.getLexicalDeclContext());
    if (MergedDCIt.$noteq(/*NO_ITER_COPY*/Reader.MergedDeclContexts.end())
       && MergedDCIt.$arrow().second == D.getDeclContext()) {
      Reader.PendingOdrMergeChecks.push_back(D);
    }
    
    return new FindExistingResult(Reader, D, /*Existing=*/ (NamedDecl /*P*/ )null, 
        AnonymousDeclNumber, TypedefNameForLinkage);
  }
  private static final class findExisting$$ {
    static //<editor-fold defaultstate="collapsed" desc="UpToDateIdentifierRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2954,
     FQN="UpToDateIdentifierRAII", NM="_ZZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclEE22UpToDateIdentifierRAII",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclEE22UpToDateIdentifierRAII")
    //</editor-fold>
     class UpToDateIdentifierRAII implements Destructors.ClassWithDestructor {
      private IdentifierInfo /*P*/ II;
      private boolean WasOutToDate;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::findExisting(NamedDecl * )::UpToDateIdentifierRAII::UpToDateIdentifierRAII">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2959,
       FQN="clang::ASTDeclReader::findExisting(NamedDecl * )::UpToDateIdentifierRAII::UpToDateIdentifierRAII", NM="_ZZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclEEN22UpToDateIdentifierRAIIC1EPNS_14IdentifierInfoE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclEEN22UpToDateIdentifierRAIIC1EPNS_14IdentifierInfoE")
      //</editor-fold>
      public /*explicit*/ UpToDateIdentifierRAII(IdentifierInfo /*P*/ II) {
        // : II(II), WasOutToDate(false) 
        //START JInit
        this.II = II;
        this.WasOutToDate = false;
        //END JInit
        if ((II != null)) {
          WasOutToDate = II.isOutOfDate();
          if (WasOutToDate) {
            II.setOutOfDate(false);
          }
        }
      }
    
      
      //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::findExisting(NamedDecl * )::UpToDateIdentifierRAII::~UpToDateIdentifierRAII">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2969,
       FQN="clang::ASTDeclReader::findExisting(NamedDecl * )::UpToDateIdentifierRAII::~UpToDateIdentifierRAII", NM="_ZZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclEEN22UpToDateIdentifierRAIID0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZZN5clang13ASTDeclReader12findExistingEPNS_9NamedDeclEEN22UpToDateIdentifierRAIID0Ev")
      //</editor-fold>
      public void $destroy() {
        if (WasOutToDate) {
          II.setOutOfDate(true);
        }
      }
    
      
      @Override public String toString() {
        return "" + "II=" + II // NOI18N
                  + ", WasOutToDate=" + WasOutToDate; // NOI18N
      }
    };
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ASTDeclReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 218,
   FQN="clang::ASTDeclReader::ASTDeclReader", NM="_ZN5clang13ASTDeclReaderC1ERNS_9ASTReaderENS1_14RecordLocationEjNS_14SourceLocationERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReaderC1ERNS_9ASTReaderENS1_14RecordLocationEjNS_14SourceLocationERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public ASTDeclReader(final ASTReader /*&*/ Reader, ASTReader.RecordLocation Loc, 
      /*uint32_t*/int thisDeclID, SourceLocation ThisDeclLoc, 
      final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    // : DeclVisitor<ASTDeclReader, void>(), Reader(Reader), F(*Loc.F), Offset(Loc.Offset), ThisDeclID(thisDeclID), ThisDeclLoc(ThisDeclLoc), Record(Record), Idx(Idx), TypeIDForTypeDecl(0), NamedDeclForTagDecl(0), TypedefNameForLinkage(null), HasPendingBody(false), IsDeclMarkedUsed(false) 
    //START JInit
    $DeclVisitor();
    this./*&*/Reader=/*&*/Reader;
    this./*&*/F=/*&*/Native.$Deref(Loc.F);
    this.Offset = Loc.Offset;
    this.ThisDeclID = thisDeclID;
    this.ThisDeclLoc = new SourceLocation(ThisDeclLoc);
    this./*&*/Record=/*&*/Record;
    this./*&*/Idx=/*&*/Idx;
    this.TypeIDForTypeDecl = 0;
    this.NamedDeclForTagDecl = 0;
    this.TypedefNameForLinkage = null;
    this.HasPendingBody = false;
    this.IsDeclMarkedUsed = false;
    //END JInit
  }

  
  /*template <typename DeclT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3011,
   FQN="clang::ASTDeclReader::getMostRecentDeclImpl", NM="Tpl__ZN5clang13ASTDeclReader21getMostRecentDeclImplEPNS_12RedeclarableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader21getMostRecentDeclImplEPNS_12RedeclarableIT_EE")
  //</editor-fold>
  public static </*typename*/ DeclT extends Decl & Redeclarable> Decl /*P*/ getMostRecentDeclImpl$T(Redeclarable<DeclT> /*P*/ D) {
    return D.$Redeclarable$Fields().RedeclLink.getLatestNotUpdated();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3014,
   FQN="clang::ASTDeclReader::getMostRecentDeclImpl", NM="_ZN5clang13ASTDeclReader21getMostRecentDeclImplEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21getMostRecentDeclImplEz")
  //</editor-fold>
  public static Decl /*P*/ getMostRecentDeclImpl(Object ... $VarArg) {
    throw new llvm_unreachable("getMostRecentDecl on non-redeclarable declaration");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::getMostRecentDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3018,
   FQN="clang::ASTDeclReader::getMostRecentDecl", NM="_ZN5clang13ASTDeclReader17getMostRecentDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17getMostRecentDeclEPNS_4DeclE")
  //</editor-fold>
  public static Decl /*P*/ getMostRecentDecl(Decl /*P*/ D) {
    assert Native.$bool(D);
    switch (D.getKind()) {
     case AccessSpec:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_AccessSpecDecl(D));
     case Block:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_BlockDecl(D));
     case Captured:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_CapturedDecl(D));
     case ClassScopeFunctionSpecialization:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ClassScopeFunctionSpecializationDecl(D));
     case Empty:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_EmptyDecl(D));
     case ExternCContext:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ExternCContextDecl(D));
     case FileScopeAsm:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_FileScopeAsmDecl(D));
     case Friend:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_FriendDecl(D));
     case FriendTemplate:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_FriendTemplateDecl(D));
     case Import:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ImportDecl(D));
     case LinkageSpec:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_LinkageSpecDecl(D));
     case Label:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_LabelDecl(D));
     case Namespace:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_NamespaceDecl(D));
     case NamespaceAlias:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_NamespaceAliasDecl(D));
     case ObjCCompatibleAlias:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCCompatibleAliasDecl(D));
     case ObjCCategory:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCCategoryDecl(D));
     case ObjCCategoryImpl:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCCategoryImplDecl(D));
     case ObjCImplementation:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCImplementationDecl(D));
     case ObjCInterface:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ObjCInterfaceDecl(D));
     case ObjCProtocol:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ObjCProtocolDecl(D));
     case ObjCMethod:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCMethodDecl(D));
     case ObjCProperty:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCPropertyDecl(D));
     case BuiltinTemplate:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_BuiltinTemplateDecl(D));
     case ClassTemplate:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ClassTemplateDecl(D));
     case FunctionTemplate:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_FunctionTemplateDecl(D));
     case TypeAliasTemplate:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_TypeAliasTemplateDecl(D));
     case VarTemplate:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_VarTemplateDecl(D));
     case TemplateTemplateParm:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_TemplateTemplateParmDecl(D));
     case Enum:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_EnumDecl(D));
     case Record:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_RecordDecl(D));
     case CXXRecord:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_CXXRecordDecl(D));
     case ClassTemplateSpecialization:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ClassTemplateSpecializationDecl(D));
     case ClassTemplatePartialSpecialization:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ClassTemplatePartialSpecializationDecl(D));
     case TemplateTypeParm:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_TemplateTypeParmDecl(D));
     case ObjCTypeParam:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ObjCTypeParamDecl(D));
     case TypeAlias:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_TypeAliasDecl(D));
     case Typedef:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_TypedefDecl(D));
     case UnresolvedUsingTypename:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_UnresolvedUsingTypenameDecl(D));
     case Using:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_UsingDecl(D));
     case UsingDirective:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_UsingDirectiveDecl(D));
     case UsingShadow:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_UsingShadowDecl(D));
     case ConstructorUsingShadow:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ConstructorUsingShadowDecl(D));
     case Field:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_FieldDecl(D));
     case ObjCAtDefsField:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCAtDefsFieldDecl(D));
     case ObjCIvar:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCIvarDecl(D));
     case Function:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_FunctionDecl(D));
     case CXXMethod:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_CXXMethodDecl(D));
     case CXXConstructor:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_CXXConstructorDecl(D));
     case CXXConversion:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_CXXConversionDecl(D));
     case CXXDestructor:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_CXXDestructorDecl(D));
     case MSProperty:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_MSPropertyDecl(D));
     case NonTypeTemplateParm:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_NonTypeTemplateParmDecl(D));
     case Var:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_VarDecl(D));
     case ImplicitParam:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ImplicitParamDecl(D));
     case OMPCapturedExpr:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_OMPCapturedExprDecl(D));
     case ParmVar:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_ParmVarDecl(D));
     case VarTemplateSpecialization:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_VarTemplateSpecializationDecl(D));
     case VarTemplatePartialSpecialization:
      return ASTDeclReader.getMostRecentDeclImpl$T(AstDeclarationsRTTI.cast_VarTemplatePartialSpecializationDecl(D));
     case EnumConstant:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_EnumConstantDecl(D));
     case IndirectField:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_IndirectFieldDecl(D));
     case OMPDeclareReduction:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_OMPDeclareReductionDecl(D));
     case UnresolvedUsingValue:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_UnresolvedUsingValueDecl(D));
     case OMPThreadPrivate:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_OMPThreadPrivateDecl(D));
     case ObjCPropertyImpl:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_ObjCPropertyImplDecl(D));
     case PragmaComment:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_PragmaCommentDecl(D));
     case PragmaDetectMismatch:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_PragmaDetectMismatchDecl(D));
     case StaticAssert:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_StaticAssertDecl(D));
     case TranslationUnit:
      return getMostRecentDeclImpl(AstDeclarationsRTTI.cast_TranslationUnitDecl(D));
    }
    throw new llvm_unreachable("unknown decl kind");
  }

  
  /*template <typename DeclT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachPreviousDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3036,
   FQN="clang::ASTDeclReader::attachPreviousDeclImpl", NM="Tpl__ZN5clang13ASTDeclReader22attachPreviousDeclImplERNS_9ASTReaderEPNS_12RedeclarableIT_EEPNS_4DeclES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader22attachPreviousDeclImplERNS_9ASTReaderEPNS_12RedeclarableIT_EEPNS_4DeclES8_")
  //</editor-fold>
  public static </*typename*/ DeclT extends Decl & Redeclarable> void attachPreviousDeclImpl$T(final ASTReader /*&*/ Reader, 
                          Redeclarable<DeclT> /*P*/ D, 
                          Decl /*P*/ Previous, Decl /*P*/ Canon) {
    D.$Redeclarable$Fields().RedeclLink.setPrevious((DeclT)Previous);
    D.$Redeclarable$Fields().First = (DeclT)((DeclT)Previous).$Redeclarable$Fields().First;
  }

  // end namespace clang
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3090,
   FQN="clang::ASTDeclReader::attachPreviousDeclImpl", NM="_ZN5clang13ASTDeclReader22attachPreviousDeclImplERNS_9ASTReaderEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22attachPreviousDeclImplERNS_9ASTReaderEz")
  //</editor-fold>
  public static void attachPreviousDeclImpl(final ASTReader /*&*/ Reader, Object ... $VarArg) {
    throw new llvm_unreachable("attachPreviousDecl on non-redeclarable declaration");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachPreviousDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3133,
   FQN="clang::ASTDeclReader::attachPreviousDecl", NM="_ZN5clang13ASTDeclReader18attachPreviousDeclERNS_9ASTReaderEPNS_4DeclES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18attachPreviousDeclERNS_9ASTReaderEPNS_4DeclES4_S4_")
  //</editor-fold>
  public static void attachPreviousDecl(final ASTReader /*&*/ Reader, Decl /*P*/ D, 
                    Decl /*P*/ Previous, Decl /*P*/ Canon) {
    assert ((D != null) && (Previous != null));
    switch (D.getKind()) {
     case AccessSpec:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_AccessSpecDecl(D), Previous, Canon);
      break;
     case Block:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_BlockDecl(D), Previous, Canon);
      break;
     case Captured:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_CapturedDecl(D), Previous, Canon);
      break;
     case ClassScopeFunctionSpecialization:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ClassScopeFunctionSpecializationDecl(D), Previous, Canon);
      break;
     case Empty:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_EmptyDecl(D), Previous, Canon);
      break;
     case ExternCContext:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ExternCContextDecl(D), Previous, Canon);
      break;
     case FileScopeAsm:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_FileScopeAsmDecl(D), Previous, Canon);
      break;
     case Friend:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_FriendDecl(D), Previous, Canon);
      break;
     case FriendTemplate:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_FriendTemplateDecl(D), Previous, Canon);
      break;
     case Import:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ImportDecl(D), Previous, Canon);
      break;
     case LinkageSpec:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_LinkageSpecDecl(D), Previous, Canon);
      break;
     case Label:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_LabelDecl(D), Previous, Canon);
      break;
     case Namespace:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_NamespaceDecl(D), Previous, Canon);
      break;
     case NamespaceAlias:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_NamespaceAliasDecl(D), Previous, Canon);
      break;
     case ObjCCompatibleAlias:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCCompatibleAliasDecl(D), Previous, Canon);
      break;
     case ObjCCategory:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCCategoryDecl(D), Previous, Canon);
      break;
     case ObjCCategoryImpl:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCCategoryImplDecl(D), Previous, Canon);
      break;
     case ObjCImplementation:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCImplementationDecl(D), Previous, Canon);
      break;
     case ObjCInterface:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ObjCInterfaceDecl(D), Previous, Canon);
      break;
     case ObjCProtocol:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ObjCProtocolDecl(D), Previous, Canon);
      break;
     case ObjCMethod:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCMethodDecl(D), Previous, Canon);
      break;
     case ObjCProperty:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCPropertyDecl(D), Previous, Canon);
      break;
     case BuiltinTemplate:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_BuiltinTemplateDecl(D), Previous, Canon);
      break;
     case ClassTemplate:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ClassTemplateDecl(D), Previous, Canon);
      break;
     case FunctionTemplate:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_FunctionTemplateDecl(D), Previous, Canon);
      break;
     case TypeAliasTemplate:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_TypeAliasTemplateDecl(D), Previous, Canon);
      break;
     case VarTemplate:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_VarTemplateDecl(D), Previous, Canon);
      break;
     case TemplateTemplateParm:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_TemplateTemplateParmDecl(D), Previous, Canon);
      break;
     case Enum:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_EnumDecl(D), Previous, Canon);
      break;
     case Record:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_RecordDecl(D), Previous, Canon);
      break;
     case CXXRecord:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_CXXRecordDecl(D), Previous, Canon);
      break;
     case ClassTemplateSpecialization:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ClassTemplateSpecializationDecl(D), Previous, Canon);
      break;
     case ClassTemplatePartialSpecialization:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ClassTemplatePartialSpecializationDecl(D), Previous, Canon);
      break;
     case TemplateTypeParm:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_TemplateTypeParmDecl(D), Previous, Canon);
      break;
     case ObjCTypeParam:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ObjCTypeParamDecl(D), Previous, Canon);
      break;
     case TypeAlias:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_TypeAliasDecl(D), Previous, Canon);
      break;
     case Typedef:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_TypedefDecl(D), Previous, Canon);
      break;
     case UnresolvedUsingTypename:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_UnresolvedUsingTypenameDecl(D), Previous, Canon);
      break;
     case Using:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_UsingDecl(D), Previous, Canon);
      break;
     case UsingDirective:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_UsingDirectiveDecl(D), Previous, Canon);
      break;
     case UsingShadow:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_UsingShadowDecl(D), Previous, Canon);
      break;
     case ConstructorUsingShadow:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ConstructorUsingShadowDecl(D), Previous, Canon);
      break;
     case Field:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_FieldDecl(D), Previous, Canon);
      break;
     case ObjCAtDefsField:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCAtDefsFieldDecl(D), Previous, Canon);
      break;
     case ObjCIvar:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCIvarDecl(D), Previous, Canon);
      break;
     case Function:
      attachPreviousDeclImpl_ASTReader_Redeclarable$FunctionDecl$P_Decl$P(Reader, AstDeclarationsRTTI.cast_FunctionDecl(D), Previous, Canon);
      break;
     case CXXMethod:
      attachPreviousDeclImpl_ASTReader_Redeclarable$FunctionDecl$P_Decl$P(Reader, AstDeclarationsRTTI.cast_CXXMethodDecl(D), Previous, Canon);
      break;
     case CXXConstructor:
      attachPreviousDeclImpl_ASTReader_Redeclarable$FunctionDecl$P_Decl$P(Reader, AstDeclarationsRTTI.cast_CXXConstructorDecl(D), Previous, Canon);
      break;
     case CXXConversion:
      attachPreviousDeclImpl_ASTReader_Redeclarable$FunctionDecl$P_Decl$P(Reader, AstDeclarationsRTTI.cast_CXXConversionDecl(D), Previous, Canon);
      break;
     case CXXDestructor:
      attachPreviousDeclImpl_ASTReader_Redeclarable$FunctionDecl$P_Decl$P(Reader, AstDeclarationsRTTI.cast_CXXDestructorDecl(D), Previous, Canon);
      break;
     case MSProperty:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_MSPropertyDecl(D), Previous, Canon);
      break;
     case NonTypeTemplateParm:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_NonTypeTemplateParmDecl(D), Previous, Canon);
      break;
     case Var:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_VarDecl(D), Previous, Canon);
      break;
     case ImplicitParam:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ImplicitParamDecl(D), Previous, Canon);
      break;
     case OMPCapturedExpr:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_OMPCapturedExprDecl(D), Previous, Canon);
      break;
     case ParmVar:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_ParmVarDecl(D), Previous, Canon);
      break;
     case VarTemplateSpecialization:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_VarTemplateSpecializationDecl(D), Previous, Canon);
      break;
     case VarTemplatePartialSpecialization:
      ASTDeclReader.attachPreviousDeclImpl$T(Reader, AstDeclarationsRTTI.cast_VarTemplatePartialSpecializationDecl(D), Previous, Canon);
      break;
     case EnumConstant:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_EnumConstantDecl(D), Previous, Canon);
      break;
     case IndirectField:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_IndirectFieldDecl(D), Previous, Canon);
      break;
     case OMPDeclareReduction:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_OMPDeclareReductionDecl(D), Previous, Canon);
      break;
     case UnresolvedUsingValue:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_UnresolvedUsingValueDecl(D), Previous, Canon);
      break;
     case OMPThreadPrivate:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_OMPThreadPrivateDecl(D), Previous, Canon);
      break;
     case ObjCPropertyImpl:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_ObjCPropertyImplDecl(D), Previous, Canon);
      break;
     case PragmaComment:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_PragmaCommentDecl(D), Previous, Canon);
      break;
     case PragmaDetectMismatch:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_PragmaDetectMismatchDecl(D), Previous, Canon);
      break;
     case StaticAssert:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_StaticAssertDecl(D), Previous, Canon);
      break;
     case TranslationUnit:
      attachPreviousDeclImpl(Reader, AstDeclarationsRTTI.cast_TranslationUnitDecl(D), Previous, Canon);
      break;
    }
    
    // If the declaration was visible in one module, a redeclaration of it in
    // another module remains visible even if it wouldn't be visible by itself.
    //
    // FIXME: In this case, the declaration should only be visible if a module
    //        that makes it visible has been imported.
    D.IdentifierNamespace_field |= Unsigned.$int2uint_13bits(Unsigned.$13bits_uint2uint(Previous.IdentifierNamespace_field)
       & (Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Type));
    {
      
      // If the declaration declares a template, it may inherit default arguments
      // from the previous declaration.
      TemplateDecl /*P*/ TD = AstDeclarationsRTTI.dyn_cast_TemplateDecl(D);
      if ((TD != null)) {
        inheritDefaultTemplateArguments(Reader.getContext(), 
            AstDeclarationsRTTI.cast_TemplateDecl(Previous), TD);
      }
    }
  }

  
  /*template <typename DeclT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachLatestDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3163,
   FQN="clang::ASTDeclReader::attachLatestDeclImpl", NM="Tpl__ZN5clang13ASTDeclReader20attachLatestDeclImplEPNS_12RedeclarableIT_EEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader20attachLatestDeclImplEPNS_12RedeclarableIT_EEPNS_4DeclE")
  //</editor-fold>
  public static </*typename*/ DeclT extends Decl & Redeclarable> void attachLatestDeclImpl$T(Redeclarable<DeclT> /*P*/ D, Decl /*P*/ Latest) {
    D.$Redeclarable$Fields().RedeclLink.setLatest((DeclT)Latest);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachLatestDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3166,
   FQN="clang::ASTDeclReader::attachLatestDeclImpl", NM="_ZN5clang13ASTDeclReader20attachLatestDeclImplEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20attachLatestDeclImplEz")
  //</editor-fold>
  public static void attachLatestDeclImpl(Object ... $VarArg) {
    throw new llvm_unreachable("attachLatestDecl on non-redeclarable declaration");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachLatestDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3170,
   FQN="clang::ASTDeclReader::attachLatestDecl", NM="_ZN5clang13ASTDeclReader16attachLatestDeclEPNS_4DeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader16attachLatestDeclEPNS_4DeclES2_")
  //</editor-fold>
  public static void attachLatestDecl(Decl /*P*/ D, Decl /*P*/ Latest) {
    assert ((D != null) && (Latest != null));
    switch (D.getKind()) {
     case AccessSpec:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_AccessSpecDecl(D), Latest);
      break;
     case Block:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_BlockDecl(D), Latest);
      break;
     case Captured:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_CapturedDecl(D), Latest);
      break;
     case ClassScopeFunctionSpecialization:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ClassScopeFunctionSpecializationDecl(D), Latest);
      break;
     case Empty:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_EmptyDecl(D), Latest);
      break;
     case ExternCContext:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ExternCContextDecl(D), Latest);
      break;
     case FileScopeAsm:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_FileScopeAsmDecl(D), Latest);
      break;
     case Friend:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_FriendDecl(D), Latest);
      break;
     case FriendTemplate:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_FriendTemplateDecl(D), Latest);
      break;
     case Import:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ImportDecl(D), Latest);
      break;
     case LinkageSpec:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_LinkageSpecDecl(D), Latest);
      break;
     case Label:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_LabelDecl(D), Latest);
      break;
     case Namespace:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_NamespaceDecl(D), Latest);
      break;
     case NamespaceAlias:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_NamespaceAliasDecl(D), Latest);
      break;
     case ObjCCompatibleAlias:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCCompatibleAliasDecl(D), Latest);
      break;
     case ObjCCategory:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCCategoryDecl(D), Latest);
      break;
     case ObjCCategoryImpl:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCCategoryImplDecl(D), Latest);
      break;
     case ObjCImplementation:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCImplementationDecl(D), Latest);
      break;
     case ObjCInterface:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ObjCInterfaceDecl(D), Latest);
      break;
     case ObjCProtocol:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ObjCProtocolDecl(D), Latest);
      break;
     case ObjCMethod:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCMethodDecl(D), Latest);
      break;
     case ObjCProperty:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCPropertyDecl(D), Latest);
      break;
     case BuiltinTemplate:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_BuiltinTemplateDecl(D), Latest);
      break;
     case ClassTemplate:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ClassTemplateDecl(D), Latest);
      break;
     case FunctionTemplate:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_FunctionTemplateDecl(D), Latest);
      break;
     case TypeAliasTemplate:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_TypeAliasTemplateDecl(D), Latest);
      break;
     case VarTemplate:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_VarTemplateDecl(D), Latest);
      break;
     case TemplateTemplateParm:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_TemplateTemplateParmDecl(D), Latest);
      break;
     case Enum:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_EnumDecl(D), Latest);
      break;
     case Record:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_RecordDecl(D), Latest);
      break;
     case CXXRecord:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_CXXRecordDecl(D), Latest);
      break;
     case ClassTemplateSpecialization:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ClassTemplateSpecializationDecl(D), Latest);
      break;
     case ClassTemplatePartialSpecialization:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ClassTemplatePartialSpecializationDecl(D), Latest);
      break;
     case TemplateTypeParm:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_TemplateTypeParmDecl(D), Latest);
      break;
     case ObjCTypeParam:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ObjCTypeParamDecl(D), Latest);
      break;
     case TypeAlias:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_TypeAliasDecl(D), Latest);
      break;
     case Typedef:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_TypedefDecl(D), Latest);
      break;
     case UnresolvedUsingTypename:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_UnresolvedUsingTypenameDecl(D), Latest);
      break;
     case Using:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_UsingDecl(D), Latest);
      break;
     case UsingDirective:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_UsingDirectiveDecl(D), Latest);
      break;
     case UsingShadow:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_UsingShadowDecl(D), Latest);
      break;
     case ConstructorUsingShadow:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ConstructorUsingShadowDecl(D), Latest);
      break;
     case Field:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_FieldDecl(D), Latest);
      break;
     case ObjCAtDefsField:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCAtDefsFieldDecl(D), Latest);
      break;
     case ObjCIvar:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCIvarDecl(D), Latest);
      break;
     case Function:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_FunctionDecl(D), Latest);
      break;
     case CXXMethod:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_CXXMethodDecl(D), Latest);
      break;
     case CXXConstructor:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_CXXConstructorDecl(D), Latest);
      break;
     case CXXConversion:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_CXXConversionDecl(D), Latest);
      break;
     case CXXDestructor:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_CXXDestructorDecl(D), Latest);
      break;
     case MSProperty:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_MSPropertyDecl(D), Latest);
      break;
     case NonTypeTemplateParm:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_NonTypeTemplateParmDecl(D), Latest);
      break;
     case Var:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_VarDecl(D), Latest);
      break;
     case ImplicitParam:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ImplicitParamDecl(D), Latest);
      break;
     case OMPCapturedExpr:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_OMPCapturedExprDecl(D), Latest);
      break;
     case ParmVar:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_ParmVarDecl(D), Latest);
      break;
     case VarTemplateSpecialization:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_VarTemplateSpecializationDecl(D), Latest);
      break;
     case VarTemplatePartialSpecialization:
      ASTDeclReader.attachLatestDeclImpl$T(AstDeclarationsRTTI.cast_VarTemplatePartialSpecializationDecl(D), Latest);
      break;
     case EnumConstant:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_EnumConstantDecl(D), Latest);
      break;
     case IndirectField:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_IndirectFieldDecl(D), Latest);
      break;
     case OMPDeclareReduction:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_OMPDeclareReductionDecl(D), Latest);
      break;
     case UnresolvedUsingValue:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_UnresolvedUsingValueDecl(D), Latest);
      break;
     case OMPThreadPrivate:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_OMPThreadPrivateDecl(D), Latest);
      break;
     case ObjCPropertyImpl:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_ObjCPropertyImplDecl(D), Latest);
      break;
     case PragmaComment:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_PragmaCommentDecl(D), Latest);
      break;
     case PragmaDetectMismatch:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_PragmaDetectMismatchDecl(D), Latest);
      break;
     case StaticAssert:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_StaticAssertDecl(D), Latest);
      break;
     case TranslationUnit:
      attachLatestDeclImpl(AstDeclarationsRTTI.cast_TranslationUnitDecl(D), Latest);
      break;
    }
  }

  
  /*template <typename DeclT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::markIncompleteDeclChainImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3184,
   FQN="clang::ASTDeclReader::markIncompleteDeclChainImpl", NM="Tpl__ZN5clang13ASTDeclReader27markIncompleteDeclChainImplEPNS_12RedeclarableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader27markIncompleteDeclChainImplEPNS_12RedeclarableIT_EE")
  //</editor-fold>
  public static </*typename*/ DeclT extends Decl & Redeclarable> void markIncompleteDeclChainImpl$T(Redeclarable<DeclT> /*P*/ D) {
    D.$Redeclarable$Fields().RedeclLink.markIncomplete();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::markIncompleteDeclChainImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3187,
   FQN="clang::ASTDeclReader::markIncompleteDeclChainImpl", NM="_ZN5clang13ASTDeclReader27markIncompleteDeclChainImplEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader27markIncompleteDeclChainImplEz")
  //</editor-fold>
  public static void markIncompleteDeclChainImpl(Object ... $VarArg) {
    throw new llvm_unreachable("markIncompleteDeclChain on non-redeclarable declaration");
  }

  
  /// \brief Determine whether this declaration has a pending body.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::hasPendingBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 250,
   FQN="clang::ASTDeclReader::hasPendingBody", NM="_ZNK5clang13ASTDeclReader14hasPendingBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13ASTDeclReader14hasPendingBodyEv")
  //</editor-fold>
  public boolean hasPendingBody() /*const*/ {
    return HasPendingBody;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::Visit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 450,
   FQN="clang::ASTDeclReader::Visit", NM="_ZN5clang13ASTDeclReader5VisitEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader5VisitEPNS_4DeclE")
  //</editor-fold>
  public void Visit(Decl /*P*/ D) {
    DeclVisitorVoid.super.Visit(D);
    
    // At this point we have deserialized and merged the decl and it is safe to
    // update its canonical decl to signal that the entire entity is used.
    D.getCanonicalDecl().Used |= IsDeclMarkedUsed;
    IsDeclMarkedUsed = false;
    {
      
      DeclaratorDecl /*P*/ DD = AstDeclarationsRTTI.dyn_cast_DeclaratorDecl(D);
      if ((DD != null)) {
        if (DD.DeclInfo.$bool()) {
          DeclaratorDecl.ExtInfo /*P*/ Info = DD.DeclInfo.get(DeclaratorDecl.ExtInfo /*P*/.class);
          Info.TInfo
             = GetTypeSourceInfo(Record, Idx);
        } else {
          DD.DeclInfo.$assign_T$C$R(TypeSourceInfo /*P*/ /*const*/ /*&*/.class, GetTypeSourceInfo(Record, Idx));
        }
      }
    }
    {
      
      TypeDecl /*P*/ TD = AstDeclarationsRTTI.dyn_cast_TypeDecl(D);
      if ((TD != null)) {
        // We have a fully initialized TypeDecl. Read its type now.
        TD.setTypeForDecl(Reader.GetType(TypeIDForTypeDecl).getTypePtrOrNull());
        
        // If this is a tag declaration with a typedef name for linkage, it's safe
        // to load that typedef now.
        if ((NamedDeclForTagDecl != 0)) {
          AstDeclarationsRTTI.cast_TagDecl(D).TypedefNameDeclOrQualifier.$assign_T$C$R(TypedefNameDecl /*P*/ /*const*/ /*&*/.class,
              AstDeclarationsRTTI.cast_TypedefNameDecl(Reader.GetDecl(NamedDeclForTagDecl))
          );
        }
      } else {
        ObjCInterfaceDecl /*P*/ ID = AstDeclarationsRTTI.dyn_cast_ObjCInterfaceDecl(D);
        if ((ID != null)) {
          // if we have a fully initialized TypeDecl, we can safely read its type now.
          ID.TypeForDecl = Reader.GetType(TypeIDForTypeDecl).getTypePtrOrNull();
        } else {
          FunctionDecl /*P*/ FD = AstDeclarationsRTTI.dyn_cast_FunctionDecl(D);
          if ((FD != null)) {
            // FunctionDecl's body was written last after all other Stmts/Exprs.
            // We only read it if FD doesn't already have a body (e.g., from another
            // module).
            // FIXME: Can we diagnose ODR violations somehow?
            if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
              {
                CXXConstructorDecl /*P*/ CD = AstJavaFixedRTTI.dyn_cast_CXXConstructorDecl(FD);
                if ((CD != null)) {
                  CD.NumCtorInitializers = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
                  if ((CD.NumCtorInitializers != 0)) {
                    CD.CtorInitializers.$assign(ReadGlobalOffset(F, Record, Idx));
                  }
                }
              }
              Reader.PendingBodies.$set(FD, GetCurrentCursorOffset());
              HasPendingBody = true;
            }
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::UpdateDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3716,
   FQN="clang::ASTDeclReader::UpdateDecl", NM="_ZN5clang13ASTDeclReader10UpdateDeclEPNS_4DeclERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader10UpdateDeclEPNS_4DeclERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEE")
  //</editor-fold>
  public void UpdateDecl(Decl /*P*/ D, final ModuleFile /*&*/ $ModuleFile,
            final /*const*/SmallVectorULong /*&*/ Record) {
    while (Unsigned.$less_uint(Idx.$deref(), Record.size())) {
      switch ((int)Record.$at$Const(Idx.$set$postInc())) {
       case DeclUpdateKind.UPD_CXX_ADDED_IMPLICIT_MEMBER:
        {
          CXXRecordDecl /*P*/ RD = AstDeclarationsRTTI.cast_CXXRecordDecl(D);
          // FIXME: If we also have an update record for instantiating the
          // definition of D, we need that to happen before we get here.
          Decl /*P*/ MD = Reader.ReadDecl($ModuleFile, Record, Idx);
          assert ((MD != null)) : "couldn't read decl from update record";
          // FIXME: We should call addHiddenDecl instead, to add the member
          // to its DeclContext.
          RD.addedMember(MD);
          break;
        }
       case DeclUpdateKind.UPD_CXX_ADDED_TEMPLATE_SPECIALIZATION:
        // It will be added to the template's specializations set when loaded.
        /*J:(void)*/Reader.ReadDecl($ModuleFile, Record, Idx);
        break;
       case DeclUpdateKind.UPD_CXX_ADDED_ANONYMOUS_NAMESPACE:
        {
          NamespaceDecl /*P*/ Anon = Reader.<NamespaceDecl>ReadDeclAs(NamespaceDecl.class, $ModuleFile, Record, Idx);
          
          // Each module has its own anonymous namespace, which is disjoint from
          // any other module's anonymous namespaces, so don't attach the anonymous
          // namespace at all.
          if ($ModuleFile.Kind != ModuleKind.MK_ImplicitModule
             && $ModuleFile.Kind != ModuleKind.MK_ExplicitModule) {
            {
              TranslationUnitDecl /*P*/ TU = AstDeclarationsRTTI.dyn_cast_TranslationUnitDecl(D);
              if ((TU != null)) {
                TU.setAnonymousNamespace(Anon);
              } else {
                AstDeclarationsRTTI.cast_NamespaceDecl(D).setAnonymousNamespace(Anon);
              }
            }
          }
          break;
        }
       case DeclUpdateKind.UPD_CXX_INSTANTIATED_STATIC_DATA_MEMBER:
        AstDeclarationsRTTI.cast_VarDecl(D).getMemberSpecializationInfo().setPointOfInstantiation(Reader.ReadSourceLocation($ModuleFile, Record, Idx));
        break;
       case DeclUpdateKind.UPD_CXX_INSTANTIATED_DEFAULT_ARGUMENT:
        {
          ParmVarDecl /*P*/ Param = AstDeclarationsRTTI.cast_ParmVarDecl(D);
          
          // We have to read the default argument regardless of whether we use it
          // so that hypothetical further update records aren't messed up.
          // TODO: Add a function to skip over the next expr record.
          Expr /*P*/ DefaultArg = Reader.ReadExpr(F);
          
          // Only apply the update if the parameter still has an uninstantiated
          // default argument.
          if (Param.hasUninstantiatedDefaultArg()) {
            Param.setDefaultArg(DefaultArg);
          }
          break;
        }
       case DeclUpdateKind.UPD_CXX_ADDED_FUNCTION_DEFINITION:
        {
          FunctionDecl /*P*/ FD = AstDeclarationsRTTI.cast_FunctionDecl(D);
          if ((Reader.PendingBodies.$at(FD) != 0)) {
            // FIXME: Maybe check for ODR violations.
            // It's safe to stop now because this update record is always last.
            return;
          }
          if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
            // Maintain AST consistency: any later redeclarations of this function
            // are inline if this one is. (We might have merged another declaration
            // into this one.)
            ASTReaderDeclStatics.forAllLaterRedecls(FD, /*[]*/ (FunctionDecl /*P*/ FD$1) -> {
                      FD$1.setImplicitlyInline();
                    });
          }
          FD.setInnerLocStart(Reader.ReadSourceLocation($ModuleFile, Record, Idx));
          {
            CXXConstructorDecl /*P*/ CD = AstJavaFixedRTTI.dyn_cast_CXXConstructorDecl(FD);
            if ((CD != null)) {
              CD.NumCtorInitializers = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
              if ((CD.NumCtorInitializers != 0)) {
                CD.CtorInitializers.$assign(ReadGlobalOffset(F, Record, Idx));
              }
            }
          }
          // Store the offset of the body so we can lazily load it later.
          Reader.PendingBodies.$set(FD, GetCurrentCursorOffset());
          HasPendingBody = true;
          assert (Idx.$deref() == Record.size()) : "lazy body must be last";
          break;
        }
       case DeclUpdateKind.UPD_CXX_INSTANTIATED_CLASS_DEFINITION:
        {
          CXXRecordDecl /*P*/ RD = AstDeclarationsRTTI.cast_CXXRecordDecl(D);
          CXXRecordDecl.DefinitionData /*P*/ OldDD = RD.getCanonicalDecl().DefinitionData;
          boolean HadRealDefinition = (OldDD != null) && (OldDD.Definition != RD
             || !(Reader.PendingFakeDefinitionData.count(OldDD) != 0));
          ReadCXXRecordDefinition(RD, /*Update*/ true);
          
          // Visible update is handled separately.
          long/*uint64_t*/ LexicalOffset = ReadLocalOffset(Record, Idx);
          if (!HadRealDefinition && (LexicalOffset != 0)) {
            Reader.ReadLexicalDeclContextStorage($ModuleFile, $ModuleFile.DeclsCursor, 
                LexicalOffset, RD);
            Reader.PendingFakeDefinitionData.erase(OldDD);
          }
          
          TemplateSpecializationKind TSK = TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          SourceLocation POI = Reader.ReadSourceLocation($ModuleFile, Record, Idx);
          {
            MemberSpecializationInfo /*P*/ MSInfo = RD.getMemberSpecializationInfo();
            if ((MSInfo != null)) {
              MSInfo.setTemplateSpecializationKind(TSK);
              MSInfo.setPointOfInstantiation(new SourceLocation(POI));
            } else {
              ClassTemplateSpecializationDecl /*P*/ Spec = AstJavaFixedRTTI.cast_ClassTemplateSpecializationDecl(RD);
              Spec.setTemplateSpecializationKind(TSK);
              Spec.setPointOfInstantiation(new SourceLocation(POI));
              if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
                ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec =  this.<ClassTemplatePartialSpecializationDecl>ReadDeclAs(ClassTemplatePartialSpecializationDecl.class, Record, Idx);
                SmallVector<TemplateArgument> TemplArgs/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
                Reader.ReadTemplateArgumentList(TemplArgs, F, Record, Idx);
                TemplateArgumentList /*P*/ TemplArgList = TemplateArgumentList.CreateCopy(Reader.getContext(), new ArrayRef<TemplateArgument>(TemplArgs, false));
                
                // FIXME: If we already have a partial specialization set,
                // check that it matches.
                if (!(Spec.getSpecializedTemplateOrPartial().is(ClassTemplatePartialSpecializationDecl /*P*/.class) != 0)) {
                  Spec.setInstantiationOf(PartialSpec, TemplArgList);
                }
              }
            }
          }
          
          RD.setTagKind(TagTypeKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
          RD.setLocation(Reader.ReadSourceLocation($ModuleFile, Record, Idx));
          RD.setLocStart(Reader.ReadSourceLocation($ModuleFile, Record, Idx));
          RD.setBraceRange(Reader.ReadSourceRange($ModuleFile, Record, Idx));
          if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
            SmallVector<Attr /*P*/> Attrs/*J*/= new SmallVector<Attr /*P*/>(4, null);
            Reader.ReadAttributes(F, Attrs, Record, Idx);
            D.setAttrsImpl(Attrs, Reader.getContext());
          }
          break;
        }
       case DeclUpdateKind.UPD_CXX_RESOLVED_DTOR_DELETE:
        {
          // Set the 'operator delete' directly to avoid emitting another update
          // record.
          FunctionDecl /*P*/ Del = Reader.<FunctionDecl>ReadDeclAs(FunctionDecl.class, $ModuleFile, Record, Idx);
          CXXDestructorDecl /*P*/ First = AstDeclarationsRTTI.cast_CXXDestructorDecl(D.getCanonicalDecl());
          // FIXME: Check consistency if we have an old and new operator delete.
          if (!(First.OperatorDelete != null)) {
            First.OperatorDelete = Del;
          }
          break;
        }
       case DeclUpdateKind.UPD_CXX_RESOLVED_EXCEPTION_SPEC:
        {
          FunctionProtoType.ExceptionSpecInfo ESI/*J*/= new FunctionProtoType.ExceptionSpecInfo();
          SmallVector<QualType> ExceptionStorage/*J*/= new SmallVector<QualType>(8, new QualType());
          Reader.readExceptionSpec($ModuleFile, ExceptionStorage, ESI, Record, Idx);
          
          // Update this declaration's exception specification, if needed.
          FunctionDecl /*P*/ FD = AstDeclarationsRTTI.cast_FunctionDecl(D);
          /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().castAs(FunctionProtoType.class);
          // FIXME: If the exception specification is already present, check that it
          // matches.
          if (BasicClangGlobals.isUnresolvedExceptionSpec(FPT.getExceptionSpecType())) {
            FD.setType(Reader.Context.getFunctionType(FPT.getReturnType(), FPT.getParamTypes(), 
                    FPT.getExtProtoInfo().withExceptionSpec(ESI)));
            
            // When we get to the end of deserializing, see if there are other decls
            // that we need to propagate this exception specification onto.
            Reader.PendingExceptionSpecUpdates.insert(new std.pairPtrPtr<Decl /*P*/ , FunctionDecl /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/FD.getCanonicalDecl(), /*Fwd2*//*Fwd*/FD));
          }
          break;
        }
       case DeclUpdateKind.UPD_CXX_DEDUCED_RETURN_TYPE:
        {
          // FIXME: Also do this when merging redecls.
          QualType DeducedResultType = Reader.readType($ModuleFile, Record, Idx);
          for (Redeclarable Redecl : merged_redecls((Redeclarable) D)) {
            // FIXME: If the return type is already deduced, check that it matches.
            FunctionDecl /*P*/ FD = AstJavaFixedRTTI.cast_FunctionDecl((FunctionDecl)Redecl);
            Reader.Context.adjustDeducedFunctionResultType(FD, new QualType(DeducedResultType));
          }
          break;
        }
       case DeclUpdateKind.UPD_DECL_MARKED_USED:
        {
          // Maintain AST consistency: any later redeclarations are used too.
          D.markUsed(Reader.Context);
          break;
        }
       case DeclUpdateKind.UPD_MANGLING_NUMBER:
        Reader.Context.setManglingNumber(AstDeclarationsRTTI.cast_NamedDecl(D), Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
        break;
       case DeclUpdateKind.UPD_STATIC_LOCAL_NUMBER:
        Reader.Context.setStaticLocalNumber(AstDeclarationsRTTI.cast_VarDecl(D), Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
        break;
       case DeclUpdateKind.UPD_DECL_MARKED_OPENMP_THREADPRIVATE:
        D.addAttr(OMPThreadPrivateDeclAttr.CreateImplicit(Reader.Context, ReadSourceRange(Record, Idx)));
        break;
       case DeclUpdateKind.UPD_DECL_EXPORTED:
        {
          /*uint*/int SubmoduleID = readSubmoduleID(Record, Idx);
          NamedDecl /*P*/ Exported = AstDeclarationsRTTI.cast_NamedDecl(D);
          {
            TagDecl /*P*/ TD = AstDeclarationsRTTI.dyn_cast_TagDecl(Exported);
            if ((TD != null)) {
              Exported = TD.getDefinition();
            }
          }
          Module$B /*P*/ Owner = (SubmoduleID != 0) ? Reader.getSubmodule(SubmoduleID) : null;
          if (Reader.getContext().getLangOpts().ModulesLocalVisibility) {
            Reader.getContext().mergeDefinitionIntoModule(AstDeclarationsRTTI.cast_NamedDecl(Exported),
                Owner);
            Reader.PendingMergedDefinitionsToDeduplicate.insert(AstDeclarationsRTTI.cast_NamedDecl(Exported));
          } else if ((Owner != null) && Owner.NameVisibility != Module$B.NameVisibilityKind.AllVisible) {
            // If Owner is made visible at some later point, make this declaration
            // visible too.
            Reader.HiddenNamesMap.$at_T1$C$R(Owner).push_back(Exported);
          } else {
            // The declaration is now visible.
            Exported.Hidden = false;
          }
          break;
        }
       case DeclUpdateKind.UPD_DECL_MARKED_OPENMP_DECLARETARGET:
       case DeclUpdateKind.UPD_ADDED_ATTR_TO_RECORD:
        SmallVector<Attr /*P*/> Attrs/*J*/= new SmallVector<Attr /*P*/>(4, null);
        Reader.ReadAttributes(F, Attrs, Record, Idx);
        assert (Attrs.size() == 1);
        D.addAttr(Attrs.$at(0));
        break;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::setNextObjCCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 257,
   FQN="clang::ASTDeclReader::setNextObjCCategory", NM="_ZN5clang13ASTDeclReader19setNextObjCCategoryEPNS_16ObjCCategoryDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19setNextObjCCategoryEPNS_16ObjCCategoryDeclES2_")
  //</editor-fold>
  public static void setNextObjCCategory(ObjCCategoryDecl /*P*/ Cat, 
                     ObjCCategoryDecl /*P*/ Next) {
    Cat.NextClassCategory = Next;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 499,
   FQN="clang::ASTDeclReader::VisitDecl", NM="_ZN5clang13ASTDeclReader9VisitDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader9VisitDeclEPNS_4DeclE")
  //</editor-fold>
  public void VisitDecl(Decl /*P*/ D) {
    if (D.isTemplateParameter() || D.isTemplateParameterPack()
       || AstDeclarationsRTTI.isa_ParmVarDecl(D)) {
      // We don't want to deserialize the DeclContext of a template
      // parameter or of a parameter of a function template immediately.   These
      // entities might be used in the formulation of its DeclContext (for
      // example, a function parameter can be used in decltype() in trailing
      // return type of the function).  Use the translation unit DeclContext as a
      // placeholder.
      /*uint32_t*/int SemaDCIDForTemplateParmDecl = ReadDeclID(Record, Idx);
      /*uint32_t*/int LexicalDCIDForTemplateParmDecl = ReadDeclID(Record, Idx);
      if (!(LexicalDCIDForTemplateParmDecl != 0)) {
        LexicalDCIDForTemplateParmDecl = SemaDCIDForTemplateParmDecl;
      }
      Reader.addPendingDeclContextInfo(D, 
          SemaDCIDForTemplateParmDecl, 
          LexicalDCIDForTemplateParmDecl);
      D.setDeclContext(Reader.getContext().getTranslationUnitDecl());
    } else {
      DeclContext /*P*/ SemaDC = this.<DeclContext>ReadDeclAs(DeclContext.class, Record, Idx);
      DeclContext /*P*/ LexicalDC = this.<DeclContext>ReadDeclAs(DeclContext.class, Record, Idx);
      if (!(LexicalDC != null)) {
        LexicalDC = SemaDC;
      }
      DeclContext /*P*/ MergedSemaDC = Reader.MergedDeclContexts.lookup(SemaDC);
      // Avoid calling setLexicalDeclContext() directly because it uses
      // Decl::getASTContext() internally which is unsafe during derialization.
      D.setDeclContextsImpl((MergedSemaDC != null) ? MergedSemaDC : SemaDC, LexicalDC, 
          Reader.getContext());
    }
    D.setLocation(new SourceLocation(ThisDeclLoc));
    D.setInvalidDecl((Record.$at$Const(Idx.$set$postInc()) != 0));
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // hasAttrs
      SmallVector<Attr /*P*/> Attrs/*J*/= new SmallVector<Attr /*P*/>(4, null);
      Reader.ReadAttributes(F, Attrs, Record, Idx);
      // Avoid calling setAttrs() directly because it uses Decl::getASTContext()
      // internally which is unsafe during derialization.
      D.setAttrsImpl(Attrs, Reader.getContext());
    }
    D.setImplicit((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.Used = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    IsDeclMarkedUsed |= D.Used;
    D.setReferenced((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.setTopLevelDeclInObjCContainer((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.setAccess(AccessSpecifier.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    D.FromASTFile = true;
    D.setModulePrivate((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.Hidden = D.isModulePrivate();
    {
      
      // Determine whether this declaration is part of a (sub)module. If so, it
      // may not yet be visible.
      /*uint*/int SubmoduleID = readSubmoduleID(Record, Idx);
      if ((SubmoduleID != 0)) {
        // Store the owning submodule ID in the declaration.
        D.setOwningModuleID(SubmoduleID);
        if (D.Hidden) {
          // Module-private declarations are never visible, so there is no work to do.
        } else if (Reader.getContext().getLangOpts().ModulesLocalVisibility) {
          // If local visibility is being tracked, this declaration will become
          // hidden and visible as the owning module does. Inform Sema that this
          // declaration might not be visible.
          D.Hidden = true;
        } else {
          Module$B /*P*/ Owner = Reader.getSubmodule(SubmoduleID);
          if ((Owner != null)) {
            if (Owner.NameVisibility != Module$B.NameVisibilityKind.AllVisible) {
              // The owning module is not visible. Mark this declaration as hidden.
              D.Hidden = true;
              
              // Note that this declaration was hidden because its owning module is 
              // not yet visible.
              Reader.HiddenNamesMap.$at_T1$C$R(Owner).push_back(D);
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitPragmaCommentDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 572,
   FQN="clang::ASTDeclReader::VisitPragmaCommentDecl", NM="_ZN5clang13ASTDeclReader22VisitPragmaCommentDeclEPNS_17PragmaCommentDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitPragmaCommentDeclEPNS_17PragmaCommentDeclE")
  //</editor-fold>
  public void VisitPragmaCommentDecl(PragmaCommentDecl /*P*/ D) {
    VisitDecl(D);
    D.setLocation(ReadSourceLocation(Record, Idx));
    D.CommentKind = PragmaMSCommentKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    std.string Arg = ReadString(Record, Idx);
    std.memcpy(D.getTrailingObjects(/*char byte.class*/), Arg.data(), Arg.size());
    D.getTrailingObjects(/*char byte.class*/).$set(Arg.size(), literal_constants.$$TERM);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitPragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 581,
   FQN="clang::ASTDeclReader::VisitPragmaDetectMismatchDecl", NM="_ZN5clang13ASTDeclReader29VisitPragmaDetectMismatchDeclEPNS_24PragmaDetectMismatchDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader29VisitPragmaDetectMismatchDeclEPNS_24PragmaDetectMismatchDeclE")
  //</editor-fold>
  public void VisitPragmaDetectMismatchDecl(PragmaDetectMismatchDecl /*P*/ D) {
    VisitDecl(D);
    D.setLocation(ReadSourceLocation(Record, Idx));
    std.string Name = ReadString(Record, Idx);
    std.memcpy(D.getTrailingObjects(/*char byte.class*/), Name.data(), Name.size());
    D.getTrailingObjects(/*char byte.class*/).$set(Name.size(), literal_constants.$$TERM);
    
    D.ValueStart = Name.size() + 1;
    std.string Value = ReadString(Record, Idx);
    std.memcpy(D.getTrailingObjects(/*char byte.class*/).$add(D.ValueStart), Value.data(),
        Value.size());
    D.getTrailingObjects(/*char byte.class*/).$set(D.ValueStart + Value.size(), literal_constants.$$TERM);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 595,
   FQN="clang::ASTDeclReader::VisitTranslationUnitDecl", NM="_ZN5clang13ASTDeclReader24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE")
  //</editor-fold>
  public void VisitTranslationUnitDecl(TranslationUnitDecl /*P*/ TU) {
    throw new llvm_unreachable("Translation units are not serialized");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitNamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 599,
   FQN="clang::ASTDeclReader::VisitNamedDecl", NM="_ZN5clang13ASTDeclReader14VisitNamedDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitNamedDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void VisitNamedDecl(NamedDecl /*P*/ ND) {
    VisitDecl(ND);
    ND.setDeclName(Reader.ReadDeclarationName(F, Record, Idx));
    AnonymousDeclNumber = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitLabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1355,
   FQN="clang::ASTDeclReader::VisitLabelDecl", NM="_ZN5clang13ASTDeclReader14VisitLabelDeclEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitLabelDeclEPNS_9LabelDeclE")
  //</editor-fold>
  public void VisitLabelDecl(LabelDecl /*P*/ D) {
    VisitNamedDecl(D);
    D.setLocStart(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1360,
   FQN="clang::ASTDeclReader::VisitNamespaceDecl", NM="_ZN5clang13ASTDeclReader18VisitNamespaceDeclEPNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18VisitNamespaceDeclEPNS_13NamespaceDeclE")
  //</editor-fold>
  public void VisitNamespaceDecl(NamespaceDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitRedeclarable(D);
    VisitNamedDecl(D);
    D.setInline((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.LocStart.$assignMove(ReadSourceLocation(Record, Idx));
    D.RBraceLoc.$assignMove(ReadSourceLocation(Record, Idx));
    
    // Defer loading the anonymous namespace until we've finished merging
    // this namespace; loading it might load a later declaration of the
    // same namespace, and we have an invariant that older declarations
    // get merged before newer ones try to merge.
    /*uint32_t*/int AnonNamespace = 0;
    if (Redecl.getFirstID() == ThisDeclID) {
      AnonNamespace = ReadDeclID(Record, Idx);
    } else {
      // Link this namespace back to the first declaration, which has already
      // been deserialized.
      D.AnonOrFirstNamespaceAndInline.setPointer(D.getFirstDecl());
    }
    
    mergeRedeclarable(D, Redecl);
    if ((AnonNamespace != 0)) {
      // Each module has its own anonymous namespace, which is disjoint from
      // any other module's anonymous namespaces, so don't attach the anonymous
      // namespace at all.
      NamespaceDecl /*P*/ Anon = AstDeclarationsRTTI.cast_NamespaceDecl(Reader.GetDecl(AnonNamespace));
      if (F.Kind != ModuleKind.MK_ImplicitModule && F.Kind != ModuleKind.MK_ExplicitModule) {
        D.setAnonymousNamespace(Anon);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitUsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1435,
   FQN="clang::ASTDeclReader::VisitUsingDirectiveDecl", NM="_ZN5clang13ASTDeclReader23VisitUsingDirectiveDeclEPNS_18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader23VisitUsingDirectiveDeclEPNS_18UsingDirectiveDeclE")
  //</editor-fold>
  public void VisitUsingDirectiveDecl(UsingDirectiveDecl /*P*/ D) {
    VisitNamedDecl(D);
    D.UsingLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.NamespaceLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    D.NominatedNamespace = this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx);
    D.CommonAncestor = this.<DeclContext>ReadDeclAs(DeclContext.class, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitNamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1392,
   FQN="clang::ASTDeclReader::VisitNamespaceAliasDecl", NM="_ZN5clang13ASTDeclReader23VisitNamespaceAliasDeclEPNS_18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader23VisitNamespaceAliasDeclEPNS_18NamespaceAliasDeclE")
  //</editor-fold>
  public void VisitNamespaceAliasDecl(NamespaceAliasDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitRedeclarable(D);
    VisitNamedDecl(D);
    D.NamespaceLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.IdentLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    D.Namespace = this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx);
    mergeRedeclarable(D, Redecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTypeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 605,
   FQN="clang::ASTDeclReader::VisitTypeDecl", NM="_ZN5clang13ASTDeclReader13VisitTypeDeclEPNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader13VisitTypeDeclEPNS_8TypeDeclE")
  //</editor-fold>
  public void VisitTypeDecl(TypeDecl /*P*/ TD) {
    VisitNamedDecl(TD);
    TD.setLocStart(ReadSourceLocation(Record, Idx));
    // Delay type reading until after we have fully initialized the decl.
    TypeIDForTypeDecl = Reader.getGlobalTypeID(F, Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 612,
   FQN="clang::ASTDeclReader::VisitTypedefNameDecl", NM="_ZN5clang13ASTDeclReader20VisitTypedefNameDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20VisitTypedefNameDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult ASTDeclReader$VisitTypedefNameDecl(TypedefNameDecl /*P*/ TD) {
    RedeclarableResult Redecl = VisitRedeclarable(TD);
    VisitTypeDecl(TD);
    TypeSourceInfo /*P*/ TInfo = GetTypeSourceInfo(Record, Idx);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // isModed
      QualType modedT = Reader.readType(F, Record, Idx);
      TD.setModedTypeSourceInfo(TInfo, new QualType(modedT));
    } else {
      TD.setTypeSourceInfo(TInfo);
    }
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 625,
   FQN="clang::ASTDeclReader::VisitTypedefDecl", NM="_ZN5clang13ASTDeclReader16VisitTypedefDeclEPNS_11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader16VisitTypedefDeclEPNS_11TypedefDeclE")
  //</editor-fold>
  public void VisitTypedefDecl(TypedefDecl /*P*/ TD) {
    RedeclarableResult Redecl = ASTDeclReader$VisitTypedefNameDecl(TD);
    mergeRedeclarable(TD, Redecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 630,
   FQN="clang::ASTDeclReader::VisitTypeAliasDecl", NM="_ZN5clang13ASTDeclReader18VisitTypeAliasDeclEPNS_13TypeAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18VisitTypeAliasDeclEPNS_13TypeAliasDeclE")
  //</editor-fold>
  public void VisitTypeAliasDecl(TypeAliasDecl /*P*/ TD) {
    RedeclarableResult Redecl = ASTDeclReader$VisitTypedefNameDecl(TD);
    {
      TypeAliasTemplateDecl /*P*/ Template = this.<TypeAliasTemplateDecl>ReadDeclAs(TypeAliasTemplateDecl.class, Record, Idx);
      if ((Template != null)) {
        // Merged when we merge the template.
        TD.setDescribedAliasTemplate(Template);
      } else {
        mergeRedeclarable(TD, Redecl);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitUnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1452,
   FQN="clang::ASTDeclReader::VisitUnresolvedUsingTypenameDecl", NM="_ZN5clang13ASTDeclReader32VisitUnresolvedUsingTypenameDeclEPNS_27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader32VisitUnresolvedUsingTypenameDeclEPNS_27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypenameDecl(UnresolvedUsingTypenameDecl /*P*/ D) {
    VisitTypeDecl(D);
    D.TypenameLocation.$assignMove(ReadSourceLocation(Record, Idx));
    D.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    mergeMergeable(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTagDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 639,
   FQN="clang::ASTDeclReader::VisitTagDecl", NM="_ZN5clang13ASTDeclReader12VisitTagDeclEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader12VisitTagDeclEPNS_7TagDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult ASTDeclReader$VisitTagDecl(TagDecl /*P*/ TD) {
    RedeclarableResult Redecl = VisitRedeclarable(TD);
    VisitTypeDecl(TD);
    
    TD.IdentifierNamespace_field = Unsigned.$uint2uint_13bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    TD.setTagKind(TagTypeKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    if (!AstJavaFixedRTTI.isa_CXXRecordDecl(TD)) {
      TD.setCompleteDefinition((Record.$at$Const(Idx.$set$postInc()) != 0));
    }
    TD.setEmbeddedInDeclarator((Record.$at$Const(Idx.$set$postInc()) != 0));
    TD.setFreeStanding((Record.$at$Const(Idx.$set$postInc()) != 0));
    TD.setCompleteDefinitionRequired((Record.$at$Const(Idx.$set$postInc()) != 0));
    TD.setBraceRange(ReadSourceRange(Record, Idx));
    switch ((int)Record.$at$Const(Idx.$set$postInc())) {
     case 0:
      break;
     case 1:
      { // ExtInfo
        QualifierInfo /*P*/ Info = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Reader.getContext())*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(Reader.getContext(), (type$ptr<?> New$Mem)->{
            return new QualifierInfo();
         });
        ReadQualifierInfo(Native.$Deref(Info), Record, Idx);
        TD.TypedefNameDeclOrQualifier.$assign_T1$C$R(QualifierInfo /*P*/ /*const*/ /*&*/.class, Info);
        break;
      }
     case 2: // TypedefNameForAnonDecl
      NamedDeclForTagDecl = ReadDeclID(Record, Idx);
      TypedefNameForLinkage = Reader.GetIdentifierInfo(F, Record, Idx);
      break;
     default:
      throw new llvm_unreachable("unexpected tag info kind");
    }
    if (!AstJavaFixedRTTI.isa_CXXRecordDecl(TD)) {
      mergeRedeclarable(TD, Redecl);
    }
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitEnumDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 674,
   FQN="clang::ASTDeclReader::VisitEnumDecl", NM="_ZN5clang13ASTDeclReader13VisitEnumDeclEPNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader13VisitEnumDeclEPNS_8EnumDeclE")
  //</editor-fold>
  public void VisitEnumDecl(EnumDecl /*P*/ ED) {
    ASTDeclReader$VisitTagDecl(ED);
    {
      TypeSourceInfo /*P*/ TI = Reader.GetTypeSourceInfo(F, Record, Idx);
      if ((TI != null)) {
        ED.setIntegerTypeSourceInfo(TI);
      } else {
        ED.setIntegerType(Reader.readType(F, Record, Idx));
      }
    }
    ED.setPromotionType(Reader.readType(F, Record, Idx));
    ED.setNumPositiveBits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    ED.setNumNegativeBits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    ED.IsScoped = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    ED.IsScopedUsingClassTag = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    ED.IsFixed = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    // If this is a definition subject to the ODR, and we already have a
    // definition, merge this one into it.
    if (ED.IsCompleteDefinition
       && Reader.getContext().getLangOpts().Modules
       && Reader.getContext().getLangOpts().CPlusPlus) {
      final type$ref<EnumDecl /*P*/ /*&*/> OldDef = Reader.EnumDefinitions.ref$at(ED.getCanonicalDecl());
      if (!(OldDef.$deref() != null)) {
        // This is the first time we've seen an imported definition. Look for a
        // local definition before deciding that we are the first definition.
        for (Redeclarable D : merged_redecls(ED.getCanonicalDecl())) {
          if (!((EnumDecl)D).isFromASTFile() && ((EnumDecl)D).isCompleteDefinition()) {
            OldDef.$set(((EnumDecl)D));
            break;
          }
        }
      }
      if ((OldDef.$deref() != null)) {
        Reader.MergedDeclContexts.insert_pair$KeyT$ValueT(new std.pairPtrPtr<DeclContext /*P*/ , DeclContext /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/ED, /*Fwd2*//*Fwd*/OldDef));
        ED.IsCompleteDefinition = false;
        mergeDefinitionVisibility(OldDef.$deref(), ED);
      } else {
        OldDef.$set(ED);
      }
    }
    {
      
      EnumDecl /*P*/ InstED = this.<EnumDecl>ReadDeclAs(EnumDecl.class, Record, Idx);
      if ((InstED != null)) {
        TemplateSpecializationKind TSK = TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        SourceLocation POI = ReadSourceLocation(Record, Idx);
        ED.setInstantiationOfMemberEnum(Reader.getContext(), InstED, TSK);
        ED.getMemberSpecializationInfo().setPointOfInstantiation(new SourceLocation(POI));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitRecordDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 720,
   FQN="clang::ASTDeclReader::VisitRecordDeclImpl", NM="_ZN5clang13ASTDeclReader19VisitRecordDeclImplEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19VisitRecordDeclImplEPNS_10RecordDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult VisitRecordDeclImpl(RecordDecl /*P*/ RD) {
    RedeclarableResult Redecl = ASTDeclReader$VisitTagDecl(RD);
    RD.setHasFlexibleArrayMember((Record.$at$Const(Idx.$set$postInc()) != 0));
    RD.setAnonymousStructOrUnion((Record.$at$Const(Idx.$set$postInc()) != 0));
    RD.setHasObjectMember((Record.$at$Const(Idx.$set$postInc()) != 0));
    RD.setHasVolatileMember((Record.$at$Const(Idx.$set$postInc()) != 0));
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 279,
   FQN="clang::ASTDeclReader::VisitRecordDecl", NM="_ZN5clang13ASTDeclReader15VisitRecordDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader15VisitRecordDeclEPNS_10RecordDeclE")
  //</editor-fold>
  public void VisitRecordDecl(RecordDecl /*P*/ RD) {
    VisitRecordDeclImpl(RD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCXXRecordDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1700,
   FQN="clang::ASTDeclReader::VisitCXXRecordDeclImpl", NM="_ZN5clang13ASTDeclReader22VisitCXXRecordDeclImplEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitCXXRecordDeclImplEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult VisitCXXRecordDeclImpl(CXXRecordDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitRecordDeclImpl(D);
    
    final ASTContext /*&*/ C = Reader.getContext();
    
    final class/*enum*/ CXXRecKind {
      private static final /*uint*/int CXXRecNotTemplate = 0;
      private static final /*uint*/int CXXRecTemplate = CXXRecNotTemplate + 1;
      private static final /*uint*/int CXXRecMemberSpecialization = CXXRecTemplate + 1;
    };
    switch ((/*CXXRecKind*//*uint*/int)Record.$at$Const(Idx.$set$postInc())) {
     case CXXRecKind.CXXRecNotTemplate:
      // Merged when we merge the folding set entry in the primary template.
      if (!AstJavaFixedRTTI.isa_ClassTemplateSpecializationDecl(D)) {
        mergeRedeclarable(D, Redecl);
      }
      break;
     case CXXRecKind.CXXRecTemplate:
      {
        // Merged when we merge the template.
        ClassTemplateDecl /*P*/ Template = this.<ClassTemplateDecl>ReadDeclAs(ClassTemplateDecl.class, Record, Idx);
        D.TemplateOrInstantiation.$assign_T$C$R(ClassTemplateDecl /*P*/ /*const*/ /*&*/.class, Template);
        if (!(Template.getTemplatedDecl() != null)) {
          // We've not actually loaded the ClassTemplateDecl yet, because we're
          // currently being loaded as its pattern. Rely on it to set up our
          // TypeForDecl (see VisitClassTemplateDecl).
          //
          // Beware: we do not yet know our canonical declaration, and may still
          // get merged once the surrounding class template has got off the ground.
          TypeIDForTypeDecl = 0;
        }
        break;
      }
     case CXXRecKind.CXXRecMemberSpecialization:
      {
        CXXRecordDecl /*P*/ RD = this.<CXXRecordDecl>ReadDeclAs(CXXRecordDecl.class, Record, Idx);
        TemplateSpecializationKind TSK = TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        SourceLocation POI = ReadSourceLocation(Record, Idx);
        MemberSpecializationInfo /*P*/ MSI = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
            return new MemberSpecializationInfo(RD, TSK);
         });
        MSI.setPointOfInstantiation(new SourceLocation(POI));
        D.TemplateOrInstantiation.$assign_T1$C$R(MemberSpecializationInfo /*P*/ /*const*/ /*&*/.class, MSI);
        mergeRedeclarable(D, Redecl);
        break;
      }
    }
    
    boolean WasDefinition = (Record.$at$Const(Idx.$set$postInc()) != 0);
    if (WasDefinition) {
      ReadCXXRecordDefinition(D, /*Update*/ false);
    } else {
      // Propagate DefinitionData pointer from the canonical declaration.
      D.DefinitionData = D.getCanonicalDecl().DefinitionData;
    }
    
    // Lazily load the key function to avoid deserializing every method so we can
    // compute it.
    if (WasDefinition) {
      /*uint32_t*/int KeyFn = ReadDeclID(Record, Idx);
      if ((KeyFn != 0) && D.IsCompleteDefinition) {
        // FIXME: This is wrong for the ARM ABI, where some other module may have
        // made this function no longer be a key function. We need an update
        // record or similar for that case.
        C.KeyFunctions.$at_T1$RR(D).$assign(Unsigned.$uint2ulong(KeyFn));
      }
    }
    
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 281,
   FQN="clang::ASTDeclReader::VisitCXXRecordDecl", NM="_ZN5clang13ASTDeclReader18VisitCXXRecordDeclEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18VisitCXXRecordDeclEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public void VisitCXXRecordDecl(CXXRecordDecl /*P*/ D) {
    VisitCXXRecordDeclImpl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitClassTemplateSpecializationDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1970,
   FQN="clang::ASTDeclReader::VisitClassTemplateSpecializationDeclImpl", NM="_ZN5clang13ASTDeclReader40VisitClassTemplateSpecializationDeclImplEPNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader40VisitClassTemplateSpecializationDeclImplEPNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult VisitClassTemplateSpecializationDeclImpl(ClassTemplateSpecializationDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitCXXRecordDeclImpl(D);
    
    final ASTContext /*&*/ C = Reader.getContext();
    {
      Decl /*P*/ InstD = ReadDecl(Record, Idx);
      if ((InstD != null)) {
        {
          ClassTemplateDecl /*P*/ CTD = AstDeclarationsRTTI.dyn_cast_ClassTemplateDecl(InstD);
          if ((CTD != null)) {
            D.SpecializedTemplate.$assign_T$C$R(ClassTemplateDecl /*P*/ /*const*/ /*&*/.class, CTD);
          } else {
            SmallVector<TemplateArgument> TemplArgs/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
            Reader.ReadTemplateArgumentList(TemplArgs, F, Record, Idx);
            TemplateArgumentList /*P*/ ArgList = TemplateArgumentList.CreateCopy(C, new ArrayRef<TemplateArgument>(TemplArgs, false));
            ClassTemplateSpecializationDecl.SpecializedPartialSpecialization /*P*/ PS = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
                return new ClassTemplateSpecializationDecl.SpecializedPartialSpecialization();
             });
            PS.PartialSpecialization
               = AstDeclarationsRTTI.cast_ClassTemplatePartialSpecializationDecl(InstD);
            PS.TemplateArgs = ArgList;
            D.SpecializedTemplate.$assign_T1$C$R(ClassTemplateSpecializationDecl.SpecializedPartialSpecialization /*P*/ /*const*/ /*&*/.class, PS);
          }
        }
      }
    }
    
    SmallVector<TemplateArgument> TemplArgs/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
    Reader.ReadTemplateArgumentList(TemplArgs, F, Record, Idx, 
        /*Canonicalize*/ true);
    D.TemplateArgs = TemplateArgumentList.CreateCopy(C, new ArrayRef<TemplateArgument>(TemplArgs, false));
    D.PointOfInstantiation.$assignMove(ReadSourceLocation(Record, Idx));
    D.SpecializationKind = Unsigned.$uint2uint_3bits(TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue());
    
    boolean writtenAsCanonicalDecl = (Record.$at$Const(Idx.$set$postInc()) != 0);
    if (writtenAsCanonicalDecl) {
      ClassTemplateDecl /*P*/ CanonPattern = this.<ClassTemplateDecl>ReadDeclAs(ClassTemplateDecl.class, Record, Idx);
      if (D.isCanonicalDecl()) { // It's kept in the folding set.
        // Set this as, or find, the canonical declaration for this specialization
        ClassTemplateSpecializationDecl /*P*/ CanonSpec;
        {
          ClassTemplatePartialSpecializationDecl /*P*/ Partial = AstJavaFixedRTTI.dyn_cast_ClassTemplatePartialSpecializationDecl(D);
          if ((Partial != null)) {
            CanonSpec = CanonPattern.getCommonPtr().PartialSpecializations.
                GetOrInsertNode(Partial);
          } else {
            CanonSpec
               = CanonPattern.getCommonPtr().Specializations.GetOrInsertNode(D);
          }
        }
        // If there was already a canonical specialization, merge into it.
        if (CanonSpec != D) {
          this.<TagDecl>mergeRedeclarable(D, CanonSpec, Redecl);
          {
            
            // This declaration might be a definition. Merge with any existing
            // definition.
            CXXRecordDecl.DefinitionData /*P*/ DDD = D.DefinitionData;
            if ((DDD != null)) {
              if ((CanonSpec.DefinitionData != null)) {
                MergeDefinitionData(CanonSpec, std.move(Native.$Deref(DDD)));
              } else {
                CanonSpec.DefinitionData = D.DefinitionData;
              }
            }
          }
          D.DefinitionData = CanonSpec.DefinitionData;
        }
      }
    }
    {
      
      // Explicit info.
      TypeSourceInfo /*P*/ TyInfo = GetTypeSourceInfo(Record, Idx);
      if ((TyInfo != null)) {
        ClassTemplateSpecializationDecl.ExplicitSpecializationInfo /*P*/ ExplicitInfo = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
            return new ClassTemplateSpecializationDecl.ExplicitSpecializationInfo();
         });
        ExplicitInfo.TypeAsWritten = TyInfo;
        ExplicitInfo.ExternLoc.$assignMove(ReadSourceLocation(Record, Idx));
        ExplicitInfo.TemplateKeywordLoc.$assignMove(ReadSourceLocation(Record, Idx));
        D.ExplicitInfo = ExplicitInfo;
      }
    }
    
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 284,
   FQN="clang::ASTDeclReader::VisitClassTemplateSpecializationDecl", NM="_ZN5clang13ASTDeclReader36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public void VisitClassTemplateSpecializationDecl(ClassTemplateSpecializationDecl /*P*/ D) {
    VisitClassTemplateSpecializationDeclImpl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2045,
   FQN="clang::ASTDeclReader::VisitClassTemplatePartialSpecializationDecl", NM="_ZN5clang13ASTDeclReader43VisitClassTemplatePartialSpecializationDeclEPNS_38ClassTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader43VisitClassTemplatePartialSpecializationDeclEPNS_38ClassTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public void VisitClassTemplatePartialSpecializationDecl(ClassTemplatePartialSpecializationDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitClassTemplateSpecializationDeclImpl(D);
    
    D.TemplateParams = Reader.ReadTemplateParameterList(F, Record, Idx);
    D.ArgsAsWritten = Reader.ReadASTTemplateArgumentListInfo(F, Record, Idx);
    
    // These are read/set from/to the first declaration.
    if (ThisDeclID == Redecl.getFirstID()) {
      D.InstantiatedFromMember.setPointer(this.<ClassTemplatePartialSpecializationDecl>ReadDeclAs(ClassTemplatePartialSpecializationDecl.class, Record, Idx));
      D.InstantiatedFromMember.setInt((Record.$at$Const(Idx.$set$postInc()) != 0));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2060,
   FQN="clang::ASTDeclReader::VisitClassScopeFunctionSpecializationDecl", NM="_ZN5clang13ASTDeclReader41VisitClassScopeFunctionSpecializationDeclEPNS_36ClassScopeFunctionSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader41VisitClassScopeFunctionSpecializationDeclEPNS_36ClassScopeFunctionSpecializationDeclE")
  //</editor-fold>
  public void VisitClassScopeFunctionSpecializationDecl(ClassScopeFunctionSpecializationDecl /*P*/ D) {
    VisitDecl(D);
    D.Specialization = this.<CXXMethodDecl>ReadDeclAs(CXXMethodDecl.class, Record, Idx);
  }

  
  /// TODO: Unify with ClassTemplateSpecializationDecl version?
  ///       May require unifying ClassTemplate(Partial)SpecializationDecl and
  ///        VarTemplate(Partial)SpecializationDecl with a new data
  ///        structure Template(Partial)SpecializationDecl, and
  ///        using Template(Partial)SpecializationDecl as input type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitVarTemplateSpecializationDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2087,
   FQN="clang::ASTDeclReader::VisitVarTemplateSpecializationDeclImpl", NM="_ZN5clang13ASTDeclReader38VisitVarTemplateSpecializationDeclImplEPNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader38VisitVarTemplateSpecializationDeclImplEPNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult VisitVarTemplateSpecializationDeclImpl(VarTemplateSpecializationDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitVarDeclImpl(D);
    
    final ASTContext /*&*/ C = Reader.getContext();
    {
      Decl /*P*/ InstD = ReadDecl(Record, Idx);
      if ((InstD != null)) {
        {
          VarTemplateDecl /*P*/ VTD = AstDeclarationsRTTI.dyn_cast_VarTemplateDecl(InstD);
          if ((VTD != null)) {
            D.SpecializedTemplate.$assign_T$C$R(VarTemplateDecl /*P*/ /*const*/ /*&*/.class, VTD);
          } else {
            SmallVector<TemplateArgument> TemplArgs/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
            Reader.ReadTemplateArgumentList(TemplArgs, F, Record, Idx);
            TemplateArgumentList /*P*/ ArgList = TemplateArgumentList.CreateCopy(C, new ArrayRef<TemplateArgument>(TemplArgs, false));
            VarTemplateSpecializationDecl.SpecializedPartialSpecialization /*P*/ PS = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
                return new VarTemplateSpecializationDecl.SpecializedPartialSpecialization();
             });
            PS.PartialSpecialization
               = AstDeclarationsRTTI.cast_VarTemplatePartialSpecializationDecl(InstD);
            PS.TemplateArgs = ArgList;
            D.SpecializedTemplate.$assign_T1$C$R(VarTemplateSpecializationDecl.SpecializedPartialSpecialization /*P*/ /*const*/ /*&*/.class, PS);
          }
        }
      }
    }
    {
      
      // Explicit info.
      TypeSourceInfo /*P*/ TyInfo = GetTypeSourceInfo(Record, Idx);
      if ((TyInfo != null)) {
        VarTemplateSpecializationDecl.ExplicitSpecializationInfo /*P*/ ExplicitInfo = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (C)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
            return new VarTemplateSpecializationDecl.ExplicitSpecializationInfo();
         });
        ExplicitInfo.TypeAsWritten = TyInfo;
        ExplicitInfo.ExternLoc.$assignMove(ReadSourceLocation(Record, Idx));
        ExplicitInfo.TemplateKeywordLoc.$assignMove(ReadSourceLocation(Record, Idx));
        D.ExplicitInfo = ExplicitInfo;
      }
    }
    
    SmallVector<TemplateArgument> TemplArgs/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
    Reader.ReadTemplateArgumentList(TemplArgs, F, Record, Idx, 
        /*Canonicalize*/ true);
    D.TemplateArgs = TemplateArgumentList.CreateCopy(C, new ArrayRef<TemplateArgument>(TemplArgs, false));
    D.PointOfInstantiation.$assignMove(ReadSourceLocation(Record, Idx));
    D.SpecializationKind = Unsigned.$uint2uint_3bits(TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue());
    
    boolean writtenAsCanonicalDecl = (Record.$at$Const(Idx.$set$postInc()) != 0);
    if (writtenAsCanonicalDecl) {
      VarTemplateDecl /*P*/ CanonPattern = this.<VarTemplateDecl>ReadDeclAs(VarTemplateDecl.class, Record, Idx);
      if (D.isCanonicalDecl()) { // It's kept in the folding set.
        {
          // FIXME: If it's already present, merge it.
          VarTemplatePartialSpecializationDecl /*P*/ Partial = AstDeclarationsRTTI.dyn_cast_VarTemplatePartialSpecializationDecl(D);
          if ((Partial != null)) {
            CanonPattern.getCommonPtr().PartialSpecializations.
                GetOrInsertNode(Partial);
          } else {
            CanonPattern.getCommonPtr().Specializations.GetOrInsertNode(D);
          }
        }
      }
    }
    
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 294,
   FQN="clang::ASTDeclReader::VisitVarTemplateSpecializationDecl", NM="_ZN5clang13ASTDeclReader34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public void VisitVarTemplateSpecializationDecl(VarTemplateSpecializationDecl /*P*/ D) {
    VisitVarTemplateSpecializationDeclImpl(D);
  }

  
  /// TODO: Unify with ClassTemplatePartialSpecializationDecl version?
  ///       May require unifying ClassTemplate(Partial)SpecializationDecl and
  ///        VarTemplate(Partial)SpecializationDecl with a new data
  ///        structure Template(Partial)SpecializationDecl, and
  ///        using Template(Partial)SpecializationDecl as input type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitVarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2151,
   FQN="clang::ASTDeclReader::VisitVarTemplatePartialSpecializationDecl", NM="_ZN5clang13ASTDeclReader41VisitVarTemplatePartialSpecializationDeclEPNS_36VarTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader41VisitVarTemplatePartialSpecializationDeclEPNS_36VarTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public void VisitVarTemplatePartialSpecializationDecl(VarTemplatePartialSpecializationDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitVarTemplateSpecializationDeclImpl(D);
    
    D.TemplateParams = Reader.ReadTemplateParameterList(F, Record, Idx);
    D.ArgsAsWritten = Reader.ReadASTTemplateArgumentListInfo(F, Record, Idx);
    
    // These are read/set from/to the first declaration.
    if (ThisDeclID == Redecl.getFirstID()) {
      D.InstantiatedFromMember.setPointer(this.<VarTemplatePartialSpecializationDecl>ReadDeclAs(VarTemplatePartialSpecializationDecl.class, Record, Idx));
      D.InstantiatedFromMember.setInt((Record.$at$Const(Idx.$set$postInc()) != 0));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2166,
   FQN="clang::ASTDeclReader::VisitTemplateTypeParmDecl", NM="_ZN5clang13ASTDeclReader25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE")
  //</editor-fold>
  public void VisitTemplateTypeParmDecl(TemplateTypeParmDecl /*P*/ D) {
    VisitTypeDecl(D);
    
    D.setDeclaredWithTypename((Record.$at$Const(Idx.$set$postInc()) != 0));
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      D.setDefaultArgument(GetTypeSourceInfo(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 730,
   FQN="clang::ASTDeclReader::VisitValueDecl", NM="_ZN5clang13ASTDeclReader14VisitValueDeclEPNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitValueDeclEPNS_9ValueDeclE")
  //</editor-fold>
  public void VisitValueDecl(ValueDecl /*P*/ VD) {
    VisitNamedDecl(VD);
    VD.setType(Reader.readType(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 735,
   FQN="clang::ASTDeclReader::VisitEnumConstantDecl", NM="_ZN5clang13ASTDeclReader21VisitEnumConstantDeclEPNS_16EnumConstantDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21VisitEnumConstantDeclEPNS_16EnumConstantDeclE")
  //</editor-fold>
  public void VisitEnumConstantDecl(EnumConstantDecl /*P*/ ECD) {
    VisitValueDecl(ECD);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      ECD.setInitExpr(Reader.ReadExpr(F));
    }
    ECD.setInitVal(Reader.ReadAPSInt(Record, Idx));
    mergeMergeable(ECD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitUnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1444,
   FQN="clang::ASTDeclReader::VisitUnresolvedUsingValueDecl", NM="_ZN5clang13ASTDeclReader29VisitUnresolvedUsingValueDeclEPNS_24UnresolvedUsingValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader29VisitUnresolvedUsingValueDeclEPNS_24UnresolvedUsingValueDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingValueDecl(UnresolvedUsingValueDecl /*P*/ D) {
    VisitValueDecl(D);
    D.setUsingLoc(ReadSourceLocation(Record, Idx));
    D.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    ReadDeclarationNameLoc(D.DNLoc, D.getDeclName(), Record, Idx);
    mergeMergeable(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitDeclaratorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 743,
   FQN="clang::ASTDeclReader::VisitDeclaratorDecl", NM="_ZN5clang13ASTDeclReader19VisitDeclaratorDeclEPNS_14DeclaratorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19VisitDeclaratorDeclEPNS_14DeclaratorDeclE")
  //</editor-fold>
  public void VisitDeclaratorDecl(DeclaratorDecl /*P*/ DD) {
    VisitValueDecl(DD);
    DD.setInnerLocStart(ReadSourceLocation(Record, Idx));
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // hasExtInfo
      DeclaratorDecl.ExtInfo /*P*/ Info = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Reader.getContext())*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(Reader.getContext(), (type$ptr<?> New$Mem)->{
          return new DeclaratorDecl.ExtInfo();
       });
      ReadQualifierInfo(Native.$Deref(Info), Record, Idx);
      DD.DeclInfo.$assign_T1$C$R(DeclaratorDecl.ExtInfo /*P*/ /*const*/ /*&*/.class, Info);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 754,
   FQN="clang::ASTDeclReader::VisitFunctionDecl", NM="_ZN5clang13ASTDeclReader17VisitFunctionDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17VisitFunctionDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public void VisitFunctionDecl(FunctionDecl /*P*/ FD) {
    RedeclarableResult Redecl = VisitRedeclarable(FD);
    VisitDeclaratorDecl(FD);
    
    ReadDeclarationNameLoc(FD.DNLoc, FD.getDeclName(), Record, Idx);
    FD.IdentifierNamespace_field = Unsigned.$uint2uint_13bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    // FunctionDecl's body is handled last at ASTDeclReader::Visit,
    // after everything else is read.
    FD.SClass = Unsigned.$uint2uint_2bits(StorageClass.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue());
    FD.IsInline = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsInlineSpecified = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsVirtualAsWritten = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsPure = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.HasInheritedPrototype = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.HasWrittenPrototype = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsDeleted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsTrivial = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsDefaulted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsExplicitlyDefaulted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.HasImplicitReturnZero = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsConstexpr = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.HasSkippedBody = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.IsLateTemplateParsed = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    FD.setCachedLinkage(Linkage.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    FD.EndRangeLoc.$assignMove(ReadSourceLocation(Record, Idx));
    switch (FunctionDecl.TemplatedKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()))) {
     case TK_NonTemplate:
      mergeRedeclarable(FD, Redecl);
      break;
     case TK_FunctionTemplate:
      // Merged when we merge the template.
      FD.setDescribedFunctionTemplate(this.<FunctionTemplateDecl>ReadDeclAs(FunctionTemplateDecl.class, Record, 
              Idx));
      break;
     case TK_MemberSpecialization:
      {
        FunctionDecl /*P*/ InstFD = this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, Record, Idx);
        TemplateSpecializationKind TSK = TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        SourceLocation POI = ReadSourceLocation(Record, Idx);
        FD.setInstantiationOfMemberFunction(Reader.getContext(), InstFD, TSK);
        FD.getMemberSpecializationInfo().setPointOfInstantiation(new SourceLocation(POI));
        mergeRedeclarable(FD, Redecl);
        break;
      }
     case TK_FunctionTemplateSpecialization:
      {
        TemplateArgumentListInfo TemplArgsInfo = null;
        try {
          FunctionTemplateDecl /*P*/ Template = this.<FunctionTemplateDecl>ReadDeclAs(FunctionTemplateDecl.class, Record, 
              Idx);
          TemplateSpecializationKind TSK = TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          
          // Template arguments.
          SmallVector<TemplateArgument> TemplArgs/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
          Reader.ReadTemplateArgumentList(TemplArgs, F, Record, Idx, 
              /*Canonicalize*/ true);
          
          // Template args as written.
          SmallVector<TemplateArgumentLoc> TemplArgLocs/*J*/= new SmallVector<TemplateArgumentLoc>(8, new TemplateArgumentLoc());
          SourceLocation LAngleLoc/*J*/= new SourceLocation();
          SourceLocation RAngleLoc/*J*/= new SourceLocation();
          boolean HasTemplateArgumentsAsWritten = (Record.$at$Const(Idx.$set$postInc()) != 0);
          if (HasTemplateArgumentsAsWritten) {
            /*uint*/int NumTemplateArgLocs = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
            TemplArgLocs.reserve(NumTemplateArgLocs);
            for (/*uint*/int i = 0; i != NumTemplateArgLocs; ++i)  {
              TemplArgLocs.push_back(Reader.ReadTemplateArgumentLoc(F, Record, Idx));
            }
            
            LAngleLoc.$assignMove(ReadSourceLocation(Record, Idx));
            RAngleLoc.$assignMove(ReadSourceLocation(Record, Idx));
          }
          
          SourceLocation POI = ReadSourceLocation(Record, Idx);
          
          final ASTContext /*&*/ C = Reader.getContext();
          TemplateArgumentList /*P*/ TemplArgList = TemplateArgumentList.CreateCopy(C, new ArrayRef<TemplateArgument>(TemplArgs, false));
          TemplArgsInfo/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
          for (/*uint*/int i = 0, e = TemplArgLocs.size(); i != e; ++i)  {
            TemplArgsInfo.addArgument(TemplArgLocs.$at(i));
          }
          FunctionTemplateSpecializationInfo /*P*/ FTInfo = FunctionTemplateSpecializationInfo.Create(C, FD, Template, TSK, 
              TemplArgList, 
              HasTemplateArgumentsAsWritten ? Native.$AddrOf(TemplArgsInfo) : (TemplateArgumentListInfo /*P*/ )null,
              new SourceLocation(POI));
          FD.TemplateOrSpecialization.$assign_T2$C$R(FunctionTemplateSpecializationInfo /*P*/ /*const*/ /*&*/.class, FTInfo);
          if (FD.isCanonicalDecl()) { // if canonical add to template's set.
            // The template that contains the specializations set. It's not safe to
            // use getCanonicalDecl on Template since it may still be initializing.
            FunctionTemplateDecl /*P*/ CanonTemplate = this.<FunctionTemplateDecl>ReadDeclAs(FunctionTemplateDecl.class, Record, Idx);
            // Get the InsertPos by FindNodeOrInsertPos() instead of calling
            // InsertNode(FTInfo) directly to avoid the getASTContext() call in
            // FunctionTemplateSpecializationInfo's Profile().
            // We avoid getASTContext because a decl in the parent hierarchy may
            // be initializing.
            FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
            FunctionTemplateSpecializationInfo.Profile(ID, new ArrayRef<TemplateArgument>(TemplArgs, false), C);
            type$ref<type$ptr<FunctionTemplateSpecializationInfo/*void P*/ >> InsertPos = NativePointer.create_type$null$ref(null);
            FunctionTemplateDecl.Common /*P*/ CommonPtr = CanonTemplate.getCommonPtr();
            FunctionTemplateSpecializationInfo /*P*/ ExistingInfo = CommonPtr.Specializations.FindNodeOrInsertPos(ID, InsertPos);
            if ((InsertPos.$deref() != null)) {
              CommonPtr.Specializations.InsertNode(FTInfo, InsertPos.$deref());
            } else {
              assert (Reader.getContext().getLangOpts().Modules) : "already deserialized this template specialization";
              mergeRedeclarable(FD, ExistingInfo.Function, Redecl);
            }
          }
          break;
        } finally {
          if (TemplArgsInfo != null) { TemplArgsInfo.$destroy(); }
        }
      }
     case TK_DependentFunctionTemplateSpecialization:
      {
        TemplateArgumentListInfo TemplArgs = null;
        try {
          // Templates.
          UnresolvedSet TemplDecls/*J*/= new UnresolvedSet(8);
          /*uint*/int NumTemplates = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          while (((NumTemplates--) != 0)) {
            TemplDecls.addDecl(this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx));
          }
          
          // Templates args.
          TemplArgs/*J*/= new TemplateArgumentListInfo();
          /*uint*/int NumArgs = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          while (((NumArgs--) != 0)) {
            TemplArgs.addArgument(Reader.ReadTemplateArgumentLoc(F, Record, Idx));
          }
          TemplArgs.setLAngleLoc(ReadSourceLocation(Record, Idx));
          TemplArgs.setRAngleLoc(ReadSourceLocation(Record, Idx));
          
          FD.setDependentTemplateSpecialization(Reader.getContext(), 
              TemplDecls, TemplArgs);
          // These are not merged; we don't need to merge redeclarations of dependent
          // template friends.
          break;
        } finally {
          if (TemplArgs != null) { TemplArgs.$destroy(); }
        }
      }
    }
    
    // Read in the parameters.
    /*uint*/int NumParams = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
    Params.reserve(NumParams);
    for (/*uint*/int I = 0; I != NumParams; ++I)  {
      Params.push_back(this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx));
    }
    FD.setParams(Reader.getContext(), new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1763,
   FQN="clang::ASTDeclReader::VisitCXXMethodDecl", NM="_ZN5clang13ASTDeclReader18VisitCXXMethodDeclEPNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader18VisitCXXMethodDeclEPNS_13CXXMethodDeclE")
  //</editor-fold>
  public void VisitCXXMethodDecl(CXXMethodDecl /*P*/ D) {
    VisitFunctionDecl(D);
    
    /*uint*/int NumOverridenMethods = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if (D.isCanonicalDecl()) {
      while (((NumOverridenMethods--) != 0)) {
        {
          // Avoid invariant checking of CXXMethodDecl::addOverriddenMethod,
          // MD may be initializing.
          CXXMethodDecl /*P*/ MD = this.<CXXMethodDecl>ReadDeclAs(CXXMethodDecl.class, Record, Idx);
          if ((MD != null)) {
            Reader.getContext().addOverriddenMethod(D, MD.getCanonicalDecl());
          }
        }
      }
    } else {
      // We don't care about which declarations this used to override; we get
      // the relevant information from the canonical declaration.
      Idx.$set$addassign(NumOverridenMethods);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCXXConstructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1781,
   FQN="clang::ASTDeclReader::VisitCXXConstructorDecl", NM="_ZN5clang13ASTDeclReader23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public void VisitCXXConstructorDecl(CXXConstructorDecl /*P*/ D) {
    // We need the inherited constructor information to merge the declaration,
    // so we have to read it before we call VisitCXXMethodDecl.
    if (D.isInheritingConstructor()) {
      ConstructorUsingShadowDecl /*P*/ Shadow = this.<ConstructorUsingShadowDecl>ReadDeclAs(ConstructorUsingShadowDecl.class, Record, Idx);
      CXXConstructorDecl /*P*/ Ctor = this.<CXXConstructorDecl>ReadDeclAs(CXXConstructorDecl.class, Record, Idx);
      Native.$Deref(D.getTrailingObjects(InheritedConstructor.class)).$assignMove(
          new InheritedConstructor(Shadow, Ctor)
      );
    }
    
    VisitCXXMethodDecl(D);
    
    D.IsExplicitSpecified = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCXXDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1796,
   FQN="clang::ASTDeclReader::VisitCXXDestructorDecl", NM="_ZN5clang13ASTDeclReader22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE")
  //</editor-fold>
  public void VisitCXXDestructorDecl(CXXDestructorDecl /*P*/ D) {
    VisitCXXMethodDecl(D);
    {
      
      FunctionDecl /*P*/ OperatorDelete = this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, Record, Idx);
      if ((OperatorDelete != null)) {
        CXXDestructorDecl /*P*/ Canon = AstJavaFixedRTTI.cast_CXXDestructorDecl(D.getCanonicalDecl());
        // FIXME: Check consistency if we have an old and new operator delete.
        if (!(Canon.OperatorDelete != null)) {
          Canon.OperatorDelete = OperatorDelete;
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCXXConversionDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1807,
   FQN="clang::ASTDeclReader::VisitCXXConversionDecl", NM="_ZN5clang13ASTDeclReader22VisitCXXConversionDeclEPNS_17CXXConversionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitCXXConversionDeclEPNS_17CXXConversionDeclE")
  //</editor-fold>
  public void VisitCXXConversionDecl(CXXConversionDecl /*P*/ D) {
    VisitCXXMethodDecl(D);
    D.IsExplicitSpecified = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1169,
   FQN="clang::ASTDeclReader::VisitFieldDecl", NM="_ZN5clang13ASTDeclReader14VisitFieldDeclEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitFieldDeclEPNS_9FieldDeclE")
  //</editor-fold>
  public void VisitFieldDecl(FieldDecl /*P*/ FD) {
    VisitDeclaratorDecl(FD);
    FD.Mutable = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    {
      int BitWidthOrInitializer = Unsigned.$ullong2int(Record.$at$Const(Idx.$set$postInc()));
      if ((BitWidthOrInitializer != 0)) {
        FD.InitStorage.setInt(/*static_cast*/FieldDecl.InitStorageKind.valueOf(BitWidthOrInitializer - 1));
        if (FD.InitStorage.getInt() == FieldDecl.InitStorageKind.ISK_CapturedVLAType) {
          // Read captured variable length array.
          FD.InitStorage.setPointer(Reader.readType(F, Record, Idx).getAsOpaquePtr());
        } else {
          FD.InitStorage.setPointer(Reader.ReadExpr(F));
        }
      }
    }
    if (!FD.getDeclName().$bool()) {
      {
        FieldDecl /*P*/ Tmpl = this.<FieldDecl>ReadDeclAs(FieldDecl.class, Record, Idx);
        if ((Tmpl != null)) {
          Reader.getContext().setInstantiatedFromUnnamedFieldDecl(FD, Tmpl);
        }
      }
    }
    mergeMergeable(FD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitMSPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1190,
   FQN="clang::ASTDeclReader::VisitMSPropertyDecl", NM="_ZN5clang13ASTDeclReader19VisitMSPropertyDeclEPNS_14MSPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19VisitMSPropertyDeclEPNS_14MSPropertyDeclE")
  //</editor-fold>
  public void VisitMSPropertyDecl(MSPropertyDecl /*P*/ PD) {
    VisitDeclaratorDecl(PD);
    PD.GetterId = Reader.GetIdentifierInfo(F, Record, Idx);
    PD.SetterId = Reader.GetIdentifierInfo(F, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitIndirectFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1196,
   FQN="clang::ASTDeclReader::VisitIndirectFieldDecl", NM="_ZN5clang13ASTDeclReader22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE")
  //</editor-fold>
  public void VisitIndirectFieldDecl(IndirectFieldDecl /*P*/ FD) {
    VisitValueDecl(FD);
    
    FD.ChainingSize = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (Unsigned.$greatereq_uint(FD.ChainingSize, 2)) : "Anonymous chaining must be >= 2";
    FD.Chaining = NativePointer.create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Reader.getContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new NamedDecl /*P*/ [FD.ChainingSize]);
    
    for (/*uint*/int I = 0; I != FD.ChainingSize; ++I)  {
      FD.Chaining.$set(I, this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx));
    }
    
    mergeMergeable(FD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitVarDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1209,
   FQN="clang::ASTDeclReader::VisitVarDeclImpl", NM="_ZN5clang13ASTDeclReader16VisitVarDeclImplEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader16VisitVarDeclImplEPNS_7VarDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult VisitVarDeclImpl(VarDecl /*P*/ VD) {
    RedeclarableResult Redecl = VisitRedeclarable(VD);
    VisitDeclaratorDecl(VD);
    
    VD.Unnamed_field1.VarDeclBits.SClass = Unsigned.$uint2uint_3bits(StorageClass.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue());
    VD.Unnamed_field1.VarDeclBits.TSCSpec = Unsigned.$uint2uint_2bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    VD.Unnamed_field1.VarDeclBits.InitStyle = Unsigned.$uint2uint_2bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    if (!AstDeclarationsRTTI.isa_ParmVarDecl(VD)) {
      VD.Unnamed_field1.NonParmVarDeclBits.ExceptionVar = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.NRVOVariable = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.CXXForRangeDecl = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.ARCPseudoStrong = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.IsInline = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.IsInlineSpecified = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.IsConstexpr = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.IsInitCapture = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      VD.Unnamed_field1.NonParmVarDeclBits.PreviousDeclInSameBlockScope = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    Linkage VarLinkage = Linkage.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    VD.setCachedLinkage(VarLinkage);
    
    // Reconstruct the one piece of the IdentifierNamespace that we need.
    if (VD.getStorageClass() == StorageClass.SC_Extern && VarLinkage != Linkage.NoLinkage
       && VD.getLexicalDeclContext().isFunctionOrMethod()) {
      VD.setLocalExternDecl();
    }
    {
      
      long/*uint64_t*/ Val = Record.$at$Const(Idx.$set$postInc());
      if ((Val != 0)) {
        VD.setInit(Reader.ReadExpr(F));
        if (Unsigned.$greater_ulong_ullong(Val, Unsigned.$int2ullong(1))) {
          EvaluatedStmt /*P*/ Eval = VD.ensureEvaluatedStmt();
          Eval.CheckedICE = true;
          Eval.IsICE = Val == Unsigned.$int2ullong(3);
        }
      }
    }
    
    final class/*enum*/ VarKind {
      private static final /*uint*/int VarNotTemplate = 0;
      private static final /*uint*/int VarTemplate = VarNotTemplate + 1;
      private static final /*uint*/int StaticDataMemberSpecialization = VarTemplate + 1;
    };
    switch ((/*VarKind*//*uint*/int)Record.$at$Const(Idx.$set$postInc())) {
     case VarKind.VarNotTemplate:
      // Only true variables (not parameters or implicit parameters) can be
      // merged; the other kinds are not really redeclarable at all.
      if (!AstDeclarationsRTTI.isa_ParmVarDecl(VD) && !AstDeclarationsRTTI.isa_ImplicitParamDecl(VD)
         && !AstDeclarationsRTTI.isa_VarTemplateSpecializationDecl(VD)) {
        mergeRedeclarable(VD, Redecl);
      }
      break;
     case VarKind.VarTemplate:
      // Merged when we merge the template.
      VD.setDescribedVarTemplate(this.<VarTemplateDecl>ReadDeclAs(VarTemplateDecl.class, Record, Idx));
      break;
     case VarKind.StaticDataMemberSpecialization:
      { // HasMemberSpecializationInfo.
        VarDecl /*P*/ Tmpl = this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx);
        TemplateSpecializationKind TSK = TemplateSpecializationKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        SourceLocation POI = ReadSourceLocation(Record, Idx);
        Reader.getContext().setInstantiatedFromStaticDataMember(VD, Tmpl, TSK, new SourceLocation(POI));
        mergeRedeclarable(VD, Redecl);
        break;
      }
    }
    
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 313,
   FQN="clang::ASTDeclReader::VisitVarDecl", NM="_ZN5clang13ASTDeclReader12VisitVarDeclEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader12VisitVarDeclEPNS_7VarDeclE")
  //</editor-fold>
  public void VisitVarDecl(VarDecl /*P*/ VD) {
    VisitVarDeclImpl(VD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitImplicitParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1272,
   FQN="clang::ASTDeclReader::VisitImplicitParamDecl", NM="_ZN5clang13ASTDeclReader22VisitImplicitParamDeclEPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitImplicitParamDeclEPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public void VisitImplicitParamDecl(ImplicitParamDecl /*P*/ PD) {
    VisitVarDecl(PD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1276,
   FQN="clang::ASTDeclReader::VisitParmVarDecl", NM="_ZN5clang13ASTDeclReader16VisitParmVarDeclEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader16VisitParmVarDeclEPNS_11ParmVarDeclE")
  //</editor-fold>
  public void VisitParmVarDecl(ParmVarDecl /*P*/ PD) {
    VisitVarDecl(PD);
    /*uint*/int isObjCMethodParam = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    /*uint*/int scopeDepth = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    /*uint*/int scopeIndex = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    /*uint*/int declQualifier = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if ((isObjCMethodParam != 0)) {
      assert (scopeDepth == 0);
      PD.setObjCMethodScopeInfo(scopeIndex);
      PD.Unnamed_field1.ParmVarDeclBits.ScopeDepthOrObjCQuals = Unsigned.$uint2uint_7bits(declQualifier);
    } else {
      PD.setScopeInfo(scopeDepth, scopeIndex);
    }
    PD.Unnamed_field1.ParmVarDeclBits.IsKNRPromoted = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    PD.Unnamed_field1.ParmVarDeclBits.HasInheritedDefaultArg = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // hasUninstantiatedDefaultArg.
      PD.setUninstantiatedDefaultArg(Reader.ReadExpr(F));
    }
    // FIXME: If this is a redeclaration of a function from another module, handle
    // inheritance of default arguments.
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitNonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2175,
   FQN="clang::ASTDeclReader::VisitNonTypeTemplateParmDecl", NM="_ZN5clang13ASTDeclReader28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE")
  //</editor-fold>
  public void VisitNonTypeTemplateParmDecl(NonTypeTemplateParmDecl /*P*/ D) {
    VisitDeclaratorDecl(D);
    // TemplateParmPosition.
    D.setDepth(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    D.setPosition(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    if (D.isExpandedParameterPack()) {
      type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ > /*P*/> TypesAndInfos = (type$ptr)D.getTrailingObjects(std.pairTypePtr.class);
      for (/*uint*/int I = 0, N = D.getNumExpansionTypes(); I != N; ++I) {
        /*NEW_EXPR [System]$AddrOf(*/TypesAndInfos.$at(I).first/*)*/ = /*new (&TypesAndInfos[I].first)*/ Native.$new_uint_voidPtr(Native.$AddrOf(TypesAndInfos.$at(I).first), (type$ptr<?> New$Mem)->{
            return Reader.readType(F, Record, Idx);
         });
        TypesAndInfos.$at(I).second = GetTypeSourceInfo(Record, Idx);
      }
    } else {
      // Rest of NonTypeTemplateParmDecl.
      D.ParameterPack = (Record.$at$Const(Idx.$set$postInc()) != 0);
      if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
        D.setDefaultArgument(Reader.ReadExpr(F));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1855,
   FQN="clang::ASTDeclReader::VisitTemplateDecl", NM="_ZN5clang13ASTDeclReader17VisitTemplateDeclEPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17VisitTemplateDeclEPNS_12TemplateDeclE")
  //</editor-fold>
  public /*uint32_t*/int ASTDeclReader$VisitTemplateDecl(TemplateDecl /*P*/ D) {
    VisitNamedDecl(D);
    
    /*uint32_t*/int PatternID = ReadDeclID(Record, Idx);
    NamedDecl /*P*/ TemplatedDecl = AstDeclarationsRTTI.cast_or_null_NamedDecl(Reader.GetDecl(PatternID));
    TemplateParameterList /*P*/ TemplateParams = Reader.ReadTemplateParameterList(F, Record, Idx);
    D.init(TemplatedDecl, TemplateParams);
    
    return PatternID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitRedeclarableTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1867,
   FQN="clang::ASTDeclReader::VisitRedeclarableTemplateDecl", NM="_ZN5clang13ASTDeclReader29VisitRedeclarableTemplateDeclEPNS_24RedeclarableTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader29VisitRedeclarableTemplateDeclEPNS_24RedeclarableTemplateDeclE")
  //</editor-fold>
  public ASTDeclReader.RedeclarableResult ASTDeclReader$VisitRedeclarableTemplateDecl(RedeclarableTemplateDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitRedeclarable(D);
    
    // Make sure we've allocated the Common pointer first. We do this before
    // VisitTemplateDecl so that getCommonPtr() can be used during initialization.
    RedeclarableTemplateDecl /*P*/ CanonD = D.getCanonicalDecl();
    if (!(CanonD.Common != null)) {
      CanonD.Common = CanonD.newCommon(Reader.getContext());
      Reader.PendingDefinitions.insert(CanonD);
    }
    D.Common = CanonD.Common;
    
    // If this is the first declaration of the template, fill in the information
    // for the 'common' pointer.
    if (ThisDeclID == Redecl.getFirstID()) {
      {
        RedeclarableTemplateDecl /*P*/ RTD = this.<RedeclarableTemplateDecl>ReadDeclAs(RedeclarableTemplateDecl.class, Record, Idx);
        if ((RTD != null)) {
          assert (RTD.getKind() == D.getKind()) : "InstantiatedFromMemberTemplate kind mismatch";
          D.setInstantiatedFromMemberTemplate(RTD);
          if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
            D.setMemberSpecialization();
          }
        }
      }
    }
    
    /*uint32_t*/int PatternID = ASTDeclReader$VisitTemplateDecl(D);
    D.IdentifierNamespace_field = Unsigned.$uint2uint_13bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    mergeRedeclarable(D, Redecl, PatternID);
    
    // If we merged the template with a prior declaration chain, merge the common
    // pointer.
    // FIXME: Actually merge here, don't just overwrite.
    D.Common = D.getCanonicalDecl().Common;
    
    return Redecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1921,
   FQN="clang::ASTDeclReader::VisitClassTemplateDecl", NM="_ZN5clang13ASTDeclReader22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE")
  //</editor-fold>
  public void VisitClassTemplateDecl(ClassTemplateDecl /*P*/ D) {
    RedeclarableResult Redecl = ASTDeclReader$VisitRedeclarableTemplateDecl(D);
    if (ThisDeclID == Redecl.getFirstID()) {
      // This ClassTemplateDecl owns a CommonPtr; read it to keep track of all of
      // the specializations.
      SmallVectorUInt SpecIDs/*J*/= new SmallVectorUInt(32, (/*uint32_t*/int)0);
      ReadDeclIDList(SpecIDs);
      if (!SpecIDs.empty()) {
        ClassTemplateDecl.Common /*P*/ CommonPtr = D.getCommonPtr();
        CommonPtr.LazySpecializations = $tryClone(newDeclIDList(Reader.getContext(), CommonPtr.LazySpecializations, SpecIDs));
      }
    }
    if (D.getTemplatedDecl().TemplateOrInstantiation.$bool()) {
      // We were loaded before our templated declaration was. We've not set up
      // its corresponding type yet (see VisitCXXRecordDeclImpl), so reconstruct
      // it now.
      Reader.Context.getInjectedClassNameType(D.getTemplatedDecl(), D.getInjectedClassNameSpecialization());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitBuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1946,
   FQN="clang::ASTDeclReader::VisitBuiltinTemplateDecl", NM="_ZN5clang13ASTDeclReader24VisitBuiltinTemplateDeclEPNS_19BuiltinTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader24VisitBuiltinTemplateDeclEPNS_19BuiltinTemplateDeclE")
  //</editor-fold>
  public void VisitBuiltinTemplateDecl(BuiltinTemplateDecl /*P*/ D) {
    throw new llvm_unreachable("BuiltinTemplates are not serialized");
  }

  
  /// TODO: Unify with ClassTemplateDecl version?
  ///       May require unifying ClassTemplateDecl and
  ///        VarTemplateDecl beyond TemplateDecl...
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitVarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1953,
   FQN="clang::ASTDeclReader::VisitVarTemplateDecl", NM="_ZN5clang13ASTDeclReader20VisitVarTemplateDeclEPNS_15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20VisitVarTemplateDeclEPNS_15VarTemplateDeclE")
  //</editor-fold>
  public void VisitVarTemplateDecl(VarTemplateDecl /*P*/ D) {
    RedeclarableResult Redecl = ASTDeclReader$VisitRedeclarableTemplateDecl(D);
    if (ThisDeclID == Redecl.getFirstID()) {
      // This VarTemplateDecl owns a CommonPtr; read it to keep track of all of
      // the specializations.
      SmallVectorUInt SpecIDs/*J*/= new SmallVectorUInt(32, (/*uint32_t*/int)0);
      ReadDeclIDList(SpecIDs);
      if (!SpecIDs.empty()) {
        VarTemplateDecl.Common /*P*/ CommonPtr = D.getCommonPtr();
        CommonPtr.LazySpecializations = $tryClone(newDeclIDList(Reader.getContext(), CommonPtr.LazySpecializations, SpecIDs));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2066,
   FQN="clang::ASTDeclReader::VisitFunctionTemplateDecl", NM="_ZN5clang13ASTDeclReader25VisitFunctionTemplateDeclEPNS_20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader25VisitFunctionTemplateDeclEPNS_20FunctionTemplateDeclE")
  //</editor-fold>
  public void VisitFunctionTemplateDecl(FunctionTemplateDecl /*P*/ D) {
    RedeclarableResult Redecl = ASTDeclReader$VisitRedeclarableTemplateDecl(D);
    if (ThisDeclID == Redecl.getFirstID()) {
      // This FunctionTemplateDecl owns a CommonPtr; read it.
      SmallVectorUInt SpecIDs/*J*/= new SmallVectorUInt(32, (/*uint32_t*/int)0);
      ReadDeclIDList(SpecIDs);
      if (!SpecIDs.empty()) {
        FunctionTemplateDecl.Common /*P*/ CommonPtr = D.getCommonPtr();
        CommonPtr.LazySpecializations = $tryClone(newDeclIDList(Reader.getContext(), CommonPtr.LazySpecializations, SpecIDs));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2195,
   FQN="clang::ASTDeclReader::VisitTemplateTemplateParmDecl", NM="_ZN5clang13ASTDeclReader29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE")
  //</editor-fold>
  public void VisitTemplateTemplateParmDecl(TemplateTemplateParmDecl /*P*/ D) {
    ASTDeclReader$VisitTemplateDecl(D);
    // TemplateParmPosition.
    D.setDepth(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    D.setPosition(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    if (D.isExpandedParameterPack()) {
      type$ptr<TemplateParameterList /*P*/ /*P*/> Data = Native.$tryClone(D.getTrailingObjects(TemplateParameterList /*P*/.class));
      for (/*uint*/int I = 0, N = D.getNumExpansionTemplateParameters();
           I != N; ++I)  {
        Data.$set(I, Reader.ReadTemplateParameterList(F, Record, Idx));
      }
    } else {
      // Rest of TemplateTemplateParmDecl.
      D.ParameterPack = (Record.$at$Const(Idx.$set$postInc()) != 0);
      if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
        D.setDefaultArgument(Reader.getContext(), 
            Reader.ReadTemplateArgumentLoc(F, Record, Idx));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitTypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2215,
   FQN="clang::ASTDeclReader::VisitTypeAliasTemplateDecl", NM="_ZN5clang13ASTDeclReader26VisitTypeAliasTemplateDeclEPNS_21TypeAliasTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader26VisitTypeAliasTemplateDeclEPNS_21TypeAliasTemplateDeclE")
  //</editor-fold>
  public void VisitTypeAliasTemplateDecl(TypeAliasTemplateDecl /*P*/ D) {
    ASTDeclReader$VisitRedeclarableTemplateDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1402,
   FQN="clang::ASTDeclReader::VisitUsingDecl", NM="_ZN5clang13ASTDeclReader14VisitUsingDeclEPNS_9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitUsingDeclEPNS_9UsingDeclE")
  //</editor-fold>
  public void VisitUsingDecl(UsingDecl /*P*/ D) {
    VisitNamedDecl(D);
    D.setUsingLoc(ReadSourceLocation(Record, Idx));
    D.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    ReadDeclarationNameLoc(D.DNLoc, D.getDeclName(), Record, Idx);
    D.FirstUsingShadow.setPointer(this.<UsingShadowDecl>ReadDeclAs(UsingShadowDecl.class, Record, Idx));
    D.setTypename((Record.$at$Const(Idx.$set$postInc()) != 0));
    {
      NamedDecl /*P*/ Pattern = this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx);
      if ((Pattern != null)) {
        Reader.getContext().setInstantiatedFromUsingDecl(D, Pattern);
      }
    }
    mergeMergeable(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1414,
   FQN="clang::ASTDeclReader::VisitUsingShadowDecl", NM="_ZN5clang13ASTDeclReader20VisitUsingShadowDeclEPNS_15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20VisitUsingShadowDeclEPNS_15UsingShadowDeclE")
  //</editor-fold>
  public void VisitUsingShadowDecl(UsingShadowDecl /*P*/ D) {
    RedeclarableResult Redecl = VisitRedeclarable(D);
    VisitNamedDecl(D);
    D.setTargetDecl(this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx));
    D.UsingOrNextShadow = this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx);
    UsingShadowDecl /*P*/ Pattern = this.<UsingShadowDecl>ReadDeclAs(UsingShadowDecl.class, Record, Idx);
    if ((Pattern != null)) {
      Reader.getContext().setInstantiatedFromUsingShadowDecl(D, Pattern);
    }
    mergeRedeclarable(D, Redecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1425,
   FQN="clang::ASTDeclReader::VisitConstructorUsingShadowDecl", NM="_ZN5clang13ASTDeclReader31VisitConstructorUsingShadowDeclEPNS_26ConstructorUsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader31VisitConstructorUsingShadowDeclEPNS_26ConstructorUsingShadowDeclE")
  //</editor-fold>
  public void VisitConstructorUsingShadowDecl(ConstructorUsingShadowDecl /*P*/ D) {
    VisitUsingShadowDecl(D);
    D.NominatedBaseClassShadowDecl
       = this.<ConstructorUsingShadowDecl>ReadDeclAs(ConstructorUsingShadowDecl.class, Record, Idx);
    D.ConstructedBaseClassShadowDecl
       = this.<ConstructorUsingShadowDecl>ReadDeclAs(ConstructorUsingShadowDecl.class, Record, Idx);
    D.IsVirtual = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitLinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1348,
   FQN="clang::ASTDeclReader::VisitLinkageSpecDecl", NM="_ZN5clang13ASTDeclReader20VisitLinkageSpecDeclEPNS_15LinkageSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20VisitLinkageSpecDeclEPNS_15LinkageSpecDeclE")
  //</editor-fold>
  public void VisitLinkageSpecDecl(LinkageSpecDecl /*P*/ D) {
    VisitDecl(D);
    D.setLanguage((/*LinkageSpecDecl::LanguageIDs*//*uint*/int)Record.$at$Const(Idx.$set$postInc()));
    D.setExternLoc(ReadSourceLocation(Record, Idx));
    D.setRBraceLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitFileScopeAsmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1298,
   FQN="clang::ASTDeclReader::VisitFileScopeAsmDecl", NM="_ZN5clang13ASTDeclReader21VisitFileScopeAsmDeclEPNS_16FileScopeAsmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21VisitFileScopeAsmDeclEPNS_16FileScopeAsmDeclE")
  //</editor-fold>
  public void VisitFileScopeAsmDecl(FileScopeAsmDecl /*P*/ AD) {
    VisitDecl(AD);
    AD.setAsmString(AstRTTI.cast_StringLiteral(Reader.ReadExpr(F)));
    AD.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitImportDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1812,
   FQN="clang::ASTDeclReader::VisitImportDecl", NM="_ZN5clang13ASTDeclReader15VisitImportDeclEPNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader15VisitImportDeclEPNS_10ImportDeclE")
  //</editor-fold>
  public void VisitImportDecl(ImportDecl /*P*/ D) {
    VisitDecl(D);
    D.ImportedAndComplete.setPointer(readModule(Record, Idx));
    D.ImportedAndComplete.setInt((Record.$at$Const(Idx.$set$postInc()) != 0));
    type$ptr<SourceLocation /*P*/> StoredLocs = D.getTrailingObjects(SourceLocation.class);
    for (/*uint*/int I = 0, N = Unsigned.$ullong2uint(Record.back$Const()); I != N; ++I)  {
      StoredLocs.$at(I).$assignMove(ReadSourceLocation(Record, Idx));
    }
    Idx.$set$preInc(); // The number of stored source locations.
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitAccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1822,
   FQN="clang::ASTDeclReader::VisitAccessSpecDecl", NM="_ZN5clang13ASTDeclReader19VisitAccessSpecDeclEPNS_14AccessSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19VisitAccessSpecDeclEPNS_14AccessSpecDeclE")
  //</editor-fold>
  public void VisitAccessSpecDecl(AccessSpecDecl /*P*/ D) {
    VisitDecl(D);
    D.setColonLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1827,
   FQN="clang::ASTDeclReader::VisitFriendDecl", NM="_ZN5clang13ASTDeclReader15VisitFriendDeclEPNS_10FriendDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader15VisitFriendDeclEPNS_10FriendDeclE")
  //</editor-fold>
  public void VisitFriendDecl(FriendDecl /*P*/ D) {
    VisitDecl(D);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // hasFriendDecl
      D.Friend.$assign_T$C$R(NamedDecl /*P*/ /*const*/ /*&*/.class, this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx));
    } else {
      D.Friend.$assign_T1$C$R(TypeSourceInfo /*P*/ /*const*/ /*&*/.class, GetTypeSourceInfo(Record, Idx));
    }
    for (/*uint*/int i = 0; i != D.NumTPLists; ++i)  {
      D.getTrailingObjects(TemplateParameterList /*P*/.class).$set(i, 
        Reader.ReadTemplateParameterList(F, Record, Idx));
    }
    D.NextFriend.$assign(Unsigned.$uint2ulong(ReadDeclID(Record, Idx)));
    D.UnsupportedFriend = (Record.$at$Const(Idx.$set$postInc()) != Unsigned.$int2ullong(0));
    D.FriendLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitFriendTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1841,
   FQN="clang::ASTDeclReader::VisitFriendTemplateDecl", NM="_ZN5clang13ASTDeclReader23VisitFriendTemplateDeclEPNS_18FriendTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader23VisitFriendTemplateDeclEPNS_18FriendTemplateDeclE")
  //</editor-fold>
  public void VisitFriendTemplateDecl(FriendTemplateDecl /*P*/ D) {
    VisitDecl(D);
    /*uint*/int NumParams = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    D.NumParams = NumParams;
    D.Params = NativePointer.create_const_type$ptr(new TemplateParameterList /*P*/ [NumParams]);
    for (/*uint*/int i = 0; i != NumParams; ++i)  {
      D.Params.$set(i, Reader.ReadTemplateParameterList(F, Record, Idx));
    }
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // HasFriendDecl
      D.Friend.$assign_T$C$R(NamedDecl /*P*/ /*const*/ /*&*/.class, this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx));
    } else {
      D.Friend.$assign_T1$C$R(TypeSourceInfo /*P*/ /*const*/ /*&*/.class, GetTypeSourceInfo(Record, Idx));
    }
    D.FriendLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitStaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2219,
   FQN="clang::ASTDeclReader::VisitStaticAssertDecl", NM="_ZN5clang13ASTDeclReader21VisitStaticAssertDeclEPNS_16StaticAssertDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21VisitStaticAssertDeclEPNS_16StaticAssertDeclE")
  //</editor-fold>
  public void VisitStaticAssertDecl(StaticAssertDecl /*P*/ D) {
    VisitDecl(D);
    D.AssertExprAndFailed.setPointer(Reader.ReadExpr(F));
    D.AssertExprAndFailed.setInt((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.Message = AstRTTI.cast_StringLiteral(Reader.ReadExpr(F));
    D.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1304,
   FQN="clang::ASTDeclReader::VisitBlockDecl", NM="_ZN5clang13ASTDeclReader14VisitBlockDeclEPNS_9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitBlockDeclEPNS_9BlockDeclE")
  //</editor-fold>
  public void VisitBlockDecl(BlockDecl /*P*/ BD) {
    VisitDecl(BD);
    BD.setBody(AstStatementsRTTI.cast_or_null_CompoundStmt(Reader.ReadStmt(F)));
    BD.setSignatureAsWritten(GetTypeSourceInfo(Record, Idx));
    /*uint*/int NumParams = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
    Params.reserve(NumParams);
    for (/*uint*/int I = 0; I != NumParams; ++I)  {
      Params.push_back(this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx));
    }
    BD.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
    
    BD.setIsVariadic((Record.$at$Const(Idx.$set$postInc()) != 0));
    BD.setBlockMissingReturnType((Record.$at$Const(Idx.$set$postInc()) != 0));
    BD.setIsConversionFromLambda((Record.$at$Const(Idx.$set$postInc()) != 0));
    
    boolean capturesCXXThis = (Record.$at$Const(Idx.$set$postInc()) != 0);
    /*uint*/int numCaptures = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<BlockDecl.Capture> captures/*J*/= new SmallVector<BlockDecl.Capture>(16, new BlockDecl.Capture());
    captures.reserve(numCaptures);
    for (/*uint*/int i = 0; i != numCaptures; ++i) {
      VarDecl /*P*/ decl = this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx);
      /*uint*/int flags = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      boolean byRef = ((flags & 1) != 0);
      boolean nested = ((flags & 2) != 0);
      Expr /*P*/ copyExpr = (((flags & 4) != 0) ? Reader.ReadExpr(F) : null);
      
      captures.push_back(new BlockDecl.Capture(decl, byRef, nested, copyExpr));
    }
    BD.setCaptures(Reader.getContext(), new ArrayRef<BlockDecl.Capture>(captures, false), capturesCXXThis);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1335,
   FQN="clang::ASTDeclReader::VisitCapturedDecl", NM="_ZN5clang13ASTDeclReader17VisitCapturedDeclEPNS_12CapturedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17VisitCapturedDeclEPNS_12CapturedDeclE")
  //</editor-fold>
  public void VisitCapturedDecl(CapturedDecl /*P*/ CD) {
    VisitDecl(CD);
    /*uint*/int ContextParamPos = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    CD.setNothrow(Record.$at$Const(Idx.$set$postInc()) != Unsigned.$int2ullong(0));
    // Body is set by VisitCapturedStmt.
    for (/*uint*/int I = 0; Unsigned.$less_uint(I, CD.NumParams); ++I) {
      if (I != ContextParamPos) {
        CD.setParam(I, this.<ImplicitParamDecl>ReadDeclAs(ImplicitParamDecl.class, Record, Idx));
      } else {
        CD.setContextParam(I, this.<ImplicitParamDecl>ReadDeclAs(ImplicitParamDecl.class, Record, Idx));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitEmptyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2227,
   FQN="clang::ASTDeclReader::VisitEmptyDecl", NM="_ZN5clang13ASTDeclReader14VisitEmptyDeclEPNS_9EmptyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader14VisitEmptyDeclEPNS_9EmptyDeclE")
  //</editor-fold>
  public void VisitEmptyDecl(EmptyDecl /*P*/ D) {
    VisitDecl(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2231,
   FQN="clang::ASTDeclReader::VisitDeclContext", NM="_ZN5clang13ASTDeclReader16VisitDeclContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader16VisitDeclContextEPNS_11DeclContextE")
  //</editor-fold>
  public std.pairULongULong VisitDeclContext(DeclContext /*P*/ DC) {
    long/*uint64_t*/ LexicalOffset = ReadLocalOffset(Record, Idx);
    long/*uint64_t*/ VisibleOffset = ReadLocalOffset(Record, Idx);
    return std.make_pair_ullong_ullong(LexicalOffset, VisibleOffset);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitRedeclarable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2239,
   FQN="clang::ASTDeclReader::VisitRedeclarable", NM="Tpl__ZN5clang13ASTDeclReader17VisitRedeclarableEPNS_12RedeclarableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader17VisitRedeclarableEPNS_12RedeclarableIT_EE")
  //</editor-fold>
  public </*typename*/ T extends Decl & Redeclarable> ASTDeclReader.RedeclarableResult VisitRedeclarable(Redeclarable<T> /*P*/ D) {
    /*uint32_t*/int FirstDeclID = ReadDeclID(Record, Idx);
    Decl /*P*/ MergeWith = null;
    
    boolean IsKeyDecl = ThisDeclID == FirstDeclID;
    boolean IsFirstLocalDecl = false;
    
    long/*uint64_t*/ RedeclOffset = Unsigned.$int2ulong(0);
    
    // 0 indicates that this declaration was the only declaration of its entity,
    // and is used for space optimization.
    if (FirstDeclID == 0) {
      FirstDeclID = ThisDeclID;
      IsKeyDecl = true;
      IsFirstLocalDecl = true;
    } else {
      /*uint*/int N = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      if ((N != 0)) {
        // This declaration was the first local declaration, but may have imported
        // other declarations.
        IsKeyDecl = N == 1;
        IsFirstLocalDecl = true;
        
        // We have some declarations that must be before us in our redeclaration
        // chain. Read them now, and remember that we ought to merge with one of
        // them.
        // FIXME: Provide a known merge target to the second and subsequent such
        // declaration.
        for (/*uint*/int I = 0; I != N - 1; ++I)  {
          MergeWith = ReadDecl(Record, Idx/*, MergeWith*/);
        }
        
        RedeclOffset = ReadLocalOffset(Record, Idx);
      } else {
        // This declaration was not the first local declaration. Read the first
        // local declaration now, to trigger the import of other redeclarations.
        /*J:(void)*/ReadDecl(Record, Idx);
      }
    }
    
    T /*P*/ FirstDecl = (T) llvm.cast_or_null/*<T>*/(Redeclarable.class, Reader.GetDecl(FirstDeclID));
    if (Native.$noteq(FirstDecl, D)) {
      // We delay loading of the redeclaration chain to avoid deeply nested calls.
      // We temporarily set the first (canonical) declaration as the previous one
      // which is the one that matters and mark the real previous DeclID to be
      // loaded & attached later on.
      D.$Redeclarable$Fields().RedeclLink = Redeclarable.<T>PreviousDeclLink(FirstDecl);
      D.$Redeclarable$Fields().First = (T)FirstDecl.getCanonicalDecl();
    }
    
    T /*P*/ DAsT = ((/*static_cast*/T /*P*/ )(D));
    
    // Note that we need to load local redeclarations of this decl and build a
    // decl chain for them. This must happen *after* we perform the preloading
    // above; this ensures that the redeclaration chain is built in the correct
    // order.
    if (IsFirstLocalDecl) {
      Reader.PendingDeclChains.push_back(std.make_pair_Ptr_ulong(DAsT, RedeclOffset));
    }
    
    return new RedeclarableResult(FirstDeclID, MergeWith, IsKeyDecl);
  }

  
  /*template <typename T> TEMPLATE*/
  
  /// \brief Attempts to merge the given declaration (D) with another declaration
  /// of the same entity.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::mergeRedeclarable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2301,
   FQN="clang::ASTDeclReader::mergeRedeclarable", NM="Tpl__ZN5clang13ASTDeclReader17mergeRedeclarableEPNS_12RedeclarableIT_EERNS0_18RedeclarableResultEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader17mergeRedeclarableEPNS_12RedeclarableIT_EERNS0_18RedeclarableResultEj")
  //</editor-fold>
  public </*typename*/ T extends Decl & Redeclarable> void mergeRedeclarable(Redeclarable<T> /*P*/ DBase, 
                   final RedeclarableResult /*&*/ Redecl) {
    mergeRedeclarable(DBase, 
                   Redecl, 
                   0);
  }
  public </*typename*/ T extends Decl & Redeclarable> void mergeRedeclarable(Redeclarable<T> /*P*/ DBase, 
                   final RedeclarableResult /*&*/ Redecl, 
                   /*uint32_t*/int TemplatePatternID/*= 0*/) {
    T /*P*/ D = ((/*static_cast*/T /*P*/ )(DBase));
    
    // If modules are not available, there is no reason to perform this merge.
    if (!Reader.getContext().getLangOpts().Modules) {
      return;
    }
    
    // If we're not the canonical declaration, we don't need to merge.
    if (Native.$not(DBase.isFirstDecl())) {
      return;
    }
    {
      
      Decl /*P*/ Existing = Redecl.getKnownMergeTarget();
      if ((Existing != null)) {
        // We already know of an existing declaration we should merge with.
        mergeRedeclarable(D, (T)/*cast<T>*/(Existing), Redecl, TemplatePatternID);
      } else {
        FindExistingResult ExistingRes = findExisting((NamedDecl)D);
        if (((ExistingRes.$NamedDecl$P()) != null)) {
          {
            T /*P*/ Existing$1 = (T)ExistingRes.$T$P(Redeclarable.class);
            if (Existing$1 != null) {
              mergeRedeclarable(D, Existing$1, Redecl, TemplatePatternID);
            }
          }
        }
      }
    }
  }

  
  /*template <typename T> TEMPLATE*/
  
  /// \brief Attempts to merge the given declaration (D) with another declaration
  /// of the same entity.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::mergeRedeclarable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2374,
   FQN="clang::ASTDeclReader::mergeRedeclarable", NM="Tpl__ZN5clang13ASTDeclReader17mergeRedeclarableEPNS_12RedeclarableIT_EEPS2_RNS0_18RedeclarableResultEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader17mergeRedeclarableEPNS_12RedeclarableIT_EEPS2_RNS0_18RedeclarableResultEj")
  //</editor-fold>
  public </*typename*/ T extends Decl & Redeclarable> void mergeRedeclarable(Redeclarable<T> /*P*/ DBase, T /*P*/ Existing, 
                   final RedeclarableResult /*&*/ Redecl) {
    mergeRedeclarable(DBase, Existing, 
                   Redecl, 
                   0);
  }
  public </*typename*/ T extends Decl & Redeclarable> void mergeRedeclarable(Redeclarable<T> /*P*/ DBase, T /*P*/ Existing, 
                   final RedeclarableResult /*&*/ Redecl, 
                   /*uint32_t*/int TemplatePatternID/*= 0*/) {
    T /*P*/ D = ((/*static_cast*/T /*P*/ )(DBase));
    T /*P*/ ExistingCanon = (T)Existing.getCanonicalDecl();
    T /*P*/ DCanon = (T)D.getCanonicalDecl();
    if (Native.$noteq(ExistingCanon, DCanon)) {
      assert Native.$bool(Native.$eq(DCanon.getGlobalID(), Redecl.getFirstID())) : "already merged this declaration";
      
      // Have our redeclaration link point back at the canonical declaration
      // of the existing declaration, so that this declaration has the
      // appropriate canonical declaration.
      D.$Redeclarable$Fields().RedeclLink = Redeclarable.<T>PreviousDeclLink(ExistingCanon);
      D.$Redeclarable$Fields().First = ExistingCanon;
      ExistingCanon.Used |= D.Used;
      D.Used = false;
      {
        
        // When we merge a namespace, update its pointer to the first namespace.
        // We cannot have loaded any redeclarations of this declaration yet, so
        // there's nothing else that needs to be updated.
        NamespaceDecl /*P*/ Namespace = llvm.dyn_cast(NamespaceDecl.class, D);
        if (Namespace != null) {
          Namespace.AnonOrFirstNamespaceAndInline.setPointer(assert_cast(NamespaceDecl.class, ExistingCanon));
        }
      }
      {
        
        // When we merge a template, merge its pattern.
        RedeclarableTemplateDecl /*P*/ DTemplate = llvm.dyn_cast(RedeclarableTemplateDecl.class, D);
        if (DTemplate != null) {
          mergeTemplatePattern(DTemplate, assert_cast(RedeclarableTemplateDecl.class, ExistingCanon), 
              TemplatePatternID, Redecl.isKeyDecl());
        }
      }
      
      // If this declaration is a key declaration, make a note of that.
      if (Redecl.isKeyDecl()) {
        Reader.KeyDecls.$at(ExistingCanon).push_back(Redecl.getFirstID());
      }
    }
  }

  
  /*template <typename T> TEMPLATE*/
  
  /// \brief Attempts to merge the given declaration (D) with another declaration
  /// of the same entity, for the case where the entity is not actually
  /// redeclarable. This happens, for instance, when merging the fields of
  /// identical class definitions from two different modules.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::mergeMergeable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2416,
   FQN="clang::ASTDeclReader::mergeMergeable", NM="Tpl__ZN5clang13ASTDeclReader14mergeMergeableEPNS_9MergeableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZN5clang13ASTDeclReader14mergeMergeableEPNS_9MergeableIT_EE")
  //</editor-fold>
  public </*typename*/ T extends Decl & Mergeable> void mergeMergeable(Mergeable<T> /*P*/ D) {
    // If modules are not available, there is no reason to perform this merge.
    if (!Reader.getContext().getLangOpts().Modules) {
      return;
    }
    
    // ODR-based merging is only performed in C++. In C, identically-named things
    // in different translation units are not redeclarations (but may still have
    // compatible types).
    if (!Reader.getContext().getLangOpts().CPlusPlus) {
      return;
    }
    {
      
      FindExistingResult ExistingRes = findExisting(((/*static_cast*/NamedDecl /*P*/ )(D)));
      if (((ExistingRes.$NamedDecl$P()) != null)) {
        {
          T /*P*/ Existing = (T)ExistingRes.$T$P(Mergeable.class);
          if (Existing != null) {
            Reader.Context.setPrimaryMergedDecl(((/*static_cast*/T /*P*/ )(D)), 
                Existing.getCanonicalDecl());
          }
        }
      }
    }
  }

  
  
  /// \brief Merge together the pattern declarations from two template
  /// declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::mergeTemplatePattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2332,
   FQN="clang::ASTDeclReader::mergeTemplatePattern", NM="_ZN5clang13ASTDeclReader20mergeTemplatePatternEPNS_24RedeclarableTemplateDeclES2_jb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20mergeTemplatePatternEPNS_24RedeclarableTemplateDeclES2_jb")
  //</editor-fold>
  public void mergeTemplatePattern(RedeclarableTemplateDecl /*P*/ D, 
                      RedeclarableTemplateDecl /*P*/ Existing, 
                      /*uint32_t*/int DsID, boolean IsKeyDecl) {
    NamedDecl /*P*/ DPattern = D.getTemplatedDecl();
    NamedDecl /*P*/ ExistingPattern = Existing.getTemplatedDecl();
    RedeclarableResult Result/*J*/= new RedeclarableResult(DPattern.getCanonicalDecl().getGlobalID(), 
        /*MergeWith*/ ExistingPattern, IsKeyDecl);
    {
      
      CXXRecordDecl /*P*/ DClass = AstDeclarationsRTTI.dyn_cast_CXXRecordDecl(DPattern);
      if ((DClass != null)) {
        // Merge with any existing definition.
        // FIXME: This is duplicated in several places. Refactor.
        CXXRecordDecl /*P*/ ExistingClass = AstDeclarationsRTTI.cast_CXXRecordDecl(ExistingPattern).getCanonicalDecl();
        {
          CXXRecordDecl.DefinitionData /*P*/ DDD = DClass.DefinitionData;
          if ((DDD != null)) {
            if ((ExistingClass.DefinitionData != null)) {
              MergeDefinitionData(ExistingClass, std.move(Native.$Deref(DDD)));
            } else {
              ExistingClass.DefinitionData = DClass.DefinitionData;
              // We may have skipped this before because we thought that DClass
              // was the canonical declaration.
              Reader.PendingDefinitions.insert(DClass);
            }
          }
        }
        DClass.DefinitionData = ExistingClass.DefinitionData;
        
        mergeRedeclarable(DClass, AstDeclarationsRTTI.cast_TagDecl(ExistingPattern),
            Result);
        /*JAVA:return*/return;
      }
    }
    {
      FunctionDecl /*P*/ DFunction = AstDeclarationsRTTI.dyn_cast_FunctionDecl(DPattern);
      if ((DFunction != null)) {
        mergeRedeclarable(DFunction, AstDeclarationsRTTI.cast_FunctionDecl(ExistingPattern),
            Result);
        /*JAVA:return*/return;
      }
    }
    {
      VarDecl /*P*/ DVar = AstDeclarationsRTTI.dyn_cast_VarDecl(DPattern);
      if ((DVar != null)) {
        mergeRedeclarable(DVar, AstDeclarationsRTTI.cast_VarDecl(ExistingPattern), Result);
        /*JAVA:return*/return;
      }
    }
    {
      TypeAliasDecl /*P*/ DAlias = AstDeclarationsRTTI.dyn_cast_TypeAliasDecl(DPattern);
      if ((DAlias != null)) {
        mergeRedeclarable(DAlias, AstDeclarationsRTTI.cast_TypedefNameDecl(ExistingPattern),
            Result);
        /*JAVA:return*/return;
      }
    }
    throw new llvm_unreachable("merged an unknown kind of redeclarable template");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::ReadObjCTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 959,
   FQN="clang::ASTDeclReader::ReadObjCTypeParamList", NM="_ZN5clang13ASTDeclReader21ReadObjCTypeParamListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21ReadObjCTypeParamListEv")
  //</editor-fold>
  public ObjCTypeParamList /*P*/ ReadObjCTypeParamList() {
    /*uint*/int numParams = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if (numParams == 0) {
      return null;
    }
    
    SmallVector<ObjCTypeParamDecl /*P*/ > typeParams/*J*/= new SmallVector<ObjCTypeParamDecl /*P*/ >(4, (ObjCTypeParamDecl /*P*/ )null);
    typeParams.reserve(numParams);
    for (/*uint*/int i = 0; i != numParams; ++i) {
      ObjCTypeParamDecl /*P*/ typeParam = this.<ObjCTypeParamDecl>ReadDeclAs(ObjCTypeParamDecl.class, Record, Idx);
      if (!(typeParam != null)) {
        return null;
      }
      
      typeParams.push_back(typeParam);
    }
    
    SourceLocation lAngleLoc = ReadSourceLocation(Record, Idx);
    SourceLocation rAngleLoc = ReadSourceLocation(Record, Idx);
    
    return ObjCTypeParamList.create(Reader.getContext(), new SourceLocation(lAngleLoc), 
        new ArrayRef<ObjCTypeParamDecl /*P*/ >(typeParams, true), new SourceLocation(rAngleLoc));
  }

  
  // FIXME: Reorder according to DeclNodes.td?
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 899,
   FQN="clang::ASTDeclReader::VisitObjCMethodDecl", NM="_ZN5clang13ASTDeclReader19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void VisitObjCMethodDecl(ObjCMethodDecl /*P*/ MD) {
    VisitNamedDecl(MD);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      // Load the body on-demand. Most clients won't care, because method
      // definitions rarely show up in headers.
      Reader.PendingBodies.$set(MD, GetCurrentCursorOffset());
      HasPendingBody = true;
      MD.setSelfDecl(this.<ImplicitParamDecl>ReadDeclAs(ImplicitParamDecl.class, Record, Idx));
      MD.setCmdDecl(this.<ImplicitParamDecl>ReadDeclAs(ImplicitParamDecl.class, Record, Idx));
    }
    MD.setInstanceMethod((Record.$at$Const(Idx.$set$postInc()) != 0));
    MD.setVariadic((Record.$at$Const(Idx.$set$postInc()) != 0));
    MD.setPropertyAccessor((Record.$at$Const(Idx.$set$postInc()) != 0));
    MD.setDefined((Record.$at$Const(Idx.$set$postInc()) != 0));
    MD.IsOverriding = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    MD.HasSkippedBody = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    MD.IsRedeclaration = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    MD.HasRedeclaration = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    if (MD.HasRedeclaration) {
      Reader.getContext().setObjCMethodRedeclaration(MD, 
          this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx));
    }
    
    MD.setDeclImplementation(ObjCMethodDecl.ImplementationControl.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    MD.setObjCDeclQualifier((/*Decl::ObjCDeclQualifier*//*uint*/int)Record.$at$Const(Idx.$set$postInc()));
    MD.SetRelatedResultType((Record.$at$Const(Idx.$set$postInc()) != 0));
    MD.setReturnType(Reader.readType(F, Record, Idx));
    MD.setReturnTypeSourceInfo(GetTypeSourceInfo(Record, Idx));
    MD.DeclEndLoc.$assignMove(ReadSourceLocation(Record, Idx));
    /*uint*/int NumParams = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
    Params.reserve(NumParams);
    for (/*uint*/int I = 0; I != NumParams; ++I)  {
      Params.push_back(this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx));
    }
    
    MD.SelLocsKind = Unsigned.$uint2uint_2bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    /*uint*/int NumStoredSelLocs = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<SourceLocation> SelLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
    SelLocs.reserve(NumStoredSelLocs);
    for (/*uint*/int i = 0; i != NumStoredSelLocs; ++i)  {
      SelLocs.push_back(ReadSourceLocation(Record, Idx));
    }
    
    MD.setParamsAndSelLocs(Reader.getContext(), new ArrayRef<ParmVarDecl /*P*/ >(Params, true), new ArrayRef<SourceLocation>(SelLocs, false));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 944,
   FQN="clang::ASTDeclReader::VisitObjCTypeParamDecl", NM="_ZN5clang13ASTDeclReader22VisitObjCTypeParamDeclEPNS_17ObjCTypeParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitObjCTypeParamDeclEPNS_17ObjCTypeParamDeclE")
  //</editor-fold>
  public void VisitObjCTypeParamDecl(ObjCTypeParamDecl /*P*/ D) {
    ASTDeclReader$VisitTypedefNameDecl(D);
    
    D.Variance = Unsigned.$uint2uint_2bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    D.Index = Unsigned.$uint2uint_14bits(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    D.VarianceLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.ColonLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCContainerDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 953,
   FQN="clang::ASTDeclReader::VisitObjCContainerDecl", NM="_ZN5clang13ASTDeclReader22VisitObjCContainerDeclEPNS_17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitObjCContainerDeclEPNS_17ObjCContainerDeclE")
  //</editor-fold>
  public void VisitObjCContainerDecl(ObjCContainerDecl /*P*/ CD) {
    VisitNamedDecl(CD);
    CD.setAtStartLoc(ReadSourceLocation(Record, Idx));
    CD.setAtEndRange(ReadSourceRange(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 981,
   FQN="clang::ASTDeclReader::VisitObjCInterfaceDecl", NM="_ZN5clang13ASTDeclReader22VisitObjCInterfaceDeclEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22VisitObjCInterfaceDeclEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void VisitObjCInterfaceDecl(ObjCInterfaceDecl /*P*/ ID) {
    RedeclarableResult Redecl = VisitRedeclarable(ID);
    VisitObjCContainerDecl(ID);
    TypeIDForTypeDecl = Reader.getGlobalTypeID(F, Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    mergeRedeclarable(ID, Redecl);
    
    ID.TypeParamList = ReadObjCTypeParamList();
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      // Read the definition.
      ID.allocateDefinitionData();
      
      // Set the definition data of the canonical declaration, so other
      // redeclarations will see it.
      ID.getCanonicalDecl().Data.$assign(ID.Data);
      
      final ObjCInterfaceDecl.DefinitionData /*&*/ Data = ID.data();
      
      // Read the superclass.
      Data.SuperClassTInfo = GetTypeSourceInfo(Record, Idx);
      
      Data.EndLoc.$assignMove(ReadSourceLocation(Record, Idx));
      Data.HasDesignatedInitializers = Unsigned.$uint2uint_1bit(Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      
      // Read the directly referenced protocols and their SourceLocations.
      /*uint*/int NumProtocols = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(16, (ObjCProtocolDecl /*P*/ )null);
      Protocols.reserve(NumProtocols);
      for (/*uint*/int I = 0; I != NumProtocols; ++I)  {
        Protocols.push_back(this.<ObjCProtocolDecl>ReadDeclAs(ObjCProtocolDecl.class, Record, Idx));
      }
      SmallVector<SourceLocation> ProtoLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
      ProtoLocs.reserve(NumProtocols);
      for (/*uint*/int I = 0; I != NumProtocols; ++I)  {
        ProtoLocs.push_back(ReadSourceLocation(Record, Idx));
      }
      ID.setProtocolList(Protocols.data(), NumProtocols, ProtoLocs.data(), 
          Reader.getContext());
      
      // Read the transitive closure of protocols referenced by this class.
      NumProtocols = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      Protocols.clear();
      Protocols.reserve(NumProtocols);
      for (/*uint*/int I = 0; I != NumProtocols; ++I)  {
        Protocols.push_back(this.<ObjCProtocolDecl>ReadDeclAs(ObjCProtocolDecl.class, Record, Idx));
      }
      ID.data().AllReferencedProtocols.set(Protocols.data(), NumProtocols, 
          Reader.getContext());
      
      // We will rebuild this list lazily.
      ID.setIvarList((ObjCIvarDecl /*P*/ )null);
      
      // Note that we have deserialized a definition.
      Reader.PendingDefinitions.insert(ID);
      
      // Note that we've loaded this Objective-C class.
      Reader.ObjCClassesLoaded.push_back(ID);
    } else {
      ID.Data.$assign(ID.getCanonicalDecl().Data);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCIvarDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1039,
   FQN="clang::ASTDeclReader::VisitObjCIvarDecl", NM="_ZN5clang13ASTDeclReader17VisitObjCIvarDeclEPNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17VisitObjCIvarDeclEPNS_12ObjCIvarDeclE")
  //</editor-fold>
  public void VisitObjCIvarDecl(ObjCIvarDecl /*P*/ IVD) {
    VisitFieldDecl(IVD);
    IVD.setAccessControl(ObjCIvarDecl.AccessControl.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    // This field will be built lazily.
    IVD.setNextIvar((ObjCIvarDecl /*P*/ )null);
    boolean synth = (Record.$at$Const(Idx.$set$postInc()) != 0);
    IVD.setSynthesize(synth);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1048,
   FQN="clang::ASTDeclReader::VisitObjCProtocolDecl", NM="_ZN5clang13ASTDeclReader21VisitObjCProtocolDeclEPNS_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21VisitObjCProtocolDeclEPNS_16ObjCProtocolDeclE")
  //</editor-fold>
  public void VisitObjCProtocolDecl(ObjCProtocolDecl /*P*/ PD) {
    RedeclarableResult Redecl = VisitRedeclarable(PD);
    VisitObjCContainerDecl(PD);
    mergeRedeclarable(PD, Redecl);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      // Read the definition.
      PD.allocateDefinitionData();
      
      // Set the definition data of the canonical declaration, so other
      // redeclarations will see it.
      PD.getCanonicalDecl().Data.$assign(PD.Data);
      
      /*uint*/int NumProtoRefs = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      SmallVector<ObjCProtocolDecl /*P*/ > ProtoRefs/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(16, (ObjCProtocolDecl /*P*/ )null);
      ProtoRefs.reserve(NumProtoRefs);
      for (/*uint*/int I = 0; I != NumProtoRefs; ++I)  {
        ProtoRefs.push_back(this.<ObjCProtocolDecl>ReadDeclAs(ObjCProtocolDecl.class, Record, Idx));
      }
      SmallVector<SourceLocation> ProtoLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
      ProtoLocs.reserve(NumProtoRefs);
      for (/*uint*/int I = 0; I != NumProtoRefs; ++I)  {
        ProtoLocs.push_back(ReadSourceLocation(Record, Idx));
      }
      PD.setProtocolList(ProtoRefs.data(), NumProtoRefs, ProtoLocs.data(), 
          Reader.getContext());
      
      // Note that we have deserialized a definition.
      Reader.PendingDefinitions.insert(PD);
    } else {
      PD.Data.$assign(PD.getCanonicalDecl().Data);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCAtDefsFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1080,
   FQN="clang::ASTDeclReader::VisitObjCAtDefsFieldDecl", NM="_ZN5clang13ASTDeclReader24VisitObjCAtDefsFieldDeclEPNS_19ObjCAtDefsFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader24VisitObjCAtDefsFieldDeclEPNS_19ObjCAtDefsFieldDeclE")
  //</editor-fold>
  public void VisitObjCAtDefsFieldDecl(ObjCAtDefsFieldDecl /*P*/ FD) {
    VisitFieldDecl(FD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1084,
   FQN="clang::ASTDeclReader::VisitObjCCategoryDecl", NM="_ZN5clang13ASTDeclReader21VisitObjCCategoryDeclEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21VisitObjCCategoryDeclEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  public void VisitObjCCategoryDecl(ObjCCategoryDecl /*P*/ CD) {
    VisitObjCContainerDecl(CD);
    CD.setCategoryNameLoc(ReadSourceLocation(Record, Idx));
    CD.setIvarLBraceLoc(ReadSourceLocation(Record, Idx));
    CD.setIvarRBraceLoc(ReadSourceLocation(Record, Idx));
    
    // Note that this category has been deserialized. We do this before
    // deserializing the interface declaration, so that it will consider this
    /// category.
    Reader.CategoriesDeserialized.insert(CD);
    
    CD.ClassInterface = this.<ObjCInterfaceDecl>ReadDeclAs(ObjCInterfaceDecl.class, Record, Idx);
    CD.TypeParamList = ReadObjCTypeParamList();
    /*uint*/int NumProtoRefs = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<ObjCProtocolDecl /*P*/ > ProtoRefs/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(16, (ObjCProtocolDecl /*P*/ )null);
    ProtoRefs.reserve(NumProtoRefs);
    for (/*uint*/int I = 0; I != NumProtoRefs; ++I)  {
      ProtoRefs.push_back(this.<ObjCProtocolDecl>ReadDeclAs(ObjCProtocolDecl.class, Record, Idx));
    }
    SmallVector<SourceLocation> ProtoLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
    ProtoLocs.reserve(NumProtoRefs);
    for (/*uint*/int I = 0; I != NumProtoRefs; ++I)  {
      ProtoLocs.push_back(ReadSourceLocation(Record, Idx));
    }
    CD.setProtocolList(ProtoRefs.data(), NumProtoRefs, ProtoLocs.data(), 
        Reader.getContext());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1135,
   FQN="clang::ASTDeclReader::VisitObjCImplDecl", NM="_ZN5clang13ASTDeclReader17VisitObjCImplDeclEPNS_12ObjCImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17VisitObjCImplDeclEPNS_12ObjCImplDeclE")
  //</editor-fold>
  public void VisitObjCImplDecl(ObjCImplDecl /*P*/ D) {
    VisitObjCContainerDecl(D);
    D.setClassInterface(this.<ObjCInterfaceDecl>ReadDeclAs(ObjCInterfaceDecl.class, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1140,
   FQN="clang::ASTDeclReader::VisitObjCCategoryImplDecl", NM="_ZN5clang13ASTDeclReader25VisitObjCCategoryImplDeclEPNS_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader25VisitObjCCategoryImplDeclEPNS_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void VisitObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ D) {
    VisitObjCImplDecl(D);
    D.setIdentifier(Reader.GetIdentifierInfo(F, Record, Idx));
    D.CategoryNameLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1146,
   FQN="clang::ASTDeclReader::VisitObjCImplementationDecl", NM="_ZN5clang13ASTDeclReader27VisitObjCImplementationDeclEPNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader27VisitObjCImplementationDeclEPNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public void VisitObjCImplementationDecl(ObjCImplementationDecl /*P*/ D) {
    VisitObjCImplDecl(D);
    D.setSuperClass(this.<ObjCInterfaceDecl>ReadDeclAs(ObjCInterfaceDecl.class, Record, Idx));
    D.SuperLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.setIvarLBraceLoc(ReadSourceLocation(Record, Idx));
    D.setIvarRBraceLoc(ReadSourceLocation(Record, Idx));
    D.setHasNonZeroConstructors((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.setHasDestructors((Record.$at$Const(Idx.$set$postInc()) != 0));
    D.NumIvarInitializers = Unsigned.$ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if ((D.NumIvarInitializers != 0)) {
      D.IvarInitializers.$assign(ReadGlobalOffset(F, Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1110,
   FQN="clang::ASTDeclReader::VisitObjCCompatibleAliasDecl", NM="_ZN5clang13ASTDeclReader28VisitObjCCompatibleAliasDeclEPNS_23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader28VisitObjCCompatibleAliasDeclEPNS_23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  public void VisitObjCCompatibleAliasDecl(ObjCCompatibleAliasDecl /*P*/ CAD) {
    VisitNamedDecl(CAD);
    CAD.setClassInterface(this.<ObjCInterfaceDecl>ReadDeclAs(ObjCInterfaceDecl.class, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCPropertyDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1115,
   FQN="clang::ASTDeclReader::VisitObjCPropertyDecl", NM="_ZN5clang13ASTDeclReader21VisitObjCPropertyDeclEPNS_16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader21VisitObjCPropertyDeclEPNS_16ObjCPropertyDeclE")
  //</editor-fold>
  public void VisitObjCPropertyDecl(ObjCPropertyDecl /*P*/ D) {
    VisitNamedDecl(D);
    D.setAtLoc(ReadSourceLocation(Record, Idx));
    D.setLParenLoc(ReadSourceLocation(Record, Idx));
    QualType T = Reader.readType(F, Record, Idx);
    TypeSourceInfo /*P*/ TSI = GetTypeSourceInfo(Record, Idx);
    D.setType(new QualType(T), TSI);
    D.setPropertyAttributes((/*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int)Record.$at$Const(Idx.$set$postInc()));
    D.setPropertyAttributesAsWritten((/*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int)Record.$at$Const(Idx.$set$postInc()));
    D.setPropertyImplementation(ObjCPropertyDecl.PropertyControl.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    D.setGetterName(Reader.ReadDeclarationName(F, Record, Idx).getObjCSelector());
    D.setSetterName(Reader.ReadDeclarationName(F, Record, Idx).getObjCSelector());
    D.setGetterMethodDecl(this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx));
    D.setSetterMethodDecl(this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx));
    D.setPropertyIvarDecl(this.<ObjCIvarDecl>ReadDeclAs(ObjCIvarDecl.class, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1159,
   FQN="clang::ASTDeclReader::VisitObjCPropertyImplDecl", NM="_ZN5clang13ASTDeclReader25VisitObjCPropertyImplDeclEPNS_20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader25VisitObjCPropertyImplDeclEPNS_20ObjCPropertyImplDeclE")
  //</editor-fold>
  public void VisitObjCPropertyImplDecl(ObjCPropertyImplDecl /*P*/ D) {
    VisitDecl(D);
    D.setAtLoc(ReadSourceLocation(Record, Idx));
    D.setPropertyDecl(this.<ObjCPropertyDecl>ReadDeclAs(ObjCPropertyDecl.class, Record, Idx));
    D.PropertyIvarDecl = this.<ObjCIvarDecl>ReadDeclAs(ObjCIvarDecl.class, Record, Idx);
    D.IvarLoc.$assignMove(ReadSourceLocation(Record, Idx));
    D.setGetterCXXConstructor(Reader.ReadExpr(F));
    D.setSetterCXXAssignment(Reader.ReadExpr(F));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitOMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2433,
   FQN="clang::ASTDeclReader::VisitOMPThreadPrivateDecl", NM="_ZN5clang13ASTDeclReader25VisitOMPThreadPrivateDeclEPNS_20OMPThreadPrivateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader25VisitOMPThreadPrivateDeclEPNS_20OMPThreadPrivateDeclE")
  //</editor-fold>
  public void VisitOMPThreadPrivateDecl(OMPThreadPrivateDecl /*P*/ D) {
    VisitDecl(D);
    /*uint*/int NumVars = D.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i) {
      Vars.push_back(Reader.ReadExpr(F));
    }
    D.setVars(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitOMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2444,
   FQN="clang::ASTDeclReader::VisitOMPDeclareReductionDecl", NM="_ZN5clang13ASTDeclReader28VisitOMPDeclareReductionDeclEPNS_23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader28VisitOMPDeclareReductionDeclEPNS_23OMPDeclareReductionDeclE")
  //</editor-fold>
  public void VisitOMPDeclareReductionDecl(OMPDeclareReductionDecl /*P*/ D) {
    VisitValueDecl(D);
    D.setLocation(Reader.ReadSourceLocation(F, Record, Idx));
    D.setCombiner(Reader.ReadExpr(F));
    D.setInitializer(Reader.ReadExpr(F));
    D.PrevDeclInScope.$assign(Unsigned.$uint2ulong(Reader.ReadDeclID(F, Record, Idx)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::VisitOMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2452,
   FQN="clang::ASTDeclReader::VisitOMPCapturedExprDecl", NM="_ZN5clang13ASTDeclReader24VisitOMPCapturedExprDeclEPNS_19OMPCapturedExprDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader24VisitOMPCapturedExprDeclEPNS_19OMPCapturedExprDeclE")
  //</editor-fold>
  public void VisitOMPCapturedExprDecl(OMPCapturedExprDecl /*P*/ D) {
    VisitVarDecl(D);
  }

  
  /// We've merged the definition \p MergedDef into the existing definition
  /// \p Def. Ensure that \p Def is made visible whenever \p MergedDef is made
  /// visible.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::mergeDefinitionVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 384,
   FQN="clang::ASTDeclReader::mergeDefinitionVisibility", NM="_ZN5clang13ASTDeclReader25mergeDefinitionVisibilityEPNS_9NamedDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader25mergeDefinitionVisibilityEPNS_9NamedDeclES2_")
  //</editor-fold>
  public void mergeDefinitionVisibility(NamedDecl /*P*/ Def, NamedDecl /*P*/ MergedDef) {
    if (Def.isHidden()) {
      // If MergedDef is visible or becomes visible, make the definition visible.
      if (!MergedDef.isHidden()) {
        Def.Hidden = false;
      } else if (Reader.getContext().getLangOpts().ModulesLocalVisibility) {
        Reader.getContext().mergeDefinitionIntoModule(Def, MergedDef.getImportedOwningModule(), 
            /*NotifyListeners*/ false);
        Reader.PendingMergedDefinitionsToDeduplicate.insert(Def);
      } else {
        /*uint*/int SubmoduleID = MergedDef.getOwningModuleID();
        assert ((SubmoduleID != 0)) : "hidden definition in no module";
        Reader.HiddenNamesMap.$at_T1$RR(Reader.getSubmodule(SubmoduleID)).push_back(Def);
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclReader::attachPreviousDeclImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3044,
   FQN="clang::ASTDeclReader::attachPreviousDeclImpl", NM="_ZN5clang13ASTDeclReader22attachPreviousDeclImplINS_12FunctionDeclEEEvRNS_9ASTReaderEPNS_12RedeclarableIT_EEPNS_4DeclESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader22attachPreviousDeclImplINS_12FunctionDeclEEEvRNS_9ASTReaderEPNS_12RedeclarableIT_EEPNS_4DeclESA_")
  //</editor-fold>
  public static void attachPreviousDeclImpl_ASTReader_Redeclarable$FunctionDecl$P_Decl$P(final ASTReader /*&*/ Reader, 
                                                                     Redeclarable<FunctionDecl> /*P*/ D, 
                                                                     Decl /*P*/ Previous, Decl /*P*/ Canon) {
    FunctionDecl /*P*/ FD = ((/*static_cast*/FunctionDecl /*P*/ )(D));
    FunctionDecl /*P*/ PrevFD = AstDeclarationsRTTI.cast_FunctionDecl(Previous);
    
    FD.$Redeclarable$Fields().RedeclLink.setPrevious(PrevFD);
    FD.$Redeclarable$Fields().First = PrevFD.$Redeclarable$Fields().First;
    
    // If the previous declaration is an inline function declaration, then this
    // declaration is too.
    if (PrevFD.IsInline != FD.IsInline) {
      // FIXME: [dcl.fct.spec]p4:
      //   If a function with external linkage is declared inline in one
      //   translation unit, it shall be declared inline in all translation
      //   units in which it appears.
      //
      // Be careful of this case:
      //
      // module A:
      //   template<typename T> struct X { void f(); };
      //   template<typename T> inline void X<T>::f() {}
      //
      // module B instantiates the declaration of X<int>::f
      // module C instantiates the definition of X<int>::f
      //
      // If module B and C are merged, we do not have a violation of this rule.
      FD.IsInline = true;
    }
    
    // If we need to propagate an exception specification along the redecl
    // chain, make a note of that so that we can do so later.
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    /*const*/ FunctionProtoType /*P*/ PrevFPT = PrevFD.getType().$arrow().getAs(FunctionProtoType.class);
    if ((FPT != null) && (PrevFPT != null)) {
      boolean IsUnresolved = BasicClangGlobals.isUnresolvedExceptionSpec(FPT.getExceptionSpecType());
      boolean WasUnresolved = BasicClangGlobals.isUnresolvedExceptionSpec(PrevFPT.getExceptionSpecType());
      if (IsUnresolved != WasUnresolved) {
        Reader.PendingExceptionSpecUpdates.insert(std.make_pair_Ptr_Ptr(Canon, IsUnresolved ? PrevFD : FD));
      }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added to emulate call by Derived::Visit from base visitor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 612,
   FQN="clang::ASTDeclReader::VisitTypedefNameDecl", NM="_ZN5clang13ASTDeclReader20VisitTypedefNameDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader20VisitTypedefNameDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>            
  public void VisitTypedefNameDecl(TypedefNameDecl /*P*/ TD) {
    ASTDeclReader$VisitTypedefNameDecl(TD);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added to emulate call by Derived::Visit from base visitor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 639,
   FQN="clang::ASTDeclReader::VisitTagDecl", NM="_ZN5clang13ASTDeclReader12VisitTagDeclEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader12VisitTagDeclEPNS_7TagDeclE")
  //</editor-fold>          
  public void VisitTagDecl(TagDecl /*P*/ TD) {
    ASTDeclReader$VisitTagDecl(TD);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added to emulate call by Derived::Visit from base visitor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1855,
   FQN="clang::ASTDeclReader::VisitTemplateDecl", NM="_ZN5clang13ASTDeclReader17VisitTemplateDeclEPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader17VisitTemplateDeclEPNS_12TemplateDeclE")
  //</editor-fold>          
  public void VisitTemplateDecl(TemplateDecl /*P*/ D) {
    ASTDeclReader$VisitTemplateDecl(D);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added to emulate call by Derived::Visit from base visitor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1867,
   FQN="clang::ASTDeclReader::VisitRedeclarableTemplateDecl", NM="_ZN5clang13ASTDeclReader29VisitRedeclarableTemplateDeclEPNS_24RedeclarableTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13ASTDeclReader29VisitRedeclarableTemplateDeclEPNS_24RedeclarableTemplateDeclE")
  //</editor-fold>          
  public void VisitRedeclarableTemplateDecl(RedeclarableTemplateDecl /*P*/ D) {
    ASTDeclReader$VisitRedeclarableTemplateDecl(D);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", F=" + F // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", ThisDeclID=" + ThisDeclID // NOI18N
              + ", ThisDeclLoc=" + ThisDeclLoc // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Idx=" + Idx // NOI18N
              + ", TypeIDForTypeDecl=" + TypeIDForTypeDecl // NOI18N
              + ", AnonymousDeclNumber=" + AnonymousDeclNumber // NOI18N
              + ", NamedDeclForTagDecl=" + NamedDeclForTagDecl // NOI18N
              + ", TypedefNameForLinkage=" + TypedefNameForLinkage // NOI18N
              + ", HasPendingBody=" + HasPendingBody // NOI18N
              + ", IsDeclMarkedUsed=" + IsDeclMarkedUsed // NOI18N
              + super.toString(); // NOI18N
  }
}
