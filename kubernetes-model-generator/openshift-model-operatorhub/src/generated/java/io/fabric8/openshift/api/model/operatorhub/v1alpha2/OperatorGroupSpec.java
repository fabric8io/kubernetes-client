
package io.fabric8.openshift.api.model.operatorhub.v1alpha2;

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
 * OperatorGroupSpec is the spec for an OperatorGroup resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "selector",
    "serviceAccountName",
    "staticProvidedAPIs",
    "targetNamespaces"
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
public class OperatorGroupSpec implements Editable<OperatorGroupSpecBuilder>, KubernetesResource
{

    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("staticProvidedAPIs")
    private Boolean staticProvidedAPIs;
    @JsonProperty("targetNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetNamespaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorGroupSpec() {
    }

    public OperatorGroupSpec(LabelSelector selector, String serviceAccountName, Boolean staticProvidedAPIs, List<String> targetNamespaces) {
        super();
        this.selector = selector;
        this.serviceAccountName = serviceAccountName;
        this.staticProvidedAPIs = staticProvidedAPIs;
        this.targetNamespaces = targetNamespaces;
    }

    /**
     * OperatorGroupSpec is the spec for an OperatorGroup resource.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * OperatorGroupSpec is the spec for an OperatorGroup resource.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * ServiceAccountName is the admin specified service account which will be used to deploy operator(s) in this operator group.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName is the admin specified service account which will be used to deploy operator(s) in this operator group.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * Static tells OLM not to update the OperatorGroup's providedAPIs annotation
     */
    @JsonProperty("staticProvidedAPIs")
    public Boolean getStaticProvidedAPIs() {
        return staticProvidedAPIs;
    }

    /**
     * Static tells OLM not to update the OperatorGroup's providedAPIs annotation
     */
    @JsonProperty("staticProvidedAPIs")
    public void setStaticProvidedAPIs(Boolean staticProvidedAPIs) {
        this.staticProvidedAPIs = staticProvidedAPIs;
    }

    /**
     * TargetNamespaces is an explicit set of namespaces to target. If it is set, Selector is ignored.
     */
    @JsonProperty("targetNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetNamespaces() {
        return targetNamespaces;
    }

    /**
     * TargetNamespaces is an explicit set of namespaces to target. If it is set, Selector is ignored.
     */
    @JsonProperty("targetNamespaces")
    public void setTargetNamespaces(List<String> targetNamespaces) {
        this.targetNamespaces = targetNamespaces;
    }

    @JsonIgnore
    public OperatorGroupSpecBuilder edit() {
        return new OperatorGroupSpecBuilder(this);
    }

    @JsonIgnore
    public OperatorGroupSpecBuilder toBuilder() {
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
        if (!(o instanceof OperatorGroupSpec)) {
            return false;
        }
        OperatorGroupSpec other = (OperatorGroupSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$staticProvidedAPIs = this.getStaticProvidedAPIs();
        Object other$staticProvidedAPIs = other.getStaticProvidedAPIs();
        if (this$staticProvidedAPIs == null ? other$staticProvidedAPIs != null : !this$staticProvidedAPIs.equals(other$staticProvidedAPIs)) {
            return false;
        }
        Object this$targetNamespaces = this.getTargetNamespaces();
        Object other$targetNamespaces = other.getTargetNamespaces();
        if (this$targetNamespaces == null ? other$targetNamespaces != null : !this$targetNamespaces.equals(other$targetNamespaces)) {
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
        return other instanceof OperatorGroupSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $staticProvidedAPIs = this.getStaticProvidedAPIs();
        result = result * prime + ($staticProvidedAPIs == null ? 43 : $staticProvidedAPIs.hashCode());
        Object $targetNamespaces = this.getTargetNamespaces();
        result = result * prime + ($targetNamespaces == null ? 43 : $targetNamespaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OperatorGroupSpec(" + "selector=" + this.getSelector() + ", serviceAccountName=" + this.getServiceAccountName() + ", staticProvidedAPIs=" + this.getStaticProvidedAPIs() + ", targetNamespaces=" + this.getTargetNamespaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
