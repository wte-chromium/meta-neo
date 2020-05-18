DESCRIPTION = "Linux kernel for ${MACHINE}"
SECTION = "kernel"
LICENSE = "GPLv2"

KERNEL_RELEASE = "4.10.6"
COMPATIBLE_MACHINE = "et4x00|et8000|et10000"

inherit kernel machine_kernel_pr

MACHINE_KERNEL_PR_append = ".1"

SRC_URI[mips.md5sum] = "e5d32dd03b742e6101fde917dcba837d"
SRC_URI[mips.sha256sum] = "2997b825996beabc25d2428d37d680f56e4fa971500eabd2033a6fc13cf5765e"

LIC_FILES_CHKSUM = "file://${WORKDIR}/linux-${PV}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG_${KERNEL_PACKAGE_NAME}-base = "kernel-base"
PKG_${KERNEL_PACKAGE_NAME}-image = "kernel-image"
RPROVIDES_${KERNEL_PACKAGE_NAME}-base = "kernel-${KERNEL_VERSION}"
RPROVIDES_${KERNEL_PACKAGE_NAME}-image = "kernel-image-${KERNEL_VERSION}"

SRC_URI = "http://downloads.mutant-digital.net/linux-${PV}-${ARCH}.tar.gz;name=${ARCH} \
	file://0001-genet1-1000mbit.patch \
	file://bcmgenet_phyaddr.patch \
	file://defconfig \
"

S = "${WORKDIR}/linux-${PV}"

export OS = "Linux"
KERNEL_OBJECT_SUFFIX = "ko"

# MIPSEL
KERNEL_IMAGETYPE_mipsel = "vmlinux.gz"
KERNEL_OUTPUT_DIR_mipsel = "."
KERNEL_IMAGEDEST_mipsel = "tmp"
KERNEL_CONSOLE_mipsel = "null"
SERIAL_CONSOLE_mipsel ?= ""

KERNEL_EXTRA_ARGS_mipsel = "EXTRA_CFLAGS=-Wno-attribute-alias"

# Replaced by kernel_output_dir
KERNEL_OUTPUT_mipsel = "vmlinux.gz"

pkg_postinst_kernel-image_mipsel() {
	if [ "x$D" == "x" ]; then
		if [ -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ] ; then
			flash_eraseall /dev/mtd1
			nandwrite -p /dev/mtd1 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
		fi
	fi
	true
}
