
package io.fabric8.openshift.api.model;

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
 * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "grouprestriction",
    "serviceaccountrestriction",
    "userrestriction"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RoleBindingRestrictionSpec implements Editable<RoleBindingRestrictionSpecBuilder>, KubernetesResource
{

    @JsonProperty("grouprestriction")
    private GroupRestriction grouprestriction;
    @JsonProperty("serviceaccountrestriction")
    private ServiceAccountRestriction serviceaccountrestriction;
    @JsonProperty("userrestriction")
    private UserRestriction userrestriction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RoleBindingRestrictionSpec() {
    }

    public RoleBindingRestrictionSpec(GroupRestriction grouprestriction, ServiceAccountRestriction serviceaccountrestriction, UserRestriction userrestriction) {
        super();
        this.grouprestriction = grouprestriction;
        this.serviceaccountrestriction = serviceaccountrestriction;
        this.userrestriction = userrestriction;
    }

    /**
     * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
     */
    @JsonProperty("grouprestriction")
    public GroupRestriction getGrouprestriction() {
        return grouprestriction;
    }

    /**
     * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
     */
    @JsonProperty("grouprestriction")
    public void setGrouprestriction(GroupRestriction grouprestriction) {
        this.grouprestriction = grouprestriction;
    }

    /**
     * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
     */
    @JsonProperty("serviceaccountrestriction")
    public ServiceAccountRestriction getServiceaccountrestriction() {
        return serviceaccountrestriction;
    }

    /**
     * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
     */
    @JsonProperty("serviceaccountrestriction")
    public void setServiceaccountrestriction(ServiceAccountRestriction serviceaccountrestriction) {
        this.serviceaccountrestriction = serviceaccountrestriction;
    }

    /**
     * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
     */
    @JsonProperty("userrestriction")
    public UserRestriction getUserrestriction() {
        return userrestriction;
    }

    /**
     * RoleBindingRestrictionSpec defines a rolebinding restriction.  Exactly one field must be non-nil.
     */
    @JsonProperty("userrestriction")
    public void setUserrestriction(UserRestriction userrestriction) {
        this.userrestriction = userrestriction;
    }

    @JsonIgnore
    public RoleBindingRestrictionSpecBuilder edit() {
        return new RoleBindingRestrictionSpecBuilder(this);
    }

    @JsonIgnore
    public RoleBindingRestrictionSpecBuilder toBuilder() {
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
