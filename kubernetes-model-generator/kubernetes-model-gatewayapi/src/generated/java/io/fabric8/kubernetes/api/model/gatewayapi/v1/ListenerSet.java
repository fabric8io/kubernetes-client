
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("gateway.networking.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ListenerSet implements Editable<ListenerSetBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "gateway.networking.k8s.io/v1";
    @JsonProperty("kind")
    private String kind = "ListenerSet";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private ListenerSetSpec spec;
    @JsonProperty("status")
    private ListenerSetStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerSet() {
    }

    public ListenerSet(String apiVersion, String kind, ObjectMeta metadata, ListenerSetSpec spec, ListenerSetStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
     */
    @JsonProperty("spec")
    public ListenerSetSpec getSpec() {
        return spec;
    }

    /**
     * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
     */
    @JsonProperty("spec")
    public void setSpec(ListenerSetSpec spec) {
        this.spec = spec;
    }

    /**
     * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
     */
    @JsonProperty("status")
    public ListenerSetStatus getStatus() {
        return status;
    }

    /**
     * ListenerSet defines a set of additional listeners to attach to an existing Gateway. This resource provides a mechanism to merge multiple listeners into a single Gateway.<br><p> <br><p> The parent Gateway must explicitly allow ListenerSet attachment through its AllowedListeners configuration. By default, Gateways do not allow ListenerSet attachment.<br><p> <br><p> Routes can attach to a ListenerSet by specifying it as a parentRef, and can optionally target specific listeners using the sectionName field.<br><p> <br><p> Policy Attachment: - Policies that attach to a ListenerSet apply to all listeners defined in that resource - Policies do not impact listeners in the parent Gateway - Different ListenerSets attached to the same Gateway can have different policies - If an implementation cannot apply a policy to specific listeners, it should reject the policy<br><p> <br><p> ReferenceGrant Semantics: - ReferenceGrants applied to a Gateway are not inherited by child ListenerSets - ReferenceGrants applied to a ListenerSet do not grant permission to the parent Gateway's listeners - A ListenerSet can reference secrets/backends in its own namespace without a ReferenceGrant<br><p> <br><p> Gateway Integration:<br><p>   - The parent Gateway's status will include "AttachedListenerSets"<br><p>     which is the count of ListenerSets that have successfully attached to a Gateway<br><p>     A ListenerSet is successfully attached to a Gateway when all the following conditions are met:<br><p>   - The ListenerSet is selected by the Gateway's AllowedListeners field<br><p>   - The ListenerSet has a valid ParentRef selecting the Gateway<br><p>   - The ListenerSet's status has the condition "Accepted: true"
     */
    @JsonProperty("status")
    public void setStatus(ListenerSetStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public ListenerSetBuilder edit() {
        return new ListenerSetBuilder(this);
    }

    @JsonIgnore
    public ListenerSetBuilder toBuilder() {
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
