Feature: Contact Us Feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows a successful message "Your enquiry has been successfully sent to the store owner!"

Examples:
|SheetName|RowNumber|
|Contactus|0|
|Contactus|1|
|Contactus|2|
|Contactus|3|