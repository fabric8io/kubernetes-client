
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
    "azure",
    "emptyDir",
    "gcs",
    "ibmcos",
    "managementState",
    "oss",
    "pvc",
    "s3",
    "swift"
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
public class ConfigStatusStorage implements Editable<ConfigStatusStorageBuilder> , KubernetesResource
{

    @JsonProperty("azure")
    private ConfigStatusSAzure azure;
    @JsonProperty("emptyDir")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object emptyDir;
    @JsonProperty("gcs")
    private ConfigStatusSGcs gcs;
    @JsonProperty("ibmcos")
    private ConfigStatusSIbmcos ibmcos;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("oss")
    private ConfigStatusSOss oss;
    @JsonProperty("pvc")
    private ConfigStatusSPvc pvc;
    @JsonProperty("s3")
    private ConfigStatusSS3 s3;
    @JsonProperty("swift")
    private ConfigStatusSSwift swift;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConfigStatusStorage() {
    }

    public ConfigStatusStorage(ConfigStatusSAzure azure, Object emptyDir, ConfigStatusSGcs gcs, ConfigStatusSIbmcos ibmcos, String managementState, ConfigStatusSOss oss, ConfigStatusSPvc pvc, ConfigStatusSS3 s3, ConfigStatusSSwift swift) {
        super();
        this.azure = azure;
        this.emptyDir = emptyDir;
        this.gcs = gcs;
        this.ibmcos = ibmcos;
        this.managementState = managementState;
        this.oss = oss;
        this.pvc = pvc;
        this.s3 = s3;
        this.swift = swift;
    }

    @JsonProperty("azure")
    public ConfigStatusSAzure getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(ConfigStatusSAzure azure) {
        this.azure = azure;
    }

    @JsonProperty("emptyDir")
    public Object getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setEmptyDir(Object emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("gcs")
    public ConfigStatusSGcs getGcs() {
        return gcs;
    }

    @JsonProperty("gcs")
    public void setGcs(ConfigStatusSGcs gcs) {
        this.gcs = gcs;
    }

    @JsonProperty("ibmcos")
    public ConfigStatusSIbmcos getIbmcos() {
        return ibmcos;
    }

    @JsonProperty("ibmcos")
    public void setIbmcos(ConfigStatusSIbmcos ibmcos) {
        this.ibmcos = ibmcos;
    }

    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("oss")
    public ConfigStatusSOss getOss() {
        return oss;
    }

    @JsonProperty("oss")
    public void setOss(ConfigStatusSOss oss) {
        this.oss = oss;
    }

    @JsonProperty("pvc")
    public ConfigStatusSPvc getPvc() {
        return pvc;
    }

    @JsonProperty("pvc")
    public void setPvc(ConfigStatusSPvc pvc) {
        this.pvc = pvc;
    }

    @JsonProperty("s3")
    public ConfigStatusSS3 getS3() {
        return s3;
    }

    @JsonProperty("s3")
    public void setS3(ConfigStatusSS3 s3) {
        this.s3 = s3;
    }

    @JsonProperty("swift")
    public ConfigStatusSSwift getSwift() {
        return swift;
    }

    @JsonProperty("swift")
    public void setSwift(ConfigStatusSSwift swift) {
        this.swift = swift;
    }

    @JsonIgnore
    public ConfigStatusStorageBuilder edit() {
        return new ConfigStatusStorageBuilder(this);
    }

    @JsonIgnore
    public ConfigStatusStorageBuilder toBuilder() {
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
