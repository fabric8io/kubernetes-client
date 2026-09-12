
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiGroups",
    "apiVersions",
    "resources",
    "scope"
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
public class Rule implements Editable<RuleBuilder>, KubernetesResource
{

    @JsonProperty("apiGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiGroups = new ArrayList<>();
    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVersions = new ArrayList<>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resources = new ArrayList<>();
    @JsonProperty("scope")
    private String scope;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Rule() {
    }

    public Rule(List<String> apiGroups, List<String> apiVersions, List<String> resources, String scope) {
        super();
        this.apiGroups = apiGroups;
        this.apiVersions = apiVersions;
        this.resources = resources;
        this.scope = scope;
    }

    @JsonProperty("apiGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiGroups() {
        return apiGroups;
    }

    @JsonProperty("apiGroups")
    public void setApiGroups(List<String> apiGroups) {
        this.apiGroups = apiGroups;
    }

    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVersions() {
        return apiVersions;
    }

    @JsonProperty("apiVersions")
    public void setApiVersions(List<String> apiVersions) {
        this.apiVersions = apiVersions;
    }

    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonIgnore
    public RuleBuilder edit() {
        return new RuleBuilder(this);
    }

    @JsonIgnore
    public RuleBuilder toBuilder() {
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
        if (!(o instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiGroups = this.getApiGroups();
        Object other$apiGroups = other.getApiGroups();
        if (this$apiGroups == null ? other$apiGroups != null : !this$apiGroups.equals(other$apiGroups)) {
            return false;
        }
        Object this$apiVersions = this.getApiVersions();
        Object other$apiVersions = other.getApiVersions();
        if (this$apiVersions == null ? other$apiVersions != null : !this$apiVersions.equals(other$apiVersions)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$scope = this.getScope();
        Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) {
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
        return other instanceof Rule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiGroups = this.getApiGroups();
        result = result * prime + ($apiGroups == null ? 43 : $apiGroups.hashCode());
        Object $apiVersions = this.getApiVersions();
        result = result * prime + ($apiVersions == null ? 43 : $apiVersions.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $scope = this.getScope();
        result = result * prime + ($scope == null ? 43 : $scope.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Rule(" + "apiGroups=" + this.getApiGroups() + ", apiVersions=" + this.getApiVersions() + ", resources=" + this.getResources() + ", scope=" + this.getScope() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
