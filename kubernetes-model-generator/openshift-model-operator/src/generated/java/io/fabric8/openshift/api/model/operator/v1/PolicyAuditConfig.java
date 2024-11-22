
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destination",
    "maxFileSize",
    "maxLogFiles",
    "rateLimit",
    "syslogFacility"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PolicyAuditConfig implements Editable<PolicyAuditConfigBuilder> , KubernetesResource
{

    @JsonProperty("destination")
    private String destination;
    @JsonProperty("maxFileSize")
    private Long maxFileSize;
    @JsonProperty("maxLogFiles")
    private Integer maxLogFiles;
    @JsonProperty("rateLimit")
    private Long rateLimit;
    @JsonProperty("syslogFacility")
    private String syslogFacility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PolicyAuditConfig() {
    }

    public PolicyAuditConfig(String destination, Long maxFileSize, Integer maxLogFiles, Long rateLimit, String syslogFacility) {
        super();
        this.destination = destination;
        this.maxFileSize = maxFileSize;
        this.maxLogFiles = maxLogFiles;
        this.rateLimit = rateLimit;
        this.syslogFacility = syslogFacility;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("maxFileSize")
    public Long getMaxFileSize() {
        return maxFileSize;
    }

    @JsonProperty("maxFileSize")
    public void setMaxFileSize(Long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    @JsonProperty("maxLogFiles")
    public Integer getMaxLogFiles() {
        return maxLogFiles;
    }

    @JsonProperty("maxLogFiles")
    public void setMaxLogFiles(Integer maxLogFiles) {
        this.maxLogFiles = maxLogFiles;
    }

    @JsonProperty("rateLimit")
    public Long getRateLimit() {
        return rateLimit;
    }

    @JsonProperty("rateLimit")
    public void setRateLimit(Long rateLimit) {
        this.rateLimit = rateLimit;
    }

    @JsonProperty("syslogFacility")
    public String getSyslogFacility() {
        return syslogFacility;
    }

    @JsonProperty("syslogFacility")
    public void setSyslogFacility(String syslogFacility) {
        this.syslogFacility = syslogFacility;
    }

    @JsonIgnore
    public PolicyAuditConfigBuilder edit() {
        return new PolicyAuditConfigBuilder(this);
    }

    @JsonIgnore
    public PolicyAuditConfigBuilder toBuilder() {
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
