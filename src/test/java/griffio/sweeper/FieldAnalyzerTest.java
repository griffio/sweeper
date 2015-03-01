package griffio.sweeper;

import com.google.common.io.Resources;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.google.common.truth.Truth.ASSERT;

public class FieldAnalyzerTest {

    private static String fixture(String resource) throws IOException {
        return Resources.toString(Resources.getResource(resource), StandardCharsets.UTF_8);
    }

    @Test
    public void analyze_4x4_no_mines() throws Exception {
        String expected = fixture("4x4_field_no_mines.txt");
        FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(4, 4);
        StringBuilder actual = new StringBuilder();
        fieldAnalyzer.printField(actual);
        ASSERT.that(actual.toString()).isEqualTo(expected);
    }

    @Test
    public void analyze_4x4_2_mines() throws Exception {
        String expected = fixture("4x4_field_2_mines.txt");
        FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(4, 4);
        fieldAnalyzer.placeMine(2, 1);
        fieldAnalyzer.placeMine(3, 3);
        StringBuilder actual = new StringBuilder();
        fieldAnalyzer.printField(actual);
        ASSERT.that(actual.toString()).isEqualTo(expected);
    }

    @Test
    public void analyze_4x2_2_mines() throws Exception {
        String expected = fixture("4x4_hint_2_mines.txt");
        FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(4, 4);
        fieldAnalyzer.placeMine(2, 1);
        fieldAnalyzer.placeMine(3, 3);
        StringBuilder actual = new StringBuilder();
        fieldAnalyzer.printHints(actual);
        ASSERT.that(actual.toString()).isEqualTo(expected);
    }

}