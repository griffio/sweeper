package griffio.sweeper;

import com.google.common.collect.Table;

import java.util.Map;

public class HintTablePrinting {

  public static String printHints(int fieldIndex, Table<Integer, Integer, String> hints) {
    StringBuilder result = new StringBuilder("Field #").append(fieldIndex).append(":").append("\n");
    for (Integer row : hints.rowKeySet()) {
      Map<Integer, String> rowHints = hints.row(row);
      for (String hint : rowHints.values()) {
        result.append(hint);
      }
      result.append("\n");
    }
    return result.toString();
  }

}
