
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chapAuthDiscovery",
    "chapAuthSession",
    "fsType",
    "initiatorName",
    "iqn",
    "iscsiInterface",
    "lun",
    "portals",
    "readOnly",
    "secretRef",
    "targetPortal"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterServiceVersionSpecISpecDSpecTSpecVIscsi implements Editable<ClusterServiceVersionSpecISpecDSpecTSpecVIscsiBuilder> , KubernetesResource
{

    @JsonProperty("chapAuthDiscovery")
    private Boolean chapAuthDiscovery;
    @JsonProperty("chapAuthSession")
    private Boolean chapAuthSession;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("initiatorName")
    private String initiatorName;
    @JsonProperty("iqn")
    private String iqn;
    @JsonProperty("iscsiInterface")
    private String iscsiInterface;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("portals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> portals = new ArrayList<>();
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private ClusterServiceVersionSpecISpecDSpecTSpecVISecretRef secretRef;
    @JsonProperty("targetPortal")
    private String targetPortal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceVersionSpecISpecDSpecTSpecVIscsi() {
    }

    public ClusterServiceVersionSpecISpecDSpecTSpecVIscsi(Boolean chapAuthDiscovery, Boolean chapAuthSession, String fsType, String initiatorName, String iqn, String iscsiInterface, Integer lun, List<String> portals, Boolean readOnly, ClusterServiceVersionSpecISpecDSpecTSpecVISecretRef secretRef, String targetPortal) {
        super();
        this.chapAuthDiscovery = chapAuthDiscovery;
        this.chapAuthSession = chapAuthSession;
        this.fsType = fsType;
        this.initiatorName = initiatorName;
        this.iqn = iqn;
        this.iscsiInterface = iscsiInterface;
        this.lun = lun;
        this.portals = portals;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
        this.targetPortal = targetPortal;
    }

    @JsonProperty("chapAuthDiscovery")
    public Boolean getChapAuthDiscovery() {
        return chapAuthDiscovery;
    }

    @JsonProperty("chapAuthDiscovery")
    public void setChapAuthDiscovery(Boolean chapAuthDiscovery) {
        this.chapAuthDiscovery = chapAuthDiscovery;
    }

    @JsonProperty("chapAuthSession")
    public Boolean getChapAuthSession() {
        return chapAuthSession;
    }

    @JsonProperty("chapAuthSession")
    public void setChapAuthSession(Boolean chapAuthSession) {
        this.chapAuthSession = chapAuthSession;
    }

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("initiatorName")
    public String getInitiatorName() {
        return initiatorName;
    }

    @JsonProperty("initiatorName")
    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    @JsonProperty("iqn")
    public String getIqn() {
        return iqn;
    }

    @JsonProperty("iqn")
    public void setIqn(String iqn) {
        this.iqn = iqn;
    }

    @JsonProperty("iscsiInterface")
    public String getIscsiInterface() {
        return iscsiInterface;
    }

    @JsonProperty("iscsiInterface")
    public void setIscsiInterface(String iscsiInterface) {
        this.iscsiInterface = iscsiInterface;
    }

    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    @JsonProperty("portals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPortals() {
        return portals;
    }

    @JsonProperty("portals")
    public void setPortals(List<String> portals) {
        this.portals = portals;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("secretRef")
    public ClusterServiceVersionSpecISpecDSpecTSpecVISecretRef getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(ClusterServiceVersionSpecISpecDSpecTSpecVISecretRef secretRef) {
        this.secretRef = secretRef;
    }

    @JsonProperty("targetPortal")
    public String getTargetPortal() {
        return targetPortal;
    }

    @JsonProperty("targetPortal")
    public void setTargetPortal(String targetPortal) {
        this.targetPortal = targetPortal;
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVIscsiBuilder edit() {
        return new ClusterServiceVersionSpecISpecDSpecTSpecVIscsiBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVIscsiBuilder toBuilder() {
        return edit();
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
