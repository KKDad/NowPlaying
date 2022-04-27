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
- [Parsing Google’s Now Playing History on Pixel Devices](https://dfir.pubpub.org/pub/xbvsrjt5/release/1)
- [How to Install and Use ADB, the Android Debug Bridge Utility](https://www.howtogeek.com/125769/how-to-install-and-use-abd-the-android-debug-bridge-utility/)

### Top entries

And here's the top artists that my phone has identified over a 18-month window. The # one entry is a complete mystery to me as I hate rap music.
~~~
post malone, 66
red hot chili peppers, 60
madonna, 57
ed sheeran, 56
shawn mendes, 52
city and colour, 50
rush, 48
taylor swift, 47
maroon 5, 45
peter gabriel, 41
johnny cash, 41
elvis presley, 38
inxs, 37
the killers, 36
tears for fears, 35
pink floyd, 33
jonas brothers, 33
michael jackson, 31
the cranberries, 30
coldplay, 30
the weeknd, 29
pet shop boys, 29
halsey, 29
elton john, 29
alessia cara, 29
~~~