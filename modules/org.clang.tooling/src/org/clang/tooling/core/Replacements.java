/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.clang.tooling.core;

import org.clank.java.std;
import org.clank.java.std.setType;
import org.clank.java.std.vector;
import org.clank.java.stdimpl.StdSetType.iterator;
import org.clank.support.Destructors;
import org.clank.support.JavaCleaner;
import org.clank.support.JavaDifferentiators;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.support.AdtsupportLlvmGlobals;
import org.llvm.support.Error;
import org.llvm.support.Expected;

import java.util.Iterator;
import java.util.function.BiFunction;

import static org.clank.support.Native.$createJavaCleaner;

/**
 * @author petrkudriavtsev
 */
/// Maintains a set of replacements that are conflict-free.
/// Two replacements are considered conflicts if they overlap or have the same
/// offset (i.e. order-dependent).
public class Replacements implements Destructors.ClassWithDestructor, Iterable {
//private:
  //using ReplacementsImpl = std::set<Replacement>;

  public setType<Replacement> Replaces;

  //public:
  //using const_iterator = ReplacementsImpl::const_iterator;
  //using const_reverse_iterator = ReplacementsImpl::const_reverse_iterator;
  public Replacements() {
    Replaces = new setType<>();
  }

  public Replacements(/*const*/Replacement /*&*/ R) {
    Replaces = new setType<>();
    Replaces.insert(R);
  }

  private Replacements(setType.iterator<Replacement> Begin,
                       setType.iterator<Replacement> End) {
    Replaces = new setType<>(Begin, End);
  }

  public Replacements(JD$Move _dparam, final Replacements /*&&*/ other) {
    Replaces = new setType<>();

    Replaces.$assignMove(other.Replaces);
  }

  public Replacements(final Replacements /*const &*/ other) {
    Replaces = new setType<>();

    Replaces.$assign(other.Replaces);
  }

  public Replacements /*&*/ $assignMove(Replacements /*&&*/ other) {
    Replaces.$assignMove(other.Replaces);
    return this;
  }

  public Replacements /*&*/ $assign(final Replacements /*const &*/ other) {
    Replaces.$assign(other.Replaces);
    return this;
  }

  @Override
  public Iterator<Replacement> iterator() {
    return Replaces.iterator();
  }

