/*
 * This program works with Automation Rules.
 */
package smartsheetdev;

import com.smartsheet.api.Smartsheet;
import com.smartsheet.api.SmartsheetException;
import com.smartsheet.api.SmartsheetFactory;
import com.smartsheet.api.models.AutomationRule;
import com.smartsheet.api.models.PagedResult;

public class AutomationRules {
    public static void main(String args[]) throws SmartsheetException {
        // Set access token for Smartsheet API
        Smartsheet smartsheet = SmartsheetFactory.createDefaultClient("ACCESS TOKEN HERE");
        // Sheet to act on
        long sheetId = "SHEET ID HERE";
        // Print sheet title
        // System.out.println(smartsheet.sheetResources().getSheet(sheetId, null, null, null, null, null, null, null).getName());
        // List all automation rules (SINGLE STEP ONLY)
        PagedResult<AutomationRule> automationRules = smartsheet.sheetResources().automationRuleResources().listAutomationRules(
        sheetId, // sheetId
        null // PaginationParameters
        );
        // Print the names of all automation rules
        for (AutomationRule automationRule : automationRules.getData()) {
            System.out.println(automationRule.getName());
        }
    }
}