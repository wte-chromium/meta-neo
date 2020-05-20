DESCRIPTION = "SPYCAT Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

INC_PR = "r0"

DEPENDS += "xz-native bc-native"
DEPENDS_append_aarch64 = " libgcc"
KERNEL_CC_append_aarch64 = " ${TOOLCHAIN_OPTIONS}"
KERNEL_LD_append_aarch64 = " ${TOOLCHAIN_OPTIONS}"

# Pick up shared functions
inherit kernel

export OS = "Linux"

S = "${WORKDIR}/linux-${PV}"
B = "${WORKDIR}/build"

KERNEL_IMAGEDEST = "tmp"

KERNEL_EXTRA_ARGS = "EXTRA_CFLAGS=-Wno-attribute-alias"

FILES_${KERNEL_PACKAGE_NAME}-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}*"

pkg_postinst_kernel-image () {
	if [ -z "$D" ]
	then
		MTD_DEVICE=$(grep 'kernel' /proc/mtd | cut -f1 -d':')
		flash_eraseall /dev/${MTD_DEVICE}
		nandwrite -p /dev/${MTD_DEVICE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
		rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
	fi
}

pkg_postrm_kernel-image () {
}

do_rm_work() {
}

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/open-spycat/spycat-kernel/releases/download/v${PV}/spycat-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	"

COMPATIBLE_MACHINE = "spycat|spycatmini|spycatminiplus|spycat4kmini"

SRC_URI[kernel.md5sum] = "251a5deee0fa6daf3f356b1bbda9eab8"
SRC_URI[kernel.sha256sum] = "b67ecafd0a42b3383bf4d82f0850cbff92a7e72a215a6d02f42ddbafcf42a7d6"
SRC_URI[kernelpatch.md5sum] = "0c8fa6cf07394e6a8ac9e3495b2d43c5"
SRC_URI[kernelpatch.sha256sum] = "f3876390e9cb3b02a0f20a374a852c2dd0a018f71887969a0fd66439a526d8e8"
