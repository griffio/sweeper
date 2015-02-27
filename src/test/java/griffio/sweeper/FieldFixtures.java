package griffio.sweeper;

public class FieldFixtures {

  public static String[] FourByFour = {"4 4\n*...\n....\n.*..\n....\n", "Field #%d:\n*100\n2210\n1*10\n1110\n"};
  public static String[] ThreeByFive = {"3 5\n**...\n.....\n.*...\n", "Field #%d:\n**100\n33200\n1*100\n"};
  public static String EOI = "0 0\n";

  public static String Input_FourByFour = FourByFour[0] + EOI;
  public static String Expected_FourByFour = String.format(FourByFour[1], 1);

  public static String Input_ThreeByFive = ThreeByFive[0] + EOI;
  public static String Expected_ThreeByFive = String.format(ThreeByFive[1], 1);

  public static String Input_FourByFour_ThreeByFive = FourByFour[0] + ThreeByFive[0] + EOI;
  public static String Expected_FourByFour_ThreeByFive = String.format(FourByFour[1] + "\n" + ThreeByFive[1], 1, 2);

}
