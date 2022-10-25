package com.phyllo.connect.api.client;

import com.phyllo.connect.api.client.connect.ConnectServiceClient;
import java.lang.String;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class PhylloConnectApiClient {
  private final Supplier<ConnectServiceClient> connectServiceClient;

  public PhylloConnectApiClient(String url) {
    this.connectServiceClient = memoize(() -> new ConnectServiceClient(url));
  }

  public PhylloConnectApiClient(String url, BasicAuth auth) {
    this.connectServiceClient = memoize(() -> new ConnectServiceClient(url, auth));
  }

  public final ConnectServiceClient connect() {
    return this.connectServiceClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
