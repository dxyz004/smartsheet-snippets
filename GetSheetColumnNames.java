/*
 * This program returns the column names for each column in a Smartsheet sheet.
 */
package smartsheetdev;

import java.io.IOException;
import com.smartsheet.api.Smartsheet;
import com.smartsheet.api.SmartsheetException;
import com.smartsheet.api.SmartsheetFactory;
import com.smartsheet.api.models.Column;
import com.smartsheet.api.models.PagedResult;


public class GetSheetColumnNames {
    public static void main(String args[]) throws IOException, SmartsheetException {
        // Set access token for Smartsheet API
        Smartsheet smartsheet = SmartsheetFactory.createDefaultClient("ACCESS TOKEN HERE");
        // Target sheet id
        long sheetId = "SHEET ID HERE";
        // Get sheet columns
        PagedResult<Column> columns = smartsheet.sheetResources().columnResources().listColumns(sheetId, null, null);
        // Print column names
        for (Column c: columns.getData()) {
            System.out.println(c.getTitle());
        }
    }    
}
