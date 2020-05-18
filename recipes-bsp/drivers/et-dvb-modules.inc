DESCRIPTION = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

PV = "${KV}+${SRCDATE}"

SRC_URI = "http://downloads.mutant-digital.net/xtrend/${MACHINE}/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

FILES_${PN} += "${sysconfdir}/modules-load.d/${MACHINE}.conf"

do_compile() {
}

do_install() {
	install -d ${D}/lib/modules/${KV}/extra
	install -d ${D}/${sysconfdir}/modules-load.d
	install -m 0755 ${S}/*.ko ${D}${base_libdir}/modules/${KV}/extra
	for i in tpm modloader modloader2 dvb; do
		echo $i >> ${D}/${sysconfdir}/modules-load.d/${MACHINE}.conf
	done
}
