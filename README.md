Note: This project contains modified code from other projects.

Android database code modified from https://www.youtube.com/watch?v=aQAIMY-HzL8

Android NFC code modified from https://medium.com/@ssaurel/create-a-nfc-reader-application-for-android-74cf24f38a6f

# Summary
The goal of this projet was to create a machine workout tracker. There are two systems that interact with each other with this project: an Android app which saves workout data in a local database, and a Raspberry Pi system which measures workout data and transfers it to the phone app for saving.

# Components
- Raspberry Pi B+ 3
- MFRC522 NFC/FRID reader/writer
- 2 buttons
- Wires
- Resistors
- Bread board
- Android phone
- Android Studio project

# Video
The video demonstrating the project can be found [here](https://youtu.be/IvDTyIdZ8Ek)

# Complications
One of the main features of the system was supposed to be its NFC capabilities. I think that NFC is a really cool technology that is rarely used to its full potential. Most of the action it gets in the real world is through phone payements. While undergoing this project, I found a few points when this lack of support showed strongly.

First, the lack of examples made it diffcult to find good documentation on NFC projects that demonstrated data transfer. Using a phone to emulate an NFC/FRID  tag is rather complicated. The fast and responsive nature of NFC comes with some drawbacks. You have to consider what happens if a reader comes in contact with a tag, and you don't want something unexpected to happen. To accomplish this, the appropriate thing to do is register your app and the NFC tags it communicates with with an [AID](https://developer.android.com/guide/topics/connectivity/nfc/hce.html#ServiceSelection). As this process and coding the AID checks lacked robust examples online, I decided to remove card emulation from my android app.

Secondly, I ran into issues when implementing reading NFC data into the Android app. I was able to accomplish reading To demonstrate my idea in practice, but when implementing the writing of tags which can then be read by Android, things started getting odd. Android's way of structuring messages is different than the MFRC522 chip I was using. At this point I called it and decided that I can demonstrate reading NFC with an app, and writing the appropriate data to a tag.

# Conclusion
While I could not sucessfully being my project to a working state, I was satisfied that the two separate parts, the MFRC522 chip and the Android app, are functional individually.  
