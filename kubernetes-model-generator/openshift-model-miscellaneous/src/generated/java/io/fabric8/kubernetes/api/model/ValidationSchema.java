
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
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCount;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountList;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequest;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestList;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinition;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionList;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHost;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouter;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouterList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKI;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIList;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "APIGroup",
    "APIGroupList",
    "APIRequestCount",
    "APIRequestCountList",
    "BareMetalHost",
    "BareMetalHostList",
    "BaseKubernetesList",
    "Config",
    "ConfigList",
    "CredentialsRequest",
    "CredentialsRequestList",
    "EgressRouter",
    "EgressRouterList",
    "Info",
    "NetworkAttachmentDefinition",
    "NetworkAttachmentDefinitionList",
    "ObjectMeta",
    "OperatorPKI",
    "OperatorPKIList",
    "Patch",
    "Status",
    "Time",
    "TypeMeta"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
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
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("APIRequestCount")
    private APIRequestCount aPIRequestCount;
    @JsonProperty("APIRequestCountList")
    private APIRequestCountList aPIRequestCountList;
    @JsonProperty("BareMetalHost")
    private BareMetalHost bareMetalHost;
    @JsonProperty("BareMetalHostList")
    private BareMetalHostList bareMetalHostList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("Config")
    private Config config;
    @JsonProperty("ConfigList")
    private ConfigList configList;
    @JsonProperty("CredentialsRequest")
    private CredentialsRequest credentialsRequest;
    @JsonProperty("CredentialsRequestList")
    private CredentialsRequestList credentialsRequestList;
    @JsonProperty("EgressRouter")
    private EgressRouter egressRouter;
    @JsonProperty("EgressRouterList")
    private EgressRouterList egressRouterList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("NetworkAttachmentDefinition")
    private NetworkAttachmentDefinition networkAttachmentDefinition;
    @JsonProperty("NetworkAttachmentDefinitionList")
    private NetworkAttachmentDefinitionList networkAttachmentDefinitionList;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("OperatorPKI")
    private OperatorPKI operatorPKI;
    @JsonProperty("OperatorPKIList")
    private OperatorPKIList operatorPKIList;
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
    public ValidationSchema() {
    }

    /**
     * 
     * @param aPIGroupList
     * @param aPIRequestCount
     * @param baseKubernetesList
     * @param networkAttachmentDefinition
     * @param configList
     * @param patch
     * @param aPIGroup
     * @param typeMeta
     * @param objectMeta
     * @param operatorPKIList
     * @param aPIRequestCountList
     * @param bareMetalHostList
     * @param egressRouterList
     * @param operatorPKI
     * @param networkAttachmentDefinitionList
     * @param time
     * @param egressRouter
     * @param config
     * @param credentialsRequestList
     * @param bareMetalHost
     * @param credentialsRequest
     * @param info
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, APIRequestCount aPIRequestCount, APIRequestCountList aPIRequestCountList, BareMetalHost bareMetalHost, BareMetalHostList bareMetalHostList, BaseKubernetesList baseKubernetesList, Config config, ConfigList configList, CredentialsRequest credentialsRequest, CredentialsRequestList credentialsRequestList, EgressRouter egressRouter, EgressRouterList egressRouterList, Info info, NetworkAttachmentDefinition networkAttachmentDefinition, NetworkAttachmentDefinitionList networkAttachmentDefinitionList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, OperatorPKI operatorPKI, OperatorPKIList operatorPKIList, Patch patch, Status status, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.aPIRequestCount = aPIRequestCount;
        this.aPIRequestCountList = aPIRequestCountList;
        this.bareMetalHost = bareMetalHost;
        this.bareMetalHostList = bareMetalHostList;
        this.baseKubernetesList = baseKubernetesList;
        this.config = config;
        this.configList = configList;
        this.credentialsRequest = credentialsRequest;
        this.credentialsRequestList = credentialsRequestList;
        this.egressRouter = egressRouter;
        this.egressRouterList = egressRouterList;
        this.info = info;
        this.networkAttachmentDefinition = networkAttachmentDefinition;
        this.networkAttachmentDefinitionList = networkAttachmentDefinitionList;
        this.objectMeta = objectMeta;
        this.operatorPKI = operatorPKI;
        this.operatorPKIList = operatorPKIList;
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

    @JsonProperty("APIRequestCount")
    public APIRequestCount getAPIRequestCount() {
        return aPIRequestCount;
    }

    @JsonProperty("APIRequestCount")
    public void setAPIRequestCount(APIRequestCount aPIRequestCount) {
        this.aPIRequestCount = aPIRequestCount;
    }

    @JsonProperty("APIRequestCountList")
    public APIRequestCountList getAPIRequestCountList() {
        return aPIRequestCountList;
    }

    @JsonProperty("APIRequestCountList")
    public void setAPIRequestCountList(APIRequestCountList aPIRequestCountList) {
        this.aPIRequestCountList = aPIRequestCountList;
    }

    @JsonProperty("BareMetalHost")
    public BareMetalHost getBareMetalHost() {
        return bareMetalHost;
    }

    @JsonProperty("BareMetalHost")
    public void setBareMetalHost(BareMetalHost bareMetalHost) {
        this.bareMetalHost = bareMetalHost;
    }

    @JsonProperty("BareMetalHostList")
    public BareMetalHostList getBareMetalHostList() {
        return bareMetalHostList;
    }

    @JsonProperty("BareMetalHostList")
    public void setBareMetalHostList(BareMetalHostList bareMetalHostList) {
        this.bareMetalHostList = bareMetalHostList;
    }

    @JsonProperty("BaseKubernetesList")
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("Config")
    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("ConfigList")
    public ConfigList getConfigList() {
        return configList;
    }

    @JsonProperty("ConfigList")
    public void setConfigList(ConfigList configList) {
        this.configList = configList;
    }

    @JsonProperty("CredentialsRequest")
    public CredentialsRequest getCredentialsRequest() {
        return credentialsRequest;
    }

    @JsonProperty("CredentialsRequest")
    public void setCredentialsRequest(CredentialsRequest credentialsRequest) {
        this.credentialsRequest = credentialsRequest;
    }

    @JsonProperty("CredentialsRequestList")
    public CredentialsRequestList getCredentialsRequestList() {
        return credentialsRequestList;
    }

    @JsonProperty("CredentialsRequestList")
    public void setCredentialsRequestList(CredentialsRequestList credentialsRequestList) {
        this.credentialsRequestList = credentialsRequestList;
    }

    @JsonProperty("EgressRouter")
    public EgressRouter getEgressRouter() {
        return egressRouter;
    }

    @JsonProperty("EgressRouter")
    public void setEgressRouter(EgressRouter egressRouter) {
        this.egressRouter = egressRouter;
    }

    @JsonProperty("EgressRouterList")
    public EgressRouterList getEgressRouterList() {
        return egressRouterList;
    }

    @JsonProperty("EgressRouterList")
    public void setEgressRouterList(EgressRouterList egressRouterList) {
        this.egressRouterList = egressRouterList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("NetworkAttachmentDefinition")
    public NetworkAttachmentDefinition getNetworkAttachmentDefinition() {
        return networkAttachmentDefinition;
    }

    @JsonProperty("NetworkAttachmentDefinition")
    public void setNetworkAttachmentDefinition(NetworkAttachmentDefinition networkAttachmentDefinition) {
        this.networkAttachmentDefinition = networkAttachmentDefinition;
    }

    @JsonProperty("NetworkAttachmentDefinitionList")
    public NetworkAttachmentDefinitionList getNetworkAttachmentDefinitionList() {
        return networkAttachmentDefinitionList;
    }

    @JsonProperty("NetworkAttachmentDefinitionList")
    public void setNetworkAttachmentDefinitionList(NetworkAttachmentDefinitionList networkAttachmentDefinitionList) {
        this.networkAttachmentDefinitionList = networkAttachmentDefinitionList;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("OperatorPKI")
    public OperatorPKI getOperatorPKI() {
        return operatorPKI;
    }

    @JsonProperty("OperatorPKI")
    public void setOperatorPKI(OperatorPKI operatorPKI) {
        this.operatorPKI = operatorPKI;
    }

    @JsonProperty("OperatorPKIList")
    public OperatorPKIList getOperatorPKIList() {
        return operatorPKIList;
    }

    @JsonProperty("OperatorPKIList")
    public void setOperatorPKIList(OperatorPKIList operatorPKIList) {
        this.operatorPKIList = operatorPKIList;
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
