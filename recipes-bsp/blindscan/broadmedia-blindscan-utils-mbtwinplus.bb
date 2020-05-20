SUMMARY = "Utilities for transponder & dvb-c blindscan"
SECTION = "base"
PRIORITY = "optional"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "CLOSED"

PROVIDES += "virtual/blindscan-dvbc"
RPROVIDES_${PN} += "virtual/blindscan-dvbc"

SRC_URI = "http://source.mynonpublic.com/broadmedia/g300-dvbc-blindscan-1.0.zip"

PV = "1.0"
PR = "r0"

S = "${WORKDIR}/"

do_compile() {
}

do_install() {
    install -d ${D}/${bindir}/
    install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
}

SRC_URI[md5sum] = "cae1ca60b9f15bd240261de5950e4ded"
SRC_URI[sha256sum] = "adaf28b72f9f9bc8a03fd5509f59ad7fb2d8fca4fb7ca4e78ceda7be716b1b07"