  /// Adds a new replacement \p R to the current set of replacements.
  /// \p R must have the same file path as all existing replacements.
  /// Returns `success` if the replacement is successfully inserted; otherwise,
  /// it returns an llvm::Error, i.e. there is a conflict between R and the
  /// existing replacements (i.e. they are order-dependent) or R's file path is
  /// different from the filepath of existing replacements. Callers must
  /// explicitly check the Error returned, and the returned error can be
  /// converted to a string message with `llvm::toString()`. This prevents users
  /// from adding order-dependent replacements. To control the order in which
  /// order-dependent replacements are applied, use merge({R}) with R referring
  /// to the changed code after applying all existing replacements.
  /// Two replacements A and B are considered order-independent if applying them
  /// in either order produces the same result. Note that the range of the
  /// replacement that is applied later still refers to the original code.
  /// These include (but not restricted to) replacements that:
  ///   - don't overlap (being directly adjacent is fine) and
  ///   - are overlapping deletions.
  ///   - are insertions at the same offset and applying them in either order
  ///     has the same effect, i.e. X + Y = Y + X when inserting X and Y
  ///     respectively.
  ///   - are identical replacements, i.e. applying the same replacement twice
  ///     is equivalent to applying it once.
  /// Examples:
  /// 1. Replacement A(0, 0, "a") and B(0, 0, "aa") are order-independent since
  ///    applying them in either order gives replacement (0, 0, "aaa").
  ///    However, A(0, 0, "a") and B(0, 0, "b") are order-dependent since
  ///    applying A first gives (0, 0, "ab") while applying B first gives (B, A,
  ///    "ba").
  /// 2. Replacement A(0, 2, "123") and B(0, 2, "123") are order-independent
  ///    since applying them in either order gives (0, 2, "123").
  /// 3. Replacement A(0, 3, "123") and B(2, 3, "321") are order-independent
  ///    since either order gives (0, 5, "12321").
  /// 4. Replacement A(0, 3, "ab") and B(0, 3, "ab") are order-independent since
  ///    applying the same replacement twice is equivalent to applying it once.
  /// Replacements with offset UINT_MAX are special - we do not detect conflicts
  /// for such replacements since users may add them intentionally as a special
  /// category of replacements.
  public Error add(/*const */Replacement /*&*/ R) {
    // Check the file path.
    if (!Replaces.empty() && R.getFilePath().$noteq(Replaces.begin().$arrow().getFilePath())) {
      return AdtsupportLlvmGlobals.make_error(
              replacement_error.wrong_file_path, R, /*P*/ Replaces.begin().$star());
    }

    // Special-case header insertions.
    if (R.getOffset() == std.numeric_limitsUInt.max()) {
      Replaces.insert(new Replacement(R));
      return Error.success();
    }

    // This replacement cannot conflict with replacements that end before
    // this replacement starts or start after this replacement ends.
    // We also know that there currently are no overlapping replacements.
    // Thus, we know that all replacements that start after the end of the current
    // replacement cannot overlap.
    // Replacement AtEnd(R.getFilePath(), R.getOffset() + R.getLength(), 0, "");
    Replacement AtEnd = new Replacement(R.getFilePath(),
            R.getOffset() + R.getLength(), 0, new StringRef(""));

    JavaCleaner $c$ = $createJavaCleaner();

    // Find the first entry that starts after or at the end of R. Note that
    // entries that start at the end can still be conflicting if R is an
    // insertion.
    //  auto I = Replaces.lower_bound(AtEnd);
    iterator<Replacement> I = Replaces.lower_bound(AtEnd);

    // If `I` starts at the same offset as `R`, `R` must be an insertion.
    // if (I != Replaces.end() && R.getOffset() == I->getOffset()) {
    if (I.$noteq(Replaces.end()) && R.getOffset() == I.$arrow().getOffset()) {
      assert R.getLength() == 0;
      // `I` is also an insertion, `R` and `I` conflict.
      // if (I->getLength() == 0)
      if (I.$arrow().getLength() == 0) {
        // Check if two insertions are order-independent: if inserting them in
        // either order produces the same text, they are order-independent.
        // if ((R.getReplacementText() + I -> getReplacementText()).str()
        // != (I -> getReplacementText() + R.getReplacementText()).str())

        std.string v1 = new Twine(R.getReplacementText())
                .concat(new Twine(I.$arrow().getReplacementText())).str();
        std.string v2 = new Twine(I.$arrow().getReplacementText())
                .concat(new Twine(R.getReplacementText())).str();

        if (v1.$eq(v2)) {
          return AdtsupportLlvmGlobals.make_error(
                  replacement_error.insert_conflict, R, /*P*/ I.$star());
        }
        // If insertions are order-independent, we can merge them.
        Replacement NewR = new Replacement(R.getFilePath(), R.getOffset(), 0,
                new StringRef(v1));

        // Insertion `R` is adjacent to a non-insertion replacement `I`, so they
        // are order-independent. It is safe to assume that `R` will not conflict
        // with any replacement before `I` since all replacements before `I` must
        // either end before `R` or end at `R` but has length > 0 (if the
        // replacement before `I` is an insertion at `R`, it would have been `I`
        // since it is a lower bound of `AtEnd` and ordered before the current `I`
        // in the set).
        Replaces.erase(I);
        Replaces.insert(new Replacement(NewR));
        return Error.success();
      }
    }

    // `I` is the smallest iterator (after `R`) whose entry cannot overlap.
    // If that is begin(), there are no overlaps.
    //  if (I == Replaces.begin()) {
    //    Replaces.insert(R);
    //    return llvm::Error::success();
    //  }
    if (I.$eq(Replaces.begin())) {
      Replaces.insert(new Replacement(R));
      return Error.success();
    }

    //  --I;
    I.$dec(1);

    //  auto Overlap = [](const Replacement &R1, const Replacement &R2) -> bool {
    //    return Range(R1.getOffset(), R1.getLength())
    //        .overlapsWith(Range(R2.getOffset(), R2.getLength()));
    //  };
    BiFunction<Replacement, Replacement, Boolean> Overlap
            = (/*const Replacement &*/R1, /*const Replacement &*/ R2) -> new Range(R1.getOffset(), R1.getLength())
            .overlapsWith(new Range(R2.getOffset(), R2.getLength()));

    // If the previous entry does not overlap, we know that entries before it
    // can also not overlap.
    if (!Overlap.apply(R, I.$star())) {
      // If `R` and `I` do not have the same offset, it is safe to add `R` since
      // it must come after `I`. Otherwise:
      //   - If `R` is an insertion, `I` must not be an insertion since it would
      //   have come after `AtEnd`.
      //   - If `R` is not an insertion, `I` must be an insertion; otherwise, `R`
      //   and `I` would have overlapped.
      // In either case, we can safely insert `R`.

      Replaces.insert(new Replacement(R));
    } else {
      // `I` overlaps with `R`. We need to check `R` against all overlapping
      // replacements to see if they are order-independent. If they are, merge `R`
      // with them and replace them with the merged replacements.
      //    auto MergeBegin = I;
      //    auto MergeEnd = std::next(I);
      iterator<Replacement> MergeBegin = I.clone();
      iterator<Replacement> MergeEnd = std.next(I);
      while (I.$noteq(Replaces.begin())) {
        I.$dec(1);
        // If `I` doesn't overlap with `R`, don't merge it.
        //      if (!Overlap(R, *I))
        //        break;
        //      MergeBegin = I;
        if (!Overlap.apply(R, I.$star())) {
          break;
        }
        MergeBegin = I.clone();
      }
      Replacements OverlapReplaces = new Replacements(MergeBegin, MergeEnd);
      try {
        Expected<Replacements> Merged
                = OverlapReplaces.mergeIfOrderIndependent(R);

        try {
          if (!Merged.$bool()) {
            return Merged.takeError();
          }

          Replaces.erase(MergeBegin, MergeEnd);
          Replaces.insert(Merged.$arrow().begin(), Merged.$arrow().end());
        } finally {
          Merged.$destroy();
        }
      } finally {
        OverlapReplaces.$destroy();
      }
    }
    return Error.success();
  }

