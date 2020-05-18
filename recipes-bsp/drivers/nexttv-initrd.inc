SUMMARY = "image update support"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "xtrend"
LICENSE = "proprietary"
PACKAGE_ARCH := "${MACHINE_ARCH}"

require conf/license/license-gplv2.inc

PR = "r1"
ALLOW_EMPTY_${PN} = "1"

SRC_URI = "http://gi-et.info/et1x000/vmlinuz-initrd-${MACHINE}-${SRCDATE}.zip"

FILES_${PN} = "/boot"

S = "${WORKDIR}"
