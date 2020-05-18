SUMMARY = "Linux kernel for ${MACHINE}"
SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel machine_kernel_pr

MACHINE_KERNEL_PR_append = ".1"
KERNEL_RELEASE = "3.8.7"

SRC_URI[mips.md5sum] = "5f6aaac90a4587df34e418bedd7d40eb"
SRC_URI[mips.sha256sum] = "afc3e654b779f4b994a0d455d6ad12f46ff0dbec2fe222a4f55925744b498218"


LIC_FILES_CHKSUM = "file://${WORKDIR}/linux-${PV}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG_${KERNEL_PACKAGE_NAME}-base = "kernel-base"
PKG_${KERNEL_PACKAGE_NAME}-image = "kernel-image"
RPROVIDES_${KERNEL_PACKAGE_NAME}-base = "kernel-${KERNEL_VERSION}"
RPROVIDES_${KERNEL_PACKAGE_NAME}-image = "kernel-image-${KERNEL_VERSION}"

SRC_URI = "http://downloads.mutant-digital.net/linux-${PV}-${ARCH}.tar.gz;name=${ARCH} \
	file://defconfig \
	file://0001-kernel-add-support-for-gcc-5.patch \
	file://0001-Revert-default-authentication-needs-to-be-at-least-n.patch \
	file://0001-Revert-MIPS-mm-Add-compound-tail-page-_mapcount-when.patch \
	file://0001-Revert-MIPS-Add-fast-get_user_pages.patch \
	file://0001-Revert-MIPS-Fix-potencial-corruption.patch \
	file://add-dmx-source-timecode.patch \
	file://af9015-output-full-range-SNR.patch \
	file://af9033-output-full-range-SNR.patch \
	file://as102-adjust-signal-strength-report.patch \
	file://as102-scale-MER-to-full-range.patch \
	file://cinergy_s2_usb_r2.patch \
	file://cxd2820r-output-full-range-SNR.patch \
	file://dvb-usb-dib0700-disable-sleep.patch \
	file://dvb-usb-rtl2832.patch \
	file://dvb_usb_disable_rc_polling.patch \
	file://em28xx_add_terratec_h5_rev3.patch \
	file://fix-proc-cputype.patch \
	file://fixme-hardfloat.patch \
	file://iosched-slice_idle-1.patch \
	file://it913x-switch-off-PID-filter-by-default.patch \
	file://tda18271-advertise-supported-delsys.patch \
	file://dvb-usb-siano-always-load-smsdvb-v2.patch \
	file://mxl5007t-add-no_probe-and-no_reset-parameters.patch \
	file://nfs-max-rwsize-8k.patch \
	file://0001-rt2800usb-add-support-for-rt55xx.patch \
	file://rtl28xxu-and-tuners-update-to-latest-version-09-09-2013.patch \
	file://rtl2832-scale-SNR-to-full-range.patch \
	file://rtl8712-fix-warnings.patch \
	file://rtl8187se-fix-warnings.patch \
	file://em28xx-dvb-enable-LNA-by-default-for-PCTV290e.patch \
	file://zl10353-output-full-range-SNR.patch \
	file://kernel-add-support-for-gcc6.patch \
	file://kernel-add-support-for-gcc7.patch \
	file://kernel-add-support-for-gcc8.patch \
	file://kernel-add-support-for-gcc9.patch \
	file://stv0900-Multistream-support.patch \
	file://0001-STV-Add-PLS-support.patch \
	file://0001-STV-Add-SNR-Signal-report-parameters.patch \
	file://0001-stv090x-optimized-TS-sync-control.patch \
	file://2-2-stv090x-on-tuning-lock-return-correct-tuned-paramaters-like-freq-sr-fec-rolloff-etc.patch \
	file://0001-Support-TBS-USB-drivers.patch \
	file://genksyms_fix_typeof_handling.patch \
	file://0002-cp1emu-do-not-use-bools-for-arithmetic.patch \
	file://0003-log2-give-up-on-gcc-constant-optimizations.patch \
	file://add-attributes-fix-modules-compile.patch \
	file://makefile-silence-warnings.patch \
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
