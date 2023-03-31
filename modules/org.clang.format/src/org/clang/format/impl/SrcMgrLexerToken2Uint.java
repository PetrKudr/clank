package org.clang.format.impl;

import org.clang.basic.SourceManager;
import org.clang.lex.Lexer;
import org.clang.lex.Token;

@FunctionalInterface
public interface SrcMgrLexerToken2Uint {
  int /*uint*/ apply(final /*const*/ SourceManager /*&*/ SrcMgr, Lexer /*&*/ L, Token /*&*/ T);
}
