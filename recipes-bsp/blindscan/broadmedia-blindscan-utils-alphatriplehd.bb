SUMMARY = "Utilities for transponder & dvb-c blindscan"
SECTION = "base"
PRIORITY = "optional"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "CLOSED"

PROVIDES += "virtual/blindscan-dvbc"
RPROVIDES_${PN} += "virtual/blindscan-dvbc"

SRC_URI = "http://source.mynonpublic.com/broadmedia/broadmedia-dvbc-blindscan-1.1.zip"

PV = "1.0"
PR = "r0"

S = "${WORKDIR}/"

do_compile() {
}

do_install() {
    install -d ${D}/${bindir}/
    install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
}

SRC_URI[md5sum] = "04475b40f25460cead27285f103a0f50"
SRC_URI[sha256sum] = "2e0c285ee8768e8a342ca8ba97f3b1238e3ebc2dcb1b71c4803c532c94804478"
