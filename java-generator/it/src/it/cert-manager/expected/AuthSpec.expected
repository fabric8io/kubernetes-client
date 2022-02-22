package io.cert_manager.v1;

@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({"appRole","kubernetes","tokenSecretRef"})
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@lombok.ToString()
@lombok.EqualsAndHashCode()
@lombok.Setter()
@lombok.experimental.Accessors(prefix = {
    "_",
    ""
})
@io.sundr.builder.annotations.Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.Container.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ContainerPort.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.Volume.class),
    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.VolumeMount.class)
})
public class AuthSpec implements io.fabric8.kubernetes.api.model.KubernetesResource {

    /**
     * AppRole authenticates with Vault using the App Role auth mechanism, with the role and secret stored in a Kubernetes Secret resource.
     */
    @com.fasterxml.jackson.annotation.JsonProperty("appRole")
    private AppRoleSpec appRole;

    public AppRoleSpec getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRoleSpec appRole) {
        this.appRole = appRole;
    }

    /**
     * Kubernetes authenticates with Vault by passing the ServiceAccount token stored in the named Secret resource to the Vault server.
     */
    @com.fasterxml.jackson.annotation.JsonProperty("kubernetes")
    private KubernetesSpec kubernetes;

    public KubernetesSpec getKubernetes() {
        return kubernetes;
    }

    public void setKubernetes(KubernetesSpec kubernetes) {
        this.kubernetes = kubernetes;
    }

    /**
     * TokenSecretRef authenticates with Vault by presenting a token.
     */
    @com.fasterxml.jackson.annotation.JsonProperty("tokenSecretRef")
    private TokenSecretRefSpec tokenSecretRef;

    public TokenSecretRefSpec getTokenSecretRef() {
        return tokenSecretRef;
    }

    public void setTokenSecretRef(TokenSecretRefSpec tokenSecretRef) {
        this.tokenSecretRef = tokenSecretRef;
    }
}
