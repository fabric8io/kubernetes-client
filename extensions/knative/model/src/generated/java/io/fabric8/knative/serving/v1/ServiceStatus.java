
package io.fabric8.knative.serving.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.pkg.apis.Condition;
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
 * ServiceStatus represents the Status stanza of the Service resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "annotations",
    "conditions",
    "latestCreatedRevisionName",
    "latestReadyRevisionName",
    "observedGeneration",
    "traffic",
    "url"
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
public class ServiceStatus implements Editable<ServiceStatusBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private Addressable address;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("latestCreatedRevisionName")
    private String latestCreatedRevisionName;
    @JsonProperty("latestReadyRevisionName")
    private String latestReadyRevisionName;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("traffic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TrafficTarget> traffic = new ArrayList<>();
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceStatus() {
    }

    public ServiceStatus(Addressable address, Map<String, String> annotations, List<Condition> conditions, String latestCreatedRevisionName, String latestReadyRevisionName, Long observedGeneration, List<TrafficTarget> traffic, String url) {
        super();
        this.address = address;
        this.annotations = annotations;
        this.conditions = conditions;
        this.latestCreatedRevisionName = latestCreatedRevisionName;
        this.latestReadyRevisionName = latestReadyRevisionName;
        this.observedGeneration = observedGeneration;
        this.traffic = traffic;
        this.url = url;
    }

    /**
     * ServiceStatus represents the Status stanza of the Service resource.
     */
    @JsonProperty("address")
    public Addressable getAddress() {
        return address;
    }

    /**
     * ServiceStatus represents the Status stanza of the Service resource.
     */
    @JsonProperty("address")
    public void setAddress(Addressable address) {
        this.address = address;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * LatestCreatedRevisionName is the last revision that was created from this Configuration. It might not be ready yet, for that use LatestReadyRevisionName.
     */
    @JsonProperty("latestCreatedRevisionName")
    public String getLatestCreatedRevisionName() {
        return latestCreatedRevisionName;
    }

    /**
     * LatestCreatedRevisionName is the last revision that was created from this Configuration. It might not be ready yet, for that use LatestReadyRevisionName.
     */
    @JsonProperty("latestCreatedRevisionName")
    public void setLatestCreatedRevisionName(String latestCreatedRevisionName) {
        this.latestCreatedRevisionName = latestCreatedRevisionName;
    }

    /**
     * LatestReadyRevisionName holds the name of the latest Revision stamped out from this Configuration that has had its "Ready" condition become "True".
     */
    @JsonProperty("latestReadyRevisionName")
    public String getLatestReadyRevisionName() {
        return latestReadyRevisionName;
    }

    /**
     * LatestReadyRevisionName holds the name of the latest Revision stamped out from this Configuration that has had its "Ready" condition become "True".
     */
    @JsonProperty("latestReadyRevisionName")
    public void setLatestReadyRevisionName(String latestReadyRevisionName) {
        this.latestReadyRevisionName = latestReadyRevisionName;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Traffic holds the configured traffic distribution. These entries will always contain RevisionName references. When ConfigurationName appears in the spec, this will hold the LatestReadyRevisionName that we last observed.
     */
    @JsonProperty("traffic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TrafficTarget> getTraffic() {
        return traffic;
    }

    /**
     * Traffic holds the configured traffic distribution. These entries will always contain RevisionName references. When ConfigurationName appears in the spec, this will hold the LatestReadyRevisionName that we last observed.
     */
    @JsonProperty("traffic")
    public void setTraffic(List<TrafficTarget> traffic) {
        this.traffic = traffic;
    }

    /**
     * ServiceStatus represents the Status stanza of the Service resource.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * ServiceStatus represents the Status stanza of the Service resource.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public ServiceStatusBuilder edit() {
        return new ServiceStatusBuilder(this);
    }

    @JsonIgnore
    public ServiceStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
