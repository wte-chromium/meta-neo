MACHINE_EXTRA_RDEPENDS += "\
	${@bb.utils.contains('MACHINE_FEATURES', 'hbbtv', 'enigma2-plugin-extensions-hbbtv-${MACHINE}' , '', d)} \
	"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS = "\
	kernel-module-cdfs \
	${@bb.utils.contains('MACHINE_FEATURES', 'v3d-nxpl', 'et-v3ddriver-${MACHINE}' , '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'micom', 'et-fpupdate-${MACHINE}' , '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'nexttv-blindscan-dvbc', 'nexttv-blindscanc-utils-${MACHINE}' , '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'ceryon-blindscan-dvbc', 'ceryon-blindscanc-utils-${MACHINE}' , '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'ceryon-blindscan-dvbs', 'ceryon-blindscans-utils-${MACHINE}' , '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'broadmedia-blindscan-dvbc', 'broadmedia-blindscanc-utils-${MACHINE}' , '', d)} \
	\
	firmware-carl9170 \
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8712u \
	firmware-rtl8192cu \
	firmware-htc7010 \
	firmware-htc9271 \
	firmware-zd1211 \
	\
	kernel-module-rtl88x2bu \
	\
	kernel-module-carl9170 \
	kernel-module-r8712u \
	kernel-module-r8723au \
	kernel-module-rt2500usb \
	kernel-module-rt2800usb \
	kernel-module-rt73usb \
	kernel-module-rtl8187 \
	kernel-module-rtl8192cu \
	kernel-module-zd1211rw \
	kernel-module-ath9k-htc \
	\
	${@bb.utils.contains('MACHINE_FEATURES', 'wifi-kernel4-4', 'firmware-rtl8192eu firmware-rtl8188eu firmware-rtl8xxxu firmware-mt7601u kernel-module-r8188eu kernel-module-8192eu kernel-module-mt7601u kernel-module-rtl8xxxu' , '', d)} \
	"
