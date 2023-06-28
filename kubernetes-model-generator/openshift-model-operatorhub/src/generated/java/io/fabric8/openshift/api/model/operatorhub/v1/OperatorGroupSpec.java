
package io.fabric8.openshift.api.model.operatorhub.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "selector",
    "serviceAccountName",
    "staticProvidedAPIs",
    "targetNamespaces"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class OperatorGroupSpec implements KubernetesResource
{

    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("staticProvidedAPIs")
    private Boolean staticProvidedAPIs;
    @JsonProperty("targetNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetNamespaces = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OperatorGroupSpec() {
    }

    public OperatorGroupSpec(io.fabric8.kubernetes.api.model.LabelSelector selector, String serviceAccountName, Boolean staticProvidedAPIs, List<String> targetNamespaces) {
        super();
        this.selector = selector;
        this.serviceAccountName = serviceAccountName;
        this.staticProvidedAPIs = staticProvidedAPIs;
        this.targetNamespaces = targetNamespaces;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("staticProvidedAPIs")
    public Boolean getStaticProvidedAPIs() {
        return staticProvidedAPIs;
    }

    @JsonProperty("staticProvidedAPIs")
    public void setStaticProvidedAPIs(Boolean staticProvidedAPIs) {
        this.staticProvidedAPIs = staticProvidedAPIs;
    }

    @JsonProperty("targetNamespaces")
    public List<String> getTargetNamespaces() {
        return targetNamespaces;
    }

    @JsonProperty("targetNamespaces")
    public void setTargetNamespaces(List<String> targetNamespaces) {
        this.targetNamespaces = targetNamespaces;
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
