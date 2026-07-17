package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserOAuthAccessTokenListBuilder extends UserOAuthAccessTokenListFluent<UserOAuthAccessTokenListBuilder> implements VisitableBuilder<UserOAuthAccessTokenList,UserOAuthAccessTokenListBuilder>{

  UserOAuthAccessTokenListFluent<?> fluent;

  public UserOAuthAccessTokenListBuilder() {
    this(new UserOAuthAccessTokenList());
  }
  
  public UserOAuthAccessTokenListBuilder(UserOAuthAccessTokenListFluent<?> fluent) {
    this(fluent, new UserOAuthAccessTokenList());
  }
  
  public UserOAuthAccessTokenListBuilder(UserOAuthAccessTokenList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserOAuthAccessTokenListBuilder(UserOAuthAccessTokenListFluent<?> fluent,UserOAuthAccessTokenList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserOAuthAccessTokenList build() {
    UserOAuthAccessTokenList buildable = new UserOAuthAccessTokenList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}