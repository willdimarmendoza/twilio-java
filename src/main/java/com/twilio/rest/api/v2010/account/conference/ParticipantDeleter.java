/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.conference;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ParticipantDeleter extends Deleter<Participant> {
    private String pathAccountSid;
    private final String pathConferenceSid;
    private final String pathCallSid;

    /**
     * Construct a new ParticipantDeleter.
     * 
     * @param pathConferenceSid The string that uniquely identifies this conference
     * @param pathCallSid The call_sid
     */
    public ParticipantDeleter(final String pathConferenceSid, 
                              final String pathCallSid) {
        this.pathConferenceSid = pathConferenceSid;
        this.pathCallSid = pathCallSid;
    }

    /**
     * Construct a new ParticipantDeleter.
     * 
     * @param pathAccountSid The account_sid
     * @param pathConferenceSid The string that uniquely identifies this conference
     * @param pathCallSid The call_sid
     */
    public ParticipantDeleter(final String pathAccountSid, 
                              final String pathConferenceSid, 
                              final String pathCallSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathConferenceSid = pathConferenceSid;
        this.pathCallSid = pathCallSid;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     * 
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Conferences/" + this.pathConferenceSid + "/Participants/" + this.pathCallSid + ".json",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Participant delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return response.getStatusCode() == 204;
    }
}