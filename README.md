Requirements:
----------------------------
- Chrome browser: version 90.
- selenium-chrome-driver: 4.0.0-beta-3
- junit: 5.7.1

Tests
----------------------------
    Case 1: Welcome page: all required elements are displayed
    1. Go to Welcome page: https://www.yellowtailwine.com
    2. Verify that “I am of legal drinking age in” is displayed
    3. Verify that checkbox before “I am of legal drinking age in” is displayed
    4. Verify that dropdown with Select is displayed
    5. Verify that “Welcome” button is displayed and is inactive

    Case 2: Main page: navigate to main page as European customer
    1. Tick on checkbox
    2. Select “Europe” from dropbox
    3. Press “Welcome” button
    4. Main page should be displayed
    
    Case 3: Main page: all required elements are displayed
    1. Navigate to main page
    2. Verify that the following elements are displayed:
    - menu button
    - WELCOME TO THE WORLD OF [Yellow tail]
    - We are passionate about creating great tasting, quality wines for everyone to enjoy
    - find your wine button
    - footer
    
    Case 4: Main page: Menu button logic (open header)
    1. Navigate to main page
    2. Click on Menu button
    3. Verify that header with all needed links is appeared
    4. Click on [yellow tail]
    5. Verify that Menu button is visible
    
    Case 5: Main page: Menu button logic (close header)
    1. Navigate to main page
    2. Click on Menu button
    3. Click on [yellow tail]
    4. Verify that Menu button is visible
    
    Case 6: Main page: Global Nav logic
    1. Navigate to main page
    2. Click on Menu button
    3. Click on Globe icon
    4. Select China in popup and click on it
    5. Verify that language is changed
    
    Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    1. Navigate to main page
    2. Click on Menu button
    3. Click on Globe icon
    4. Select China in popup and click on it
    5. Click on icon ( in white square on screenshot)
    6. Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
    
    Case 8: Where to buy: enter valid postal code
    1. Navigate to “Where to buy” page
    2. Enter valid data in “Your location” field
    3. Click on Search button
    4. Verify that the results of search are displayed    
    
    Case 9: Cocktails: Select one wine
    1. Navigate to “Cocktails” page
    2. Select “Red wine cocktails”
    3. Verify that 7 recipes are displayed
    
    Case 10: Cocktails: Navigate to Cocktail recipe page
    1. Navigate to “Cocktails” page
    2. Scroll to “RASPBERRY ROSÉ” recipe
    3. Click on “RASPBERRY ROSÉ” recipe
    4. Verify that new page is displayed:
    - ingredients section is displayed
    
    Case 11: Cocktails: Select several wines
    1. Navigate to “Cocktails” page
    2. Select “Red wine cocktails”
    3. Select “Sparkling wine cocktails”
    4. Verify that “Multiple” word is displayed in “Type” dropdown
    5. Verify that 18 recipes are displayed