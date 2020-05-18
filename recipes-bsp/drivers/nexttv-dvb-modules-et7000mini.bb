KV = "4.1.21"
SRCDATE = "20170424"
GCC = "6.2.0"

require nexttv-dvb-modules.inc

SRC_URI = "http://gi-et.info/et7000mini/${MACHINE}-drivers-${KV}-${GCC}-${SRCDATE}.zip"

SRC_URI[md5sum] = "6421190b0db6f267ff603aadc25b55b4"
SRC_URI[sha256sum] = "e3a41f228d346db65161738387a601a27fea9ba3ab3cf8c492a7e16452a40659"

COMPATIBLE_MACHINE = "et7000mini"
