SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.10.12"
SRCDATE = "20180523"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "cb8f72af4883443b65941f7b6a7cabb2"
SRC_URI[sha256sum] = "ceba728a108e2697286721680e9edafdf9dc8ce34a598a8faec5d102530a96f8"

SRC_URI = "http://source.mynonpublic.com/ceryon/ceryon-7005s-dvbdrive-${SRCDATE}.zip"

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
