
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "adminKubeconfigSecretRef",
    "adminPasswordSecretRef",
    "attempt",
    "clusterDeploymentRef",
    "clusterID",
    "infraID",
    "installLog",
    "podSpec",
    "prevClusterID",
    "prevInfraID",
    "prevProvisionName",
    "stage"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterProvisionSpec implements KubernetesResource
{

    @JsonProperty("adminKubeconfigSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference adminKubeconfigSecretRef;
    @JsonProperty("adminPasswordSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference adminPasswordSecretRef;
    @JsonProperty("attempt")
    private Integer attempt;
    @JsonProperty("clusterDeploymentRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference clusterDeploymentRef;
    @JsonProperty("clusterID")
    private java.lang.String clusterID;
    @JsonProperty("infraID")
    private java.lang.String infraID;
    @JsonProperty("installLog")
    private java.lang.String installLog;
    @JsonProperty("metadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> metadata = new LinkedHashMap<String, Object>();
    @JsonProperty("podSpec")
    private PodSpec podSpec;
    @JsonProperty("prevClusterID")
    private java.lang.String prevClusterID;
    @JsonProperty("prevInfraID")
    private java.lang.String prevInfraID;
    @JsonProperty("prevProvisionName")
    private java.lang.String prevProvisionName;
    @JsonProperty("stage")
    private java.lang.String stage;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterProvisionSpec() {
    }

    public ClusterProvisionSpec(io.fabric8.kubernetes.api.model.LocalObjectReference adminKubeconfigSecretRef, io.fabric8.kubernetes.api.model.LocalObjectReference adminPasswordSecretRef, Integer attempt, io.fabric8.kubernetes.api.model.LocalObjectReference clusterDeploymentRef, java.lang.String clusterID, java.lang.String infraID, java.lang.String installLog, Map<String, Object> metadata, PodSpec podSpec, java.lang.String prevClusterID, java.lang.String prevInfraID, java.lang.String prevProvisionName, java.lang.String stage) {
        super();
        this.adminKubeconfigSecretRef = adminKubeconfigSecretRef;
        this.adminPasswordSecretRef = adminPasswordSecretRef;
        this.attempt = attempt;
        this.clusterDeploymentRef = clusterDeploymentRef;
        this.clusterID = clusterID;
        this.infraID = infraID;
        this.installLog = installLog;
        this.metadata = metadata;
        this.podSpec = podSpec;
        this.prevClusterID = prevClusterID;
        this.prevInfraID = prevInfraID;
        this.prevProvisionName = prevProvisionName;
        this.stage = stage;
    }

    @JsonProperty("adminKubeconfigSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getAdminKubeconfigSecretRef() {
        return adminKubeconfigSecretRef;
    }

    @JsonProperty("adminKubeconfigSecretRef")
    public void setAdminKubeconfigSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference adminKubeconfigSecretRef) {
        this.adminKubeconfigSecretRef = adminKubeconfigSecretRef;
    }

    @JsonProperty("adminPasswordSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getAdminPasswordSecretRef() {
        return adminPasswordSecretRef;
    }

    @JsonProperty("adminPasswordSecretRef")
    public void setAdminPasswordSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference adminPasswordSecretRef) {
        this.adminPasswordSecretRef = adminPasswordSecretRef;
    }

    @JsonProperty("attempt")
    public Integer getAttempt() {
        return attempt;
    }

    @JsonProperty("attempt")
    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    @JsonProperty("clusterDeploymentRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getClusterDeploymentRef() {
        return clusterDeploymentRef;
    }

    @JsonProperty("clusterDeploymentRef")
    public void setClusterDeploymentRef(io.fabric8.kubernetes.api.model.LocalObjectReference clusterDeploymentRef) {
        this.clusterDeploymentRef = clusterDeploymentRef;
    }

    @JsonProperty("clusterID")
    public java.lang.String getClusterID() {
        return clusterID;
    }

    @JsonProperty("clusterID")
    public void setClusterID(java.lang.String clusterID) {
        this.clusterID = clusterID;
    }

    @JsonProperty("infraID")
    public java.lang.String getInfraID() {
        return infraID;
    }

    @JsonProperty("infraID")
    public void setInfraID(java.lang.String infraID) {
        this.infraID = infraID;
    }

    @JsonProperty("installLog")
    public java.lang.String getInstallLog() {
        return installLog;
    }

    @JsonProperty("installLog")
    public void setInstallLog(java.lang.String installLog) {
        this.installLog = installLog;
    }

    @JsonProperty("metadata")
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("podSpec")
    public PodSpec getPodSpec() {
        return podSpec;
    }

    @JsonProperty("podSpec")
    public void setPodSpec(PodSpec podSpec) {
        this.podSpec = podSpec;
    }

    @JsonProperty("prevClusterID")
    public java.lang.String getPrevClusterID() {
        return prevClusterID;
    }

    @JsonProperty("prevClusterID")
    public void setPrevClusterID(java.lang.String prevClusterID) {
        this.prevClusterID = prevClusterID;
    }

    @JsonProperty("prevInfraID")
    public java.lang.String getPrevInfraID() {
        return prevInfraID;
    }

    @JsonProperty("prevInfraID")
    public void setPrevInfraID(java.lang.String prevInfraID) {
        this.prevInfraID = prevInfraID;
    }

    @JsonProperty("prevProvisionName")
    public java.lang.String getPrevProvisionName() {
        return prevProvisionName;
    }

    @JsonProperty("prevProvisionName")
    public void setPrevProvisionName(java.lang.String prevProvisionName) {
        this.prevProvisionName = prevProvisionName;
    }

    @JsonProperty("stage")
    public java.lang.String getStage() {
        return stage;
    }

    @JsonProperty("stage")
    public void setStage(java.lang.String stage) {
        this.stage = stage;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
