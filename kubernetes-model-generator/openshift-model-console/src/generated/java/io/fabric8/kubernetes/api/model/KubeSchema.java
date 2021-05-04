
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.console.v1.ConsoleCLIDownload;
import io.fabric8.openshift.api.model.console.v1.ConsoleCLIDownloadList;
import io.fabric8.openshift.api.model.console.v1.ConsoleExternalLogLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleExternalLogLinkList;
import io.fabric8.openshift.api.model.console.v1.ConsoleLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleLinkList;
import io.fabric8.openshift.api.model.console.v1.ConsoleNotification;
import io.fabric8.openshift.api.model.console.v1.ConsoleNotificationList;
import io.fabric8.openshift.api.model.console.v1.ConsoleYAMLSample;
import io.fabric8.openshift.api.model.console.v1.ConsoleYAMLSampleList;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "APIGroup",
    "APIGroupList",
    "BaseKubernetesList",
    "ConsoleCLIDownload",
    "ConsoleCLIDownloadList",
    "ConsoleExternalLogLink",
    "ConsoleExternalLogLinkList",
    "ConsoleLink",
    "ConsoleLinkList",
    "ConsoleNotification",
    "ConsoleNotificationList",
    "ConsoleYAMLSample",
    "ConsoleYAMLSampleList",
    "Info",
    "ObjectMeta",
    "Patch",
    "Status",
    "Time",
    "TypeMeta"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class KubeSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("ConsoleCLIDownload")
    private ConsoleCLIDownload consoleCLIDownload;
    @JsonProperty("ConsoleCLIDownloadList")
    private ConsoleCLIDownloadList consoleCLIDownloadList;
    @JsonProperty("ConsoleExternalLogLink")
    private ConsoleExternalLogLink consoleExternalLogLink;
    @JsonProperty("ConsoleExternalLogLinkList")
    private ConsoleExternalLogLinkList consoleExternalLogLinkList;
    @JsonProperty("ConsoleLink")
    private ConsoleLink consoleLink;
    @JsonProperty("ConsoleLinkList")
    private ConsoleLinkList consoleLinkList;
    @JsonProperty("ConsoleNotification")
    private ConsoleNotification consoleNotification;
    @JsonProperty("ConsoleNotificationList")
    private ConsoleNotificationList consoleNotificationList;
    @JsonProperty("ConsoleYAMLSample")
    private ConsoleYAMLSample consoleYAMLSample;
    @JsonProperty("ConsoleYAMLSampleList")
    private ConsoleYAMLSampleList consoleYAMLSampleList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    /**
     * 
     * @param aPIGroupList
     * @param consoleLinkList
     * @param baseKubernetesList
     * @param consoleCLIDownload
     * @param patch
     * @param aPIGroup
     * @param typeMeta
     * @param consoleNotificationList
     * @param consoleCLIDownloadList
     * @param consoleExternalLogLink
     * @param consoleNotification
     * @param consoleYAMLSample
     * @param objectMeta
     * @param consoleExternalLogLinkList
     * @param consoleLink
     * @param consoleYAMLSampleList
     * @param time
     * @param info
     * @param status
     */
    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, ConsoleCLIDownload consoleCLIDownload, ConsoleCLIDownloadList consoleCLIDownloadList, ConsoleExternalLogLink consoleExternalLogLink, ConsoleExternalLogLinkList consoleExternalLogLinkList, ConsoleLink consoleLink, ConsoleLinkList consoleLinkList, ConsoleNotification consoleNotification, ConsoleNotificationList consoleNotificationList, ConsoleYAMLSample consoleYAMLSample, ConsoleYAMLSampleList consoleYAMLSampleList, Info info, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, Status status, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.consoleCLIDownload = consoleCLIDownload;
        this.consoleCLIDownloadList = consoleCLIDownloadList;
        this.consoleExternalLogLink = consoleExternalLogLink;
        this.consoleExternalLogLinkList = consoleExternalLogLinkList;
        this.consoleLink = consoleLink;
        this.consoleLinkList = consoleLinkList;
        this.consoleNotification = consoleNotification;
        this.consoleNotificationList = consoleNotificationList;
        this.consoleYAMLSample = consoleYAMLSample;
        this.consoleYAMLSampleList = consoleYAMLSampleList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
    }

    @JsonProperty("APIGroup")
    public APIGroup getAPIGroup() {
        return aPIGroup;
    }

    @JsonProperty("APIGroup")
    public void setAPIGroup(APIGroup aPIGroup) {
        this.aPIGroup = aPIGroup;
    }

    @JsonProperty("APIGroupList")
    public APIGroupList getAPIGroupList() {
        return aPIGroupList;
    }

    @JsonProperty("APIGroupList")
    public void setAPIGroupList(APIGroupList aPIGroupList) {
        this.aPIGroupList = aPIGroupList;
    }

    @JsonProperty("BaseKubernetesList")
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("ConsoleCLIDownload")
    public ConsoleCLIDownload getConsoleCLIDownload() {
        return consoleCLIDownload;
    }

    @JsonProperty("ConsoleCLIDownload")
    public void setConsoleCLIDownload(ConsoleCLIDownload consoleCLIDownload) {
        this.consoleCLIDownload = consoleCLIDownload;
    }

    @JsonProperty("ConsoleCLIDownloadList")
    public ConsoleCLIDownloadList getConsoleCLIDownloadList() {
        return consoleCLIDownloadList;
    }

    @JsonProperty("ConsoleCLIDownloadList")
    public void setConsoleCLIDownloadList(ConsoleCLIDownloadList consoleCLIDownloadList) {
        this.consoleCLIDownloadList = consoleCLIDownloadList;
    }

    @JsonProperty("ConsoleExternalLogLink")
    public ConsoleExternalLogLink getConsoleExternalLogLink() {
        return consoleExternalLogLink;
    }

    @JsonProperty("ConsoleExternalLogLink")
    public void setConsoleExternalLogLink(ConsoleExternalLogLink consoleExternalLogLink) {
        this.consoleExternalLogLink = consoleExternalLogLink;
    }

    @JsonProperty("ConsoleExternalLogLinkList")
    public ConsoleExternalLogLinkList getConsoleExternalLogLinkList() {
        return consoleExternalLogLinkList;
    }

    @JsonProperty("ConsoleExternalLogLinkList")
    public void setConsoleExternalLogLinkList(ConsoleExternalLogLinkList consoleExternalLogLinkList) {
        this.consoleExternalLogLinkList = consoleExternalLogLinkList;
    }

    @JsonProperty("ConsoleLink")
    public ConsoleLink getConsoleLink() {
        return consoleLink;
    }

    @JsonProperty("ConsoleLink")
    public void setConsoleLink(ConsoleLink consoleLink) {
        this.consoleLink = consoleLink;
    }

    @JsonProperty("ConsoleLinkList")
    public ConsoleLinkList getConsoleLinkList() {
        return consoleLinkList;
    }

    @JsonProperty("ConsoleLinkList")
    public void setConsoleLinkList(ConsoleLinkList consoleLinkList) {
        this.consoleLinkList = consoleLinkList;
    }

    @JsonProperty("ConsoleNotification")
    public ConsoleNotification getConsoleNotification() {
        return consoleNotification;
    }

    @JsonProperty("ConsoleNotification")
    public void setConsoleNotification(ConsoleNotification consoleNotification) {
        this.consoleNotification = consoleNotification;
    }

    @JsonProperty("ConsoleNotificationList")
    public ConsoleNotificationList getConsoleNotificationList() {
        return consoleNotificationList;
    }

    @JsonProperty("ConsoleNotificationList")
    public void setConsoleNotificationList(ConsoleNotificationList consoleNotificationList) {
        this.consoleNotificationList = consoleNotificationList;
    }

    @JsonProperty("ConsoleYAMLSample")
    public ConsoleYAMLSample getConsoleYAMLSample() {
        return consoleYAMLSample;
    }

    @JsonProperty("ConsoleYAMLSample")
    public void setConsoleYAMLSample(ConsoleYAMLSample consoleYAMLSample) {
        this.consoleYAMLSample = consoleYAMLSample;
    }

    @JsonProperty("ConsoleYAMLSampleList")
    public ConsoleYAMLSampleList getConsoleYAMLSampleList() {
        return consoleYAMLSampleList;
    }

    @JsonProperty("ConsoleYAMLSampleList")
    public void setConsoleYAMLSampleList(ConsoleYAMLSampleList consoleYAMLSampleList) {
        this.consoleYAMLSampleList = consoleYAMLSampleList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
