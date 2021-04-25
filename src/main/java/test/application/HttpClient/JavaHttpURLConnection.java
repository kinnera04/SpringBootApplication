package test.application.HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import test.application.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class JavaHttpURLConnection {

    public static void main(String[] args) throws IOException {

    	// Create a neat value object to hold the URL
        URL url = new URL("http://localhost:8181/useradministrator/api/users");

        // Open a connection(?) on the URL(?) and cast the response(??)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "*/*");


        // This line makes the request
        InputStream responseStream = connection.getInputStream();

        // Manually converting the response body InputStream to APOD using Jackson
        ObjectMapper mapper = new ObjectMapper();
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);

        List<User> apod = mapper.readValue(responseStream, collectionType);

        // Finally we have the response
        System.out.println(apod.get(0).getEmail());



    }

}
