SRCDATE = "20170302"

require initrd.inc

do_install() {
    install -d ${D}/boot
    install -m 0644 ${WORKDIR}/vmlinuz-initrd-et1x000 ${D}/boot/update.bin
}

SRC_URI[md5sum] = "d975108c96305a1b36374a2c2562119d"
SRC_URI[sha256sum] = "cb241e8ec9d1cacfc35f9762ca05506129fc7e359f0a41711fb38a45fb1ced50"
