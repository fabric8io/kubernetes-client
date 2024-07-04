
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3Remediation;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationList;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationTemplate;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationTemplateList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouter;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouterList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKI;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIList;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private APIRequestCount aPIRequestCount;
    private APIRequestCountList aPIRequestCountList;
    private BareMetalHost bareMetalHost;
    private BareMetalHostList bareMetalHostList;
    private KubernetesList baseKubernetesList;
    private Config config;
    private ConfigList configList;
    private CredentialsRequest credentialsRequest;
    private CredentialsRequestList credentialsRequestList;
    private EgressRouter egressRouter;
    private EgressRouterList egressRouterList;
    private Info info;
    private Metal3Remediation metal3Remediation;
    private Metal3RemediationList metal3RemediationList;
    private Metal3RemediationTemplate metal3RemediationTemplate;
    private Metal3RemediationTemplateList metal3RemediationTemplateList;
    private NetworkAttachmentDefinition networkAttachmentDefinition;
    private NetworkAttachmentDefinitionList networkAttachmentDefinitionList;
    private ObjectMeta objectMeta;
    private OperatorPKI operatorPKI;
    private OperatorPKIList operatorPKIList;
    private Patch patch;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, APIRequestCount aPIRequestCount, APIRequestCountList aPIRequestCountList, BareMetalHost bareMetalHost, BareMetalHostList bareMetalHostList, KubernetesList baseKubernetesList, Config config, ConfigList configList, CredentialsRequest credentialsRequest, CredentialsRequestList credentialsRequestList, EgressRouter egressRouter, EgressRouterList egressRouterList, Info info, Metal3Remediation metal3Remediation, Metal3RemediationList metal3RemediationList, Metal3RemediationTemplate metal3RemediationTemplate, Metal3RemediationTemplateList metal3RemediationTemplateList, NetworkAttachmentDefinition networkAttachmentDefinition, NetworkAttachmentDefinitionList networkAttachmentDefinitionList, ObjectMeta objectMeta, OperatorPKI operatorPKI, OperatorPKIList operatorPKIList, Patch patch, Status status, String time, TypeMeta typeMeta) {
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
        this.metal3Remediation = metal3Remediation;
        this.metal3RemediationList = metal3RemediationList;
        this.metal3RemediationTemplate = metal3RemediationTemplate;
        this.metal3RemediationTemplateList = metal3RemediationTemplateList;
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
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
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

    @JsonProperty("Metal3Remediation")
    public Metal3Remediation getMetal3Remediation() {
        return metal3Remediation;
    }

    @JsonProperty("Metal3Remediation")
    public void setMetal3Remediation(Metal3Remediation metal3Remediation) {
        this.metal3Remediation = metal3Remediation;
    }

    @JsonProperty("Metal3RemediationList")
    public Metal3RemediationList getMetal3RemediationList() {
        return metal3RemediationList;
    }

    @JsonProperty("Metal3RemediationList")
    public void setMetal3RemediationList(Metal3RemediationList metal3RemediationList) {
        this.metal3RemediationList = metal3RemediationList;
    }

    @JsonProperty("Metal3RemediationTemplate")
    public Metal3RemediationTemplate getMetal3RemediationTemplate() {
        return metal3RemediationTemplate;
    }

    @JsonProperty("Metal3RemediationTemplate")
    public void setMetal3RemediationTemplate(Metal3RemediationTemplate metal3RemediationTemplate) {
        this.metal3RemediationTemplate = metal3RemediationTemplate;
    }

    @JsonProperty("Metal3RemediationTemplateList")
    public Metal3RemediationTemplateList getMetal3RemediationTemplateList() {
        return metal3RemediationTemplateList;
    }

    @JsonProperty("Metal3RemediationTemplateList")
    public void setMetal3RemediationTemplateList(Metal3RemediationTemplateList metal3RemediationTemplateList) {
        this.metal3RemediationTemplateList = metal3RemediationTemplateList;
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
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
