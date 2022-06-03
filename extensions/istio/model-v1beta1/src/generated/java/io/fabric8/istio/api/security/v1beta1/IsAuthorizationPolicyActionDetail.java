
package io.fabric8.istio.api.security.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyProvider.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyProvider.class)
public interface IsAuthorizationPolicyActionDetail {


}
