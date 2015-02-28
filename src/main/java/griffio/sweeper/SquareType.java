package griffio.sweeper;

public enum SquareType {
  MINE {
    @Override
    public String toString() {
      return "*";
    }
  },
  SAFE {
    @Override
    public String toString() {
      return ".";
    }
  }
}
