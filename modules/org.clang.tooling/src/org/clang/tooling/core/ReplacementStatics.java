/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.clang.tooling.core;

import org.clank.java.std;
import org.llvm.support.llvm_unreachable;

/**
 *
 * @author petrkudriavtsev
 */
public final class ReplacementStatics {

  public static std.string getReplacementErrString(replacement_error Err) {
    switch (Err) {
      case fail_to_apply:
        return new std.string("Failed to apply a replacement.");
      case wrong_file_path:
        return new std.string("The new replacement's file path is different from the file path of "
            + "existing replacements");
      case overlap_conflict:
        return new std.string("The new replacement overlaps with an existing replacement.");
      case insert_conflict:
        return new std.string("The new insertion has the same insert location as an existing "
            + "replacement.");
    }
    throw new llvm_unreachable("A value of replacement_error has no message.");
    }

    // Combines overlapping ranges in \p Ranges and sorts the combined ranges.
    // Returns a set of non-overlapping and sorted ranges that is equivalent to
    // \p Ranges.
    public static std.vector<Range> combineAndSortRanges(std.vector<Range> Ranges) {
        //  llvm::sort(Ranges, [](const Range &LHS, const Range &RHS) {
        //    if (LHS.getOffset() != RHS.getOffset())
        //      return LHS.getOffset() < RHS.getOffset();
        //    return LHS.getLength() < RHS.getLength();
        //  });
        std.sort(Ranges.begin(), Ranges.end(),
                (/*const Range &*/LHS, /*const Range &*/ RHS) -> {
                    if (LHS.getOffset() != RHS.getOffset()) {
                        return LHS.getOffset() < RHS.getOffset();
                    }
                    return LHS.getLength() < RHS.getLength();
                });

        //  std::vector<Range> Result;
        std.vector<Range> Result = new std.vector<>(new Range());

        //  for (const auto &R : Ranges) {
        //    if (Result.empty() ||
        //        Result.back().getOffset() + Result.back().getLength() < R.getOffset()) {
        //      Result.push_back(R);
        //    } else {
        //      unsigned NewEnd =
        //          std::max(Result.back().getOffset() + Result.back().getLength(),
        //                   R.getOffset() + R.getLength());
        //      Result[Result.size() - 1] =
        //          Range(Result.back().getOffset(), NewEnd - Result.back().getOffset());
        //    }
        //  }
        for (Range R : Ranges) {
            if (Result.empty()
                    || Result.back().getOffset() + Result.back().getLength() < R.getOffset()) {
                Result.push_back(R);
            } else {
                int NewEnd
                        = std.max(Result.back().getOffset() + Result.back().getLength(),
                                R.getOffset() + R.getLength());
                Result.$at(Result.size() - 1)
                        .$assign(new Range(Result.back().getOffset(), NewEnd - Result.back().getOffset()));
            }
        }

        return Result;
    }

}
