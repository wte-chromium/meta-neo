KV = "4.4.8"
SRCDATE = "20170424"
GCC = "6.3.0"

SRC_URI = "https://github.com/neo-pli-bsps/meta-xtrend/releases/download/Binaries-1.0/et7x00-drivers-4.4.8-6.3.0-${SRCDATE}.zip"

require nexttv-dvb-modules.inc

SRC_URI[md5sum] = "ffb420f7fe0c00603cf3f4d063828cf6"
SRC_URI[sha256sum] = "48f9e09b23081eeab860c41aed08b0d9fbb1a60ab47b85d80322c2897df55e51"
