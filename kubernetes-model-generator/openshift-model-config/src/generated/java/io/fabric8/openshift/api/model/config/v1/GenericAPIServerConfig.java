
package io.fabric8.openshift.api.model.config.v1;

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
    "admission",
    "auditConfig",
    "corsAllowedOrigins",
    "kubeClientConfig",
    "servingInfo",
    "storageConfig"
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
public class GenericAPIServerConfig implements Editable<GenericAPIServerConfigBuilder> , KubernetesResource
{

    @JsonProperty("admission")
    private AdmissionConfig admission;
    @JsonProperty("auditConfig")
    private AuditConfig auditConfig;
    @JsonProperty("corsAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> corsAllowedOrigins = new ArrayList<>();
    @JsonProperty("kubeClientConfig")
    private KubeClientConfig kubeClientConfig;
    @JsonProperty("servingInfo")
    private HTTPServingInfo servingInfo;
    @JsonProperty("storageConfig")
    private EtcdStorageConfig storageConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenericAPIServerConfig() {
    }

    public GenericAPIServerConfig(AdmissionConfig admission, AuditConfig auditConfig, List<String> corsAllowedOrigins, KubeClientConfig kubeClientConfig, HTTPServingInfo servingInfo, EtcdStorageConfig storageConfig) {
        super();
        this.admission = admission;
        this.auditConfig = auditConfig;
        this.corsAllowedOrigins = corsAllowedOrigins;
        this.kubeClientConfig = kubeClientConfig;
        this.servingInfo = servingInfo;
        this.storageConfig = storageConfig;
    }

    @JsonProperty("admission")
    public AdmissionConfig getAdmission() {
        return admission;
    }

    @JsonProperty("admission")
    public void setAdmission(AdmissionConfig admission) {
        this.admission = admission;
    }

    @JsonProperty("auditConfig")
    public AuditConfig getAuditConfig() {
        return auditConfig;
    }

    @JsonProperty("auditConfig")
    public void setAuditConfig(AuditConfig auditConfig) {
        this.auditConfig = auditConfig;
    }

    @JsonProperty("corsAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCorsAllowedOrigins() {
        return corsAllowedOrigins;
    }

    @JsonProperty("corsAllowedOrigins")
    public void setCorsAllowedOrigins(List<String> corsAllowedOrigins) {
        this.corsAllowedOrigins = corsAllowedOrigins;
    }

    @JsonProperty("kubeClientConfig")
    public KubeClientConfig getKubeClientConfig() {
        return kubeClientConfig;
    }

    @JsonProperty("kubeClientConfig")
    public void setKubeClientConfig(KubeClientConfig kubeClientConfig) {
        this.kubeClientConfig = kubeClientConfig;
    }

    @JsonProperty("servingInfo")
    public HTTPServingInfo getServingInfo() {
        return servingInfo;
    }

    @JsonProperty("servingInfo")
    public void setServingInfo(HTTPServingInfo servingInfo) {
        this.servingInfo = servingInfo;
    }

    @JsonProperty("storageConfig")
    public EtcdStorageConfig getStorageConfig() {
        return storageConfig;
    }

    @JsonProperty("storageConfig")
    public void setStorageConfig(EtcdStorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    @JsonIgnore
    public GenericAPIServerConfigBuilder edit() {
        return new GenericAPIServerConfigBuilder(this);
    }

    @JsonIgnore
    public GenericAPIServerConfigBuilder toBuilder() {
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
