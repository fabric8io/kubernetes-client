
package io.fabric8.openshift.api.model.insights.v1alpha2;

import java.util.LinkedHashMap;
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

/**
 * gathererConfig allows to configure specific gatherers
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "state"
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
public class GathererConfig implements Editable<GathererConfigBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GathererConfig() {
    }

    public GathererConfig(String name, String state) {
        super();
        this.name = name;
        this.state = state;
    }

    /**
     * name is the required name of a specific gatherer It may not exceed 256 characters. The format for a gatherer name is: {gatherer}/{function} where the function is optional. Gatherer consists of a lowercase letters only that may include underscores (_). Function consists of a lowercase letters only that may include underscores (_) and is separated from the gatherer by a forward slash (/). The particular gatherers can be found at https://github.com/openshift/insights-operator/blob/master/docs/gathered-data.md. Run the following command to get the names of last active gatherers: "oc get insightsoperators.operator.openshift.io cluster -o json | jq '.status.gatherStatus.gatherers[].name'"
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the required name of a specific gatherer It may not exceed 256 characters. The format for a gatherer name is: {gatherer}/{function} where the function is optional. Gatherer consists of a lowercase letters only that may include underscores (_). Function consists of a lowercase letters only that may include underscores (_) and is separated from the gatherer by a forward slash (/). The particular gatherers can be found at https://github.com/openshift/insights-operator/blob/master/docs/gathered-data.md. Run the following command to get the names of last active gatherers: "oc get insightsoperators.operator.openshift.io cluster -o json | jq '.status.gatherStatus.gatherers[].name'"
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * state is a required field that allows you to configure specific gatherer. Valid values are "Enabled" and "Disabled". When set to Enabled the gatherer will run. When set to Disabled the gatherer will not run.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state is a required field that allows you to configure specific gatherer. Valid values are "Enabled" and "Disabled". When set to Enabled the gatherer will run. When set to Disabled the gatherer will not run.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public GathererConfigBuilder edit() {
        return new GathererConfigBuilder(this);
    }

    @JsonIgnore
    public GathererConfigBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GathererConfig)) {
            return false;
        }
        GathererConfig other = (GathererConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof GathererConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GathererConfig(" + "name=" + this.getName() + ", state=" + this.getState() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
