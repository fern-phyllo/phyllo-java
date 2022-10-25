package com.phyllo.connect.api.client.connect;

import com.fern.java.jackson.ClientObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.phyllo.connect.api.client.BasicAuth;
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
import com.phyllo.connect.api.client.connect.types.AccountId;
import com.phyllo.connect.api.client.connect.types.AllAccountsResponse;
import com.phyllo.connect.api.client.connect.types.AllUsersResponse;
import com.phyllo.connect.api.client.connect.types.AllWorkPlatformsResponse;
import com.phyllo.connect.api.client.connect.types.CreateUserRequest;
import com.phyllo.connect.api.client.connect.types.DisconnectAccountResponse;
import com.phyllo.connect.api.client.connect.types.ExternalId;
import com.phyllo.connect.api.client.connect.types.SDKTokenRequest;
import com.phyllo.connect.api.client.connect.types.SDKTokenResponse;
import com.phyllo.connect.api.client.connect.types.User;
import com.phyllo.connect.api.client.connect.types.UserId;
import com.phyllo.connect.api.client.connect.types.WorkPlatform;
import com.phyllo.connect.api.client.connect.types.WorkPlatformId;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1")
interface ConnectService {
  @GET
  @Path("/work-platforms/{id}")
  WorkPlatform getWorkPlatform(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("id") WorkPlatformId id) throws GetWorkPlatformException;

  @GET
  @Path("/work-platforms")
  AllWorkPlatformsResponse getAllWorkPlatforms(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("name") Optional<String> name,
      @QueryParam("offset") Optional<Integer> offset) throws GetAllWorkPlatformsException;

  @GET
  @Path("/users/{id}")
  User getUser(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") UserId id) throws
      GetUserException;

  @GET
  @Path("/users")
  AllUsersResponse getAllUsers(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("offset") Optional<Integer> offset)
      throws GetAllUsersException;

  @POST
  @Path("/users")
  User createUser(@HeaderParam("Authorization") BasicAuth auth, CreateUserRequest body) throws
      CreateUserException;

  @GET
  @Path("/users/external_id/{external_id}")
  User getUserByExernalId(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("external_id") ExternalId externalId) throws GetUserByExernalIdException;

  @POST
  @Path("/sdk-tokens")
  SDKTokenResponse createSDKToken(@HeaderParam("Authorization") BasicAuth auth,
      SDKTokenRequest body) throws CreateSdkTokenException;

  @GET
  @Path("/accounts/{id}")
  Account getAccount(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") AccountId id)
      throws GetAccountException;

  @GET
  @Path("/accounts")
  AllAccountsResponse getAllAccounts(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("offset") Optional<Integer> offset,
      @QueryParam("user_id") Optional<UserId> userId,
      @QueryParam("work_platform_id") Optional<WorkPlatformId> workPlatformId) throws
      GetAllAccountsException;

  @POST
  @Path("/accounts/{id}/disconnect")
  DisconnectAccountResponse disconnectAccount(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("id") AccountId id) throws DisconnectAccountException;

  static ConnectService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ClientObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ClientObjectMappers.JSON_MAPPER))
        .errorDecoder(new ConnectServiceErrorDecoder()).target(ConnectService.class, url);
  }
}
