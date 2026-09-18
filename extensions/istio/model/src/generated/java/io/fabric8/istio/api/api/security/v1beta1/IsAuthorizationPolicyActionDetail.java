
package io.fabric8.istio.api.api.security.v1beta1;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonTypeResolver;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(AuthorizationPolicyProvider.class),
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public interface IsAuthorizationPolicyActionDetail extends KubernetesResource
{



}
