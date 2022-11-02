package com.phyllo.connect.api.client.connect;

import com.phyllo.connect.api.client.connect.endpoints.CreateSdkToken;
import com.phyllo.connect.api.client.connect.endpoints.CreateUser;
import com.phyllo.connect.api.client.connect.endpoints.DisconnectAccount;
import com.phyllo.connect.api.client.connect.endpoints.GetAccount;
import com.phyllo.connect.api.client.connect.endpoints.GetAllAccounts;
import com.phyllo.connect.api.client.connect.endpoints.GetAllUsers;
import com.phyllo.connect.api.client.connect.endpoints.GetAllWorkPlatforms;
import com.phyllo.connect.api.client.connect.endpoints.GetUser;
import com.phyllo.connect.api.client.connect.endpoints.GetUserByExernalId;
import com.phyllo.connect.api.client.connect.endpoints.GetWorkPlatform;
import com.phyllo.connect.api.client.connect.exceptions.CreateSdkTokenException;
import com.phyllo.connect.api.client.connect.exceptions.CreateUserException;
import com.phyllo.connect.api.client.connect.exceptions.DisconnectAccountException;
import com.phyllo.connect.api.client.connect.exceptions.GetAccountException;
import com.phyllo.connect.api.client.connect.exceptions.GetAllAccountsException;
import com.phyllo.connect.api.client.connect.exceptions.GetAllUsersException;
import com.phyllo.connect.api.client.connect.exceptions.GetAllWorkPlatformsException;
import com.phyllo.connect.api.client.connect.exceptions.GetUserByExernalIdException;
import com.phyllo.connect.api.client.connect.exceptions.GetUserException;
import com.phyllo.connect.api.client.connect.exceptions.GetWorkPlatformException;
import com.phyllo.connect.api.client.connect.types.Account;
import com.phyllo.connect.api.client.connect.types.AllAccountsResponse;
import com.phyllo.connect.api.client.connect.types.AllUsersResponse;
import com.phyllo.connect.api.client.connect.types.AllWorkPlatformsResponse;
import com.phyllo.connect.api.client.connect.types.DisconnectAccountResponse;
import com.phyllo.connect.api.client.connect.types.SDKTokenResponse;
import com.phyllo.connect.api.client.connect.types.User;
import com.phyllo.connect.api.client.connect.types.WorkPlatform;
import com.phyllo.connect.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class ConnectServiceClient {
  private final ConnectService service;

  private final Optional<BasicAuth> auth;

  public ConnectServiceClient(String url) {
    this.service = ConnectService.getClient(url);
    this.auth = Optional.empty();
  }

  public ConnectServiceClient(String url, BasicAuth auth) {
    this.service = ConnectService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public WorkPlatform getWorkPlatform(GetWorkPlatform.Request request) throws
      GetWorkPlatformException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getWorkPlatform")));
    return this.service.getWorkPlatform(authValue, request.getId());
  }

  public AllWorkPlatformsResponse getAllWorkPlatforms(GetAllWorkPlatforms.Request request) throws
      GetAllWorkPlatformsException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getAllWorkPlatforms")));
    return this.service.getAllWorkPlatforms(authValue, request.getLimit(), request.getName(), request.getOffset());
  }

  public User getUser(GetUser.Request request) throws GetUserException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getUser")));
    return this.service.getUser(authValue, request.getId());
  }

  public AllUsersResponse getAllUsers(GetAllUsers.Request request) throws GetAllUsersException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getAllUsers")));
    return this.service.getAllUsers(authValue, request.getLimit(), request.getOffset());
  }

  public User createUser(CreateUser.Request request) throws CreateUserException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for createUser")));
    return this.service.createUser(authValue, request.getBody());
  }

  public User getUserByExernalId(GetUserByExernalId.Request request) throws
      GetUserByExernalIdException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getUserByExernalId")));
    return this.service.getUserByExernalId(authValue, request.getExternalId());
  }

  public SDKTokenResponse createSDKToken(CreateSdkToken.Request request) throws
      CreateSdkTokenException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for createSDKToken")));
    return this.service.createSdkToken(authValue, request.getBody());
  }

  public Account getAccount(GetAccount.Request request) throws GetAccountException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getAccount")));
    return this.service.getAccount(authValue, request.getId());
  }

  public AllAccountsResponse getAllAccounts(GetAllAccounts.Request request) throws
      GetAllAccountsException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getAllAccounts")));
    return this.service.getAllAccounts(authValue, request.getLimit(), request.getOffset(), request.getUserId(), request.getWorkPlatformId());
  }

  public DisconnectAccountResponse disconnectAccount(DisconnectAccount.Request request) throws
      DisconnectAccountException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for disconnectAccount")));
    return this.service.disconnectAccount(authValue, request.getId());
  }
}
