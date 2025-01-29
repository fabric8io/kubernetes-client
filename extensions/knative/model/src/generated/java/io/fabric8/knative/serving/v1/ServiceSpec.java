
package io.fabric8.knative.serving.v1;

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
 * ServiceSpec represents the configuration for the Service object. A Service's specification is the union of the specifications for a Route and Configuration.  The Service restricts what can be expressed in these fields, e.g. the Route must reference the provided Configuration; however, these limitations also enable friendlier defaulting, e.g. Route never needs a Configuration name, and may be defaulted to the appropriate "run latest" spec.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "template",
    "traffic"
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
public class ServiceSpec implements Editable<ServiceSpecBuilder>, KubernetesResource
{

    @JsonProperty("template")
    private RevisionTemplateSpec template;
    @JsonProperty("traffic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TrafficTarget> traffic = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceSpec() {
    }

    public ServiceSpec(RevisionTemplateSpec template, List<TrafficTarget> traffic) {
        super();
        this.template = template;
        this.traffic = traffic;
    }

    /**
     * ServiceSpec represents the configuration for the Service object. A Service's specification is the union of the specifications for a Route and Configuration.  The Service restricts what can be expressed in these fields, e.g. the Route must reference the provided Configuration; however, these limitations also enable friendlier defaulting, e.g. Route never needs a Configuration name, and may be defaulted to the appropriate "run latest" spec.
     */
    @JsonProperty("template")
    public RevisionTemplateSpec getTemplate() {
        return template;
    }

    /**
     * ServiceSpec represents the configuration for the Service object. A Service's specification is the union of the specifications for a Route and Configuration.  The Service restricts what can be expressed in these fields, e.g. the Route must reference the provided Configuration; however, these limitations also enable friendlier defaulting, e.g. Route never needs a Configuration name, and may be defaulted to the appropriate "run latest" spec.
     */
    @JsonProperty("template")
    public void setTemplate(RevisionTemplateSpec template) {
        this.template = template;
    }

    /**
     * Traffic specifies how to distribute traffic over a collection of revisions and configurations.
     */
    @JsonProperty("traffic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TrafficTarget> getTraffic() {
        return traffic;
    }

    /**
     * Traffic specifies how to distribute traffic over a collection of revisions and configurations.
     */
    @JsonProperty("traffic")
    public void setTraffic(List<TrafficTarget> traffic) {
        this.traffic = traffic;
    }

    @JsonIgnore
    public ServiceSpecBuilder edit() {
        return new ServiceSpecBuilder(this);
    }

    @JsonIgnore
    public ServiceSpecBuilder toBuilder() {
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
