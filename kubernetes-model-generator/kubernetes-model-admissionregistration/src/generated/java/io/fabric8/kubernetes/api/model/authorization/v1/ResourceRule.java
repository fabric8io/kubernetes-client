
package io.fabric8.kubernetes.api.model.authorization.v1;

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

/**
 * ResourceRule is the list of actions the subject is allowed to perform on resources. The list ordering isn't significant, may contain duplicates, and possibly be incomplete.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiGroups",
    "resourceNames",
    "resources",
    "verbs"
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
public class ResourceRule implements Editable<ResourceRuleBuilder>, KubernetesResource
{

    @JsonProperty("apiGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiGroups = new ArrayList<>();
    @JsonProperty("resourceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resourceNames = new ArrayList<>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resources = new ArrayList<>();
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verbs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceRule() {
    }

    public ResourceRule(List<String> apiGroups, List<String> resourceNames, List<String> resources, List<String> verbs) {
        super();
        this.apiGroups = apiGroups;
        this.resourceNames = resourceNames;
        this.resources = resources;
        this.verbs = verbs;
    }

    /**
     * apiGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any action requested against one of the enumerated resources in any API group will be allowed.  "&#42;" means all.
     */
    @JsonProperty("apiGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiGroups() {
        return apiGroups;
    }

    /**
     * apiGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any action requested against one of the enumerated resources in any API group will be allowed.  "&#42;" means all.
     */
    @JsonProperty("apiGroups")
    public void setApiGroups(List<String> apiGroups) {
        this.apiGroups = apiGroups;
    }

    /**
     * resourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.  "&#42;" means all.
     */
    @JsonProperty("resourceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResourceNames() {
        return resourceNames;
    }

    /**
     * resourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.  "&#42;" means all.
     */
    @JsonProperty("resourceNames")
    public void setResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
    }

    /**
     * resources is a list of resources this rule applies to.  "&#42;" means all in the specified apiGroups.<br><p>  "&#42;/foo" represents the subresource 'foo' for all resources in the specified apiGroups.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResources() {
        return resources;
    }

    /**
     * resources is a list of resources this rule applies to.  "&#42;" means all in the specified apiGroups.<br><p>  "&#42;/foo" represents the subresource 'foo' for all resources in the specified apiGroups.
     */
    @JsonProperty("resources")
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    /**
     * verbs is a list of kubernetes resource API verbs, like: get, list, watch, create, update, delete, proxy.  "&#42;" means all.
     */
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerbs() {
        return verbs;
    }

    /**
     * verbs is a list of kubernetes resource API verbs, like: get, list, watch, create, update, delete, proxy.  "&#42;" means all.
     */
    @JsonProperty("verbs")
    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    @JsonIgnore
    public ResourceRuleBuilder edit() {
        return new ResourceRuleBuilder(this);
    }

    @JsonIgnore
    public ResourceRuleBuilder toBuilder() {
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
        if (!(o instanceof ResourceRule)) {
            return false;
        }
        ResourceRule other = (ResourceRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiGroups = this.getApiGroups();
        Object other$apiGroups = other.getApiGroups();
        if (this$apiGroups == null ? other$apiGroups != null : !this$apiGroups.equals(other$apiGroups)) {
            return false;
        }
        Object this$resourceNames = this.getResourceNames();
        Object other$resourceNames = other.getResourceNames();
        if (this$resourceNames == null ? other$resourceNames != null : !this$resourceNames.equals(other$resourceNames)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$verbs = this.getVerbs();
        Object other$verbs = other.getVerbs();
        if (this$verbs == null ? other$verbs != null : !this$verbs.equals(other$verbs)) {
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
        return other instanceof ResourceRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiGroups = this.getApiGroups();
        result = result * prime + ($apiGroups == null ? 43 : $apiGroups.hashCode());
        Object $resourceNames = this.getResourceNames();
        result = result * prime + ($resourceNames == null ? 43 : $resourceNames.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $verbs = this.getVerbs();
        result = result * prime + ($verbs == null ? 43 : $verbs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceRule(" + "apiGroups=" + this.getApiGroups() + ", resourceNames=" + this.getResourceNames() + ", resources=" + this.getResources() + ", verbs=" + this.getVerbs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
