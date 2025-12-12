
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
 * CLusterImagePolicySpec is the specification of the ClusterImagePolicy custom resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "policy",
    "scopes"
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
public class ClusterImagePolicySpec implements Editable<ClusterImagePolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("policy")
    private Policy policy;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterImagePolicySpec() {
    }

    public ClusterImagePolicySpec(Policy policy, List<String> scopes) {
        super();
        this.policy = policy;
        this.scopes = scopes;
    }

    /**
     * CLusterImagePolicySpec is the specification of the ClusterImagePolicy custom resource.
     */
    @JsonProperty("policy")
    public Policy getPolicy() {
        return policy;
    }

    /**
     * CLusterImagePolicySpec is the specification of the ClusterImagePolicy custom resource.
     */
    @JsonProperty("policy")
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    /**
     * scopes is a required field that defines the list of image identities assigned to a policy. Each item refers to a scope in a registry implementing the "Docker Registry HTTP API V2". Scopes matching individual images are named Docker references in the fully expanded form, either using a tag or digest. For example, docker.io/library/busybox:latest (not busybox:latest). More general scopes are prefixes of individual-image scopes, and specify a repository (by omitting the tag or digest), a repository namespace, or a registry host (by only specifying the host name and possibly a port number) or a wildcard expression starting with `&#42;.`, for matching all subdomains (not including a port number). Wildcards are only supported for subdomain matching, and may not be used in the middle of the host, i.e.  &#42;.example.com is a valid case, but example&#42;.&#42;.com is not. This support no more than 256 scopes in one object. If multiple scopes match a given image, only the policy requirements for the most specific scope apply. The policy requirements for more general scopes are ignored. In addition to setting a policy appropriate for your own deployed applications, make sure that a policy on the OpenShift image repositories quay.io/openshift-release-dev/ocp-release, quay.io/openshift-release-dev/ocp-v4.0-art-dev (or on a more general scope) allows deployment of the OpenShift images required for cluster operation. If a scope is configured in both the ClusterImagePolicy and the ImagePolicy, or if the scope in ImagePolicy is nested under one of the scopes from the ClusterImagePolicy, only the policy from the ClusterImagePolicy will be applied. For additional details about the format, please refer to the document explaining the docker transport field, which can be found at: https://github.com/containers/image/blob/main/docs/containers-policy.json.5.md#docker
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * scopes is a required field that defines the list of image identities assigned to a policy. Each item refers to a scope in a registry implementing the "Docker Registry HTTP API V2". Scopes matching individual images are named Docker references in the fully expanded form, either using a tag or digest. For example, docker.io/library/busybox:latest (not busybox:latest). More general scopes are prefixes of individual-image scopes, and specify a repository (by omitting the tag or digest), a repository namespace, or a registry host (by only specifying the host name and possibly a port number) or a wildcard expression starting with `&#42;.`, for matching all subdomains (not including a port number). Wildcards are only supported for subdomain matching, and may not be used in the middle of the host, i.e.  &#42;.example.com is a valid case, but example&#42;.&#42;.com is not. This support no more than 256 scopes in one object. If multiple scopes match a given image, only the policy requirements for the most specific scope apply. The policy requirements for more general scopes are ignored. In addition to setting a policy appropriate for your own deployed applications, make sure that a policy on the OpenShift image repositories quay.io/openshift-release-dev/ocp-release, quay.io/openshift-release-dev/ocp-v4.0-art-dev (or on a more general scope) allows deployment of the OpenShift images required for cluster operation. If a scope is configured in both the ClusterImagePolicy and the ImagePolicy, or if the scope in ImagePolicy is nested under one of the scopes from the ClusterImagePolicy, only the policy from the ClusterImagePolicy will be applied. For additional details about the format, please refer to the document explaining the docker transport field, which can be found at: https://github.com/containers/image/blob/main/docs/containers-policy.json.5.md#docker
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @JsonIgnore
    public ClusterImagePolicySpecBuilder edit() {
        return new ClusterImagePolicySpecBuilder(this);
    }

    @JsonIgnore
    public ClusterImagePolicySpecBuilder toBuilder() {
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
