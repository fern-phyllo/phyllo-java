package sample;

import java.lang.String;

import com.phyllo.connect.api.client.BasicAuth;
import com.phyllo.connect.api.client.PhylloConnectApiClient;
import com.phyllo.connect.api.client.connect.endpoints.CreateUser;
import com.phyllo.connect.api.client.connect.exceptions.CreateUserException;
import com.phyllo.connect.api.client.connect.types.CreateUserRequest;
import com.phyllo.connect.api.client.connect.types.User;

public final class App {
  public static void main(String[] args) {
    String client_id = System.getenv("PHYLLO_CLIENT_ID");
    String secret = System.getenv("PHYLLO_SECRET");
    BasicAuth auth = BasicAuth.of(client_id, secret);

    PhylloConnectApiClient phylloConnectApiClient =
            new PhylloConnectApiClient("api.getphyllo.com", auth);

    try {
      User user = phylloConnectApiClient.connect().createUser(CreateUser.Request.builder()
              .body(CreateUserRequest.builder()
                      .name("John Doe")
                      .externalId("179a0bb4-c572-4477-9457-7dacf1b84848")
                      .build())
              .build());
      System.out.println("Created a user! The user ID is " + user.getId());
    } catch (CreateUserException e) {
      System.out.println("Failed to create a user" + e.getMessage());
    }

  }
}
