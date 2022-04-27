Quick program to grab some statistics from the "Now Playing" data file copied from my phone.

### Quick Guide
1. Grab a backup of com.google.intelligence.sense
~~~
./adb backup -noapk com.google.intelligence.sense
~~~
2. Convert backup to a tar file
~~~
dd if=backup.ab bs=24 skip=1|openssl zlib -d > mybackup.tar
~~~
3. Extract history_db
4. Profit

### References
[Parsing Google’s Now Playing History on Pixel Devices](https://dfir.pubpub.org/pub/xbvsrjt5/release/1)
[How to Install and Use ADB, the Android Debug Bridge Utility](https://www.howtogeek.com/125769/how-to-install-and-use-abd-the-android-debug-bridge-utility/)