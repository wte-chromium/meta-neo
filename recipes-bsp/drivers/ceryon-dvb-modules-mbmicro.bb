SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.0.1"
SRCDATE = "20170829"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "ac07f9c848beb2e5ab034a363d903fef"
SRC_URI[sha256sum] = "cf0879ae33b11a6d1ec5e49328e0bd5843f957fee3bba7dc6075ba0111b6a6eb"

#SRC_URI = "file://ceryon-7000s-dvbdrive-${SRCDATE}.zip"
SRC_URI = "http://source.mynonpublic.com/ceryon/ceryon-7000s-dvbdrive-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    echo "dvbdrive" >> ${D}/${sysconfdir}/modules-load.d/dvbdrive.conf
    install -m 0755 ${WORKDIR}/dvbdrive.ko ${D}/lib/modules/${KV}/extra
    install -d ${D}/etc/rcS.d
}

FILES_${PN} += "${sysconfdir}/modules-load.d/dvbdrive.conf"