  /// Merges \p Replaces into the current replacements. \p Replaces
  /// refers to code after applying the current replacements.
  public Replacements merge(/*const*/Replacements /*&*/ ReplacesToMerge) /*const*/ {
    //  if (empty() || ReplacesToMerge.empty())
    //    return empty() ? ReplacesToMerge : *this;
    if (empty() || ReplacesToMerge.empty())
      return empty()
              ? new Replacements(ReplacesToMerge)
              : new Replacements(this);

    //  auto &First = Replaces;
    std.setType<Replacement> First = Replaces;
    //  auto &Second = ReplacesToMerge.Replaces;
    std.setType<Replacement> Second = ReplacesToMerge.Replaces;

    // Delta is the amount of characters that replacements from 'Second' need to
    // be shifted so that their offsets refer to the original text.
    int Delta = 0;
    //  ReplacementsImpl Result;
    std.setType<Replacement> Result = new std.setType<>();

    // Iterate over both sets and always add the next element (smallest total
    // Offset) from either 'First' or 'Second'. Merge that element with
    // subsequent replacements as long as they overlap. See more details in the
    // comment on MergedReplacement.
    //  for (auto FirstI = First.begin(), SecondI = Second.begin();
    //       FirstI != First.end() || SecondI != Second.end();) {
    iterator<Replacement> FirstI = First.begin();
    iterator<Replacement> SecondI = Second.begin();
    while (FirstI.$noteq(First.end()) || SecondI.$noteq(Second.end())) {
      boolean NextIsFirst = SecondI.$eq(Second.end())
              || (FirstI.$noteq(First.end())
              && FirstI.$arrow().getOffset() < SecondI.$arrow().getOffset() + Delta);
//    MergedReplacement Merged(NextIsFirst ? *FirstI : *SecondI, NextIsFirst,
//                             Delta);
      MergedReplacement Merged =
              new MergedReplacement(NextIsFirst ? FirstI.$star() : SecondI.$star(),
                      NextIsFirst, Delta);

//    ++(NextIsFirst ? FirstI : SecondI);
      if (NextIsFirst)
        FirstI.$preInc();
      else
        SecondI.$preInc();

//    while ((Merged.mergeSecond() && SecondI != Second.end()) ||
//           (!Merged.mergeSecond() && FirstI != First.end())) {
      while ((Merged.mergeSecond() && SecondI.$noteq(Second.end())) ||
              (!Merged.mergeSecond() && FirstI.$noteq(First.end()))) {
//      auto &I = Merged.mergeSecond() ? SecondI : FirstI;
        iterator<Replacement> /*&*/ I = Merged.mergeSecond() ? SecondI : FirstI;
//      if (Merged.endsBefore(*I))
//        break;
        if (Merged.endsBefore(I.$star()))
          break;
//      Merged.merge(*I);
        Merged.merge(I.$star());
//      ++I;
        I.$inc(1);
      }
//    Delta -= Merged.deltaFirst();
      Delta -= Merged.deltaFirst();
//    Result.insert(Merged.asReplacement());
      Result.insert(Merged.asReplacement());
    }

    //  return Replacements(Result.begin(), Result.end());
    return new Replacements(Result.begin(), Result.end());
  }

