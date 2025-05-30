
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
 * AuditCustomRule describes a custom rule for an audit profile that takes precedence over the top-level profile.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "profile"
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
public class AuditCustomRule implements Editable<AuditCustomRuleBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("profile")
    private String profile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuditCustomRule() {
    }

    public AuditCustomRule(String group, String profile) {
        super();
        this.group = group;
        this.profile = profile;
    }

    /**
     * group is a name of group a request user must be member of in order to this profile to apply.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group is a name of group a request user must be member of in order to this profile to apply.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * profile specifies the name of the desired audit policy configuration to be deployed to all OpenShift-provided API servers in the cluster.<br><p> <br><p> The following profiles are provided: - Default: the existing default policy. - WriteRequestBodies: like 'Default', but logs request and response HTTP payloads for write requests (create, update, patch). - AllRequestBodies: like 'WriteRequestBodies', but also logs request and response HTTP payloads for read requests (get, list). - None: no requests are logged at all, not even oauthaccesstokens and oauthauthorizetokens.<br><p> <br><p> If unset, the 'Default' profile is used as the default.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * profile specifies the name of the desired audit policy configuration to be deployed to all OpenShift-provided API servers in the cluster.<br><p> <br><p> The following profiles are provided: - Default: the existing default policy. - WriteRequestBodies: like 'Default', but logs request and response HTTP payloads for write requests (create, update, patch). - AllRequestBodies: like 'WriteRequestBodies', but also logs request and response HTTP payloads for read requests (get, list). - None: no requests are logged at all, not even oauthaccesstokens and oauthauthorizetokens.<br><p> <br><p> If unset, the 'Default' profile is used as the default.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonIgnore
    public AuditCustomRuleBuilder edit() {
        return new AuditCustomRuleBuilder(this);
    }

    @JsonIgnore
    public AuditCustomRuleBuilder toBuilder() {
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
