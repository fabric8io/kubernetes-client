
package io.fabric8.openshift.api.model.config.v1;

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

/**
 * MaxAgePolicy contains a numeric range for specifying a compliant HSTS max-age for the enclosing RequiredHSTSPolicy
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "largestMaxAge",
    "smallestMaxAge"
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
public class MaxAgePolicy implements Editable<MaxAgePolicyBuilder>, KubernetesResource
{

    @JsonProperty("largestMaxAge")
    private Integer largestMaxAge;
    @JsonProperty("smallestMaxAge")
    private Integer smallestMaxAge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MaxAgePolicy() {
    }

    public MaxAgePolicy(Integer largestMaxAge, Integer smallestMaxAge) {
        super();
        this.largestMaxAge = largestMaxAge;
        this.smallestMaxAge = smallestMaxAge;
    }

    /**
     * The largest allowed value (in seconds) of the RequiredHSTSPolicy max-age This value can be left unspecified, in which case no upper limit is enforced.
     */
    @JsonProperty("largestMaxAge")
    public Integer getLargestMaxAge() {
        return largestMaxAge;
    }

    /**
     * The largest allowed value (in seconds) of the RequiredHSTSPolicy max-age This value can be left unspecified, in which case no upper limit is enforced.
     */
    @JsonProperty("largestMaxAge")
    public void setLargestMaxAge(Integer largestMaxAge) {
        this.largestMaxAge = largestMaxAge;
    }

    /**
     * The smallest allowed value (in seconds) of the RequiredHSTSPolicy max-age Setting max-age=0 allows the deletion of an existing HSTS header from a host.  This is a necessary tool for administrators to quickly correct mistakes. This value can be left unspecified, in which case no lower limit is enforced.
     */
    @JsonProperty("smallestMaxAge")
    public Integer getSmallestMaxAge() {
        return smallestMaxAge;
    }

    /**
     * The smallest allowed value (in seconds) of the RequiredHSTSPolicy max-age Setting max-age=0 allows the deletion of an existing HSTS header from a host.  This is a necessary tool for administrators to quickly correct mistakes. This value can be left unspecified, in which case no lower limit is enforced.
     */
    @JsonProperty("smallestMaxAge")
    public void setSmallestMaxAge(Integer smallestMaxAge) {
        this.smallestMaxAge = smallestMaxAge;
    }

    @JsonIgnore
    public MaxAgePolicyBuilder edit() {
        return new MaxAgePolicyBuilder(this);
    }

    @JsonIgnore
    public MaxAgePolicyBuilder toBuilder() {
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
