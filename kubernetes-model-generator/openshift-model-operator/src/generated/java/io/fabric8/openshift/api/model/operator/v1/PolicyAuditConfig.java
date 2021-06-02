
package io.fabric8.openshift.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "destination",
    "maxFileSize",
    "rateLimit",
    "syslogFacility"
})
@ToString
@EqualsAndHashCode
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
public class PolicyAuditConfig implements KubernetesResource
{

    @JsonProperty("destination")
    private String destination;
    @JsonProperty("maxFileSize")
    private Integer maxFileSize;
    @JsonProperty("rateLimit")
    private Integer rateLimit;
    @JsonProperty("syslogFacility")
    private String syslogFacility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PolicyAuditConfig() {
    }

    /**
     * 
     * @param rateLimit
     * @param destination
     * @param maxFileSize
     * @param syslogFacility
     */
    public PolicyAuditConfig(String destination, Integer maxFileSize, Integer rateLimit, String syslogFacility) {
        super();
        this.destination = destination;
        this.maxFileSize = maxFileSize;
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
    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    @JsonProperty("maxFileSize")
    public void setMaxFileSize(Integer maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    @JsonProperty("rateLimit")
    public Integer getRateLimit() {
        return rateLimit;
    }

    @JsonProperty("rateLimit")
    public void setRateLimit(Integer rateLimit) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
