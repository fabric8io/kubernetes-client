
package io.fabric8.openshift.api.model.insights.v1alpha2;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * custom provides the custom configuration of gatherers
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configs"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Custom implements Editable<CustomBuilder>, KubernetesResource
{

    @JsonProperty("configs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GathererConfig> configs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Custom() {
    }

    public Custom(List<GathererConfig> configs) {
        super();
        this.configs = configs;
    }

    /**
     * configs is a required list of gatherers configurations that can be used to enable or disable specific gatherers. It may not exceed 100 items and each gatherer can be present only once. It is possible to disable an entire set of gatherers while allowing a specific function within that set. The particular gatherers IDs can be found at https://github.com/openshift/insights-operator/blob/master/docs/gathered-data.md. Run the following command to get the names of last active gatherers: "oc get insightsoperators.operator.openshift.io cluster -o json | jq '.status.gatherStatus.gatherers[].name'"
     */
    @JsonProperty("configs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GathererConfig> getConfigs() {
        return configs;
    }

    /**
     * configs is a required list of gatherers configurations that can be used to enable or disable specific gatherers. It may not exceed 100 items and each gatherer can be present only once. It is possible to disable an entire set of gatherers while allowing a specific function within that set. The particular gatherers IDs can be found at https://github.com/openshift/insights-operator/blob/master/docs/gathered-data.md. Run the following command to get the names of last active gatherers: "oc get insightsoperators.operator.openshift.io cluster -o json | jq '.status.gatherStatus.gatherers[].name'"
     */
    @JsonProperty("configs")
    public void setConfigs(List<GathererConfig> configs) {
        this.configs = configs;
    }

    @JsonIgnore
    public CustomBuilder edit() {
        return new CustomBuilder(this);
    }

    @JsonIgnore
    public CustomBuilder toBuilder() {
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
