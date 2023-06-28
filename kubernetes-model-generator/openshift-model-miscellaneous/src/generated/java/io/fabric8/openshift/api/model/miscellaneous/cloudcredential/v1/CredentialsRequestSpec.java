
package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    "providerSpec",
    "secretRef",
    "serviceAccountNames"
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
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CredentialsRequestSpec implements KubernetesResource
{

    @JsonProperty("providerSpec")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> providerSpec = new LinkedHashMap<String, Object>();
    @JsonProperty("secretRef")
    private io.fabric8.kubernetes.api.model.ObjectReference secretRef;
    @JsonProperty("serviceAccountNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> serviceAccountNames = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CredentialsRequestSpec() {
    }

    public CredentialsRequestSpec(Map<String, Object> providerSpec, io.fabric8.kubernetes.api.model.ObjectReference secretRef, List<java.lang.String> serviceAccountNames) {
        super();
        this.providerSpec = providerSpec;
        this.secretRef = secretRef;
        this.serviceAccountNames = serviceAccountNames;
    }

    @JsonProperty("providerSpec")
    public Map<String, Object> getProviderSpec() {
        return providerSpec;
    }

    @JsonProperty("providerSpec")
    public void setProviderSpec(Map<String, Object> providerSpec) {
        this.providerSpec = providerSpec;
    }

    @JsonProperty("secretRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(io.fabric8.kubernetes.api.model.ObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    @JsonProperty("serviceAccountNames")
    public List<java.lang.String> getServiceAccountNames() {
        return serviceAccountNames;
    }

    @JsonProperty("serviceAccountNames")
    public void setServiceAccountNames(List<java.lang.String> serviceAccountNames) {
        this.serviceAccountNames = serviceAccountNames;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
