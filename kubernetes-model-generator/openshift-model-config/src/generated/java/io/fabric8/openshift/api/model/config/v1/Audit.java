
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customRules",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Audit implements Editable<AuditBuilder>, KubernetesResource
{

    @JsonProperty("customRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AuditCustomRule> customRules = new ArrayList<>();
    @JsonProperty("profile")
    private String profile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Audit() {
    }

    public Audit(List<AuditCustomRule> customRules, String profile) {
        super();
        this.customRules = customRules;
        this.profile = profile;
    }

    /**
     * customRules specify profiles per group. These profile take precedence over the top-level profile field if they apply. They are evaluation from top to bottom and the first one that matches, applies.
     */
    @JsonProperty("customRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AuditCustomRule> getCustomRules() {
        return customRules;
    }

    /**
     * customRules specify profiles per group. These profile take precedence over the top-level profile field if they apply. They are evaluation from top to bottom and the first one that matches, applies.
     */
    @JsonProperty("customRules")
    public void setCustomRules(List<AuditCustomRule> customRules) {
        this.customRules = customRules;
    }

    /**
     * profile specifies the name of the desired top-level audit profile to be applied to all requests sent to any of the OpenShift-provided API servers in the cluster (kube-apiserver, openshift-apiserver and oauth-apiserver), with the exception of those requests that match one or more of the customRules.<br><p> <br><p> The following profiles are provided: - Default: default policy which means MetaData level logging with the exception of events<br><p>   (not logged at all), oauthaccesstokens and oauthauthorizetokens (both logged at RequestBody<br><p>   level).<br><p> - WriteRequestBodies: like 'Default', but logs request and response HTTP payloads for write requests (create, update, patch). - AllRequestBodies: like 'WriteRequestBodies', but also logs request and response HTTP payloads for read requests (get, list). - None: no requests are logged at all, not even oauthaccesstokens and oauthauthorizetokens.<br><p> <br><p> Warning: It is not recommended to disable audit logging by using the `None` profile unless you are fully aware of the risks of not logging data that can be beneficial when troubleshooting issues. If you disable audit logging and a support situation arises, you might need to enable audit logging and reproduce the issue in order to troubleshoot properly.<br><p> <br><p> If unset, the 'Default' profile is used as the default.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * profile specifies the name of the desired top-level audit profile to be applied to all requests sent to any of the OpenShift-provided API servers in the cluster (kube-apiserver, openshift-apiserver and oauth-apiserver), with the exception of those requests that match one or more of the customRules.<br><p> <br><p> The following profiles are provided: - Default: default policy which means MetaData level logging with the exception of events<br><p>   (not logged at all), oauthaccesstokens and oauthauthorizetokens (both logged at RequestBody<br><p>   level).<br><p> - WriteRequestBodies: like 'Default', but logs request and response HTTP payloads for write requests (create, update, patch). - AllRequestBodies: like 'WriteRequestBodies', but also logs request and response HTTP payloads for read requests (get, list). - None: no requests are logged at all, not even oauthaccesstokens and oauthauthorizetokens.<br><p> <br><p> Warning: It is not recommended to disable audit logging by using the `None` profile unless you are fully aware of the risks of not logging data that can be beneficial when troubleshooting issues. If you disable audit logging and a support situation arises, you might need to enable audit logging and reproduce the issue in order to troubleshoot properly.<br><p> <br><p> If unset, the 'Default' profile is used as the default.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonIgnore
    public AuditBuilder edit() {
        return new AuditBuilder(this);
    }

    @JsonIgnore
    public AuditBuilder toBuilder() {
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
