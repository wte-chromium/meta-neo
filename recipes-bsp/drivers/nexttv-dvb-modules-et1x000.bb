KV = "4.1.37"
SRCDATE = "20170918"
GCCREV = "6.2.0"

require nexttv-dvb-modules.inc

SRC_URI = "http://gi-et.info/et1x000/${MACHINE}-drivers-${KV}-${GCCREV}-${SRCDATE}.zip"

SRC_URI[md5sum] = "8e817d3bc25088b07180e75d83330091"
SRC_URI[sha256sum] = "3963d0938541d587fb5eaab9baa68993c30d4ea062151fd4407605027e043d30"

COMPATIBLE_MACHINE = "et1x000"