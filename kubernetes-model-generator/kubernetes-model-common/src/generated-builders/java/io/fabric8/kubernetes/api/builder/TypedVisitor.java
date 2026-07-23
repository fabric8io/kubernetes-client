package io.fabric8.kubernetes.api.builder;

import java.lang.Class;
public abstract class TypedVisitor<V> implements Visitor<V>{

  
  
  public Class<V> getType() {
    return (Class<V>) Visitors.getTypeArguments(TypedVisitor.class, getClass()).get(0);
  }
  
}