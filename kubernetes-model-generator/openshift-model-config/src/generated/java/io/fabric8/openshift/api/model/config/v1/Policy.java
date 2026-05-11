
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Policy defines the verification policy for the items in the scopes list.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rootOfTrust",
    "signedIdentity"
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
public class Policy implements Editable<PolicyBuilder>, KubernetesResource
{

    @JsonProperty("rootOfTrust")
    private PolicyRootOfTrust rootOfTrust;
    @JsonProperty("signedIdentity")
    private PolicyIdentity signedIdentity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Policy() {
    }

    public Policy(PolicyRootOfTrust rootOfTrust, PolicyIdentity signedIdentity) {
        super();
        this.rootOfTrust = rootOfTrust;
        this.signedIdentity = signedIdentity;
    }

    /**
     * Policy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("rootOfTrust")
    public PolicyRootOfTrust getRootOfTrust() {
        return rootOfTrust;
    }

    /**
     * Policy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("rootOfTrust")
    public void setRootOfTrust(PolicyRootOfTrust rootOfTrust) {
        this.rootOfTrust = rootOfTrust;
    }

    /**
     * Policy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("signedIdentity")
    public PolicyIdentity getSignedIdentity() {
        return signedIdentity;
    }

    /**
     * Policy defines the verification policy for the items in the scopes list.
     */
    @JsonProperty("signedIdentity")
    public void setSignedIdentity(PolicyIdentity signedIdentity) {
        this.signedIdentity = signedIdentity;
    }

    @JsonIgnore
    public PolicyBuilder edit() {
        return new PolicyBuilder(this);
    }

    @JsonIgnore
    public PolicyBuilder toBuilder() {
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
