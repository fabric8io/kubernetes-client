
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prefix",
    "signedPrefix"
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
public class PolicyMatchRemapIdentity implements Editable<PolicyMatchRemapIdentityBuilder>, KubernetesResource
{

    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("signedPrefix")
    private String signedPrefix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyMatchRemapIdentity() {
    }

    public PolicyMatchRemapIdentity(String prefix, String signedPrefix) {
        super();
        this.prefix = prefix;
        this.signedPrefix = signedPrefix;
    }

    /**
     * prefix is required if matchPolicy is set to "RemapIdentity". prefix is the prefix of the image identity to be matched. If the image identity matches the specified prefix, that prefix is replaced by the specified "signedPrefix" (otherwise it is used as unchanged and no remapping takes place). This is useful when verifying signatures for a mirror of some other repository namespace that preserves the vendor’s repository structure. The prefix and signedPrefix values can be either host[:port] values (matching exactly the same host[:port], string), repository namespaces, or repositories (i.e. they must not contain tags/digests), and match as prefixes of the fully expanded form. For example, docker.io/library/busybox (not busybox) to specify that single repository, or docker.io/library (not an empty string) to specify the parent namespace of docker.io/library/busybox.
     */
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    /**
     * prefix is required if matchPolicy is set to "RemapIdentity". prefix is the prefix of the image identity to be matched. If the image identity matches the specified prefix, that prefix is replaced by the specified "signedPrefix" (otherwise it is used as unchanged and no remapping takes place). This is useful when verifying signatures for a mirror of some other repository namespace that preserves the vendor’s repository structure. The prefix and signedPrefix values can be either host[:port] values (matching exactly the same host[:port], string), repository namespaces, or repositories (i.e. they must not contain tags/digests), and match as prefixes of the fully expanded form. For example, docker.io/library/busybox (not busybox) to specify that single repository, or docker.io/library (not an empty string) to specify the parent namespace of docker.io/library/busybox.
     */
    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * signedPrefix is required if matchPolicy is set to "RemapIdentity". signedPrefix is the prefix of the image identity to be matched in the signature. The format is the same as "prefix". The values can be either host[:port] values (matching exactly the same host[:port], string), repository namespaces, or repositories (i.e. they must not contain tags/digests), and match as prefixes of the fully expanded form. For example, docker.io/library/busybox (not busybox) to specify that single repository, or docker.io/library (not an empty string) to specify the parent namespace of docker.io/library/busybox.
     */
    @JsonProperty("signedPrefix")
    public String getSignedPrefix() {
        return signedPrefix;
    }

    /**
     * signedPrefix is required if matchPolicy is set to "RemapIdentity". signedPrefix is the prefix of the image identity to be matched in the signature. The format is the same as "prefix". The values can be either host[:port] values (matching exactly the same host[:port], string), repository namespaces, or repositories (i.e. they must not contain tags/digests), and match as prefixes of the fully expanded form. For example, docker.io/library/busybox (not busybox) to specify that single repository, or docker.io/library (not an empty string) to specify the parent namespace of docker.io/library/busybox.
     */
    @JsonProperty("signedPrefix")
    public void setSignedPrefix(String signedPrefix) {
        this.signedPrefix = signedPrefix;
    }

    @JsonIgnore
    public PolicyMatchRemapIdentityBuilder edit() {
        return new PolicyMatchRemapIdentityBuilder(this);
    }

    @JsonIgnore
    public PolicyMatchRemapIdentityBuilder toBuilder() {
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
