SUMMARY = "Firmware for mn8847x"
LICENSE = "CLOSED"

inherit allarch

SRC_URI = "file://mn88472.fw"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 mn88472.fw ${D}${base_libdir}/firmware
}