  // Returns the affected ranges in the changed code.
  public vector<Range> getAffectedRanges() /*const*/ {
    //  std::vector<Range> ChangedRanges;
    std.vector<Range> ChangedRanges = new std.vector<>(new Range());
    int Shift = 0;
    //  for (const auto &R : Replaces) {
    //    unsigned Offset = R.getOffset() + Shift;
    //    unsigned Length = R.getReplacementText().size();
    //    Shift += Length - R.getLength();
    //    ChangedRanges.push_back(Range(Offset, Length));
    //  }
    for (Replacement R : Replaces) {
      int Offset = R.getOffset() + Shift;
      int Length = R.getReplacementText().size();
      Shift += Length - R.getLength();
      ChangedRanges.push_back(new Range(Offset, Length));
    }
    //  return combineAndSortRanges(ChangedRanges);
    return ReplacementStatics.combineAndSortRanges(ChangedRanges);
  }

  // Returns the new offset in the code after replacements being applied.
  // Note that if there is an insertion at Offset in the current replacements,
  // \p Offset will be shifted to Offset + Length in inserted text.
  public int getShiftedCodePosition(int Position) {
    //  unsigned Offset = 0;
    int Offset = 0;
    //  for (const auto &R : Replaces) {
    //    if (R.getOffset() + R.getLength() <= Position) {
    //      Offset += R.getReplacementText().size() - R.getLength();
    //      continue;
    //    }
    //    if (R.getOffset() < Position &&
    //        R.getOffset() + R.getReplacementText().size() <= Position) {
    //      Position = R.getOffset() + R.getReplacementText().size();
    //      if (!R.getReplacementText().empty())
    //        Position--;
    //    }
    //    break;
    //  }
    for (Replacement R : Replaces) {
      if (R.getOffset() + R.getLength() <= Position) {
        Offset += R.getReplacementText().size() - R.getLength();
        continue;
      }
      if (R.getOffset() < Position &&
              R.getOffset() + R.getReplacementText().size() <= Position) {
        Position = R.getOffset() + R.getReplacementText().size();
        if (!R.getReplacementText().empty()) {
          Position--;
        }
      }
    }
    //  return Position + Offset;
    return Position + Offset;
  }

  public int size() /*const*/ {
    return Replaces.size();
  }

  public void clear() {
    Replaces.clear();
  }

  public boolean empty() /*const*/ {
    return Replaces.empty();
  }

  public setType.iterator<Replacement> begin() /*const*/ {
    return Replaces.begin();
  }

  public setType.iterator<Replacement> end() /*const*/ {
    return Replaces.end();
  }

  public std.reverse_iterator<Replacement> rbegin() /*const*/ {
    return Replaces.rbegin();
  }

  public std.reverse_iterator<Replacement> rend() /*const*/ {
    return Replaces.rend();
  }

  public boolean $eq(/*const*/Replacements /*&*/ RHS) {
    return Replaces.$eq(RHS.Replaces);
  }

  // Returns `R` with new range that refers to code after `Replaces` being
  // applied.
  public Replacement getReplacementInChangedCode(/*const*/Replacement /*&*/ R) /*const*/ {
    //  unsigned NewStart = getShiftedCodePosition(R.getOffset());
    //  unsigned NewEnd = getShiftedCodePosition(R.getOffset() + R.getLength());
    //  return Replacement(R.getFilePath(), NewStart, NewEnd - NewStart,
    //                     R.getReplacementText());

    int NewStart = getShiftedCodePosition(R.getOffset());
    int NewEnd = getShiftedCodePosition(R.getOffset() + R.getLength());
    assert NewEnd > NewStart;
    return new Replacement(R.getFilePath(), NewStart, NewEnd - NewStart, R.getReplacementText());
  }

