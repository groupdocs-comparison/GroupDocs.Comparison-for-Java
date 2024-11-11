
#include "stdafx.h"
#include "../dokani.h"
#include "fileinfo.h"

VOID
DispatchQuerySecurity(
    HANDLE			Handle,
    PEVENT_CONTEXT	EventContext,
    PDOKAN_INSTANCE	DokanInstance)
{
    PEVENT_INFORMATION	eventInfo;
    DOKAN_FILE_INFO		fileInfo;
    PDOKAN_OPEN_INFO	openInfo;
    ULONG	eventInfoLength;
    NTSTATUS status = STATUS_NOT_IMPLEMENTED;
    ULONG	lengthNeeded = 0;

    eventInfoLength = sizeof(EVENT_INFORMATION) - 8 + EventContext->Security.BufferLength;
    CheckFileName(EventContext->Security.FileName);

    eventInfo = DispatchCommon(EventContext, eventInfoLength, DokanInstance, &fileInfo, &openInfo);
    
    if (DOKAN_SECURITY_SUPPORTED_VERSION <= DokanInstance->DokanOptions->Version &&
        DokanInstance->DokanOperations->GetFileSecurity) {
        status = DokanInstance->DokanOperations->GetFileSecurity(
                    EventContext->Security.FileName,
                    &EventContext->Security.SecurityInformation,
                    &eventInfo->Buffer,
                    EventContext->Security.BufferLength,
                    &lengthNeeded,
                    &fileInfo);
    }

    eventInfo->Status = status;
    eventInfo->BufferLength = lengthNeeded;

    if (status != STATUS_SUCCESS && status != STATUS_BUFFER_OVERFLOW) {
        eventInfo->BufferLength = 0;
    }

    SendEventInformation(Handle, eventInfo, eventInfoLength, DokanInstance);
    free(eventInfo);
}


VOID
DispatchSetSecurity(
    HANDLE			Handle,
    PEVENT_CONTEXT	EventContext,
    PDOKAN_INSTANCE	DokanInstance)
{
    PEVENT_INFORMATION	eventInfo;
    DOKAN_FILE_INFO		fileInfo;
    PDOKAN_OPEN_INFO	openInfo;
    ULONG	eventInfoLength;
    int		status = -2;
    PSECURITY_DESCRIPTOR	securityDescriptor;
    
    eventInfoLength = sizeof(EVENT_INFORMATION);
    CheckFileName(EventContext->SetSecurity.FileName);

    eventInfo = DispatchCommon(EventContext, eventInfoLength, DokanInstance, &fileInfo, &openInfo);
    
    securityDescriptor = (PCHAR)EventContext + EventContext->SetSecurity.BufferOffset;

    if (status < 0) {
        eventInfo->Status = STATUS_INVALID_PARAMETER;
        eventInfo->BufferLength = 0;
    } else {
        eventInfo->Status = STATUS_SUCCESS;
        eventInfo->BufferLength = 0;
    }

    SendEventInformation(Handle, eventInfo, eventInfoLength, DokanInstance);
    free(eventInfo);
}
