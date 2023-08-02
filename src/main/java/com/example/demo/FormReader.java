package com.example.demo;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.forms.v1.Forms;
import com.google.api.services.forms.v1.FormsScopes;
import com.google.api.services.forms.v1.model.FormResponse;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Objects;

public class FormReader {

    private static final String APPLICATION_NAME = "woodsgpt";
    private static final String FORM_ID = "1g42E9hLywCOi6PlkKrCqj69_yGqNAamkGvldC_E9f7E";

    public List<FormResponse> readForm() throws IOException, GeneralSecurityException {

        JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        var driveService = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null).setApplicationName(APPLICATION_NAME).build();
        var formService = new Forms.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null).setApplicationName(APPLICATION_NAME).build();
        GoogleCredentials credentials = GoogleCredentials.fromStream(Objects.requireNonNull(
                DemoApplication.class.getResourceAsStream("credentials.json"))).createScoped(FormsScopes.all());
        var responses = formService.forms().responses().list(FORM_ID).setAccessToken(getToken()).execute().getResponses();


        for (var r : responses) {
            var answers = r.getAnswers().entrySet();
            for (var a : answers) {
                System.out.println(a);
            }
        }
        return responses;
    }

    private String getToken() throws IOException {
        GoogleCredentials credential = GoogleCredentials.fromStream(Objects.requireNonNull(
                DemoApplication.class.getResourceAsStream("cred.json"))).createScoped(FormsScopes.all());
        return credential.getAccessToken() != null ?
                credential.getAccessToken().getTokenValue() :
                credential.refreshAccessToken().getTokenValue();
    }
}
