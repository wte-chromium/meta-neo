KV = "4.1.21"
SRCDATE = "20170424"
GCC = "6.3.0"

require nexttv-dvb-modules.inc

SRC_URI = "http://source.mynonpublic.com/xtrend/${MACHINE}-drivers-${KV}-${GCC}-${SRCDATE}.zip"

SRC_URI[md5sum] = "90e18d1bb2ff14d8062dc75a21ac58d0"
SRC_URI[sha256sum] = "1768f70d39434afd41f6d2c368c4bc68a17ee04ad871baa480bf16919a31950c"

COMPATIBLE_MACHINE = "et7000mini"
