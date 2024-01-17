/*
 * This program returns the formulas for each column in a Smartsheet sheet.
 */
package smartsheetdev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.smartsheet.api.Smartsheet;
import com.smartsheet.api.SmartsheetException;
import com.smartsheet.api.SmartsheetFactory;
import com.smartsheet.api.models.Column;
import com.smartsheet.api.models.PagedResult;


public class GetSheetFormulas {
    public static void main(String args[]) throws IOException, SmartsheetException {
        // Set access token for Smartsheet API
        Smartsheet smartsheet = SmartsheetFactory.createDefaultClient("ACCESS TOKEN HERE");
        // Target sheet id
        long sheetId = "SHEET ID HERE";
        // Get sheet columns
        PagedResult<Column> columns = smartsheet.sheetResources().columnResources().listColumns(sheetId, null, null);
        // Write all column formulas to a new text file called column_formulas.txt, ignoring empty formulas
        // Update existing column_formulas.txt file
        Path path = Path.of("app\\src\\main\\java\\smartsheetdev\\column_formulas.txt");
        List<String> lines = Arrays.asList("");
        Files.write(path, lines);
        for (Column column : columns.getData()) {
            if (column.getFormula() != null) {
                Files.write(path, Arrays.asList(column.getTitle() + ": " + column.getFormula()), java.nio.file.StandardOpenOption.APPEND);
            }
        }
    }    
}
