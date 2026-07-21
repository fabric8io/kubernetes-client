package io.fabric8.kubernetes.api.builder;

import java.lang.FunctionalInterface;
@FunctionalInterface
public interface Builder<T>{

  
  T build();
  
}