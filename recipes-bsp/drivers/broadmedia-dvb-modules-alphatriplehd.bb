SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.1.24"
GCCREV = "4.9.1"
SRCDATE = "20170508"

SRC_URI[md5sum] = "3a10e7abbd0228cadb0b189aa5a94b32"
SRC_URI[sha256sum] = "6ada5de766887a245c0f3fcf1031112628fcee40bd11f2dda781bb07cc5792fe"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI = "http://dvbstand.com/alphatriplehd/drivers/alphatriple-drivers-${KV}-${GCCREV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    install -m 0755 ${WORKDIR}/linuxtv.ko ${D}/lib/modules/${KV}/extra
    echo linuxtv >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

