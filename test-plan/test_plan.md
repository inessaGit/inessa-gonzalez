

### Test plan strategy: 
1. Identify types of test that's needed for robust coverage e.g : 
- Unit, Integration, UI, Functional, Regression, Internazionalization, Security, Performance etc
2. For each test type identify goals, resources needed, potential tools, estimate time needed to implement e.g for Unit tests: 
- Goal : automation to minimize execution time when your tests have no Android framework dependencies or when you can mock the Android framework dependencies
- Tools:Mockito to test Android API calls in your local unit tests, JUnit , Appium, Gradle
- Timeframe: TBD
- Resources: DEV/SDET

3. For each test type break application into modules e.g for Monefy app :
- Categories module
- Accounts module
- Currencies module
- Settings module
4. For each module indentify core functionality: 
- e.g Monefy - Settings module - Monefy pro Multi currency component - ability to track multiple accounts in different currencies
- e.g Monefy - Settings module - Monefy pro component Syncronization - ability to use app on multiple devices 
5. For each core functionality create set of test cases e.g for Monefy app: 
- TC1: Consumer user should be able to install app 
- TC2: Consumer user should be able to unistall app 
- TC3: Consumer user should be able to sign up for an account 
- TC4: Consumer user should be able to log in and log out
- TC5: Consumer user should be able to switch language (English/Ukranian/Russian)
- TC6: Consumer user should be able to see titles on the home screen on app load
- TC7: Consumer user should be able to upgrade to a Monefy pro premium plan
- TC8: Monefy Pro user should be able to setup a 4 digit passcode
- TC9: Consumer user should be able to create back up file 
- TC 10: Consumer user should be able to clear all data 

### Links: 
- [Screen resolution and physical dimensions](https://mydevice.io/devices/)
- [Android API support](https://developer.android.com/about/dashboards/index.html#OpenGL)
- [Apple App store review](https://developer.apple.com/app-store/review/guidelines/)
- [Google play stats on devices/OS] (https://developer.android.com/about/dashboards/index.html)

Test type | Native iOS app | Native Android app | Web app | Web mobile optimized| Questions/Roadblocks
------------ | -------------|--------------|---------------|--------------------|---------------------
Cross browser/platform | iPhone 5,6,7,X, iPad Air 2,Mini 2, 4 ,Pro| Samsung Galaxy S5,S6,S7 Lollipop 5.1, Marshmallow 6.0, Nougat 7.0 , 
Virtual machines/Emulators  | [Apple developer Xcode](https://developer.apple.com/documentation) iOS simulator comes with Xcode| [Andoid Studio](https://developer.android.com/studio), [Android Firebase](https://firebase.google.com/docs/test-lab), [AWS Device Farm](https://docs.aws.amazon.com/devicefarm/latest/developerguide/welcome.html)
Unit | **Tools**: Automator, XCTest **Resources**: DEV/SDET | **Tools**:Mockito to test Android API calls in your local unit tests,JUnit, UI Automator, Gradle **Resources**: DEV/SDET
Integration  (components within your app only) | TBD|TBD
Integration  (cross-app components) | Integration with Dropbox sync|e.g Integration with Facebook Graph API,Google Maps Static Maps API ,Google Maps Javascript API 
UI  | [iOS Human Interface Guidlines](https://developer.apple.com/ios/human-interface-guidelines/overview/themes/)|[Android UI Guidlines](https://developer.android.com/guide/practices/ui_guidelines/index.html)
Functional  | see examples above| 
Regression  | set of test cases for manual regression; set of test cases which are candidates for automation; set of automated test cases | 
Usability  |[iOS Human Interface Guidlines](https://developer.apple.com/ios/human-interface-guidelines/overview/themes/)|[Android UI Guidlines](https://developer.android.com/guide/practices/ui_guidelines/index.html)
Internationalization | TBD|TBD
Security  | TBD |TBD
Performance   |**Tools**: Hardware IO Tools for XCode - Network Link Conditioner,  |**Tools**: Android Emulator, Performance Monitoring SDK , Firebase Performance Monitoring Automatic Traces|**Tools**: Chrome DevTools - Network panel,JMeter
