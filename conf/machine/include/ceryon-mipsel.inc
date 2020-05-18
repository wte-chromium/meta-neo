MACHINE_KERNEL_PR = "r0"

KERNEL_MODULE_AUTOLOAD += "xfs"

# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

IMAGE_CMD_ubi_prepend = " \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS = "\
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer1.0-libav", "gst-ffmpeg", d)} \
	ceryon-dvb-modules-${MACHINE} \
	kernel-vmlinux \
	"

MACHINE_EXTRA_RRECOMMENDS = " \
	gst-plugin-dvbmediasink \
	"

DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dts --with-eac3 \
    ${@bb.utils.contains('MACHINE', 'mbmicrov2', '--with-h265 --with-vb6 --with-vb8 --with-spark' , '', d)} \
"

TARGET_ARCH = "mipsel"
DEFAULTTUNE ?= "mips32el"

PREFERRED_PROVIDER_virtual/kernel = "linux-ceryon"

PREFERRED_PROVIDER_virtual/blindscan-dvbc = "ceryon-blindscan-utils-${MACHINE}"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "ceryon-blindscan-utils-${MACHINE}"

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"
KERNEL_OUTPUT_DIR = "."
KERNEL_CONSOLE = "null"
SERIAL_CONSOLE ?= ""

IMAGE_FSTYPES ?= "ubi"

UBI_VOLNAME = "rootfs"

IMGDEPLOYDIR ?= "${DEPLOY_DIR_IMAGE}"
IMAGEVERSION := "${DISTRO_NAME}-${DISTRO_VERSION}-${DATE}"
IMAGEVERSION[vardepsexclude] = "DATE"

IMAGE_CMD_ubi_append = " \
	mkdir -p ${IMGDEPLOYDIR}/${IMAGEDIR}; \
	cp ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ubi ${IMGDEPLOYDIR}/${IMAGEDIR}/rootfs.bin; \
	gzip -9c ${DEPLOY_DIR_IMAGE}/vmlinux-${MACHINE}.bin > ${IMGDEPLOYDIR}/${IMAGEDIR}/kernel.bin; \
	echo "${IMAGEVERSION}" > ${IMGDEPLOYDIR}/${IMAGEDIR}/imageversion; \
	echo "rename this file to 'force' to force an update without confirmation" > ${IMGDEPLOYDIR}/${IMAGEDIR}/noforce; \
	cd ${IMGDEPLOYDIR}; \
	zip ${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}_usb.zip ${IMAGEDIR}/*; \
	rm -Rf miraclebox; \
	"

IMAGE_CMD_ubi_prepend = " \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	"

MACHINE_FEATURES += "alsa usbhost wlan 3dtv switchoff osdposition hdmicec dvbusb"

require conf/machine/include/tune-mips32.inc
require conf/machine/include/essential.inc
