#ifndef _DOKANC_H_
#define _DOKANC_H_

#include "dokan.h"

#ifdef __cplusplus
extern "C" {
#endif

#define DOKAN_MOUNT_POINT_SUPPORTED_VERSION 600
#define DOKAN_SECURITY_SUPPORTED_VERSION	600

#define DOKAN_GLOBAL_DEVICE_NAME	L"\\\\.\\Dokan"
#define DOKAN_CONTROL_PIPE			L"\\\\.\\pipe\\DokanMounter"

#define DOKAN_MOUNTER_SERVICE L"DokanMounter"
#define DOKAN_DRIVER_SERVICE L"Dokan"

#define DOKAN_CONTROL_MOUNT		1
#define DOKAN_CONTROL_UNMOUNT	2
#define DOKAN_CONTROL_CHECK		3
#define DOKAN_CONTROL_FIND		4
#define DOKAN_CONTROL_LIST		5

#define DOKAN_CONTROL_OPTION_FORCE_UNMOUNT 1

#define DOKAN_CONTROL_SUCCESS	1
#define DOKAN_CONTROL_FAIL		0

#define DOKAN_SERVICE_START		1
#define DOKAN_SERVICE_STOP		2
#define DOKAN_SERVICE_DELETE	3

#define DOKAN_KEEPALIVE_TIME	3000 // in miliseconds

#define DOKAN_MAX_THREAD		15

// DokanOptions->DebugMode is ON?
extern	BOOL	g_DebugMode;

// DokanOptions->UseStdErr is ON?
extern	BOOL	g_UseStdErr;

typedef struct _DOKAN_CONTROL {
	ULONG	Type;
	WCHAR	MountPoint[MAX_PATH];
	WCHAR	DeviceName[64];
	ULONG	Option;
	ULONG	Status;

} DOKAN_CONTROL, *PDOKAN_CONTROL;

BOOL DOKANAPI
DokanServiceInstall(
	LPCWSTR	ServiceName,
	DWORD	ServiceType,
	LPCWSTR ServiceFullPath);

BOOL DOKANAPI
DokanServiceDelete(
	LPCWSTR	ServiceName);

BOOL DOKANAPI
DokanNetworkProviderInstall();

BOOL DOKANAPI
DokanNetworkProviderUninstall();

BOOL DOKANAPI
DokanSetDebugMode(ULONG Mode);

BOOL DOKANAPI
DokanMountControl(PDOKAN_CONTROL Control);


#ifdef __cplusplus
}
#endif


#endif