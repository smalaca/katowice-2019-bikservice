Narrative:
Bank Client have got invalid history in BIK

Scenario: Bank Client have got an invalid history in BIK
Given bank client with pesel
When ask for status in bik
Then status is invalid