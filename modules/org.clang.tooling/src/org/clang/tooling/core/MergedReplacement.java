/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.clang.tooling.core;

import org.clang.tooling.core.Replacement;
import org.clank.java.std;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;

/**
 *
 * @author Zahar.Koval
 */
public class MergedReplacement {
  private boolean MergeSecond;

  // Amount of characters that elements from 'Second' need to be shifted by in
  // order to refer to the original text.
  private int Delta;

  // Sum of all deltas (text-length - length) of elements from 'First' merged
  // into this element. This is used to update 'Delta' once the
  // MergedReplacement is completed.
  private int DeltaFirst;

  // Data of the actually merged replacement. FilePath and Offset aren't changed
  // as the element is only extended to the right.
  private final StringRef FilePath;
  private int Offset;
  private int Length;
  private std.string Text;

  public MergedReplacement(Replacement /*const  &*/ R,
      boolean MergeSecond, int D) {
    this.MergeSecond = MergeSecond;
    this.Delta = D;
    this.FilePath = new StringRef(R.getFilePath());
    this.Offset = R.getOffset() + (MergeSecond ? 0 : Delta);
    this.Length = R.getLength();
    this.Text = R.getReplacementText().$string();

    this.Delta += MergeSecond ? 0 : Text.size() - Length;
    this.DeltaFirst = MergeSecond ? Text.size() - Length : 0;
  }

  public MergedReplacement() {
    this.MergeSecond = false;
    this.Delta = 0;
    this.DeltaFirst = 0;
    this.FilePath = new StringRef();
    this.Offset = 0;
    this.Length = 0;
    this.Text = new std.string();
  }

  public MergedReplacement(MergedReplacement /*const&*/ other) {
    this.MergeSecond = other.MergeSecond;
    this.Delta = other.Delta;
    this.DeltaFirst = other.DeltaFirst;
    this.FilePath = new StringRef(other.FilePath);
    this.Offset = other.Offset;
    this.Length = other.Length;
    this.Text = new std.string(other.Text);
  }

  public MergedReplacement(JD$Move _dparam, MergedReplacement /*&&*/ other) {
    this.MergeSecond = other.MergeSecond;
    this.Delta = other.Delta;
    this.DeltaFirst = other.DeltaFirst;
    this.FilePath = new StringRef(JD$Move.INSTANCE, other.FilePath);
    this.Offset = other.Offset;
    this.Length = other.Length;
    this.Text = new std.string(JD$Move.INSTANCE, other.Text);
  }

  public void merge(Replacement /*const&*/ R) {
    if (MergeSecond) {
      //      unsigned REnd = R.getOffset() + Delta + R.getLength();
      int REnd = R.getOffset() + Delta + R.getLength();
      //      unsigned End = Offset + Text.size();
      int End = Offset + Text.size();
      //      if (REnd > End) {
      //        Length += REnd - End;
      //        MergeSecond = false;
      //      }
      if (REnd > End) {
        Length += REnd - End;
        MergeSecond = false;
      }
      //      StringRef TextRef = Text;
      StringRef TextRef = new StringRef(Text);

      //      StringRef Head = TextRef.substr(0, R.getOffset() + Delta - Offset);
      StringRef Head = TextRef.substr(0, R.getOffset() + Delta - Offset);

      //      StringRef Tail = TextRef.substr(REnd - Offset);
      StringRef Tail = TextRef.substr(REnd - Offset);

      //      Text = (Head + R.getReplacementText() + Tail).str();
      Text = new Twine(Head)
          .concat(new Twine(R.getReplacementText()))
          .concat(new Twine(Tail))
          .str();
      //      Delta += R.getReplacementText().size() - R.getLength();
      Delta += R.getReplacementText().size() - R.getLength();
    } else {
      //      unsigned End = Offset + Length;
      int End = Offset + Length;
      //      StringRef RText = R.getReplacementText();
      StringRef RText = new StringRef(R.getReplacementText());
      //      StringRef Tail = RText.substr(End - R.getOffset());
      StringRef Tail = RText.substr(End - R.getOffset());
      //      Text = (Text + Tail).str();
      Text = new Twine(Text).concat(new Twine(Tail)).str();

      // copy-pasted from c++
      if (R.getOffset() + RText.size() > End) {
        Length = R.getOffset() + R.getLength() - Offset;
        MergeSecond = true;
      } else {
        Length += R.getLength() - RText.size();
      }
      DeltaFirst += RText.size() - R.getLength();
    }
  }

  // Returns 'true' if 'R' starts strictly after the MergedReplacement and thus
  // doesn't need to be merged.
  public boolean endsBefore(Replacement /*const&*/ R) /*const*/ {
    if (MergeSecond)
      return Offset + Text.size() < R.getOffset() + Delta;
    return Offset + Length < R.getOffset();
  }

  // Returns 'true' if an element from the second set should be merged next.
  public boolean mergeSecond() /*const*/ {
    return MergeSecond;
  }

  public int deltaFirst() /*const*/ {
    return DeltaFirst;
  }

  public Replacement asReplacement() /*const*/ {
    return new Replacement(FilePath, Offset, Length, new StringRef(Text));
  }

}
