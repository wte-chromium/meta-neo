KV = "4.1.21"
SRCDATE = "20170424"
GCC = "6.2.0"

require nexttv-dvb-modules.inc

SRC_URI = "http://xpeedlx.info/${MACHINE}-drivers-${KV}-${GCC}-${SRCDATE}.zip"

SRC_URI[md5sum] = "798e12cfe57d2d982148dd01d88190a4"
SRC_URI[sha256sum] = "97d970168713a43b53e9f0e80946e9acc594b05972c4a3ad68dc916c49f1d3cd"

COMPATIBLE_MACHINE = "xpeedc"
