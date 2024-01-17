 * This program adds columns to a Smartsheet sheet.
 * - The columns are added based on the column_names.txt file.
 * - The column_names.txt file is a list of column names, each on a new line.
 * - The first column added will be at the rightmost end of the target sheet.
 * - The column names are added to the sheet in the order they appear in the file.
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
import com.smartsheet.api.models.enums.ColumnType;

public class AddSheetColumns {
    public static void main(String args[]) throws IOException, SmartsheetException {
        // Set access token for Smartsheet API
        Smartsheet smartsheet = SmartsheetFactory.createDefaultClient("ACCESS TOKEN HERE");
        // Read column_names.txt to provide list of column names
        List<String> content = Files.readAllLines(Path.of("app\\src\\main\\java\\smartsheetdev\\column_names.txt"));
        // Target sheet id
        long sheetId = "SHEET ID HERE";
        // Add columns to target sheet
        int index = 0;
		int endIndex = 0; // Specify the index of the last column in the sheet
        for (String s : content) {
            List<Column> newColumns = Arrays.asList(new Column().setTitle(content.get(index)).setType(ColumnType.TEXT_NUMBER).setIndex(endIndex)); 
            smartsheet.sheetResources().columnResources().addColumns(sheetId, newColumns);
            index++;
        }
    }
}