  // Returns a set of replacements that is equivalent to the current
  // replacements by merging all adjacent replacements. Two sets of replacements
  // are considered equivalent if they have the same effect when they are
  // applied.
  public Replacements getCanonicalReplacements() /*const*/ {
    // std::vector<Replacement> NewReplaces;
    std.vector<Replacement> NewReplaces
            = new std.vector(/*default value*/ new Replacement());
    // Merge adjacent replacements.

    //  for (const auto &R : Replaces) {
    //    if (NewReplaces.empty()) {
    //      NewReplaces.push_back(R);
    //      continue;
    //    }
    //    auto &Prev = NewReplaces.back();
    //    unsigned PrevEnd = Prev.getOffset() + Prev.getLength();
    //    if (PrevEnd < R.getOffset()) {
    //      NewReplaces.push_back(R);
    //    } else {
    //      assert(PrevEnd == R.getOffset() &&
    //             "Existing replacements must not overlap.");
    //      Replacement NewR(
    //          R.getFilePath(), Prev.getOffset(), Prev.getLength() + R.getLength(),
    //          (Prev.getReplacementText() + R.getReplacementText()).str());
    //      Prev = NewR;
    //    }
    //  }
    for (Replacement R : Replaces) {
      if (NewReplaces.empty()) {
        NewReplaces.push_back(R);
        continue;
      }
      Replacement Prev = NewReplaces.back();
      int PrevEnd = Prev.getOffset() + Prev.getLength();
      if (PrevEnd < R.getOffset()) {
        NewReplaces.push_back(R);
      } else {
        assert PrevEnd == R.getOffset();
        Replacement NewR = new Replacement(
                R.getFilePath(), Prev.getOffset(),
                Prev.getLength() + R.getLength(),
                new StringRef(new Twine(Prev.getReplacementText()).concat(new Twine(R.getReplacementText())).str())
        );
        Prev.$assign(NewR);
      }
    }

    //  ReplacementsImpl NewReplacesImpl(NewReplaces.begin(), NewReplaces.end());
    setType<Replacement> NewReplacesImpl = new setType<>(NewReplaces.begin(), NewReplaces.end());

    //  return Replacements(NewReplacesImpl.begin(), NewReplacesImpl.end());
    return new Replacements(NewReplacesImpl.begin(), NewReplacesImpl.end());
  }

  // If `R` and all existing replacements are order-independent, then merge it
  // with `Replaces` and returns the merged replacements; otherwise, returns an
  // error.
  public Expected<Replacements>
  mergeIfOrderIndependent(/*const*/Replacement /*&*/ R) /*const*/ {
    //    Replacements Rs(R);
    Replacements Rs = new Replacements(R);
    // A Replacements set containing a single replacement that is `R` referring to
    // the code after the existing replacements `Replaces` are applied.
    // Replacements RsShiftedByReplaces(getReplacementInChangedCode(R));
    Replacements RsShiftedByReplaces
            = new Replacements(getReplacementInChangedCode(R));
    // A Replacements set that is `Replaces` referring to the code after `R` is
    // applied.
    // Replacements ReplacesShiftedByRs;
    Replacements ReplacesShiftedByRs = new Replacements();
    //    for (const auto &Replace : Replaces)
    //      ReplacesShiftedByRs.Replaces.insert(
    //         Rs.getReplacementInChangedCode(Replace));
    for (Replacement Replace : Replaces) {
      ReplacesShiftedByRs.Replaces.insert(Rs.getReplacementInChangedCode(Replace));
    }

    // This is equivalent to applying `Replaces` first and then `R`.
    // auto MergeShiftedRs = merge(RsShiftedByReplaces);
    Replacements MergeShiftedRs = merge(RsShiftedByReplaces);
    // This is equivalent to applying `R` first and then `Replaces`.
    // auto MergeShiftedReplaces = Rs.merge(ReplacesShiftedByRs);
    Replacements MergeShiftedReplaces = Rs.merge(ReplacesShiftedByRs);

    // Since empty or segmented replacements around existing replacements might be
    // produced above, we need to compare replacements in canonical forms.
    //    if (MergeShiftedRs.getCanonicalReplacements() ==
    //        MergeShiftedReplaces.getCanonicalReplacements())
    //      return MergeShiftedRs;
    if (MergeShiftedRs.getCanonicalReplacements().$eq(MergeShiftedReplaces.getCanonicalReplacements()))
      return new Expected(JavaDifferentiators.JD$Convertible.INSTANCE, MergeShiftedRs);

    //    return llvm::make_error<ReplacementError>(replacement_error::overlap_conflict,
    //                                              R, *Replaces.begin());
    return new Expected(AdtsupportLlvmGlobals.make_error(
            replacement_error.overlap_conflict, R, /*P*/ Replaces.begin().$star()));
  }

  @Override
  public void $destroy() {
    if (Replaces != null) {
      Replaces.$destroy();
    } else {
      throw new IllegalStateException("Replaces can't be null!");
    }
  }
}
